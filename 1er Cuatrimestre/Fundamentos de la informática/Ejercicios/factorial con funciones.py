def factorial(num):

    fact=1  #hay k poner 1 pq sino siempre se multiplicaria x 0
    for i in range(2,num+1):
        fact = fact*i
    return fact


def main():
    pass

    n=int(input("Introduce un número >=0:"))
    while n < 0:
         n=int(input("Introduce un número >=0:"))

    for i in range(n+1):
        print(i,"! =", factorial(i))


if __name__ == '__main__':
    main()
