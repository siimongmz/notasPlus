package notas.Principal;



import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;

public class TextPanel extends JPanel{
    TextInterfaz ti ;
    
    TextPanel(){
        BorderLayout bl = new BorderLayout();
        this.setBackground(new Color(0,0,0,0));
        this.setLayout(bl);
        this.setVisible(true);
        ti = new TextInterfaz();
        this.add(new HerramientasPanel(),BorderLayout.NORTH);
        this.add(ti,BorderLayout.CENTER);
        
    }
}
