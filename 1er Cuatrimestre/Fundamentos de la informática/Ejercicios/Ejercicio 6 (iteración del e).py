def main():
    pass

    e_last = 0.0
    e_curr = 0.0
    count = 0
    factorial = 1
    umbral=float(input("Especifica el umbral a usar para el cálculo de e: "))
    while umbral<= 0.0 or umbral>1.0:
        print("El umbral debe estar en el intervalo (0,1]")
        umbral = float(input("Especifica el umbral a usar para el cálculo de e: "))

    finished = False
    while not finished:
        e_last = e_curr
        e_curr = e_curr+1/factorial
        count = count+1
        factorial = factorial*count

        if e_curr - e_last <=umbral:
            finished = True
    print("La aproximación de e tras {} iteraciones es {}".format(count,e_curr))




if __name__ == '__main__':
    main()
