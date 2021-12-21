import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


class Calculos {
	public double funcion(double x) {
					//x^2 + 1 
		double x0 = (Math.pow(x, 2))+1;
		return x0;
		
	}
	//METODO 3 PUNTOS IZQUIERDA
	public double m3PuntosIZQ(double x, double h) {
		double respuesta;
		respuesta = ((-3*funcion(x))+(4*funcion(x+h))-(funcion(x+2*h)))/(2*h);
		return respuesta;
	}
	//METODO 3 PUNTOS CENTRO
	public double m3PuntosCENTRO(double x,double h) {
		double respuesta;
		respuesta = (funcion(x-h)+funcion(x+h))/(2*h);
		return respuesta;
	}
	//METODO 3 PUNTOS DERECHA
	public double m3PuntosDER(double x, double h) {
		double respuesta;
		respuesta = ((funcion(x-2*h))-(4*funcion(x-h))+(3*funcion(x)))/(2*h);
		return respuesta;
	}
	//METODO 5 PUNTOS CENTRO
	public double m5PuntosCENTRO(double x, double h) {
		double respuesta;
		respuesta = ((funcion(x-2*h))-(8*funcion(x-h))+(8*funcion(x+h))-(funcion(x+2*h)))/(12*h);
		return respuesta;
	}
	
}



class Ventana extends JFrame implements ActionListener{
	
	JLabel lFuncion = new JLabel("=== FUNCION ===");
	JLabel funcion = new JLabel("f(x) = x^2 + 1 ");
	
	
	JTextField tx0 = new JTextField();
	JTextField th = new JTextField();
	JLabel lx0 = new JLabel("X0 =");
	JLabel lh = new JLabel("h =");
	
	JLabel selecOpcion = new JLabel("Seleccione una opcion");
	JComboBox cMetodos = new JComboBox();
	
	JButton bCalcular = new JButton("CALCULAR");
	
	JLabel lDFuncion = new JLabel("f'(x) = ");
	JTextField dFuncion = new JTextField();
	
	JButton blimpiar = new JButton("LIMPIAR");
	
	
	public Ventana() {
		getContentPane().setLayout(null);
		setSize(380,300);
		setLocationRelativeTo(null);
		setTitle("Calculadora");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(120, 120, 120, 120));
		
		
		setVisible(true);
		
		
		lFuncion.setBounds(125, 10, 100, 20);
		add(lFuncion);
		funcion.setBounds(135, 30, 100, 20);
		add(funcion);
		
		lx0.setBounds(20, 80, 50, 20);
		add(lx0);
		tx0.setBounds(50, 80, 50, 20);
		add(tx0);
		
		lh.setBounds(20, 140, 50, 20);
		add(lh);
		th.setBounds(50, 140, 50, 20);
		add(th);
		
		selecOpcion.setBounds(180,70, 150, 20);
		add(selecOpcion);
		cMetodos.setBounds(185,90, 120, 20);
		cMetodos.addItem("==============");
		cMetodos.addItem("3 puntos(IZQ)");
		cMetodos.addItem("3 puntos(CENTRO)");
		cMetodos.addItem("3 puntos(DER)");
		cMetodos.addItem("5 puntos(CENTRO)");
		add(cMetodos);
		
		
		bCalcular.setBounds(190, 140, 100, 20);
		bCalcular.addActionListener(this);
		add(bCalcular);
	
		lDFuncion.setBounds(80, 200, 100, 20);
		add(lDFuncion);
		
		dFuncion.setBounds(130, 200, 100, 20);
		dFuncion.
		add(dFuncion);
		
		blimpiar.setBounds(130, 230, 100, 20);
		blimpiar.addActionListener(this);
		add(blimpiar);
		
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		double x = 0;
		double h = 0;
		try {
			 x = Double.parseDouble(tx0.getText());
			 h = Double.parseDouble(th.getText());
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null,"Parece que algo anda mal con los valores ingresado");
			tx0.setText("");
			th.setText("");
		}
		String r = "";
		Calculos calculadora = new Calculos();
		if(e.getSource()==bCalcular) {
			if(cMetodos.getSelectedIndex()==0) {
				JOptionPane.showMessageDialog(null, "Seleccione un metodo por favor");
			}else if (cMetodos.getSelectedIndex()==1) {
				r = String.valueOf(calculadora.m3PuntosIZQ(x, h));
				dFuncion.setText(r);
			}else if(cMetodos.getSelectedIndex()==2) {
				r = String.valueOf(calculadora.m3PuntosCENTRO(x, h));
				dFuncion.setText(r);
			}else if(cMetodos.getSelectedIndex()==3) {
				r = String.valueOf(calculadora.m3PuntosDER(x, h));
				dFuncion.setText(r);
			}else if(cMetodos.getSelectedIndex()==4) {
				r = String.valueOf(calculadora.m5PuntosCENTRO(x, h));
				dFuncion.setText(r);
			}
		
			
			
			
		}else if(e.getSource()==blimpiar) {
			tx0.setText("");
			th.setText("");
			dFuncion.setText("");
			cMetodos.setSelectedIndex(0);
		}
	}

}






public class CalculadoraDerivadas {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Ventana();
			}
		});

	}

}
