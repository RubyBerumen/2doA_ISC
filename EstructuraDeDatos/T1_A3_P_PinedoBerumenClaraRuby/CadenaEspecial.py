'''
Created on 17 dic. 2020

@author: Ruby
'''

class VectorCadenaEspecial:
    
    def __init__(self, cadena):
        self.__cadena=cadena
    
    def getCadena(self):
        return self.__cadena
    def setCadena(self, cadena):
        self.__cadena=cadena
    
    def mostrarCadenaInvertida(self):
        aux = reversed(self.getCadena())
        print("[", end="")
        for e in aux:
            for i in range(len(e)-1,-1,-1):
                print(e[i], end="")
            print("    ",end="")
        print("]", end="")
        print()
    def agregarCaracter(self, subC, pos, caracter):
        subC=subC-1
        pos=pos-1
        palabras=self.getCadena()
        while(subC>=len(palabras)):
            print("Ingresa otra posicion para la subcadena:  ")
            subC=self.validar()-1
        
        palabra=palabras[subC]
        while(pos>len(palabra)):
            print("Ingresa otra posicion para el caracter: ")
            pos=self.validar()-1
        
        if(pos==0):
            palabra=caracter+palabra
        elif(pos==len(palabra)):
            palabra=palabra+caracter
        else:
            palabra=palabra[0:pos]+caracter+palabra[pos:]
        
        palabras[subC]=palabra;
        self.setCadena(palabras);    
    def eliminarCaracter(self, subC, pos):
        subC=subC-1
        pos=pos-1
        palabras=self.getCadena()
        while(subC>=len(palabras)):
            print("Ingresa otra posicion para la subcadena: ")
            subC=self.validar()-1
        
        palabra=palabras[subC]
        while(pos>len(palabra)):
            print("Ingresa otra posicion para el caracter: ")
            pos=self.validar()-1
        
        
        if(pos==0):
            palabra=palabra[1:]
        elif(pos==len(palabra)-1):
            palabra=palabra[:-2]
        else:
            palabra=palabra[0:pos]+palabra[pos+1:]
        
        palabras[subC]=palabra
        self.setCadena(palabras)
    def agregarSubcadena(self, subC, cad):
        subC=subC-1
        palabras= self.getCadena()
        palabras.append("")
        while(subC>len(palabras)-1):
            print("Ingresa otra posicion para la subcadena:  ")
            subC=self.validar()-1
        if(subC==0):
            for i in range(len(palabras)-1,0,-1):
                palabras[i]=palabras[i-1]
            palabras[0]=cad
        elif(subC==len(palabras)-1):
            palabras[len(palabras)-1]=cad
        else:
            for i in range(len(palabras)-1,subC,-1):
                palabras[i]=palabras[i-1]
            palabras[subC]=cad
        self.setCadena(palabras)
    def eliminarSubcadena(self, subC):
        subC=subC-1
        palabras=self.getCadena()
        while(subC>=len(palabras)):
            print("Ingresa otra posicion para la subcadena: ")
            subC=self.validar()-1
        
        if(subC==0):
            for i in range(len(palabras)-1):
                palabras[i]=palabras[i+1]
            
        elif(subC==len(palabras)-1):
            pass
        else:
            for i in range(len(palabras)-1):
                
                if(i>=subC):
                    palabras[i]=palabras[i+1]
        palabras.pop()
        self.setCadena(palabras)
    def camelCaseEspecial(self):
        out=""
        palabras=self.getCadena()
        for i in range(len(palabras)):
            out=out+palabras[i]+" "
        
        strUp=out.upper()
        strLo=out.lower()
        j=0
        
        for i in range(len(out)):
            if (out[i]!=' '):
                j+=1
            if(j%2!=0):
                print(strUp[i],end="")
            else: 
                print(strLo[i],end="") 
        print()
    def primerLetraMayuscula(self):
        palabras=self.getCadena()
        for i in range(len(palabras)):
            print(palabras[i].capitalize(),end="    ")
        print()
    def validar(self):
        err=1
        while err==1:
            try:
                r = int(input())
            except:
                print("Opcion invalida, intenta de nuevo:")
                err=1
            else:
                if r>0:
                    err=0
                else:
                    print("Debes ingresar un numero")
                    err=1
        return r

vce = VectorCadenaEspecial([""])
opc = 0

print("Debes llenar el vector")
print("Ingresa un tamano: ")
tamano = vce.validar()

palabras=[]          
for i in range(tamano):
    palabras.append(str(input(f"Ingresa el elemento {i+1}: ")))
vce1 = VectorCadenaEspecial(palabras)

while opc!=8:
    print("1)Mostrar cadena invertida")
    print("2)Agregar caracter en posicion especifica")
    print("3)Eliminar caracter en posicion especifica")
    print("4)Agregar subcadena en posicion especifica")
    print("5)Eliminar subcadena en posicion especifica")
    print("6)Mostrar cadena en formato camel case especial")
    print("7)Mostrar primera letra en mayuscula")
    print("8)Salir")
    print("Escribe una opcion")
    opc = vce.validar()
    if opc<1 or opc>8:
        print("Opcion invalida")
    elif opc==1:
        vce1.mostrarCadenaInvertida()
    elif opc==2:
        print("Ingresa la posicion de la subcadena:  ")
        sub = vce.validar()
        print("Ingresa la posicion del caracter dentro de la subcadena: ")
        pos = vce.validar()
        caracter = input("Ingresa el caracter a agregar: ")[0]
        vce1.agregarCaracter(sub, pos, caracter)
    elif opc==3:
        print("Ingresa la posicion de la subcadena: ")
        sub = vce.validar()
        print("Ingresa la posicion del caracter dentro de la subcadena:")
        pos = vce.validar()
        vce1.eliminarCaracter(sub, pos)
    elif opc==4:
        print("Ingresa la posicion de la subcadena:")
        sub = vce.validar()
        cad = str(input("Ingresa la subcadena a agregar:  ")).lower()
        vce1.agregarSubcadena(sub, cad)
    elif opc==5:
        print("Ingresa la posicion de la subcadena:")
        sub = vce.validar()
        vce1.eliminarSubcadena(sub)
    elif opc==6:
        vce1.camelCaseEspecial()
    elif opc==7:
        vce1.primerLetraMayuscula()
  

