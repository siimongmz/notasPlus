package notas.Principal;

import java.awt.*;
import javax.swing.JPanel;

public class HerramientasPanel extends JPanel{


    
    HerramientasPanel(){
        this.setLayout(new GridLayout(1,9,0,0));
        this.setBackground(Propiedades.getTema().principal);
        this.add(new ButtonPanel(ButtonPanel.DEFAULT,60,30));
        this.add(new ButtonPanel(ButtonPanel.DEFAULT,60,30));
        this.add(new ButtonPanel(ButtonPanel.DEFAULT,60,30));
        this.add(new ButtonPanel(ButtonPanel.DEFAULT,60,30));
        this.add(new ButtonPanel(ButtonPanel.CERRAR,60,30,"Cerrar"));
        this.add(new ButtonPanel(ButtonPanel.GUARDAR,60,30,"Guardar"));
        this.add(new ButtonPanel(ButtonPanel.IMPRIMIR,60,30,"Imprimir"));

        this.setVisible(true);
    }
    
}
