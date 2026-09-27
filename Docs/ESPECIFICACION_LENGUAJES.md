# Especificación de Lenguajes — PigLatin (.pig), Y? (.y), Zetariano (.z)

Documento de referencia: palabras reservadas, símbolos, gramática resumida y compatibilidad de tipos. Fuente de verdad: `src/main/java/antlr4/com/*.g4` y `src/main/java/org/example/Semantico/Tipo.java`, `SemanticoPig/Y/Z.java`.

Equivalencia de tipos primitivos entre lenguajes:

| Concepto | PigLatin | Y? | Zetariano |
|---|---|---|---|
| Entero | `numerus` | `entero` | `int` |
| Flotante | `decimalis` | `flotante` | `double` |
| Texto | `textum` | `cadena` | `String` |
| Carácter | `littera` | `caracter` | `char` |
| Booleano | `bool` | `bool` | `boolean` |
| Vacío | — | (sin retorno) | `void` |
| Nulo | — (no es literal) | — | `null` |
| Arreglo / serie | `series T` | `T[]` / `{...}` | `T[]` |
| Estructura / objeto | `ID` (struct importado) / `novus Clase()` | `estructura ID` | `class ID` / `new` |

Literales booleanos: PigLatin `verum` / `falsus`, Y? `verdadero` / `falso`, Zetariano `true` / `false`.

---

# 1. PigLatin (`.pig`)

## 1.1 Palabras reservadas

```
import  VARIABILES>  esto  series  novus
numerus  decimalis  textum  littera  bool  verum  falsus
MAIOR>  FINIS  finis
si  aliter  dum  facere  per  perge  interrumpe  non
```

`FINIS;` (mayúsculas) cierra el programa; `finis;` (minúsculas) cierra `si` / `dum`.

## 1.2 Símbolos y operadores

| Categoría | Símbolos |
|---|---|
| E/S | `>>` (imprimir), `<<` (leer) |
| Agrupación | `( )  { }  [ ]` |
| Puntuación | `:  ,  .  ;` |
| Aritméticos | `+  -  *  /  ++  --` (unario `-` permitido) |
| Relacionales | `==  !=  <  >  <=  >=` |
| Lógicos | `&&  \|\|`, `non` (NOT) |
| Asignación | `=` |
| Comentarios | `// línea`, `## bloque ##` |

Identificadores: `[a-zA-Z_][a-zA-Z_0-9]*`. Literales: `INT (12)`, `DOUBLE (9.5)`, `STRING ("...")`, `CHARS ('a')`.

## 1.3 Gramática

```
inicio       : instrucciones? EOF
instrucciones: bloque_imports* vars_par? bloque_main FINIS ';'
bloque_imports: 'import' ID ('.' ID)*        // ej. import funciones.y
vars_par     : 'VARIABILES>' bloque_vars*
bloque_vars  : 'esto' ID ':' tipos expresion ';'
             | 'esto' ID ':' expresion ';'            // solo bool inferido
             | 'series' ID '[' expr ']' ':' tipo ('{' vals '}')? ';'
             | 'esto' ID ':' ID '{' vals '}' ';'      // struct literal
             | 'esto' ID ':' 'novus' ID '(' args? ')' ';'
             | 'series' ID '[' expr ']' ':' ID ';'    // serie de objetos
bloque_main  : 'MAIOR>' instruccion*
instruccion  : '>>' expr ('>>' expr)* ';'     // imprimir
             | ID? '<<'                       // leer (ej. edad <<)
             | expresion ';'
             | 'si' '(' expr ')' '{' ... '}' bloque_si 'finis' ';'
             | 'dum' '(' expr ')' '{' ... '}' 'finis' ';'
             | 'facere' '{' ... '}' 'dum' '(' expr ')' ';'
             | 'per' '(' 'esto' ID ':' tipo init ';' cond ';' ID++/-- ')' '{' ... '}'
             | ID '=' expr ';' | ID '[' i ']' '=' expr ';'
             | ID '.' ID '=' expr ';' | ID '[' i ']' '.' ID '=' expr ';'
             | ID '++'/'--' ';' | 'perge' ';' | 'interrumpe' ';'
bloque_si    : ('aliter' '(' expr ')' '{' ... '}')* ('aliter' '{' ... '}')?
tipos        : 'numerus' | 'textum' | 'bool' | 'decimalis' | 'littera'
```

Precedencia de expresión (de menor a mayor): `|| &&` → `== !=` → `<= >=` → `< >` → `+ -` → `* /` → unarios (`-`, `non`) → paréntesis, llamadas, accesos (`a[i]`, `p.x`, `obj.met(args)`, `f(args)`, `Tipo f(args)`).

