import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class CombosDependientes extends JFrame implements ActionListener{
	
	JComboBox<String> comboEstados, comboMunicipios;
	
	public CombosDependientes(){
		getContentPane().setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(200, 200);
		setLocationRelativeTo(null);
		setTitle("Combos dependientes");
		setVisible(true);
		
		add(new JLabel("Selecciona Estado:"));
		
		String vectorEstados[] = {"Elige opcion...", "Aguascalientes", "...", 
							"Guanajuato", "...", "Michoacan", "...", "Zacatecas"};
		comboEstados = new JComboBox<String>(vectorEstados);
		comboEstados.addActionListener(this);
		add(comboEstados);
		
		
		add(new JLabel("Selecciona Municipio:"));
		comboMunicipios = new JComboBox<>();
		
		comboMunicipios.addItem("Elige opcion...");
		add(comboMunicipios);
		
		add(new JButton("Enviar formulario >>>"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String municipiosZacatecas[] = {"Apozol", "Apulco", "...", "Jerez", "Juchipila", "Zacatecas"};
		
		if(e.getSource() == comboEstados) {
			comboMunicipios.removeAllItems();
			if(comboEstados.getSelectedItem().equals("Zacatecas")) {
				
				for( String x : municipiosZacatecas)
					comboMunicipios.addItem(x);
			}
		}
		
	}
	
}


public class PruebaCombosDependientes {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
			
				new CombosDependientes();
			}
		});
	}
}