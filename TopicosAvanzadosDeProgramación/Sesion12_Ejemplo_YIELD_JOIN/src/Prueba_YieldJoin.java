
/*
 * YIELD - Permite que un hilo que ejecuta una tarea larga, pero no relevante, 
 * 		   le de accesi a orto hio para su ejecucion de una tarea mas importante. 
 * 
 * JOIN - Pausa la ejecucion de un hilo hasta el termino de la ejecucion de otro.
 * 
 *		NOTA: El JOIN debe ser utilizado dentro del hilo en ejecucion que se desea pausar.
 */

class HiloProcesadorTexto implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Escribiendo");
			System.out.println("Redimensionando imagen");
			System.out.println("Revisión ortográfica");
			Thread.yield();//Indica al planificador de hilos que puede dar su tiempo 
							//de procesador a otro hilo con mayor prioridad, esperando
							//para continuar su ejecucion.
		}
		
	}
	
}



class HiloProgramacion implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Codificando 10 lineas");
			System.out.println("Complilando");
			System.out.println("Depurando");
			System.out.println("Complilando");
		}
		
	}
	
}


public class Prueba_YieldJoin {

	public static void main(String[] args) {
		System.out.println("Encendiendo ordenador");
		
		Thread hiloPT = new Thread(new HiloProcesadorTexto());
		hiloPT.start();
		
		Thread hiloProg = new Thread(new HiloProgramacion());
		hiloProg.start();
		
		
		try {
			hiloPT.join();		//Indica la unión de estos hilos, al hilo principal para que este 
			hiloProg.join();	//espere la terminavion de dichos hilos unidos.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Apagando ordenador");
	}

}
