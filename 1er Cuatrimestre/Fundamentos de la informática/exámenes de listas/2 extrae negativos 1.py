def extrae_negativos(lista):
    # creación de la lista de negativos
    negativos=[]
    for elemento in lista:
        if elemento<0:
            negativos.append(elemento)
    # se quitan de la original los negativos
    for negativo in negativos:
        lista.remove(negativo)
    # se devuelven los negativos
    return negativos

mi_lista=[10,11,-7,4.5,-2,-2,6.3,8,-1]
print("mi lista antes",mi_lista)
negativos=extrae_negativos(mi_lista)
print("mi lista después",mi_lista)
print("negativos",negativos)

