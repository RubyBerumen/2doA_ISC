
//Paso 1: importar bibliotecas para crear GUI's (Swing y AWT)
import javax.swing.*;
import java.awt.*;

					   //Paso 2: heredar de JFrame
public class PruebaGUI extends JFrame{
	
	//constructor
	public PruebaGUI() {
		
		//Paso 3: configurar la interfaz gráfica de la ventana principal
		
			//3A: establecer un layout (diferente al predeterinado (BORDERLAYOUT) )
			getContentPane().setLayout(new FlowLayout());
		
			//3B: establecer acción al cerrar la ventana
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		
			//3C: establecer un tamaño inicial
			setSize(300,100);
			
			//3D: establecer titulo
			setTitle("Hoda");
			
			//3E: centrar la ventana
			setLocationRelativeTo(null);
		
			//3F: hacer visible la ventana
			setVisible(true);
		
	}

	public static void main(String[] args) {
		
		//Paso 5: Crear la instancia de la ventana
		new PruebaGUI();
		
	}

}
