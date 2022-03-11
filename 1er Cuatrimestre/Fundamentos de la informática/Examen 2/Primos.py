def primo(a):

    if(a < 2):
        return "El número {} NO es primo".format(a)

    for i in range(a//2,1,-1):
        if a%i == 0:
            return "El número {} NO es primo".format(a)
    return "El número {} es primo".format(a)

def main():
    pass

    n1=int(input("Introduce un número:"))
    while n1 > 0:
        print("{}".format(primo(n1)))
        n1=int(input("Introduce un número:"))
    print("--FIN DE LA EJECUCIÓN--")
if __name__ == '__main__':
    main()