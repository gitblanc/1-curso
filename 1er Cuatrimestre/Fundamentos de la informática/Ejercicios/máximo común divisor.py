def mcd(a, b):
    for i in range(min(a,b),1,-1):
        if a % i == 0 and b % i == 0:
            return i
    return 1


def main():
    pass

    valor1=int(input("Introduzca el primer número"))
    while valor1<=0:
        valor1=int(input("El número debe ser mayor que 0. Introduzca el primer número"))
    valor2=int(input("Introduzca el segundo número"))
    while valor2<=0:
        valor2=int(input("El número debe ser mayor que 0. Introduzca el segundo número"))

    print("El máximo común divisor es ", mcd(valor1,valor2))

if __name__ == '__main__':
    main()
