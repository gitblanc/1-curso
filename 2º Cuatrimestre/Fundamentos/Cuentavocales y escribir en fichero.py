#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      blanc
#
# Created:     21/06/2021
# Copyright:   (c) blanc 2021
# Licence:     <your licence>
#-------------------------------------------------------------------------------
def cuenta_vocales(fileName, letra):

    f=open(fileName, "r")
    datos = f.readlines()
    cont=0
    for cadena in datos:
        for x in cadena:
            if(x in letra):

                cont+=1
    f.close()
    return cont

def escribe_vocales():
    nombreFichero="examen.txt"
    nuevoFichero = "vocales.txt"
    numA = cuenta_vocales(nombreFichero,["a", "á", "A", "Á"])
    numE = cuenta_vocales(nombreFichero,["e", "é", "E", "É"])
    numI = cuenta_vocales(nombreFichero,["i", "í", "I", "Í"])
    numO = cuenta_vocales(nombreFichero,["o", "ó", "O", "Ó"])
    numU = cuenta_vocales(nombreFichero,["u", "ú", "U", "Ú"])

    newFile=open(nuevoFichero,"w")
    newFile.write("a    " + str(numA)+ "\n")
    newFile.write("e    " + str(numE)+ "\n")
    newFile.write("i    " + str(numI)+ "\n")
    newFile.write("o    " + str(numO)+ "\n")
    newFile.write("u    " + str(numU)+ "\n")

def main():
    pass
    escribe_vocales()

if __name__ == '__main__':
    main()
