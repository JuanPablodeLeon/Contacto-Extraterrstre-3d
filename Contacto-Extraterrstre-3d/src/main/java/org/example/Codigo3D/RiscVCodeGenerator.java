package org.example.Codigo3D;

import org.example.Codigo3D.NewGenerate.C3DProgram;
import org.example.Codigo3D.NewGenerate.OpCode;
import org.example.Codigo3D.NewGenerate.Quadruple;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Genera ensamblador RISC-V (RV32 + extension D para doubles) a partir del C3D.
 *
 * El modelo de memoria imita al backend C: todos los valores del lenguaje son
 * doubles de 64 bits. El stack y el heap del lenguaje son dos arreglos en
 * .data; P y H son indices (doubles) dentro de esos arreglos. Cada rutina usa
 * un marco nativo propio con s0 como frame pointer, tal como se explica en
 * Elementos/RiscV.md.
 *
 * Convencion de llamada:
 *   - Los parametros y el valor de retorno viajan por el stack del lenguaje
 *     (stack[P], stack[P+1], ...), exactamente igual que en el C3D.
 *   - jal/ret se usan para las llamadas entre rutinas.
 *   - Los temporales tN se guardan en el marco nativo de la rutina; los
 *     temporales compartidos (literales) se guardan en .data.
 *
 * Nota: los valores de 64 bits se cargan/almacenan con fld/fsd, mientras que
 * los registros enteros (direcciones, indices y ra/s0) usan lw/sw de RV32.
 */
public class RiscVCodeGenerator {

    private static final int STACK_CELLS = 250_000;
    private static final int HEAP_CELLS = 250_000;
    private static final int CELL_BYTES = 8;

    private final Map<String, String> numericPool = new LinkedHashMap<>();
    private final Set<String> fallbackGlobals = new LinkedHashSet<>();
    private final Set<String> globalTemps = new LinkedHashSet<>();
    private final Set<String> definedRoutines = new LinkedHashSet<>();
    private final Set<String> calledTargets = new LinkedHashSet<>();

    private int numericCounter;
    private int uniqueCounter;

    private StringBuilder text;
    private Map<String, Integer> currentSlots = Map.of();

    public String generateRiscV(C3DProgram program) {
        if (program == null || program.getQuadruples().isEmpty()) {
            return minimalProgram();
        }

        List<Quadruple> all = program.getQuadruples();
        List<Quadruple> mainBody = new ArrayList<>();
        List<Routine> routines = new ArrayList<>();
        splitProgram(all, mainBody, routines);

        collectGlobalTemps(mainBody, routines);
        collectCalledTargets(all);

        text = new StringBuilder();

        // Punto de entrada: prepara las bases del stack/heap simulados y llama
        // al bloque principal del C3D.
        text.append("# Punto de entrada\n");
        text.append("main:\n");
        text.append("    la s10, stack\n");
        text.append("    la s11, heap\n");
        text.append("    fcvt.d.w f0, zero\n");
        text.append("    jal ra, main_entry\n");
        text.append("    li a7, 10\n");
        text.append("    ecall\n\n");

        Routine mainRoutine = new Routine("main_entry", mainBody);
        assignSlots(mainRoutine);
        definedRoutines.add(mainRoutine.name);
        emitRoutine(mainRoutine);

        for (Routine r : routines) {
            assignSlots(r);
            definedRoutines.add(r.name);
            emitRoutine(r);
        }

        // Stubs defensivos: si el C3D llama a una rutina que no quedo definida,
        // el ensamblador no debe fallar por una etiqueta inexistente.
        for (String target : calledTargets) {
            if (definedRoutines.contains(target)) continue;
            if (target.startsWith("_rt_")) continue;
            text.append("# rutina no definida en el C3D\n");
            text.append(target).append(":\n");
            text.append("    ret\n\n");
        }

        text.append(runtimeLibrary());

        return buildFinalAssembly();
    }

    private String minimalProgram() {
        return "# ============================================================\n"
                + "# RISC-V generado por Contacto Extraterrestre 3D\n"
                + "# No hay cuartetas para traducir.\n"
                + "# ============================================================\n\n"
                + ".data\n"
                + ".align 3\n"
                + "P: .double 0.0\n"
                + "H: .double 0.0\n\n"
                + ".text\n"
                + ".globl main\n"
                + "main:\n"
                + "    li a7, 10\n"
                + "    ecall\n";
    }

    private void splitProgram(List<Quadruple> all, List<Quadruple> mainBody,
                              List<Routine> routines) {
        Routine current = null;
        for (Quadruple q : all) {
            if (q.getOp() == OpCode.LABEL && isRoutineLabel(q.getResult())) {
                String name = sanitize(q.getResult());
                if (current != null && current.name.equals(name)) {
                    continue;
                }
                current = new Routine(name, new ArrayList<>());
                routines.add(current);
                continue;
            }
            if (current == null) {
                mainBody.add(q);
            } else {
                current.body.add(q);
            }
        }
    }

    private boolean isRoutineLabel(String label) {
        if (label == null || label.isEmpty()) return false;
        String s = sanitize(label);
        return !s.matches("L\\d+") && !"main_entry".equals(s);
    }

    private void collectGlobalTemps(List<Quadruple> mainBody, List<Routine> routines) {
        Map<String, Set<String>> owners = new LinkedHashMap<>();
        collectTempOwners(owners, mainBody, "main");
        for (Routine r : routines) {
            collectTempOwners(owners, r.body, "r:" + r.name);
        }
        for (Map.Entry<String, Set<String>> e : owners.entrySet()) {
            if (e.getValue().size() > 1) {
                globalTemps.add(e.getKey());
            }
        }
    }

    private void collectTempOwners(Map<String, Set<String>> owners,
                                   List<Quadruple> body, String owner) {
        for (Quadruple q : body) {
            addTemps(owners, q.getArg1(), owner);
            addTemps(owners, q.getArg2(), owner);
            addTemps(owners, q.getResult(), owner);
        }
    }

