#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      blanc
#
# Created:     01/06/2021
# Copyright:   (c) blanc 2021
# Licence:     <your licence>
#-------------------------------------------------------------------------------

def list_numbers(fileName):#leer de un fichero
    f=open(fileName, "r")
    datos=f.readlines()

    numbers=[]

    for i in range(len(datos)):
        entero = int(datos[i])
        numbers.append(entero)

    suma = sum(numbers)
    f.close()
    return numbers, suma


def alumnos_total(fileName):
    f=open(fileName, "r")
    datos=f.readlines()
    cont=0
    for i in range(len(datos)):
        cont+=1

    f.close()
    return cont




def apellido_fichero(line, surname):

    if(surname in line):
        return True
    return False



def how_many_words(line):
    nombre_completo = line.split(", ")
    nombre_completo_final = nombre_completo[1].split(" ")
    cont=0
    for i in nombre_completo_final:
        cont+=1
    return cont



def type_of_name(lines):
    una = 0
    dos = 0
    tres = 0
    cuatro = 0
    cinco = 0
    seis = 0
    siete = 0

    for i in lines:
        if(how_many_words(i)) == 1:
            una+=1
        elif(how_many_words(i)) == 2:
            dos+=1
        elif(how_many_words(i)) == 3:
            tres+=1
        elif(how_many_words(i)) == 4:
            cuatro+=1
        elif(how_many_words(i)) == 5:
            cinco+=1
        elif(how_many_words(i)) == 6:
            seis+=1
        else:
            siete+=1

    return una, dos, tres, cuatro, cinco, seis, siete



def main():
    pass

    x,y = list_numbers("datos.txt")
    print("Datos {} \n\nSuma {}" .format(x,y))



    num_alumnos = alumnos_total("alumnos.txt")
    print("Num. total de alumnos = {}".format(num_alumnos))



    f = open("alumnos.txt","r")
    line = f.readline()
    f.close()
    print(apellido_fichero(line, "Gonzalez"))
    print(apellido_fichero(line, "Aceituna"))



    k = open("alumnos.txt", "r")
    lines = k.readlines()
    cont=0
    for i in lines:
        if apellido_fichero(i, "Fernandez") == True:
            cont+=1
    k.close()
    num = (cont/len(lines))*100
    print("% de alumnos con apellido Fernandez = {} %" .format(round(num,3)))



    n = open("alumnos.txt", "r")
    lines = n.readlines()
    n.close()
    print("El nombre tiene {} palabras".format(how_many_words(lines[7])))



    j = open("alumnos.txt", "r")
    lines = j.readlines()
    j.close()

    uno,dos,tres,cuatro,cinco,seis,siete = type_of_name(lines)
    print("Una {} \ndos {} \ntres {} \ncuatro {} \ncinco {} \nseis {} \nsiete {}"
    .format(uno,dos,tres,cuatro,cinco,seis,siete))

if __name__ == '__main__':
    main()

