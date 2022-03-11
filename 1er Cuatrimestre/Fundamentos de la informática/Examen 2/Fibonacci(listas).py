def fibo(n):
    lista=[]
    if n > 0:
        lista.append(0)
    if n > 1:
        lista.append(1)

    for i in range(2,n):
        lista.append(lista[-1] + lista[-2])
    return lista

def main():
    pass

    x=int(input("Introduce número de valores a mostrar: "))
    z=fibo(x)
    print(z)

if __name__ == '__main__':
    main()
