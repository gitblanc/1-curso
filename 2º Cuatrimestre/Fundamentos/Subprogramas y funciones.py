#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      blanc
#
# Created:     21/06/2021
# Copyright:   (c) blanc 2021
# Licence:     <your licence>
#-------------------------------------------------------------------------------
def max_comun_divisor(a, b):
    for i in range(min(a, b), 1, -1):
        if a % i == 0 and b % i == 0:
            return i
    return 1

def factorial(num):
    fact=1
    print("0! = " + str(fact))
    for i in range(1,num+1):
        fact=fact*i
        print("{}! = {}".format(i, fact))



def main():
    pass
"""
    num1=int(input("Introduce un número"))
    num2=int(input("Introduce otro número"))
    print("El max com divisor es: {}".format(max_comun_divisor(num1, num2)))
"""
factorial(int(input("Factorial:")))
if __name__ == '__main__':
    main()
