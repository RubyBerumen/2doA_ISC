import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

class VentanaLab extends JFrame{
	
	JMenuBar menuBar;
	JMenu masters,booking,testPerform,transaction,labReport,setings,windows,help;
	JMenuItem menuItem;
	JToolBar barraH;
	
	JInternalFrame registro;
	
	
	
	
	public VentanaLab() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(900,700);
		setLocationRelativeTo(null);
		setTitle("INTERNALFRAMES");
		setVisible(true);
		
		JOptionPane.showMessageDialog(rootPane,"El FRAME se encuentra en Maestros => Registro");
		
	
		
		menuBar = new JMenuBar();
			masters = new JMenu("Maestros");
			booking = new JMenu("Reserva");
			testPerform = new JMenu("Hacer Test");
			transaction = new JMenu("Transaccion");
			labReport = new JMenu("Reporte");
			setings = new JMenu("Ajustes");
			windows = new JMenu("Ventana");
			help = new JMenu("Ayuda");
			
				menuItem = new JMenuItem("Registro");
				menuItem.setIcon(new ImageIcon());
			masters.add(menuItem);
				
				
				menuItem.addActionListener(new ActionListener() {
				
					@Override
					public void actionPerformed(ActionEvent e) {
						registro.setVisible(true);
						
						
					}
				});
		
	menuBar.add(masters);
	menuBar.add(booking);
	menuBar.add(testPerform);
	menuBar.add(transaction);
	menuBar.add(labReport);
	menuBar.add(setings);
	menuBar.add(windows);
	menuBar.add(help);
	setJMenuBar(menuBar);
	
	JDesktopPane dp = new JDesktopPane();
				
	
	registro = new JInternalFrame();
	registro.getContentPane().setLayout(null);
	registro.setDefaultCloseOperation(HIDE_ON_CLOSE);
	registro.setSize(885, 640);
	registro.setTitle("Registro");
	//registro.setVisible(true);
	
	
	
	
	JButton plus = new JButton("Add");//, new ImageIcon("Iconos/page-blank.png"));
	JButton edit = new JButton("Edit");//, new ImageIcon("Iconos/editar.png"));
	JButton back = new JButton("Back");//, new ImageIcon("Iconos/back.png"));
	JButton next = new JButton("Next");//, new ImageIcon("Iconos/next.png"));
	JButton list = new JButton("List");//, new ImageIcon("Iconos/list.png"));
	JButton save = new JButton("Save");//, new ImageIcon("Iconos/save.png"));
	JButton print = new JButton("Print");//, new ImageIcon("Iconos/print.png"));
	JButton test = new JButton("Test");//, new ImageIcon("Iconos/test.png"));
	JButton cancel = new JButton("Cancel");//, new ImageIcon("Iconos/cancel.png"));
	JButton settings = new JButton("Settings");//, new ImageIcon("Iconos/settings.png"));
	JButton delete = new JButton("Delete");//, new ImageIcon("Iconos/delete.png"));
	JButton exit = new JButton("Exit");//, new ImageIcon("Iconos/exit.png"));
	
	
	barraH = new JToolBar(JToolBar.HORIZONTAL);	
	barraH.setBounds(0, 0, 950, 30);
	barraH.add(plus);
	barraH.add(edit);
	barraH.add(back);
	barraH.add(next);
	barraH.add(list);
	barraH.add(save);
	barraH.add(print);
	barraH.add(test);
	barraH.add(cancel);
	barraH.add(settings);
	barraH.add(delete);
	barraH.add(exit);
	
	
	registro.add(barraH);
	
	
	
	JPanel panel1 = new JPanel();

	panel1.setBackground(Color.WHITE);
	Border bordejpanel = new TitledBorder(new EtchedBorder());
	panel1.setBorder(bordejpanel);
	panel1.setBounds(1, 30, 873, 200);
	
	JLabel id = new JLabel("ID de pasiente");
	panel1.add(id);
	
	JTextField idT = new JTextField(5);
	panel1.add(idT);
	
