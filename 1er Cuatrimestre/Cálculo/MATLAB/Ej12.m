u1=[1,1,1];u2=[1,3,1];u3=[-2,1,3]
S=[u1;u2;u3]
BaseS=colspace(sym(S))
u=[1,1,2]
syms x y z
X=[x,y,z]

P=S.' %matriz de paso de Bc3 a Bs

Ecsist=P*u.'

