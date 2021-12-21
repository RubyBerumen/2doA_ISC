import java.util.Scanner;

class Archivo {
	
	private String nombre;
	private String tipo;
	private long tama�o;
	
	public Archivo(String nombre, String tipo, long l) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.tama�o = l;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public long getTama�o() {
		return tama�o;
	}

	public void setTama�o(int tama�o) {
		this.tama�o = tama�o;
	}
	
	
	public void calcularTama�o(int tama�o) {
        double bite = tama�o/8;
        double kb = bite/1024;
        System.out.println("Tama�o en KB = " + kb );
        double mb = kb/1024;
        System.out.println("Tama�o en MB = " + mb );
        double gb = mb/1024;
        System.out.println("Tama�o en GB = " + gb );
        double tb = gb/1024;
        System.out.println("Tama�o en TB = " + tb );
	
	}

	@Override
	public String toString() {
		return "Archivo [nombre=" + nombre + ", tipo=" + tipo + ", tama�o=" + tama�o + "]";
	}
	
	
}//class archivo 



class NodoArbol{
	private NodoArbol nodoIzq;
	private Archivo dato;
	private NodoArbol nodoDer;
	
	public NodoArbol(Archivo dato) {
		this.dato = dato;
	}
	public NodoArbol(){
	}
	
	public NodoArbol getNodoIzq() {
		return nodoIzq;
	}
	public void setNodoIzq(NodoArbol nodoIzq) {
		this.nodoIzq = nodoIzq;
	}
	public Archivo getDato() {
		return dato;
	}
	public void setDato(Archivo dato) {
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
		return "NodoArbol [nodoIzq=" + nodoIzq + ", dato=" + dato + ", nodoDer=" + nodoDer + "]";
	}
	
}// class NodoArbol

class ArbolBinarioBusqueda{
	NodoArbol nodoRaiz;
	
	public ArbolBinarioBusqueda(){
		nodoRaiz=null;
	}

	
	public void agregar(Archivo dato) {
        NodoArbol nuevoNodo = new NodoArbol(dato);
        if(nodoRaiz==null) {
            nodoRaiz = nuevoNodo;
        }else {

            NodoArbol aux = nodoRaiz;
            NodoArbol nodoAnterior;

            while(aux!=null) {
                nodoAnterior = aux;

                if(dato.getTama�o()>aux.getDato().getTama�o()) {  //derecha
                    aux = aux.getNodoDer();
                    if(aux==null)
                        nodoAnterior.setNodoDer(nuevoNodo);
                }else { //izquierda
                    aux = aux.getNodoIzq();
                    if(aux==null)
                        nodoAnterior.setNodoIzq(nuevoNodo);
                }
            }
        }
    }
	
	
	public void recorridoEnorden(NodoArbol nodoRaiz) {
		if(nodoRaiz!=null) {
			recorridoEnorden(nodoRaiz.getNodoIzq());
			System.out.print(nodoRaiz.getDato() + " --> ");
			recorridoEnorden(nodoRaiz.getNodoDer());
		}
	}
	
	
	public int buscarDato(NodoArbol nodo, Archivo dato,int encontrado) {
		if(nodo!=null) {
			if(dato.getTama�o()==nodo.getDato().getTama�o()) {
				encontrado+=1;
			}
			encontrado+=buscarDato(nodo.getNodoIzq(),dato,encontrado);
			encontrado+=buscarDato(nodo.getNodoDer(),dato,encontrado);
		}
		return encontrado;
	}
	

}//class ArbolBinario


class AnalisisDeDatos{
	
	private ArbolBinarioBusqueda abb;
	private long datos[];
	
	public AnalisisDeDatos(ArbolBinarioBusqueda abb,long[] datos) {
		this.abb = abb;
		this.datos = datos;
	}
	public AnalisisDeDatos() {
	}
	
	
	public ArbolBinarioBusqueda getAbb() {
		return abb;
	}
	public void setAbb(ArbolBinarioBusqueda abb) {
		this.abb = abb;
	}
	public long[] getDatos() {
		return datos;
	}
	public void setDatos(long[] datos) {
		this.datos = datos;
	}

	
	public void mostrarInformacion() {
		abb.recorridoEnorden(abb.nodoRaiz);
	}
	
	
	public void buscarPorTipo(NodoArbol nodo, String tipo){
		
		if(nodo!=null) {
			if(tipo.contains(nodo.getDato().getTipo())) {
				long[] dts = this.getDatos();
				dts[0]=dts[0]+1;
				dts[1]=dts[1]+nodo.getDato().getTama�o();
				this.setDatos(dts);
			}
			this.buscarPorTipo(nodo.getNodoIzq(),tipo);
			this.buscarPorTipo(nodo.getNodoDer(),tipo);
		}
	}
	
	
	//public Archivo sacarTipo(ArbolBinarioBusqueda arbol,String tipo) {
     //   return AnalisisDeDatos.buscarPorTipo(arbol.nodoRaiz, tipo);
    //}
	
	
	/*public Archivo busquedaTipo(NodoArbol nodoRaiz,String tipo) {//IZ DER RAIZ
        if(!(nodoRaiz==null)) {
            if(nodoRaiz.getDato().getTipo().equalsIgnoreCase(tipo)) {
                return nodoRaiz.getDato();
            }
            recorridoEnorden(nodoRaiz.getNodoIzq());
            recorridoEnorden(nodoRaiz.getNodoDer());
            nodoRaiz.getDato().calcularTama�o(nodoRaiz.getDato().getTama�o());
        }
        return null;
    }*/
	
	
}// AnalisisDeDatos


public class Examen3Ruby {

	public static void main(String[] args) {
		
		Scanner ent = new Scanner(System.in);
		
		Archivo a = new Archivo("1","1",84584L);
		a.calcularTama�o(0);
		
		ArbolBinarioBusqueda abb = new ArbolBinarioBusqueda();
		abb.agregar(a);
		abb.agregar(a);
		
		long[] datos = {1,2,3,4,5,6,7,8};
		
		AnalisisDeDatos add = new AnalisisDeDatos(abb,datos);
		
		add.buscarPorTipo(abb.nodoRaiz, "x");
		
		long[] fin = add.getDatos();
		
		for (int i = 0; i < fin.length; i++) {
			System.out.println(fin[i]);
		}
		
		
		byte op=0;
		int num;
		boolean salir=false;
		
		do {
			System.out.println("�Cu�ntos archivos desea ingresar?");
			int cantidad = ent.nextInt();
			
			for (int i = 0; i < cantidad; i++) {
				System.out.println("Nombre del archivo: ");
				String nombre=ent.nextLine();
				System.out.println("Tipo de archivo: ");
				String tipo=ent.nextLine();
				System.out.println("Tama�o en Bits: ");
				long tama�o=ent.nextLong();
				Archivo dato = new Archivo(nombre,tipo,tama�o);
				abb.agregar(dato);
			}
		}while(!salir);
		
		
		
		
		
		
	}

}
