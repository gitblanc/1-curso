
def main():
    pass

    cadena=str(input("Introduzca una cadena de caracteres"))
    nueva=""
    for c in cadena:
        nueva=c+nueva#se pega un carácter por delante
    print(nueva)


if __name__ == '__main__':
    main()
