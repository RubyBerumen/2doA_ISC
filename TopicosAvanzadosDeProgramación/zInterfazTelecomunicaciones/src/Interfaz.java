import java.awt.Color;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.IOException;
import javax.swing.*;



class Ventana extends JFrame{
	
	JLabel txtTitulo, txtEntrada, txtSalida;
	JTextField jtfEntrada, jtfSalida;
	JTextArea jtaEntrada, jtaSalida, jta1;
	JButton btnEnviar;
	JComboBox <String> cmbTipo;
	Color azul = new Color(35,88,137);
	Color grisClaro = new Color(212,212,212);
	Font fuente = new Font("Berlin Sans FB", Font.PLAIN, 16);

	public Ventana(){
		getContentPane().setLayout(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(630,400);
		setBackground(new Color(165,202,210));
		setLocationRelativeTo(null);
		
		txtTitulo = new JLabel("Métodos de detección y corrección de errores");
		txtTitulo.setBounds(15, 10, 600, 45);
		txtTitulo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		txtTitulo.setForeground(azul);
		add(txtTitulo);
		
		txtEntrada = new JLabel("Ingresa el mensaje:");
		txtEntrada.setBounds(15, 70, 200, 25);
		txtEntrada.setFont(fuente);
		add(txtEntrada);
		
		jtfEntrada = new JTextField();
		jtfEntrada.setBounds(15, 100, 185, 25);
		add(jtfEntrada);
		
		String tipo[] = {"Selecciona método...","Vertical","Longitudinal","Ciclica"};
		cmbTipo = new JComboBox<String>(tipo);
		cmbTipo.setBounds(215, 95, 185, 30);
		cmbTipo.setFont(fuente);
		cmbTipo.setBackground(azul);
		cmbTipo.setForeground(grisClaro);
		add(cmbTipo);
		
		txtSalida = new JLabel("Salida:");
		txtSalida.setBounds(415, 70, 200, 25);
		txtSalida.setFont(fuente);
		add(txtSalida);
		
		jtfSalida = new JTextField();
		jtfSalida.setBounds(415, 100, 185, 25);
		add(jtfSalida);
		
		jtaEntrada = new JTextArea();
		jtaEntrada.setBounds(15, 145, 185, 120);
		add(jtaEntrada);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(260, 160, 100, 35);
		btnEnviar.setBackground(azul);
		btnEnviar.setForeground(grisClaro);
		btnEnviar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		add(btnEnviar);
		
		jtaSalida = new JTextArea();
		jtaSalida.setBounds(415, 145, 185, 120);
		add(jtaSalida);
		
		jta1 = new JTextArea();
		jta1.setBounds(15, 285, 585, 60);
		add(jta1);
		
		
		
		setVisible(true);
	}
	
}


public class Interfaz {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Ventana();
			}
		});

	}

}
