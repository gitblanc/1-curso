
package lexico;
import java.io.InputStreamReader;
import java.lang.System;
import sintactico.sym;
import java_cup.runtime.Symbol;
%%
%char
%public
%cup
%full
%type java_cup.runtime.Symbol

DIGITO = [0-9]
LETRA = [a-zA-Z]
ALFANUM = ({LETRA}|{DIGITO})
SIGNO = (\+|\-)
BLANCO = (" "|\t)
TEXTO = ({ALFANUM}|{SIMBOLOS}|{BLANCO})
SIMBOLOS = [+*/()-]
COMENTARIO = "//"{TEXTO}+
ENTERO = {SIGNO}?{DIGITO}+
REAL = {ENTERO}\.{DIGITO}+
VAR = [a-z]{ALFANUM}*(\_?{ALFANUM}+)*
CAD = \" {TEXTO}* \"

%%
; {System.out.print(" FinSentencia"); return new Symbol(sym.fin_sent);}
\+ {System.out.print(" Mas"); return new Symbol(sym.mas);}
\* {System.out.print(" Por"); return new Symbol(sym.por);}
\/ {System.out.print(" Entre"); return new Symbol(sym.entre);}
\( {System.out.print(" Abrepar"); return new Symbol(sym.abrepar);}
\) {System.out.print(" Cierrapar"); return new Symbol(sym.cierrapar);}
":=" {System.out.print(" Asigna"); return new Symbol(sym.asigna);}
"+=" {System.out.print(" Adicion"); return new Symbol(sym.masigual);}
"++" {System.out.print(" Incremento"); return new Symbol(sym.masmas);}
\- {System.out.print(" Menos"); return new Symbol(sym.menos);}
\> {System.out.print(" Mayor"); return new Symbol(sym.mayor);}
\< {System.out.print(" Menor"); return new Symbol(sym.menor);}
\=\= {System.out.print(" Igual"); return new Symbol(sym.igual);}
\>\= {System.out.print(" MayoroIgual"); return new Symbol(sym.mayoroigual);}
\<\= {System.out.print(" MenoroIgual"); return new Symbol(sym.menoroigual);}
inicio {System.out.print(" Palabra_reservada(inicio)"); return new Symbol(sym.inicio);}
fin {System.out.print(" Palabra_reservada(fin)"); return new Symbol(sym.fin);}
imprime {System.out.print(" Palabra_reservada(imprime)"); return new Symbol(sym.imprime);}
{ENTERO} {System.out.print(" Entero("+yytext()+")"); return new Symbol(sym.entero, new Double(yytext()));}
{REAL} {System.out.print(" Real("+yytext()+")"); return new Symbol(sym.real, new Double(yytext()));}
{VAR} {System.out.print(" Variable("+yytext()+")"); return new Symbol(sym.variable, yytext());}
{COMENTARIO} {System.out.print(" Comentario("+yytext()+")");}
{CAD} {System.out.print(" Cadena("+yytext()+")"); return new Symbol(sym.cadena, yytext());}
{BLANCO}+ { }
\n {System.out.print(yytext());}
. {System.out.print(" ERROR_Lexico");}
