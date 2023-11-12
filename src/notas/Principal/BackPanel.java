package notas.Principal;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;

public class BackPanel extends JPanel{
    static ArrayList<TextPanel> textPanels = new ArrayList<>();
    static private JPanel contenedor = new JPanel();
    static private GridBagConstraints gbc = new GridBagConstraints();
    static private GridBagLayout layout= new GridBagLayout();
    static private GridLayout gl = new GridLayout(1,1);
    
    public BackPanel(){
        this.setSize(Propiedades.windowSize);
        this.setLayout(new BorderLayout());
        this.add(new SidePanel(),BorderLayout.WEST);
        gl.setColumns(textPanels.size());
        contenedor.setBackground(Color.ORANGE);
        contenedor.setLayout(layout);
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridheight=1;
        gbc.gridwidth=1;
        textPanels.add(new TextPanel());
        contenedor.add(textPanels.get(0),gbc);
        contenedor.setVisible(true);
        this.add(contenedor,BorderLayout.CENTER);
        this.setVisible(true);
    
    }
    
    
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setPaint(new GradientPaint(0,0, Propiedades.getTema().principal,0,Propiedades.windowSize.height, Propiedades.getTema().secundario,true));
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());

    }
    protected static void actualizarContenedor(){
        contenedor.removeAll();
        if(textPanels.size()>2){
            gl.setRows(2);
        }

        for (int i = 0; i< textPanels.size(); i++){
            if (i<2){
                gbc.gridx=i;
                gbc.gridy=0;
                gbc.gridheight=1;
                gbc.gridwidth=1;
            }else{
                gbc.gridx=i-2;
                gbc.gridy=1;
                gbc.gridwidth=2;
            }

            contenedor.add(textPanels.get(i),gbc);
        }
        contenedor.revalidate();

    }
}
