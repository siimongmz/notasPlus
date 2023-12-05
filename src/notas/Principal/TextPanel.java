package notas.Principal;



import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

public class TextPanel extends JPanel{
    TextInterfaz ti ;
    
    TextPanel(){
        BorderLayout bl = new BorderLayout();
        this.setLayout(bl);
        this.setVisible(true);
        ti = new TextInterfaz();
        this.add(new HerramientasPanel(),BorderLayout.NORTH);
        this.add(ti,BorderLayout.CENTER);
        
    }
}
