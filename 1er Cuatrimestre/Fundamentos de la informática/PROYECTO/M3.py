#-------------------------------------------------------------------------------
# Name:     M1
#
# Purpose:  Este módulo crea o modifica (en función de si ya hay un fichero
#           existente) un fichero en el que se almacenará la semilla usada para
#           la encriptación y el mensaje encriptado.
#
# Authors:  Guillermo Pulido Fernández, Antonio Castro Álvarez,
#           Eduardo Blanco Bielsa
#
# Created:  28/12/2020
#-------------------------------------------------------------------------------

import M1
import M2

def write_code(codeList,msg):
    #Esta función crea o modifica el fichero en el que se escribirá la semilla
    #de encriptación y el mensaje encriptado.

    f = open("codificator.txt",'w')
    f.write(str(codeList))
    f.write("\n")
    f.write("\n")
    f.write(str(msg))
    f.close()

def string_to_list():
    #Esta función abre en modo lectura el fichero que contiene la semilla y el
    #mensaje, copia en una lista la semilla y la devuelve.

    f = open("codificator.txt",'r')
    lista=[]

    for i in f.readline():
        if i in M1.create_charList():
            lista.append(i)
    f.close()
    return lista

