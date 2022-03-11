def main():
    pass

    m=int(input("Introduzca un número natural"))
    n=int(input("Introduzca otro número natural"))
    filas=0
    columnas=0
    for i in range(m):
        filas=filas+1

        for j in range(n):
            print("A"+str(filas)+str(columnas),end=" ")
            columnas=columnas+1
        columnas=1
        print()


if __name__ == '__main__':
    main()
