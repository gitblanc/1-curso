def distancia(a,b):
    # distancia debida a la diferencia de longitudes
    dist_longitudes=abs(len(a)-len(b))
    # distancia debida a la diferencia entre valores
    dist_valores=0
    for i in range(min(len(a),len(b))):
        if a[i]!=b[i]:
            dist_valores=dist_valores+1
    # distancia total
    return dist_longitudes+dist_valores

print(distancia([1.9,1.4,1.2,0,1.7],[1.7,1.4,0.1,0,1.7]))
print(distancia([0.2,0,0.1,0,1.1,0.6,0,1.7],[0.2,0,0.1,0,1.1,1.1,1.4]))