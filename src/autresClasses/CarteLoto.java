package autresClasses;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Abider
 */
public class CarteLoto {
    // déclaration des attributs de la classe
    private int tab[][]; // tableau à deux dimensions contenant les numéros d'une carte
    private int jetons[][]; // tableau à deux dimensions contenant les jetons d'un joueur
    private int nbCol; // nombre colonne de la carte
    private int nbLig; // nombre de ligne de la cartes
    private int nbNumeros; // nombre de numéros de la cartes
    private double prix; // prix de la cartes
    private final int valMax = 90; // le nombre maximal de valeur autorisé

    // constructeur par defaut d'une carte
    public CarteLoto() {
        this.nbNumeros = 15; // nombre de numéro par defaut
        this.nbCol = 9; // nombre de Colonne par defaut
        this.nbLig = 3; // nombre de ligne par defaut
        this.tab = new int[nbLig][nbCol]; // initialisation de la carte
        this.jetons = new int[nbLig][nbCol]; // initialisation des jeton du joueur
        this.prix = 5; // prix par defaut d'une carte
        initValeursCarte(); // appel de la méthode qui initialise des valeur de la cartes
    }

    // constructeur avec parametre
    public CarteLoto(int nbc, int nbVal) {
        this.nbNumeros = nbVal; // affectation du nombre de numéros
        this.nbCol = nbc; // affectation de nombre de colonne
        this.nbLig = 3;
        this.tab = new int[nbLig][nbCol];
        this.jetons = new int[nbLig][nbCol];
        this.prix = 5;
        initValeursCarte();
    }

    // accesseurs
    public double getPrix() {
        return this.prix;
    }

    public int[][] getTab() {
        return tab;
    }

    public void setTab(int[][] tab) {
        this.tab = tab;
    }

    public int[][] getJetons() {
        return this.jetons;
    }

    public void ajoutJeton(int num) {
        for (int i = 0; i < this.nbLig; i++)
            for (int j = 0; j < this.nbCol; j++)
                if (tab[i][j] == num)
                    jetons[i][j] = num;
    }

    public int getNbCol() {
        return nbCol;
    }

    public void setNbCol(int nbCol) {
        this.nbCol = nbCol;
    }

    public int getNbLig() {
        return nbLig;
    }

    public void setNbLig(int nbLig) {
        this.nbLig = nbLig;
    }

    public int getNbNumeros() {
        return nbNumeros;
    }

    public void setNbNumeros(int nbNumeros) {
        if (nbNumeros >= 3 && nbNumeros <= tab.length) { // affect un nombre de numéro supérieur à 3 det inférieur à la
                                                         // taille du de la carte de LOTO
            this.nbNumeros = nbNumeros;
        }
    }

