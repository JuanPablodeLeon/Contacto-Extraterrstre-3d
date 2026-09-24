import lib.math.ops
import app.data.tipos
VARIABILES>
esto edad : numerus 20 ;
esto nombre : textum "Ana" ;
esto activo : bool verum ;
esto soloBool : verum && falsus ;
esto promedio : decimalis 9.5 ;
esto inicial : littera 'a' ;
series notas[3] : numerus {8, 9, 10} ;
series nombres[2] : textum {"Ana", "Bob"} ;
series vacio[5] : textum ;
esto punto : Punto {10, 20} ;
esto matriz : Matriz {{1, 2}, {3, 4}} ;
esto cfg : Config {sensor.leer(), {1, 2}} ;
esto perro1 : novus Perro() ;
esto perro2 : novus Perro(3, "Firulais", verum) ;
series manada[2] : Perro ;
MAIOR>
edad = 21 ;
notas[0] = 10 ;
punto.x = 5 ;
manada[0].edad = 3 ;
edad++ ;
edad-- ;
>> "Inicio" ;
>> nombre >> edad >> "fin" ;
nombre <<
<<
>> notas[0] ;
>> sensor.leer() ;
>> datos.valores[0].promedio() ;
>> calcular(1, 2) ;
>> punto.x ;
>> datos.valores[0] ;
si (edad > 18) {
  >> "mayor" ;
} finis ;
si (edad < 10) {
  >> "nino" ;
} aliter {
  >> "otro" ;
} finis ;
si (edad > 18) {
  >> "mayor" ;
} aliter (edad == 18) {
  >> "justo" ;
} finis ;
si (edad > 18) {
  >> "mayor" ;
} aliter (edad == 18) {
  >> "justo" ;
} aliter {
  >> "menor" ;
} finis ;
dum (edad < 25) {
  >> edad ;
  edad = edad + 1 ;
} finis ;
facere {
  >> edad ;
  edad = edad + 1 ;
} dum (edad < 30) ;
per (esto i : numerus 0 ; i < 5 ; i++) {
  >> i ;
  si (i == 3) {
    interrumpe ;
  } finis ;
  si (i == 1) {
    perge ;
  } finis ;
} 
FINIS ;
