import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
 

class VentanaPrincipal extends JFrame implements ActionListener{
	JLabel txtValores[]=new JLabel[4];
	JTextField[] cajas=new JTextField[4];
	JTextArea log = new JTextArea();
	JScrollPane sp;
	JButton btnCalcular = new JButton("Calcular");
	Euler e = new Euler();
	
	public VentanaPrincipal(){
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(420,220);
		setLocationRelativeTo(null);
		setTitle("Ecuaciones diferenciales");
		setVisible(true);
		
		log.setEditable(false);
		log.setLineWrap(true);
		log.setWrapStyleWord(true);
		sp = new JScrollPane(log);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setBounds(110,20,280,140);
		add(sp);
		
		txtValores[0] = new JLabel("X0:");
		txtValores[1] = new JLabel("Y0:");
		txtValores[2] = new JLabel("h:");
		txtValores[3] = new JLabel("x:");		
		
		for (int i = 0; i < txtValores.length; i++) {
			txtValores[i].setBounds(20,20+(30*i),40,20);
			add(txtValores[i]);
			cajas[i]=new JTextField();
			cajas[i].setBounds(60,20+(30*i),40,20);
			add(cajas[i]);
		}
		
		btnCalcular.setBounds(15, 140, 90, 20);//
		btnCalcular.addActionListener(this);
		add(btnCalcular);
		
		for (JTextField i:cajas) {//Se valida lo que hay en las cajas de texto
			i.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent ke) {
					String value =i.getText();
					int code=ke.getKeyCode();
					if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')	||	(!value.contains(".")&&ke.getKeyChar()=='.') || (code==KeyEvent.VK_BACK_SPACE)||	(value.equals("")&&ke.getKeyChar()=='-')) {
						i.setEditable(true);
					}else{
						i.setEditable(false);
					}
				}
			});
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		float parametros [] = new float[4];
		
		for (int i = 0; i < parametros.length; i++) {
			try {
				parametros[i]=Float.parseFloat(cajas[i].getText());
			}catch (Exception e) {
				cajas[i].setText("0");
				parametros[i]=0f;
			}
		}
		
        e.calcular(parametros[0],parametros[1],parametros[2],parametros[3], log);//se manda a llamar al metodo de Euler
		
	}
	
}

class Euler {
	public static final DecimalFormat df= new DecimalFormat( "#.###" );
	
    float func(float x, float y){//ecuación diferencial
        return (x + y + x * y);
    }
 
    void calcular(float x0, float y, float h, float x, JTextArea log) {//Se hacen iteraciones con la ecuacion
        float temp = -0;
        while (x0 < x) {
            temp = y;
            y = y + h * func(x0, y);
            x0 = x0 + h;
            log.append("Solución aproximada en x = " + df.format(x0) + " es " + df.format(y)+"\n");//se añaden las iteraciones al area del resultado
        }
        
    }
    
}


public class Prueba {
	
	public static void main(String args[]) throws IOException {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				
				new VentanaPrincipal();
				
			}
		});
        
    }

}
