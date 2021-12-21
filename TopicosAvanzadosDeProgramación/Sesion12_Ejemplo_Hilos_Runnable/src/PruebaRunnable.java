
// Paso 1: implementar la interfaz Runnable
class Hilo1 implements Runnable{

	// Paso 2: implementar el métoso abstracto run()
	@Override
	public void run() {
		//Paso 3: Crear el código que se ejecutará como otro hilo por separado
		//Simular un proceso a travez de un ciclo
		
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " - " + i);
		}
		
	}
	
}

class Hilo2 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " - " + i);
		}
		
	}
	
}


public class PruebaRunnable {

	public static void main(String[] args) {
		//hilo pricipal de ejecucion
		System.out.println("Iniciando hilo principal");
		System.out.println(Thread.currentThread());
		
		// Paso 4: Instanciar las clases que implementen runnable
		Thread h1 = new Thread(new Hilo1());
		
		// Paso 5: Invocar el metodo Start del objeto THREAD
		h1.start();
		
		Thread h2 = new Thread(new Hilo1());
		h2.start();
		
		
		
		System.out.println("Terminando hilo principal");
	}

}
