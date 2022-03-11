def cadena(line):

    z=line.split(",")
    z[0]=str(z[0])
    z[1]=int(z[1])
    z[2]=int(z[2])
    return z


def main():
    pass
    f=open("input.csv","r")
    line=f.readline()

    while line != "":
        print("{}".format(cadena(line)))
        line=f.readline()

    f.close()

if __name__ == '__main__':
    main()
