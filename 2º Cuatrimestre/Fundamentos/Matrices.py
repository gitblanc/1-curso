#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      blanc
#
# Created:     09/06/2021
# Copyright:   (c) blanc 2021
# Licence:     <your licence>
#-------------------------------------------------------------------------------

def matriz(m,n):
    for i in range (m):
        for j in range (n):
            print(" ª ", end="")
        print("\n")


def persistencia_aditiva_y_raiz_digital(n):
    cont=0
    while n > 9:
        suma = 0
        cont+=1
        for digito in str(n):
            suma+=int(digito)
        n=suma
    return cont,suma



def main():
    pass
"""
    x=int(input("Introduce el num de filas"))
    y=int(input("Introduce el num de columnas"))
    while x < 0 or y < 0:
        x=int(input("Introduce el num de filas"))
        y=int(input("Introduce el num de columnas"))
    matriz(x,y)#llama a la funcion
"""
num=2089
persist, raiz= persistencia_aditiva_y_raiz_digital(num)
print("La persist. aditiva es: {}, y su raíz digital es: {}".format(persist,raiz))


if __name__ == '__main__':
    main()
