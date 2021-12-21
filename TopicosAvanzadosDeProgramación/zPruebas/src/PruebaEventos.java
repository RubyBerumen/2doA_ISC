import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

                                        //PASO 1: Implementar interfaz
class CalculadoraC extends JFrame implements ActionListener {

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
        //PASO 2: Registrar el oyente al componente
        btnSumar.addActionListener(this);
        add(btnSumar);
        JButton btnRestar = new JButton( "-");
        btnRestar.addActionListener(this);
        add(btnRestar);
        JButton btnmultiplicar = new JButton( "*");
        add(btnmultiplicar);
        JButton btnDividir = new JButton( "/");
        add(btnDividir);
        add(new JLabel("RESULTADO: "));
        cajaResultado= new JTextField(5);
        add(cajaResultado);

    }

    @Override               //PASO 3: implementar metodo actionPerformed
    public void actionPerformed(ActionEvent e) {
        //PASO 4:
        if(e.getSource() == btnSumar){
            String n1 = cajaPrimerNumero.getText();
            String n2 = cajaSegundoNumero.getText();
            int res = Integer.parseInt(n1)+Integer.parseInt(n2);
            cajaResultado.setText(Integer.toString(res));
        }
    }
}

public class PruebaEventos {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculadoraC();
            }
        });
    }
}

