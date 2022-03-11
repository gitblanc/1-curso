c1 = 0
c3 = 0
c5 = 0
c7 = 0
for i in range(100,1000):
    cont = 0
    for j in range(2,i):
        if(i%j==0):
            cont=cont+1
    if cont==0:
        pito = i%10
        if(pito == 1):
            c1 = c1 + 1
        elif(pito == 3):
            c3 = c3 + 1
        elif(pito == 5):
            c5 = c5 + 1
        elif(pito == 7):
            c7 = c7 + 1

if(c1>c3 and c1>c5 and c1>c7):
        print("La mayor cantidad de primos en ese intervalo acaban en 1, con un total de {}".format(c1))
elif(c3>c5 and c3>c7):
        print("La mayor cantidad de primos en ese intervalo acaban en 3, con un total de {}".format(c3))
elif(c5>c7):
        print("La mayor cantidad de primos en ese intervalo acaban en 5, con un total de {}".format(c5))
elif(c7>c5):
        print("La mayor cantidad de primos en ese intervalo acaban en 7, con un total de {}".format(c7))
else:
        print("Hay un empate en la cantidad de primos acabados en dos cifras distintas")