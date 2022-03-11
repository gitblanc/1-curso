def factorial(n):
    fact = 1
    for i in range(2,n+1):
        fact = fact*i
    return fact


def main():
    pass

    val1 = int(input("Introduce un número"))
    while val1<0:
        val1 = int(input("El número debe ser mayor a 0. Introduce un número"))

    for i in range(0,val1+1):
        print("!",i,"=",factorial(i))

if __name__ == '__main__':
    main()
