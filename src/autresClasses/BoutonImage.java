/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autresClasses;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Abider
 */
public class BoutonImage extends JButton {
    private Image img;

    public BoutonImage(Image im) {
        super();
        this.img = im;

    }

    public BoutonImage() {
        super();
        Image im = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/joueurDefaut.png"));
        this.img = im;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (this.img != null) {

            Image im = this.img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT);
            this.setIcon(new ImageIcon(im));
        }
    }

}
