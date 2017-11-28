from PIL import Image

A = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]           # matriz 3x3
B = [[1], [1], [1]]   # matriz 3x1

def creaMatriz(n,m):
    matriz = []
    for i in range(n):
        a = [0]*m
        matriz.append(a)
    return matriz

def dibujaMatriz(M):
    for i in range(len(M)):
        print '[',
        for j in range(len(M[i])):
            print '{:>3s}'.format(str(M[i][j])),
        print ']'

#Entra matriz A nxm y B mxk
#Sale matriz C nxk
def productoMatrices(A,B):
    fila_A = len(A)
    columna_A = len(A[0])
    fila_B = len(B)
    columna_B = len (B[0])
    
    #Verifica si nxm mxk (m==m)
    if columna_A != fila_B:
        print ('None')
        return
    
    #Se crea matriz nxk
    C = creaMatriz(fila_A, columna_B)
    fila_C = len(C)
    columna_C = len(C[0])

    #Se rellena la matriz del producto de A y B
    for i in range(fila_C):
        for j in range(columna_C):
            for k in range(columna_A):
                C[i][j] += A[i][k]*B[k][j]
    print ("Matriz resultante: ", C)
    print("Dibujada: ")
    dibujaMatriz(C)
    return C


aa = [[2.71828, 0, 0], [0, 2.71828, 0], [0, 0, 1]]           # matriz 3x3
bb = [[1], [1], [1]]   # matriz 3x1


def transform(M,p):
    matrizTransformada = 0
    fila_M = len(M)
    columna_M = len(M[0])
    fila_p = len(p)
    columna_p = len (p[0])
    if((fila_M == 3) and (columna_M == 3) and (fila_p == 3) and (columna_p == 1)):
        matrizTransformada=productoMatrices(M,p)
    else:
        print("La matriz no es 3x3 o el punto no es 3x1")
    return matrizTransformada

def transformGradosARadianes(grados):
    radianes=((grados*3.14159)/180)
    return radianes
    

#productoMatrices(A,B)
transform(aa,bb)



