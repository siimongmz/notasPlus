package notas;

import java.awt.Graphics;
import javax.swing.JFrame;
import static notas.Propiedades.*;

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
