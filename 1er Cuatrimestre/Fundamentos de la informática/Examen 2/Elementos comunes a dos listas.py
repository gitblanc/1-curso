def equalElems(listaA,listaB):
    lista=[]
    for i in listaA:
        if i not in lista and i in listaB:   #not in lista es para que no haya elementos duplicados
            lista.append(i)
    return lista

def main():
    pass
    a=[1,6,6,5,2,8]
    b=[2,8,8,6]
    print("Los elementos presentes en ambas listas son {}".format(equalElems(a,b)))

if __name__ == '__main__':
    main()
