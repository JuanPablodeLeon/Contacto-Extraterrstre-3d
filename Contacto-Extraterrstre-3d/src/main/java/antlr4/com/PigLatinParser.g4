grammar PigLatinParser;

import PigLatinLexer;

inicio: instrucciones? EOF
      ;

instrucciones: bloque_imports* bloque_vars* bloque_main FINISUP PUNTO_COMA
             ;

bloque_imports: IMPORT ID PUNTO ID PUNTO ID
              ;

bloque_vars: ESTO ID DOS_PUNTOS tipos expresion PUNTO_COMA
           // arrays
           | SERIES ID LCORCH expresion RCORCH DOS_PUNTOS tipos_array LLLAVE bloque_arrays RLLAVE PUNTO_COMA
           | SERIES ID LCORCH expresion RCORCH DOS_PUNTOS tipos_array PUNTO_COMA
           // estructuras
           | ESTO ID DOS_PUNTOS ID LLLAVE bloque_estruc RLLAVE PUNTO_COMA
           | SERIES ID LCORCH expresion RCORCH DOS_PUNTOS tipos_estruc PUNTO_COMA
           //Objetos
           | ESTO ID DOS_PUNTOS NOVUS ID LPAREN bloque_objt RPAREN PUNTO_COMA
           | SERIES ID LCORCH expresion RCORCH DOS_PUNTOS ID PUNTO_COMA
           ;



bloque_main: MAIOR instruccion*
           ;

instruccion: bloque_impr
           | bloque_leer
           | expresion
           | SI
           ;

        // -<valor>
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
       // <id_structura>.<id_propiedad>
         | ID PUNTO ID # Llamada_Propiedad_Structura
         // <id> (...)
         | ID LPAREN (expresion (COMA expresion)* )* RPAREN # Llamada_Actio_Exp
        // <tipo> <id> (...)
         | tipos ID LPAREN (expresion (COMA expresion)* )* RPAREN # Llamada_Ratio_Tipo
       // <id>[<valor>].<id>
         | ID LCORCH expresion RCORCH PUNTO ID # Llamada_Series_Structura
         | VERUM # VerumValor
         | FALSUS # FalsusValor
         | ID # Identificador
         | DOUBLE # DoubleVal
         | INT # IntVal
         | CHARS # CharVal
         | STRING # StringVal
         ;