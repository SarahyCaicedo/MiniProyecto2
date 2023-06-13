package view;

import javax.swing.*;
import java.awt.*;

public class Fondo  extends JPanel {
    private Image imagenFondo;

    public Fondo(Image imagenFondo){
        this.imagenFondo = imagenFondo;
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo !=null){
            g.drawImage(imagenFondo,0,0,getWidth(), getHeight(), this);
        }
    }
}
