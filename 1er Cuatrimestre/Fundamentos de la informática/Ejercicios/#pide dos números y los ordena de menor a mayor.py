def main():
    pass

    #pide dos números y los ordena de mayor a menor
    a=float(input("Introduzca un número a"))
    b=float(input("Introduzca un número b"))

    if a>b:
        #se intercambian las variables
       (a,b)=(b,a)
    print("En orden",a,"y",b)

if __name__ == '__main__':
    main()
