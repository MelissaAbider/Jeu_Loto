/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autresClasses;

import java.util.ArrayList;

/**
 *
 * @author Abider
 */
public class LesCartes {
    private ArrayList<CarteLoto> lc; // déclaration d'un arrayList de CarteLoto

    public LesCartes() {
        this.lc = new ArrayList<>(); // Initialistion de la Liste
    }

    public int getTaille() {
        return this.lc.size(); // retourne le nombre de carte
    }

    public CarteLoto getCarte(int i) { // retourne une carte à patir de son indice dans la liste
        return this.lc.get(i);
    }

    public void ajoute(CarteLoto c) { // ajoute une carte à la liste
        this.lc.add(c);

    }

    public void RetireCarte(CarteLoto C) { // retir une carte de la liste
        for (int i = 0; i < getTaille(); i++) {
            if (getCarte(i).equals(C))
                this.lc.remove(i);
        }
    }

    public void RetireCartes() { // vide la liste des Cartes
        this.lc.clear();
    }

    public ArrayList<CarteLoto> getLst() {
        return this.lc;
    }

}
