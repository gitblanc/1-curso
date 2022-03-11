u1=[1,-1,1,-1],u2=[2,1,3,1]
CoefEcU=[u1;u2]
BaseU=null(sym(CoefEcU)).'
syms x1 x2 x3 x4
X=[x1,x2,x3,x4]
EcParamU=CoefEcU*X.'
EcParamU1=solve(sym(EcParamU))