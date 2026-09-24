import lib.math.ops
VARIABILES>
esto edad : numerus 20 ;
series notas[3] : numerus {8, 9, 10} ;
esto perro1 : novus Perro() ;
// ERROR 1: serie sin cerrar la llave
series mala[2] : numerus {1, 2 ;
// ERROR 2: elementos de struct sin comas
esto malo : Punto {10 20} ;
MAIOR>
>> "Empieza bien" ;
edad = 21 ;
// ERROR 3: falta el ';' final en la asignacion
edad = 22
>> "Esta linea sigue al error 3" ;
// ERROR 4: aliter intermedio sin '()' (solo el ultimo puede ir sin parentesis)
si (edad > 18) {
  >> "mayor" ;
} aliter {
  >> "medio" ;
} aliter (edad == 10) {
  >> "diez" ;
} finis ;
// ERROR 5: lectura con ';' (la gramatica es ID? '<<' sin ';')
<< ;
// ERROR 6: lectura con ';' (la gramatica es ID? '<<' sin ';')
nombre << ;
// ERROR 7: dum sin 'finis ;' de cierre
dum (edad < 25) {
  edad = edad + 1 ;
}
// ERROR 8: per sin 'esto' en el inicializador
per (i : numerus 0 ; i < 5 ; i++) {
  >> i ;
}
// ERROR 9: imprimir sin ';' final
>> "falta punto y coma"
FINIS ;
