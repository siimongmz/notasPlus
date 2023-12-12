package notas.Principal;

import java.awt.*;
import javax.swing.JPanel;

public class HerramientasPanel extends JPanel{
    HerramientasPanel(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.gridheight = 0;
        gbc.gridwidth = 7;
        gbc.fill = GridBagConstraints.BOTH;

        GridBagLayout gl = new GridBagLayout();
        this.setLayout(gl);
        this.setBackground(new Color(0, 0, 0,0));
        this.add(new ButtonPanel(ButtonPanel.DEFAULT,60,30),gbc);
        this.add(new ButtonPanel(ButtonPanel.DEFAULT,60,30),gbc);
        this.add(new ButtonPanel(ButtonPanel.DEFAULT,60,30),gbc);
        this.add(new ButtonPanel(ButtonPanel.DEFAULT,60,30),gbc);
        this.add(new ButtonPanel(ButtonPanel.DEFAULT,60,30),gbc);
        this.add(new ButtonPanel(ButtonPanel.GUARDAR,60,30,"Guardar"),gbc);
        this.add(new ButtonPanel(ButtonPanel.IMPRIMIR,60,30,"Imprimir"),gbc);

        this.setVisible(true);
    }
    
}
