def main():
    pass

    binario=int(input("Introduce un número entero:"))

    x=bin(binario)
    y=hex(binario)

    print("La representación binaria de {} es {}".format(binario,x))

    print("La representación hexadecimal de {} es {}".format(binario,y))






if __name__ == '__main__':
    main()
