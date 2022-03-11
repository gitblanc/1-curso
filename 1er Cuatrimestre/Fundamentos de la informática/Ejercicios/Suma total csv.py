def split_data(linea):
    campos=linea.split(",")
    campos[1]=int(campos[1])
    campos[2]=int(campos[2]) #SE ASIGNAN A ENTERO, EN LUGAR DE STRING
    return campos



def main():


    f_in=open("input.csv","r")
    f_out=open("output.csv","w")

    line=f_in.readline()
    while line!="":
        linea_completa=split_data(line)
        sumatotal=linea_completa[1]+linea_completa[2]
        f_out.write(linea_completa[0]+"-"+str(sumatotal)+"\n")
        line=f_in.readline()

    f_in.close()
    f_out.close()

if __name__ == '__main__':
    main()