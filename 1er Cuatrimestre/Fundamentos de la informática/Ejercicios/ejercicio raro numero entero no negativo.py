





def main():
    pass

    n=int(input("Introduce un número >=0:"))
    while n < 0:
        n=int(input("Introduce un número >=0:"))

    a=int(input("Introduce un número >=0:"))
    while a < 0:
        a=int(input("Introduce un número >=0:"))

    d=int(input("Introduce un número d (n>d>0):"))
    while d < 0 or d > n:
        d=int(input("Introduce un número d (n>d>0):"))

    x=0
    suma = 0
    for i in range(1,d+1):
        suma = suma+i

    while suma != a and x+d>n:
        x=x+1
        suma=suma+d+1

    if suma==a:
        print("El número es",x)
    else:
        print("El número buscado no existe")


if __name__ == '__main__':
    main()
