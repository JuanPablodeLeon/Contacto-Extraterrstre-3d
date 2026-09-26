grammar YLenguajeParser;

import YLenguajeLexer;

tokens { INDENT, DEDENT }

inicio: instruccion EOF
      ;

instruccion: bloq_estruc? bloq_func?
           ;

bloq_estruc: ESTRUCTURAS NEWLINE INDENT esctruc+ DEDENT
           ;

esctruc: ESTRUCTURA ID DOS_PUNTOS NEWLINE INDENT definiciones+ DEDENT
       ;

bloq_func: FUNCIONES NEWLINE bloc_func*
         ;

bloc_func: DEFINIR ID LPAREN RPAREN RETORNO_FUNC (tipos | ID) DOS_PUNTOS NEWLINE bloque
         | DEFINIR ID LPAREN RPAREN DOS_PUNTOS NEWLINE bloque?
         ;

           // {...}, {...} .... , {...}
bloc_llaves: LLLAVE val_arreglo RLLAVE (COMA LLLAVE val_arreglo RLLAVE)*
           ;

            // <val> , <val> , ... , <val>
val_arreglo: expresion (COMA expresion)*
           ;


instrucciones: definiciones
             | asignaciones
             // imprimir ()
             | IMPRIMIR LPAREN expresion? RPAREN NEWLINE
             // si(<exp bool>) entonces ...
             | SI LPAREN expresion RPAREN ENTONCES NEWLINE bloque? bloc_si?
             // mientras(<exp bool>) hacer ...
             | MIENTRAS LPAREN expresion RPAREN HACER NEWLINE bloque
             // hacer: ... mientras(<exp bool>)
             | HACER DOS_PUNTOS NEWLINE bloque MIENTRAS LPAREN expresion RPAREN
             | PARA LPAREN tipos ID ASIG expresion DOS_PUNTOS expresion DOS_PUNTOS ID (INCREMENTO | DECREMENTO) DOS_PUNTOS NEWLINE bloque
             | RETORNAR expresion NEWLINE
             | expresion NEWLINE
             ;

bloc_si: (SINO LPAREN expresion RPAREN ENTONCES NEWLINE bloque)* CONTRARIO NEWLINE bloque
       ;


bloque: INDENT instrucciones+ DEDENT
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
asignaciones: ID PUNTO ID ASIG expresion NEWLINE
           // <id>.<id>[<valor>] = <valor>
            | ID PUNTO ID (LCORCH expresion RCORCH)+ ASIG expresion NEWLINE
          // <id>[<valor>] = <valor>
            | ID (LCORCH expresion RCORCH)+ ASIG expresion NEWLINE
           //<id> = <valor>
            | ID ASIG expresion NEWLINE
            | ID INCREMENTO
            | ID DECREMENTO
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
         | LEER LPAREN RPAREN
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


