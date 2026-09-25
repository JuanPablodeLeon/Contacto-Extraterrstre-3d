grammar YLenguajeParser;

import YLenguajeLexer;

tokens { INDENT, DEDENT }

inicio: instruccion EOF
      ;

instruccion: bloq_estruc? bloq_func?
           ;

bloq_estruc: ESTRUCTURAS NEWLINE bloque_def+
           ;


bloq_func: FUNCIONES NEWLINE bloc_func*
         ;

bloc_func: DEFINIR ID LPAREN RPAREN RETORNO_FUNC (tipos | ID) DOS_PUNTOS bloque
         | DEFINIR ID LPAREN RPAREN DOS_PUNTOS bloque?
         ;


bloc_llaves: LLLAVE val_arreglo RLLAVE (COMA LLLAVE val_arreglo RLLAVE)*
           ;

val_arreglo: expresion (COMA expresion)*
           ;

bloque_def: INDENT definiciones DEDENT
          ;

bloque: INDENT instrucciones+ DEDENT
      ;

instrucciones: definiciones
             | asignaciones
             | RETORNAR expresion NEWLINE
             ;

            // <tipo> <id> = <expresion>
definiciones: (tipos | ID) ID ASIG expresion NEWLINE
           // <tipo> <id> [<valor>] = {...}
            | (tipos | ID) ID (LCORCH expresion RCORCH)+ ASIG bloc_llaves NEWLINE
           // <tipo> <id> = {...}
            | (tipos | ID) ID ASIG LLLAVE val_arreglo RLLAVE NEWLINE
           // <tipo> <id>
            | (tipos | ID) ID NEWLINE
            ;

           // <id>.<id> = <valor>
asignaciones: ID PUNTO ID ASIG expresion
           // <id>.<id>[<valor>] = <valor>
            | ID PUNTO ID (LCORCH expresion RCORCH)+ ASIG expresion
          // <id>[<valor>] = <valor>
            | ID (LCORCH expresion RCORCH)+ ASIG expresion
           //<id> = <valor>
            | ID ASIG expresion
            ;

        // - <val>
expresion: RESTA expresion
        // ! <exp>
         | NOT expresion
        // (...)
         | LPAREN expresion RPAREN
        // <val> / * <val>
         | expresion (MULT | DIV) expresion
         // <val> + - <val>
         | expresion (SUMA | RESTA) expresion
         // <val> == != <val>
         | expresion (IGUAL | NO_IGUAL) expresion
         // <val> <= >= <val>
         | expresion (MENOR_IGUAL | MAYOR_IGUAL) expresion
         // <val> < > <val>
         | expresion (MENOR | MAYOR) expresion
         // <val> && || <val>
         | expresion (AND | OR) expresion
        // <id>[...] <- Puede tener de 1 a n []
         | ID (LCORCH expresion RCORCH)+
        // <id>.<id>
         | ID PUNTO ID
         | VERDADERO
         | FALSO
         | ID
         | INT
         | DECIMAL
         | STRING
         | CHAR
         ;

tipos: CADENA
     | ENTERO
     | FLOTANTE
     | CARACTER
     | BOOL
     ;


