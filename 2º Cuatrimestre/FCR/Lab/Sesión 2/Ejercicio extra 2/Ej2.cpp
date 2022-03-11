#include <iostream>
using namespace std;

int main() 
{
	int a = 0, b = 0;
	printf("Ingrese el valor de a: ");
	cin >> a;
	printf("Ingrese el valor de b: ");
	cin >> b;

	int c = a - b;
	if ((a > 0 && b < 0 && c < 0) || (a < 0 && b > 0 && c > 0)) {
		cout << "Se ha producido un desbordamiento." << endl;
	}
	else {
		cout << "La diferencia de a y b es:" << c << endl;
	}

	int cont = 0;
	unsigned int i;
	for (i = 1; i < 1000001; i++) 
	{
		if (i % 3 == 0) {
			cont += i;
			cout << cont;
		}
	}


	return 0;
}

