package notas.Principal;


import java.awt.BorderLayout;
import javax.swing.JPanel;

public class TextPanel extends JPanel{
    static TextInterfaz ti = new TextInterfaz();
    
    TextPanel(){
        BorderLayout bl = new BorderLayout();
        this.setLayout(bl);
        this.setVisible(true);
        this.add(ti,BorderLayout.CENTER);
        this.add(new HerramientasPanel(),BorderLayout.NORTH);
        
    }
    
    
    
    
   
    
}
