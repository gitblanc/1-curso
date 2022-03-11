def cuenta_pos(lista):
    l2=[]
    for i in range(len(lista)):
        if lista[i]>0 and lista[i]%2==0:
            l2.append(lista[i])
            lista[i]=-lista[i]#SE MODIFICAN LOS ELEMENTOS DE LA LISTA QUE CUMPLEN LA CONDICION ANTERIOR

    return l2

    #isinstance(a,int)  Comprobar que es entero

def main():
    pass

    l = [2,3,4,5,6,7,34,-2]

    l_result=cuenta_pos(l)

    print("El número de positivos pares de la lista es",len(l_result),"que son"
    ,l_result)
    print("La lista original queda como",l)







if __name__ == '__main__':
    main()
