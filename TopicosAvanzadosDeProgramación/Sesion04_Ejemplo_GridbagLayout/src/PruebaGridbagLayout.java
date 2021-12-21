import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

class VentanaInicio extends JFrame {
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	
	//Constructor
	public VentanaInicio() {
		getContentPane().setLayout(gbl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("GridbagLayout");
		//setSize(100,100);
		
		
		JTextArea areaTxt1 = new JTextArea("TextArea1");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 3;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbl.setConstraints(areaTxt1, gbc);
		add(areaTxt1);
		//componente(areaTxt1, 0, 0, 1, 3, 3);
		
		JButton btn1 = new JButton("Button 1");
		/*gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		gbc.fill = 2;//GridBagConstraints.HORIZONTAL;
		gbc.anchor = 13;//GridBagConstraints.EAST;
		gbl.setConstraints(btn1, gbc);
		add(btn1);*/
		componente(btn1, 1, 0, 2, 1, 2);
		
		JButton btn2 = new JButton("Button 2");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbl.setConstraints(btn2, gbc);
		add(btn2);
		
		JButton btn3 = new JButton("Button 3");
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbl.setConstraints(btn3, gbc);
		add(btn3);
		
		JComboBox<String> comboB1 = new JComboBox<String>();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		gbl.setConstraints(comboB1, gbc);
		comboB1.addItem("Iron");
		comboB1.addItem("2");
		comboB1.addItem("3");
		add(comboB1);
		
		JTextArea areaTxtF = new JTextArea("TextField");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		gbl.setConstraints(areaTxtF, gbc);
		add(areaTxtF);

		JTextArea areaTxt2 = new JTextArea("TextArea2");
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbl.setConstraints(areaTxt2, gbc);
		add(areaTxt2);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void componente(JComponent c, int gx, int gy, int gw, int gh, int fill) {
		
		gbc.gridx = gx;
		gbc.gridy = gy;
		gbc.gridheight = gh;
		gbc.gridwidth = gw;
		gbc.fill = fill;
		//gbc.anchor = a;
		gbl.setConstraints(c, gbc);
		add(c);
		
	}
	
	
	
}

public class PruebaGridbagLayout {

	public static void main(String[] args) {

		 SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new VentanaInicio();
	            }
	    });
		 
	}
	
}
