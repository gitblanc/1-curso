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

def trasponerMatriz(m):
    result=[]
    for j in range(len(m[0])):
        fila=[]
        for i in range(len(m)):
            fila.append(m[i][j])
        result.append(fila)
    m.clear()
    m.extend(result)

def generarIdentidad(tam):
    result=[]
    for i in range(tam):
        fila = [0]*tam #Se puede usar * para multiplicar matrices
        fila[i]=1
        result.append(fila)
    return result

def matrizSimetrica(m):
    for i in range(len(m)):
        for j in range(i+1,len(m[i])):
            if m[i][j] != m[j][i]:
                return False
    return True


def main():
    pass
    mat=[[0,1,2],[1,3,4],[2,4,5]]
    mostrarMatriz(mat)

    if matrizSimetrica(mat):
        print("Es simétrica")
    else:
        print("No es simétrica")

if __name__ == '__main__':
    main()
