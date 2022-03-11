.386
.model flat, C

.code

; Complete the procedure
IsValidAssembly PROC

push ebp
mov ebp,esp
add ebp,8
mov ebx, dword ptr[ebp]
add ebp,4
mov ecx, dword ptr[ebp]
add ebp,4
mov edx, dword ptr[ebp]

cmp ecx,edx
jnz incorrecto

cmp ebx,34h
jle incorrecto
mov eax,255
jmp fin

incorrecto:
mov eax,0

fin:
pop ebp
ret

IsValidAssembly ENDP

END