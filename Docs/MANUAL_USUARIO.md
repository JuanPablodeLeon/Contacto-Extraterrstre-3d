# Manual de Usuario — Contacto Extraterrestre 3D

IDE gráfico para compilar y traducir tres lenguajes didácticos:

| Extensión | Lenguaje | Rol |
|---|---|---|
| `.pig` | PigLatin | Programa principal. **Es lo único que se ejecuta.** |
| `.y` | Y? | Biblioteca de funciones / estructuras. Se usa vía `import`. |
| `.z` | Zetariano | Clases estilo Java. Se usa vía `import` + `novus`. |

El programa `.pig` importa `.y` / `.z`, el IDE valida todo, y si no hay errores genera **Código de 3 Direcciones (cuartetas)** y **Código C** compilable con `gcc`.

## 1. Requisitos

- Java 21 (JDK)
- Maven 3.8+
- Dependencias (se descargan solas con Maven): ANTLR 4.13.2, RSyntaxTextArea 3.3.4
- Para probar el C generado (opcional): `gcc`

## 2. Instalación y ejecución

```bash
java -jar target/Contacto-Extraterrestre-3d.jar
```

Al arrancar aparece un mensaje de bienvenida con el flujo básico.

## 3. La ventana principal

- **Izquierda: explorador de proyecto** — árbol de archivos `.pig` / `.y` / `.z`. Doble clic abre en pestaña. Clic derecho: nuevo archivo, nueva subcarpeta, renombrar, eliminar.
- **Centro: pestañas de editor** — un editor con resaltado por lenguaje (`PigLatinEditor`, `YEditor`, `ZetarianoEditor`). Cada pestaña tiene `x` para cerrar.
- **Abajo: pestañas de salida**
  - `Consola` — resultado de la compilación / errores resumidos.
  - `Codigo 3 Direciones` — cuartetas generadas (solo si no hay errores).
  - `Codigo C` — traducción a C (solo si no hay errores).
- **Barra superior**
  - `Archivo`: Nuevo proyecto… / Abrir proyecto… / Guardar / Salir
  - `Ejecutar`: compila el `.pig` activo
  - `Reportes`: tokens, errores, AST, símbolos, C3D, C, guardar C
  - `Limpiar consola` y `Ayuda > Acerca de`

> El botón **Ejecutar solo se habilita en archivos `.pig`**. Los `.y` / `.z` no se ejecutan solos: se validan como imports del `.pig`.

## 4. Flujo básico (paso a paso)

### 4.1 Crear un proyecto

1. `Archivo > Nuevo proyecto…`
2. Escribe el nombre.
3. Elige la carpeta padre. Se crea `NombreProyecto/` con:
   - `PigLatin.pig`, `YFile.y`, `Zetariano.z` (vacíos / plantilla)
4. Los 3 archivos se abren automáticamente en pestañas.

### 4.2 Abrir un proyecto existente

`Archivo > Abrir proyecto…` → selecciona la **carpeta** del proyecto. Si no contiene `.pig/.y/.z` ni `proyecto.xml`, el IDE pregunta si abrirla de todos modos.

### 4.3 Editar

- Abre archivos con doble clic en el explorador.
- Escribe con resaltado de sintaxis por lenguaje.
- Guardar: `Archivo > Guardar` o `Ctrl+S` (guarda **todo** + reescribe `proyecto.xml`). Al cambiar de pestaña también se autogurada. Al cerrar la ventana se guarda todo.

### 4.4 Conectar `.pig` con `.y` / `.z` (imports)

En el `.pig`, al inicio:

```
import funciones.y
```

Reglas:

- Si el archivo no existe → error semántico, sin C3D.
- Los `.y` deben traer sección `%funciones` y los `.z` una clase válida (`public class Nombre {...}` donde el archivo se llama `Nombre.z`).
- Las funciones se llaman igual que en el `.y` (`calcularPoder(fuerza)`) y los objetos con `novus` (`esto c : novus Caja() ;`).

### 4.5 Ejecutar

1. Activa la pestaña `.pig` principal.
2. Pulsa **Ejecutar**.
3. Mira la `Consola`:
   - `✔ Ejecución exitosa…` → pasa a las pestañas `Codigo 3 Direciones` y `Codigo C`.
   - `----- Hay errores … -----` → abre `Reportes > Reporte de errores`, corrige y re-ejecuta.

### 4.6 Ver reportes

`Reportes >`:

- `Reporte de tokens` — lista de tokens del último análisis (requiere haber ejecutado antes).
- `Reporte de errores` — tabla de errores léxicos / sintácticos / semánticos.
- `Visualizar Árbol AST` — actualmente muestra aviso (previsto para Proyecto 2).
- `Tabla de símbolos` / `Código 3 direcciones` / `Código C generado` — requieren una compilación **exitosa**; solo cambian la pestaña inferior.
- `Guardar C (.c)…` — guarda el C en disco. El diálogo indica cómo compilarlo: `gcc salida.c -o salida`.

### 4.7 Cerrar pestañas / archivos

- `x` de la pestaña, `Ctrl+W`, clic medio, o clic derecho > Cerrar / Cerrar otras / Cerrar todas. Al cerrar se guarda el archivo.

## 5. Ejemplo mínimo completo

**`funciones.y`**

```
%funciones
definir calcularPoder(entero fuerza) -> entero:
    entero total = fuerza * 2
    retornar total
```

**`principal.pig`**

```
import funciones.y
VARIABILES>
esto fuerza : numerus 10 ;
esto poder : numerus 0 ;
MAIOR>
>> "Tu poder es: " >> calcularPoder(fuerza) ;
FINIS;
```

1. Guarda todo (`Ctrl+S`), activa `principal.pig`, pulsa **Ejecutar**.
2. Consola: `✔ Ejecución exitosa… | Funciones importadas: 1 | Cuartetas generadas: N`.
3. Revisa el C3D y el C, o guárdalo con `Reportes > Guardar C (.c)…`.

Más ejemplos listos en la carpeta `ejemplos-piglatin/` (`01-facil.pig`, `02-complejo-ok.pig`, `principal.pig` + `funciones.y`, `Caja.z`, `Item.z`, etc.).

## 6. Atajos y trucos

| Acción | Cómo |
|---|---|
| Guardar todo | `Ctrl+S` o `Archivo > Guardar` |
| Cerrar pestaña | `x`, `Ctrl+W` o clic medio |
| Menú de pestañas | clic derecho sobre la pestaña |
| Limpiar salida | botón `Limpiar consola` |
| Solo `.pig` ejecuta | si el botón está gris, cambia a una pestaña `.pig` |
