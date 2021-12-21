
/*
 	Programación concurrente (MULTIHILO)
 	
 	Concurrencia: Acción de concurrir distintas personas, sucesos o cosas en un mismo lugar o tiempo.
 	Programación concurrente:
 	Programacion paralela:
 	Multiprocesamiento:
 	Multitarea:
 	Hilos de ejecución:
 	
 */


public class PruebaMultihilo {

	public static void main(String[] args) {
		
		
		System.out.println(Thread.currentThread().getId());
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getPriority());
		System.out.println(Thread.currentThread().getState());
		System.out.println(Thread.currentThread().isDaemon());
		System.out.println(Thread.currentThread().isAlive());
		System.out.println(Thread.currentThread().isInterrupted());
		System.out.println(Thread.currentThread().getStackTrace());
		
		Thread hilo1 = Thread.currentThread();
		System.out.println(hilo1.getName());
		hilo1.setName("Hilo principal");
		System.out.println(hilo1.getName());
		hilo1.setPriority(10);
		System.out.println(hilo1.getPriority());
		
		
	}

}
