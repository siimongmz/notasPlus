package notas.Principal;


import javax.swing.*;

import static notas.Principal.Propiedades.aplicarConfig;

public class Notas {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppFrame ventana = AppFrame.getInstance();
        });

        aplicarConfig();
    }
    
}
