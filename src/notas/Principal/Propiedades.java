package notas.Principal;

import notas.Ajustes.Tema;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public abstract class Propiedades {

    /*----------------Datos----------------*/
    
    static private final File config =new File("./src/notas/Ajustes/config.txt");
    
    static public Dimension windowSize = new Dimension((int)Math.round(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width*0.75),(int)Math.round(java.awt.Toolkit.getDefaultToolkit().getScreenSize().height*0.75));

    static public File carpetaNotas = new File("./src/notas/ArchivoNotas");


    //Imagenes
    static public final ImageIcon logoClaro = new ImageIcon("./src/resources/logoSinFondo.png","Notas+");
    static public final ImageIcon logoOscuro = new ImageIcon("./src/resources/logoSinFondo.png","Notas+");
    static public final ImageIcon ajustesLogoClaro = new ImageIcon("./src/resources/ajuste.png","Notas+");
    static public final ImageIcon ajustesLogoOscuro = new ImageIcon("./src/resources/ajusteOscuro.png","Notas+");
    static public final ImageIcon addLogoClaro = new ImageIcon("./src/resources/add.png","Notas+");
    static public final ImageIcon addLogoOscuro = new ImageIcon("./src/resources/addOscuro.png","Notas+");

    static public ImageIcon logo = logoClaro;
    static public ImageIcon logoAjustes = ajustesLogoClaro;
    static public ImageIcon logoAdd = addLogoClaro;


    //Temas
    static final Tema temaVerde = new Tema("Verde",new Color(32, 79, 21),new Color(109, 192, 52));
    static final Tema temaAzul = new Tema("Azul",new Color(21, 40, 79),new Color(47, 88, 173));
    static final Tema temaRojo = new Tema("Rojo",new Color(79, 21, 21),new Color(173, 47, 47));
    static final Tema temaMorado = new Tema("Morado",new Color(58, 21, 79),new Color(108, 47, 173));
    static final Tema temaAmarillo = new Tema("Amarillo",new Color(135, 109, 34),new Color(234, 195, 17));
    static final Tema temaOscuro = new Tema("Oscuro",new Color(35, 35, 35),new Color(58, 58, 58));
    static final Tema temaClaro = new Tema("Claro",new Color(110, 110, 110),new Color(227, 227, 227));

    static private Tema temaActual = temaAzul;

    //Fuentes

    public static Font lexendRegular = crearFuente("Regular");
    public static Font lexendExtraBold = crearFuente("ExtraBold");

    //padding
    static int paddingTexto = 10;



    /*----------------Metodos----------------*/



    static public void setTema(String tema){
        tema = tema.toLowerCase();
        switch (tema){
            case "azul" -> {
                temaActual = temaAzul;
                logo = logoClaro;
                logoAjustes=ajustesLogoClaro;
                logoAdd =addLogoClaro;}
            case "rojo" -> {
                temaActual = temaRojo;
                logo = logoClaro;
                logoAjustes = ajustesLogoClaro;
                logoAdd =addLogoClaro;}
            case "verde" -> {
                temaActual = temaVerde;
                logo = logoClaro;
                logoAjustes = ajustesLogoClaro;
                logoAdd =addLogoClaro;}
            case "morado" -> {
                temaActual=temaMorado;
                logo = logoClaro;
                logoAjustes = ajustesLogoClaro;
                logoAdd =addLogoClaro;}
            case "amarillo" -> {
                temaActual = temaAmarillo;
                logo = logoClaro;
                logoAjustes = ajustesLogoClaro;
                logoAdd =addLogoClaro;}
            case "oscuro" -> {
                temaActual = temaOscuro;
                logo = logoClaro;
                logoAjustes = ajustesLogoClaro;
                logoAdd =addLogoClaro;}
            case "claro" -> {
                temaActual = temaClaro;
                logo = logoOscuro;
                logoAjustes = ajustesLogoOscuro;
                logoAdd =addLogoOscuro;}


        }

        AppFrame.getInstance().repaint();
        for (TextPanel t : BackPanel.textPanels){
            t.repaint();
        }

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
    public static Font crearFuente(String tipo){
        Font fuente;
        try {
            fuente = Font.createFont(Font.TRUETYPE_FONT,new File("./src/resources/fonts/Lexend-"+tipo+".ttf"));
            fuente = fuente.deriveFont(Font.PLAIN,14f);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }

        return fuente;
    }
    
}
