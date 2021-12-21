'''
Created on 17 dic. 2020

@author: Ruby
'''

class Conjunto:
    
    def __init__(self, elementos):
        if elementos is None:
            self.__elementos = []
        else:
            self.__elementos = elementos
    
    def getElementos(self):
        return self.__elementos
    def setElementos(self, elementos):
        self.__elementos=elementos
    
    def mostrarElementos(self):
        eds = self.getElementos()
        print("[ ", end="")
        for e in eds:
            print(e, end=", ")
        print("]", end="")
        print("\n")
        
    def eliminarDuplicados(self, elementos):
        elementos = list(dict.fromkeys(elementos))
        return elementos
    
    def union(self, conjuntoA, conjuntoB):
        elementos1 = conjuntoA.getElementos()
        elementos2 = conjuntoB.getElementos()
        
        elementos1 = elementos1+elementos2
        elementos1 = self.eliminarDuplicados(elementos1)
        elementos1.sort()
        
        union = Conjunto(elementos1)
        return union
    
    def interseccion(self, conjuntoA, conjuntoB):
        elementos1 = conjuntoA.getElementos()
        elementos1 = self.eliminarDuplicados(elementos1)
        elementos2 = conjuntoB.getElementos()
        elementos2 = self.eliminarDuplicados(elementos2)
        interseccion = []
        
        for i in range(len(elementos1)):
            for j in range(len(elementos2)):
                if(elementos1[i]==elementos2[j]):
                    interseccion.append(elementos1[i])
                    
        interseccion.sort()
        res  = Conjunto(interseccion)
        return res
    
    def diferencia(self, conjuntoA, conjuntoB):
        elementos1 = conjuntoA.getElementos()
        elementos1 = self.eliminarDuplicados(elementos1)
        elementos2 = conjuntoB.getElementos()
        elementos2 = self.eliminarDuplicados(elementos2)
        diferencia = []
        
        diferente=1
        for i in range(len(elementos1)):
            diferente=1
            for j in range(len(elementos2)):
                if(elementos1[i]==elementos2[j]):
                    diferente=diferente*0
            if diferente==1:
                diferencia.append(elementos1[i])
                 
                    
        diferencia.sort()
        dif = Conjunto(diferencia)
        return dif
    
    
conjunto = Conjunto([])

cont = 0
a = 100
conjuntoA = []

for i in range(1,a+1):
    for j in range(1,i+1):
        if(i%j==0):
            cont+=1
    if(cont==2):
        conjuntoA.append(i)
    cont=0

conjuntoB = []

b = 350
for i in range(1,b+1):
    if(b%i==0):
        conjuntoB.append(i)
        
conjA = Conjunto(conjuntoA)
conjB = Conjunto(conjuntoB)
print("Conjunto A:", end="")
conjA.mostrarElementos()
print("Conjunto B:", end="")
conjB.mostrarElementos()

opc=0

while opc!=9:
    print("1. Union(A U B)")
    print("2. Interseccion (A n B)")
    print("3. Diferencia (A - B)")
    print("4. Diferencia (B - A)")
    print("5. Salir")
    
    opc = int(input("Escribe una de las opciones"))
    
    if opc<1 or opc>5:
        print("Debes ingresar numeros entre 1 y 5")
    elif opc==1:
        conjunto = conjunto.union(conjA, conjB)
        conjunto.mostrarElementos()
    elif opc==2:
        conjunto = conjunto.interseccion(conjA, conjB)
        conjunto.mostrarElementos()
    elif opc==3:
        conjunto = conjunto.diferencia(conjA, conjB)
        conjunto.mostrarElementos()
    elif opc==4:
        conjunto = conjunto.diferencia(conjB, conjA)
        conjunto.mostrarElementos()
    elif opc==5:
        break
        
        