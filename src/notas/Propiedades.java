package notas;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

public interface Propiedades {
    
    
    
    Dimension windowSize = new Dimension((int)Math.round(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width*0.75),(int)Math.round(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height*0.75));
    static File carpetaNotas = new File("./src/notas/ArchivoNotas");
    Color lightBlue = new Color(80,80,255);
    Color superLightBlue = new Color(200,200,255);
    
}
