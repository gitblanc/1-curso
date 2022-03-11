#include <iostream>
using namespace std;

int main()
{
	int a = 0, b = 0;
	printf("Ingrese el valor de a: ");
	scanf("%d", &a);
	printf("Ingrese el valor de b: ");
	scanf("%d", &b);

	int c = a + b;
	int d = a/2 + b/2;

	cout << "a: " << a << " b: " << b << endl;

	if ((a > 0 && b > 0 && c < 0) || (a < 0 && b < 0 && c > 0)) {
		cout << "Se ha producido un desbordamiento." << endl;
	}
	else {
		cout << "La suma de a y b es:" << c << endl;
	}

	cout << "El valor de la media entre a y b es: " << d << endl;

	const int UN_MILLON = 1000000;
	int contador = 0;
	for (int i = 0; i < 3000 * UN_MILLON; i++)
		contador++;
	cout << "contador " << contador << endl;

	return 0;
}