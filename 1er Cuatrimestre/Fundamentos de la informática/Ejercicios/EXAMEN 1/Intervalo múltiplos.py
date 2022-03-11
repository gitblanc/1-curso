for i in range(1000,10000):
    num = i
    c4=num%10
    num=num//10
    c3=num%10
    num=num//10
    c2=num%10
    num=num//10
    c1=num%10

    if c1!=7 and c2!=7 and c3!=7 and c4!=7:
        if c1+c2+c3+c4 == 10:
            print(i,":",c1,"+",c2,"+",c3,"+",c4,"= 10")