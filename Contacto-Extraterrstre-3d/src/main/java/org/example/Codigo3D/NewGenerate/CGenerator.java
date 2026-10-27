package org.example.Codigo3D.NewGenerate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CGenerator {

    public String generateC(C3DProgram program) {
        StringBuilder sb = new StringBuilder();

        sb.append("// ========================================================\n");
        sb.append("// C Code Generated from Nexus-Solairy C3D IR\n");
        sb.append("// ========================================================\n\n");
        sb.append("#include <stdio.h>\n");
        sb.append("#include <stdlib.h>\n");
        sb.append("#include <stdbool.h>\n");
        sb.append("#include <string.h>\n");
        sb.append("#include <math.h>\n\n");

        sb.append("#define STACK_SIZE 30101999\n");
        sb.append("#define HEAP_SIZE  30101999\n\n");

        sb.append("double stack[STACK_SIZE];\n");
        sb.append("double heap[HEAP_SIZE];\n");
        sb.append("double P = 0;\n");
        sb.append("double H = 0;\n\n");

        List<Quadruple> all = program.getQuadruples();
        Set<String> routines = new LinkedHashSet<>();
        for (Quadruple q : all) {
            if (q.getOp() == OpCode.LABEL && isRoutineLabel(q.getResult())) {
                routines.add(sanitize(q.getResult()));
            }
        }

        if (!routines.isEmpty()) {
            for (String r : routines) {
                sb.append("void ").append(r).append("();\n");
            }
            sb.append("\n");
        }

        List<Quadruple> mainBody = new ArrayList<>();
        List<Routine> routineBodies = new ArrayList<>();
        Routine current = null;
        for (Quadruple q : all) {
            if (q.getOp() == OpCode.LABEL && isRoutineLabel(q.getResult())) {
                String name = sanitize(q.getResult());
                if (current != null && current.name.equals(name)) {
                    continue;
                }
                current = new Routine(name);
                routineBodies.add(current);
                continue;
            }
            if (current == null) {
                mainBody.add(q);
            } else {
                current.body.add(q);
            }
        }

        Map<String, Set<String>> tempOwners = new LinkedHashMap<>();
        collectTempOwners(tempOwners, mainBody, "main");
        for (Routine r : routineBodies) {
            collectTempOwners(tempOwners, r.body, "r:" + r.name);
        }
        Set<String> globalTemps = new LinkedHashSet<>();
        for (Map.Entry<String, Set<String>> e : tempOwners.entrySet()) {
            if (e.getValue().size() > 1) globalTemps.add(e.getKey());
        }
        if (!globalTemps.isEmpty()) {
            for (String t : globalTemps) {
                sb.append("double ").append(t).append(" = 0;\n");
            }
            sb.append("\n");
        }

        sb.append("int main() {\n");
        appendTempDeclarations(sb, mainBody, globalTemps);
        for (Quadruple q : mainBody) {
            if (q.getOp() == OpCode.LABEL && "main_entry".equals(sanitize(q.getResult()))) {
                continue;
            }
            appendTranslated(sb, q, false, routines);
        }
        sb.append("\n    return 0;\n}\n");

        for (Routine r : routineBodies) {
            sb.append("\nvoid ").append(r.name).append("() {\n");
            appendTempDeclarations(sb, r.body, globalTemps);
            for (Quadruple q : r.body) {
                appendTranslated(sb, q, true, routines);
            }
            sb.append("\n    return;\n}\n");
        }

        return sb.toString();
    }

    private boolean isRoutineLabel(String label) {
        if (label == null || label.isEmpty()) return false;
        String s = sanitize(label);
        return !s.matches("L\\d+") && !"main_entry".equals(s);
    }

    private void appendTempDeclarations(StringBuilder sb, List<Quadruple> quads, Set<String> globalTemps) {
        Set<String> temps = new LinkedHashSet<>();
        for (Quadruple q : quads) {
            if (isTemp(q.getResult())) temps.add(q.getResult());
            if (isTemp(q.getArg1())) temps.add(q.getArg1());
            if (isTemp(q.getArg2())) temps.add(q.getArg2());
        }
        for (String t : temps) {
            if (!globalTemps.contains(t)) {
                sb.append("    double ").append(t).append(" = 0;\n");
            }
        }
    }

    private void collectTempOwners(Map<String, Set<String>> owners, List<Quadruple> quads, String owner) {
        for (Quadruple q : quads) {
            addOwner(owners, q.getResult(), owner);
            addOwner(owners, q.getArg1(), owner);
            addOwner(owners, q.getArg2(), owner);
        }
    }

    private void addOwner(Map<String, Set<String>> owners, String s, String owner) {
        if (isTemp(s)) {
            owners.computeIfAbsent(s, k -> new LinkedHashSet<>()).add(owner);
        }
    }

    private void appendTranslated(StringBuilder sb, Quadruple q, boolean inRoutine, Set<String> routines) {
        String translated = translateQuadToC(q, inRoutine, routines);
        if (translated == null || translated.isEmpty()) return;
        String[] lines = translated.split("\n", -1);
        for (String line : lines) {
            if (line.isEmpty()) continue;
            if (line.startsWith("        ")) {
                sb.append(line).append("\n");
            } else {
                sb.append("    ").append(line).append("\n");
            }
        }
    }

    private boolean isTemp(String s) {
        return s != null && s.matches("t\\d+");
    }

    private String safe(String s) {
        if (s == null || s.trim().isEmpty()) return "0";
        return s;
    }

    private String sanitize(String id) {
        if (id == null) return "";
        return id.replaceAll("[^a-zA-Z0-9_]", "_");
    }

    private String translateQuadToC(Quadruple q, boolean inRoutine, Set<String> routines) {
        OpCode op = q.getOp();
        String arg1 = safe(q.getArg1());
        String arg2 = safe(q.getArg2());
        String res = safe(q.getResult());
        String comment = q.getComment() == null ? "" : q.getComment();

        switch (op) {
            case LABEL:
                return sanitize(res) + ":;";
            case GOTO:
                return "goto " + sanitize(res) + ";";
            case IF_TRUE:
                return "if (" + arg1 + ") goto " + sanitize(res) + ";";
            case IF_FALSE:
                return "if (!(" + arg1 + ")) goto " + sanitize(res) + ";";
            case ASSIGN:
                return res + " = " + arg1 + ";";
            case ADD:
                return res + " = " + arg1 + " + " + arg2 + ";";
            case SUB:
                return res + " = " + arg1 + " - " + arg2 + ";";
            case MULT:
                return res + " = " + arg1 + " * " + arg2 + ";";
            case DIV:
                if ("int".equals(comment)) {
                    return res + " = (" + arg2 + " != 0) ? ((double)((long long)(" + arg1 + ") / (long long)(" + arg2 + "))) : 0;";
                }
                return res + " = (" + arg2 + " != 0) ? (" + arg1 + " / " + arg2 + ") : 0;";
            case MOD:
                if ("int".equals(comment)) {
                    return res + " = (" + arg2 + " != 0) ? ((double)((long long)(" + arg1 + ") % (long long)(" + arg2 + "))) : 0;";
                }
                return res + " = fmod(" + arg1 + ", " + arg2 + ");";
            case EQ:
                return res + " = (" + arg1 + " == " + arg2 + ") ? 1 : 0;";
            case NEQ:
                return res + " = (" + arg1 + " != " + arg2 + ") ? 1 : 0;";
            case LT:
                return res + " = (" + arg1 + " < " + arg2 + ") ? 1 : 0;";
            case LE:
                return res + " = (" + arg1 + " <= " + arg2 + ") ? 1 : 0;";
            case GT:
                return res + " = (" + arg1 + " > " + arg2 + ") ? 1 : 0;";
            case GE:
                return res + " = (" + arg1 + " >= " + arg2 + ") ? 1 : 0;";
            case AND:
                return res + " = ((" + arg1 + " != 0) && (" + arg2 + " != 0)) ? 1 : 0;";
            case OR:
                return res + " = ((" + arg1 + " != 0) || (" + arg2 + " != 0)) ? 1 : 0;";
            case NOT:
                return res + " = (" + arg1 + " == 0) ? 1 : 0;";
            case STACK_WRITE:
                return "stack[(int)(" + arg1 + ")] = " + arg2 + ";";
            case STACK_READ:
                return res.equals("0") ? "" : res + " = stack[(int)(" + arg1 + ")];";
            case HEAP_WRITE:
                return "heap[(int)(" + arg1 + ")] = " + arg2 + ";";
            case HEAP_READ:
                return res.equals("0") ? "" : res + " = heap[(int)(" + arg1 + ")];";
            case PRINT:
                return printC(arg1, comment);
            case PRINT_STR:
                return printStrC(arg1, comment);
            case READ:
                return "{ double _v = 0; if (scanf(\"%lf\", &_v) != 1) { _v = 0; } int _ch; while ((_ch = getchar()) != '\\n' && _ch != EOF); " + res + " = _v; }";
            case READ_CHAR:
                return "{ char _v = 0; if (scanf(\" %c\", &_v) != 1) _v = 0; " + res + " = (unsigned char)_v; }";
            case READ_STR:
                return readStrC(res);
            case CONCAT_STR:
                return concatStrC(res, arg1, arg2, comment);
            case CMP_STR:
                return cmpStrC(res, arg1, arg2);
            case CALL: {
                String target = sanitize(arg1);
                if (routines.contains(target)) {
                    return target + "();";
                }
                return "// undefined call to " + target;
            }
            case RETURN:
                return inRoutine ? "return;" : "return 0;";
            case PARAM:
                return "";
            case NOP:
                return "";
            default:
                return "// " + q.toString();
        }
    }

    private String printC(String arg1, String comment) {
        boolean nonl = comment.contains("nonl");
        if (comment.contains("char")) {
            if (nonl) {
                return "printf(\"%c\", (char)(int)(" + arg1 + ")); fflush(stdout);";
            }
            return "printf(\"%c\\n\", (char)(int)(" + arg1 + ")); fflush(stdout);";
        }
        if (comment.contains("bool")) {
            String nl = nonl ? "" : "\\n";
            return "{ if (" + arg1 + " != 0) printf(\"verum" + nl + "\"); else printf(\"falsus" + nl + "\"); fflush(stdout); }";
        }
        if (comment.contains("decimal")) {
            String nl = nonl ? "" : "\\n";
            return "{ double _v = " + arg1 + "; if (fabs(_v) < 1e15 && _v == (double)(long long)_v) printf(\"%lld.0" + nl + "\", (long long)_v); else printf(\"%g" + nl + "\", _v); fflush(stdout); }";
        }
        if (nonl) {
            return "printf(\"%g\", " + arg1 + "); fflush(stdout);";
        }
        return "printf(\"%g\\n\", " + arg1 + "); fflush(stdout);";
    }

    private String printStrC(String arg1, String comment) {
        boolean nl = "nl".equals(comment);
        if (nl) {
            return "{ int _p = (int)(" + arg1 + "); while (_p >= 0 && _p < HEAP_SIZE && heap[_p] != -1) { printf(\"%c\", (char)heap[_p++]); } printf(\"\\n\"); fflush(stdout); }";
        }
        return "{ int _p = (int)(" + arg1 + "); while (_p >= 0 && _p < HEAP_SIZE && heap[_p] != -1) { printf(\"%c\", (char)heap[_p++]); } fflush(stdout); }";
    }

    private String readStrC(String res) {
        return "{\n" +
                "        char _buf[4096];\n" +
                "        " + res + " = H;\n" +
                "        if (fgets(_buf, sizeof(_buf), stdin)) {\n" +
                "            size_t _l = strlen(_buf);\n" +
                "            while (_l > 0 && (_buf[_l-1] == '\\n' || _buf[_l-1] == '\\r')) _buf[--_l] = 0;\n" +
                "            for (size_t _i = 0; _i < _l; _i++) { if ((int)H < HEAP_SIZE) heap[(int)H++] = (unsigned char)_buf[_i]; }\n" +
                "        }\n" +
                "        if ((int)H < HEAP_SIZE) heap[(int)H++] = -1;\n" +
                "    }";
    }

    private String concatStrC(String res, String arg1, String arg2, String comment) {
        String mode = comment == null || comment.isEmpty() ? "str_str" : comment;
        String[] kinds = mode.split("_", 2);
        String k1 = kinds.length > 0 && !kinds[0].isEmpty() ? kinds[0] : "str";
        String k2 = kinds.length > 1 && !kinds[1].isEmpty() ? kinds[1] : "str";

        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("        ").append(res).append(" = H;\n");
        appendValue(sb, arg1, k1);
        appendValue(sb, arg2, k2);
        sb.append("        if ((int)H < HEAP_SIZE) heap[(int)H++] = -1;\n");
        sb.append("    }");
        return sb.toString();
    }

    private void appendValue(StringBuilder sb, String expr, String kind) {
        switch (kind) {
            case "int":
                sb.append("        { char _b[64]; sprintf(_b, \"%lld\", (long long)(").append(expr).append(")); ");
                sb.append("for (int _i = 0; _b[_i]; _i++) { if ((int)H < HEAP_SIZE) heap[(int)H++] = (double)_b[_i]; } }\n");
                break;
            case "dec":
                sb.append("        { char _b[64]; double _v = ").append(expr).append("; ");
                sb.append("if (fabs(_v) < 1e15 && _v == (double)(long long)_v) sprintf(_b, \"%lld.0\", (long long)_v); else sprintf(_b, \"%g\", _v); ");
                sb.append("for (int _i = 0; _b[_i]; _i++) { if ((int)H < HEAP_SIZE) heap[(int)H++] = (double)_b[_i]; } }\n");
                break;
            case "bool":
                sb.append("        if (").append(expr).append(" != 0) { const char *_b = \"verum\"; for (int _i = 0; _b[_i]; _i++) { if ((int)H < HEAP_SIZE) heap[(int)H++] = (double)_b[_i]; } } ");
                sb.append("else { const char *_b = \"falsus\"; for (int _i = 0; _b[_i]; _i++) { if ((int)H < HEAP_SIZE) heap[(int)H++] = (double)_b[_i]; } }\n");
                break;
            case "char":
                sb.append("        if ((int)H < HEAP_SIZE) heap[(int)H++] = (double)(unsigned char)(int)(").append(expr).append(");\n");
                break;
            default:
                sb.append("        { int _p = (int)(").append(expr).append("); int _lim = (int)").append("H").append("; ");
                sb.append("while (_p >= 0 && _p < _lim && heap[_p] != -1) { if ((int)H < HEAP_SIZE) heap[(int)H++] = heap[_p++]; } }\n");
                break;
        }
    }

    private String cmpStrC(String res, String arg1, String arg2) {
        return "{\n" +
                "        int _a = (int)(" + arg1 + "), _b = (int)(" + arg2 + "), _i = 0, _r = 0;\n" +
                "        if (_a < 0 || _b < 0) { _r = (_a == _b) ? 0 : (_a < _b ? -1 : 1); }\n" +
                "        else { while (heap[_a+_i] != -1 && heap[_b+_i] != -1 && heap[_a+_i] == heap[_b+_i]) _i++; " +
                "double _ca = heap[_a+_i], _cb = heap[_b+_i]; _r = (_ca == _cb) ? 0 : (_ca < _cb ? -1 : 1); }\n" +
                "        " + res + " = _r;\n" +
                "    }";
    }

    private static class Routine {
        final String name;
        final List<Quadruple> body = new ArrayList<>();

        Routine(String name) {
            this.name = name;
        }
    }
}
