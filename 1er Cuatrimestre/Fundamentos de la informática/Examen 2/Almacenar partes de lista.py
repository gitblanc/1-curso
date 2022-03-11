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
    lista=[]
    while line != "":
        z=cadena(line)
        if z[1] < z[2]:
            lista.append(z[0])
        line = f.readline()
    f.close()

    print("Hay {} provincias con mayor número de putas que de maromos".format(len(lista)))
    for j in lista:
        print(j)

if __name__ == '__main__':
    main()
