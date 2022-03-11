/*Crea un programa que defina dos cadenas e imprima el n�mero de vocales y el n�mero de consonantes que tienen.
Para ello debe utilizar una funci�n que realice el c�lculo.*/
#include <iostream>

using std::cout;
using std::endl;



void cuentaVocales(char cadena[], unsigned int longCads) {
	unsigned int i;
	int cont = 0;
	for (i = 0; i < longCads; i++) {
		if (cadena[i] == char("a" || "e" || "i" || "o" || "u" || "�" || "�" || "�" || "�" || "�" || "A" || "E" || "I" || "O" || "U" || "�" || "�" || "�" || "�" || "�")) {
			cont++;
		}
	}
	cout << cont << endl;
}

void cuentaConsonantes(char cadena[], unsigned int longCads) {
	unsigned int i;
	int cont = 0;
	for (i = 0; i < longCads; i++) {
		if (cadena[i] != char("a" || "e" || "i" || "o" || "u" || "�" || "�" || "�" || "�" || "�" || "A" || "E" || "I" || "O" || "U" || "�" || "�" || "�" || "�" || "�")) {
			cont++;
		}
	}
	cout << cont << endl;
}

int main() {
	char cad1[] = "Patata";
	char cad2[] = "Pepito";
	const unsigned int longCads = 6;

	cout << "Num de vocales de cadena 1: ";
	cuentaVocales(cad1, longCads);
	cout << "Num de consonantes de cadena 1: ";
	cuentaConsonantes(cad1, longCads);

	cout << "Num de vocales de cadena 2: ";
	cuentaVocales(cad2, longCads);
	cout << "Num de consonantes de cadena 2: ";
	cuentaConsonantes(cad2, longCads);
}