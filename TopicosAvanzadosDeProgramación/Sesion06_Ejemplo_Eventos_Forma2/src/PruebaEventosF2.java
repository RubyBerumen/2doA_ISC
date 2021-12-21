import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

                                        //PASO 1: Implementar interfaz
class CalculadoraC extends JFrame {

    JButton btnSumar;
    JTextField cajaPrimerNumero, cajaSegundoNumero, cajaResultado;

    public CalculadoraC(){
        getContentPane().setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(270, 160);
        setLocationRelativeTo(null);
        setTitle("Calculadora Chafa");
        setVisible(true);

        add(new JLabel("Ingresa un numero: "));
        cajaPrimerNumero = new JTextField(10);
        add(cajaPrimerNumero);

        add(new JLabel("Ingresa otro numero: "));
        cajaSegundoNumero = new JTextField(10);
        add(cajaSegundoNumero);

        btnSumar = new JButton( "+");
        btnSumar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cajaResultado.setText(
						String.valueOf(
								Double.parseDouble(cajaPrimerNumero.getText() )+
										Double.parseDouble(cajaSegundoNumero.getText())
								)
						);
			}
		});
        add(btnSumar);
        
        JButton btnRestar = new JButton( "-");
        add(btnRestar);
        JButton btnmultiplicar = new JButton( "*");
        add(btnmultiplicar);
        JButton btnDividir = new JButton( "/");
        add(btnDividir);
        add(new JLabel("RESULTADO: "));
        cajaResultado= new JTextField(5);
        add(cajaResultado);

    }


}

public class PruebaEventosF2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculadoraC();
            }
        });
    }
}


