/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autresClasses;

/**
 *
 * @author Abider
 */
public class Lot {
    private String descriptif;
    private String categorie;
    private int niveau;

    public Lot(String descriptif, String categorie, int niveau) {
        this.descriptif = descriptif;
        this.categorie = categorie;
        this.niveau = niveau;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

}
