
/*
   SINCRONIZACION
   	Cuando dos o mas hilos utilizan el mismo recurso en sus procesos
   	
   	Por ejemolo un vector, una coleccion o un objeto cualquiera
   		Ejemplo real:
   			Reserva de boletos
   			Actualizacion de cuenta bancaria
   			Conexion a BD
   			Gestion de la BD (CRUD)
 */


class InstruccionSQL{
	public void enviarInstrucciones(String sql) {
		System.out.println("Ejecutando consulta");
		System.out.println("Ejecutando consulta: " + sql);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Instruccion ejecutada. FIN");
		
	}
}


class HiloEnviarInstruccionSQL implements Runnable{
	InstruccionSQL instruccionSQL;
	String sql;
	
	public HiloEnviarInstruccionSQL(InstruccionSQL instruccionSQL, String sql) {
		super();
		this.instruccionSQL = instruccionSQL;
		this.sql = sql;
	}

	@Override
	public void run() {
		instruccionSQL.enviarInstrucciones(sql);
		
	}
}


public class PruebaSincronizacion {

	public static void main(String[] args) {
		
		InstruccionSQL isq = new InstruccionSQL();
		
		Thread h1 = new Thread(new HiloEnviarInstruccionSQL(isq, "Deposito a banco")); 
		h1.start();
		
		Thread h2 = new Thread(new HiloEnviarInstruccionSQL(isq, "Retiro a banco")); 
		h2.start();

		

	}

}
