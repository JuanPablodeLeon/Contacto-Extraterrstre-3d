package org.example.Semantico;

import java.util.Objects;

// Tipos para los tres lengujes
public class Tipo {
    public enum Base {
        ENTERO, FLOTANTE, CADENA, BOOL, CARACTER, VOID, SERIES, STRUCT, NULL, ERROR
    }

    public final Base base;
    public final Tipo elementos;
    public final String nombreStruct;

    private Tipo(Base base, Tipo elementos, String nombreStruct) {
        this.base = base;
        this.elementos = elementos;
        this.nombreStruct = nombreStruct;
    }

    public static final Tipo ENTERO = new Tipo(Base.ENTERO, null, null);
    public static final Tipo FLOTANTE = new Tipo(Base.FLOTANTE, null, null);
    public static final Tipo CADENA = new Tipo(Base.CADENA, null, null);
    public static final Tipo BOOL = new Tipo(Base.BOOL, null, null);
    public static final Tipo CARACTER = new Tipo(Base.CARACTER, null, null);
    public static final Tipo VOID = new Tipo(Base.VOID, null, null);
    public static final Tipo NULL = new Tipo(Base.NULL, null, null);
    public static final Tipo ERROR = new Tipo(Base.ERROR, null, null);

    public static Tipo series(Tipo elementos) {
        return new Tipo(Base.SERIES, elementos, null);
    }

    public static Tipo struct(String nombre) {
        return new Tipo(Base.STRUCT, null, nombre);
    }

    public boolean esError() {
        return base == Base.ERROR;
    }

    public boolean esPrimitivo() {
        return base == Base.ENTERO || base == Base.FLOTANTE
                || base == Base.CADENA || base == Base.CARACTER || base == Base.BOOL;
    }

    public boolean esNumero() {
        return base == Base.ENTERO || base == Base.FLOTANTE;
    }

    public int jerarquia() {
        switch (base) {
            case CADENA: return 5;
            case FLOTANTE: return 4;
            case ENTERO: return 3;
            case CARACTER: return 2;
            case BOOL: return 1;
            default: return -1;
        }
    }
    //Jerarquia devuelva en operaciones
    public static Tipo resultado(Tipo a, Tipo b) {
        if (a.esError() || b.esError()) return ERROR;
        if (!a.esPrimitivo() || !b.esPrimitivo()) return ERROR;
        return a.jerarquia() >= b.jerarquia() ? a : b;
    }

    // ------ Asignacion Implicita --------
    public static boolean asignableY(Tipo destino, Tipo origen) {
        return asignableNucleo(destino, origen, true);
    }
    public static boolean asignablePig(Tipo destino, Tipo origen) {
        return asignableNucleo(destino, origen, true);
    }
    public static boolean asignableZ(Tipo destino, Tipo origen) {
        if (destino.esError() || origen.esError()) return true;
        if (destino.base == Base.SERIES && origen.base == Base.SERIES) {
            return asignableZ(destino.elementos, origen.elementos);
        }
        if (origen.base == Base.NULL) {
            return destino.base == Base.STRUCT || destino.base == Base.SERIES
                    || destino.base == Base.CADENA; // String es referencia en Java
        }
        if (destino.base == Base.STRUCT && origen.base == Base.STRUCT) {
            return Objects.equals(destino.nombreStruct, origen.nombreStruct);
        }
        if (!destino.esPrimitivo() || !origen.esPrimitivo()) {
            return destino.base == origen.base
                    && Objects.equals(destino.nombreStruct, origen.nombreStruct);
        }
        if (destino.base == Base.FLOTANTE) {
            return origen.base == Base.FLOTANTE || origen.base == Base.ENTERO;
        }
        return destino.base == origen.base;
    }
    private static boolean asignableNucleo(Tipo destino, Tipo origen, boolean cadenaAceptaTodo) {
        if (destino.esError() || origen.esError()) return true;
        if (destino.base == Base.SERIES && origen.base == Base.SERIES) {
            return asignableNucleo(destino.elementos, origen.elementos, cadenaAceptaTodo);
        }
        if (destino.base == Base.STRUCT && origen.base == Base.STRUCT) {
            return Objects.equals(destino.nombreStruct, origen.nombreStruct);
        }
        if (origen.base == Base.NULL) {
            return destino.base == Base.STRUCT || destino.base == Base.SERIES;
        }
        if (!destino.esPrimitivo() || !origen.esPrimitivo()) {
            return destino.base == origen.base;
        }
        if (cadenaAceptaTodo && destino.base == Base.CADENA) return true;
        if (origen.base == Base.CADENA) return destino.base == Base.CADENA;
        return destino.jerarquia() >= origen.jerarquia();
    }

    // tipos d variables
    public static Tipo desdeY(String nombre, TablaSimbolos tabla, int linea,
                              org.example.Reports.ErrorReporter errores) {
        if (nombre == null) return ERROR;
        switch (nombre.trim()) {
            case "entero": return ENTERO;
            case "flotante": return FLOTANTE;
            case "cadena": return CADENA;
            case "caracter": return CARACTER;
            case "bool": return BOOL;
            default:
                if (tabla != null && tabla.existeStruct(nombre)) return struct(nombre);
                if (errores != null) errores.semantico(linea, "Tipo no declarado: '" + nombre + "'.");
                return ERROR;
        }
    }
    public static Tipo desdeZ(String nombre) {
        if (nombre == null) return ERROR;
        switch (nombre.trim()) {
            case "int": return ENTERO;
            case "double": return FLOTANTE;
            case "String": return CADENA;
            case "char": return CARACTER;
            case "boolean": return BOOL;
            case "void": return VOID;
            case "null": return NULL;
            default: return struct(nombre); // objeto de una clase
        }
    }
    public static Tipo desdePig(String nombre, TablaSimbolos tabla, int linea,
                                org.example.Reports.ErrorReporter errores) {
        if (nombre == null) return ERROR;
        switch (nombre.trim()) {
            case "numerus": return ENTERO;
            case "decimalis": return FLOTANTE;
            case "textum": return CADENA;
            case "littera": return CARACTER;
            case "bool": return BOOL;
            default:
                if (tabla != null && tabla.existeStruct(nombre)) return struct(nombre);
                return struct(nombre); //Structs y Objetos se validan en los imports
        }
    }
    @Override
    public String toString() {
        switch (base) {
            case SERIES: return "series<" + elementos + ">";
            case STRUCT: return nombreStruct;
            case ENTERO: return "entero/int/numerus";
            case FLOTANTE: return "flotante/double/decimalis";
            case CADENA: return "cadena/String/textum";
            case CARACTER: return "caracter/char/littera";
            case BOOL: return "bool";
            case VOID: return "void";
            case NULL: return "null";
            default: return base.name().toLowerCase();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tipo)) return false;
        Tipo t = (Tipo) o;
        if (base != t.base) return false;
        if (base == Base.SERIES) return Objects.equals(elementos, t.elementos);
        if (base == Base.STRUCT) return Objects.equals(nombreStruct, t.nombreStruct);
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, elementos, nombreStruct);
    }
}
