
import javax.swing.*;
import java.awt.*;

class VentanaPrincipal extends JFrame{
	
	public VentanaPrincipal() {
		//Paso 3: configurar la interfaz gráfica de la ventana principal
		
		//3A: establecer un layout (diferente al predeterinado (BORDERLAYOUT) )
		getContentPane().setLayout(new FlowLayout());
	
		//3B: establecer acción al cerrar la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		//3C: establecer un tamaño inicial
		setSize(250,700);
		
		//3D: establecer titulo
		setTitle("Formulario de registro");
		
		//3E: centrar la ventana
		setLocationRelativeTo(null);
	
		
		//Paso 4: Agregar componentes
		/*
		 * 4a)Crear el componente
		 * 4b) Configurar el componente
		 * 4c) Agregar el componente
		 */
		
		JLabel lblTitulo = new JLabel("<<<Formulario de registro>>>");
		add(lblTitulo);
		
		JLabel lblSaludo = new JLabel();
		lblSaludo.setText("Datos personales");
		add(lblSaludo);
		
		JLabel lblNumControl = new JLabel("Número de control: ");
		add(lblNumControl);
		
		JTextField cajaNumControl = new JTextField(10);
		add(cajaNumControl);
		
		add(new JLabel("Nombre: "));
		JTextField cajaNombre = new JTextField(10);
		add(cajaNombre);
		
		add(new JLabel("Primer Apellido: "));
		JTextField cajaPrimerAp = new JTextField(10);
		add(cajaPrimerAp);
		
		add(new JLabel("Segundo Apellido: "));
		JTextField cajaSegundoAp = new JTextField(10);
		add(cajaSegundoAp);
		
		add(new JLabel("Edad: "));
		JComboBox<String> comboEdad = new JComboBox<String>();
		comboEdad.addItem("Selecciona opción...");
		comboEdad.addItem("1");
		comboEdad.addItem("2");
		add(comboEdad);
		
		add(new JLabel("Semestre:"));
		JSpinner spinnerSemestre = new JSpinner();
		add(spinnerSemestre);
		
		add(new JLabel("Selecciona Carrera: "));
		
		ButtonGroup bg = new ButtonGroup();
		
		JRadioButton radioISC = new JRadioButton("ISC");
		bg.add(radioISC);
		add(radioISC);
		JRadioButton radioIM = new JRadioButton("IM");
		bg.add(radioIM);
		add(radioIM);
		JRadioButton radioIIA = new JRadioButton("IIA");
		bg.add(radioIIA);
		add(radioIIA);
		
		add(new JLabel("Selecciona especialidad(es) de interés: "));
		JCheckBox checkBD = new JCheckBox("Bases de datos");
		add(checkBD);
		JCheckBox checkIS = new JCheckBox("Ingeniería de software");
		add(checkIS);
		JCheckBox checkIA = new JCheckBox("Inteligencia artificial");
		add(checkIA);
		
		add(new JLabel("Selecciona actividades extraescolares de interés: "));	
		String actividades[] = {"Deportes","Danza","Musica","Teatro"};
		JList<String> listaExtraescolares = new JList<String>(actividades);
		listaExtraescolares.setVisibleRowCount(3);//Se debe agregar el scroll
		listaExtraescolares.setToolTipText("Presiona CTRL/CMD para multiselección ");
		
		JScrollPane scroll = new JScrollPane(listaExtraescolares);
		
		add(scroll);
		
		add(new JLabel("Comentarios: "));
		JTextArea areaComentarios = new JTextArea("Escribe aquí...",10,15);
		
		areaComentarios.setLineWrap(true);
		areaComentarios.setWrapStyleWord(true);
		
		add(areaComentarios);
		
		JButton btnReestablecer = new JButton("Reestablecer");
		add(btnReestablecer);
		
		JButton btnEnviar = new JButton("Enviar");
		add(btnEnviar);
		
		//3F: hacer visible la ventana
		setVisible(true);
	}
	
}

public class PruebaFormulario {

	public static void main(String[] args) {

		
		new VentanaPrincipal();
		
		

	}

}
