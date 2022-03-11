



def main():
    pass

    n=int(input("Introduce un número positivo"))
    while n<0:
        n=int(input("Introduce un número positivo"))

    suma=0
    for i in range(1,n):
        if n%i==0:
            suma=suma+i
    if(suma==n):
        print("El número es perfecto")
    elif(suma>n):
        print("Es abundante")
    else:
        print("Es defectivo")
        if(suma==1):
            print("y primo")

if __name__ == '__main__':
    main()
