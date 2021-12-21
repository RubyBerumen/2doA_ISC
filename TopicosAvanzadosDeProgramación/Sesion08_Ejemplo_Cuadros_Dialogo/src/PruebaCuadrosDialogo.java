import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Ventana extends JFrame{
	
	public Ventana() {
		getContentPane().setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(250, 105);
		setLocationRelativeTo(null);
		setTitle("Cuadros de dialogo");
		setVisible(true);
		
		JButton btn1 = new JButton("MassageDialog");
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(rootPane, "Hola");
				JOptionPane.showMessageDialog(rootPane, "Hola", "Mensaje", JOptionPane.WARNING_MESSAGE);
				JOptionPane.showMessageDialog(rootPane, "Hola", "Mensaje", JOptionPane.QUESTION_MESSAGE);
				JOptionPane.showMessageDialog(rootPane, "Hola", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(rootPane, "Hola", "Mensaje", JOptionPane.ERROR_MESSAGE);
			}
		});
		add(btn1);
		
		
		JButton btn2 = new JButton("ConfirmDialog");
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(JOptionPane.showConfirmDialog(rootPane, "¿Estas segura(o)?"));
			}
		});
		add(btn2);
		
		
		JButton btn3 = new JButton("InputDialog");
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(JOptionPane.showInputDialog(rootPane,"Ingresa cantidad de datos a analizar"));
			}
		});
		add(btn3);
		
	}
	
}


public class PruebaCuadrosDialogo {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
			
				new Ventana();
			}
		});
	

	}

}
