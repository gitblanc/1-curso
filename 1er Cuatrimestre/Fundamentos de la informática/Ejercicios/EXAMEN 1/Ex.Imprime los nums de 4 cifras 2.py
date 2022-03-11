for i in range(1000,10000):
    c1=i//1000
    c2=i//100%10
    c3=i//10%10
    c4=i%10

    if(c1==c4 and c2==c3):
        print(i,end=" ")
    elif(c1==c2==c3==c4):
        print(i,end=" ")
    print()


for c1 in range(10):
    for c2 in range(10):
        for c3 in range(10):
            for c4 in range(10):
                num = c1*1000+c2*100+c3*10+c4
                if c1==c4 and c3==c2:
                    print(num,end=" ")
    print("\n"+80*"*")