def split_data(linea):
    campos=linea.split(",")
    campos[1]=int(campos[1])
    campos[2]=int(campos[2]) #SE ASIGNAN A ENTERO, EN LUGAR DE STRING
    return campos



def main():


    f=open("input.csv","r")
    line=f.readline()
    while line!="":
        linea_completa=split_data(line)
        if linea_completa[2]>linea_completa[1]:
            print(linea_completa[0],"(", linea_completa[2],">",linea_completa[1],")")
            #lista_mujeres[c]=linea_completa[0]
            #c=c+1
        line=f.readline()

    f.close()

if __name__ == '__main__':
    main()