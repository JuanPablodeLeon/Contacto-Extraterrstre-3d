lexer grammar YLenguajeLexer;

// Tokens sinteticos para identacion
tokens { INDENT, DEDENT }

//PALABRAS RESERVADAS
ESTRUCTURAS: '%estructuras';
ESTRUCTURA: 'estructura';
CADENA: 'cadena';
ENTERO: 'entero';
FLOTANTE: 'flotante';
CARACTER: 'caracter';
BOOL: 'bool';
FUNCIONES: '%funciones';
DEFINIR: 'definir';
SI: 'si';
ENTONCES: 'entonces';
SINO: 'sino';
CONTRARIO: 'contrario';
ELEGITR: 'elegir';
CASO: 'caso';
ROMPER: 'romper';
PARA: 'para';
CONTINUAR: 'continuar';
MIENTRAS: 'mientras';
HACER: 'hacer';
IMPRIMIR: 'imprimir';
LEER: 'leer';
VERDADERO: 'verdadero';
FALSO: 'falso';
RETORNAR: 'retornar';
SIEMPRE: 'siempre';

//SIGNOS RESERVADOS
RETORNO_FUNC: '->';
DOS_PUNTOS: ':';
LCORCH: '[';
RCORCH: ']';
LPAREN: '(';
RPAREN: ')';
COMA: ',';
LLLAVE: '{';
RLLAVE: '}';
PUNTO: '.';
PUNTO_COMA: ';';

//RELACIONALES
IGUAL: '==';
NO_IGUAL: '!=';
MENOR_IGUAL: '<=';
MAYOR_IGUAL: '>=';
MENOR: '<';
MAYOR: '>';
AND: '&&';
OR: '||';
NOT: '!';

//ARITMETICOS
INCREMENTO: '++';
DECREMENTO: '--';
ASIG: '=';
SUMA: '+';
RESTA: '-';
MULT: '*';
DIV: '/';

ID: [a-zA-Z_][a-zA-Z0-9_]*;
INT: [0-9]+;
DECIMAL: INT '.' INT;
STRING: '"' (ESC | ~["\\\r\n])* '"';
CHAR: '\'' [a-zA-Z] '\'';
fragment ESC: '\\"' | '\\\\' | '\\n' | '\\t' | '\\r';

LINE_COMMENT: '//' ~[\r\n]* -> channel(HIDDEN);
BLOCK_COMMENT: '/*' .*? '*/' -> channel(HIDDEN);

NEWLINE: ('\r'? '\n' | '\r') [ \t]*;

WS: [ \t]+ -> skip;
