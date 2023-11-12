package notas.Principal;

import notas.Ajustes.Tema;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.io.*;

public abstract class Propiedades {

    /*----------------Datos----------------*/
    
    static private final File config =new File("./src/notas/Ajustes/config.txt");
    
    static public Dimension windowSize = new Dimension((int)Math.round(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width*0.75),(int)Math.round(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height*0.75));

    static public File carpetaNotas = new File("./src/notas/ArchivoNotas");
    static public ImageIcon logo = new ImageIcon("./src/resources/logoSinFondo.png","Notas+");


    //Temas
    static final Tema temaVerde = new Tema("verde",new Color(32, 79, 21),new Color(109, 192, 52));
    static final Tema temaAzul = new Tema("azul",new Color(21, 40, 79),new Color(47, 88, 173));
    static final Tema temaRojo = new Tema("rojo",new Color(79, 21, 21),new Color(173, 47, 47));
    static final Tema temaMorado = new Tema("morado",new Color(58, 21, 79),new Color(108, 47, 173));

    static private Tema temaActual = temaAzul;

    static int paddingTexto = 10;



    /*----------------Metodos----------------*/



    static public void setTema(String tema){
        tema = tema.toLowerCase();
        switch (tema){
            case "azul" -> temaActual=temaAzul;
            case "rojo" -> temaActual=temaRojo;
            case "verde" -> temaActual=temaVerde;
            case "morado" -> temaActual=temaMorado;

        }

        AppFrame.getInstance().repaint();

    }

    public static Tema getTema(){
        return temaActual;
    }

    public static void aplicarConfig(){
        try {

            FileReader fr = new FileReader(config);
            final String SEPARADOR = " , ";
            final int TEMA = 0;
            final int CARPETA = 1;
            StringBuilder infoText = new StringBuilder();
            String[] configuracion;
            int actual;

            while ((actual=fr.read())!=-1){
                infoText.append((char) actual);
            }
            configuracion = infoText.toString().split(SEPARADOR);
            carpetaNotas = new File(configuracion[CARPETA]);
            SidePanel.Actualizar();
            setTema(configuracion[TEMA]);
            fr.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void guardarConfig(){
        try {

            FileWriter fw = new FileWriter(config);
            PrintWriter pw = new PrintWriter(fw);
            final String SEPARADOR = " , ";

            if (config.exists()){
                pw.write(getTema().nombre+SEPARADOR+carpetaNotas.getAbsolutePath());
            }
            pw.close();
            fw.close();
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
}
