l1=float(input("Introduzca la longitud del primer lado"))
l2=float(input("Introduzca la longitud del segundo lado"))
l3=float(input("Introduzca la longitud del tercer lado"))

if l1+l2>l3 and l1+l3>l2 and l2+l3>l1:
    print ("El triángulo existe")
else:
    print("El triángulo especificado no existe")

