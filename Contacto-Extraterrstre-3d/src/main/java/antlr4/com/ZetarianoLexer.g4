lexer grammar ZetarianoLexer;

PUBLIC: 'public';
CLASS: 'class';
STRING: 'String';
INT: 'int';
BOOLEAN: 'boolean';
DOUBLE: 'double';
CHAR: 'char';
VOID: 'void';
RETURN: 'return';
NEW: 'new';
IF: 'if';
ELSE: 'else';
TRUE: 'true';
FALSE: 'false';
SWITCH: 'switch';
CASE: 'case';
DEFAULT: 'default';
BREAK: 'break';
FOR: 'for';
CONTINUE: 'continue';
WHILE: 'while';
DO: 'do';
PRINTLN: 'println';
PRINT: 'print';
READLN: 'readln';
NULL_VAL: 'null';

LPAREN: '(';
RPAREN: ')';
LLLAVE: '{';
RLLAVE: '}';
PUNTO_COMA: ';';
COMA: ',';
INTERRG: '?';
DOS_PUNTOS: ':';
PUNTO: '.';
LCORCH: '[';
RCORCH: ']';

IGUAL: '==';
NO_IGUAL: '!=';
MAYOR_IGUAL: '>=';
MENOR_IGUAL: '<=';
MAYOR: '>';
MENOR: '<';
AND: '&&';
OR: '||';
NOT: '!';

INCREMENTO: '++';
DECREMENTO: '--';
SUMA_IGL: '+=';
RESTA_IGL: '-=';
MULT_IGL: '*=';
SUMA: '+';
RESTA: '-';
MULT: '*';
DIV: '/';
MOD: '%';
ASIGNACION: '=';

ID: [a-zA-Z_][a-zA-Z_0-9]*;
INTEGER: [0-9]+;
DOUBLES: INTEGER '.' INTEGER;
STRINGS: '"' (ESC|.)*? '"';
CHARS: '\'' [a-z-A-Z] '\'';
ESC: '\\"' | '\\\\' ;

//Comentarios
LINE_COMMENT: '//' .*? '\r'? '\n' -> skip;
BLOCK_COMMENT: '/*' .*? '*/' -> skip;

WS: [ \t\r\n]+ -> skip;