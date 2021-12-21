import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


class ConversorDistancias extends JFrame implements ActionListener, KeyListener{
	
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
		caja1.addKeyListener(this);
		
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
			/*Forma de validacion mas lárga
			 * verificar posicion por posicion de la cadena se es numero
			 */
			
			/*Forma de validacion un poco menos larga
			 * expresiones regulares
			 */
			
			/*Forma de valiación un poco menos larga
			 * uso de la clase character
			 */
			
			
			double dato = 0.0;
			
			try {
				dato = Double.parseDouble(caja1.getText());
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(
						rootPane, "Debes Ingresar un número","Info" ,JOptionPane.WARNING_MESSAGE);
			}
			
			
			if(rbKm.isSelected()) {
				if(cbMillas.isSelected())
					cajaMillas.setText(String.valueOf(dato/1.609));
			}else if(rbM.isSelected()) {
				
			}else if(rbCm.isSelected()) {
				
			}
			
			
		}
	
		
	}



	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		JOptionPane.showMessageDialog(rootPane, " "+e.getKeyChar()+"n"+e.getKeyCode());
		
		if(!(e.getKeyCode()>=48 && e.getKeyCode()<=57)) {
			
		}
		
	}



	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
	
}//class

public class PruevaEventosTeclado {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
			
				new ConversorDistancias();
			}
		});
		
	
	}

}
