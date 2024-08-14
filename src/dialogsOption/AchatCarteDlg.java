/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package dialogsOption;

import autresClasses.CarteLoto;
import autresClasses.Joueur;
import autresClasses.LesJoueurs;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Abider
 */
public class AchatCarteDlg extends javax.swing.JDialog {

    private LesJoueurs ljc;
    private int nbCol, nbLig, nbNum;
    private Joueur jc;
    private CarteLoto cc;
    private boolean achat;
    private int nbCarte;

    /**
     * Creates new form AchatCarteDlg
     */
    public AchatCarteDlg(java.awt.Frame parent, boolean modal, LesJoueurs lj, int nl, int nc, int nn) {
        super(parent, modal);
        initComponents();
        this.jc = new Joueur();
        CarteLoto cl = new CarteLoto(nc, nn); // nc et nn redefini ou la valeur par defaut du constructeur de la Frame
        this.nbCol = nc;
        this.nbLig = nl;
        this.nbNum = nn;
        this.ljc = lj;
        this.achat = false;
        this.jc = lj.getJoueur(0);
        this.cc = new CarteLoto(this.nbCol, nbNum);
        this.cc.setNbLig(this.nbLig);
        System.out.println(cc.getNbNumeros());
        remplirListeJoueurs();
        affMessage(); // affiche par defaut les infos du premier joueur dans la combo
        initCarte(); // génération automatique de carte au démarrage
        afficheCarte();
    }

    public Joueur getJc() {
        return this.jc;
    }

    public boolean getAchat() {
        for (Joueur j : ljc.getLst())
            if (j.getMesCartes().getTaille() >= 1)
                return true;
        return false;
    }

    private void affMessage() {
        String ps = this.ListeJoueurs.getSelectedItem().toString();
        for (Joueur j : ljc.getLst()) {
            if (j.getPseudo().equals(ps))
                this.Message.setText(ps + " dispose de " + j.getSolde() + "€");
        }
    }

    private void initCarte() {
        int nc = this.cc.getNbCol(); // récupération du nombre de colonne de la carte
        int nl = this.cc.getNbLig(); // récupération du nombre de ligne de la carte
        Panneau.setLayout(new GridLayout(nl, nc));
        for (int i = 0; i < this.nbLig * this.nbCol; i++) {
            JButton bt = new JButton(); // creation d'un bouton
            bt.setText("");
            Panneau.add(bt);
        }

    }

    private void afficheCarte() {
        int[][] tab = this.cc.getTab(); // recupération du tableau des numéroro de la carte
        for (int i = 0; i < this.nbLig; i++) {
            for (int j = 0; j < this.nbCol; j++) {
                JButton bt = (JButton) Panneau.getComponent(i * this.nbCol + j);
                if (tab[i][j] == 0)
                    bt.setText(""); // on écrit rien sur le bouton si le numéro vaut 0
                else
                    bt.setText("" + tab[i][j]); // affichage du numéro de case sur le bouton à la i-eme position

            }
        }
    }

    public boolean isAcheter() {
        return achat;
    }

    public CarteLoto getCl() {
        return cc;
    }

    private void remplirListeJoueurs() {
        for (Joueur j : ljc.getLst()) {
            ListeJoueurs.addItem(j.getPseudo()); // remplissage de la combo avec la liste des joueur disponible dans la
                                                 // Frame laquelle liste est fourni en paramètre du constructeur de la
                                                 // jDialog
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Panneau = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        Message = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        ListeJoueurs = new javax.swing.JComboBox<>();
        BAutreChoix = new javax.swing.JButton();
        BAcheter = new javax.swing.JButton();
        BQuitter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Acheter une ou plusieurs cartes");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout PanneauLayout = new javax.swing.GroupLayout(Panneau);
        Panneau.setLayout(PanneauLayout);
        PanneauLayout.setHorizontalGroup(
                PanneauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 408, Short.MAX_VALUE));
        PanneauLayout.setVerticalGroup(
                PanneauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 216, Short.MAX_VALUE));

        getContentPane().add(Panneau, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(2, 1));

        Message.setText("jLabel2");
        jPanel4.add(Message);

        jPanel3.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(1, 4));

        ListeJoueurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListeJoueursActionPerformed(evt);
            }
        });
        jPanel5.add(ListeJoueurs);

        BAutreChoix.setText("Autre choix");
        BAutreChoix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAutreChoixActionPerformed(evt);
            }
        });
        jPanel5.add(BAutreChoix);

        BAcheter.setText("Acheter");
        BAcheter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAcheterActionPerformed(evt);
            }
        });
        jPanel5.add(BAcheter);

        BQuitter.setText("Quitter");
        BQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BQuitterActionPerformed(evt);
            }
        });
        jPanel5.add(BQuitter);

        jPanel3.add(jPanel5);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BAutreChoixActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BAutreChoixActionPerformed
        // TODO add your handling code here:
        this.cc = new CarteLoto(this.nbCol, nbNum);
        cc.initValeursCarte(); // rappel de la méthode qui rempli les numéro de la carte aléatoirement
        int[][] tab = cc.getTab(); // recupération du tableau des numéroro de la carte
        // on crée une nouvelle instance de carte sinon l'objet celle qui sera transmise
        // au joueur aura la même adresse mais ne se resent pas sur l'affichage car seul
        // les valeur to tableau importe alors que les joueur lui a besoin de deux
        // instance differente de carte
        // cc.setTab(tab);
        for (int i = 0; i < this.nbLig; i++) {
            for (int j = 0; j < this.nbCol; j++) {
                JButton bt = (JButton) Panneau.getComponent(i * this.nbCol + j);// recupéure un bouton
                if (tab[i][j] == 0)
                    bt.setText(""); // on écrit rien sur le bouton si le numéro vaut 0
                else
                    bt.setText("" + tab[i][j]); // affichage du numéro de case sur le bouton à la i-eme position

            }
        }
    }// GEN-LAST:event_BAutreChoixActionPerformed

    private void BQuitterActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BQuitterActionPerformed
        // String ps=this.ListeJoueurs.getSelectedItem().toString();
        this.dispose(); // TODO add your handling code here:
    }// GEN-LAST:event_BQuitterActionPerformed

    private void BAcheterActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BAcheterActionPerformed
        // TODO add your handling code here:
        for (Joueur j : this.ljc.getLst()) {
            if (j.getPseudo().equals(jc.getPseudo())) {
                if (j.getSolde() > this.cc.getPrix()) {
                    if (j.getMesCartes().getTaille() < 2) {
                        j.getMesCartes().ajoute(cc);
                        this.achat = true;
                        j.setSolde(j.getSolde() - this.cc.getPrix());
                        affMessage();
                    } else
                        this.Message.setText("vous disposez de deux cartes dejà");
                } else
                    System.out.println(
                            "vouz n'avez pas assez d'argent pour acheter la carte, elle coût" + cc.getPrix() + "€");

            }
        }
    }// GEN-LAST:event_BAcheterActionPerformed

    private void ListeJoueursActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_ListeJoueursActionPerformed
        // TODO add your handling code here:
        int ind = this.ListeJoueurs.getSelectedIndex();
        jc = ljc.getLst().get(ind);
        affMessage();
    }// GEN-LAST:event_ListeJoueursActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAcheter;
    private javax.swing.JButton BAutreChoix;
    private javax.swing.JButton BQuitter;
    private javax.swing.JComboBox<String> ListeJoueurs;
    private javax.swing.JLabel Message;
    private javax.swing.JPanel Panneau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
