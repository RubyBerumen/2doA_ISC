import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//METODO LRC
class VentanaLRC extends JFrame implements ActionListener{
	JLabel lblDato = new JLabel("El dato es:");
	JButton exe = new JButton("Ejecutar");
	JLabel lblError = new JLabel("Error:");
	JTextField txtDato = new JTextField();
	JTextField txtError = new JTextField();
	JLabel lblR = new JLabel("El dato recibido es:");
	JTextField txtR = new JTextField();
	JLabel lblLRCE = new JLabel("LRC Enviado");
	JTextField txtLRCE = new JTextField();
	JLabel lblLRCR = new JLabel("LRC Recibido:");
	JTextField txtLRCR = new JTextField();
	
	String datos = "11001010 11010001";
	int x = 0;
	int x2 = 0;
	
	public VentanaLRC() {
		getContentPane().setLayout(null);
		setSize(450,300);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("LRC");
		setVisible(true);
		
		lblDato.setBounds(100, 50, 100, 20);
		add(lblDato);
		txtDato.setBounds(170, 50, 150, 20);
		txtDato.setText(datos);
		txtDato.setEditable(false);
		add(txtDato);
		
		exe.setBounds(80, 100, 100, 20);
		exe.addActionListener(this);
		add(exe);
		
		lblLRCE.setBounds(230, 100, 100, 20);
		add(lblLRCE);
		txtLRCE.setBounds(310, 100, 100, 20);
		add(txtLRCE);
			
		lblError.setBounds(100, 150, 100, 20);
		add(lblError);
		txtError.setBounds(140, 150, 50, 20);
		add(txtError);
		
		lblLRCR.setBounds(230, 150, 100, 20);
		add(lblLRCR);
		txtLRCR.setBounds(310, 150, 100, 20);
		add(txtLRCR);
		
		lblR.setBounds(90, 200, 150, 20);
		add(lblR);
		txtR.setBounds(200, 200, 150, 20);
		add(txtR);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exe) {
			String lrc = "";
			String lrc2 = "";
			String datos = "11001010 11010001";
			//Separar la cadena del dato para obtener los juegos de 8bits(1Byte)
			String datosVec[] = datos.split(" ");
			int datosInt[][]= new int [datosVec.length][8] ;
			
			//ciclo para almacenar cada bite en un vector bidimencional
			for(int i = 0; i < datosVec.length;i++) {
					String datosChar[] = datosVec[i].split("");
					for(int j = 0;j<datosChar.length;j++) {
						datosInt[i][j]=Integer.valueOf(datosChar[j]);
					}
			}
			//Ciclo que realiza el proceso de "sumar"/identificar como queda el byte LRC
			for(int i = 0;i<8;i++) {
				for(int k = 0;k<datosVec.length;k++) {
					x = x + datosInt[k][i];
				}
				if(x % 2 ==0) {
					x = 0;
				}else {
					x = 1;
				}
				//x es un acumulador para construir el Byte LRC
				lrc = lrc +x; //Byte LRC
				x = 0;
			}
			txtLRCE.setText(lrc);
			//Se decide aleatoriamente la insersion de un bit falso para simular una corrupcion de datos
			int ali = (int) Math.round(Math.random());
			String datos2 = datos;
				if(ali==1) {
					txtError.setText("SI");
					if(datos2.charAt(0)=='1') {
						datos2 = "0"+datos2.substring(1);
					}else {
						
						datos2 = "1"+datos2.substring(1);
					}
				}else {
					txtError.setText("NO");
				}
				// Se repite el proceso anterior para obtener el Byte LRC por si el error fue añadido
				String datosVec2[] = datos2.split(" ");
				int datosInt2[][]= new int [datosVec2.length][8] ;
				
				for(int i = 0; i < datosVec2.length;i++) {
						String datosChar[] = datosVec2[i].split("");
						for(int j = 0;j<datosChar.length;j++) {
							datosInt2[i][j]=Integer.valueOf(datosChar[j]);
						}
				}
				for(int i = 0;i<8;i++) {
					for(int k = 0;k<datosVec2.length;k++) {
						x2 = x2 + datosInt2[k][i];
					}
					if(x2 % 2 ==0) {
						x2 = 0;
					}else {
						x2 = 1;
					}
					lrc2 = lrc2 +x2; // Y es el Byte LRC
					x2 = 0;
				}
				//Se indica si el mensaje llego de forma correcta comparando el Byte LRC
				if(lrc.equals(lrc2)) {
					JOptionPane.showMessageDialog(null,"El mensaje llego correctamente");
				}
				
				txtLRCR.setText(lrc2);
				txtR.setText(datos2);
		}//Boton exe
		
	}

}

//METODO VRC

class VentanaVRC extends JFrame implements ActionListener{
	JLabel lblDato = new JLabel("El dato es:");
	JButton exe = new JButton("Ejecutar");
	JLabel lblError = new JLabel("Error:");
	JTextField txtDato = new JTextField();
	JTextField txtError = new JTextField();
	JLabel lblR = new JLabel("El dato recibido es:");
	JTextField txtR = new JTextField();
	
