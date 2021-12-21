'''
Created on 26 nov. 2020

@author: clara
'''


class Shellsort:
    
    def ordenar(self, numeros):
        intervalo = len(numeros)/2
        intervalo = int(intervalo)
        while(intervalo>0):
            for i in range(int(intervalo),len(numeros)):
                j=i-int(intervalo)
                while(j>0):
                    k=j+int(intervalo)
                    if(numeros[j] <= numeros[k]):
                        j-=1
                    else:
                        aux=numeros[j]
                        numeros[j]=numeros[k]
                        numeros[k]=aux
                        j-=int(intervalo)
                        
            intervalo = int(intervalo)/2
            
ss=Shellsort()
numeros = [8,90,67,56,4]
print(f"Arreglo desordenado: {numeros} ")
ss.ordenar(numeros)
print(f"Arreglo ordenado: {numeros} ")                              
                
                
                
                
                
                