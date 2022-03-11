def distancia(a,b):
    #devuelve la distancia entre dos listas considerando
    # La diferencia de longitudes y la diferencia de valores

    #diferencia de longitudes

    #if len(a) > len(b):          MANERA NOVATA
     #   dist1=len(a) - len(b)
    #else:
     #   dist1=len(b) - len(a)

     dist1=abs(len(a) - len(b))#usando valor absoluto

     #diferencia de valores

     dist2=0

     for i in range(min(len(a),len(b))): #min() permite saber cual es menor
        if a[i] != b[i]:
            dist2=dist2+1

     return dist1+dist2



print(distancia([1,0,3,2,1,23,34],[2,4,3.2,3]))
