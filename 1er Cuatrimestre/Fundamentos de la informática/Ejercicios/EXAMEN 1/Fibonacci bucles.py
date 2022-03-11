num1=int(input("Especifica el valor de inicio de la serie:"))
while num1<=0:
    print("Especifique un valor de inicio positivo")
    num1=int(input("Especifica el valor de inicio de la serie:"))


elem=int(input("Especifica el número de elementos a mostrar:"))
while elem<=0:
    print("Especifique un número de elementos positivo mayor que 0")
    elem=int(input("Especifica el número de elementos a mostrar:"))


for i in range(elem):

    print(num1, end=" ")

    aux = num1
    suma = 1
    while aux>0:
        if aux % 10 != 0:
            suma = suma * (aux%10)
        aux = aux//10

    num1 = num1 + suma


