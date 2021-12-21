import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

class Ventana extends JFrame{
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	//Constructor
	public Ventana() {
		getContentPane().setLayout(gbl); //Configuración de la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Gauss Seidel");
		setLocationRelativeTo(null);
		setVisible(true);
		this.getContentPane().setBackground(Color.white);
		ArrayList<JTextField> datos = new ArrayList<JTextField>();
		JTextArea arriba = new JTextArea("                                                                                                                                    ");
		componente(arriba, 0, 0, 10, 2, GridBagConstraints.BOTH);
		JTextArea izquierda = new JTextArea("               ");
		componente(izquierda, 0, 0, 2, 20, GridBagConstraints.BOTH);
		JTextArea abajo = new JTextArea("               ");
		componente(abajo, 0, 14, 10, 2, GridBagConstraints.BOTH);
		JLabel titulo = new JLabel("           Gauss Seidel");
		componente(titulo, 4, 2, 10, 1, GridBagConstraints.BOTH);
		JTextArea middle1 = new JTextArea("                         ");
		componente(middle1, 2, 3, 10, 1, GridBagConstraints.BOTH);
		
		//Primera línea de elementos
		JTextField ingresar00 = new JTextField(5);
		componente(ingresar00, 2, 4, 1, 1, GridBagConstraints.BOTH);
		datos.add(ingresar00);
		JLabel txt1 = new JLabel("  x +  ");
		componente(txt1, 3, 4, 1, 1, GridBagConstraints.BOTH);
		JTextField ingresar01 = new JTextField(5);
		componente(ingresar01, 4, 4, 1, 1, GridBagConstraints.BOTH);
		datos.add(ingresar01);
		JLabel txt2 = new JLabel("  y +  ");
		componente(txt2, 5, 4, 1, 1, GridBagConstraints.BOTH);
		JTextField ingresar02 = new JTextField(5);
		componente(ingresar02, 6, 4, 1, 1, GridBagConstraints.BOTH);
		datos.add(ingresar02);
		JLabel txt3 = new JLabel("  z =  ");
		componente(txt3, 7, 4, 1, 1, GridBagConstraints.BOTH);
		JTextField ingresar03 = new JTextField(5);
		componente(ingresar03, 8, 4, 1, 1, GridBagConstraints.BOTH);
		datos.add(ingresar03);
		
		//Segunda línea de elementos
		JTextArea middle2 = new JTextArea("                                              ");
		componente(middle2, 2, 5, 10, 1, GridBagConstraints.BOTH);
		JTextField ingresar10 = new JTextField(5);
		componente(ingresar10, 2, 6, 1, 1, GridBagConstraints.BOTH);
		datos.add(ingresar10);
		JLabel txt4 = new JLabel("  x +  ");
		componente(txt4, 3, 6, 1, 1, GridBagConstraints.BOTH);
		JTextField ingresar11 = new JTextField(5);
		componente(ingresar11, 4, 6, 1, 1, GridBagConstraints.BOTH);
		datos.add(ingresar11);
		JLabel txt5 = new JLabel("  y +  ");
		componente(txt5, 5, 6, 1, 1, GridBagConstraints.BOTH);
		JTextField ingresar12 = new JTextField(5);
		componente(ingresar12, 6, 6, 1, 1, GridBagConstraints.BOTH);
		datos.add(ingresar12);
		JLabel txt6 = new JLabel("  z =  ");
		componente(txt6, 7, 6, 1, 1, GridBagConstraints.BOTH);
		JTextField ingresar13 = new JTextField(5);
		componente(ingresar13, 8, 6, 1, 1, GridBagConstraints.BOTH);
		datos.add(ingresar13);
		
		//Tercera línea de elementos
		JTextArea middle3 = new JTextArea("                          ");
		componente(middle3, 2, 7, 10, 1, GridBagConstraints.BOTH);
		JTextField ingresar20 = new JTextField(5);
		componente(ingresar20, 2, 8, 1, 1, GridBagConstraints.BOTH);
		datos.add(ingresar20);
		JLabel txt7 = new JLabel("  x +  ");
		componente(txt7, 3, 8, 1, 1, GridBagConstraints.BOTH);
		JTextField ingresar21 = new JTextField(5);
		componente(ingresar21, 4, 8, 1, 1, GridBagConstraints.BOTH);
		datos.add(ingresar21);
		JLabel txt8 = new JLabel("  y +  ");
		componente(txt8, 5, 8, 1, 1, GridBagConstraints.BOTH);
		JTextField ingresar22 = new JTextField(5);
		componente(ingresar22, 6, 8, 1, 1, GridBagConstraints.BOTH);
		datos.add(ingresar22);
		JLabel txt9 = new JLabel("  z =  ");
		componente(txt9, 7, 8, 1, 1, GridBagConstraints.BOTH);
		JTextField ingresar23 = new JTextField(5);
		componente(ingresar23, 8, 8, 1, 1, GridBagConstraints.BOTH);
		datos.add(ingresar23);
		
		//Botones limpiar y calcular
		JTextArea middle4 = new JTextArea("                                 ");
		componente(middle4, 2, 9, 10, 1, GridBagConstraints.BOTH);
		JButton limpiar = new JButton("Limpiar Cajas");
		componente(limpiar, 2, 10, 3, 1, GridBagConstraints.BOTH);
		limpiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for(int i=0; i<12; i++) {
					datos.get(i).setText("");
				}
			}
		});
		
		JButton calcular = new JButton("Calcular");
		componente(calcular, 6, 10, 3, 1, GridBagConstraints.BOTH);
		
		
		//Impedir que se escriban letras y caracteres especiales
		KeyAdapter noLetras = new KeyAdapter() {
			public void keyTyped(KeyEvent key) {
				char presionada = key.getKeyChar();
				if((presionada<48 || presionada>57) && presionada!='.' && presionada!='-') {
					key.consume();
				}
			}
		};
		
		//KeyAdapter de cada caja de texto
		for(int i=0; i<12; i++) {
			datos.get(i).addKeyListener(noLetras);
		}
		
		//ActionListener del botón calcular
		calcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {	
				boolean bandera = true;
				for(int i=0; i<12; i++) { 
					String dato = datos.get(i).getText();
					int cont1 = 0;
					int cont2 = 0;
					if(dato.length()>0) {
						for(int j=0; j<dato.length(); j++) {
							if(dato.charAt(j)=='.')
								cont1++;
							if(dato.charAt(j)=='-')
								cont2++;
							if(cont1>1 || cont2>1) {
								bandera = false;
								JOptionPane.showMessageDialog(rootPane, "Una o más entradas no son válidas, inténtelo nuevamente...");
								break;
							}
						}
					}
				}
				if(bandera) {
				float[][] arrayDatos = new float[3][4];
				int cont = 0;
				for(int i=0; i<3; i++) {//Guardar los datos ingresados en un arreglo bidimensional
					for(int j=0; j<4; j++) {
						if(datos.get(cont).getText().equals(""))
							arrayDatos[i][j] = 0;
						else
							arrayDatos[i][j] = Float.parseFloat(datos.get(cont).getText());
						cont++;
					}
				}
				GaussSeidel gs = new GaussSeidel();
				JOptionPane.showMessageDialog(rootPane, gs.resolver(arrayDatos));
				
				}
			}
		});
		
		pack();
		
		
	}
	//Metodo para agregar los componentes
	public void componente(JComponent c, int gx, int gy, int gw, int gh, int f) {
		gbc.gridx = gx;
		gbc.gridy = gy;
		gbc.gridheight = gh;
		gbc.gridwidth = gw;
		gbc.fill = f;
		gbl.setConstraints(c, gbc);
		add(c);
	}
}

