def main():
    pass


    initialPosition=float(input("Introduce la posición actual:"))
    speed=float(input("Introduzca la velocidad:"))
    aceleration=float(input("Introduzca la aceleración:"))

    time=float(input("Introduzca el tiempo en segundos(segs):"))

    x=initialPosition+(speed*time)+(0.5*aceleration*time*time)


    print("La posición del objeto tras",time,"es",x,"m")
    #print("La posición del objeto tras {}s es {:.2f}m".format(time,x))
    #USANDO EL FORMAT
if __name__ == '__main__':
    main()
