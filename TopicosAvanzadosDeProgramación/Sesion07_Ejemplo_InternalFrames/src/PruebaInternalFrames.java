import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

class Conversor extends JFrame {
	
	JMenuBar menuBar;
	JMenu menuConversores;
	JMenuItem menuItemDistancias, menuItemTemperaturas, menuItemMoneda;
	
	public Conversor() {
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 700);
		setLocationRelativeTo(null);
		setTitle("Internal Frames");
		setVisible(true);
		
		menuBar = new JMenuBar();
			menuConversores = new JMenu("Conversores");
				menuItemDistancias = new JMenuItem("Distancias");
				menuItemDistancias.setMnemonic(KeyEvent.VK_D);
				//menuItemDistancias.setAccelerator (KeyStroke.getKeyStroke.); 
				menuConversores.add(menuItemDistancias);
				menuItemMoneda = new JMenuItem("Moneda");
				menuConversores.add(menuItemMoneda);
				menuItemTemperaturas = new JMenuItem("Temperaturas");
				menuItemTemperaturas.setToolTipText("TEMP");
				menuConversores.add(menuItemTemperaturas);
				menuConversores.add(menuItemMoneda);
		menuBar.add(menuConversores);
		setJMenuBar(menuBar);
		
		JDesktopPane dp = new JDesktopPane();
		add(dp,BorderLayout.CENTER);
		
		
	}//constructor

	

}//class


public class PruebaInternalFrames {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
			
				new Conversor();
			}
		});
		
	}

}
