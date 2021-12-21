import javax.swing.*;
import java.awt.*;

class EjemploPaneles extends JFrame{
	
	public EjemploPaneles() {
		getContentPane().setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,300);
		setTitle("Ejemplo Paneles");
		setLocationRelativeTo(null);
		
		JPanel panelIzq = new JPanel();
		panelIzq.setBackground(new Color(255,219,204));
		panelIzq.setLayout(new FlowLayout());
		panelIzq.setBorder(BorderFactory.createTitledBorder("Datos personales"));
		panelIzq.setPreferredSize(new Dimension(130,250));
		add(panelIzq);
		
		JPanel panelDer = new JPanel();
		panelDer.setBackground(new Color(162,225,219));
		panelDer.setLayout(new FlowLayout());
		panelDer.setBorder(BorderFactory.createTitledBorder("Datos académicos"));
		panelDer.setPreferredSize(new Dimension(130,250));
		add(panelDer);
		
		
		
		setVisible(true);
	}
}


public class PruebaPaneles {

	public static void main(String[] args) {
		
		new EjemploPaneles();
	

	}

}
