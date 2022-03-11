def main():
    pass

    x1=float(input("Longitud del primer lado:"))
    x2=float(input("Longitud del segundo lado:"))
    x3=float(input("Longitud del tercer lado:"))

    if x1>x2+x3 or x2>x1+x3 or x3>x1+x2:
        print("El triángulo especificado NO existe")
    else:
        print("El triángulo especificado existe")


if __name__ == '__main__':
    main()