	String datos = "1100101 1101000";
	
	String sFinal = "";
	String sInicial = "";
	int err = 0;
	
	public VentanaVRC() {
		getContentPane().setLayout(null);
		setSize(450,300);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("VRC");
		setVisible(true);
		
		lblDato.setBounds(100, 50, 100, 20);
		add(lblDato);
		txtDato.setBounds(170, 50, 150, 20);
		txtDato.setText(datos);
		txtDato.setEditable(false);
		add(txtDato);
		
		exe.setBounds(160, 100, 100, 20);
		exe.addActionListener(this);
		add(exe);
		
		lblError.setBounds(140, 150, 100, 20);
		add(lblError);
		txtError.setBounds(180, 150, 50, 20);
		add(txtError);
		
		lblR.setBounds(90, 200, 150, 20);
		add(lblR);
		txtR.setBounds(200, 200, 150, 20);
		add(txtR);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exe) {
			err = 0;
			sFinal = "";
			String datosVec[] = datos.split(" ");
			for(int j = 0;j<datosVec.length;j++) {
			int cantUno = 0; 
			String primerByte = datosVec[j];
				//Se cuenta la cantidad de bits 1
			for(int i = 0; i < primerByte.length(); i++) { //Cuenta la cantidad de unos
				char chr = primerByte.charAt(i);
					if (chr == '1') {
						cantUno = cantUno +1;
					}
			}
			
			System.out.println(cantUno);
			//Se decide el valor del bit de paridad
			if(cantUno % 2 == 0) { // Saca los bits de paridad 	
				datosVec[j] = "0"+primerByte;
			}else {
				datosVec[j] = "1"+primerByte;
				
			}
			System.out.println(datosVec[j]);
			//Se va almacenando la cadena de dato inicial
			sInicial = sInicial + datosVec[j]+" ";
		
			String enviada = "";
			//simulacion de envio
			//Se decide aleatoriamente si se inserta error o no
			int ali = (int) Math.round(Math.random());
			System.out.println(ali);
			if(ali==1) {
				//Se inserta error
				if(datosVec[j].charAt(0)=='1') {
					enviada = "0" + datosVec[j].substring(1);
				}else {
					enviada = "1" + datosVec[j].substring(1);
				}
			}else {
				//No se inserta error
				enviada = datosVec[j];
				}
			//Se repite el proceso de contar los bits 1 pero esta vez ya con la cadena con error insertado
			int c = 0;
			for(int i = 0; i < enviada.length(); i++) { //Cuenta la cantidad de unos
				char chr = enviada.charAt(i);
					if (chr == '1') {
						c = c +1;
					}
			}
			if(c % 2 == 0) { // Saca los bits de paridad 
				//genera un acumulador de error
				System.out.println("Mensaje Bien");
				err = err + 0;
			}else {
				System.out.println("Mensaje erroeno");
				err = err + 1;
		
			}
			//Almacena la cadena del dato simulando como es recibida
			sFinal = sFinal + enviada + " ";
			txtR.setText(sFinal);
			//si el acomumulador de erro tiene algun error encontrado nos indicara que encontro un error
			
		}
			if(err==0) {
				JOptionPane.showMessageDialog(null,"Mesaje Correcto");
				txtError.setText("NO");
			}else {
				JOptionPane.showMessageDialog(null,"Mensaje con error");
				txtError.setText("SI");
			}
		}
		
	} 
}
class VentanaPrincipal extends JFrame implements ActionListener{
	JLabel lb1 = new JLabel("Seleccione un Metodo de Verificacion");
	JButton use = new JButton("USAR METODO") ; 
	JComboBox selecMetod = new JComboBox();
	
	public VentanaPrincipal() {
		getContentPane().setLayout(null);
		setSize(450,300);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Programa Deteccion de errores");
		setVisible(true);
	
		lb1.setBounds(70, 50, 250, 20);
		add(lb1);
		
		selecMetod.setBounds(70, 70, 300, 20);
		selecMetod.addItem("seleccione una opcion...");
		selecMetod.addItem("Redundancia Vertical  (VRC)");
		selecMetod.addItem("Redundancia Longitudinal (LRC)");
		add(selecMetod);
		
		use.setBounds(150, 150, 150, 20);
		use.addActionListener(this);
		add(use);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==use) {
			if(selecMetod.getSelectedIndex()==0) {
				JOptionPane.showMessageDialog(null, "Seleccione una opcion");
			}else if(selecMetod.getSelectedIndex()==1) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new VentanaVRC();
					}
				});
			}else if(selecMetod.getSelectedIndex()==2) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						new VentanaLRC();
					}
				});
			}
		}
		
	}
}

public class programa {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new VentanaPrincipal();
			}
		});
	}

}

