def extrae_negativos(lista):
    # creación de la lista de negativos
    negativos=[x for x in lista if x<0]
    # se quitan de la original los negativos
    [lista.remove(x) for x in negativos]
    # se devuelven los negativos
    return negativos

mi_lista=[10,11,-7,4.5,-2,-2,6.3,8,-1]
print("mi lista antes",mi_lista)
negativos=extrae_negativos(mi_lista)
print("mi lista después",mi_lista)
print("negativos",negativos)

