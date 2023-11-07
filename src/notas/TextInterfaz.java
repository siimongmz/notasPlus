package notas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JEditorPane;
import javax.swing.text.html.HTMLEditorKit;
import static notas.Propiedades.lightBlue;
import static notas.Propiedades.superLightBlue;
import static notas.Propiedades.windowSize;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TextInterfaz extends JEditorPane{
    
    static Font fuente = new Font(Font.SANS_SERIF,  Font.BOLD, 90);
    static String texto;
    
    public TextInterfaz(){
      
        this.setOpaque(false);
        
        this.setBackground(new Color(255,255,255));
        
        HTMLEditorKit editorKit = new HTMLEditorKit();
        this.setEditorKit(editorKit);
        
        this.setText("<head><style>body{font-size:50}</style></head>");
        
        
    }
    
    @Override
    protected void paintComponent(Graphics g){
        
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setPaint(new GradientPaint(0,0,superLightBlue,0,windowSize.height,lightBlue,true));
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2.setColor(new Color(0,0,0,50));
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        texto=this.getText();
        super.paintComponent(g);
        
    }
    
    public static void setFuenteActual(Font f){
        fuente = f;
        
    }
    public static void getTexto(){
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
