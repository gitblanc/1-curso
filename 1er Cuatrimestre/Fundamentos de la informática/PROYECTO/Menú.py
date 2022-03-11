#-------------------------------------------------------------------------------
# Name:     Menú
#
# Purpose:  Este módulo comprende el menú desde el cual se ejecutará el
#           programa, llamando a los demás módulos en función de la opción
#           introducida por el usuario, siempre que sea válida.
#
# Authors:  Guillermo Pulido Fernández, Antonio Castro Álvarez,
#           Eduardo Blanco Bielsa
#
# Created:  28/12/2020
#-------------------------------------------------------------------------------

import M1
import M2
import M3
import time

def main():
    a = 1   #Se crea una variable a para que entre en el bucle del menú
    while a > 0 and a <= 2:
        print()
        print("1- Introducir un mensaje a codificar")
        print("2- Decodificar el mensaje codificado")
        print("0- Salir")
        print()
        a = int(input("Introduce una opción: "))
        while a < 0 or a > 2:
            print("Error: opción no válida")
            a = int(input("Introduce una opción: "))
        print("-"*100)
        time.sleep(2)   #Esta función se usa para que se ralentice la ejecución
                        #del código
        if a == 1:
            M1.main()
            time.sleep(5)

        elif a == 2:
            M2.main()
            time.sleep(5)
        else:
            print("Saliendo...")
            time.sleep(2)


if __name__ == '__main__':
    main()

