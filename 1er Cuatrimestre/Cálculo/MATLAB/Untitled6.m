U=[-1 0 2; 0 1 -1; 2 1 -4]
rank(U)
MPaso_R3_B1=U.'
MPaso_B1_R3=inv(MPaso_R3_B1)
M=[1 0 0; 0 2 0; 0 0 -3]
M2=MPaso_R3_B1*M*inv(MPaso_R3_B1)
u1=[-1 0 2]
e2=[0 1 0]
v_R3=2*u1+e2
Imv_R3=M2*v_R3.'
Imv_B1=inv(MPaso_R3_B1)*Imv_R3
kerf=null(sym(M))
kerf=null(sym(M2))
Imf=colspace(sym(M))
M_inv=inv(M)
v_B1=[3 1 0]
Imv_B1inv=M_inv*v_B1.'
Imv_R3inv=MPaso_R3_B1*Imv_B1
