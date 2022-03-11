n=int(input("Introduzca un número: "))
cadena=""
while  n!=0:
    resto=n%2
    cadena=str(resto)+cadena#Si pones +" "+ deja un espacio
    n=n//2
print(cadena)