"""
Escribir una funcion que reciba 3 parámetros. Los dos primeros representan el
num de filas y columnas de una matriz. El tercero, el valor inicial de los
elementos de la matriz. La función devuelve una lista de listas que representa esa matriz,
cada elemento de la matriz igual al tercer parámetro de la funcion.
"""

def inicializaMatriz(row, column, value):
    a=[None]*row

    for i in range(row):
        a[i]=[value]*column
    return a

def suma_matrices(matriz1, matriz2):

    matrizFinal=inicializaMatriz(len(matriz1), len(matriz1[0]), 0)

    for i in range(len(matriz1)):
        for j in range(len(matriz1[0])):
            matrizFinal[i][j] = matriz1[i][j] + matriz2[i][j]
    print(matrizFinal)


def main():
    pass
    ma=inicializaMatriz(int(input("Fila")),int(input("Columna")),int(input("Valor")))
    mb=ma
    suma_matrices(ma, mb)
if __name__ == '__main__':
    main()
