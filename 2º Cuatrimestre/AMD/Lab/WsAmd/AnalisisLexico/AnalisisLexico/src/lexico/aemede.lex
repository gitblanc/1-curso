/* Fichero: ejemplo.lex */
package lexico;
import java.io.InputStreamReader;
import java.lang.System;
%%
%char
%public
%standalone
%full

%%
; {System.out.print(" FinSentencia");}
\+ {System.out.print(" Mas");}
\- {System.out.print(" Menos");}
imprime {System.out.print(" Palabra_reservada(imprime)");}
" " { }
\n {System.out.print(yytext());}
. {System.out.print(" ERROR_Lexico");}
