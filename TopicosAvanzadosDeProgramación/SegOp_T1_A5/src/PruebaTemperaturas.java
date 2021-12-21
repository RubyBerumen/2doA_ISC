import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class Ventana extends JFrame implements ActionListener{
	
	JTextField caja1,caja2;
	JComboBox<String> cmb1 = new JComboBox<String>();
	JComboBox<String> cmb2 = new JComboBox<String>();
	
	public Ventana() {
		getContentPane().setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(250,105);
		setLocationRelativeTo(null);
		setTitle("Conversor temperaturas");
		setVisible(true);
		
		JLabel lblConv = new JLabel("Convertir:");
		add(lblConv);
		
		caja1 = new JTextField(5);
		caja1.setToolTipText("Presiona enter para convertir");
		caja1.addActionListener(this);
		caja1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				String value = caja1.getText();
				int code=ke.getKeyCode();
				if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')	||	(!value.contains(".")&&ke.getKeyChar()=='.') || (code==KeyEvent.VK_BACK_SPACE)||	(!value.contains("-")&&ke.getKeyChar()=='-')) {
					caja1.setEditable(true);
				}else{
					caja1.setEditable(false);
				}
			}
		});
		add(caja1);
		
		cmb1.addItem("Centigrados");
		cmb1.addItem("Fahrenheit");
		cmb1.addItem("Rankine");
		cmb1.addItem("Kelvin");
		cmb1.addActionListener(this);
		add(cmb1);
		
		JLabel a = new JLabel("A:");
		add(a);
		
		cmb2.addItem("Centigrados");
		cmb2.addItem("Fahrenheit");
		cmb2.addItem("Rankine");
		cmb2.addItem("Kelvin");
		cmb2.addActionListener(this);
		add(cmb2);
		
		caja2 = new JTextField(5);
		caja2.setEditable(false);
		add(caja2);
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (caja1.getText().equals("")||caja1.getText().equals(".")) {
			caja1.setText("0");
		}
		if (cmb1.getSelectedItem()==cmb2.getSelectedItem()) {
			JOptionPane.showMessageDialog(null, "Debes seleccionar otra opción", "InfoBox: " + "Incoherencia", JOptionPane.INFORMATION_MESSAGE);
		}else if (e.getSource()==caja1||e.getSource()==cmb1||e.getSource()==cmb2) {
			double res = Double.parseDouble(caja1.getText());
			
			if (cmb1.getSelectedItem()=="Centigrados" && cmb2.getSelectedItem()=="Fahrenheit") {
				res=(res*1.8)+32;
			}else if (cmb1.getSelectedItem()=="Centigrados" && cmb2.getSelectedItem()=="Rankine") {
				res=(res*1.8)+491.67;
			}else if (cmb1.getSelectedItem()=="Centigrados" && cmb2.getSelectedItem()=="Kelvin") {
				res=res+ 273.15;
			}else if (cmb1.getSelectedItem()=="Fahrenheit" && cmb2.getSelectedItem()=="Centigrados") {
				res=(res-32)*5/9;	
			}else if (cmb1.getSelectedItem()=="Fahrenheit" && cmb2.getSelectedItem()=="Rankine") {
				res=(res+459.67);	
			}else if (cmb1.getSelectedItem()=="Fahrenheit" && cmb2.getSelectedItem()=="Kelvin") {
				res=(res-32)*5/9+273.15;
			}else if (cmb1.getSelectedItem()=="Rankine" && cmb2.getSelectedItem()=="Centigrados") {
				res=(res-491.67)*5/9;	
			}else if (cmb1.getSelectedItem()=="Rankine" && cmb2.getSelectedItem()=="Fahrenheit") {
				res=(res-459.67);	
			}else if (cmb1.getSelectedItem()=="Rankine" && cmb2.getSelectedItem()=="Kelvin") {
				res=res*5/9;	
			}else if (cmb1.getSelectedItem()=="Kelvin" && cmb2.getSelectedItem()=="Centigrados") {
				res=res-273.15;
			}else if (cmb1.getSelectedItem()=="Kelvin" && cmb2.getSelectedItem()=="Fahrenheit") {
				res=(res - 273.15) * 9/5 + 32;
			}else if (cmb1.getSelectedItem()=="Kelvin" && cmb2.getSelectedItem()=="Rankine") {
				res=res*9/5;	
			}
			
			res = Math.round(res * 100.0) / 100.0;
			caja2.setText(String.valueOf(res));
	
		}
		
	}
	
}
public class PruebaTemperaturas {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ventana();
            }
        });

	}

}