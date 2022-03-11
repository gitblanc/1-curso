matriz=[["a","b","c","d"],["e","f","g","h"],["i","j","k","l"]]

for i in range(len(matriz)):#RECORRE LAS LISTAS
    for j in range(len(matriz[i])):#RECORRE LAS SUBLISTAS
        if matriz[i][j]=="f":
            matriz[i][j]="X"
        print(matriz[i][j],end=" ")

    print()#METE UN SALTO DE LÍNEA



#print(matriz[0][1])#DEL ELEMENTO [X] AL ELEMENTO [Y]

