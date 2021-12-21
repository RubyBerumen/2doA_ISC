import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.*;
class AnalisisEstadistico{
	DecimalFormat df=new DecimalFormat("##.00");
	Scanner entrada=new Scanner(System.in);
	private int datos[];
	public AnalisisEstadistico(int datos[]) {
		this.datos=datos;
	}
	public int[] getDatos() {
		return datos;
	}
	public void setDatos(int[] datos) {
		this.datos = datos;
	}
	
	
	public void obtenerMedia() {
		double sum=0.0;
		for(int i=0;i<datos.length;i++) {
			sum=sum+datos[i];
		}
		System.out.println(sum/datos.length);
	}
	public double obtenerMedia2() {
		double sum=0.0;
		for(int i=0;i<datos.length;i++) {
			sum=sum+datos[i];
		}
		return sum/datos.length;
	}
	public double obtenerModa() {
		HashMap<Integer, Integer> mapa = new HashMap<>();
        for (int x = 0; x < datos.length; x++) {
          int numero = datos[x];
          if (mapa.containsKey(numero)) {
            mapa.put(numero, mapa.get(numero) + 1);
          } else {
            mapa.put(numero, 1);
          }
        }
        int moda = 0, mayor = 0;
        for (HashMap.Entry<Integer, Integer> entry : mapa.entrySet()) {
            if (entry.getValue() > mayor) {
                mayor = entry.getValue();
                moda = entry.getKey();
            }
        }
        return moda;
	}
	public void Mediana() {
		if(datos.length%2==0) {
			Arrays.sort(datos);
			System.out.println(datos[(datos.length/2)-1]);
		}else {
			double x=datos.length/2;
			x=x+1.5;
			int y=(int) x;
			System.out.println(datos[y]);
		}
	}
	public double desviacionRepectoMedia() {
		double media=obtenerMedia2();
		double suma=0.0;
		for(int i=0;i<datos.length;i++) {
			suma=suma+datos[i]-media;
		}
		if(suma<0) {
			suma=suma*-1;
		}
		return suma;
	}
	
	public double[] obtenerDesviaciones() {
		double media = obtenerMedia2();
		double desviaciones[] = new double[datos.length];
		for (int i = 0; i < desviaciones.length; i++) {
			desviaciones[i]=datos[i];
		}
		for (int i = 0; i < datos.length; i++) {
			desviaciones[i]/=media;
			if (desviaciones[i]<0) {
				desviaciones[i]*=(-1);
			}
		}
		
		return desviaciones;
	}
	
	
	public void desviacionMedia() {
		double desviaciones[] =obtenerDesviaciones();
		double desviacionMedia=0.0;
		for (int i = 0; i < desviaciones.length; i++) {
			desviacionMedia+=desviaciones[i];
		}
		desviacionMedia/=desviaciones.length;
		System.out.println(df.format(desviacionMedia));
	}
	public double varianza() {
		 	double x = 0;
	        double media = obtenerMedia2();
	        for (int i = 0;i<datos.length;i=i+1) {
	            x = x + Math.pow((datos[i]-media),2);
	        }
	        x = x/datos.length;
	        return x;
	}
	public void desviacionEstandar() {
		System.out.println(df.format(Math.sqrt(varianza())));
	}
	public void llenado() {
		for(int i=0;i<datos.length;i++) {
			System.out.println("Ingresa el dato "+(i+1)+":");
			datos[i]=entrada.nextInt();
		}
	}
	@Override
	public String toString() {
		return "AnalisisEstadistico [datos=" + Arrays.toString(datos) + "]";
	}
	
	
}

public class Ex1 {

	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		DecimalFormat df=new DecimalFormat("##.00");
		System.out.print("Cuantos datos deseas ingresar?");
		int cantidad=entrada.nextInt();
		int datos[]=new int[cantidad];
		System.out.println();
		AnalisisEstadistico analisis=new AnalisisEstadistico(datos);
		analisis.llenado();
		System.out.println("Datos guardados:");
		System.out.println(analisis);
		
		System.out.println("---------- Resultados--------------");
		System.out.println("Media:");
		analisis.obtenerMedia();
		System.out.println("Moda: "+df.format(analisis.obtenerModa()));
		System.out.println("Mediana: ");
		analisis.Mediana();
		System.out.println("Desviacion respecto a la media: "+analisis.desviacionRepectoMedia());
		System.out.println("Desviacion media: ");
		analisis.desviacionMedia();
		System.out.println("Varianza: "+df.format(analisis.varianza()));
		System.out.println("Desviacion estandar:");
		analisis.desviacionEstandar();
	}

}