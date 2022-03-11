def leet(cadena):
    result=""
    for i in cadena:
        if i == "a" or i == "A":
            result= result+ "4"
        elif i == "e" or i == "E":
            result= result+  "3"
        elif i == "i" or i == "I":
            result= result+  "1"
        elif i == "o" or i == "O":
            result= result+  "0"
        else:
            result=result + i

    return result

    """
    LA MANERA MÁS CORRECTA SERÍA

    def to_leet(a):
        result =""
        for char in a:
            if char in ["a", "á", "A", "Á"]:
                result =result +"4"
            elif char in ["e", "é", "E", "É"]:
                result =result +"3"
            elif char in ["i", "í", "I", "Í"]:
                result =result +"1"
            elif char in ["o", "ó", "O", "Ó"]:
                result =result +"0"
            else:
                result =result +char
    return result

    DEF MAIN

    a =input("Introduce la frase a convertir: ")
    print(to_leet(a))
    """

def main():
    pass

    x=str(input("Introduce la frase a poner en leet:"))

    print("{}".format(leet(x)))

if __name__ == '__main__':
    main()
