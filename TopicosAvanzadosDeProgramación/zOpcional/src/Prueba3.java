import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class Productor implements Runnable{
	char vectorCarac[];
	Sincronizar objsincronizar;
	public Productor(char[] vectorCarac,Sincronizar objsincronizar) {
		this.vectorCarac = vectorCarac;
		this.objsincronizar=objsincronizar;
	}
	
	@Override
	public void run() {
		objsincronizar.leer(vectorCarac);
		
	}
	
}

class Consumidor implements Runnable{
	char vectorCarac[];
	Sincronizar objsincronizar;
	public Consumidor(char[] vectorCarac,Sincronizar objsincronizar) {
		this.vectorCarac = vectorCarac;
		this.objsincronizar=objsincronizar;
	}
	@Override
	public void run() {
		
		try {
			objsincronizar.actualizar(vectorCarac);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
class Sincronizar{
	
	private int limite=1;
	private boolean bandera=false;
	private int c;
	public synchronized void leer(char vectorCarac[]) {
		
		//byte contador=0;
		File archivo = new File("texto1.txt");
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			//int c = br.read();
			c =0;
			while(c != -1) {
				while(bandera) {
					wait();
				}
				limite++;
				vectorCarac[0]=(char)c;
				c = br.read();
				System.out.println("Lenyendo--> "+(char)c);
				bandera=true;
				notifyAll();
			}
			
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					br.close();
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		System.out.println();
	}//Metodo Leer
	
	public synchronized void actualizar(char vectorCarac[]) throws InterruptedException {
		
		File archivo=new File("texto2.txt");
		FileWriter fw=null;
		PrintWriter pw=null;
		try {
			fw=new FileWriter("texto2.txt",false);
			pw=new PrintWriter(fw);
			//for (int i = 0; i < limite; i++) {
			while(c!=-1) {
					while(!bandera) {
						wait();
					}
				if(Character.isDigit(vectorCarac[0])) {
					pw.print(vectorCarac[0]);
					System.out.println("Actualizando -->"+vectorCarac[0]);
					System.out.println("Archivo actualizado");
				}
				bandera=false;
				notifyAll();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
			
			e.printStackTrace();
		}finally {
			pw.close();
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//------------------------------
	}//Metodo actualizar
	
}
public class Prueba3 {

	public static void main(String[] args) {
		
		char vectorCarac[]=new char[1];
		
		Sincronizar obj=new Sincronizar();
		Thread hilo1=new Thread(new Productor(vectorCarac, obj));
		Thread hilo2=new Thread(new Consumidor(vectorCarac, obj));
		hilo1.start();
		System.out.println("--------------------------------");
		hilo2.start();
		
	}

}