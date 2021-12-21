import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class VentanaPrincipal extends JFrame implements ActionListener{
	public static final DecimalFormat df= new DecimalFormat( "#.###" );
	JTextField[][] cajas=new JTextField[2][5];;
	JTextField cajaX=new JTextField();
	JTextField cajaY=new JTextField();
	JLabel txtValores[]=new JLabel[4];
	JButton btnCalcularY=new JButton("Calcular Y");
	
	public VentanaPrincipal() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		for (int i = 0; i<txtValores.length;i+=1) {
			txtValores[i] = new JLabel();
			txtValores[i].setBounds(20,20+(30*i),50,20);
			add(txtValores[i]);
		}
		
		txtValores[0].setText("X0...Xn:");
		txtValores[1].setText("Y0...Yn:");
		txtValores[2].setText("x:");
		txtValores[3].setText("y:");
		
		cajaX.setBounds(70,80,50,20);
		cajaX.addKeyListener(new KeyAdapter() {//Validacion de caja de texto
			public void keyPressed(KeyEvent ke) {
				String value =cajaX.getText();
				int code=ke.getKeyCode();
				if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')	||	(!value.contains(".")&&ke.getKeyChar()=='.') || (code==KeyEvent.VK_BACK_SPACE)||	(value.equals("")&&ke.getKeyChar()=='-')) {
					cajaX.setEditable(true);
				}else{
					cajaX.setEditable(false);
				}
			}
		});
		add(cajaX);
		
		cajaY.setBounds(70,110,50,20);
		cajaY.setEditable(false);
		add(cajaY);
		
		btnCalcularY.setBounds(130,110,100,20);
		btnCalcularY.addActionListener(this);
		add(btnCalcularY);
		
		int l = 0;
		while(true) {//validacion de los numeros
			try {
				l = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuantos números deseas ingresar?"));
				break;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Numero inválido");
			}
		}
		
		cajas = new JTextField[2][l];
		
		for (int i = 0; i < cajas.length; i++) {
			for (int j = 0; j < cajas[0].length; j++) {
				cajas[i][j]=new JTextField();
				cajas[i][j].setBounds(70+(40*j), 20+(30*i), 40, 20);
				add(cajas[i][j]);
			}
			for (JTextField j:cajas[i]) {//Validacion de las cajas de texto
				j.addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent ke) {
						String value =j.getText();
						int code=ke.getKeyCode();
						if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')	||	(!value.contains(".")&&ke.getKeyChar()=='.') || (code==KeyEvent.VK_BACK_SPACE)||	(value.equals("")&&ke.getKeyChar()=='-')) {
							j.setEditable(true);
						}else{
							j.setEditable(false);
						}
					}
				});
			}
		}
		
		setSize(115+(cajas[0].length*40),190);
		setLocationRelativeTo(null);
		setTitle("Interpolación");
		setVisible(true);
		
	}
	
	
	public double calcularY(double x, double ejeX[], double ejeY[]) {
		double sum[] = ejeY.clone();
		double res=0;
		
		for (int i = 0; i < ejeX.length; i++) {
			for (int j = 0; j < ejeX.length; j++) {
				if (i!=j) {
					sum[i]*=(x-ejeX[j]);
					sum[i]/=(ejeX[i]-ejeX[j]);
				}
			}
		}
		
		for (int i = 0; i < sum.length; i++) {
			res+=sum[i];
		}
		
		return res;
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		boolean valido = true;
	
		for (int i = 0; i < cajas.length; i++) {
			for (int j = 0; j < cajas[i].length; j++) {
				if (cajas[i][j].getText().equals(".")||cajas[i][j].getText().equals("-")||cajas[i][j].getText().equals("")) {
					valido = false;
					break;
				}
			}
		}
		
		if (!valido) {
			JOptionPane.showMessageDialog(null, "Una o más cajas están vacias");
		}else{
			double x = Double.parseDouble(cajaX.getText());
			double ejeX[] = new double[cajas[0].length];
			double ejeY[] = new double[cajas[1].length];
			for (int i = 0;i<ejeX.length;i+=1) {
				ejeX[i]=Double.parseDouble(cajas[0][i].getText());
			}
			for (int i = 0;i<ejeY.length;i+=1) {
				ejeY[i]=Double.parseDouble(cajas[1][i].getText());
			}
			cajaY.setText(df.format(calcularY(x, ejeX, ejeY)));
		}
		
	}
	
}

public class Prueba {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {//Invoca a la interfaz
			@Override
			public void run() {
				
				new VentanaPrincipal();
				
			}
		});

	}

}