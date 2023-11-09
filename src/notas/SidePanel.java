package notas;

import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import javax.swing.*;

import static notas.Propiedades.*;
public class SidePanel extends JPanel{
    JPanel panelBotones = new JPanel();
    private int offsetY = 0;
    public SidePanel(){
        /*
        * TODO: tenemos que poner que el tamaño sea el de la ventana no el de la pantalla
        * */
        this.setSize(320, Toolkit.getDefaultToolkit().getScreenSize().height);
        this.setPreferredSize(new Dimension(320, Toolkit.getDefaultToolkit().getScreenSize().height));
        this.setVisible(true);
        this.setOpaque(false);

        this.add(panelBotones);
        panelBotones.setVisible(true);
        panelBotones.setSize(320, this.getHeight());
        panelBotones.setPreferredSize(new Dimension(320, this.getHeight()));
        panelBotones.setOpaque(false);
        panelBotones.setLayout(null);


        FlowLayout fl = new FlowLayout();
        this.setLayout(fl);
        this.setLayout(null);
        fl.setVgap(110);
        this.Actualizar();
        this.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                offsetY = e.getUnitsToScroll()*10;
                for (int i = 0; i < panelBotones.getComponentCount(); i++) {
                    Component component = panelBotones.getComponent(i);

                    /*
                    * TODO: Tenemos que hacer que los botones sigan subiendo solo hasta que se
                    *  muestre el ultimo de los botones
                    * */


                    if(i==panelBotones.getComponentCount()-1&&component.getY()<900&&offsetY>0){
                        break;
                    }
                    component.setLocation(component.getX(), component.getY() - offsetY);

                }
                revalidate();
                panelBotones.repaint();
                repaint();
            }
        });

    }
    
    public void Actualizar(){

        String[] lista = carpetaNotas.list();
        File[] listaArchivos =carpetaNotas.listFiles();
        ButtonPanel boton;
        int anterior=100;

        for (int i = 0; i < lista.length; i++) {
            boton = new ButtonPanel(0,lista[i].split(".html")[0],listaArchivos[i]);
            boton.setBounds(10, anterior, 300, 75);
            anterior=anterior+90;

            this.panelBotones.add(boton);

        }

    }
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g.create();
        super.paintComponent(g);
        g.drawImage(logo.getImage(),0,0,logo.getIconWidth()/3,logo.getIconHeight()/3,this);



    }
    
}
