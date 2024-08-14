/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autresClasses;

import java.awt.Image;

/**
 *
 * @author Abider
 */
public class Objet extends Lot {

    private Image pho;

    public Objet(String descriptif, String categorie, int niveau, Image img) {
        super(descriptif, categorie, niveau);
        this.pho = img;
    }

    public Image getPho() {
        return pho;
    }

    public void setPho(Image img) {
        this.pho = img;
    }

}
