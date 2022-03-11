def ident(num):
    for i in range(num):
        for j in range(num):
            if i == j:
                print (" 1 ",end=" ")
            else:
                print(" 0 ",end=" ")
        print()

def main():
    pass

    x=int(input("Introduce el tamaño de la identidad: "))
    while x < 0:
        x=int(input("Introduce el tamaño de la identidad:"))

    ident(x)

if __name__ == '__main__':
    main()
