def factorial(a):

    fact = 1
    for i in range(2,a+1):
        fact = fact*i
    return fact



def main():
    pass

    k=int(input("Introduce el valor máximo del cual mostrar el factorial"))
    while k < 0:
        print(k=int(input("Introduce el valor máximo del cual mostrar el factorial")))

    for j in range(0,k+1):
        print("{}! = {}".format(j,factorial(j)))

if __name__ == '__main__':
    main()
