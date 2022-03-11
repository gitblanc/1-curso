#PRODUCTO DE DOS NÚMEROS SIN USAR EL OPERADOR*
# eDUARDO bLANCO bIELSA 9/10/20

#pedir  valores de entrada a y b
#sumar tantas veces como valga b
#mostrar el resultado

multiplicando=float(input("multiplicando"))
multiplicador=int(input("multiplicador"))
producto=0

for i in range(multiplicador):
    producto = producto + multiplicando

print("El producto de",multiplicando,"por",multiplicador,"es",producto)








