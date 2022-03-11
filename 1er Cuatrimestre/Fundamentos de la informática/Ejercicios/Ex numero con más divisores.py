#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      alumno
#
# Created:     19/11/2020
# Copyright:   (c) alumno 2020
# Licence:     <your licence>
#-------------------------------------------------------------------------------

def main():
    div = 0
    maxDiv=0
    maxNum=0
    for i in range(100,1001):
        for j in range(2,i):
            if(i%j==0):
                div=div+1

        if(div>maxDiv):
            maxNum=i;
            maxDiv=div;
        div=0

    print("El número con más divisores es ",maxNum,". Son ",maxDiv," divisores",sep="")


if __name__ == '__main__':
    main()
