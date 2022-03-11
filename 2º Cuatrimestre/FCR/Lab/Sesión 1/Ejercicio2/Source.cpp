/*Crea un programa que defina dos cadenas e imprima el número de vocales y el número de consonantes que tienen.
Para ello debe utilizar una función que realice el cálculo.*/
#include <iostream>

using std::cout;
using std::endl;



void cuentaVocales(char cadena[], unsigned int longCads) {
	unsigned int i;
	int cont = 0;
	for (i = 0; i < longCads; i++) {
		if (cadena[i] == char("a" || "e" || "i" || "o" || "u" || "á" || "é" || "í" || "ó" || "ú" || "A" || "E" || "I" || "O" || "U" || "Á" || "É" || "Í" || "Ó" || "Ú")) {
			cont++;
		}
	}
	cout << cont << endl;
}

void cuentaConsonantes(char cadena[], unsigned int longCads) {
	unsigned int i;
	int cont = 0;
	for (i = 0; i < longCads; i++) {
		if (cadena[i] != char("a" || "e" || "i" || "o" || "u" || "á" || "é" || "í" || "ó" || "ú" || "A" || "E" || "I" || "O" || "U" || "Á" || "É" || "Í" || "Ó" || "Ú")) {
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