## 1.4 Tipos y compatibilidad (PigLatin)

Asignación `esto x : T = valor;` y `x = valor;` usan `Tipo.asignablePig`:

- `textum` acepta **cualquier primitivo** (concatenación implícita). `textum + numerus → textum`.
- `decimalis` acepta `decimalis`, `numerus`, `littera`, `bool` (jerarquía). Ej. `decimalis d = 17/2;` válido.
- `numerus` acepta `numerus`, `littera`, `bool`; **no** `decimalis` ni `textum`.
- `littera` acepta `littera`, `bool`; **no** numéricos grandes ni `textum`.
- `bool` solo acepta `bool` (relacionales/lógicas). La forma `esto x : <expr>;` (sin tipo) exige `bool`.
- `series<T>` solo acepta serie del mismo elemento (elemento a elemento); el tamaño `[N]` debe ser `numerus` y el nº de valores debe coincidir; el índice debe ser `numerus` y dentro de rango.
- Estructura/objeto: solo el mismo tipo (`Punto = Punto`, `Perro = Perro`); el literal `{...}` debe traer los valores en orden y cantidad del struct.

Resultado de operadores:

| Operador | Regla | Resultado |
|---|---|---|
| `+` con algún `textum` | `textum + primitivo` (el otro lado debe ser primitivo, no serie/struct) | `textum` |
| `+ -` numéricos | solo `numerus`/`decimalis` (`littera`/`bool`/`textum` → error) | mayor jerarquía (`numerus+decimalis → decimalis`) |
| `* /` | solo `numerus`/`decimalis`; `textum` prohibido | mayor jerarquía |
| `-x`, `non x` | `-` solo numérico; `non` solo `bool` | mismo tipo / `bool` |
| `== !=` | `textum` solo con `textum`; `bool` solo con `bool`; resto primitivos; series/structs → error | `bool` |
| `< > <= >=` | solo `numerus`/`decimalis`/`littera`; `textum`/series/structs → error | `bool` |
| `&& \|\|` | solo `bool` | `bool` |
| `++ --` | solo `numerus`/`decimalis` | mismo tipo |
| condición `si/dum/facere/per` | debe ser `bool` | — |

Ejemplo: `textum + numerus → textum`; `numerus + decimalis → decimalis`; `numerus * textum → ERROR`; `bool && numerus → ERROR`.

---

# 2. Y? (`.y`)

Lenguaje indentado (como Python). La indentación genera tokens `INDENT/DEDENT`. Estructura obligatoria: sección `%funciones`; sección `%estructuras` opcional, siempre antes.

## 2.1 Palabras reservadas

```
%estructuras  estructura
%funciones  definir  retornar  ->  :
si  entonces  sino  contrario
elegir  caso  siempre  romper
para  continuar  mientras  hacer
imprimir  leer
entero  flotante  cadena  caracter  bool  verdadero  falso
```

## 2.2 Símbolos y operadores

| Categoría | Símbolos |
|---|---|
| Estructura | `%funciones`, `%estructuras`, `->`, `:` |
| Agrupación | `( )  [ ]  { }` |
| Puntuación | `,  .  ;` |
| Aritméticos | `+  -  *  /  ++  --` |
| Relacionales | `==  !=  <  >  <=  >=` |
| Lógicos | `&&  \|\|  !` |
| Asignación | `=` |
| Comentarios | `// línea`, `/* bloque */` |

## 2.3 Gramática

```
inicio      : bloq_estruc? bloq_func EOF
bloq_estruc : '%estructuras' INDENT esctruc+ DEDENT
esctruc     : 'estructura' ID ':' INDENT definiciones+ DEDENT
bloq_func   : '%funciones' INDENT bloc_func+ DEDENT
bloc_func   : 'definir' ID '(' params? ')' ('->' (tipos|ID))? ':' bloque
params      : (tipos|ID) ID | '[' ']' (tipos|ID) ID | '{' '}' (tipos|ID) ID ...
tipos       : 'cadena' | 'entero' | 'flotante' | 'caracter' | 'bool'
bloque      : INDENT instrucciones+ DEDENT
instrucciones:
    definiciones | asignaciones
  | 'imprimir' '(' expr? ')'            // por línea (NEWLINE)
  | 'si' '(' expr ')' 'entonces' bloque bloc_si
  | 'mientras' '(' expr ')' 'hacer' bloque
  | 'hacer' ':' bloque 'mientras' '(' expr ')'
  | 'para' '(' tipo ID '=' e1 ';' e2 ';' ID ++/-- ')' ':' bloque
  | 'elegir' '(' expr ')' ':' INDENT ('caso' e ':' bloque)+ 'siempre' ':' bloque DEDENT
  | 'retornar' expr? | 'romper' | 'continuar'
definiciones:
    tipo ID '=' expr | tipo ID | tipo ID '[' e ']' ('=' '{{..},{..}}')?
  | tipo ID '=' '{' v,... '}' | tipo ID '[' e ']' | tipo ID '=' '{' ... '}'
asignaciones:
    ID '=' e | ID '[' e ']' '=' e | ID '.' ID '=' e
  | ID '.' ID '[' e ']' '=' e | ID '++' | ID '--'
```

