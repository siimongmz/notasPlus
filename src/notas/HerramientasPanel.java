/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notas;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
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
