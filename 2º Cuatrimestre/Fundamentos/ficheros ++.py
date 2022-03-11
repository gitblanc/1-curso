#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      blanc
#
# Created:     14/06/2021
# Copyright:   (c) blanc 2021
# Licence:     <your licence>
#-------------------------------------------------------------------------------
def campos_input():
    f=open("input.csv", "r")
    datos = f.readlines()
    listaFinal=[]

    for i in range(len(datos)):
        line = datos[i].split(",")
        provincia = line[0]
        hombres = line[1]
        mujeres = line[2].rstrip("\n") #el rstrip quita el salto de linea
        listaFinal.append(provincia + "-" + hombres+ "-" + mujeres)
    print(listaFinal)
    f.close()
def main():
    pass

    campos_input()
if __name__ == '__main__':
    main()
