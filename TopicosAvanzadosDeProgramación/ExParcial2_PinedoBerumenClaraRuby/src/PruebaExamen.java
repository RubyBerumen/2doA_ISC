import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


class LecturaCaracteres implements Runnable {
	private BufferVector vectorN;

	public LecturaCaracteres(BufferVector vectorN) {
		this.vectorN = vectorN;
	}
	
	@Override
	public void run() {
		vectorN.obetenerCaracteres();
	}
}

class EliminarCaracteres implements Runnable {
	private BufferVector vectorN;

	public EliminarCaracteres(BufferVector vectorN) {
		this.vectorN=vectorN;
	}
	
	@Override
	public void run() {
		vectorN.eliminarCaracteres();
	}	
}

class BufferVector {
	private char[] caracteres;
	@SuppressWarnings("unused")
	
	public synchronized void obetenerCaracteres() {
		File archivoC = new File("./src/caracteres.txt");
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(archivoC);
			br = new BufferedReader(fr);
			
			String fila;
			while((fila=br.readLine())!=null){
				caracteres=new char[fila.length()];
				caracteres=fila.toCharArray();
			}
		}
		catch (FileNotFoundException e) {e.printStackTrace();}
		catch (IOException e) {e.printStackTrace();}
		finally {
			try {fr.close();}
			catch (IOException e) {e.printStackTrace();}
		}
	}
	
	public synchronized void eliminarCaracteres(){
		for(int i=0;i<caracteres.length;i++){
			if((caracteres[i]>='0' && caracteres[i]<='9')) {
			}else {
				caracteres[i]='-';
			}
		}
	}

	public char[] getVectorCaracteres() {
		return caracteres;
	}


	@Override
	public String toString() {
		return "Vector Caracteres= " + Arrays.toString(caracteres);
	}
}

class EscribirEnArchivo {
	
	String cadena;
	
	public void escribirCaracteres(){
		FileWriter archivo = null;
		PrintWriter pr = null;
		try {
			archivo = new FileWriter("./src/caracteres.txt", false);
			pr = new PrintWriter(archivo);
			pr.print(cadena);
			
			System.out.println("Se agregron los caracteres");
			
		}catch (IOException e) {
			System.out.println("Error!");
		}finally {
			try {archivo.close();}
			catch(IOException e) {
				System.out.println("El archivo no se pudo cerrar");
			}
		}
	}
	
	public void guardarNuevo(char[] caracteres) {
		FileWriter archivo1 =null;
		PrintWriter pr=null;
		cadena="";
		
		try {
			archivo1 = new FileWriter("./src/caracteresnuevo.txt", false);
			pr = new PrintWriter(archivo1);
			for(int i=0;i<caracteres.length;i++){
				if(caracteres[i]!='-')
					cadena+=caracteres[i];
			}
					
			pr.println(cadena);
			System.out.println("Se guardo el archivo");
		}catch (IOException e) {
			System.out.println("Error al guardar o eliminar");
		}finally{
			try{archivo1.close();}
			catch(IOException e) {
				System.out.println("No se pudo cerrar archivo");
			}
		}
	}
}




public class PruebaExamen {
	
	public static void main(String[] args) {
		
		EscribirEnArchivo escribirEnArchivo = new EscribirEnArchivo();
		escribirEnArchivo.escribirCaracteres();
		
		BufferVector vc = new BufferVector();
		LecturaCaracteres lc = new LecturaCaracteres(vc);
		EliminarCaracteres ec = new EliminarCaracteres(vc);
		
		ExecutorService es=Executors.newCachedThreadPool();
		es.execute(lc);
		es.execute(ec);
		
		es.shutdown();
		
		try{
			boolean tareaTerminada = es.awaitTermination(3, TimeUnit.MINUTES);
			if(tareaTerminada){
				escribirEnArchivo.guardarNuevo(vc.getVectorCaracteres());
			}
			else {
				
			}
				
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
