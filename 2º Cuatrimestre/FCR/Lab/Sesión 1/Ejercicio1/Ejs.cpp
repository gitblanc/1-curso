/* -Crea un programa que defina dos vectores de 6 enteros. Inicialízalos con valores aleatorios, 
la mitad positivos y la mitad negativos. 
- El programa debe contener una función que reciba un vector de enteros y su longitud y ponga a 
cero los elementos negativos. 
- El programa principal debe llamar a esta función para los dos vectores. Deben imprimirse los 
vectores antes y después de modificarlos.*/
#include <iostream>

using std::cout;
using std::endl;

void zeros(int vector[], unsigned int longVect) {
	unsigned int i;
	for (i = 0; i < longVect; i++) {
		if (vector[i] < 0) {
			vector[i] = -vector[i];
		}
	}
}

void imprimeVector(int vector[], unsigned int longVect) {

	unsigned int i;
	for (i = 0; i < longVect; i++) {
		cout << vector[i] << " ";
	}
	cout << endl;
}

int main() {

	const unsigned int longVects = 6;
	int vect1[longVects] = { 1,2,3,-1,-2,-3 };
	int vect2[longVects] = { 4,5,6,-4,-5,-6 };
	printf("El vector 1 inicialmente era: ");
	imprimeVector(vect1, longVects);
	printf("El vector 2 inicialmente era: ");
	imprimeVector(vect2, longVects);

	zeros(vect1, longVects);
	printf("El vector 1 tras cambiar los negativos es: ");
	imprimeVector(vect1, longVects);

	zeros(vect2, longVects);
	printf("El vector 2 tras cambiar los negativos es: " );
	imprimeVector(vect2, longVects);
	
}