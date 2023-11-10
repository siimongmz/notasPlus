package notas;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

import static notas.Propiedades.colorFondo1;

public class HerramientasPanel extends JPanel{
    
    HerramientasPanel(){
        this.setPreferredSize(new Dimension(this.getWidth(),30));
        this.setBackground(colorFondo1);
        this.setLayout(new GridLayout(1,9,1,0));
        this.add(new ButtonPanel(1,60,30));
        this.add(new ButtonPanel(1,60,30));
        this.add(new ButtonPanel(1,60,30));
        this.add(new ButtonPanel(1,60,30));
        this.add(new ButtonPanel(1,60,30));
        this.add(new ButtonPanel(1,60,30));
        this.add(new ButtonPanel(1,60,30));
        this.add(new ButtonPanel(1,60,30,"Guardar"));
        this.add(new ButtonPanel(2,60,30,"Imprimir"));
        this.setVisible(true);
    }
    
}
