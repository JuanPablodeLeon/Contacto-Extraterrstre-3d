package org.example.Codigo3D;

public class Cuarteta {
    public final int id;
    public final String op;
    public final String arg1;
    public final String arg2;
    public final String res;
    public final String segmento;
    public final String comentario;

    public Cuarteta(int id, String op, String arg1, String arg2, String res, String segmento, String comentario) {
        this.id = id;
        this.op = op == null ? "" : op;
        this.arg1 = arg1 == null ? "-" : arg1;
        this.arg2 = arg2 == null ? "-" : arg2;
        this.res = res == null ? "-" : res;
        this.segmento = segmento == null ? "STACK" : segmento;
        this.comentario = comentario == null ? "" : comentario;
    }

    public String a3Direcciones() {
        switch (op) {
            case "LABEL": return arg1 + ":";
            case "GOTO": return "goto " + arg1;
            case "IF_FALSE": return "if_false " + arg1 + " goto " + res;
            case "IF_TRUE": return "if_true " + arg1 + " goto " + res;
            case "FUNC_BEGIN": return "func " + arg1 + " begin";
            case "FUNC_END": return "func " + arg1 + " end";
            case "MAIN_BEGIN": return "main begin";
            case "MAIN_END": return "main end";
            case "PARAM": return "param " + arg1;
            case "CALL": return res.equals("-") ? "call " + arg1 + ", " + arg2 : res + " = call " + arg1 + ", " + arg2;
            case "RETURN": return arg1.equals("-") ? "return" : "return " + arg1;
            case "PRINT": return "print " + arg1;
            case "PRINTLN": return "println " + arg1;
            case "READ": return "read " + arg1;
            case "DECLARE": return arg1 + " " + res;
            case "PARAM_DECL": return "param " + arg1 + " " + res;
            case "=": return res + " = " + arg1;
            case "=[]": return res + " = " + arg1 + "[" + arg2 + "]";
            case "[]=": return arg1 + "[" + arg2 + "] = " + res;
            case "=.": return res + " = " + arg1 + "." + arg2;
            case ".=": return arg1 + "." + arg2 + " = " + res;
            case "S.=": return arg1 + "." + arg2 + " = " + res;
            case "ALLOC_SERIES": return res + " = alloc_series(" + arg1 + ", " + arg2 + ")";
            case "ALLOC_OBJECT": return res + " = new " + arg1;
            case "STRUCT_DEF": return "struct_def " + arg1;
            case "STRUCT_FIELD": return "  field " + arg1 + " : " + arg2;
            case "STRUCT_INIT_BEGIN": return "struct_init " + arg1 + " : " + arg2;
            case "STRUCT_SET": return arg1 + "." + arg2 + " = " + res;
            case "STRUCT_INIT_END": return "end_struct_init " + arg1;
            case "UMINUS": return res + " = -" + arg1;
            case "NOT": return res + " = non " + arg1;
            default:
                if (!res.equals("-") && !arg1.equals("-")) return res + " = " + arg1 + " " + op + " " + arg2;
                return op + " " + arg1 + " " + arg2 + " " + res;
        }
    }

    @Override
    public String toString() {
        return String.format("%3d: (%s, %s, %s, %s)", id, op, arg1, arg2, res);
    }
}
