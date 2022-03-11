def leet (frase):
    frase_leet=""#En un principio está vacía
    for caracter in frase:
        if caracter=="a" in["a","A","á","Á"]:
            frase_leet=frase_leet + "4"
        elif caracter=="e" in["e","E","é","É"]:
            frase_leet=frase_leet + "3"
        elif caracter=="i" in["i","I","í","Í"]:
            frase_leet=frase_leet +"1"
        elif caracter=="o" in["o","O","ó","Ó"]:
            frase_leet=frase_leet + "0"
        else:
            frase_leet=frase_leet + caracter
    return frase_leet

frase=str(input("Introduzca la frase a convertir"))

print(leet(frase))