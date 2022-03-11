# lee el fichero prueba.txt entero y muestra su contenido
# escrito por Jose A. Corrales el 30-oct-2013

# antes de ejecutar el programa, salvarlo en el escritorio para
# que los ficheros deban estar sobre el escritorio

# se abre el fichero para lectura
fichero=open("prueba.txt")

# proceso del fichero, se lee todo en una única cadena
todo=fichero.read()

# se cierra el fichero
fichero.close()

# se muestran los resultados
print(todo)
