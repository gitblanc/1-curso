""" Función que recibe un mensaje """

import random
import getpass
import sys
import M3

def read_message(msg):

    lista=[]

    for i in msg:
        lista.append(i) #se añaden todos los elems. del mensaje a la lista vacía
    return lista

def create_charList():


    alphabetLowerCase=['a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z']
    alphabetUpperCase=[]

    for i in alphabetLowerCase:
        alphabetUpperCase.append(i.upper())

    alphabetAccentMark=['á','é','í','ó','ú','Á','É','Í','Ó','Ú']
    numbers=['0','1','2','3','4','5','6','7','8','9']

    alphabet=numbers+alphabetLowerCase+alphabetUpperCase+alphabetAccentMark

    return alphabet

def create_code():

    charList=create_charList()
    codeList=[]

    for i in range(len(charList)):
        r=random.randint(0,len(charList) - 1)
        codeList.append(charList[r])
        charList.pop(r)
    return codeList

def create_msg_coded(msg):

    message=""
    codeList=create_code()
    alphabet=create_charList()

    for i in msg:
        if i in alphabet:
            k=alphabet.index(i)
            message = message + codeList[k]
        else:
            message = message + i
    return message,codeList

def main():
    pass
    print()
    msg=getpass.getpass("Introduce el mensaje a codificar: ")
    print()
    msg_coded,codeList=create_msg_coded(msg)
    print ("El mensaje codificado es: {}".format(msg_coded))

    M3.write_code(codeList,msg_coded)

if __name__ == '__main__':
    main()
