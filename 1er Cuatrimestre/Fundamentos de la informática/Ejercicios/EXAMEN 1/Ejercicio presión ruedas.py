def main():
    pass

    x1=float(input("Introduce la presión del neumático delantero izquierdo(bar)"))
    x2=float(input("Introduce la presión del neumático delantero derecho(bar)"))
    x3=float(input("Introduce la presión del neumático trasero izquierdo(bar)"))
    x4=float(input("Introduce la presión del neumático trasero derecho(bar)"))

    p = 2.5
    m = 0.2

    if x1<p-m:
        print("El neumático delantero izquierdo tiene la presión BAJA")
    elif x1>p+m:
        print("El neumático delantero izquierdo tiene la presión ALTA")

    if x2<p-m:
        print("El neumático delantero derecho tiene la presión BAJA")
    elif x2>p+m:
        print("El neumático delantero derecho tiene la presión ALTA")

    if x3<p-m:
        print("El neumático trasero izquierdo tiene la presión BAJA")
    elif x3>p+m:
        print("El neumático trasero izquierdo tiene la presión ALTA")

    if x4<p-m:
        print("El neumático trasero derecho tiene la presión BAJA")
    elif x4>p+m:
        print("El neumático trasero derecho tiene la presión ALTA")

if __name__ == '__main__':
    main()
