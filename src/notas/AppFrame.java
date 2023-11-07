/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notas;

import java.awt.Graphics;
import javax.swing.JFrame;
import static notas.Propiedades.*;

/**
 *
 * @author Usuario
 */
public class AppFrame extends JFrame{
    
    BackPanel bp = new BackPanel();
    
    public AppFrame(){
        this.setSize(windowSize);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(bp);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
    
    
    
    
}
