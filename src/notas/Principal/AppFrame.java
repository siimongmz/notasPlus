package notas.Principal;

import javax.swing.JFrame;

public class AppFrame extends JFrame{
    
    BackPanel bp = new BackPanel();
    static AppFrame af = new AppFrame();
    
    public AppFrame(){
        this.setSize(Propiedades.windowSize);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(bp);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

    public static AppFrame getInstance(){
        return af;
    }
    
    
    
    
}