    private void addTemps(Map<String, Set<String>> owners, String operand, String owner) {
        if (operand == null) return;
        String s = operand.trim();
        if (isTemp(s)) {
            owners.computeIfAbsent(s, k -> new LinkedHashSet<>()).add(owner);
            return;
        }
        if (s.contains("+")) {
            for (String part : s.split("\\+")) {
                String p = part.trim();
                if (isTemp(p)) {
                    owners.computeIfAbsent(p, k -> new LinkedHashSet<>()).add(owner);
                }
            }
        }
    }

    private void collectCalledTargets(List<Quadruple> all) {
        for (Quadruple q : all) {
            if (q.getOp() == OpCode.CALL) {
                String target = sanitize(q.getArg1());
                if (!target.isEmpty()) calledTargets.add(target);
            }
        }
    }

    private void assignSlots(Routine r) {
        Set<String> temps = new LinkedHashSet<>();
        for (Quadruple q : r.body) {
            addTempsToSet(temps, q.getArg1());
            addTempsToSet(temps, q.getArg2());
            addTempsToSet(temps, q.getResult());
        }
        int index = 0;
        for (String t : temps) {
            if (globalTemps.contains(t)) continue;
            r.slots.put(t, -(16 + CELL_BYTES * index));
            index++;
        }
        r.frameSize = align16(16 + CELL_BYTES * index);
    }

    private void addTempsToSet(Set<String> temps, String operand) {
        if (operand == null) return;
        String s = operand.trim();
        if (isTemp(s)) {
            temps.add(s);
            return;
        }
        if (s.contains("+")) {
            for (String part : s.split("\\+")) {
                String p = part.trim();
                if (isTemp(p)) temps.add(p);
            }
        }
    }

    private void emitRoutine(Routine r) {
        text.append("# ------------------------------------------------------------\n");
        text.append("# Rutina ").append(r.name).append("\n");
        text.append("# ------------------------------------------------------------\n");
        text.append(r.name).append(":\n");
        emitPrologue(r.frameSize);

        currentSlots = r.slots;
        text.append("    fcvt.d.w fa0, zero\n");
        for (Integer off : r.slots.values()) {
            emitStoreLocal(off, "fa0");
        }
        for (Quadruple q : r.body) {
            emitQuad(q, r.name);
        }

        text.append("_ret_").append(r.name).append(":\n");
        emitEpilogue(r.frameSize);
        text.append("\n");
    }

    private void emitPrologue(int frameSize) {
        text.append("    li t0, ").append(frameSize).append("\n");
        text.append("    sub sp, sp, t0\n");
        text.append("    li t0, ").append(frameSize - 8).append("\n");
        text.append("    add t0, sp, t0\n");
        text.append("    sw s0, 0(t0)\n");
        text.append("    li t1, ").append(frameSize - 16).append("\n");
        text.append("    add t1, sp, t1\n");
        text.append("    sw ra, 0(t1)\n");
        text.append("    mv s0, t0\n");
    }

    private void emitEpilogue(int frameSize) {
        text.append("    lw ra, -8(s0)\n");
        text.append("    lw s0, 0(s0)\n");
        text.append("    li t0, ").append(frameSize).append("\n");
        text.append("    add sp, sp, t0\n");
        text.append("    ret\n");
    }

    private void emitLoadLocal(int offset, String freg) {
        if (offset >= -2048 && offset <= 2047) {
            text.append("    fld ").append(freg).append(", ").append(offset).append("(s0)\n");
        } else {
            text.append("    li t0, ").append(offset).append("\n");
            text.append("    add t0, s0, t0\n");
            text.append("    fld ").append(freg).append(", 0(t0)\n");
        }
    }

    private void emitStoreLocal(int offset, String freg) {
        if (offset >= -2048 && offset <= 2047) {
            text.append("    fsd ").append(freg).append(", ").append(offset).append("(s0)\n");
        } else {
            text.append("    li t0, ").append(offset).append("\n");
            text.append("    add t0, s0, t0\n");
            text.append("    fsd ").append(freg).append(", 0(t0)\n");
        }
    }

    private int align16(int n) {
        return (n + 15) & ~15;
    }

    private static class Routine {
        final String name;
        final List<Quadruple> body;
        final Map<String, Integer> slots = new LinkedHashMap<>();
        int frameSize = 16;

        Routine(String name, List<Quadruple> body) {
            this.name = name;
            this.body = body;
        }
    }

    // ================================================================
    // Traduccion de cuadruplas
    // ================================================================

