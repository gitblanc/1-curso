def main():
    pass

    puntuacion1=0
    puntuacion2=0
    finished=False
    maxscore=21

    while puntuacion1<=maxscore and not finished:
        puntos=int(input("Jugador 1 ({} puntos): ".format(puntuacion1)))
        if puntos > 11:
            print("{} no es un número válido de puntos".format(puntos))
        elif puntos>0:
            puntuacion1=puntuacion1+puntos
        else:
            finished=True
    print("El jugador 1 terminó su turno con ({} puntos".format(puntuacion1))

    finished=False
    while puntuacion2<=maxscore and not finished:
        puntos=int(input("Jugador 2 ({} puntos): ".format(puntuacion2)))
        if puntos > 11:
            print("{} no es un número válido de puntos".format(puntos))
        elif puntos>0:
            puntuacion2=puntuacion2+puntos
        else:
            finished=True
    print("El jugador 2 terminó su turno con ({} puntos".format(puntuacion2))




    if puntuacion1>maxscore and puntuacion2>maxscore:
        print("Ambos jugadores pierden")

    elif puntuacion1<=maxscore and (puntuacion2>maxscore or puntuacion1>puntuacion2):
        print("Ganó el jugador 1 con {} puntos".format(jugador1))

    elif puntuacion2<=maxscore and (puntuacion1>maxscore or puntuacion1<puntuacion2) :
        print("Ganó el jugador 2 con {} puntos".format(jugador2))

    else:
        print("Ha habido un empate")

if __name__ == '__main__':
    main()
