#muestra las cifras de un número en orden inverso
def main():
    pass

    numero=int(input("Introduzca un número"))
    n=numero
    print("El número",n,"con las cifras invertidas es",end=" ")
    while n>0:
        ultima_cifra=n%10
        print(ultima_cifra,end="")
        n=n//10
    if n == 0:
        print(0,end="")
    print(".")#añadiría detrás del anterior print cualquier cadena





    numero=input("Número:")##COMO CADENA DE CARACTERES EZ
    nueva=""
    for caracter in numero:
        nueva=caracter+nueva
    print("El número",numero,"al revés es",nueva)


    numero=input("Número: ")##COMO CADENA DE CARACTERES HARD
    print("El número",numero,"al revés es",numero[::-1])


    print("El número",numero:=input("número: "),"al revés es",numero[::-1])#OPERADOR MORSA

if __name__ == '__main__':
    main()
