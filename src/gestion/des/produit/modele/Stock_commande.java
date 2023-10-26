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
public class Stock_commande {
   int id ;
   String devise ;
   float gain ;
   float vent ; 
   float achat ; 
   double qnt ;

    public Stock_commande( float gain, float vent, float achat, double qnt) {
        
        this.gain = gain;
        this.vent = vent;
        this.achat = achat;
        this.qnt = qnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public float getGain() {
        return gain;
    }

    public void setGain(float gain) {
        this.gain = gain;
    }

    public float getVent() {
        return vent;
    }

    public void setVent(float vent) {
        this.vent = vent;
    }

    public float getAchat() {
        return achat;
    }

    public void setAchat(float achat) {
        this.achat = achat;
    }

    public double getQnt() {
        return qnt;
    }

    public void setQnt(double qnt) {
        this.qnt = qnt;
    }
   
    
}
