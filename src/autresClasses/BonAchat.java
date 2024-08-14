/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autresClasses;

/**
 *
 * @author Abider
 */
public class BonAchat extends Lot {

    private double somme;

    public BonAchat(String descriptif, String categorie, int niveau, double somme) {
        super(descriptif, categorie, niveau);
        this.setSomme(somme);

    }

    public double getSomme() {
        return somme;
    }

    public void setSomme(double somme) {
        this.somme = somme;
    }

}
