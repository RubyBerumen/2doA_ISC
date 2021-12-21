import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class Ventana extends JFrame implements ActionListener{
	JTextArea areaTexto;
	JButton btnCalcular;
	JLabel etiqueta1,etiqueta2;
	public Ventana() {
		getContentPane().setLayout(new FlowLayout());	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,260);	
		setTitle("Formulario de registro");
		setLocationRelativeTo(null);
		setVisible(true);
		
		areaTexto=new JTextArea(10,25);
		JScrollPane scroll=new JScrollPane(areaTexto);
		add(scroll);
		
		btnCalcular=new JButton("Carga imagen");
		btnCalcular.addActionListener(this);
		add(btnCalcular);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCalcular) {
			Generador gen=new Generador(areaTexto);
			Thread hiloGenerando = new Thread(gen);
			hiloGenerando.start();
			
		}
		
	}
}

class Generador extends Thread{
	int vectorBidimenional[][];
	JLabel label1,label2;
	JTextArea areaTexto;
	
	public Generador(JTextArea areaTexto) {
		vectorBidimenional=new int[1000][1000];
		this.areaTexto=areaTexto;
		
	}
	
	public void generar() {
		byte conta=0;
		for(int i=0;i<vectorBidimenional.length;i++) {
			for(int x=0;x<vectorBidimenional[i].length;x++) {
				double z=Math.random();
				if(z<0.5) {
					vectorBidimenional[i][x]=1;
					areaTexto.append("1");
					conta++;
				}else {
					conta++;
					vectorBidimenional[i][x]=0;
					areaTexto.append("0");
				}
				if(conta==40) {
					conta=0;
					areaTexto.append("\n");
				}
			}
		}
		
	}
	
	@Override
	public void run() {
		generar();
		//----------------------
		BusquedaConcurrencias obj=new BusquedaConcurrencias();
		
		EnviarInstruccion envio1=new EnviarInstruccion(obj,0,vectorBidimenional);
		EnviarInstruccion envio2=new EnviarInstruccion(obj,1,vectorBidimenional);
		
		Thread hilo1=new Thread(envio1);
		hilo1.start();
		
		Thread hilo2=new Thread(envio2);
		hilo2.start();
	}
	
	
}
class EnviarInstruccion implements Runnable{
	private int concidencias=0;
	int[][] vector;
	BusquedaConcurrencias busqueda;
	int tipo;
	
	public EnviarInstruccion(BusquedaConcurrencias busqueda,int tipo,int[][] vector) {
		this.busqueda=busqueda;
		this.tipo=tipo;
		this.vector=vector.clone();
	}
	@Override
	public void run() {		
		busqueda.busquedaPatrones(vector,tipo);
	}
	
}
class BusquedaConcurrencias{
	
	public BusquedaConcurrencias() {}
	
	public synchronized void busquedaPatrones(int[][] vector,int tipo){
		
		int contador=0;
		int concidencias = 0;
		int vector2[][]= vector.clone();
		int tipodeBusqueda=tipo;
		
		//System.out.println("Ejecutando consulta de : "+tipo);
		
		for(int i=0;i<vector2.length;i++) {
			
			for(int x=0;x<vector2[i].length;x++) {
				
				if(vector2[i][x]==tipodeBusqueda) {
					contador++;
				}else{
					contador=0;
				}
				
				if(contador==5) {
					concidencias++;
					contador=0;
				}
			}//for2
			contador=0;
		}//for1
		
		JOptionPane.showMessageDialog(null,"Numero de patrones de "+tipodeBusqueda+"´ fue de: "+concidencias);
	}
	
	
}
public class Prueba1 {

	public static void main(String[] args) {
		new Ventana();

	}

}
