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
public class ListeLot {
    private ArrayList<Lot> lstL;

    public ListeLot() {
        this.lstL = new ArrayList<Lot>();
    }

    public ListeLot(ArrayList<Lot> lstL) {
        this.lstL = lstL;
    }

    public ArrayList<Lot> getLstL() {
        return lstL;
    }

    public void setLstL(ArrayList<Lot> lstL) {
        this.lstL = lstL;
    }

    public void ajoute(Lot lot) {
        lstL.add(lot);
    }

    public void enleveLot(Lot l) {
        lstL.remove(l);
    }
}
