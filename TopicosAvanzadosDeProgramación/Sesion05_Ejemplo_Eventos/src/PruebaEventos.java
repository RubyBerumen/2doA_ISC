import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

								//paso1: ImplementarInterfaz
class CalculadoraChafa extends JFrame implements ActionListener{
	
	public CalculadoraChafa() {
		getContentPane().setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(350,200);
		setTitle("Calculadora");
		setLocationRelativeTo(null);
		
		
		JLabel lblNumControl = new JLabel("Ingresa número 1:");
		add(lblNumControl);
		JTextField cajaNumControl = new JTextField(10);
		add(cajaNumControl);
		
		add(new JLabel("Ingresa número 2: "));
		JTextField cajaNombre = new JTextField(10);
		add(cajaNombre);
		JButton btnSum = new JButton("+");
		//Paso 2: Registrar el oyente al componente
		btnSum.addActionListener(this);
		add(btnSum);
		JButton btn1 = new JButton("-");
		add(btn1);
		JButton btn2 = new JButton("x");
		add(btn2);
		JButton btn3 = new JButton("/");
		add(btn3);
		
	
		
		
		setVisible(true);
	}

	
	@Override					//Paso 3: Implementar método ActionPreformed
	public void actionPerformed(ActionEvent e) {
	
		
	}
	
	
	
}


public class PruebaEventos {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculadoraChafa();
            }
    });
		
	}

}
