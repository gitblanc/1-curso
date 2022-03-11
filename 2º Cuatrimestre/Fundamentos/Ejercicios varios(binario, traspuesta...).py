#-------------------------------------------------------------------------------
# Name:        module2
# Purpose:
#
# Author:      blanc
#
# Created:     11/06/2021
# Copyright:   (c) blanc 2021
# Licence:     <your licence>
#-------------------------------------------------------------------------------

def capitalizada(cadena):
    palabras = cadena.split(" ")
    result=""
    for i in range(len(palabras)):
       palabras[i] = palabras[i].capitalize()

    for j in range(len(palabras)):
        result = result + palabras[j] + " "

    return result


def lenguaje_leet(cad):
    cadena=""
    for i in cad:
        if(i in ["a","A"]):
            cadena += "4"
        elif(i == "e" or i=="E"):
            cadena += "3"
        elif(i == "i" or i=="I"):
            cadena += "1"
        elif(i == "o" or i=="O"):
            cadena += "0"
        else:
            cadena+=i
    return cadena

def binario(num):
    while num < 0:
        int(input("Introduce un número entero no negativo: "))

    if(num == 0):
        return "0"
    binario=""
    result=""
    while num > 0:
        resto=num%2
        num=num//2
        binario+=str(resto)


    for i in range(len(binario)-1, -1, -1):
        result+=binario[i]
    return result


    """
    result = ""
 if n == 0:
 return "0"
 while n > 0:
 result = str(n % 2) + result
 n = n // 2
 return result
    """

def matriz_traspuesta(matriz):
    result=[]

    for j in range(len(matriz[0])):
        fila = []
        for i in range(len(matriz)):
            fila.append(matriz[i][j])
        result.append(fila)
    return result

def main():
    pass

"""
    cadena = "hay más de 50 trabajadores en Google"
    cadCap = capitalizada(cadena)
    print (cadCap)

    cadena2 = "de vuelta a Internet de los años ochenta"
    print (lenguaje_leet(cadena2))


    x = int(input("Introduce un número entero no negativo: "))
    print(binario(x))
"""
matriz=[[0, 1, 2, 3], [4, 5, 6, 7], [8, 9, 10, 11]]
print(matriz_traspuesta(matriz))
if __name__ == '__main__':
    main()
