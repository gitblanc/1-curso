def main():
#raíz y persistencia aditiva de un número

    original=int(input("Introduzca un número"))#hay que mantener los datos originales
    n=original
    contador=0
    while n>9:
        suma=0
        contador=contador+1
        for digito in str(n):
            suma=suma+int(digito)

        n=suma
    print("La persistencia aditiva de",original,
     "es",contador,
     "y su raíz digital es",n)








if __name__ == '__main__':
    main()
