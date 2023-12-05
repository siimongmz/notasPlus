package notas.Principal;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import javax.swing.JEditorPane;
import javax.swing.text.html.HTMLEditorKit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TextInterfaz extends JEditorPane{
    
    Font fuente = new Font(Font.SANS_SERIF,  Font.BOLD, 90);
    String texto;
    File ficheroActual;
    ButtonPanel botonCerrar;
    
    public TextInterfaz(){
      
        this.setOpaque(false);
        HTMLEditorKit editorKit = new HTMLEditorKit();
        this.setEditorKit(editorKit);
        this.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true);
        this.putClientProperty(JEditorPane.W3C_LENGTH_UNITS, true);
        botonCerrar = new ButtonPanel(ButtonPanel.CERRAR,30,30,"X");
        this.add(botonCerrar);
        this.setVisible(true);
        this.setText("<head><style>body{font-size:40;padding:20px;}</style></head><body></body>");


    }
    
    @Override
    protected void paintComponent(Graphics g){
        
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setPaint(new GradientPaint(0,0, Propiedades.getTema().principal,0,Propiedades.windowSize.height, Propiedades.getTema().secundario,true));
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2.setColor(new Color(255,255,255,90));
        g2.fill(new RoundRectangle2D.Double(Propiedades.paddingTexto, Propiedades.paddingTexto, this.getWidth()-Propiedades.paddingTexto*2, this.getHeight()-Propiedades.paddingTexto*2, 25,25));
        
        texto=this.getText();
        super.paintComponent(g);
        botonCerrar.setBounds(this.getWidth()-40,10,30,30);
        this.revalidate();
        
    }
    
    public void setFuenteActual(Font f){
        fuente = f;
    }
    public void getTexto(){
        System.out.println(texto);
    }
    
    public void limpiarHTML(){
        String html = this.getText();
        Document doc = Jsoup.parse(html);

        for (Element element : doc.select("*")) {
            if (!element.hasText() && element.isBlock()) {
                element.remove();
            }
        }

        this.setText(doc.body().html());
        System.out.println(this.getText());
    }
    
}
