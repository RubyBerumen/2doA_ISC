import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Ventana extends JFrame {
	
	JTextField cajaNombre;
	JComboBox comboEdad;
	JRadioButton radioCarrera;
	JButton btnEnviar,btnRestablecer;
	
	public Ventana() {
		getContentPane().setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(250, 105);
		setLocationRelativeTo(null);
		setTitle("Cuadros de dialogo");
		setVisible(true);
		
		add(new JLabel("Ingresa datos"));
		
		cajaNombre = new JTextField(10);
		add(cajaNombre);
		
		String datos[]= {"Selecciona opcion...","1","2","3"};
		comboEdad = new JComboBox(datos);
		add(comboEdad);
		
		radioCarrera = new JRadioButton("ISC");
		add(radioCarrera);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setEnabled(false);
		add(btnEnviar);
		
		btnRestablecer = new JButton("Restablecer");
		//btnRestablecer.addActionListener(this);
		add(btnRestablecer);
		
	}
}

public class PruebaReestablecerComponentes {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
			
				new Ventana();
			}
		});
	
		
	}

}