    private void emitQuad(Quadruple q, String routineName) {
        OpCode op = q.getOp();
        String arg1 = q.getArg1();
        String arg2 = q.getArg2();
        String res = q.getResult();
        String comment = q.getComment() == null ? "" : q.getComment();

        switch (op) {
            case LABEL: {
                String lbl = sanitize(res);
                if (!lbl.isEmpty() && !"main_entry".equals(lbl)) {
                    text.append(lbl).append(":\n");
                }
                break;
            }
            case GOTO:
                text.append("    j ").append(sanitize(res)).append("\n");
                break;
            case IF_TRUE:
            case IF_FALSE:
                emitIf(op, arg1, sanitize(res));
                break;
            case ASSIGN:
                loadDouble(arg1, "fa1");
                storeDouble(res, "fa1");
                break;
            case ADD:
                emitBinary("fadd.d", arg1, arg2, res);
                break;
            case SUB:
                emitBinary("fsub.d", arg1, arg2, res);
                break;
            case MULT:
                emitBinary("fmul.d", arg1, arg2, res);
                break;
            case DIV:
                emitDiv(arg1, arg2, res, "int".equals(comment));
                break;
            case MOD:
                emitMod(arg1, arg2, res, "int".equals(comment));
                break;
            case EQ:
            case NEQ:
            case LT:
            case LE:
            case GT:
            case GE:
                emitCompare(op, arg1, arg2, res);
                break;
            case AND:
            case OR:
            case NOT:
                emitLogic(op, arg1, arg2, res);
                break;
            case STACK_WRITE:
                computeAddress(arg1, false, "t3");
                loadDouble(arg2, "fa1");
                text.append("    fsd fa1, 0(t3)\n");
                break;
            case STACK_READ:
                if (res == null || res.isEmpty() || "-".equals(res) || "_".equals(res)) break;
                computeAddress(arg1, false, "t3");
                text.append("    fld fa1, 0(t3)\n");
                storeDouble(res, "fa1");
                break;
            case HEAP_WRITE:
                computeAddress(arg1, true, "t3");
                loadDouble(arg2, "fa1");
                text.append("    fsd fa1, 0(t3)\n");
                break;
            case HEAP_READ:
                if (res == null || res.isEmpty() || "-".equals(res) || "_".equals(res)) break;
                computeAddress(arg1, true, "t3");
                text.append("    fld fa1, 0(t3)\n");
                storeDouble(res, "fa1");
                break;
            case PRINT:
                emitPrint(arg1, comment);
                break;
            case PRINT_STR:
                loadDouble(arg1, "fa0");
                text.append("    jal ra, _rt_print_str_d\n");
                if ("nl".equals(comment)) emitNewline();
                break;
            case READ:
                text.append("    jal ra, _rt_read_double\n");
                storeDouble(res, "fa0");
                break;
            case READ_CHAR:
                text.append("    jal ra, _rt_read_char\n");
                storeDouble(res, "fa0");
                break;
            case READ_STR:
                text.append("    jal ra, _rt_read_str\n");
                storeDouble(res, "fa0");
                break;
            case CONCAT_STR:
                emitConcat(arg1, arg2, res, comment);
                break;
            case CMP_STR:
                loadDouble(arg1, "fa0");
                loadDouble(arg2, "fa1");
                text.append("    jal ra, _rt_cmp_str\n");
                storeDouble(res, "fa0");
                break;
            case CALL: {
                String target = sanitize(arg1);
                if (!target.isEmpty()) {
                    text.append("    jal ra, ").append(target).append("\n");
                }
                break;
            }
            case RETURN:
                text.append("    j _ret_").append(routineName).append("\n");
                break;
            case PARAM:
            case NOP:
                break;
            default:
                text.append("    # cuadrupla no soportada: ").append(ascii(op.getSymbol())).append("\n");
                break;
        }
    }

    private void emitIf(OpCode op, String cond, String target) {
        int id = uniqueCounter++;
        loadDouble(cond, "fa0");
        text.append("    feq.d t0, fa0, f0\n");
        if (op == OpCode.IF_TRUE) {
            text.append("    bne t0, zero, _skip_").append(id).append("\n");
        } else {
            text.append("    beq t0, zero, _skip_").append(id).append("\n");
        }
        text.append("    j ").append(target).append("\n");
        text.append("_skip_").append(id).append(":\n");
    }

    private void emitBinary(String instr, String arg1, String arg2, String res) {
        loadDouble(arg1, "fa1");
        loadDouble(arg2, "fa2");
        text.append("    ").append(instr).append(" fa3, fa1, fa2\n");
        storeDouble(res, "fa3");
    }

    private void emitDiv(String arg1, String arg2, String res, boolean integer) {
        int id = uniqueCounter++;
        loadDouble(arg1, "fa1");
        loadDouble(arg2, "fa2");
        if (integer) {
            text.append("    fcvt.w.d t0, fa1, rtz\n");
            text.append("    fcvt.w.d t1, fa2, rtz\n");
            text.append("    beq t1, zero, _div_zero_").append(id).append("\n");
            text.append("    div t2, t0, t1\n");
            text.append("    j _div_end_").append(id).append("\n");
            text.append("_div_zero_").append(id).append(":\n");
            text.append("    li t2, 0\n");
            text.append("_div_end_").append(id).append(":\n");
            text.append("    fcvt.d.w fa3, t2\n");
        } else {
            text.append("    feq.d t0, fa2, f0\n");
            text.append("    bne t0, zero, _div_zero_").append(id).append("\n");
            text.append("    fdiv.d fa3, fa1, fa2\n");
            text.append("    j _div_end_").append(id).append("\n");
            text.append("_div_zero_").append(id).append(":\n");
            text.append("    fcvt.d.w fa3, zero\n");
            text.append("_div_end_").append(id).append(":\n");
        }
        storeDouble(res, "fa3");
    }

    private void emitMod(String arg1, String arg2, String res, boolean integer) {
        int id = uniqueCounter++;
        loadDouble(arg1, "fa1");
        loadDouble(arg2, "fa2");
        if (integer) {
            text.append("    fcvt.w.d t0, fa1, rtz\n");
            text.append("    fcvt.w.d t1, fa2, rtz\n");
            text.append("    beq t1, zero, _mod_zero_").append(id).append("\n");
            text.append("    rem t2, t0, t1\n");
            text.append("    j _mod_end_").append(id).append("\n");
            text.append("_mod_zero_").append(id).append(":\n");
            text.append("    li t2, 0\n");
            text.append("_mod_end_").append(id).append(":\n");
            text.append("    fcvt.d.w fa3, t2\n");
        } else {
            text.append("    feq.d t0, fa2, f0\n");
            text.append("    bne t0, zero, _mod_zero_").append(id).append("\n");
            text.append("    fdiv.d fa3, fa1, fa2\n");
            text.append("    fcvt.w.d t0, fa3, rtz\n");
            text.append("    fcvt.d.w fa4, t0\n");
            text.append("    fmul.d fa4, fa4, fa2\n");
            text.append("    fsub.d fa3, fa1, fa4\n");
            text.append("    j _mod_end_").append(id).append("\n");
            text.append("_mod_zero_").append(id).append(":\n");
            text.append("    fcvt.d.w fa3, zero\n");
            text.append("_mod_end_").append(id).append(":\n");
        }
        storeDouble(res, "fa3");
    }

