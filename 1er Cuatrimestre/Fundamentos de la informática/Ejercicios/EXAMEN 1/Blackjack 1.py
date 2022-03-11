def main():
    pass
    j1=0
    j2=0
    maxscore=21
    limit=11
    finished=False

    while j1<=21 and not finished:
        puntos=int(input("Jugador 1 ({} puntos):".format(j1)))
        if puntos>limit:
            print("Por favor introduzca un número válido de puntos")
        elif puntos>0:
            j1=puntos+j1
        else:
            finished=True
    print("El jugador 1 terminó su turno con {} puntos".format(j1))

    finished=False

    while j2<=21 and not finished:
        puntos=int(input("Jugador 2 ({} puntos):".format(j2)))
        if puntos>limit:
            print("Por favor introduzca un número válido de puntos")
        elif puntos>0:
            j2=puntos+j2
        else:
            finished=True
    print("El jugador 2 terminó su turno con {} puntos".format(j2))


    if j1>maxscore and j2>maxscore:
        print("Ambos jugadores pierden")
    elif j1<=maxscore and (j1>j2):
        print("¡Gana el jugador 1 con {} puntos!".format(j1))
    elif j2<=maxscore and (j2>j1):
        print("¡Gana el jugador 2 con {} puntos!".format(j2))
    else:
        print("¡Hubo un empate!")



if __name__ == '__main__':
    main()
