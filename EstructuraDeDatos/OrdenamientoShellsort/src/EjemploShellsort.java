import java.util.Arrays;

class Shellsort{
	
	public void ordenar(int[] numeros) {
		
		int intervalo = numeros.length/2;
		
		while(intervalo>0) {
			for(int i = intervalo; i<numeros.length; i++) {
				int j=i-intervalo;
				while(j>0) {
					int k = j + intervalo;
					if(numeros[j] <= numeros[k]) {
						j-=1;
					}else {
						int aux = numeros[j];
						numeros[j] = numeros[k];
						numeros[k] = aux;
						j-=intervalo;
					}
				}
			}
			intervalo = intervalo/2;
		}
			
			
		
	}//ordenar
	
}//class

public class EjemploShellsort {

	public static void main(String[] args) {
		
		Shellsort ss = new Shellsort();
		int numeros[]= {12,34,54,2,3};
		System.out.println("Arreglo desordenado: " + Arrays.toString(numeros));
		ss.ordenar(numeros);
		System.out.println("Arreglo ordenado: " + Arrays.toString(numeros));
		
	

	}

}
