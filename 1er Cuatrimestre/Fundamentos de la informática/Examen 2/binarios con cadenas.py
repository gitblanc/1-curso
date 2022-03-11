
def binario(num):
    cadena=""

    if num == 0:
        return "0"

    while num > 0:
        if num % 2 == 0:
            cadena="0"+cadena   #para que sea invertido, el num va delante que la cadena
        elif num % 2 == 1:
            cadena="1"+cadena
        num=num//2
    return cadena

def main():
    pass

    x=int(input("Introduce un valor entero no negativo:"))
    while x < 0:
        x=int(input("Introduce un valor entero no negativo:"))

    print("La representación binaria de {} es {}".format(x,binario(x)))

if __name__ == '__main__':
    main()
