u1=[-1,0,2];u2=[0,1,-1];u3=[2,1,-4]
BaseF=rref([u1;u2;u3])

P=[u1.',u2.',u3.']

fu1=[1,0,0];fu2=[0,2,0];fu3=[0,0,-1]

Masociada = [fu1.',fu2.',fu3.']

uBc=[-2,1,4]
ImuBc=uBc*Masociada

ImuB=inv(Masociada)*uBc.'

Kerf=null(sym(Masociada))

Imf=colspace(sym(Masociada))