	JLabel date = new JLabel("                Fecha	    	");
	panel1.add(date);
	
	String []x = {"00/00/0000"}; 
	JComboBox<String> fecha = new JComboBox<String>(x);
	panel1.add(fecha);
	
	JLabel time = new JLabel("  *Hora (hh:mm)");
	panel1.add(time);
	
	JTextField h = new JTextField("0",1);
	JTextField m = new JTextField("0",1);
	JLabel pd = new JLabel(":");
	
	panel1.add(h);
	panel1.add(pd);
	panel1.add(m);
	
	JLabel labN = new JLabel("  No. Lab");
	JTextField nlab = new JTextField(5);
	JLabel zero = new JLabel("                                                                                  .");
	
	panel1.add(labN);
	panel1.add(nlab);
	panel1.add(zero);
	
	
	
	
	
	JLabel name = new JLabel("Nombre     ");
	String []y = {"MR."}; 
	JComboBox<String> mr = new JComboBox<String>(y);
	JTextField mrT = new JTextField(7);
	JLabel zero2 = new JLabel("                                                                                                                                                                                                                      .");
	
	
	
	panel1.add(name);
	panel1.add(mr);
	panel1.add(mrT);
	panel1.add(zero2);
	
	JLabel sex = new JLabel("Sexo          ");
	String []z = {"Mujer","Hombre"}; 
	JComboBox<String> s = new JComboBox<String>(z);
	JLabel age = new JLabel("Edad");
	JLabel monts = new JLabel("  Meses");
	JLabel days = new JLabel("  Dias");
	JLabel sample = new JLabel("     Muestra de");
	JTextField ageT = new JTextField(2);
	JTextField montsT = new JTextField(2);
	JTextField daysT = new JTextField(2);
	JTextField sampleT = new JTextField(7);
	JLabel zero3 = new JLabel("                                                                                                            .");
	
	
	panel1.add(sex);
	panel1.add(s);
	panel1.add(age);
	panel1.add(ageT);
	panel1.add(monts);
	panel1.add(montsT);
	panel1.add(days);
	panel1.add(daysT);
	panel1.add(sample);
	panel1.add(sampleT);
	panel1.add(zero3);
	
	JLabel referente = new JLabel("Referente a:");
	JTextField referenteT = new JTextField(5);
	JTextField solovino = new JTextField(15);
	JLabel panelCode = new JLabel("  Codigo del panel");
	JTextField panelT = new JTextField(7);
	JLabel zero4 = new JLabel("                                                                                                               .");
	
	panel1.add(referente);
	panel1.add(referenteT);
	panel1.add(solovino);
	panel1.add(panelCode);
	panel1.add(panelT);
	panel1.add(zero4);
	
	JLabel panelID = new JLabel(".                                                                                                                       ID de Panel");
	JTextField panelIDT = new JTextField(7);
	
	
	
	
	JLabel email = new JLabel("e-mail");
	JTextField emailT = new JTextField(7);
	
	panel1.add(panelID);
	panel1.add(panelIDT);
	
	panel1.add(new JLabel("                                                                                                         ."));
	
	panel1.add(email);
	panel1.add(emailT);
	
	JPanel panel2 = new JPanel();
	panel2.setBorder(bordejpanel);
	panel2.setBounds(525, 230, 423, 250);
	panel2.setBackground(Color.WHITE);
	panel2.setLayout(null);
	
	
	
	String cabezaT []={"Test ID", "Test Name","Velocidad","Disc %","Descuento $","IVA%","IVA $"};
	String cuerpoT [][] = new String[1][7];
	
	DefaultTableModel modelo = new DefaultTableModel();
	modelo=new DefaultTableModel(cuerpoT,cabezaT);
   
	JTable tabla=new JTable();
	tabla=new JTable(modelo);
	JTableHeader header = tabla.getTableHeader();
	header.setBounds(0,230,525,20);
	tabla.setBounds(0,250,500,20);
	registro.add(header);
	registro.add(tabla);
	
