def main():
    pass


    suma = 0
    num = 1
    contador=0

    while num>=0:
        num=float(input("Introduzca un número cualquiera"))
        if num>=0:
            contador = contador+1
            suma = suma+num
    if contador==0:
        print("Datos insuficientes")

    else:
        promedio = suma/contador
        print("El promedio total es:",promedio)












if __name__ == '__main__':
    main()
