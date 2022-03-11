
def main():
    print("--------------------------")
    print("1) Calcular el doble")
    print("2) Calcular el cuadrado")
    print("3) Calcular el cubo")
    print("0) Salir")
    print("--------------------------")
    num=float(input("Introduce un número: "))
    opt=int(input("Introduce una opción: "))


    while opt!=0:
        if opt==1:
            print("El doble de ",num, " es ", num*2)
        elif opt==2:
            print("El cuadrado de ",num, " es ", num**2)
        elif opt==3:
            print("El cubo de ",num, " es ", num**3)

        else:
            print("Introduzca una opción válida")


        print("--------------------------")
        print("1) Calcular el doble")
        print("2) Calcular el cuadrado")
        print("3) Calcular el cubo")
        print("4) Salir")
        print("--------------------------")
        num=float(input("Introduce un número: "))
        opt=int(input("Introduce una opción: "))

    if opt==0:
            print("Saliendo...")


if __name__ == '__main__':
    main()


