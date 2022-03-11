def inserta_ceros(lista):
    # se crea una lista nueva insertando los ceros antes de los negativos
    otra=[]
    [(otra.append(0),otra.append(x)) if x<0 else otra.append(x) for x in lista]
    # se reemplaza el contenido de la original por el de la nueva
    lista[:]=otra

mi_lista=[10,11,-7,4.5,-2,-2,6.3,8,-1]
print("lista antes:",mi_lista)
inserta_ceros(mi_lista)
print("lista después:",mi_lista)