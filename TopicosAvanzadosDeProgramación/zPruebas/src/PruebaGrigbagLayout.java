import javax.swing.*;
import java.awt.*;

class VentanaInicio extends JFrame {

    GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();

    public VentanaInicio(){
        getContentPane().setLayout(gbl);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("GridBagLayout");
        //setSize(300, 300);

        setVisible(true);

        JTextArea areaTexto1 = new JTextArea("TextArea1");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbl.setConstraints(areaTexto1, gbc);
        add(areaTexto1);

        JButton btn1 = new JButton("Button 1");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.EAST;
        gbl.setConstraints(btn1, gbc);
        add(btn1);

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

        JComboBox<String> combo1 = new JComboBox<String>();
        combo1.addItem("Iron");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbl.setConstraints(combo1, gbc);
        add(combo1);

        JTextField caja1 = new JTextField("TextField", 10);
        metodoMagico(caja1, 0, 3, 2, 1, 0);

        JTextArea area2 = new JTextArea("TextArea2");
        metodoMagico(area2, 2, 3, 1, 1, 0);

        pack();
        setLocationRelativeTo(null);
    }//constructor

    public void metodoMagico(JComponent c, int gx, int gy, int gw, int gh, int f){
        gbc.gridx = gx;
        gbc.gridy = gy;
        gbc.gridwidth = gw;
        gbc.gridheight = gh;
        gbc.fill = f;
        gbl.setConstraints(c, gbc);
        add(c);
    }

}

public class PruebaGrigbagLayout {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaInicio();
            }
        });
    }
}

