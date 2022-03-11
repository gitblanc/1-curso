def cadena(line):

    z=line.split(",")
    z[0]=str(z[0])
    z[1]=int(z[1])
    z[2]=int(z[2])
    return z



def main():
    pass
    f_in=open("input.csv","r")
    f_out=open("output.csv","w")
    line=f_in.readline()

    while line != "":
        z=cadena(line)
        f_out.write("{}--{}\n".format(z[0],z[1]+z[2]))
        line=f_in.readline()

    f_in.close()
    f_out.close()

if __name__ == '__main__':
    main()
