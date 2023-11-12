package notas.Principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import notas.Ajustes.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ButtonPanel extends JPanel implements MouseListener{
    boolean dentro = false;
    int function;
    File fichero;
    final static int  AJUSTES = 9;
    final static int IMPRIMIR = 2;
    final static int DEFAULT = 1;
    final static int ARCHIVO = 0;


    
    public ButtonPanel(int f,String text,File fichero){
        this.setSize(300, 50);
        this.setPreferredSize(new Dimension(300,70));
        this.setOpaque(false);
        this.addMouseListener(this);
        this.setVisible(true);
        this.function = f;
        this.add(new JLabel(text)).setFont(new Font(Font.SANS_SERIF,  Font.ITALIC, 40));
        this.fichero = fichero;
    
    }
    
    public ButtonPanel(int f,int width,int height){
        this.setSize(width, height);
        this.setPreferredSize(new Dimension(width,height));
        this.setOpaque(false);
        this.addMouseListener(this);
        this.setVisible(true);
        this.function = f;
    
    }
    public ButtonPanel(int f,int width,int height,String text){
        this.setSize(width, height);
        this.setPreferredSize(new Dimension(width,height));
        this.setOpaque(false);
        this.addMouseListener(this);
        this.setVisible(true);
        this.function = f;
        this.add(new JLabel("\n"+text)).setFont(new Font(Font.SANS_SERIF,  Font.PLAIN, 15));
    
    }
    
    @Override
    protected void paintComponent(Graphics g){

        switch (function){
            case ARCHIVO -> pintarBoton0(g);
            case DEFAULT,AJUSTES -> pintarBoton1(g);
            case IMPRIMIR -> pintarBoton2(g);
        }
        super.paintComponent(g);
    }
    
    protected void pintarBoton0(Graphics g){
        Graphics2D g2 = (Graphics2D) g.create();
        if(dentro){
            g2.setColor(new Color(255,255,255,200));
        }else{
            g2.setColor(new Color(255,255,255,100));
        }

        g2.fill(new RoundRectangle2D.Double(0, 0, this.getWidth(), this.getHeight(), 25,25));

    }
    protected void pintarBoton1(Graphics g){
        Graphics2D g2 = (Graphics2D) g.create();
        if(dentro){
            g2.setColor(Propiedades.getTema().secundario);
        }else{
            g2.setColor(Propiedades.getTema().principal);
        }

        g2.fillRect(0, 0, this.getWidth(), this.getHeight());

    }
    protected void pintarBoton2(Graphics g){
        Graphics2D g2 = (Graphics2D) g.create();
        if(dentro){
            g2.setColor(Propiedades.getTema().secundario);
        }else{
            g2.setColor(Propiedades.getTema().principal);
        }

        g2.fillRect(0, 0, this.getWidth(), this.getHeight());

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        switch (function){

            case ARCHIVO -> accionArchivo();
            case DEFAULT -> accionDefault();
            case IMPRIMIR -> accionImprimir();
            case AJUSTES -> accionAjustes();
        }
    }

    private void accionArchivo(){
        try {
            FileReader fr = new FileReader(fichero);
            int sig;
            String contenido = "";
            while((sig=fr.read())!=-1){
                contenido += (char)sig;
            }
            TextPanel.ti.setText(contenido);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    private void accionDefault(){

        String html = TextPanel.ti.getText();
        Document doc = Jsoup.parse(html);
        int pos = TextPanel.ti.getCaretPosition();
        int contador=0;
        String selec=TextPanel.ti.getSelectedText();
        Element bold = new Element("b");



        for (Element element : doc.select("*")) {

            if (element.hasText()) {
                contador+=element.ownText().length();
                System.out.println(element.tagName());
                System.out.println(element.ownText());
                System.out.println(contador+"-"+pos);


                if(contador>pos){
                    String texto=element.ownText();
                    System.out.println(element.ownText());
                    element.text(texto.substring(0, (contador-pos)-selec.length()));
                    element.appendChild(bold.text(selec));
                    element.appendText(texto.substring((contador-pos)));




                    System.out.println(doc.html());
                    break;
                }else{
                    if(element.tagName().equals("p") && element.ownText().length()>=1){
                        contador+=1;
                    }


                }
            }
        }
    }
    private void accionImprimir(){
        TextPanel.ti.limpiarHTML();
        System.out.println();
    }
    private void accionAjustes(){
            AjustesFrame af = AjustesFrame.getInstance();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getClickCount()==2 && this.function == ARCHIVO){
            String nombre = JOptionPane.showInputDialog("Que nombre quieres poner");
            this.removeAll();
            this.add(new JLabel(nombre)).setFont(new Font(Font.SANS_SERIF,  Font.ITALIC, 40));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
        dentro = true;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
        dentro = false;
        repaint();
        
    }
    
}