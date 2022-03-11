# lee el fichero prueba.txt linea a linea y muestra su contenido
# escrito por Jose A. Corrales el 30-oct-2013

# antes de ejecutar el programa, salvarlo en el escritorio para
# que los ficheros deban estar sobre el escritorio

# se abre el fichero para lectura
fichero=open("prueba.txt")

# proceso del fichero, línea a línea
for linea in fichero:
    # línea contiene el terminador "línea nueva"
    # excepto a veces la última del fichero
    # si acaba en el caracter línea nueva, se quita
    if linea[-1]=="\n":
        linea=linea[:-1]
    # alternativa:
    # linea=linea.rstrip("\n")
    print(linea)

# se cierra el fichero
fichero.close()
