#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      blanc
#
# Created:     31/05/2021
# Copyright:   (c) blanc 2021
# Licence:     <your licence>
#-------------------------------------------------------------------------------
def distance(listaA, listaB):

    diflistas = abs(len(listaA) - len(listaB))

    cont = 0
    for i in range (min(len(listaA), len(listaB))):
        if listaA[i] != listaB[i]:
            cont+=1

    return diflistas + cont


def extrae_negativos(negativos):
    listaNegs = []

    for neg in negativos:
        if(neg < 0):
            listaNegs.append(neg)

    for neg in listaNegs:
        negativos.remove(neg)

    return listaNegs

def ordenada(lista):

    for i in range (1,len(lista)):
        if lista[i] < lista[i-1] :
            return False

    return True


def inserta_ceros(ceros):

    for i in range (len(ceros) - 1, -1, -1):

        if (ceros[i] < 0):
            ceros.insert(i, 0)


def main():
    pass

    listaA = [1.9,1.4,1.2,0,1.7]
    listaB = [1.7,1.4,0.1,0,1.7]

    listaC = [1.9,1.7,0,1.9,1.4]
    listaD = [1.2,2,0.4,1.1,0]

    print(distance(listaA, listaB))
    print(distance(listaC, listaD))

    negs = [10,11,-7,4.5,-2,-2,6.3,8,-1]

    print(negs)
    print(extrae_negativos(negs))
    print(negs)


    ordenada1 = [9,11,10,20]
    ordenada2 = ["Ana","Juan","Teresa"]

    print(ordenada(ordenada1))
    print(ordenada(ordenada2))


    ceros = [10,11,-7,4.5,-2,-2,6.3,8,-1]
    print(ceros)
    inserta_ceros(ceros)
    print(ceros)

if __name__ == '__main__':
    main()
