def main():
    pass

    p=[12,-3,56,1,4]

    print(p)
    p.append(999)#añade un elemento con el 999
    x=p.pop(2)#extrae el elemento cuyo indice es especificado
    for i in range(len(p)):
        p[i]=p[i]+1
    print(p)



if __name__ == '__main__':
    main()
