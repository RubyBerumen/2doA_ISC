
class ProcesarImagen extends Thread{
	
	@Override
	public void run() {
		Thread t = new Thread();
		t.setName("Imagen");
		
		Long tInicio = System.currentTimeMillis();
		for (int i = 0; i < 50; i++) {
			System.out.println(i + "-" + t.getPriority() + "-" + t.getName());
		}
		Long tFin = System.currentTimeMillis();
		System.out.println("Tiempo de ejecucion de imagen: " + (tFin - tInicio));
	}
	
}


class ProcesarSonido extends Thread{
	
	@Override
	public void run() {
		Thread t = new Thread();
		t.setName("Sonido");
		for (int i = 0; i < 50; i++) {
			System.out.println(i + "-" + t.getPriority() + "-" + t.getName());
		}
	}
	
}

public class PruebaHilosThread {

	public static void main(String[] args) {
		System.out.println("Iniciando main");

		ProcesarImagen hiloPI = new ProcesarImagen();
		hiloPI.start();
		
		ProcesarSonido hiloPS = new ProcesarSonido();
		hiloPS.start();
		
		
		System.out.println("Terminando main");
	}

}
