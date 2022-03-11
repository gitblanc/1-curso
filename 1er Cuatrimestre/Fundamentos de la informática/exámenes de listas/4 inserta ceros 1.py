def inserta_ceros(lista):
    # se empieza por el final de la lista para no alterar el orden
    for i in range(len(lista)-1,-1,-1):
        # si hay un negativo se inserta un cero
        if lista[i]<0:
            lista.insert(i,0)

mi_lista=[10,11,-7,4.5,-2,-2,6.3,8,-1]
print("lista antes:",mi_lista)
inserta_ceros(mi_lista)
print("lista después:",mi_lista)