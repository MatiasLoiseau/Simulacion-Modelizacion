from PIL import Image
import math

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
    return C


aa = [[2.71828, 0, 0], [0, 2.71828, 0], [0, 0, 1]]           # matriz 3x3
#e 0 0
#0 e 0
#0 0 1
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
    radianes=((grados*math.pi)/180)
    return radianes

def transformRadianesAGrados(radianes):
    grados=((radianes*180)/math.pi)
    return grados
     
#//////////////////ejercicio2///////////////////////////////////////////

class AffineTransf: # clase base de las transformaciones afines
    def transform(self, p): # transforma el Point p
        pass

class Translation(AffineTransf):
    def __init__(self, x, y):
        self.x = x
        self.y = y
    def transform(self, p):
        #traslacionA = [[1, 0, p[0]], [0, 1, p[1]], [0, 0, 1]] antes es con los 1 como dice el
        #apunte pero nose si esta bien porque suma 1 lugar de mas
        traslacionA = [[0, 0, self.x], [0, 0, self.y], [0, 0, 1]]
        puntoActual = [[p[0]], [p[1]], [1]]
        resultante=productoMatrices(traslacionA, puntoActual)
        print ("Matriz resultante: ", resultante)
        print("Dibujada: ")
        dibujaMatriz(resultante)
        return resultante

def redondearMatriz(matriz):
    fila_M = len(matriz)
    columna_M = len(matriz[0])
    for i in range(fila_M):
        for j in range(columna_M):
            matriz[i][j]=round(matriz[i][j])
    return matriz

class Rotation(AffineTransf):
    def __init__(self, omega):
        self.omega = omega #omega es el angulo en radianes
    def transform(self, p):
        omegaEnAngulo = transformRadianesAGrados(self.omega)
        rotacionA = [[math.cos(omegaEnAngulo), -math.sin(omegaEnAngulo), 0], [math.sin(omegaEnAngulo), math.cos(omegaEnAngulo), 0], [0, 0, 1]]
        puntoActual = [[p[0]], [p[1]], [1]]
        resultante=productoMatrices(rotacionA, puntoActual)
        resultante2=redondearMatriz(resultante)
        print ("Matriz resultante: ", resultante2)
        print("Dibujada: ")
        dibujaMatriz(resultante2)
        return resultante2

class Scale(AffineTransf):
    def __init__(self, lamda):
        self.lamda = lamda #lamda es el coeficiente de escalamiento
    def transform(self, p):
        escalarA = [[self.lamda, 0, 0], [0, self.lamda, 0], [0, 0, 1]]
        puntoActual = [[p[0]], [p[1]], [1]]
        resultante=productoMatrices(escalarA, puntoActual)
        print ("Matriz resultante: ", resultante)
        print("Dibujada: ")
        dibujaMatriz(resultante)
        return resultante

class AffineTransfComposite(AffineTransf): # modela un producto de transformaciones: es un container de AffineTransf
    def __init__(self):
        self.listaTransformaciones=[]
        self.posicion=0
    def add(self, trans): # agregar un AffineTransf al container
        self.listaTransformaciones.append(trans)
        self.posicion=self.posicion + 1
    def transform(self, p):
        for i in range(len(self.listaTransformaciones)):
            matrizNueva=self.listaTransformaciones[i].transform(p)
            p=[matrizNueva[0][0],matrizNueva[1][0]]

#////////////translacion/////////////
#puntoActual = [4,4] #Estoy en el punto, 4 4
#trans = Translation(2,2) # Quiero ir al punto 1 1
#trans.transform(puntoActual)

#////////////Rotacion////////////////
#puntoActual = [10,10] #Estoy en el punto, 10 10
#rot = Rotation(math.pi*4) # Quiero rotarlo pi*4 radianes
#rot.transform(puntoActual)

#////////////Sclae///////////////////
#puntoActual = [10,10] #Estoy en el punto, 10 10
#scal = Scale(5) # Quiero escalarlo por 5
#scal.transform(puntoActual)

#////////////Composite///////////////
puntoActual = [10,10] #Estoy en el punto, 10 10
comp = scal = AffineTransfComposite() # Quiero rotarlo pi*4 radianes
trans = Translation(22,243) # Quiero ir al punto 2,2
rot = Rotation(math.pi*4) # Quiero rotarlo pi*4 radianes
scal = Scale(5) # Quiero escalarlo por 5
comp.add(trans)
comp.add(rot)
comp.add(scal)
comp.transform(puntoActual)
