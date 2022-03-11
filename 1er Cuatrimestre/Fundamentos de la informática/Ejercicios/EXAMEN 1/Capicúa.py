asterisco="*"

for i in range(1,10):
    for j in range(1000,10000):
        num=j
        cadena=str(num)
        capicua=""
        for j in cadena:
            capicua=j+capicua

        c1=num//1000

        if c1==i:
            if cadena == capicua:
                print(capicua,end=" ")

    print()
    print(80*asterisco)