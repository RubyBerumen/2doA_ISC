import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import figuras.dosdimensiones.*;
import figuras.tresdimensiones.*;

class Paquetes extends JFrame implements ActionListener{
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();

	JComboBox<String> comboTipo = new JComboBox<String>();
	JButton area,perimetro,volumen;
	JLabel parametro1, parametro2, parametro3;
	JTextField caja1, caja2, caja3, txtArea,txtPerimetro,txtVolumen;
	
	
	public Paquetes() {
		getContentPane().setLayout(gbl);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Figuras");
		gbc.fill=GridBagConstraints.BOTH;
		setVisible(true);
		
		String tipos[] = {"Triangulo","Rombo","Circulo","Elipse","Piramide","Cono"};
		comboTipo = new JComboBox(tipos);
		inst(comboTipo, 0, 0, 4, 1, GridBagConstraints.NONE);
		comboTipo.addActionListener(this);
		
		parametro1 = new JLabel(" Parametro 1 ");
		inst(parametro1, 0, 1, 2, 1, GridBagConstraints.NONE);
		caja1 = new JTextField(5);
		inst(caja1, 2, 1, 2, 1, GridBagConstraints.NONE);
		caja1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				String value = caja1.getText();
				int code=ke.getKeyCode();
				if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')	||	(!value.contains(".")&&ke.getKeyChar()=='.') || (code==KeyEvent.VK_BACK_SPACE)) {
					caja1.setEditable(true);
				}else{
					caja1.setEditable(false);
				}
			}
		});
		
		parametro2 = new JLabel(" Parametro 2 ");
		inst(parametro2, 0, 2, 2, 1, GridBagConstraints.NONE);
		caja2 = new JTextField(5);
		inst(caja2, 2, 2, 2, 1, GridBagConstraints.NONE);
		caja2.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				String value = caja2.getText();
				int code=ke.getKeyCode();
				if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')	||	(!value.contains(".")&&ke.getKeyChar()=='.') || (code==KeyEvent.VK_BACK_SPACE)) {
					caja2.setEditable(true);
				}else{
					caja2.setEditable(false);
				}
			}
		});
		
		parametro3 = new JLabel(" Parametro 3 ");
		inst(parametro3, 0, 3, 2, 1, GridBagConstraints.NONE);
		caja3 = new JTextField(5);
		inst(caja3, 2, 3, 2, 1, GridBagConstraints.NONE);
		caja3.addKeyListener(new KeyAdapter() {//validacion
			public void keyPressed(KeyEvent ke) {
				String value = caja3.getText();
				int code=ke.getKeyCode();
				if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')	||	(!value.contains(".")&&ke.getKeyChar()=='.') || (code==KeyEvent.VK_BACK_SPACE)) {
					caja3.setEditable(true);
				}else{
					caja3.setEditable(false);
				}
			}
		});
		
		inst(new JLabel("  Calcular  "), 4, 0, 1, 3, GridBagConstraints.NONE);
		
		area = new JButton("Área");
		inst(area, 5, 1, 2, 1, GridBagConstraints.BOTH);
		area.addActionListener(this);
		
		txtArea = new JTextField(5);
		inst(txtArea, 7, 1, 2, 1, GridBagConstraints.NONE);
		
		perimetro = new JButton("Perímetro");
		inst(perimetro, 5, 2, 2, 1, GridBagConstraints.NONE);
		perimetro.addActionListener(this);
		
		txtPerimetro = new JTextField(5);
		inst(txtPerimetro, 7, 2, 2, 1, GridBagConstraints.NONE);
		
		volumen = new JButton("Volúmen");
		inst(volumen, 5, 3, 2, 1, GridBagConstraints.BOTH);
		volumen.addActionListener(this);
		
		txtVolumen = new JTextField(5);
		inst(txtVolumen, 7, 3, 2, 1, GridBagConstraints.NONE);
		
		
		pack();
	}
	
	public void inst(Component cmp,int gridx, int gridy, int gridwidth, int gridheight, int fill) {
		gbc.gridx=gridx;
		gbc.gridy=gridy;
		gbc.gridwidth=gridwidth;
		gbc.gridheight=gridheight;
		gbc.fill=fill;
		gbl.setConstraints(cmp, gbc);
		add(cmp);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DecimalFormat df = new DecimalFormat("#.00");
		String txt="";
		double num1=0.0;
		double num2=0.0;
		double num3=0.0;
		
		if (!caja1.getText().isEmpty()) {
			num1=Double.parseDouble(caja1.getText());
		}
		if (!caja2.getText().isEmpty()) {
			num2=Double.parseDouble(caja2.getText());
		}
		if (!caja3.getText().isEmpty()) {
			num3=Double.parseDouble(caja3.getText());
		}
		
		if (e.getSource()==comboTipo) {
			if (comboTipo.getSelectedItem()=="Triangulo") {
				parametro1.setText("Lado 1");
				parametro2.setText("Lado 3");
				parametro3.setText("Lado 3");
				caja2.enable();
				caja3.enable();
				perimetro.enable();
				txtVolumen.setText("");
				volumen.disable();
			}else if (comboTipo.getSelectedItem()=="Rombo") {
				parametro1.setText("Base");
				parametro2.setText("Altura");
				parametro3.setText("");
				caja2.enable();
				caja3.disable();
				perimetro.enable();
				txtVolumen.setText("");
				volumen.disable();
			}else if (comboTipo.getSelectedItem()=="Circulo") {
				parametro1.setText("Radio");
				parametro2.setText("Parametro 2");
				parametro3.setText("");
				caja2.disable();
				caja3.disable();
				perimetro.enable();
				txtVolumen.setText("");
				volumen.disable();
			}else if (comboTipo.getSelectedItem()=="Elipse") {
				parametro1.setText("Radio 1");
				parametro2.setText("Radio 2");
				parametro3.setText("");
				caja2.enable();
				caja3.disable();
				perimetro.enable();
				txtVolumen.setText("");
				volumen.disable();
			}else if (comboTipo.getSelectedItem()=="Piramide") {
				parametro1.setText("Lado base");
				parametro2.setText("Altura");
				parametro3.setText("");
				caja2.enable();
				caja3.disable();
				txtPerimetro.setText("");
				perimetro.disable();
				volumen.enable();
			}else if (comboTipo.getSelectedItem()=="Cono") {
				parametro1.setText("Radio");
				parametro2.setText("Altura");
				parametro3.setText("");
				caja2.enable();
				caja3.disable();
				txtPerimetro.setText("");
				perimetro.disable();
				volumen.enable();
			}
		}else if (e.getSource()==area) {
			if (comboTipo.getSelectedItem()=="Triangulo") {
				Triangulo tng = new Triangulo(num1, num2, num3);
				txt = df.format(tng.area());
			}else if (comboTipo.getSelectedItem()=="Rombo") {
				Rombo rmb = new Rombo(num1, num2, num3);
				txt = df.format(rmb.area());
			}else if (comboTipo.getSelectedItem()=="Circulo") {
				Circulo crc = new Circulo(num1);
				txt = df.format(crc.area());
			}else if (comboTipo.getSelectedItem()=="Elipse") {
				Elipse elp = new Elipse(num1, num2);
				txt = df.format(elp.area());
			}else if (comboTipo.getSelectedItem()=="Piramide") {
				Piramide prm = new Piramide(num1, num2, num3);
				txt  = df.format(prm.area());
			}else if (comboTipo.getSelectedItem()=="Cono") {
				Cono cn = new Cono(num1, num2, num3);
				txt  = df.format(cn.area());
			}
			txtArea.setText(txt);
			
		}else if (e.getSource()==perimetro) {
			if (comboTipo.getSelectedItem()=="Triangulo") {
				Triangulo tng = new Triangulo(num1, num2, num3);
				txt = df.format(tng.perimetro());
			}else if (comboTipo.getSelectedItem()=="Rombo") {
				Rombo rmb = new Rombo(num1, num2, num3);
				txt = df.format(rmb.perimetro());
			}else if (comboTipo.getSelectedItem()=="Circulo") {
				Circulo crc = new Circulo(num1);
				txt = df.format(crc.perimetro());
			}else if (comboTipo.getSelectedItem()=="Elipse") {
				Elipse elp = new Elipse(num1, num2);
				txt = df.format(elp.perimetro());
			}
			txtPerimetro.setText(txt);
		}else if (e.getSource()==volumen) {
			if (comboTipo.getSelectedItem()=="Piramide") {
				Piramide prm = new Piramide(num1, num2, num3);
				txt  = df.format(prm.volumen());
			}else if (comboTipo.getSelectedItem()=="Cono") {
				Cono cn = new Cono(num1, num2, num3);
				txt  = df.format(cn.volumen());
			}
			txtVolumen.setText(txt);
		}
		
	}
	
}

public class Prueba {
	
	public static void main(String[] args) {
	
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Paquetes();
			}
		});
		
	}

}

