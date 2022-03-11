def max_divisor(a,b):
    for i in range(min(a,b),1,-1):
        if a%i == 0 and b%i == 0:
            return i




def main():
    pass

    n1=int(input("Introduce el primer número natural: "))
    while n1 < 0:
        print(n1=int(input("Introduce el primer número natural: ")))
    n2=int(input("Introduce el segundo número natural: "))
    while n2 < 0:
        print(n2=int(input("Introduce el segundo número natural: ")))

    res = max_divisor(n1,n2)
    print("El máximo común divisor es: {}".format(res))

if __name__ == '__main__':
    main()
