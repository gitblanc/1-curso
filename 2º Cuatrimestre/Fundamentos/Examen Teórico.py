#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      blanc
#
# Created:     17/06/2021
# Copyright:   (c) blanc 2021
# Licence:     <your licence>
#-------------------------------------------------------------------------------
def multiplos(lista, valor1, valor2):
    listaFinal=[]
    for i in range(len(lista)):
        if lista[i]%valor1 != 0 and i%valor2 != 0:
            listaFinal.append(lista[i])
    return listaFinal

def suma_matriz_filas(m):
    listaFinal = []
    suma = 0
    for i in range(len(m)):
        suma=0
        for j in range(len(m[i])):
            suma+=m[i][j]

        listaFinal.append(suma)
    return listaFinal

def cadena(cadena):
    caracter = ""
    cont=0
    aux = 0
    for i in cadena:
        aux = cadena.count(i)
        if(aux > cont):
            cont = aux
            caracter = i

    return caracter,cont

def fichero(fileName):
    f=open(fileName,"r")
    datos=f.readlines()
    media=0
    suma=0
    cont=0
    for i in range(len(datos)):
        suma+=datos[i]
        cont+=1
    media=suma/cont

    valor1=datos[0]
    valor2=datos[1]
    diferencia1 = abs(media - valor1)
    diferencia2 = abs(media - valor2)
    listaFinal=[]
    i=2
    for i in range(len(datos)):
        difi = abs(media - datos[i])
        if(difi > diferencia1) and (difi < diferencia2):
            diferencia1=difi
            valor1 = datos[i]
        elif(difi < diferencia1) and (difi > diferencia2):
            diferencia2 = difi
            valor2 = datos[i]
    listaFinal.append(valor1)
    listaFinal.append(valor2)
    f.close()

    return listaFinal

def main():
    pass
    lista=[0,1,2,3,4,5,6,7]
    valor1=2
    valor2=3
    print(multiplos(lista, valor1,valor2))

    matriz=[(1,1,1),(1,2,3)]
    print(suma_matriz_filas(matriz))

    cad= "Había una vez una puta llamada Juan"
    letra,num =cadena(cad)
    print("Caracter: {} y num de veces: {}".format(letra, num))

if __name__ == '__main__':
    main()
