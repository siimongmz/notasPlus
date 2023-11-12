package notas.Principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MenuSeleccion extends JPopupMenu implements ActionListener {
    JMenuItem[] items;
    File fichero;
    public MenuSeleccion(File fichero) {
        this.fichero= fichero;
        this.items = new JMenuItem[BackPanel.textPanels.size()];
        for (int i = 0; i < BackPanel.textPanels.size(); i++) {
            items[i]=new JMenuItem(""+(i+1));
            items[i].addActionListener(this);

            this.add(items[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            FileReader fr = new FileReader(this.fichero);
            int sig;
            String contenido = "";
            while((sig=fr.read())!=-1){
                contenido += (char)sig;
            }
            if(BackPanel.textPanels.size()==1){
                BackPanel.textPanels.get(0).ti.setText(contenido);
            }else{
                JMenuItem opcion =(JMenuItem) e.getSource();
                BackPanel.textPanels.get(Integer.parseInt(opcion.getText())-1).ti.setText(contenido);
            }

            fr.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
