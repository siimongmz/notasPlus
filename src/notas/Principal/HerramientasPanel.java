package notas.Principal;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class HerramientasPanel extends JPanel{


    
    HerramientasPanel(){
        this.setPreferredSize(new Dimension(1000,30));
        this.setLayout(new GridLayout(1,9));

        this.add(new ButtonPanel(ButtonPanel.DEFAULT,60,30));
        this.add(new ButtonPanel(ButtonPanel.DEFAULT,60,30));
        this.add(new ButtonPanel(ButtonPanel.DEFAULT,60,30));
        this.add(new ButtonPanel(ButtonPanel.DEFAULT,60,30));
        this.add(new ButtonPanel(ButtonPanel.DEFAULT,60,30));
        this.add(new ButtonPanel(ButtonPanel.DEFAULT,60,30));
        this.add(new ButtonPanel(ButtonPanel.DEFAULT,60,30,"Guardar"));
        this.add(new ButtonPanel(ButtonPanel.IMPRIMIR,60,30,"Imprimir"));
        this.add(new ButtonPanel(ButtonPanel.AJUSTES,60,30,"Ajustes"));
        this.setVisible(true);
    }
    
}
