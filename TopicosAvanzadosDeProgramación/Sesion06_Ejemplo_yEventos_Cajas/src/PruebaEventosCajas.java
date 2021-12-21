import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class EventosCajas extends JFrame implements ActionListener{
	
	JTextField cajaDolares, cajaPesos;
	JButton btnConvertir;
	
	public EventosCajas() {
		getContentPane().setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,100);
		setLocationRelativeTo(null);
		setTitle("Evento cajas");
		setVisible(true);
		
		
		add(new JLabel("Dolares"));
		cajaDolares = new JTextField(5);
		cajaDolares.setToolTipText("Presiona ENTER para convertir");
		cajaDolares.addActionListener(this);
		add(cajaDolares);
		
		add(new JLabel("Pesos"));
		cajaPesos = new JTextField(5);
		add(cajaPesos);
		
		btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(this);
		add(btnConvertir);
		
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		ConvertirMoneda cv = new ConvertirMoneda();
		double dato = 0.0;
		
		if(e.getSource() == btnConvertir) {
			dato = Double.parseDouble(cajaDolares.getText());
			cajaPesos.setText(String.valueOf(cv.convertirDaP(dato)));
			
		}else if(e.getSource() == cajaDolares) {
			dato = Double.parseDouble(cajaDolares.getText());
			cajaPesos.setText(String.valueOf(cv.convertirDaP(dato)));
			
		}
		
	}
	
}


class ConvertirMoneda{
	
	public double convertirDaP(double monedaAConvertir) {
		
							//consumir servicio web de la pagina BANXICO
		double tasaConversion = 20;
		
		return monedaAConvertir*tasaConversion;
	}
	
}


public class PruebaEventosCajas {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {	
			@Override
			public void run() {	
				new EventosCajas();
			}
		});
		
	}

}
