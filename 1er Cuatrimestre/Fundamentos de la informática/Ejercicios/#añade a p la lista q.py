def añade(p,q):#añade a p la lista q
    print(p,"principio añade",id(p))
    #p=p+q#no se puede hacer
    for i in q:
        p.append(i)
    #TAMBIEN VALE p[:]=p+q   //reemplaza todos los elementos de la lista por otra nueva
    print(p,"final añade",id(p))


a=[10,20,30]
b=[40,50]
print(a,"antes",id(a))
añade(a,b)
print(a,"después",id(a))

