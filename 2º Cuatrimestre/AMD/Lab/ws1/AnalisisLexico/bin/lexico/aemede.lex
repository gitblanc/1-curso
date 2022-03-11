/* Fichero: ejemplo.lex */
package lexico;
import java.io.InputStreamReader;
import java.lang.System;

%%

%char
%public
%standalone
%full

UO = ([Uu][Oo])
NUMEROS = [0-9]
NUMEROSUO = ({NUMEROS}{NUMEROS}{NUMEROS}{NUMEROS}{NUMEROS}?{NUMEROS}?)
NUMEROSUO2 = {NUMEROS}{4,6} 

ID= ({UO}{NUMEROSUO})

LETRAS = [a-zA-Z]
DOMINIO = (@uniovi\.(es|com))
LETRASYNUMS = ({LETRAS} | {NUMEROS})
NOMBREUSUARIO = {LETRAS}(\.?{LETRASYNUMS})*
SIGNO = (\+|\-)?
CORREOS = ({NOMBREUSUARIO}{DOMINIO}) 

LOCONTRARIONOT = [^] 

ENTEROS = {SIGNO}{NUMEROS}+ 
REALES =  {ENTEROS},{NUMEROS}*

MINUSCULA = [a-z]
MAYUSCULA = [A-Z]
VARIABLE = ({MINUSCULA}+\_?{LETRASYNUMS}*)

SIMBOLOS = "+"*"-"*"*"*"/"*"("*")"*" "*

CADENADOBLE = (\"({LETRASYNUMS}*{SIMBOLOS})*\")
CADENASIMPLE = (\'({LETRASYNUMS}*{SIMBOLOS})*\')
CADENA = ({CADENASIMPLE}|{CADENADOBLE})

LINEA = {SIMBOLOS}+
DOBLEBARRA = ("//"" ")
COMENTARIO = ({DOBLEBARRA}({LETRASYNUMS}*{SIMBOLOS})*)

CODIGOPAIS = "+"{NUMEROS}{NUMEROS}?
BLOQUENUMS = {NUMEROS}{3}
TELEFONO = ({CODIGOPAIS}"-")?({BLOQUENUMS}"-")?{BLOQUENUMS}"-"{BLOQUENUMS}


NUMSIN0 = [1-9]
NUMEROCHASIS = (A|B)((A|B)(A|B))*{NUMSIN0}{NUMEROS}*

GRUPOCUENTAS = "("{NUMEROS}+("-"{NUMEROS}+)*")"

VOCALES = [AEIOU]
ESTADOSUNIDOS = {VOCALES}{NUMEROS}{3}

NUMSYMAYS = {NUMEROS} | {MAYUSCULA}
CUENTAEMPRESA = {NUMSYMAYS}*{MINUSCULA}{NUMSYMAYS}*{MINUSCULA}{NUMSYMAYS}*0

JKLMAY = [JKL]
JKLMIN = [jkl]
DEL1AL5 = [1-5]
NUMS = {DEL1AL5}{DEL1AL5}?{DEL1AL5}?{DEL1AL5}?{DEL1AL5}?
JKL = {JKLMAY}{3}|{JKLMIN}{3}
JKLNUMS = {JKL}{NUMS}

EJERCICIO1 = {JKLNUMS}(";"{NUMS})*


ESPACIOSYNUMS = ";"{NUMS}" "+

EJERCICIO2 = "["{JKLNUMS}({ESPACIOSYNUMS}{JKLNUMS})*"]"

%%

; {System.out.print("FinSentencia");}
\+ {System.out.print("Mas");}
\- {System.out.print("Menos");}
imprime {System.out.print("Palabra_reservada(imprime)");}
inicio {System.out.print("Palabra_reservada(inicio)");}
fin {System.out.print("Palabra_reservada(fin)");}
" " { }
\n {System.out.print(yytext());}



{ID} {System.out.print("Uo");}



{ENTEROS} {System.out.print("Entero("+yytext()+")");}

{REALES} {System.out.print("Real("+yytext()+")");}

{CORREOS} {System.out.print("Correo correcto");}

{EJERCICIO1} {System.out.print("Ejercicio1("+yytext()+")");}

{VARIABLE} {System.out.print("Variable("+yytext()+")");}

{CADENA} {System.out.print(" Cadena("+yytext()+")");}

{COMENTARIO} {System.out.print("Comentario("+yytext()+")");}

\* {System.out.print("Por");}
\/ {System.out.print("Entre");}
\( {System.out.print("Abre-Par");}
\) {System.out.print("Cierra-Par");}
\:= {System.out.print("Asigna");}

{TELEFONO} {System.out.print("Telefono("+yytext()+")");}

{NUMEROCHASIS} {System.out.print("Numerochasis("+yytext()+")");}

{GRUPOCUENTAS} {System.out.print("GrupoCuentas("+yytext()+")");}

{ESTADOSUNIDOS} {System.out.print("EstadosUnidos("+yytext()+")");}

{CUENTAEMPRESA} {System.out.print("CuentaEmpresa("+yytext()+")");}

{EJERCICIO2} {System.out.print("Ejercicio2("+yytext()+")");}

. {System.out.print(" ERROR_Lexico");}
