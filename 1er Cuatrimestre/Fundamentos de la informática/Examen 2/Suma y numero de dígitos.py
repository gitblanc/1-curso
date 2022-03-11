def suma(a):
    suma = 0
    while a >= 1:
        suma = suma + a % 10
        a=a//10
    return suma

def contador(a):
    cont=0
    while a >= 1:
        cont = cont + 1
        a=a//10
    return cont

def main():
    pass

    n1=int(input("Itroduce un número entero:"))
    while n1 < 0:
        print(n1=int(input("Itroduce un número entero positivo:")))

    print("La suma de sus dígitos es {}".format(suma(n1)))
    print("Tiene un total de {} dígitos".format(contador(n1)))

    if(contador(n1) > 1):
        print("Como tiene más de un dígito, la suma"
        " de sus dígitos es: {}".format(suma(contador(n1))))

if __name__ == '__main__':
    main()