	JLabel totalTest = new JLabel("Total Test");
	JLabel testAmount = new JLabel("Importe del test");
	JLabel consension = new JLabel("Consension");
	JLabel homecolector = new JLabel("Colección");
	JLabel taxAmount = new JLabel("Importe del IVA");
	JLabel netAmount = new JLabel("Importe Neto");
	JLabel balance = new JLabel("Balance");
	
	JTextField totalT = new JTextField(5);
	totalT.setBackground(Color.BLUE);
	JTextField importeT = new JTextField(5);
	importeT.setBackground(Color.BLUE);
	JTextField consensionT = new JTextField(5);
	consensionT.setBackground(Color.BLUE);
	JTextField coleccionT = new JTextField(5);
	coleccionT.setBackground(Color.BLUE);
	JTextField taxT = new JTextField(5);
	taxT.setBackground(Color.BLUE);
	JTextField netT = new JTextField(5);
	netT.setBackground(Color.BLUE);
	JTextField balanceT = new JTextField(5);
	balanceT.setBackground(Color.BLUE);
	
	totalTest.setBounds(20, 10, 100, 20);
	totalT.setBounds(120, 10, 110, 20);
	testAmount.setBounds(20,40,100,20);
	importeT.setBounds(120, 40, 110, 20);
	consension.setBounds(20,70,100,20);
	consensionT.setBounds(120, 70, 110, 20);
	homecolector.setBounds(20,100,100,20);
	coleccionT.setBounds(120, 100, 110, 20);
	taxAmount.setBounds(20,130,100,20);
	taxT.setBounds(120, 130, 110, 20);
	netAmount.setBounds(20,160,100,20);
	netT.setBounds(120, 160, 110, 20);
	balance.setBounds(20,190,100,20);
	balanceT.setBounds(120, 190, 110, 20);
	
	
	panel2.add(totalTest);
	panel2.add(totalT);
	panel2.add(testAmount);
	panel2.add(importeT);
	panel2.add(consension);
	panel2.add(consensionT);
	panel2.add(homecolector);
	panel2.add(coleccionT);
	panel2.add(taxAmount);
	panel2.add(taxT);
	panel2.add(netAmount);
	panel2.add(netT);
	panel2.add(balance);
	panel2.add(balanceT);
	
	JPanel panel3 = new JPanel();
	panel3.setBorder(bordejpanel);
	panel3.setBounds(1, 480, 873, 125);
	panel3.setBackground(Color.WHITE);
	panel3.setLayout(null);
	
	JLabel homec = new JLabel("Coleccion");
	JLabel paid = new JLabel("Pago");
	JLabel typePaid = new JLabel("Tipo de pago");
	JLabel receibNo = new JLabel("No. Recibo");
	
	String[] t = {"Efectivo"};
	JComboBox type = new JComboBox(t);
	JTextField homecT = new JTextField(3);
	JTextField paidT = new JTextField(3);
	JTextField receibT = new JTextField(5);
	JTextField blue = new JTextField();
	blue.setBackground(Color.BLUE);
	
	homec.setBounds(5, 5, 100, 20);
	homecT.setBounds(70, 5, 70, 20);
	paid.setBounds(170, 5, 100, 20);
	paidT.setBounds(210, 5, 70, 20);
	typePaid.setBounds(310, 5, 100, 20);
	type.setBounds(390, 7, 100, 20);
	receibNo.setBounds(520, 5, 100, 20);
	receibT.setBounds(600, 5, 100, 20);
	
	blue.setBounds(1, 60, 870, 65);
	
	panel3.add(homec);
	panel3.add(homecT);
	panel3.add(paid);
	panel3.add(paidT);
	panel3.add(typePaid);
	panel3.add(type);
	panel3.add(receibNo);
	panel3.add(receibT);
	panel3.add(blue);
	
	
	
	registro.add(panel1);
	registro.add(panel2);
	registro.add(panel3);
	
	dp.add(registro);
	dp.setBounds(0, 0, 900, 700);
	add(dp);
	
	}
	
}


public class PruebaInternalFramesT1_A6 {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanaLab();
			}
		});	
		

	}

}