    private void emitCompare(OpCode op, String arg1, String arg2, String res) {
        loadDouble(arg1, "fa1");
        loadDouble(arg2, "fa2");
        switch (op) {
            case EQ:
                text.append("    feq.d t0, fa1, fa2\n");
                break;
            case NEQ:
                text.append("    feq.d t0, fa1, fa2\n");
                text.append("    xori t0, t0, 1\n");
                break;
            case LT:
                text.append("    flt.d t0, fa1, fa2\n");
                break;
            case LE:
                text.append("    fle.d t0, fa1, fa2\n");
                break;
            case GT:
                text.append("    flt.d t0, fa2, fa1\n");
                break;
            case GE:
                text.append("    fle.d t0, fa2, fa1\n");
                break;
            default:
                text.append("    li t0, 0\n");
                break;
        }
        text.append("    fcvt.d.w fa3, t0\n");
        storeDouble(res, "fa3");
    }

    private void emitLogic(OpCode op, String arg1, String arg2, String res) {
        loadDouble(arg1, "fa1");
        if (op == OpCode.NOT) {
            text.append("    feq.d t0, fa1, f0\n");
            text.append("    fcvt.d.w fa3, t0\n");
            storeDouble(res, "fa3");
            return;
        }
        loadDouble(arg2, "fa2");
        text.append("    feq.d t0, fa1, f0\n");
        text.append("    xori t0, t0, 1\n");
        text.append("    feq.d t1, fa2, f0\n");
        text.append("    xori t1, t1, 1\n");
        if (op == OpCode.AND) {
            text.append("    and t2, t0, t1\n");
        } else {
            text.append("    or t2, t0, t1\n");
        }
        text.append("    fcvt.d.w fa3, t2\n");
        storeDouble(res, "fa3");
    }

    private void emitPrint(String arg1, String comment) {
        loadDouble(arg1, "fa0");
        if (comment.contains("char")) {
            text.append("    jal ra, _rt_print_char\n");
        } else if (comment.contains("bool")) {
            text.append("    jal ra, _rt_print_bool\n");
        } else if (comment.contains("decimal")) {
            text.append("    li a0, 1\n");
            text.append("    jal ra, _rt_print_dec\n");
        } else {
            text.append("    li a0, 0\n");
            text.append("    jal ra, _rt_print_dec\n");
        }
        if (!comment.contains("nonl")) emitNewline();
    }

    private void emitConcat(String arg1, String arg2, String res, String comment) {
        loadDouble(arg1, "fa0");
        loadDouble(arg2, "fa1");
        String mode = comment == null || comment.isEmpty() ? "str_str" : comment;
        String[] parts = mode.split("_", 2);
        String k1 = parts.length > 0 && !parts[0].isEmpty() ? parts[0] : "str";
        String k2 = parts.length > 1 && !parts[1].isEmpty() ? parts[1] : "str";
        text.append("    li a0, ").append(kindCode(k1)).append("\n");
        text.append("    li a1, ").append(kindCode(k2)).append("\n");
        text.append("    jal ra, _rt_concat\n");
        storeDouble(res, "fa0");
    }

    private int kindCode(String kind) {
        switch (kind) {
            case "int": return 1;
            case "dec": return 2;
            case "char": return 3;
            case "bool": return 4;
            default: return 0;
        }
    }

    private void emitNewline() {
        text.append("    li a0, 10\n");
        text.append("    li a7, 11\n");
        text.append("    ecall\n");
    }

    // ================================================================
    // Operandos
    // ================================================================

    private void loadDouble(String operand, String freg) {
        String s = operand == null ? "" : operand.trim();
        if (s.isEmpty() || "-".equals(s) || "_".equals(s)) {
            text.append("    fcvt.d.w ").append(freg).append(", zero\n");
            return;
        }
        if ("verum".equals(s)) {
            text.append("    li t0, 1\n");
            text.append("    fcvt.d.w ").append(freg).append(", t0\n");
            return;
        }
        if ("falsus".equals(s)) {
            text.append("    fcvt.d.w ").append(freg).append(", zero\n");
            return;
        }
        if ("NULL".equals(s)) {
            text.append("    li t0, -1\n");
            text.append("    fcvt.d.w ").append(freg).append(", t0\n");
            return;
        }
        if ("P".equals(s) || "H".equals(s)) {
            text.append("    la t0, ").append(s).append("\n");
            text.append("    fld ").append(freg).append(", 0(t0)\n");
            return;
        }
        if (isNumber(s)) {
            String lbl = numericLabel(s);
            text.append("    la t0, ").append(lbl).append("\n");
            text.append("    fld ").append(freg).append(", 0(t0)\n");
            return;
        }
        if (isTemp(s)) {
            loadTemp(s, freg);
            return;
        }
        String lbl = fallbackGlobal(s);
        text.append("    la t0, ").append(lbl).append("\n");
        text.append("    fld ").append(freg).append(", 0(t0)\n");
    }

    private void storeDouble(String result, String freg) {
        String s = result == null ? "" : result.trim();
        if (s.isEmpty() || "-".equals(s) || "_".equals(s)) return;
        if ("P".equals(s) || "H".equals(s)) {
            text.append("    la t0, ").append(s).append("\n");
            text.append("    fsd ").append(freg).append(", 0(t0)\n");
            return;
        }
        if (isTemp(s)) {
            storeTemp(s, freg);
            return;
        }
        String lbl = fallbackGlobal(s);
        text.append("    la t0, ").append(lbl).append("\n");
        text.append("    fsd ").append(freg).append(", 0(t0)\n");
    }

    private void loadTemp(String temp, String freg) {
        Integer off = currentSlots.get(temp);
        if (off != null) {
            emitLoadLocal(off, freg);
        } else {
            text.append("    la t0, _gt_").append(temp).append("\n");
            text.append("    fld ").append(freg).append(", 0(t0)\n");
        }
    }

