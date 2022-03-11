def ordenada(lista):
    # se recorre la lista mirando si algún elemento es menor que el anterior
    # empezando en 1 para que el anterior sea 0
    fallos=sum([1 for i in range(1,len(lista)) if lista[i]<lista[i-1]])
    return fallos==0

print(ordenada([9,11,10,20]))
print(ordenada(["Ana","Juan","Teresa"]))