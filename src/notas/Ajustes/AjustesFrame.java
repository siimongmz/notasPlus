package notas.Ajustes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AjustesFrame extends JFrame {
    private static AjustesFrame af;
    public AjustesFrame(){

        //Look and feel
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500,500);
        this.add(new AjustesPanel());
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                af = null;
            }
        });
    }
    public static AjustesFrame getInstance(){
        if (af == null){
            af = new AjustesFrame();
        }
        return af;
    }

}
