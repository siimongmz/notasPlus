package notas;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import static notas.Propiedades.*;
public class TextPanel extends JPanel{
    static TextInterfaz ti = new TextInterfaz();
    
    TextPanel(){
        
        this.setBackground(new Color(0,0,0,30));
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.add(ti,BorderLayout.CENTER);
        this.add(new HerramientasPanel(),BorderLayout.NORTH);
        
    }
    
    
    
    
   
    
}
