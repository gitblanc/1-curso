p1 = float(input ("Introduzca la presión del neumático delantero izquierdo"))
p2 = float(input ("Introduzca la presión del neumático delantero derecho"))
p3 = float(input ("Introduzca la presión del neumático trasero izquierdo"))
p4 = float(input ("Introduzca la presión del neumático trasero derecho"))

presion = 2.5
margen = 0.2

if p1 > presion + margen:
    print("El neumático delantero izquierdo tiene la presión alta ")
elif p1 < presion - margen:
    print("El neumático delantero izquierdo tiene la presión baja ")

if p2 > presion + margen:
    print("El neumático delantero derecho tiene la presión alta ")
elif p2 < presion - margen:
    print("El neumático delantero derecho tiene la presión baja ")

if p3 > presion + margen:
    print("El neumático trasero izquierdo tiene la presión alta ")
elif p3 < presion - margen:
    print("El neumático trasero izquierdo tiene la presión baja ")

if p4 > presion + margen:
    print("El neumático trasero derecho tiene la presión alta ")
elif p4 < presion - margen:
    print("El neumático trasero derecho tiene la presión baja ")