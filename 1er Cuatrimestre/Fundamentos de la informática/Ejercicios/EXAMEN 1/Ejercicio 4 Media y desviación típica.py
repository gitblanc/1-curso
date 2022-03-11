def main():
    pass

    x1=float(input("Introduce el primer valor"))
    x2=float(input("Introduce el segundo valor"))
    x3=float(input("Introduce el tercer valor"))


    media=(x1+x2+x3)/3

    desviacion=(((x1-media)**2+(x2-media)**2+(x3-media)**2)/3)**0.5


    print("La media es {:.2f} y la desviación típica es {:.2f}".format(media,desviacion))





if __name__ == '__main__':
    main()