    private void storeTemp(String temp, String freg) {
        Integer off = currentSlots.get(temp);
        if (off != null) {
            emitStoreLocal(off, freg);
        } else {
            text.append("    la t0, _gt_").append(temp).append("\n");
            text.append("    fsd ").append(freg).append(", 0(t0)\n");
        }
    }

    /**
     * Calcula en t3 la direccion real (bytes) de stack[expr] o heap[expr].
     * expr puede ser: numero, temp, P, H, o una suma de esos terminos.
     */
    private void computeAddress(String expr, boolean heap, String addrReg) {
        String base = heap ? "s11" : "s10";
        text.append("    li t3, 0\n");
        String e = expr == null ? "" : expr.trim();
        if (!e.isEmpty()) {
            for (String part : e.split("\\+")) {
                String p = part.trim();
                if (p.isEmpty()) continue;
                if (isNumber(p)) {
                    long v = (long) Double.parseDouble(p);
                    text.append("    li t1, ").append(v).append("\n");
                    text.append("    add t3, t3, t1\n");
                } else if ("P".equals(p) || "H".equals(p)) {
                    text.append("    la t0, ").append(p).append("\n");
                    text.append("    fld fa1, 0(t0)\n");
                    text.append("    fcvt.w.d t1, fa1, rtz\n");
                    text.append("    add t3, t3, t1\n");
                } else if (isTemp(p)) {
                    loadTemp(p, "fa1");
                    text.append("    fcvt.w.d t1, fa1, rtz\n");
                    text.append("    add t3, t3, t1\n");
                } else {
                    String lbl = fallbackGlobal(p);
                    text.append("    la t0, ").append(lbl).append("\n");
                    text.append("    fld fa1, 0(t0)\n");
                    text.append("    fcvt.w.d t1, fa1, rtz\n");
                    text.append("    add t3, t3, t1\n");
                }
            }
        }
        text.append("    slli t3, t3, 3\n");
        text.append("    add ").append(addrReg).append(", ").append(base).append(", t3\n");
    }

    private String numericLabel(String literal) {
        String key = literal.trim();
        String lbl = numericPool.get(key);
        if (lbl != null) return lbl;
        lbl = "_num_" + numericCounter++;
        numericPool.put(key, lbl);
        return lbl;
    }

    private String fallbackGlobal(String name) {
        String clean = sanitize(name);
        if (clean.isEmpty()) clean = "anon";
        String lbl = "_gv_" + clean;
        fallbackGlobals.add(lbl);
        return lbl;
    }

    private boolean isTemp(String s) {
        return s != null && s.matches("t\\d+");
    }

    private boolean isNumber(String s) {
        if (s == null || s.isEmpty()) return false;
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String sanitize(String id) {
        if (id == null) return "";
        return id.trim().replaceAll("[^a-zA-Z0-9_]", "_");
    }

    private String ascii(String s) {
        if (s == null) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sb.append(c < 128 ? c : '?');
        }
        return sb.toString();
    }

    // ================================================================
    // Ensamblado final
    // ================================================================

    private String buildFinalAssembly() {
        StringBuilder sb = new StringBuilder();
        sb.append("# ============================================================\n");
        sb.append("# RISC-V generado por Contacto Extraterrestre 3D\n");
        sb.append("# Modelo: RV32 + extension D (valores del lenguaje en doubles de 64 bits)\n");
        sb.append("# Ejecutar en RARS:\n");
        sb.append("#   java -jar rars.jar nc me sm programa.s\n");
        sb.append("# ============================================================\n\n");

        sb.append(".data\n");
        sb.append(".align 3\n");
        sb.append("stack: .space ").append(STACK_CELLS * CELL_BYTES).append("\n");
        sb.append(".align 3\n");
        sb.append("heap: .space ").append(HEAP_CELLS * CELL_BYTES).append("\n");
        sb.append(".align 3\n");
        sb.append("P: .double 0.0\n");
        sb.append("H: .double 0.0\n");

        for (String t : globalTemps) {
            sb.append("_gt_").append(t).append(": .double 0.0\n");
        }
        for (String g : fallbackGlobals) {
            sb.append(g).append(": .double 0.0\n");
        }
        for (Map.Entry<String, String> e : numericPool.entrySet()) {
            String val = e.getKey();
            if (val.matches("[-+]?\\d+")) val = val + ".0";
            sb.append(e.getValue()).append(": .double ").append(val).append("\n");
        }

        sb.append(".align 3\n");
        sb.append("_rt_num_buf: .space 128\n");
        sb.append("_rt_buf: .space 4096\n");
        sb.append("_str_verum: .asciz \"verum\"\n");
        sb.append("_str_falsus: .asciz \"falsus\"\n\n");

        sb.append(".text\n");
        sb.append(".globl main\n\n");
        sb.append(text);
        return sb.toString();
    }

    // ================================================================
    // Biblioteca de runtime
    // ================================================================

