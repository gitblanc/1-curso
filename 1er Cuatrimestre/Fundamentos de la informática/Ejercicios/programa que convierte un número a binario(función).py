import getpass
def binario(dec):
    binario=""#se pone vacío para luego ir añadiendo caracteres
    if dec==0:
        return "0"
    while dec>0:
        binario=str(dec%2)+binario
        dec=dec//2
    return binario

num=int(getpass.getpass("Introduzca un número:"))
print()
print()
print(binario(num))
