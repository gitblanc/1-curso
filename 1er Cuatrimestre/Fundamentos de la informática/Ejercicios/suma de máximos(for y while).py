
def main():
    pass


    reps=int(input("Introduzca el número de repeticiones: "))
    suma=0
    for i in range(1, reps+1, 1):

        max=0
        num=0


        num=int(input("[Serie"+str(i)+"]Introduzca un número: "))
        while num!=0:
            if num>max:
                max=num
            num=int(input("Introduzca un número: "))
        suma=suma+max

    print("La suma de los máximos es",suma)

if __name__ == '__main__':
    main()
