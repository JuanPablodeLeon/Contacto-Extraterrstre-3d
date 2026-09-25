grammar ZetarianoParser;

import ZetarianoLexer;

inicio: bloc_main? EOF
      ;

        // public class <id> {...}
bloc_main: PUBLIC CLASS ID LLLAVE instrucciones* RLLAVE
             ;

           // public <id> (...){...} <- Puede o no tener parametros, y puede o no tener instrucciones dentro
instrucciones: PUBLIC ID LPAREN param_var? RPAREN LLLAVE instruccion* RLLAVE
            // public void <id> (...) {...}
             | PUBLIC VOID ID LPAREN param_var? RPAREN LLLAVE instruccion* RLLAVE
            // public <tipo> <id> (...) {...}
             | PUBLIC (tipos | ID) ID LPAREN param_var? RPAREN LLLAVE instruccion* RLLAVE
            //declaracion de variables
             | declaracion+
             ;

instruccion: declaracion
           | asignacion
         // if (<exp bool> ) {...} ...
           |IF LPAREN expresion RPAREN LLLAVE instruccion* RLLAVE bloque_si?
          // switch (<opcion>): .... default: ... break ;
           | SWITCH LPAREN ID RPAREN bloque_switch+ DEFAULT DOS_PUNTOS instruccion* BREAK PUNTO_COMA
           // for (<tipo> <id> = <valor> ; <exp bool> ; <id> ++ o --) {....} || for ( ; ; ) {....}
           | FOR LPAREN ((tipos ID ASIGNACION expresion PUNTO_COMA expresion PUNTO_COMA ID (INCREMENTO | DECREMENTO)) | (PUNTO_COMA PUNTO_COMA PUNTO_COMA)) RPAREN LLLAVE instruccion+ RLLAVE
           // while (<exp bool>) {...}
           | WHILE LPAREN expresion RPAREN LLLAVE instruccion+ RLLAVE
           // do {...} while (<exp bool>) ;
           | DO LLLAVE instruccion+ RLLAVE WHILE LPAREN expresion RPAREN DOS_PUNTOS
          // println(...);
           | PRINTLN LPAREN expresion? RPAREN DOS_PUNTOS
          // print(...);
           | PRINT LPAREN expresion? RPAREN DOS_PUNTOS
          // break ;
           | BREAK PUNTO_COMA
          // continue ;
           | CONTINUE PUNTO_COMA
          // return <valor> ; || return ;
           | RETURN expresion? PUNTO_COMA
           | expresion PUNTO_COMA
           ;

        // else if (<exp bool> ) {...} || else {...}
bloque_si: (ELSE IF LPAREN expresion RPAREN LLLAVE instruccion* RLLAVE)* ELSE LLLAVE instruccion* RLLAVE
         ;

            // case <id> : ... break; <- Puede no tener break
bloque_switch: CASE ID DOS_PUNTOS instruccion* (BREAK PUNTO_COMA)?
             ;

           // <tipos> <id> = <value> ;
declaracion: (tipos | ID) ID ASIGNACION expresion PUNTO_COMA
           // <tipos>[] <id> = new <tipos>[<value>] ; || <tipos>[][]... <id> = new <tipos>[<value>][<value>]... ; <- misma cantidad en ambos lados
           | (tipos | ID) (LCORCH RCORCH)+ ID ASIGNACION NEW tipos (LCORCH expresion RCORCH)+ PUNTO_COMA
          // <tipos> [] <id> = {...} ;
           | (tipos | ID) LCORCH RCORCH ID ASIGNACION LLLAVE params RLLAVE PUNTO_COMA
          // <tipos> <id> ;
           | (tipos | ID) ID PUNTO_COMA
         // <id> = new <id>(...);
           | ID ASIGNACION NEW ASIGNACION LPAREN params? RPAREN PUNTO_COMA
          // <tipos> <id> = new
           | (tipos | ID) ID ASIGNACION NEW ID LPAREN params? RPAREN PUNTO_COMA
           ;

         // <id> += <value> ;
asignacion: ID SUMA_IGL expresion PUNTO_COMA
        // <id> -= <value> ;
          | ID RESTA_IGL expresion PUNTO_COMA
        // <id> *= <value> ;
          | ID MULT_IGL expresion PUNTO_COMA
        // <id> = (<exp bool>) ? <exp> : <exp> ;
          | ID ASIGNACION LPAREN expresion RPAREN INTERRG expresion DOS_PUNTOS expresion PUNTO_COMA
        // <id>[<value>] = <valor> ;
          | ID LCORCH expresion RCORCH ASIGNACION expresion PUNTO_COMA
        // <id> = <valor> ;
          | ID ASIGNACION expresion PUNTO_COMA
        // <id> ++ ;
          | ID INCREMENTO PUNTO_COMA
        // <id> -- ;
          | ID DECREMENTO PUNTO_COMA
          ;

      // <id> || <id>, <id>, ... , <id>
params: expresion (COMA expresion)*
      ;

        // <tipo> <id> || <tipo> <id>, <tipo> <id>, ... , <tipo> <id>
param_var: (tipos | ID) expresion ((tipos | ID) expresion)*
         ;

        // - <valor>
expresion: RESTA expresion
        // ! <exp>
         | NOT expresion
        // (...)
         | LPAREN expresion RPAREN
       // <valor> * / <valor>
         | expresion (MULT | DIV) expresion
       // <valor> % <valor>
         | expresion MOD expresion
       // <valor> + - <valor>
         | expresion (SUMA | RESTA) expresion
         // <valor> (== !=) <valor>
         | expresion ops1=(IGUAL | NO_IGUAL) expresion //# IgualNoIgual
         // <valor> (<= >=) <valor>
         | expresion ops1=(MENOR_IGUAL | MAYOR_IGUAL) expresion //# MenorMayorIgual
         // <valor> (< >) <valor>
         | expresion ops1=(MENOR | MAYOR) expresion //# MenorMayor
         // <valor> (&& ||) <valor>
         | expresion ops1=(AND | OR) expresion //# AndOr
        // <id>[<value>]
         | ID LCORCH expresion RCORCH
        // <id>.<id>
         | ID PUNTO ID
        // <id>.<id>(...)
         | ID PUNTO ID LPAREN params? RPAREN
        // <id>(...)
         | ID LPAREN params? RPAREN
         | TRUE
         | FALSE
         | NULL_VAL
         | ID
         | DOUBLES
         | INTEGER
         | CHARS
         | STRINGS
         ;

tipos: INT
     | DOUBLE
     | BOOLEAN
     | CHAR
     | STRING
     ;