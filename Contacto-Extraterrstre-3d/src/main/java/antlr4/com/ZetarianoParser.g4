grammar ZetarianoParser;

import ZetarianoLexer;

inicio: bloc_main EOF
      ;

        // public class <id> {...}
bloc_main: PUBLIC CLASS ID (EXTENDS ID)? LLLAVE instrucciones* RLLAVE
             ;

           // public <id> (...){...} <- Puede o no tener parametros, y puede o no tener instrucciones dentro
instrucciones: OVERRIDE? modificador? ID LPAREN param_var? RPAREN LLLAVE instruccion* RLLAVE
            // [modificador] void <id> (...) {...}
             | OVERRIDE? modificador? VOID ID LPAREN param_var? RPAREN LLLAVE instruccion* RLLAVE
            // [modificador] <tipo> <id> (...) {...}
             | OVERRIDE? modificador? (tipos | ID) ID LPAREN param_var? RPAREN LLLAVE instruccion* RLLAVE
            //declaracion de variables
             | modificador? declaracion+
             ;

modificador: PUBLIC
           | PRIVATE
           | PROTECTED
           ;

encapsulamiento: modificador
               ;

instruccion: declaracion
           | asignacion
         // if (<exp bool> ) {...} ...
           |IF LPAREN expresion RPAREN LLLAVE instruccion* RLLAVE bloque_si
         // if (<exp bool>) ...
           | IF LPAREN expresion RPAREN instruccion
           // if (<exp bool>) .... else ....
           | IF LPAREN expresion RPAREN instruccion ELSE instruccion
          // switch (<opcion>) { ... } || switch (<opcion>) case ... default ...
           | SWITCH LPAREN expresion RPAREN switch_cuerpo
           // for (<tipo> <id> = <valor> ; <exp bool> ; <id> ++ o --) {....} || for ( ; ; ) {....}
           | FOR LPAREN ((tipos ID ASIGNACION expresion PUNTO_COMA expresion PUNTO_COMA ID (INCREMENTO | DECREMENTO)) | (PUNTO_COMA PUNTO_COMA)) RPAREN (LLLAVE instruccion+ RLLAVE | instruccion)
           // while (<exp bool>) {...}
           | WHILE LPAREN expresion RPAREN (LLLAVE instruccion+ RLLAVE | instruccion)
           // do {...} while (<exp bool>) ;
           | DO LLLAVE instruccion+ RLLAVE WHILE LPAREN expresion RPAREN PUNTO_COMA
          // println(...);
           | PRINTLN LPAREN expresion? RPAREN PUNTO_COMA
          // print(...);
           | PRINT LPAREN expresion? RPAREN PUNTO_COMA
          // readln() ;
           | READLN LPAREN RPAREN PUNTO_COMA
          // break ;
           | BREAK PUNTO_COMA
          // continue ;
           | CONTINUE PUNTO_COMA
          // return <valor> ; || return ;
           | RETURN expresion? PUNTO_COMA
          // super(...) ; <- debe ser la primera instruccion del constructor
           | SUPER LPAREN params? RPAREN PUNTO_COMA
           | expresion PUNTO_COMA
           ;

        // else if (<exp bool> ) {...} || else {...}
bloque_si: (ELSE IF LPAREN expresion RPAREN LLLAVE instruccion* RLLAVE)* (ELSE LLLAVE instruccion* RLLAVE)?
         ;

switch_cuerpo: LLLAVE bloque_switch* bloque_default? RLLAVE
             | bloque_switch+ bloque_default?
             ;

            // case <id> : ... break; <- Puede no tener break
bloque_switch: CASE expresion DOS_PUNTOS instruccion*
             ;

bloque_default: DEFAULT DOS_PUNTOS instruccion*
              ;

           // <tipos> <id> = <value> ;
declaracion: (tipos | ID) ID ASIGNACION expresion PUNTO_COMA
           // <tipos>[] <id> = new <tipos>[<value>] ; || <tipos>[][]... <id> = new <tipos>[<value>][<value>]... ; <- misma cantidad en ambos lados
           | (tipos | ID) (LCORCH RCORCH)+ ID ASIGNACION NEW tipos (LCORCH expresion RCORCH)+ PUNTO_COMA
          // <tipos> [] <id> = {...} ;
           | (tipos | ID) LCORCH RCORCH ID ASIGNACION LLLAVE params RLLAVE PUNTO_COMA
          // <tipos>[]... <id> ;
           | (tipos | ID) (LCORCH RCORCH)+ ID PUNTO_COMA
          // <tipos> <id> ;
           | (tipos | ID) ID PUNTO_COMA
          // <tipos> <id> = new
           | (tipos | ID) ID ASIGNACION NEW ID LPAREN params? RPAREN PUNTO_COMA
           ;

         // <id> += <value> ;
asignacion: THIS PUNTO ID SUMA_IGL expresion PUNTO_COMA
          | THIS PUNTO ID RESTA_IGL expresion PUNTO_COMA
          | THIS PUNTO ID MULT_IGL expresion PUNTO_COMA
          | THIS PUNTO ID ASIGNACION expresion PUNTO_COMA
          | THIS PUNTO ID INCREMENTO PUNTO_COMA
          | THIS PUNTO ID DECREMENTO PUNTO_COMA
        // <id> += <value> ;
          | ID SUMA_IGL expresion PUNTO_COMA
        // <id> -= <value> ;
          | ID RESTA_IGL expresion PUNTO_COMA
        // <id> *= <value> ;
          | ID MULT_IGL expresion PUNTO_COMA
        // <id> = (<exp bool>) ? <exp> : <exp> ;
          | ID ASIGNACION LPAREN expresion RPAREN INTERRG expresion DOS_PUNTOS expresion PUNTO_COMA
        // <id> = <valor> ;
          | lvalue ASIGNACION expresion PUNTO_COMA
        // <id> ++ ;
          | ID INCREMENTO PUNTO_COMA
        // <id> -- ;
          | ID DECREMENTO PUNTO_COMA
          ;

lvalue: ID (PUNTO ID | LCORCH expresion RCORCH)*
      ;
      // <id> || <id>, <id>, ... , <id>
params: expresion (COMA expresion)*
      ;

        // <tipo> <id> || <tipo> <id>, <tipo> <id>, ... , <tipo> <id>
param_var: (tipos | ID) expresion (COMA (tipos | ID) expresion)*
         ;

expresion: // <exp>.<id>
           expresion PUNTO ID
         // <exp>.<id>(...)
         | expresion PUNTO ID LPAREN params? RPAREN
         // <exp>[<valor>]
         | expresion LCORCH expresion RCORCH
        // - <valor>
         | RESTA expresion
        // ! <exp>
         | NOT expresion
        // (...)
         | LPAREN expresion RPAREN
         // <cond> ? <valor> : <valor>
         | expresion INTERRG expresion DOS_PUNTOS expresion
         // new <tipo>[<valor>]...
         | NEW tipos (LCORCH expresion RCORCH)+
         // new <Clase>[<valor>]...  (arreglo de objetos)
         | NEW ID (LCORCH expresion RCORCH)+
         // new <id>(...)
         | NEW ID LPAREN params? RPAREN
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
        // this.<expresion>
         | THIS PUNTO expresion
        // super.metodo(...) / super.atributo
         | SUPER PUNTO ID LPAREN params? RPAREN
         | SUPER PUNTO ID
         | THIS
        // <tipo> <id> (...)
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