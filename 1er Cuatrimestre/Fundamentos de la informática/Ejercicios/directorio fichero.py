



def main():
    pass

    f=open("texto ej.txt","r")

    lineas = f.readlines()

    f.close()
    for l in lineas:
        print(l, end="")

if __name__ == '__main__':
    main()
