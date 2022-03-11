def mediaa(a):
    if len(a)==0:
        return 0, 0

    mediaTotal=sum(a)/len(a)

    desv=0
    for i in a:
        desv=desv + (i - mediaTotal)**2

    desviacion=(desv/len(a))**0.5

    return mediaTotal,desviacion



def main():
    pass

    x=int(input("Introduce el tamaño de la población: "))
    while x < 0:
        x=int(input("Introduce el tamaño de la población: "))

    lista=[]
    for i in range(1,x+1):
        y=float(input("Introduce valor #{}: ".format(i)))
        lista.append(y)

    z,k=mediaa(lista)
    print("La media es {:.2f} y la desviación típica es {:.2f}".format(z,k))

if __name__ == '__main__':
    main()