class GaussSeidel {
	
	public String resolver(float[][] datos) {
		 double X1, X2, X3, Y1, Y2, Y3, Z1, Z2, Z3, val1, val2, val3;
		 X1 = datos[0][0];
		 X2 = datos[1][0];
		 X3 = datos[2][0];
		 Y1 = datos[0][1];
		 Y2 = datos[1][1];
		 Y3 = datos[2][1];
		 Z1 = datos[0][2];
		 Z2 = datos[1][2];
		 Z3 = datos[2][2];
		 val1 = datos[0][3];
		 val2 = datos[1][3];
		 val3 = datos[2][3];
		 double arregloX []= new double[1000]; 
		 double arregloY []= new double[1000];    
		 double arregloZ []= new double[1000];  
		 int cont;  
		 double error = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el error con el que se trabajará")); 
		 double errorX = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el error de X")); 
		 double errorY = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el error de Y"));  
		 double errorZ = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el error de Z")); 
		 cont = 1;
		 while (errorX > error || errorY > error || errorZ > error){
			 arregloX [cont] = (val1-(Y1*arregloY[cont-1])-(Z1*arregloZ[cont-1]))/X1; 
			 arregloY [cont] = (val2-(X2*arregloX[cont])-(Z2*arregloZ[cont-1]))/Y2; 
			 arregloZ [cont] = (val3-(X3*arregloX[cont])-(Y3*arregloY[cont]))/Z3; 
		     errorX  = Math.abs((arregloX[cont] - arregloX[cont-1])/arregloX[cont])*100;
		     errorY  = Math.abs((arregloY[cont] - arregloY[cont-1])/arregloY[cont])*100; 
		     errorZ  = Math.abs((arregloZ[cont] - arregloZ[cont-1])/arregloZ[cont])*100;           
		     cont++;               
		 }
		 double x, y, z;
		 x = arregloX[cont-2];
		 y = arregloY[cont-2];
		 z = arregloZ[cont-2];
		 if(x!=x || y!=y || z!=z)
				return ("El sistema de ecuaciones ingresado no tiene solución o tiene una infinidad de soluciones.");
			else
				return (x+"\nY = "+y+"\nZ = "+z);
	}
	
}

public class PruebaGaussSeidel {
	public static void main(String[] args) {
		
		Ventana ventana = new Ventana();
	}
}
