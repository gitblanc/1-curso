def main():
    pass

    e=0
    cont = 0
    fact = 1

    num = int(input("Especifica el número de iteraciones para el cálculo de e:"))

    while num <=0:
        print("El número de iteraciones debe ser superior a 0")
        num = int(input("Especifica el número de iteraciones para el cálculo de e:"))

    for i in range(num):
        e += 1/fact
        cont=cont+1
        fact=fact*cont

    print("La aproximación de e tras {} iteraciones es {}".format(num,e))


if __name__ == '__main__':
    main()