    private String runtimeLibrary() {
        StringBuilder sb = new StringBuilder();
        sb.append("""
            # ============================================================
            # Runtime: impresion, cadenas, lectura y concatenacion
            # ============================================================

            _rt_newline:
                li a0, 10
                li a7, 11
                ecall
                ret

            _rt_print_char:
                fcvt.w.d a0, fa0, rtz
                li a7, 11
                ecall
                ret

            _rt_print_bool:
                feq.d t0, fa0, f0
                bnez t0, _rt_print_bool_false
                la a0, _str_verum
                j _rt_print_bool_do
            _rt_print_bool_false:
                la a0, _str_falsus
            _rt_print_bool_do:
                li a7, 4
                ecall
                ret

            _rt_print_str:
                mv t0, a0
            _rt_print_str_loop:
                bltz t0, _rt_print_str_done
                slli t1, t0, 3
                add t1, s11, t1
                fld fa0, 0(t1)
                fcvt.w.d a0, fa0, rtz
                li t1, -1
                beq a0, t1, _rt_print_str_done
                li a7, 11
                ecall
                addi t0, t0, 1
                j _rt_print_str_loop
            _rt_print_str_done:
                ret

            _rt_print_str_d:
                fcvt.w.d a0, fa0, rtz
                j _rt_print_str

            _rt_print_dec:
                addi sp, sp, -32
                sw ra, 24(sp)
                sw s0, 16(sp)
                sw s1, 8(sp)
                la t0, H
                fld fa1, 0(t0)
                fcvt.w.d s0, fa1, rtz
                jal ra, _rt_append_dec
                la t0, H
                fld fa1, 0(t0)
                fcvt.w.d s1, fa1, rtz
                mv t0, s0
            _rt_print_dec_loop:
                bge t0, s1, _rt_print_dec_done
                slli t1, t0, 3
                add t1, s11, t1
                fld fa1, 0(t1)
                fcvt.w.d a0, fa1, rtz
                li a7, 11
                ecall
                addi t0, t0, 1
                j _rt_print_dec_loop
            _rt_print_dec_done:
                la t0, H
                fcvt.d.w fa1, s0
                fsd fa1, 0(t0)
                lw s1, 8(sp)
                lw s0, 16(sp)
                lw ra, 24(sp)
                addi sp, sp, 32
                ret

            _rt_append_char:
                la t0, H
                fld fa1, 0(t0)
                fcvt.w.d t1, fa1, rtz
                fcvt.w.d t2, fa0, rtz
                slli t3, t1, 3
                add t3, s11, t3
                fcvt.d.w fa1, t2
                fsd fa1, 0(t3)
                addi t1, t1, 1
                la t0, H
                fcvt.d.w fa1, t1
                fsd fa1, 0(t0)
                ret

            _rt_append_bool:
                la t0, H
                fld fa1, 0(t0)
                fcvt.w.d t1, fa1, rtz
                feq.d t2, fa0, f0
                bnez t2, _rt_append_bool_false
                la t3, _str_verum
                j _rt_append_bool_copy
            _rt_append_bool_false:
                la t3, _str_falsus
            _rt_append_bool_copy:
                lb t4, 0(t3)
                beq t4, zero, _rt_append_bool_done
                slli t5, t1, 3
                add t5, s11, t5
                fcvt.d.w fa1, t4
                fsd fa1, 0(t5)
                addi t1, t1, 1
                addi t3, t3, 1
                j _rt_append_bool_copy
            _rt_append_bool_done:
                la t0, H
                fcvt.d.w fa1, t1
                fsd fa1, 0(t0)
                ret

            _rt_append_str:
                la t0, H
                fld fa1, 0(t0)
                fcvt.w.d t1, fa1, rtz
                mv t2, a0
            _rt_append_str_loop:
                bltz t2, _rt_append_str_done
                slli t3, t2, 3
                add t3, s11, t3
                fld fa2, 0(t3)
                fcvt.w.d t4, fa2, rtz
                li t5, -1
                beq t4, t5, _rt_append_str_done
                slli t3, t1, 3
                add t3, s11, t3
                fcvt.d.w fa2, t4
                fsd fa2, 0(t3)
                addi t1, t1, 1
                addi t2, t2, 1
                j _rt_append_str_loop
            _rt_append_str_done:
                la t0, H
                fcvt.d.w fa1, t1
                fsd fa1, 0(t0)
                ret

            _rt_append_str_d:
                fcvt.w.d a0, fa0, rtz
                j _rt_append_str

            _rt_append_int:
                li a0, 2
                j _rt_append_dec
            """);

        sb.append("""
            # a0 = 0 numerico, 1 decimal (fuerza .0), 2 entero (trunca)
            _rt_append_dec:
                la t0, H
                fld fa1, 0(t0)
                fcvt.w.d t0, fa1, rtz
                flt.d t1, fa0, f0
                beq t1, zero, _rt_dec_abs
                li t2, 45
                slli t3, t0, 3
                add t3, s11, t3
                fcvt.d.w fa1, t2
                fsd fa1, 0(t3)
                addi t0, t0, 1
                fneg.d fa0, fa0
            _rt_dec_abs:
                fcvt.w.d t1, fa0, rtz
                fcvt.d.w fa1, t1
                fsub.d fa2, fa0, fa1
                li t2, 2
                beq a0, t2, _rt_dec_int_only
                j _rt_dec_have_frac
            _rt_dec_int_only:
                fcvt.d.w fa2, zero
            _rt_dec_have_frac:
                bne t1, zero, _rt_dec_int_nonzero
                li t2, 48
                slli t3, t0, 3
                add t3, s11, t3
                fcvt.d.w fa1, t2
                fsd fa1, 0(t3)
                addi t0, t0, 1
                j _rt_dec_after_int
            _rt_dec_int_nonzero:
                la t2, _rt_num_buf
                addi t2, t2, 128
                li t3, 10
            _rt_dec_extract:
                beq t1, zero, _rt_dec_write_digits
                rem t4, t1, t3
                div t1, t1, t3
                addi t4, t4, 48
                addi t2, t2, -4
                sw t4, 0(t2)
                j _rt_dec_extract
            _rt_dec_write_digits:
                la t4, _rt_num_buf
                addi t4, t4, 128
            _rt_dec_write_loop:
                beq t2, t4, _rt_dec_after_int
                lw t5, 0(t2)
                slli t6, t0, 3
                add t6, s11, t6
                fcvt.d.w fa1, t5
                fsd fa1, 0(t6)
                addi t0, t0, 1
                addi t2, t2, 4
                j _rt_dec_write_loop
            _rt_dec_after_int:
                li t2, 2
                beq a0, t2, _rt_dec_finish
                feq.d t1, fa2, f0
                bnez t1, _rt_dec_frac_zero
                li t2, 46
                slli t3, t0, 3
                add t3, s11, t3
                fcvt.d.w fa1, t2
                fsd fa1, 0(t3)
                addi t0, t0, 1
                li t2, 1000000
                fcvt.d.w fa3, t2
                fmul.d fa2, fa2, fa3
                fcvt.w.d t1, fa2
                li t2, 1000000
                blt t1, t2, _rt_dec_frac_ok
                addi t1, t1, -1
            _rt_dec_frac_ok:
                la t2, _rt_num_buf
                li t3, 100000
                li t4, 6
            _rt_dec_frac_digits:
                beq t4, zero, _rt_dec_frac_trim
                div t5, t1, t3
                rem t1, t1, t3
                addi t5, t5, 48
                sw t5, 0(t2)
                addi t2, t2, 4
                li t6, 10
                div t3, t3, t6
                addi t4, t4, -1
                j _rt_dec_frac_digits
            _rt_dec_frac_trim:
                la t3, _rt_num_buf
            _rt_dec_trim_loop:
                addi t2, t2, -4
                blt t2, t3, _rt_dec_frac_none
                lw t4, 0(t2)
                li t5, 48
                beq t4, t5, _rt_dec_trim_loop
                la t3, _rt_num_buf
            _rt_dec_frac_write:
                bgt t3, t2, _rt_dec_finish
                lw t4, 0(t3)
                slli t5, t0, 3
                add t5, s11, t5
                fcvt.d.w fa1, t4
                fsd fa1, 0(t5)
                addi t0, t0, 1
                addi t3, t3, 4
                j _rt_dec_frac_write
            _rt_dec_frac_none:
                li t2, 1
                bne a0, t2, _rt_dec_finish
                li t2, 46
                slli t3, t0, 3
                add t3, s11, t3
                fcvt.d.w fa1, t2
                fsd fa1, 0(t3)
                addi t0, t0, 1
                li t2, 48
                slli t3, t0, 3
                add t3, s11, t3
                fcvt.d.w fa1, t2
                fsd fa1, 0(t3)
                addi t0, t0, 1
                j _rt_dec_finish
            _rt_dec_frac_zero:
                li t2, 1
                bne a0, t2, _rt_dec_finish
                li t2, 46
                slli t3, t0, 3
                add t3, s11, t3
                fcvt.d.w fa1, t2
                fsd fa1, 0(t3)
                addi t0, t0, 1
                li t2, 48
                slli t3, t0, 3
                add t3, s11, t3
                fcvt.d.w fa1, t2
                fsd fa1, 0(t3)
                addi t0, t0, 1
            _rt_dec_finish:
                la t1, H
                fcvt.d.w fa1, t0
                fsd fa1, 0(t1)
                ret

            _rt_concat:
                addi sp, sp, -48
                sw ra, 40(sp)
                sw s0, 32(sp)
                sw s1, 24(sp)
                sw s2, 16(sp)
                fsd fa0, 8(sp)
                fsd fa1, 0(sp)
                mv s0, a0
                mv s1, a1
                la t0, H
                fld fa2, 0(t0)
                fcvt.w.d s2, fa2, rtz
                li t0, 0
                beq s0, t0, _rt_concat_a1_str
                li t0, 1
                beq s0, t0, _rt_concat_a1_int
                li t0, 2
                beq s0, t0, _rt_concat_a1_dec
                li t0, 3
                beq s0, t0, _rt_concat_a1_char
                j _rt_concat_a1_bool
            _rt_concat_a1_str:
                fld fa0, 8(sp)
                fcvt.w.d a0, fa0, rtz
                jal ra, _rt_append_str
                j _rt_concat_a2
            _rt_concat_a1_int:
                fld fa0, 8(sp)
                jal ra, _rt_append_int
                j _rt_concat_a2
            _rt_concat_a1_dec:
                fld fa0, 8(sp)
                li a0, 1
                jal ra, _rt_append_dec
                j _rt_concat_a2
            _rt_concat_a1_char:
                fld fa0, 8(sp)
                jal ra, _rt_append_char
                j _rt_concat_a2
            _rt_concat_a1_bool:
                fld fa0, 8(sp)
                jal ra, _rt_append_bool
            _rt_concat_a2:
                li t0, 0
                beq s1, t0, _rt_concat_a2_str
                li t0, 1
                beq s1, t0, _rt_concat_a2_int
                li t0, 2
                beq s1, t0, _rt_concat_a2_dec
                li t0, 3
                beq s1, t0, _rt_concat_a2_char
                j _rt_concat_a2_bool
            _rt_concat_a2_str:
                fld fa0, 0(sp)
                fcvt.w.d a0, fa0, rtz
                jal ra, _rt_append_str
                j _rt_concat_finish
            _rt_concat_a2_int:
                fld fa0, 0(sp)
                jal ra, _rt_append_int
                j _rt_concat_finish
            _rt_concat_a2_dec:
                fld fa0, 0(sp)
                li a0, 1
                jal ra, _rt_append_dec
                j _rt_concat_finish
            _rt_concat_a2_char:
                fld fa0, 0(sp)
                jal ra, _rt_append_char
                j _rt_concat_finish
            _rt_concat_a2_bool:
                fld fa0, 0(sp)
                jal ra, _rt_append_bool
            _rt_concat_finish:
                la t0, H
                fld fa0, 0(t0)
                fcvt.w.d t1, fa0, rtz
                slli t2, t1, 3
                add t2, s11, t2
                li t3, -1
                fcvt.d.w fa1, t3
                fsd fa1, 0(t2)
                addi t1, t1, 1
                fcvt.d.w fa0, t1
                fsd fa0, 0(t0)
                fcvt.d.w fa0, s2
                lw s2, 16(sp)
                lw s1, 24(sp)
                lw s0, 32(sp)
                lw ra, 40(sp)
                addi sp, sp, 48
                ret
            """);

        sb.append("""
            _rt_cmp_str:
                fcvt.w.d t0, fa0, rtz
                fcvt.w.d t1, fa1, rtz
                bltz t0, _rt_cmp_neg
                bltz t1, _rt_cmp_neg
            _rt_cmp_loop:
                slli t2, t0, 3
                add t2, s11, t2
                fld fa2, 0(t2)
                fcvt.w.d t4, fa2, rtz
                slli t3, t1, 3
                add t3, s11, t3
                fld fa3, 0(t3)
                fcvt.w.d t5, fa3, rtz
                li t6, -1
                beq t4, t6, _rt_cmp_end
                beq t4, t5, _rt_cmp_next
                blt t4, t5, _rt_cmp_less
                li a0, 1
                j _rt_cmp_done
            _rt_cmp_less:
                li a0, -1
                j _rt_cmp_done
            _rt_cmp_next:
                addi t0, t0, 1
                addi t1, t1, 1
                j _rt_cmp_loop
            _rt_cmp_end:
                beq t5, t6, _rt_cmp_equal
                li a0, -1
                j _rt_cmp_done
            _rt_cmp_equal:
                li a0, 0
                j _rt_cmp_done
            _rt_cmp_neg:
                beq t0, t1, _rt_cmp_equal
                blt t0, t1, _rt_cmp_less
                li a0, 1
            _rt_cmp_done:
                fcvt.d.w fa0, a0
                ret

            # Lee una linea y la convierte a double. Si la linea esta vacia o
            # no contiene digitos devuelve 0.0 (util para EOF en RARS, donde
            # syscall 7 abortaria con "invalid double input").
            _rt_read_double:
                addi sp, sp, -16
                sw s0, 12(sp)
                sw s1, 8(sp)
                la a0, _rt_buf
                li a1, 256
                li a7, 8
                ecall
                la s0, _rt_buf
                li s1, 0
            _rt_rd_skip:
                lb t0, 0(s0)
                li t1, 32
                beq t0, t1, _rt_rd_adv
                li t1, 9
                beq t0, t1, _rt_rd_adv
                li t1, 13
                beq t0, t1, _rt_rd_adv
                j _rt_rd_sign
            _rt_rd_adv:
                addi s0, s0, 1
                j _rt_rd_skip
            _rt_rd_sign:
                li t1, 45
                bne t0, t1, _rt_rd_plus
                li s1, 1
                addi s0, s0, 1
                j _rt_rd_int
            _rt_rd_plus:
                li t1, 43
                bne t0, t1, _rt_rd_int
                addi s0, s0, 1
            _rt_rd_int:
                li t2, 0
            _rt_rd_int_loop:
                lb t0, 0(s0)
                li t1, 48
                blt t0, t1, _rt_rd_frac_start
                li t1, 57
                bgt t0, t1, _rt_rd_frac_start
                addi t0, t0, -48
                li t1, 10
                mul t2, t2, t1
                add t2, t2, t0
                addi s0, s0, 1
                j _rt_rd_int_loop
            _rt_rd_frac_start:
                fcvt.d.w fa0, t2
                lb t0, 0(s0)
                li t1, 46
                bne t0, t1, _rt_rd_finish
                addi s0, s0, 1
                li t3, 0
                li t5, 0
            _rt_rd_frac_loop:
                lb t0, 0(s0)
                li t1, 48
                blt t0, t1, _rt_rd_frac_done
                li t1, 57
                bgt t0, t1, _rt_rd_frac_done
                addi t0, t0, -48
                li t1, 10
                mul t3, t3, t1
                add t3, t3, t0
                addi t5, t5, 1
                addi s0, s0, 1
                j _rt_rd_frac_loop
            _rt_rd_frac_done:
                beq t5, zero, _rt_rd_finish
                li t4, 1
                li t6, 10
            _rt_rd_pow:
                beq t5, zero, _rt_rd_pow_done
                mul t4, t4, t6
                addi t5, t5, -1
                j _rt_rd_pow
            _rt_rd_pow_done:
                fcvt.d.w fa3, t3
                fcvt.d.w fa4, t4
                fdiv.d fa3, fa3, fa4
                fadd.d fa0, fa0, fa3
            _rt_rd_finish:
                beq s1, zero, _rt_rd_done
                fneg.d fa0, fa0
            _rt_rd_done:
                lw s1, 8(sp)
                lw s0, 12(sp)
                addi sp, sp, 16
                ret

            _rt_read_char:
            _rt_read_char_loop:
                li a7, 12
                ecall
                li t0, -1
                beq a0, t0, _rt_read_char_eof
                li t0, 32
                beq a0, t0, _rt_read_char_loop
                li t0, 9
                beq a0, t0, _rt_read_char_loop
                li t0, 10
                beq a0, t0, _rt_read_char_loop
                li t0, 13
                beq a0, t0, _rt_read_char_loop
                j _rt_read_char_got
            _rt_read_char_eof:
                li a0, 0
            _rt_read_char_got:
                fcvt.d.w fa0, a0
                ret

            _rt_read_str:
                addi sp, sp, -32
                sw ra, 24(sp)
                sw s0, 16(sp)
                sw s1, 8(sp)
                la t0, H
                fld fa0, 0(t0)
                fcvt.w.d s0, fa0, rtz
                la a0, _rt_buf
                li a1, 4096
                li a7, 8
                ecall
                la t1, _rt_buf
                mv t2, s0
            _rt_read_str_loop:
                lb t3, 0(t1)
                beq t3, zero, _rt_read_str_end
                li t4, 10
                beq t3, t4, _rt_read_str_end
                li t4, 13
                beq t3, t4, _rt_read_str_end
                slli t4, t2, 3
                add t4, s11, t4
                fcvt.d.w fa0, t3
                fsd fa0, 0(t4)
                addi t2, t2, 1
                addi t1, t1, 1
                j _rt_read_str_loop
            _rt_read_str_end:
                slli t4, t2, 3
                add t4, s11, t4
                li t5, -1
                fcvt.d.w fa0, t5
                fsd fa0, 0(t4)
                addi t2, t2, 1
                la t0, H
                fcvt.d.w fa0, t2
                fsd fa0, 0(t0)
                fcvt.d.w fa0, s0
                lw s1, 8(sp)
                lw s0, 16(sp)
                lw ra, 24(sp)
                addi sp, sp, 32
                ret
            """);
        return sb.toString();
    }
}
