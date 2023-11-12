package notas.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionDialog extends JDialog implements ActionListener {
    int seleccion = 0;
    JButton[] botones;
    public SeleccionDialog(Frame parent, boolean modal){
        super(parent, modal);
        this.setSize(300,100);
        this.setLayout(new GridLayout(1,BackPanel.textPanels.size()));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.botones = new JButton[BackPanel.textPanels.size()];
        for (int i = 0; i < BackPanel.textPanels.size(); i++) {
            botones[i]=new JButton(""+(i+1));
            botones[i].addActionListener(this);
            this.add(botones[i]);
        }
        this.setResizable(false);
        this.setLocationRelativeTo(null);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        seleccion=Integer.parseInt(((JButton)e.getSource()).getText());
        dispose();

    }
    public int getSeleccion(){
        return seleccion;
    }

}
