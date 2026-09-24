grammar PigLatinParser;

import PigLatinLexer;

inicio: instrucciones? EOF
      ;

instrucciones: bloque_imports* vars_par? bloque_main FINISUP PUNTO_COMA
             ;

bloque_imports: IMPORT ID PUNTO ID PUNTO ID
              ;

vars_par: VARIABILES bloque_vars*
        ;

        // esto <id> : <tipo> <valor> ;
bloque_vars: ESTO ID DOS_PUNTOS tipos expresion PUNTO_COMA
          // esto <id> : <valor> ; <- Solo para expresiones booleanas
           | ESTO ID DOS_PUNTOS expresion PUNTO_COMA
           // -------------- ARRAYS -----------------------
          // series <id>[<valor>] : <tipo> {...} ;
           | SERIES ID LCORCH expresion RCORCH DOS_PUNTOS tipos_varios LLLAVE bloque_varios RLLAVE PUNTO_COMA
          // series <id>[<valor>] : <tipo> ;
           | SERIES ID LCORCH expresion RCORCH DOS_PUNTOS tipos_varios PUNTO_COMA
           // -------------- ESTRUCTURAS ---------------------
          // esto <id> : <id_estructura> {...} ;
           | ESTO ID DOS_PUNTOS ID LLLAVE bloque_varios RLLAVE PUNTO_COMA
          // series <id>[<valor>] : <id_estrucura> ;
           | SERIES ID LCORCH expresion RCORCH DOS_PUNTOS tipos_varios PUNTO_COMA
           // ---------------- OBJETOS -----------------------
          // esto <id> : novus <id_objeto>(...) ;
           | ESTO ID DOS_PUNTOS NOVUS ID LPAREN bloque_objt? RPAREN PUNTO_COMA
          // series <id>·[<valor>] : <id_objeto> ;
           | SERIES ID LCORCH expresion RCORCH DOS_PUNTOS ID PUNTO_COMA
           ;

tipos_varios: tipos
           | ID
           ;

bloque_varios: (expresion | LLLAVE bloque_varios RLLAVE)  (COMA (expresion | LLLAVE bloque_varios RLLAVE))*
             ;

bloque_objt: (expresion | NOVUS ID LPAREN bloque_objt? RPAREN) (COMA (expresion | NOVUS ID LPAREN bloque_objt? RPAREN))*
           ;


bloque_main: MAIOR instruccion*
           ;

instruccion: bloque_impr
           | bloque_leer
           | expresion PUNTO_COMA?
           | SI LPAREN expresion RPAREN LLLAVE instruccion* RLLAVE bloque_si? FINIS PUNTO_COMA
           | DUM LPAREN expresion RPAREN LLLAVE instruccion+ RLLAVE FINIS PUNTO_COMA
           | FACERE LLLAVE instruccion+ RLLAVE DUM LPAREN expresion RPAREN PUNTO_COMA
           | PER LPAREN ESTO ID DOS_PUNTOS tipos expresion PUNTO_COMA expresion PUNTO_COMA auto_cambio RPAREN LLLAVE instruccion+ RLLAVE
           | bloque_asignacion
           | PERGE PUNTO_COMA
           | INTERRUMPE PUNTO_COMA
           ;

bloque_si: (ALITER LPAREN expresion RPAREN LLLAVE instruccion* RLLAVE)* (ALITER LLLAVE instruccion* RLLAVE)?
         ;

        // >> <valor> ; | >> <valor>  ...  >> <valor> ;
bloque_impr: IMPRIMIR expresion (IMPRIMIR expresion)* PUNTO_COMA # Impresion_Consola
        ;

      // <id> << | <<
bloque_leer: ID? LEER # Lectura_Texto
        ;

                // <id> = <valor> ;
bloque_asignacion: ID ASIGNACION expresion PUNTO_COMA
                // <id>[<index>] = <valor> ;
                 | ID LCORCH expresion RCORCH ASIGNACION expresion PUNTO_COMA
                // <id>.<id> = <valor> ;
                 | ID PUNTO ID ASIGNACION expresion PUNTO_COMA
                // <id>[<index>].<id> = <valor> ;
                 | ID LCORCH expresion RCORCH PUNTO ID ASIGNACION expresion PUNTO_COMA
                 | auto_cambio PUNTO_COMA
                 ;

           // <id> ++
auto_cambio: ID SUMA_INCR
          // <id> --
           | ID RESTA_DECR
           ;

        // - <valor>
expresion: RESTA expresion # Umenos
        // non <valor>
         | NON expresion # Negacion
        // (...)
         | LPAREN expresion RPAREN # Parentesis
        // <valor> (* /) <valor>
         | expresion ops1=(MULTI | DIV) expresion # MultDiv
        // <valor> (+ -) <valor>
         | expresion ops1=(SUMA | RESTA) expresion # SumaResta
        // <valor> (== !=) <valor>
         | expresion ops1=(IGUAL | NO_IGUAL) expresion # IgualNoIgual
        // <valor> (<= >=) <valor>
         | expresion ops1=(MENRO_IGUAL | MAYOR_IGUAL) expresion # MenorMayorIgual
        // <valor> (< >) <valor>
         | expresion ops1=(MENOR | MAYOR) expresion # MenorMayor
        // <valor> (&& ||) <valor>
         | expresion ops1=(AND | OR) expresion # AndOr
       // <id>[<valor>]
         | ID LCORCH expresion RCORCH # Llamada_Elemento_Series
        // <id>.<id>[<valor>].<id>(...)
         | ID PUNTO ID LCORCH expresion RCORCH PUNTO ID LPAREN (expresion (COMA expresion)* )? RPAREN # Llmada_Elemnto_FUnc_Serie
       // <id_structura>.<id_propiedad>
         | ID PUNTO ID # Llamada_Propiedad_Structura
       // <id>.<id>(...)
         | ID PUNTO ID LPAREN (expresion (COMA expresion)* )? RPAREN # LLamada_Propiedad_Funcion
         // <id> (...)
         | ID LPAREN (expresion (COMA expresion)* )? RPAREN # Llamada_Actio_Exp
        // <tipo> <id> (...)
         | tipos ID LPAREN (expresion (COMA expresion)* )? RPAREN # Llamada_Ratio_Tipo
       // <id>[<valor>].<id>
         | ID LCORCH expresion RCORCH PUNTO ID # Llamada_Series_Structura
        // <id>.<id>[<valor>]
         | ID PUNTO ID LCORCH expresion RCORCH # Llamada_Series_Valor
         | VERUM # VerumValor
         | FALSUS # FalsusValor
         | ID # Identificador
         | DOUBLE # DoubleVal
         | INT # IntVal
         | CHARS # CharVal
         | STRING # StringVal
         ;

tipos: NUMERUS
     | TEXTUM
     | BOOL
     | DECIMALIS
     | LITTERA
     ;
