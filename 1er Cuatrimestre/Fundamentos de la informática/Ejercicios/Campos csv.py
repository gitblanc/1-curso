
def split_data(linea):
    campos=linea.split(",")
    campos[1]=int(campos[1])
    campos[2]=int(campos[2]) #SE ASIGNAN A ENTERO, EN LUGAR DE STRING
    return campos




def main():
    pass

    f=open("input.csv","r")
    lines=f.readlines()
    #c=0
    #print(len(lines))#cuenta el número de líneas

    #while c<len(lines):#CON WHILE****
       # print(lines[c])
       # c=c+1

    for i in range(len(lines)):#CON FOR****
        #print(lines[i])
        fields=split_data(lines[i])
        print(fields[0],"Nº de hombres:",fields[1],"Nº de mujeres:",fields[2])
    f.close()



if __name__ == '__main__':
    main()
