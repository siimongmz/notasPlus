package notas;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class HerramientasPanel extends JPanel{
    
    HerramientasPanel(){
        this.setPreferredSize(new Dimension(this.getWidth(),60));
        this.setLayout(new GridLayout(1,9,2,0));
        this.add(new ButtonPanel(1,60,60));
        this.add(new ButtonPanel(1,60,60));
        this.add(new ButtonPanel(1,60,60));
        this.add(new ButtonPanel(1,60,60));
        this.add(new ButtonPanel(1,60,60));
        this.add(new ButtonPanel(1,60,60));
        this.add(new ButtonPanel(1,60,60));
        this.add(new ButtonPanel(1,60,60,"Guardar"));
        this.add(new ButtonPanel(2,60,60,"Imprimir"));
        this.setVisible(true);
    }
    
}
