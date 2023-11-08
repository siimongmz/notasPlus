package notas;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JEditorPane;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.border.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import static notas.Propiedades.*;

public class TextInterfaz extends JEditorPane{
    
    static Font fuente = new Font(Font.SANS_SERIF,  Font.BOLD, 90);
    static String texto;
    
    public TextInterfaz(){
      
        this.setOpaque(false);
        this.setBackground(new Color(255,255,255));
        HTMLEditorKit editorKit = new HTMLEditorKit();
        this.setEditorKit(editorKit);
        this.setMaximumSize(new Dimension(20, Integer.MAX_VALUE));
        this.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true);
        this.putClientProperty(JEditorPane.W3C_LENGTH_UNITS, true);

        
        this.setText("<head><style>body{font-size:40;padding:10px;}</style></head><body></body>");
        
        
    }
    
    @Override
    protected void paintComponent(Graphics g){
        
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setPaint(new GradientPaint(0,0,superLightBlue,0,windowSize.height,lightBlue,true));
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());
        g2.setColor(new Color(0,0,0,50));
        g2.fill(new RoundRectangle2D.Double(paddingTexto, paddingTexto, this.getWidth()-paddingTexto*2, this.getHeight()-paddingTexto*2, 25,25));
        
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
