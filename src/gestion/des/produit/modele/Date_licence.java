/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.des.produit.modele;

/**
 *
 * @author ziram
 */
public class Date_licence {
    int etat ; 
    String date_start ;
    String date_point ;
    String date_end ;
    
    public Date_licence(int etat, String date_start, String date_point ,  String date_end ) {
        this.etat = etat;
        this.date_start = date_start;
        this.date_point = date_point;
        this.date_end = date_end;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public String getDate_point() {
        return date_point;
    }

    public void setDate_point(String date_point) {
        this.date_point = date_point;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }
    
    
}
