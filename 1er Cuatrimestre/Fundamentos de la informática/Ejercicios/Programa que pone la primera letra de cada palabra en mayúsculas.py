def capitalize (a):
    palabras=frase.split(" ")
    for i in range(len(palabras)):
        palabra=palabras[i]
        palabras[i]=palabra[:1].upper()+palabra[1:]
    return " ".join(palabras)

frase=str(input("Introduzca una frase cualquiera"))
print(capitalize(frase))


