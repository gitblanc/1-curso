def naturales(lista):
    cont = 0
    for i in range(len(lista)):
        if lista[i] > 0 and lista[i]%2 == 0:
            cont = cont+1
    return cont

def main():
    pass

    z=[2,4,-3,-1,0]
    x=naturales(z)
    print("La lista contiene {} números naturales positivos".format(x))
    print("La lista tras llamar a la función es {}".format(z))
if __name__ == '__main__':
    main()
