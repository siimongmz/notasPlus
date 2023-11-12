package notas.Principal;

import java.awt.BorderLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class BackPanel extends JPanel{
    
    public BackPanel(){
        this.setSize(Propiedades.windowSize);
        this.setLayout(new BorderLayout());
        this.add(new SidePanel(),BorderLayout.WEST);
        this.add(new TextPanel(),BorderLayout.CENTER);
        this.setVisible(true);
    
    }
    
    
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setPaint(new GradientPaint(0,0, Propiedades.getTema().principal,0,Propiedades.windowSize.height, Propiedades.getTema().secundario,true));
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());
    
    }
}
