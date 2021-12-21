import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class ConversorDistancias extends JFrame implements ActionListener{
	
	JTextField caja1,cajaMillas,cajaPies,cajaPulgadas;
	JButton btn;
	ButtonGroup bg = new ButtonGroup();
	JRadioButton rbKm, rbM, rbCm;
	JCheckBox cbMillas,cbPies,cbPulgadas;
	
	public ConversorDistancias() {
		getContentPane().setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(210, 260);
		setLocationRelativeTo(null);
		setTitle("CheckBox_RadioButton");
		setVisible(true);
		
		add(new JLabel("Ingresa cantidad"));
		caja1 = new JTextField(7);
		add(caja1);
		
		add(new JLabel("Selecciona distancia a convertir"));
		rbKm = new JRadioButton("Km");
		bg.add(rbKm);
		add(rbKm);
		rbKm.addActionListener(null);
		
		rbM = new JRadioButton("M");
		bg.add(rbM);
		add(rbM);
		rbCm = new JRadioButton("Cm");
		bg.add(rbCm);
		add(rbCm);
		
		
		add(new JLabel("Selecciona opciones para conversion"));
		cbMillas = new JCheckBox("Millas");
		add(cbMillas);
		cajaMillas = new JTextField(7);
		add(cajaMillas);
		
		cbPies = new JCheckBox("Pies");
		add(cbPies);
		cajaPies = new JTextField(7);
		add(cajaPies);
		
		cbPulgadas = new JCheckBox("Pulgadas");
		add(cbPulgadas);
		cajaPulgadas = new JTextField(7);
		add(cajaPulgadas);
		
		
		btn = new JButton("Convertir");
		add(btn);
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btn) {
			double dato = Double.parseDouble(caja1.getText());
			
			if(rbKm.isSelected()) {
				if(cbMillas.isSelected())
					cajaMillas.setText(String.valueOf(dato/1.609));
			}else if(rbM.isSelected()) {
				
			}else if(rbCm.isSelected()) {
				
			}
			
			
		}
	
		
	}	
	
}//class


public class PruebaCheckBoxRadioButton {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
			
				new ConversorDistancias();
			}
		});
		
		
		
		
		
	}

}
