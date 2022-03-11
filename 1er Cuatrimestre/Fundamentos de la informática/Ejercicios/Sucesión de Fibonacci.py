#Sucesion de fibonacci
def main():
    pass

    umbral=int(input("Umbral: "))
    a=0
    b=1
    print(a,b,end=" ")
    termino=a+b


    while termino<=umbral:
        print(termino, end=" ")
        a=b
        b=termino
        termino=a+b




if __name__ == '__main__':
    main()