Ejemplo:

```
%funciones
definir calcularPoder(entero fuerza) -> entero:
    entero total = fuerza * 2
    retornar total
```

Notas: `definir f(...) :` sin `->` es sin retorno (`void`); toda función con retorno debe `retornar` en todos los caminos; `romper` solo en ciclo/`elegir`, `continuar` solo en ciclo; código tras `retornar` es inalcanzable (error).

## 2.4 Tipos y compatibilidad (Y?)

Igual núcleo que PigLatin (`Tipo.asignableY`): `cadena` acepta todo primitivo; `flotante` acepta `flotante/entero/caracter/bool`; `entero` acepta `entero/caracter/bool`; `caracter` acepta `caracter/bool`; `bool` solo `bool`; struct solo mismo tipo; arreglo elemento a elemento; índice/tamaño `entero`.

| Origen \ Destino | `entero` | `flotante` | `cadena` | `caracter` | `bool` |
|---|---|---|---|---|---|
| `entero` | ✅ | ✅ | ✅ (concatena) | ❌ | ❌ |
| `flotante` | ❌ | ✅ | ✅ (concatena) | ❌ | ❌ |
| `cadena` | ❌ | ❌ | ✅ | ❌ | ❌ |
| `caracter` | ✅ | ✅ | ✅ (concatena) | ✅ | ❌ |
| `bool` (`verdadero`) | ✅ | ✅ | ✅ (concatena) | ✅ | ✅ |

Operadores (idéntico a PigLatin con otros literales):

| Operador | Regla | Resultado |
|---|---|---|
| `+` con `cadena` | `cadena + entero/flotante/...` → concatenación | `cadena` |
| `+ - * /` | solo `entero`/`flotante` | mayor jerarquía (`entero+flotante → flotante`) |
| `-x`, `!x` | `-` solo numérico; `!` solo `bool` | mismo / `bool` |
| `== !=` | `cadena`↔`cadena`, `bool`↔`bool` | `bool` |
| `< > <= >=` | numéricos o `caracter`; nunca `cadena` | `bool` |
| `&& \|\|` | solo `bool` | `bool` |
| `leer()` | sin args | `cadena` |

Ejemplo pedido: `cadena + entero → cadena` (`"Edad: " + 20 → "Edad: 20"`); `entero + flotante → flotante`; `cadena - entero → ERROR`; `bool + entero → ERROR`.

---

# 3. Zetariano (`.z`)

Lenguaje estilo Java con llaves y `;`. **El archivo debe llamarse como la clase**: `Item.z` contiene `public class Item {...}`.

## 3.1 Palabras reservadas

```
public  class  void  new  return
int  double  String  char  boolean
true  false  null
if  else  switch  case  default  break
for  while  do  continue
print  println  readln
```

## 3.2 Símbolos y operadores

| Categoría | Símbolos |
|---|---|
| Agrupación | `( )  { }  [ ]` |
| Puntuación | `;  ,  .  :  ?` (ternario `cond ? a : b`) |
| Aritméticos | `+  -  *  /  %  ++  --` |
| Asignación | `=  +=  -=  *=` |
| Relacionales | `==  !=  <  >  <=  >=` |
| Lógicos | `&&  \|\|  !` |
| Comentarios | `// línea`, `/* bloque */` |

## 3.3 Gramática

