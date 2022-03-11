def inserta_ceros(lista):
    # se crea una lista nueva insertando los ceros antes de los negativos
    nueva=[]
    for elemento in lista:
        if elemento<0:
            nueva.append(0)
        nueva.append(elemento)
    # se reemplaza el contenido de la original por el de la nueva
    lista[:]=nueva

mi_lista=[10,11,-7,4.5,-2,-2,6.3,8,-1]
print("lista antes:",mi_lista)
inserta_ceros(mi_lista)
print("lista después:",mi_lista)