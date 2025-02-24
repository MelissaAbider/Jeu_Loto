
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package dialogsOption;

import autresClasses.BoutonImage;
import autresClasses.Joueur;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;

/**
 *
 * @author Abider
 */
public class SaisieJoueurDlg extends javax.swing.JDialog {
    // déclaration des attributs
    private Joueur nj; // contient le joueur saisie
    private boolean ok; // témoin de fermeture
    private BoutonImage btImg;
    private ImageIcon photo;

    public ImageIcon getPhoto() {
        return photo;
    }

    /**
     * Creates new form SaisieJoueurDlg
     */
    public SaisieJoueurDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal); // appel du constructeur de la classe JDialog
        initComponents(); // initialisation de l'interface graphique au démarrage
        this.nj = new Joueur(); // initialisation du joueur avec le constructeur par defaut
        this.ok = false; // initialisation du témoin de à false
        this.btImg = new BoutonImage();
        this.BPhoto.add(btImg);
        this.photo = new ImageIcon(getClass().getResource("/Images/joueurDefaut.png"));
    }

    // accesseurs
    public Joueur getJoueur() {
        return this.nj;
    }

    public boolean getOk() {
        return this.ok;
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

        north = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        center = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Pseudo = new javax.swing.JTextField();
        Solde = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        Bchoisir = new javax.swing.JButton();
        PanCouleur = new javax.swing.JPanel();
        parcourir = new javax.swing.JButton();
        BPhoto = new javax.swing.JPanel();
        south = new javax.swing.JPanel();
        BAnnuler = new javax.swing.JButton();
        BValider = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Ajout d'un nouveau joueur");
        north.add(jLabel1);

        getContentPane().add(north, java.awt.BorderLayout.NORTH);

        center.setLayout(new java.awt.GridLayout(1, 2));

        jPanel1.setLayout(new java.awt.GridLayout(4, 1));

        jLabel2.setText("Pseudo?");
        jPanel1.add(jLabel2);

        jLabel3.setText("Solde?");
        jPanel1.add(jLabel3);

        jLabel4.setText("Couleur préférée?");
        jPanel1.add(jLabel4);

        jLabel5.setText("Photo?");
        jPanel1.add(jLabel5);

        center.add(jPanel1);

        jPanel2.setLayout(new java.awt.GridLayout(2, 1));

        jPanel3.setLayout(new java.awt.GridLayout(2, 1));
        jPanel3.add(Pseudo);
        jPanel3.add(Solde);

        jPanel2.add(jPanel3);

        jPanel4.setLayout(new java.awt.GridLayout(2, 2));

        Bchoisir.setText("Choisir!");
        Bchoisir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BchoisirActionPerformed(evt);
            }
        });
        jPanel4.add(Bchoisir);

        javax.swing.GroupLayout PanCouleurLayout = new javax.swing.GroupLayout(PanCouleur);
        PanCouleur.setLayout(PanCouleurLayout);
        PanCouleurLayout.setHorizontalGroup(
                PanCouleurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 210, Short.MAX_VALUE));
        PanCouleurLayout.setVerticalGroup(
                PanCouleurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 125, Short.MAX_VALUE));

        jPanel4.add(PanCouleur);

        parcourir.setText("parcourir");
        parcourir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parcourirActionPerformed(evt);
            }
        });
        jPanel4.add(parcourir);

        BPhoto.setLayout(new java.awt.GridLayout(1, 1));
        jPanel4.add(BPhoto);

        jPanel2.add(jPanel4);

        center.add(jPanel2);

        getContentPane().add(center, java.awt.BorderLayout.CENTER);

        south.setLayout(new java.awt.GridLayout(1, 2));

        BAnnuler.setText("Annuler");
        BAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAnnulerActionPerformed(evt);
            }
        });
        south.add(BAnnuler);

        BValider.setText("Valider");
        BValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BValiderActionPerformed(evt);
            }
        });
        south.add(BValider);

        getContentPane().add(south, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void parcourirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_parcourirActionPerformed
        // TODO add your handling code here:
        JFileChooser diag = new JFileChooser();
        if (diag.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            String nfc = diag.getSelectedFile().getPath();
            Image im = Toolkit.getDefaultToolkit().getImage(nfc);
            this.photo = new ImageIcon(im);// conversion et affectation de l'image
            this.btImg.setImg(im); // BPhoto est un Jpanel qui contiendra le bouton
        }
    }// GEN-LAST:event_parcourirActionPerformed

    private void BValiderActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BValiderActionPerformed

        // TODO add your handling code here:
        boolean err = false; // déclaration d'une variable contenant true ou false selon si le bon solde est
                             // saisi
        String ps = Pseudo.getText(); // récupération du pseudo
        String so = Solde.getText(); // récupération du solde

        // gestion de d'erreur pour la convertion du solde de String à double
        try {
            double s = Double.parseDouble(so);
        } catch (Exception e) {
            err = true;
        }

        if (ps.equals("") || err == true) { // gestion d'erreur si le pseudo n'est pas saisi ou le solde mal saisie ou
                                            // non saisi
            if (ps.equals("")) {
                this.Pseudo.setText("!!!veillez saisir un pseudo!!!");
                Pseudo.setForeground(Color.red);
            }
            if (err == true) {
                this.Solde.setText("!!!veillez saisir le bon solde!!! ");
                Solde.setForeground(Color.red);
            }

        } else {

            double s = Double.parseDouble(so);// conversion du String en double du solde
            this.nj.setPseudo(ps); // affectation du pseudo récupéré au joueur
            this.nj.setSolde(s); // affectation du solde récupéré au joueur
            this.ok = true;
            // fermeture de la boite
            this.setVisible(false);
            // this.dispose();
        }

    }// GEN-LAST:event_BValiderActionPerformed

    private void BchoisirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BchoisirActionPerformed

        // TODO add your handling code here:
        JColorChooser diag = new JColorChooser(); // déclaration de la boite de choix de couleur
        Color coul = diag.showDialog(this, "Couleu", Color.red); // affichage de la boite avec "couleur" comme tire et
                                                                 // "rouge" comme couleur par defaut
        if (coul != null) { // si un couleur es choisie
            this.nj.setCouleur(coul); // affection de la couleur au joueur
            PanCouleur.setBackground(coul); // affichage de la couleur dans le panneau
        }
    }// GEN-LAST:event_BchoisirActionPerformed

    private void BAnnulerActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BAnnulerActionPerformed
        // TODO add your handling code here:
        // mis à false du témoin de fermeture et fermeture de la boite de dialogue
        this.ok = false;
        this.setVisible(false);
        // this.dispose();
    }// GEN-LAST:event_BAnnulerActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAnnuler;
    private javax.swing.JPanel BPhoto;
    private javax.swing.JButton BValider;
    private javax.swing.JButton Bchoisir;
    private javax.swing.JPanel PanCouleur;
    private javax.swing.JTextField Pseudo;
    private javax.swing.JTextField Solde;
    private javax.swing.JPanel center;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel north;
    private javax.swing.JButton parcourir;
    private javax.swing.JPanel south;
    // End of variables declaration//GEN-END:variables
}
