def trasponer(matrix):
    matrizF=[]
    for j in range(len(matrix[0])):
        fila=[]
        for i in range(len(matrix)):
            fila.append(matrix[i][j])
        matrizF.append(fila)

    matrix.clear()
    matrix.extend(matrizF)

def main():
    pass

    #x=input("Introduce una matriz:")
    x=[[0,1,2,3],[4,5,6,7],[8,9,10,11]]

    print("La matriz original es {}".format(x))
    trasponer(x)
    print("La matriz traspuesta es {}".format(x))


if __name__ == '__main__':
    main()
