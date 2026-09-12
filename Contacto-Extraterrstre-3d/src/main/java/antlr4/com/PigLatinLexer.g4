lexer grammar PigLatinLexer;

//PALABRAS RESERVADAS
IMPORT: 'import';
VARIABILES: 'VARIABILES>';
ESTO: 'esto';
BOOL: 'bool';
NUMERUS: 'numerus';
TEXTUM: 'textum';
MAIOR: 'MAIOR>';
FINISUP: 'FINIS';
DECIMALIS: 'decimalis';
LITTERA: 'littera';
SERIES: 'series';
FALSUS: 'falsus';
VERUM: 'verum';
NOVUS: 'novus';
SI: 'si';
FINIS: 'finis';
ALITER: 'aliter';
DUM: 'dum';
FACERE: 'facere';
PER: 'per';
NON: 'non';
PERGE: 'perge';
INTERRUMPE: 'interrumpe';

//SIGNOS RESERVADOS
IMPRIMIR: '>>';
LEER: '<<';
DOS_PUNTOS: ':';
LCORCH: '[';
RCORCH: ']';
LLLAVE: '{';
RLLAVE: '}';
LPAREN: '(';
RPAREN: ')';
COMA: ',';
PUNTO: '.';
PUNTO_COMA: ';';

//Aritmeticas
SUMA_INCR: '++';
RESTA_DECR: '--';
SUMA: '+';
RESTA: '-';
MULTI: '*';
DIV: '/';

//Relacionales
IGUAL: '==';
NO_IGUAL: '!=';
MENRO_IGUAL: '<=';
MAYOR_IGUAL: '>=';
MENOR: '<';
MAYOR: '>';

ASIGNACION: '=';

//Logicos
AND: '&&';
OR: '||';

ID: [a-zA-Z_][a-zA-Z_0-9]*;
INT: [0-9]+;
DOUBLE: INT '.' INT;
STRING: '"' (ESC|.)*? '"';
CHARS: '\'' [a-z-A-Z] '\'';
ESC: '\\"' | '\\\\' ;

//Comentarios
LINE_COMMENT: '//' .*? '\r'? '\n' -> skip;
BLOCK_COMMENT: '##' .*? '##' -> skip;

WS: [ \t\r\n]+ -> skip;

