/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autresClasses;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Abider
 */
public class PanneauImage extends JPanel {
    private Image img;

    public PanneauImage() {
        super();
        ImageIcon im;
        im = new ImageIcon(getClass().getResource("/Images/ordinateur.jpg"));
        this.img = im.getImage();
    }

    public PanneauImage(Image img) {
        super();
        this.img = img;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
        this.repaint(); // on rafraichi à chaque ajout
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (this.img != null) {
            g.drawImage(this.img, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}
