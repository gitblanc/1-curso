def inserta_ceros(lista):
    # modifica la lista insertando un cero delante de cada numero negativo
    i=0 # indice del primer elemento de la lista
    while i<len(lista):
        if lista[i]<0: # si es negativo se inserta un cero
            lista.insert(i,0)
            i=i+1 # hay que saltar el cero insertado
        i=i+1 # se pasa al siguiente elemento de la lista

mi_lista=[10,11,-7,4.5,-2,-2,6.3,8,-1]
print("lista antes:",mi_lista)
inserta_ceros(mi_lista)
print("lista después:",mi_lista)