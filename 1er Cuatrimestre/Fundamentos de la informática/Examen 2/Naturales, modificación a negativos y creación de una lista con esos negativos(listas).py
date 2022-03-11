def naturales(lista):
    negativos=[]
    for i in range(len(lista)):
        if isinstance(lista[i], int) and lista[i] > 0 and lista[i]%2 == 0: #El isinstance se usa para comprobar el tipo de dato
            negativos.append(lista[i])
            lista[i]=-lista[i]
    return negativos



def main():
    pass

    z=[-2,6,-6,7,1,0,4,12]
    x=naturales(z)
    print("Los números reemplazados han sido {}, que son {}".format(len(x),x))
    print("La lista tras llamar a la función es {}".format(z))
if __name__ == '__main__':
    main()
