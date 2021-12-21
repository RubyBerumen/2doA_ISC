'''
Created on Mar 12, 2021

@author: Bryan Valdez
'''
import tkinter as tk
import math

ventana_principal = tk.Tk()
ventana_principal.title("Calculadora PYTHON")
ventana_principal.geometry("300x375")

caja = tk.Entry()
caja.place(x=0,y=0 ,width=300,height=60)
op=0
cache=""

def residuo():
    global op
    global cache
    op = 1
    cache = caja.get()
    caja.delete(0,'end')
def raiz():
    if(caja.get()!=""):
        x = float(caja.get())
        if(x>0):
            x = math.sqrt(x)
            caja.delete(0,'end')
            caja.insert(0,str(x))
        else:
            caja.delete(0,'end')
            caja.insert(0,"NO se puede con numeros negativos")
def potencia():
    if(caja.get()!=""):
        x = float(caja.get())
        x= math.pow(x, 2)
        caja.delete(0,'end')
        caja.insert(0,str(x))  
def sobreX():
    x=0.0
    if(caja.get()!="0"):
        if(caja.get()=="" or caja.get()=="."):
            x = 0.0
        else:
            x = float(caja.get())  
        caja.delete(0,'end')
        if(x!=0):
            x = 1/x
            caja.insert(0,str(x))
        else:
            caja.insert(0,"Se necesita un numero")
    else:
        caja.insert(0,"NO se puede dividir entre 0")
def ce():
    global op
    global cache
    op = 0
    cache = ""
    caja.delete(0,'end')
def c():
    pass
def borrar():
    if(caja.get()!=""):
        x = caja.get()[:-1]
        caja.delete(0,'end')
        caja.insert(tk.END,x)
def swap():
    if(caja.get()!="" or caja.get()!="." or caja.get()!="-"):
        x = float(caja.get()) 
        x = x*(-1)
        caja.delete(0,'end')
        caja.insert(0,str(x))
def dividir():
    global op
    global cache
    op =2
    cache = caja.get()
    caja.delete(0,'end')
def multiplicar():
    global op
    global cache
    op =3
    cache = caja.get()
    caja.delete(0,'end')
def restar():
    global op
    global cache
    op =4
    cache = caja.get()
    caja.delete(0,'end')
def sumar():
    global op
    global cache
    op =5
    cache = caja.get()
    caja.delete(0,'end')

def key0():
    caja.insert(tk.INSERT,"0")
def key1():
    caja.insert(tk.INSERT,"1")
def key2():
    caja.insert(tk.INSERT,"2")
def key3():
    caja.insert(tk.INSERT,"3")
def key4():
    caja.insert(tk.INSERT,"4")
def key5():
    caja.insert(tk.INSERT,"5")
def key6():
    caja.insert(tk.INSERT,"6")
def key7():
    caja.insert(tk.INSERT,"7")
def key8():
    caja.insert(tk.INSERT,"8")
def key9():
    caja.insert(tk.INSERT,"9")
def dot():
    caja.insert(tk.INSERT,".")

def igual():
    n1 = float(cache)
    n2 = float(caja.get())
    if(op==1):
        caja.delete(0,'end')
        x = n1%n2
        caja.insert(0, str(x))
    if(op==2):
        caja.delete(0,'end')
        if(n2==0):
            caja.insert(0, "NO se puede dividir entre 0")
        else:
            x = n1/n2
            caja.insert(0, str(x))
    if(op==3):
        caja.delete(0,'end')
        x = n1*n2
        caja.insert(0, str(x))
    if(op==4):
        caja.delete(0,'end')
        x = n1-n2
        caja.insert(0, str(x))
    if(op==5):
        caja.delete(0,'end')
        x = n1+n2
        caja.insert(0, str(x))
#75x52

btnResiduo = tk.Button(ventana_principal,text="%", command=residuo)#linea 1
btnResiduo.place(x=0,y=60,width=75,height=55)
btnRaiz = tk.Button(ventana_principal, text="√x",  command=raiz)
btnRaiz.place(x=75,y=60,width=75,height=55)
btnPotencia = tk.Button(ventana_principal, text="x^2", command=potencia)
btnPotencia.place(x=150,y=60,width=75,height=55)
btnSobreX = tk.Button(ventana_principal, text="1/x", command=sobreX)
btnSobreX.place(x=225,y=60,width=75,height=55)

btnCe = tk.Button(ventana_principal, text="CE", command=ce)#linea 2
btnCe.place(x=0,y=115,width=75,height=52)
btnC = tk.Button(ventana_principal, text="C", command=c)
btnC.place(x=75,y=115,width=75,height=52)
btnBorrar = tk.Button(ventana_principal, text="<=", command=borrar)
btnBorrar.place(x=150,y=115,width=75,height=52)
btnDividir = tk.Button(ventana_principal, text="÷", command=dividir)
btnDividir.place(x=225,y=115,width=75,height=52)

btn7 = tk.Button(ventana_principal, text="7", command=key7)#linea 3
btn7.place(x=0,y=167,width=75,height=52)
btn8 = tk.Button(ventana_principal, text="8", command=key8)
btn8.place(x=75,y=167,width=75,height=52)
btn9 = tk.Button(ventana_principal, text="9", command=key9)
btn9.place(x=150,y=167,width=75,height=52)
btnMultiplicar = tk.Button(ventana_principal, text="x", command=multiplicar)
btnMultiplicar.place(x=225,y=167,width=75,height=52)

btn4 = tk.Button(ventana_principal, text="4", command=key4)#linea 4
btn4.place(x=0,y=219,width=75,height=52)
btn5 = tk.Button(ventana_principal, text="5", command=key5)
btn5.place(x=75,y=219,width=75,height=52)
btn6 = tk.Button(ventana_principal, text="6", command=key6)
btn6.place(x=150,y=219,width=75,height=52)
btnRestar = tk.Button(ventana_principal, text="-", command=restar)
btnRestar.place(x=225,y=219,width=75,height=52)

btn1 = tk.Button(ventana_principal, text="1", command=key1)#linea 5
btn1.place(x=0,y=271,width=75,height=52)
btn2 = tk.Button(ventana_principal, text="2", command=key2)
btn2.place(x=75,y=271,width=75,height=52)
btn3 = tk.Button(ventana_principal, text="3", command=key3)
btn3.place(x=150,y=271,width=75,height=52)
btnSumar = tk.Button(ventana_principal, text="-", command=sumar)
btnSumar.place(x=225,y=271,width=75,height=52)

btnSwap = tk.Button(ventana_principal, text="+-", command=swap)#linea 6
btnSwap.place(x=0,y=323,width=75,height=52)
btn0 = tk.Button(ventana_principal, text="0", command=key0)
btn0.place(x=75,y=323,width=75,height=52)
btnDot = tk.Button(ventana_principal, text=".", command=dot)
btnDot.place(x=150,y=323,width=75,height=52)
btnEquals = tk.Button(ventana_principal, text="=", command=igual)
btnEquals.place(x=225,y=323,width=75,height=52)

ventana_principal.mainloop()

