package autresClasses;

import java.awt.*;
import javax.swing.*;

 

public class Joueur {
     // déclaration des attribut d'un joueur 
 private String pseudo;
 private Color couleur;
 private double solde;
 private ImageIcon photo;
 private LesCartes mesC;
 
 // accesseurs en lecture 
 public String getPseudo() { return this.pseudo; }
 public Color getCouleur() { return this.couleur; }
 public double getSolde() { return this.solde; }
 public ImageIcon getPhoto() { return this.photo;}
 public LesCartes getMesCartes(){return this.mesC;}
 
 // accesseurs en ecriture
 public void setMesC(LesCartes mesC) { this.mesC = mesC;}
 public void setPseudo(String p) { this.pseudo=p; }
 public void setCouleur(Color c) { this.couleur = c; }
 public void setPhoto(ImageIcon p) { this.photo = p; }
 public void setSolde(double s) { this.solde = s; }

 //constructeur par defaut d'un joueur
 public Joueur() {
 this.pseudo = ""; 
 this.couleur=Color.gray;
 this.solde = 20;
 this.photo = new ImageIcon(getClass().getResource("../Images/joueurDefaut.png"));  // affectation de la photo par defaut contenu dans le sous-repertoir Images du repertoire src
 this.mesC= new LesCartes(); // initialisation  des cartes par defaut 
 }

 // constructeur avec parametre du joueur  qui prend en parametre le pseudo 
 public Joueur(String p) {
 this.pseudo = p;
 this.couleur=Color.gray;
 this.solde = 20;
 this.photo = new ImageIcon(getClass().getResource("../Images/joueurDefaut.png"));
  this.mesC= new LesCartes();
 }

 // méthode toString pour afficher les inforpations sur le joueur 
 public String toString() {
 String res= "\nJoueur " + this.pseudo;
 res+= "\nCouleur " + this.couleur;
 res+= "\nSolde " + this.solde;
 res+="\n Nombre de Carte "+this.mesC.getTaille();
 return res;
 }

}