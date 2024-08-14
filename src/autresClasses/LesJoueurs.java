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
public class LesJoueurs {
    private ArrayList<Joueur> Lst; // déclaration d'un arrayList de Joeurs

    public LesJoueurs() {
        this.Lst = new ArrayList<>(); // Initialisation de la list
    }

    // accesseur
    public ArrayList<Joueur> getLst() {
        return this.Lst;
    }

    public int getTaille() {
        return this.Lst.size(); // retourne le nombre de joueur
    }

    public Joueur getJoueur(int i) { // retourne un joueur à partir de son son indice dans la liste
        return this.Lst.get(i);
    }

    public void ajoute(Joueur j) { // ajoute un joueur à la liste
        this.Lst.add(j);
    }
}
