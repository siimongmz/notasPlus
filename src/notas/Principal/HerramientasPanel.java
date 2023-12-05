package notas.Principal;

import java.awt.*;
import javax.swing.JPanel;

public class HerramientasPanel extends JPanel{


    
    HerramientasPanel(){
        this.setLayout(new GridLayout(1,9,0,0));
        this.add(new ButtonPanel(ButtonPanel.DEFAULT,60,30));
        this.add(new ButtonPanel(ButtonPanel.DEFAULT,60,30));
        this.add(new ButtonPanel(ButtonPanel.DEFAULT,60,30));
        this.add(new ButtonPanel(ButtonPanel.DEFAULT,60,30));
        this.add(new ButtonPanel(ButtonPanel.DEFAULT,60,30));
        this.add(new ButtonPanel(ButtonPanel.GUARDAR,60,30,"Guardar"));
        this.add(new ButtonPanel(ButtonPanel.IMPRIMIR,60,30,"Imprimir"));

        this.setVisible(true);
    }
    
}