    // metthode toString pour afficher les information d'une carte de loto
    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < this.nbLig; i++) {
            for (int j = 0; j < this.nbCol; j++)
                if (tab[i][j] < 10)
                    res += " " + tab[i][j] + " ";
                else
                    res += " " + tab[i][j];
            res += "\n";
        }
        return res;
    }

    // déclaration de la méthode d'initialisation des valeur de la carte de loto
    public void initValeursCarte() {
        int val, j, i;
        for (i = 0; i < this.nbLig; i++)
            for (j = 0; j < this.nbCol; j++) {
                // initialisation des deux tableaux à 0
                tab[i][j] = 0;
                jetons[i][j] = 0;
            }

        i = 0;// variable qui parcour les ligne
        // affection de (nbNumeros) aléatoir de numéro au tableau sachant qu'il n'y est
        // pas encore
        for (int k = 0; k < this.nbNumeros; k++) {
            do {
                val = (int) (Math.random() * (this.valMax) + 1);

            } while (estDans(val));
            do {
                j = (int) (Math.random() * this.nbCol); // affection aléatoir de la variable qui parcour des colonne
            } while (tab[i][j] != 0); // on change d'indice le colonne tend que la case n'est pas vide (0)
            tab[i][j] = val;
            i = (i + 1) % this.nbLig; // incrementation de la variable d'indice de ligne qui ne dépasse jamais le
                                      // nombre le ligne du tableau (revient à 0 )

        }
    }

    // méthode retournant true si un numéro est déjà sur la carte
    public boolean estDans(int val) {
        boolean res = false;
        for (int i = 0; i < this.nbLig; i++)
            for (int j = 0; j < this.nbCol; j++)
                if (tab[i][j] == val)
                    res = true;
        return res;
    }

    public void dessineCarte(JPanel jp, Color coul) {

        jp.removeAll();
        jp.setLayout(new GridLayout(this.nbLig, this.nbCol));
        for (int i = 0; i < this.nbLig; i++) {
            for (int j = 0; j < this.nbCol; j++) {
                JButton bt = new JButton();
                if (this.tab[i][j] != 0) {
                    bt.setText(this.tab[i][j] + "");
                    if (jetons[i][j] == 0)
                        bt.setBackground(coul);
                    else
                        bt.setBackground(Color.white);
                    jp.add(bt);
                } else {
                    bt.setText("");
                    if (jetons[i][j] == 0)
                        bt.setBackground(coul);
                    else
                        bt.setBackground(Color.white);
                    jp.add(bt);
                }

            }
        }
    }

    public static LesJoueurs cartonGagnant(int opt, LesJoueurs lesj) {
        LesJoueurs lesJG = new LesJoueurs();
        int nbreLine = 0;
        boolean egaux = true;
        switch (opt) {
            case 1:
                for (Joueur j : lesj.getLst()) { // parcour de la liste des joueurs
                    for (CarteLoto c : j.getMesCartes().getLst()) { // parcours de la liste des carte du joueur courant
                        for (int i = 0; i < 3; i++) {// on boucle sur trois ligne
                            for (int k = 0; k < c.getNbCol(); k++) {// on boucle sur la colonne de chaque ligne
                                // le tableau n'est pas vide et sa valeur n'est pas egale à celle du jeton au
                                // même indice
                                if (c.getTab()[i][k] != 0 && (c.getTab()[i][k] != c.getJetons()[i][k])) // si la
                                                                                                        // premiere ou
                                                                                                        // la deuxieme
                                                                                                        // ou la
                                                                                                        // troisieme
                                                                                                        // ligne du
                                                                                                        // jeton ne
                                                                                                        // correspond
                                                                                                        // celle de la
                                                                                                        // carte
                                    egaux = false;
                            }
                            if (egaux)
                                nbreLine++;

                            egaux = true;// on réinitialise car lors qu'un boucle egaux peux valoir false mais c'est pas
                                         // forcement le cas pour pour toute les line ei qu'il peut existé une autre
                                         // ligne qui ne modifie pas la valeur de égaux et cette ligne nous intéresse
                        }
                        if (nbreLine >= 1)// si une seul ligne vaus egale le joueur est gagnant
                            lesJG.ajoute(j); // le joueur est gagnant
                        nbreLine = 0;// on remet à O le compteur quand on fini de parcourir une carte
                    }
                }
                ;

                break;
            case 2:
                for (Joueur j : lesj.getLst()) { // parcour de la liste des joueurs
                    for (CarteLoto c : j.getMesCartes().getLst()) { // parcours de la liste des carte du joueur courant
                        for (int i = 0; i < 3; i++) {// on boucle sur trois ligne
                            for (int k = 0; k < c.getNbCol(); k++) {// on boucle sur la colonne de chaque ligne
                                // le tableau n'est pas vide et sa valeur n'est pas egale à celle du jeton au
                                // même indice
                                if (c.getTab()[i][k] != 0 && (c.getTab()[i][k] != c.getJetons()[i][k])) // si la
                                                                                                        // premiere ou
                                                                                                        // la deuxieme
                                                                                                        // ou la
                                                                                                        // troisieme
                                                                                                        // ligne du
                                                                                                        // jeton ne
                                                                                                        // correspond
                                                                                                        // celle de la
                                                                                                        // carte
                                    egaux = false;
                            }
                            if (egaux)
                                nbreLine++;

                            egaux = true;// on réinitialise car lors qu'un boucle egaux peux valoir false mais c'est pas
                                         // forcement le cas pour pour toute les line ei qu'il peut existé une autre
                                         // ligne qui ne modifie pas la valeur de égaux et cette ligne nous intéresse
                        }
                        if (nbreLine >= 2)// si au moin deux lignes valles egale le joueur est gagnant
                            lesJG.ajoute(j); // le joueur est gagnant
                        nbreLine = 0;
                    }
                }
                ;
                break;
            case 3:
                for (Joueur j : lesj.getLst()) { // parcour de la liste des joueurs
                    for (CarteLoto c : j.getMesCartes().getLst()) { // parcours de la liste des carte du joueur courant
                        for (int i = 0; i < 3; i++) {// on boucle sur trois ligne
                            for (int k = 0; k < c.getNbCol(); k++) {// on boucle sur la colonne de chaque ligne
                                // le tableau n'est pas vide et sa valeur n'est pas egale à celle du jeton au
                                // même indice
                                if (c.getTab()[i][k] != 0 && (c.getTab()[i][k] != c.getJetons()[i][k])) // si la
                                                                                                        // premiere ou
                                                                                                        // la deuxieme
                                                                                                        // ou la
                                                                                                        // troisieme
                                                                                                        // ligne du
                                                                                                        // jeton ne
                                                                                                        // correspond
                                                                                                        // celle de la
                                                                                                        // carte
                                    egaux = false;
                            }
                            if (egaux)
                                nbreLine++;

                            egaux = true;// on réinitialise car lors qu'un boucle egaux peux valoir false mais c'est pas
                                         // forcement le cas pour pour toute les line ei qu'il peut existé une autre
                                         // ligne qui ne modifie pas la valeur de égaux et cette ligne nous intéresse
                        }
                        if (nbreLine == 3)// si les 3 line donnent egale le joueur est gagnant
                            lesJG.ajoute(j); // le joueur est gagnant
                        nbreLine = 0;
                    }
                }
                ;
        }
        return lesJG;
    }
}