def pedir_num():
    n=int(input("Introduzca un número mayor que 0(0 para salir)"))
    while n<0:
        n=int(input("Introduzca un número mayor que 0(0 para salir)"))

    return n


def main():
    pass

    n=pedir_num()

    l=[]
    while n!=0:
        l.append(n)
        n=pedir_num()


    print(l)
    print("El máximo es",max(l),",el mínimo es",min(l),"y la suma total es",sum(l))
    q=sorted(l)
    print(q)
    print("El máximo es",q[len(q)-1],"el segundo es",q[len(q)-2],"y el tercero es",
    q[len(q)-3])





if __name__ == '__main__':
    main()
