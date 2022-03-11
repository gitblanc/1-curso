
def mostrarMatriz(m):
    for i in range(len(m)):
        for j in range(len(m[i])):
            print(m[i][j], end=" ")
        print()

def generarTranspuesta(m):
    result=[]
    for j in range(len(m[0])):
        fila=[]
        for i in range(len(m)):
            fila.append(m[i][j])
        result.append(fila)
    return result


def main():
    pass
    mat=[[0,1,2,3],[4,5,6,7],[8,9,10,11]]

    m2 = generarTranspuesta(mat)

    print("La matriz original es: ")
    mostrarMatriz(mat)
    print("La matriz traspuesta es: ")
    mostrarMatriz(m2)

if __name__ == '__main__':
    main()
