#CÁLCULO DE LOS DIVISORES DE UN NÚMERO ENTERO

n=int(input("Intruduzca un número entero"))
for divisor in range(1,1+n):
    if n%divisor==0:
        print(divisor)