import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


class VentanaPrincipal extends JFrame implements ActionListener{
	
	JLabel lblFuncion = new JLabel("f(x)=sin(2x)+x^2");
	JLabel lblX0 = new JLabel("x0=");
	JLabel lblH = new JLabel("h=");
	JLabel lbl3Puntos = new JLabel("3 PUNTOS");
	JLabel lbl5Puntos = new JLabel("5 PUNTOS");
	JRadioButton radioIzq3 = new JRadioButton("Izquierda");
	JRadioButton radioCen3 = new JRadioButton("Centro");
	JRadioButton radioDer3 = new JRadioButton("Derecha");
	JRadioButton radioCen5 = new JRadioButton("Centro");
	ButtonGroup bg = new ButtonGroup();
	JTextField txtbX0 = new JTextField();
	JTextField txtbH = new JTextField();
	JButton calcular = new JButton("Calcular");
	
	public VentanaPrincipal() {
		
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,230);
		setLocationRelativeTo(null);
		setTitle("Programa Derivacion");
		setVisible(true);
		
		asignacion();
		lblFuncion.setBounds(150, 13, 170, 20);
		lblX0.setBounds(43, 43, 50, 20);
		lblH.setBounds(43, 64, 50, 20);
		lbl3Puntos.setBounds(182, 43, 100, 20);
		lbl5Puntos.setBounds(290, 43, 100, 20);
		radioIzq3.setBounds(180, 60, 80, 25);
		radioCen3.setBounds(180, 89, 80, 25);
		radioDer3.setBounds(180, 117, 80, 25);
		radioCen5.setBounds(290, 87, 80, 25);
		txtbX0.setBounds(68,43,80,20);
		txtbH.setBounds(68,64,80,20);
		calcular.setBounds(150, 150, 100, 22);
		
		txtbX0.addKeyListener(new KeyAdapter() {//validacion
			public void keyPressed(KeyEvent ke) {
				String value = txtbX0.getText();
				int code=ke.getKeyCode();
				if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')	||	(!value.contains(".")&&ke.getKeyChar()=='.') || (code==KeyEvent.VK_BACK_SPACE)||	(!value.contains("-")&&!value.contains(".")&&ke.getKeyChar()=='-')) {
					txtbX0.setEditable(true);
				}else{
					txtbX0.setEditable(false);
				}
			}
		});
		
		txtbH.addKeyListener(new KeyAdapter() {//validacion
			public void keyPressed(KeyEvent ke) {
				String value = txtbH.getText();
				int code=ke.getKeyCode();
				if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')	||	(!value.contains(".")&&ke.getKeyChar()=='.') || (code==KeyEvent.VK_BACK_SPACE)||	(!value.contains("-")&&!value.contains(".")&&ke.getKeyChar()=='-')) {
					txtbH.setEditable(true);
				}else{
					txtbH.setEditable(false);
				}
			}
		});
		calcular.addActionListener(this);
		
		addAll(lblFuncion,lblX0,lblH,lbl3Puntos,lbl5Puntos,radioIzq3,radioCen3,radioDer3,radioCen5,txtbX0,txtbH,calcular);
	}//Constructor
	
	public void asignacion() {
		bg.add(radioIzq3);
		bg.add(radioCen3);
		bg.add(radioDer3);
		bg.add(radioCen5);
	}
	
	public void addAll(Component...componentesGraficos) {
		for (Component c: componentesGraficos) {
			add(c);
		}
	}
	
	public double funcion(double x) {
		return (Math.sin(2*x)+Math.pow(x, 2));
	}
	
	public double calcularIzq3Puntos(double x0, double h) {
		return (1/(2*h))*((-3*funcion(x0))+(4*funcion(x0+h))+(-funcion(x0+(2*h))));
	}
	public double calcularCen3Puntos(double x0, double h) {
		return (1/(2*h))*(funcion(x0-h)+funcion(x0+h));
	}
	public double calcularDer3Puntos(double x0, double h) {
		return (1/(2*h))*((funcion(x0-(2*h)))+(-4*funcion(x0-h))+(3*funcion(x0)));
	}
	public double calcularCen5Puntos(double x0, double h) {
		return (1/(12*h))*((funcion(x0-(2*h)))+(-8*funcion(x0-h))+(8*funcion(x0+h))+(-funcion(x0+(2*h))));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		double x0;
		double h;
		if (txtbX0.getText().equals("")||txtbH.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Faltan uno o más valores");
		}else {
			x0 = Double.parseDouble(txtbX0.getText());
			h = Double.parseDouble(txtbH.getText());
			if (h==0) {
				JOptionPane.showMessageDialog(null, "h no puede ser igual a cero");
			}else {
				if (radioIzq3.isSelected()) {
					JOptionPane.showMessageDialog(null, "El resultado es: "+ calcularIzq3Puntos(x0, h));
				}else if (radioCen3.isSelected()) {
					JOptionPane.showMessageDialog(null, "El resultado es: "+ calcularCen3Puntos(x0, h));
				}else if (radioDer3.isSelected()) {
					JOptionPane.showMessageDialog(null, "El resultado es: "+ calcularDer3Puntos(x0, h));
				}else if (radioCen5.isSelected()) {
					JOptionPane.showMessageDialog(null, "El resultado es: "+ calcularCen5Puntos(x0, h));
				}else {
					JOptionPane.showMessageDialog(null, "Escoge algún método");
				}
			}
			
		}
		
	}//actionPerformed
	
}

public class PruebaDerivacion {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanaPrincipal();
			}
		});
		
	}

}
