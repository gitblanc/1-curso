#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      blanc
#
# Created:     14/06/2021
# Copyright:   (c) blanc 2021
# Licence:     <your licence>
#-------------------------------------------------------------------------------

def naturales(lista):
    cont=0
    for i in range(len(lista)):
        if lista[i] > 0 and lista[i]%2==0:
            cont+=1
    return cont

def naturales_y_sustituye_negativos(lista):
    cont=0
    for i in range(len(lista)):
        if lista[i] > 0 and lista[i]%2==0:
            cont+=1
            lista[i] = -lista[i]
    return cont

def naturales_y_sustituye_negativos_y_devuelve_lista(lista):
    cont=0
    np=[]
    for i in range(len(lista)):
        if lista[i] > 0 and lista[i]%2==0:
            cont+=1
            np.append(lista[i])
            lista[i] = -lista[i]

    return cont, np

def fibonacci(num):

    fibo=[]

    for i in range(num):
        if(i==0):
            fibo.append(0)
        elif(i==1):
            fibo.append(1)
        else:
            res=fibo[i-1] + fibo[i-2]
            fibo.append(res)
    print(fibo)

def main():
    pass

    enteros = [-2, 6, -6, 7, 1, 0, 4, 12]
    """
    print("La lista contiene {} números naturales positivos.".format(naturales(enteros)))
    print("La lista tras llamar a la función es {}".format(enteros))
    print("")

    print("La lista contenía {} números naturales positivos".format(naturales_y_sustituye_negativos(enteros)))
    print("La lista tras llamar a la función es {}".format(enteros))
    print("")

    nums,lista = naturales_y_sustituye_negativos_y_devuelve_lista(enteros)
    print("Los números reemplazados han sido {}, que son {}".format(nums,lista))
    print("La lista tras llamar a la función es {}".format(enteros))
    """
    fibonacci(int(input("Introduce un número de iteraciones")))
if __name__ == '__main__':
    main()
