
def leerDatos(mes):
    """
        Recibe un entero con el nombre del mes
        devuelve una lista de enteros con los datos
        1- Cargar el fichero mes+".dat" y cargar las líneas
        2- Recorrer la lista modificando cada uno de los datos string a int
        3- Devolver la lista
    """

    f= open(mes + ".dat")
    lista=f.readlines()

    for i in range(len(lista)):
        lista[i] = int(lista[i])
    f.close()

    return lista


def datosPorDia(datos,dia):
    """
        Recibe la lista de datos, y el día de interés
        Devuelve el dato de ese día
    """
    return datos[dia-1]

def maximo(datos):
    """
        Recibe la lista de datos
        Devuelve el día en el que se midió el máximo del mes
    """
    max=[0]
    dia=1
    dia_max=1
    for i in datos:
        if i > max:
            max=i
            dia_max=dia
        dia=dia+1
    return dia_max

def minimo(datos):
    """
        Recibe la lista de datos
        Devuelve el día en el que se midió el mínimo del mes
    """
    min=[0]
    dia=1
    dia_min=1
    for i in datos:
        if i < min:
            min=i
            dia_min=dia
        dia=dia+1
    return dia_min

def media(datos):
    """
        Recibe la lista de datos
        Devuelve la media de precipitaciones/dia del mes
    """

    suma=0
    dias=0
    for i in range(len(datos)):
        suma = suma + datos[i]
        dias = dias + 1
    media=suma/dias

    return media

def vistaMensual(datos):
    """
        Recibe la lista de datos
        Muestra los datos formateados de acuerdo al calendario:
        Ejemplo (Para primerLunes=3):

            L	    M	    Mi	   J	    V	    S	    D
                                                    706  	989
            789  	1414 	1419 	1058 	1259 	1130 	76
            68   	454  	1219 	882  	436  	1107 	1070
            798  	1035 	277  	212  	891  	306  	727
            234  	909  	296  	539  	1328 	403  	771
    """
    primerLunes=int(input("Introduce el día del mes del primer lunes: "))-1
    print({":<5"}.format("L\t"),{":<5"}.format("M\t"),{":<5"}.format("X\t"),{":<5"}.format("J\t"),{":<5"}.format("V\t"),{":<5"}.format("S\t"),{":<5"}.format("D\t"))
    for i in range(7-primerLunes):
        print({":<5"}.format(""),end="\t")
    for i in range(len(datos)):
        if(i in [primerLunes,primerLunes+7,primerLunes+14,primerLunes+21,primerLunes+28]):
            print()
        print({":<5"}.format(datos[i]),end="\t")
    print()


def mostrarMenu():
    print("1...............Cargar datos")
    print("2...............Consultar precipitaciones por día")
    print("3...............Ver maxímo de precipitaciones")
    print("4...............Ver mínimo de precipitaciones")
    print("5...............Ver media de precipitaciones")
    print("6...............Vista mensual")
    print("0...............Salir")
    print("----------------------------------------------------")
    opt=int(input("Introduce una opción: "))
    while opt not in [1,2,3,4,5,6,0]:
         opt=int(input("Opción inválida. Introduce una opción: "))
    return opt


datos=""
opt=mostrarMenu()

while opt != 0:
if opt==1:
    mes=input("Mes a consultar:  ")
    datos=leerDatos(mes)
else:
    if datos=="":
        print("Error: Antes de ejecutar cualquier opción debe cargar un fichero de datos")
    else:

        if opt==2:
            dia=int(input("Día del mes: "))
            #COMPROBACIÓN: Seguir pidiendo valores mientras estos no sean validos
            print("El día", dia, "se midieron", datosPorDia(datos, dia),"cm3")
        elif opt==3:
            dia_max=maximo(datos)
            print("El día de máximas precipitaciones fue el día",dia_max , "con", datos[dia_max-1], "mm3")
        elif opt==4:
            dia_min=minimo(datos)
            print("El día de minimas precipitaciones fue el día",dia_min , "con", datos[dia_min-1], "mm3")
        elif opt==5:
            print("La media de precipitaciones por día es",media(datos), "mm3")
        else:
            vistaMensual(datos)

