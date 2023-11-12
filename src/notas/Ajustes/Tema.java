package notas.Ajustes;

import java.awt.*;

public class Tema {
    public Color secundario, principal;
    public String nombre;

    public Tema(String nombre,Color secundario, Color principal) {
        this.nombre = nombre;
        this.secundario = secundario;
        this.principal = principal;
    }
}
