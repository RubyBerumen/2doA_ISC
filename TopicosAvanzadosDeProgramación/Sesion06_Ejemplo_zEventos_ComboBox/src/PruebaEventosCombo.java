import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

class EventosComboBox extends JFrame implements ActionListener {
	
	JButton btnConvertir;
	JComboBox<String> temp;
	
	public EventosComboBox() {
		getContentPane().setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(260,150);
		setLocationRelativeTo(null);
		setTitle("Conversor de temperatura");
		setVisible(true);
		
		
		add(new JLabel("Ingresa °C a convertir"));
		JTextField caja1 = new JTextField(5);
		add(caja1);
		
		add(new JLabel("Selecciona la opcion a convertir:"));
		temp = new JComboBox<String>();
		temp.addItem("F°");
		temp.addItem("K°");
		temp.addItem("R°");
		add(temp);
		
		/*JComboBox<String> temp1 = new JComboBox<String>();
		temp1.addItem("F°");
		temp1.addItem("C°");
		add(temp1);*/
		
		btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(this);
		add(btnConvertir);
		
		add(new JLabel("Resultado:"));
		JTextField res = new JTextField(5);
		add(res);
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnConvertir) {
			System.out.println(temp.getSelectedIndex());
			System.out.println(temp.getSelectedItem());
		}
		
	}
	
}//EventosComboBox

public class PruebaEventosCombo {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {	
			@Override
			public void run() {	
				new EventosComboBox();
			}
		});
	

	}

}
