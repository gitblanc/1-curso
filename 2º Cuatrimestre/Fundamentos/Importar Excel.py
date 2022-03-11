#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      blanc
#
# Created:     07/06/2021
# Copyright:   (c) blanc 2021
# Licence:     <your licence>
#-------------------------------------------------------------------------------

def num_total_habitantes(fileName):

    f=open(fileName, "r")
    datos=f.readlines()

    population=0

    for line in datos:
        linea = line.split(";")

        entero = int(linea[1])
        population+=entero

    f.close()
    return population


def num_promedio(fileName):

    f=open(fileName, "r")
    datos=f.readlines()

    cont=0
    for pais in datos:
        cont+=1

    result = num_total_habitantes(fileName)/cont
    f.close()
    return result

def lista_paises_num(fileName):

    f=open(fileName, "r")
    datos=f.readlines()
    paisesPromedio = []

    for line in range(len(datos)):


        pais = datos[line].split(";")[0]
        telefonos = int(datos[line].split(";")[2])
        poblacion = int(datos[line].split(";")[1])
        promedio = telefonos/poblacion
        element = [pais,promedio]
        paisesPromedio.append(element)

    nombreFichero ="telefonos-promedio.csv"
    fichero=open(nombreFichero, 'w')


    for elem in range(len(paisesPromedio)):
        fichero.write(str(paisesPromedio[elem]) + "\n")

    f.close()
    fichero.close()

def habitantes_cercanos(fileName):
    f=open(fileName, "r")
    datos=f.readlines()

    promedio=num_promedio(fileName)
    cadena="Los países cercanos al promedio son: "

    for line in range(len(datos)):
        pais=datos[line].split(";")[0]
        p=datos[line].split(";")[1]#promedio del pais

        if(promedio-int(p) < 1000000):
            cadena+=pais + ","

    f.close()
    return cadena

def main():
    pass

    fileName ="datos-paisess.csv"
    entero = num_total_habitantes(fileName)
    promedio = num_promedio(fileName)
    paisesPromedio = lista_paises_num(fileName)

    print("El numero total de habitantes es: {}" .format(entero) )

    print("El numero promedio de habitantes es: {}".format(promedio))

    print("{}".format(habitantes_cercanos(fileName)))





if __name__ == '__main__':
    main()
