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
    int separacionVertical=110;
    public SidePanel(){
        /*
        * TODO: tenemos que poner que el tamaño sea el de la ventana no el de la pantalla
        * */
        this.setSize(320, windowSize.height);
        this.setPreferredSize(new Dimension(320, windowSize.height));
        this.setVisible(true);
        this.setOpaque(false);

        this.add(panelBotones);
        panelBotones.setBounds(0,separacionVertical,320,this.getHeight()-separacionVertical);
        panelBotones.setVisible(true);
        panelBotones.setSize(320, this.getHeight()-separacionVertical);
        panelBotones.setPreferredSize(new Dimension(320, this.getHeight()-separacionVertical));
        panelBotones.setOpaque(false);
        panelBotones.setLayout(null);



        this.setLayout(null);
        this.Actualizar();
        this.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                //offset es la cantidad de movimiento que hará el mouse será positivo o neativo dependiendo de la direccion
                offsetY = e.getUnitsToScroll()*10;


                /*
                * En este bucle se actualiza la posicion de los botones segun se mueve el offset
                * y se comprueba la posicion de los botones para limitar cuanto se pueden desplazar
                * */
                for (int i = 0; i < panelBotones.getComponentCount(); i++) {
                    Component component = panelBotones.getComponent(i);
                    if(i==0&&component.getY()<-90*panelBotones.getComponentCount()+panelBotones.getHeight()&&offsetY>0){
                        break;
                    } else if (i==0&& component.getY()>0&&offsetY<0) {
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

    //Este metodo sirve para poner el numero de botones en funcion del numero de archivos
    public void Actualizar(){

        String[] lista = carpetaNotas.list();
        File[] listaArchivos =carpetaNotas.listFiles();
        ButtonPanel boton;
        int anterior=0;

        //Recorremos el directorio de las notas y creamos los


        for (int i = 0; i < lista.length; i++) {
            boton = new ButtonPanel(0,lista[i].split(".html")[0],listaArchivos[i]);
            boton.setBounds(10, i*90, 300, 75);
            this.panelBotones.add(boton);

        }

    }
    @Override
    protected void paintComponent(Graphics g){
        this.setSize(320, AppFrame.getAppFrame().getHeight());
        this.setPreferredSize(new Dimension(320, AppFrame.getAppFrame().getHeight()));
        panelBotones.setSize(320, this.getHeight()-separacionVertical);
        panelBotones.setPreferredSize(new Dimension(320, this.getHeight()-separacionVertical));
        panelBotones.setBounds(0,separacionVertical,320,this.getHeight()-separacionVertical);

        Graphics2D g2 = (Graphics2D) g.create();
        super.paintComponent(g);
        g.drawImage(logo.getImage(),0,0,logo.getIconWidth()/3,logo.getIconHeight()/3,this);

    }
}
