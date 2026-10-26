parser grammar YLenguajeParser;

options { tokenVocab=YLenguajeLexer; }

inicio: NEWLINE* bloq_estruc? bloq_func NEWLINE* EOF
      ;
           // %estructuas ...
bloq_estruc: ESTRUCTURAS NEWLINE (INDENT esctruc+ DEDENT | esctruc*)
           ;

        // estructua <id> : ...
esctruc: ESTRUCTURA ID DOS_PUNTOS NEWLINE INDENT definiciones+ DEDENT
       ;

        // %funciones ...
bloq_func: FUNCIONES NEWLINE (INDENT bloc_func+ DEDENT | bloc_func*)
         ;

        // definir <id> (...) -> <tipo> : ....
bloc_func: DEFINIR ID LPAREN params? RPAREN RETORNO_FUNC (tipos | ID) DOS_PUNTOS NEWLINE bloque
        // definir <id> (...) :
         | DEFINIR ID LPAREN params? RPAREN DOS_PUNTOS NEWLINE bloque
         ;

params: tipos_params (COMA tipos_params)*
      ;

             // <tipo> <id>
tipos_params: (tipos | ID) ID
            // [] <tipo> <id>
            | LCORCH RCORCH (tipos | ID) ID
            // {} <tipo> <id>
            | LLLAVE RLLAVE (tipos | ID) ID
            ;

           // {...}, {...} .... , {...}
bloc_llaves: LLLAVE val_arreglo RLLAVE (COMA LLLAVE val_arreglo RLLAVE)*
           ;

            // <val> , <val> , ... , <val>
val_arreglo: expresion (COMA expresion)*
           ;


instrucciones: definiciones
             | asignaciones
             // llamada suelta: funcion(...) o objeto.metodo(...)
             | llamada NEWLINE
             // leer() como instruccion
             | LEER LPAREN RPAREN NEWLINE
             // linea en blanco dentro de un bloque
             | NEWLINE
             // imprimir ()
             | IMPRIMIR LPAREN expresion? RPAREN NEWLINE
             // si(<exp bool>) entonces ...
             | SI LPAREN expresion RPAREN ENTONCES NEWLINE bloque bloc_si
             // mientras(<exp bool>) hacer ...
             | MIENTRAS LPAREN expresion RPAREN HACER NEWLINE bloque
             // hacer: ... mientras(<exp bool>)
             | HACER DOS_PUNTOS NEWLINE bloque MIENTRAS LPAREN expresion RPAREN NEWLINE
             // para (<tipo> <id> = <valor> ; <exp bool> ; <id> ++ --) : ...
             | PARA LPAREN tipos ID ASIG expresion PUNTO_COMA expresion PUNTO_COMA ID (INCREMENTO | DECREMENTO) RPAREN DOS_PUNTOS NEWLINE bloque
            // elegir (<exp bool>) : ...
             | ELEGITR LPAREN expresion RPAREN DOS_PUNTOS NEWLINE INDENT bloque_elegir DEDENT
             // retornar <valor>
             | RETORNAR expresion? NEWLINE
             | ROMPER NEWLINE
             | CONTINUAR NEWLINE
             ;

        // sino (<exp bool>) entonces ...                       contrario ...
bloc_si: (SINO LPAREN expresion RPAREN ENTONCES NEWLINE bloque)* (CONTRARIO NEWLINE bloque)?
       ;

bloque: INDENT instrucciones+ DEDENT
      ;

llamada: ID LPAREN (expresion (COMA expresion)*)? RPAREN
       | ID PUNTO ID LPAREN (expresion (COMA expresion)*)? RPAREN
       ;

bloque_elegir: (CASO expresion DOS_PUNTOS NEWLINE bloque)+ SIEMPRE DOS_PUNTOS NEWLINE bloque
             ;

            // <tipo> <id> = <expresion>
definiciones: (tipos | ID) ID ASIG expresion NEWLINE
           // <tipo> <id> [<valor>] = {...}
            | (tipos | ID) ID (LCORCH expresion RCORCH)+ ASIG bloc_llaves NEWLINE
           // <tipo> <id> = {...}
            | (tipos | ID) ID ASIG LLLAVE val_arreglo RLLAVE NEWLINE
           // <tipo> <id>
            | (tipos | ID) ID NEWLINE
           // <tipo> <id> [<valor>]
            | (tipos | ID) ID (LCORCH expresion RCORCH)+ NEWLINE
            ;

           // <id>.<id> = <valor>
asignaciones: ID PUNTO ID ASIG expresion NEWLINE
           // <id>.<id>[<valor>] = <valor>
            | ID PUNTO ID (LCORCH expresion RCORCH)+ ASIG expresion NEWLINE
          // <id>[<valor>] = <valor>
            | ID (LCORCH expresion RCORCH)+ ASIG expresion NEWLINE
           //<id> = <valor>
            | ID ASIG expresion NEWLINE
           // <id> ++
            | ID INCREMENTO NEWLINE
           // <id> --
            | ID DECREMENTO NEWLINE
           // <id>.<id> ++ / --
            | ID PUNTO ID (INCREMENTO | DECREMENTO) NEWLINE
           // <id>.<id>[<valor>] ++ / --
            | ID PUNTO ID (LCORCH expresion RCORCH)+ (INCREMENTO | DECREMENTO) NEWLINE
           // <id>[<valor>] ++ / --
            | ID (LCORCH expresion RCORCH)+ (INCREMENTO | DECREMENTO) NEWLINE
           // <id> += -= *= /= <valor>
            | ID (ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | DIV_ASSIGN) expresion NEWLINE
           // <id>.<id> += -= *= /= <valor>
            | ID PUNTO ID (ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | DIV_ASSIGN) expresion NEWLINE
           // <id>.<id>[<valor>] += -= *= /= <valor>
            | ID PUNTO ID (LCORCH expresion RCORCH)+ (ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | DIV_ASSIGN) expresion NEWLINE
           // <id>[<valor>] += -= *= /= <valor>
            | ID (LCORCH expresion RCORCH)+ (ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | DIV_ASSIGN) expresion NEWLINE
            ;

        // - <val>
expresion: RESTA expresion
        // ! <exp>
         | NOT expresion
        // (...)
         | LPAREN expresion RPAREN
        // <val> * / % <val>
         | expresion (MULT | DIV | MOD) expresion
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
        // <id>.<id>[...] <- campo que es arreglo
         | ID PUNTO ID (LCORCH expresion RCORCH)+
        // <id>( <valor> , <valor>)
         | ID LPAREN (expresion (COMA expresion)*)? RPAREN
        // <id>.<id>( <valor> , <valor>)
         | ID PUNTO ID LPAREN (expresion (COMA expresion)*)? RPAREN
         // leer()
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