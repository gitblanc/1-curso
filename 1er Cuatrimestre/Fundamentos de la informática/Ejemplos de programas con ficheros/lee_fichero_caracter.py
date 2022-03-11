# lee el fichero prueba.txt caracter a caracter y muestra su contenido
# escrito por Jose A. Corrales el 30-oct-2013

# antes de ejecutar el programa, salvarlo en el escritorio para
# que los ficheros deban estar sobre el escritorio

# se abre el fichero para lectura
fichero=open("prueba.txt")

todo=""

# proceso del fichero, carácter a carácter
caracter=fichero.read(1)
while caracter!="":
    todo=todo+caracter
    caracter=fichero.read(1)

# otra posible forma
#while True:
#    caracter=fichero.read(1)
#    if caracter=="":
#        break
#    todo=todo+caracter

# se cierra el fichero
fichero.close()

# se muestran los resultados
print(todo)
