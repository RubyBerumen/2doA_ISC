
class NodoArbol{
	private NodoArbol nodoIzq;
	private int dato;
	private NodoArbol nodoDer;
	
	public NodoArbol(int dato) {
		this.dato = dato;
	}

	public NodoArbol getNodoIzq() {
		return nodoIzq;
	}

	public void setNodoIzq(NodoArbol nodoIzq) {
		this.nodoIzq = nodoIzq;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public NodoArbol getNodoDer() {
		return nodoDer;
	}

	public void setNodoDer(NodoArbol nodoDer) {
		this.nodoDer = nodoDer;
	}

	@Override
	public String toString() {
		return "NodoArbol [nodoIzquierdo=" + nodoIzq + ", dato=" + dato + ", nodoDerecho=" + nodoDer + "]";
	}
	
}

/* 1) Crear
 * 2) Agregar
 * 3) Eliminar (dato)
 * 4) Mostrar  (recorrido)
 */

class ArbolBinarioBusqueda {
	NodoArbol nodoRaiz;
	
	// 1) Crear (ya está listo con el constructor predeterminado)
	
	// 2) Agregar 
	public void agregarDato(int dato){
		NodoArbol nuevoNodo  = new NodoArbol(dato);
		
		if(nodoRaiz == null) {
			nodoRaiz = nuevoNodo;
		}else {
			NodoArbol nodoActual = nodoRaiz;
			NodoArbol nodoPadre;
			
			while(nodoActual != null) {
				nodoPadre = nodoActual;
				
				if(dato <= nodoActual.getDato()) { //mover a la izquierda
					nodoActual = nodoActual.getNodoIzq();
					if(nodoActual == null) {
						nodoPadre.setNodoIzq(nuevoNodo);
					}
					
				}
			}
			
		}
	}// agregarDato
	
	
}//class ArbolBinarioBusqueda

public class ArbolBinario {

	public static void main(String[] args) {
		

	}

}
