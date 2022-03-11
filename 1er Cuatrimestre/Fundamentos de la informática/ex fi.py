from random import *
from math import *

def esPrimo(a):
    """ Programa que comprueba si el numero introducido es primo"""
    if a == 1:
        return "No es primo"
    for i in range (2, a):
        if a%i == 0:
            return "No es primo"
    return "Es primo"

print(esPrimo(2))


def esPerfecto(b):
    """ Programa que comprueba si el numero introducido es perfecto"""
    suma = 0
    for i in range(1, b):
        if b % i == 0:
            suma = suma + i
    if suma == b:
        return "Es perfecto"
    return "No es perfecto"


print(esPerfecto(2))

def compruebaPremio(n, p):
    """ La funcion genera un numero aleatorio entre 0.0 y 1.0, y retorna True en caso de que ese número sea
    menor que el dado p y además n sea primo o perfecto. En caso contrario devuelve False"""
    x = random()
    print (x)
    if (x < p) and (esPrimo(n) == "Es primo" or esPerfecto(n) == "Es perfecto"):
        return True
    else:
        return False


print(compruebaPremio(2, 0.3))


def probarSuerte(n):
    """ Recibe un entero en un rango de [0,100]. La función genera un número aleatorio en dicho rango
    y devolverá True si es igual que el entero recibido, False en caso contrario. """
    x = randint(0,101)
    print (x)
    if x == n:
        return True
    else:
        return False

print(probarSuerte(3))

def distancia(palabra1,palabra2):
    """ Programa que calcula la distancia entre dos palabras"""
    count = 0
    lista1 = []
    lista2 = []
    if len(palabra1) == len(palabra2):
        for i in palabra1:
            lista1.append(i)
        for j in palabra2:
            lista2.append(j)
        for i in range (len(palabra1)):
            if lista1[i] != lista2[i]:
                count = count + 1
        total = count
    else:
        difLen = len(palabra1) - len(palabra2)
        for i in palabra1:
            lista1.append(i)
        for j in palabra2:
            lista2.append(j)
        if len(palabra1) < len(palabra2):
            for i in range (len(palabra1)):
                if lista1[i] != lista2[i]:
                    count = count + 1
        else:
            for i in range (len(palabra2)):
                if lista1[i] != lista2[i]:
                    count = count + 1
        total = difLen + count
    print ("La distancia entre " + str(palabra1) + " y " + str(palabra2) + " es " + str(total) + ".")

distancia("cabalgar", "caballo")



def unionFicheros(a,b,c):
    """ Une dos ficheros introducidos en uno solo llamado "agenda"."""
    f = open(a + ".txt", "w")
    f2 = open(b + ".txt", "r")
    f3 = open(c + ".txt", "r")
    lineas1 = f2.readlines()
    lineas2 = f3.readlines()
    f2.close()
    f3.close()
    for i in lineas1:
        for j in lineas2:
            f.write(i.strip() + 5*"\t" + j + "\n")
    f.close()
    return f


print(unionFicheros("agenda","nombres","telefonos"))







