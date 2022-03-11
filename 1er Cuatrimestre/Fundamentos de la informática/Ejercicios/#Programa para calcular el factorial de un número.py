#Programa para calcular el factorial de un número

#obtener el número
#ir multiplicando todos los anteriores
#mostrar el resultado

n=int(input("Introduzca un número entero positivo"))
factorial=1
for i in range(1,n+1):
    factorial=factorial*i

print("El factorial de",n,"es",factorial)
