#include <iostream>
#include <stdlib.h>
#include <wchar.h>
#include <locale.h>
#include <string>
#include <stdio.h>
#include <cstring>
#include <bitset>

using std::cout;
using std::endl;
using std::cin;
using std::string;
using std::bitset;

const unsigned int maxChars = 21;
char cad[] = "2fYdfR91";
char i[maxChars];
char x[maxChars];

const unsigned int maxBits = 33;
unsigned int num1;
unsigned int num2;
unsigned int num3;

int nums[maxBits];

extern "C" bool IsValidAssembly(int a, int b, int c);

void CheckChars() {

    cout << "Introduce una cadena de caracteres: " << endl;
    cin.getline(i, maxChars);

    if (strlen(i) < 10 || i[9] != i[3]) {
        cout << "Intruso detectado" << endl;
        exit(-1);
    }
    else {
        cout << "Introduce otra cadena de caracteres: " << endl;
        cin.getline(x, maxChars);

        if (strcmp(x, cad) != 0) {
            cout << "¡Alto ahí!" << endl;
            exit(-1);
        }
    }
}


void ControlWithBits() {
    cout << "Introduce un número entero de 32 bits: " << endl;
    cin >> num1;
    cout << "Introduce otro número entero de 32 bits: " << endl;
    cin >> num2;

    int num2_memoria = (num2 & 0x000000f0) >> 5;
    int num1_memoria = (num1 & 0x0000000f) >> 3;

    int num1_suma = (num1 & 0xfffff000);
    int num2_suma = (num2 & 0x00000fff);

    int valor = 25937;
    int suma = num1_suma + num2_suma;

    if (num2_memoria != 0) {
        cout << "Algo fue mal" << endl;
        exit(-1);
    }
    
    else if (num1_memoria != 0) {
        cout << "Entrada incorrecta" << endl;
        exit(-1);
    }
    else if (suma < valor) {
        cout << "Hubo algún fallo" << endl;
        exit(-1);
    }


}


void ControlInAssembly() {
    cout << "Introduce un número entero de 32 bits: " << endl;
    cin >> num1;
    cout << "Introduce otro número entero de 32 bits: " << endl;
    cin >> num2;
    cout << "Introduce el tercer número entero de 32 bits: " << endl;
    cin >> num3;

    int num1_fun = (num1 & 0x000000ff);
    int num2_fun = (num2 & 0x00000002) >> 1;
    int num3_fun = (num3 & 0x00800000) >> 23;

    bool result = IsValidAssembly(num1_fun, num2_fun, num3_fun);
    if (!result)
    {
        cout << "Acceso incorrecto" << endl;
    }
}



void InlineAssemblyControl()
{
    cout << "Introduce un número entero de 32 bits: " << endl;
    cin >> num1;
    int numero_16_primeros = (num1 & 0x0000ffff);
    int numero_16_ultimos = (num1 & 0xffff0000) >> 16;

    int result;

    __asm {
        mov ebx, numero_16_primeros
        mov ecx, numero_16_ultimos

        cmp ebx,ecx
        jnz correcto
        jz incorrecto

        correcto:
        mov result,1
        jmp fin
        
        incorrecto:
        mov result, 0

        fin:
    }

    if (result == 0) {
        cout << "Acceso incorrecto" << endl;
        exit(-1);
    }
}


int main()
{
    setlocale(LC_ALL, "");
    CheckChars(); 
    ControlWithBits();
    ControlInAssembly();
    InlineAssemblyControl();
    return 0;
}



