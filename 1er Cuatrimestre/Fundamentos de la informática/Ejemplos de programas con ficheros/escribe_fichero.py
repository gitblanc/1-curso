# crea un fichero cuyo nombre se pide por teclado y que contiene varias líneas
# escrito por Jose A. Corrales el 23-oct-2013

# antes de ejecutar el programa, salvarlo en el escritorio para
# que los ficheros se creen sobre el escritorio

# se pide por teclado el nombre del fichero
import getpass

nombre_fichero=getpass.getpass("nombre del fichero a crear (por ejemplo test.txt)")

# creación del fichero al abrirlo para escritura
fichero=open(nombre_fichero,"w")

# proceso del fichero, se escribe un texto, números y el fin de línea
for i in range(5):
    j=i+1
    fichero.write("El inverso de "+str(j)+" es "+str(1./j)+"\n")

# se cierra el fichero
fichero.close()

print("fin del programa, mirar el fichero "+nombre_fichero)