import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;

class LayoutNulo extends JFrame{
	
	public LayoutNulo() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,300);
		setTitle("Hoda");
		setLocationRelativeTo(null);
		
		JLabel txtTitulo = new JLabel("Formulario de registro");
		txtTitulo.setBounds(0, 0, 300, 50);
		txtTitulo.setBackground(new Color(255,0,0));
		add(txtTitulo);
		
		JLabel txtNumControl = new JLabel("Numero de control:");
		txtNumControl.setBounds(0, 55, 150, 50);
		add(txtNumControl);
		
		JTextField cajaNumControl = new JTextField();
		cajaNumControl.setBounds(130, 60, 100, 30);
		add(cajaNumControl);
		
		
		setVisible(true);
	}
	
}

public class PruebaLayoutNulo {

	public static void main(String[] args) {

		
		new LayoutNulo();
		
		

	}

}
