
def main():
    pass
    n=int(input("Introduzca un número positivo o cero"))
    while (n<0):
        n=int(input("Introduzca un número positivo o cero"))

    fact = 1
    for i in range(1, n+1):
        fact=fact*i
    print(n, "!",fact)



if __name__ == '__main__':
    main()
