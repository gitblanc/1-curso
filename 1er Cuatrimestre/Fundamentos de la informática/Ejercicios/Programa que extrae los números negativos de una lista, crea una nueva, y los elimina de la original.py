def extrae(lista):
    negativos=[]
    for i in lista:
        if i<0:
            negativos.append(i)

    for neg in negativos:
        lista.remove(neg)
    return negativos

a=[1,2,-3,4,-5,-6,7]
print("a antes",a)
b=extrae(a)
print("a después",a)
print("lista de negativos",b)