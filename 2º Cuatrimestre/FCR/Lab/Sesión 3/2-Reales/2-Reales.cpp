#include <iomanip>
#include <iostream>
using namespace std;

float f = -27.625;
float f1 = 0.1;
float f2 = 0.3;
const float TOLERANCIA = 0.0000001;

float euros = 0;
const int UN_MILLON = 1000000;

float f3 = 19 * UN_MILLON;

char c1 = 'a';
char c2 = 0xf1;
int main()
{
	cout << "El número en decimal es: " << f << endl;

	cout << "El número en decimal 1 REDOND es: " << setprecision(15) << f1 << endl;
	cout << "El número en decimal 2 REDOND es: " << setprecision(15) << f2 << endl;

	if (fabs(f1 * 3 - f2) < TOLERANCIA) {
		cout << "Son iguales" << endl;
	}
	else{
		cout << "Son distintos" << endl;
	}


	for (int i = 0; i < 20 * UN_MILLON; i++) 
		euros += 1;
	cout << "Euros = " << euros << endl;

	cout << "f3: " << setprecision(15) << f3 << endl;
	f3 += 1;
	cout << "f3 + 1: " << setprecision(15) << f3 << endl;

	cout << c1 << " " << c2 << endl;
	return 0;
}
