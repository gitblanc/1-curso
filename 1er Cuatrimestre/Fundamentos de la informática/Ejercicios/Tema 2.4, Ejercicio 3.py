jugador1=int(input("Resultado del jugador 1"))
jugador2=int(input("Resultado del jugador 2"))
maxscore=21

if jugador1>maxscore and jugador2>maxscore:
    print("Ambos jugadores pierden")

elif jugador1<=maxscore and jugador2>maxscore:
    print("Ganó el jugador 1 con {} puntos".format(jugador1))

elif jugador1>maxscore and jugador2<=maxscore:
    print("Ganó el jugador 2 con {} puntos".format(jugador2))

elif jugador1==jugador2:
    print("Ha habido un empate")




