import java.util.Iterator;

class HilosProcesadores extends Thread{
	
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println("Trabajando en hilo");
		}
	}
}


public class PruebaHilosPrecesadores {

	public static void main(String[] args) {
		
		System.out.println((double)Runtime.getRuntime().totalMemory()/1024/1024 + "MB");
		System.out.println(Runtime.getRuntime().maxMemory());
		System.out.println(Runtime.getRuntime().freeMemory());
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		Runtime runtime = Runtime.getRuntime();
		for (int i = 0; i < runtime.availableProcessors(); i++) {
			
		}
		
		

	}

}
