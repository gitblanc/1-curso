def main():
    pass

    cont=0
    total=0
    finished=False

    while not finished:
         num=float(input("Siguiente número:"))
         if num!=0:
            cont=cont+1
            total=total+num

         else:
            finished=True

    print("La media aritmética es {:.2f}".format(total/cont))



if __name__ == '__main__':
    main()
