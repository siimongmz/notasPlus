/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notas;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import javax.swing.JPanel;
import static notas.Propiedades.*;

/**
 *
 * @author Usuario
 */
public class SidePanel extends JPanel{
    
    public SidePanel(){
        this.setSize(320, windowSize.height);
        this.setPreferredSize(new Dimension(320, windowSize.height));
        this.setVisible(true);
        this.setBackground(new Color(160,160,255));
        this.Actualizar();
    
    }
    
    public void Actualizar(){
        
        String[] lista = carpetaNotas.list();
        File[] listaArchivos =carpetaNotas.listFiles();
        
        for (int i = 0; i < lista.length; i++) {
            this.add(new ButtonPanel(0,lista[i].split(".html")[0],listaArchivos[i]));
        }
        
    }
    
}
