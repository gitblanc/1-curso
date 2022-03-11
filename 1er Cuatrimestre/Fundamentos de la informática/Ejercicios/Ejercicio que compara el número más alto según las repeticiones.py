
def main():
    pass

    n=int(input("Introduzca un número de repeticiones"))
    while(n<0):
        n=int(input("Introduzca un número de repeticiones"))

    max=0
    num=0
    mensaje="El número más alto de "
    for i in range(1,n+1,1):
        num=int(input("Introduzca el número" + str(i) + ": "))
        mensaje=mensaje+str(i)+" "
        if num>max:
            max=num

    print(mensaje, "es:",max)









if __name__ == '__main__':
    main()
