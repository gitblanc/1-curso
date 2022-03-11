 v1=[1,3,1,0],v2=[-2,2,-2,0],v3=[8,2,8,0],v4=[-2,0,-2,0]
 B1=[v1;v2;v3;v4]
 w1=[1,0,1,0],w2=[0,-1,1,0],w3=[1,1,0,1],w4=[0,0,-1,1]
B2=[w1;w2;w3;w4]
P=B2.'
M=[B1].'
M1=M*inv(P)
M2=inv(P)*M
M3=B1

Img=colspace(sym(B1))
BaseImg=Img.'
rank(Img)
BaseKer=null(sym(B1)).'
rank(BaseKer)

v=[0.5,-3,1,0]
Img=M1*v.'

a=[1,0,-1,1],b=[2,-3,0,4]
fab=M*[a;b].'