```
inicio       : 'public' 'class' ID '{' instrucciones* '}'
instrucciones: 'public' ID '(' params? ')' '{' instruccion* '}'      // constructor
             | 'public' 'void' ID '(' params? ')' '{' ... '}'        // método void
             | 'public' (tipos|ID) ID '(' params? ')' '{' ... '}'    // método con retorno
             | declaracion+
declaracion  : (tipos|ID) ID '=' expr ';' | (tipos|ID) ID ';'
             | (tipos|ID) ('[' ']')+ ID '=' 'new' tipos ('[' e ']')+ ';'
             | (tipos|ID) '[' ']' ID '=' '{' e,... '}' ';'
             | ID '=' 'new' ID '(' args? ')' ';'
             | (tipos|ID) ID '=' 'new' ID '(' args? ')' ';'
asignacion   : ID '+='/'-='/'*=' expr ';' | ID '++'/'--' ';'
             | ID '[' e ']' '=' expr ';' | lvalue '=' expr ';'
             | ID '=' '(' cond ')' '?' e1 ':' e2 ';'                 // ternario
instruccion  : declaracion | asignacion
             | 'if' '(' e ')' '{' ... '}' bloque_si
             | 'switch' '(' ID ')' bloque_switch+ 'default' ':' ... 'break' ';'
             | 'for' '(' (tipos ID '=' e ';' e ';' ID ++/--) | (';' ';') ')' '{' ... '}'
             | 'while' '(' e ')' '{' ... '}' | 'do' '{' ... '}' 'while' '(' e ')' ';'
             | 'println'/'print' '(' e? ')' ';' | 'readln' '(' ')' ';'
             | 'break' ';' | 'continue' ';' | 'return' e? ';' | expr ';'
tipos        : 'int' | 'double' | 'boolean' | 'char' | 'String'
```

Sobrecarga permitida (misma arity = firma duplicada → error). Constructor sin `return` con valor. `break`/`continue`/`return` con las mismas reglas de alcance que Y?.

## 3.4 Tipos y compatibilidad (Zetariano)

`Tipo.asignableZ`. A diferencia de Y?/PigLatin, aquí **no** hay concatenación implícita en asignación:

| Origen \ Destino | `int` | `double` | `String` | `char` | `boolean` |
|---|---|---|---|---|---|
| `int` | ✅ | ✅ | ❌ | ❌ | ❌ |
| `double` | ❌ | ✅ | ❌ | ❌ | ❌ |
| `String` | ❌ | ❌ | ✅ | ❌ | ❌ |
| `char` | ❌ | ❌ | ❌ | ✅ | ❌ |
| `boolean` | ❌ | ❌ | ❌ | ❌ | ✅ |
| `null` | ❌ | ❌ | ✅ (es referencia) | ❌ | ❌ |

- Objeto: `Clase x = new Clase(args)` solo con constructor de igual aridad y params compatibles; objeto acepta `null` o la misma clase; arreglo acepta `null` o mismo elemento.
- `null` **nunca** asignable a `int/double/boolean/char`, ni retornable en ellos; comparar `primitivo == null` es error (excepto `String`).

Operadores:

| Operador | Regla | Resultado |
|---|---|---|
| `+` con `String` | `String + int/double/char/boolean/...` | `String` |
| `+ - * /` | solo `int`/`double` (`int/int` = división entera) | `int` si ambos `int`, si no `double` |
| `%` | solo `int`/`double` | `int` o `double` igual que arriba |
| `-x`, `!x` | `-` solo `int`/`double`; `!` solo `boolean` | mismo / `boolean` |
| `== !=` | numéricos entre sí; `String`↔`String`; `boolean`↔`boolean`; `char`↔`char`; objeto↔mismo tipo; objeto/`String`/arreglo ↔ `null` | `boolean` |
| `< > <= >=` | `int`/`double` (o `char`↔`char`); nunca `String`/`boolean` | `boolean` |
| `&& \|\|` | solo `boolean` | `boolean` |
| `+= -= *=` | variable y expresión ambas numéricas y `destino` acepta `origen` (`int += double` → error) | mismo tipo |
| `(c) ? a : b` | `c` debe ser `boolean`; ramas `a`,`b` compatibles entre sí y con el destino | tipo común |
| `++ --` | solo `int`/`double` | mismo tipo |
| índice `a[i]` / tamaño `new T[n]` | `i`/`n` debe ser `int` | elemento |

Ejemplo pedido: `String + int → String` (`"puntos: " + 5 → "puntos: 5"`); `int + double → double`; `int = double → ERROR`; `double = int → OK`; `int + String → String` (por conmutar con `+`); `int - String → ERROR`; `boolean + int → ERROR`.

---

# Apéndice: tabla comparativa rápida de `+`

| Operación | PigLatin | Y? | Zetariano |
|---|---|---|---|
| texto + entero | `textum` | `cadena` | `String` |
| entero + flotante | `decimalis` | `flotante` | `double` |
| entero + entero | `numerus` | `entero` | `int` |
| texto − entero | ERROR | ERROR | ERROR |
| texto + bool | `textum` | `cadena` | `String` |
| bool + entero | ERROR | ERROR | ERROR |
| char + entero (asignado a entero/flotante) | (`numerus`/`decimalis`) | (`entero`/`flotante`) | (`int` no acepta `char`) |
