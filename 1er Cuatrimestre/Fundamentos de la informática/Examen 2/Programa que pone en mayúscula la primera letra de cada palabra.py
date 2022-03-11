def capital(cadena):

    palabras=cadena.split(" ")

    for i in range(len(palabras)):
        palabra=palabras[i]
        palabras[i]=palabra[:1].upper() + palabra[1:]
    return " ".join(palabras)



def main():
    pass

    x=str(input("Introduce la frase a capitalizar:"))

    print("{}".format(capital(x)))

if __name__ == '__main__':
    main()
