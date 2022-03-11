import M1
import M3
import time
import getpass

def read_code():

    codeList=M3.string_to_list()
    f = open("codificator.txt",'r')
    lista = f.readlines()
    msg = lista[2]
    f.close()

    return msg,codeList

def decoder(msg,codeList):

    alphabet = M1.create_charList()
    decoded_msg = ""
    for i in msg:
        if i in alphabet:
            aux = codeList.index(i)
            decoded_msg = decoded_msg + alphabet[aux]
        else:
            decoded_msg = decoded_msg + i
    return decoded_msg

def pin():
    default_pin = 9973  #El mayor primo de 4 cifras :)
    cont=3
    x = False

    while cont > 0 and x == False:
        PIN = int(getpass.getpass("Introduce el PIN de 4 cifras: "))
        print()
        print()
        if PIN == default_pin:
            x = True
        cont =cont - 1
    return x

def puk():
    default_puk = 71771009 #Dos primos de 4 cifras :)
    cont=3
    x = False

    while cont > 0 and x == False:
        PUK = int(getpass.getpass("Introduce el PUK de 8 cifras: "))
        print()
        print()
        if PUK == default_puk:
            x = True
        cont = cont - 1
    return x


def main():
    pass
    PIN=pin()
    while not PIN:
        PUK = puk()
        if not PUK:
            print("No acertaste ni el PIN ni el PUK")
            print("Espera 5 minutos para volver a intentarlo.")
            time.sleep(300)
        else:
            PIN = True



    msg,codeList = read_code()
    msg_decoded = decoder(msg,codeList)

    print("El mensaje original era:")
    time.sleep(2)
    print("20%")
    time.sleep(2)
    print("50%")
    time.sleep(2)
    print("94%")
    time.sleep(2)
    print("99%")
    time.sleep(4)
    print("-"*200)
    print(msg_decoded)
    print("-"*200)


if __name__ == '__main__':
    main()
