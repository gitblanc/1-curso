def cuenta_pos(lista):
    cont=0
    for elem in lista:
        if elem>0 and elem%2==0:
            cont=cont+1
    return cont

    #isinstance(a,int)  Comprobar que es entero

def main():
    pass

    l = [2,3,4,5,6,7,34,-2]

    num=cuenta_pos(l)

    print("El número de positivos pares de la lista es",num)







if __name__ == '__main__':
    main()
