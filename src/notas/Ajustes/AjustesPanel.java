package notas.Ajustes;

import notas.Principal.Propiedades;
import notas.Principal.SidePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AjustesPanel extends JPanel implements ActionListener {

    JButton guardar,botonCarpeta;
    JComboBox<String> eleccionTema;
    File directorio = Propiedades.carpetaNotas;

    protected AjustesPanel(){
        this.setSize(500,500);
        this.setLayout(null);
        //Carpeta Guardado
        botonCarpeta = new JButton("Elegir Carpeta");
        botonCarpeta.setBounds(220,80,250,40);
        botonCarpeta.addActionListener(this);
        this.add(botonCarpeta);
        //ComboBox
        eleccionTema= new JComboBox<String>();
        eleccionTema.addItem("Azul");
        eleccionTema.addItem("Rojo");
        eleccionTema.addItem("Verde");
        eleccionTema.addItem("Morado");

        eleccionTema.setBounds(220,20,250,40);
        this.add(eleccionTema);
        //Boton Guardado
        guardar = new JButton("Guardar");
        guardar.addActionListener(this);
        guardar.setBounds(370,420,100,30);
        this.add(guardar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==guardar){
            Propiedades.carpetaNotas=directorio;
            SidePanel.Actualizar();
            notas.Principal.Propiedades.setTema((String)this.eleccionTema.getSelectedItem());
            Propiedades.guardarConfig();
        }
        else if(e.getSource()==botonCarpeta){
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fc.setVisible(true);
            int val = fc.showOpenDialog(AjustesFrame.getInstance());
            if(val == JFileChooser.APPROVE_OPTION){
                directorio = fc.getSelectedFile();
            }

        }
    }
}
