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

class BufferVector {
	private char[] vectChar;
	@SuppressWarnings("unused")
	
	public synchronized void obetenerCaracteres() {
		File ac=new File("./src/archivo.txt");
		
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader(ac);
			br=new BufferedReader(fr);
			
			String ln;
			while((ln=br.readLine())!=null){
				vectChar=new char[ln.length()];
				vectChar=ln.toCharArray();
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {fr.close();}
			catch (IOException e) {
				e.printStackTrace();
				}
		}
	}
	
	public synchronized void eliminarCaracteres(){
		for(int i=0;i<vectChar.length;i++){
			if((vectChar[i]>='a' && vectChar[i]<='z') || (vectChar[i]>='A' && vectChar[i]<='Z')) {
			}else {
				vectChar[i]='-';
			}
		}
	}

	public char[] getVectorCaracteres() {
		return vectChar;
	}
	
}

class LecturaCaracteresVetor implements Runnable {
	private BufferVector vectorCompartido;

	public LecturaCaracteresVetor(BufferVector vectorCompartido) {
		this.vectorCompartido=vectorCompartido;
	}
	
	@Override
	public void run() {
		vectorCompartido.obetenerCaracteres();
	}
}

class EliminarCaracteresVetor implements Runnable {
	private BufferVector vectorCompartido;

	public EliminarCaracteresVetor(BufferVector vectorCompartido) {
		this.vectorCompartido=vectorCompartido;
	}
	
	@Override
	public void run() {
		vectorCompartido.eliminarCaracteres();
	}	
}


class EscribirEnArchivo {
	
	String cad;
	
	public void guardarEnArchivo(char[] caracteres) {
		FileWriter archivo =null;
		PrintWriter pr=null;
		cad="";
		
		try {
			archivo = new FileWriter("./src/Archivo.txt", false);
			pr = new PrintWriter(archivo);
			for(int i=0;i<caracteres.length;i++){
				if(caracteres[i]!='-')
					cad+=caracteres[i];
			}	
			pr.println(cad);
			System.out.println("Se guardo el archivo con solo letras");
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				archivo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}


public class Prueba2 {

	public static void main(String[] args) {
		
		 EscribirEnArchivo eea = new EscribirEnArchivo();
	        BufferVector bv = new BufferVector();
	        LecturaCaracteresVetor lec = new LecturaCaracteresVetor(bv);
	        EliminarCaracteresVetor ecs = new EliminarCaracteresVetor(bv);

	        ExecutorService es=Executors.newCachedThreadPool();
	        es.execute(lec);
	        es.execute(ecs);
	        es.shutdown();

	        try{
	            boolean terminado=es.awaitTermination(4, TimeUnit.MINUTES);
	            if(terminado) {
	                eea.guardarEnArchivo(bv.getVectorCaracteres());
	            }else {
	                System.out.println("Tiempo excedido");
	            }
	        }catch(InterruptedException e){
	            e.printStackTrace();
	        }

	}

}
