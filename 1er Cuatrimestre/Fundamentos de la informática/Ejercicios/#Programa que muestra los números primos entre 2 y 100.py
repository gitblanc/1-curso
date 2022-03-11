 #Programa que muestra los números primos entre 2 y 100

def es_primo(num):
    for divisor in range(2,num):
        if num%divisor==0:
            return False
    return True

for num in range(2,101):
    if es_primo(num):
        print(num)


print(3,es_primo(3))
print(10,es_primo(10))