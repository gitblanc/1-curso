



def main():
    pass

    n=int(input("Introduce un número positivo"))
    while n<0:
        n=int(input("Introduce un número positivo"))

    for i in range(1,n+1):
        if n%i==0:
            print(i)


if __name__ == '__main__':
    main()
