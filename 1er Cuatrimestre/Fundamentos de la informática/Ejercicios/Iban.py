def digitos_control(cp,ccc):
    base = ccc+cp+"00" #los 0 entre comillas pq es una cadena
    base_num = ""
    for i in base:
        if not i.isdigit(): #si no es un dígito
            base_num = base_num + str(ord(i)-ord("A")+10)
        else:
            base_num = base_num + i
    return "{:02}".format(98 - int(base_num) % 97)


def iban(cp,ccc):

    dc = digitos_control(cp,ccc)

    iban = cp + dc + ccc

    iban_format = iban[:4]

    for i in range(4,len(iban)):
        iban_format = iban_format + " " + iban[i:(i+4)]

    return iban_format

def main():
    pass

    cp = input("Introduce el código de país:")
    ccc = input("Introduce el número de cuenta:")

    print(iban(cp,ccc))

if __name__ == '__main__':
    main()
