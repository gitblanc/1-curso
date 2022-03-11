u1=[1,-1,0,1];u2=[-1,0,1,0];u3=[1,-2,1,2]
U=[u1;u2;u3]
v1=[0,-1,1,1];v2=[1,-2,1,2]
V=[v1;v2]

BaseU=rref(U)
BaseU(3,:)=[]
BaseV=rref(V)

dimU=rank(U)
dimV=rank(V)

Suma1=[BaseU;BaseV]
Base1=rref(Suma1)

Base1(3,:)=[]
Base1(3,:)=[]
BaseSuma=Base1

BaseInter=null(sym(BaseU)).'

