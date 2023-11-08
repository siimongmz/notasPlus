package notas;

import java.awt.BorderLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import static notas.Propiedades.*;

public class BackPanel extends JPanel{
    
    public BackPanel(){
        this.setSize(windowSize);
        this.setLayout(new BorderLayout());
        this.add(new SidePanel(),BorderLayout.WEST);
        this.add(new TextPanel(),BorderLayout.CENTER);
        this.setVisible(true);
    
    }
    
    
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setPaint(new GradientPaint(0,0, colorFondo2,0,windowSize.height, colorFondo1,true));
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());
    
    }
}
