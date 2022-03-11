def distancia(lista1,lista2):

    dist = abs(len(lista1) - len(lista2))
    suma=0

    for i in range(min(len(lista1),len(lista2))):
        if lista1[i] != lista2[i]:
            suma = suma + 1
    total=dist+suma
    return total

def extrae_negativos(lista):
    negativos=[]
    positivos=[]
    for i in lista:
        if i < 0:
            negativos.append(i)
        else:
            positivos.append(i)
    lista=positivos
    return lista,negativos
    """OTRA MANERA DE ELIMINAR NEGS DE LISTA
    for negativo in negativos:
        lista.remove(negativo)
    # se devuelven los negativos
    return negativos
    """

def ordenada(lista):

    for i in range(1,len(lista)):
        if lista[i] < lista[i-1]:
            return False
    return True

def inserta_ceros(lista):
    i=0
    while i<len(lista):
        if lista[i]<0:
            lista.insert(i,0)
            i=i+1#se salta el cero
        i=i+1#se pasa al siguiente elemento




def main():
    pass
    """1
    x=[0.2,0,0.1,0,1.1,0.6,0,1.7]
    y=[0.2,0,0.1,0,1.1,1.1,1.4]
    print("La distancia entre {} y {} es: {}".format(x,y,distancia(x,y)))
    """

    """2
    x=[10,11,-7,4.5,-2,-2,6.3,8,-1]
    x1,x2=extrae_negativos(x)

    print("Lista sin negativos: {}".format(x1))
    print("Lista de negativos: {}".format(x2))
    """

    """3
    x=[9,11,10,20]
    y=["Ana","Juan","Teresa"]
    print(ordenada(x),ordenada(y))
    """
    """4
    x=[10,11,-7,4.5,-2,-2,6.3,8,-1]
    inserta_ceros(x)
    print(x)
    """
if __name__ == '__main__':
    main()
