
def suma_digitos(n):
    suma = 0

    while n != 0:
        suma = suma + n%10 #sacar la ultima cifra : 98.5 -> 5
        n = n // 10     #nos quedamos con la parte entera : 98.5 -> 98
    return suma

def cuenta_digitos(n):
    c = 0
    while n!=0:
        c=c+1
        n=n//10
    return c

def main():
    pass
    n=int(input("Introduce un número >=0:"))
    while n < 0:
        n=int(input("Introduce un número >=0:"))

    if cuenta_digitos(n)>1:
        print(suma_digitos(n))


if __name__ == '__main__':
    main()
