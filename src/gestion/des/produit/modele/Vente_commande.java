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
public class Vente_commande {
    int id ;
    float gain ;
    float CA ;
    float qnt ;
    String date ;
    String nom ;

    public Vente_commande(float gain, float CA, float qnt, String date, String nom , int id) {
        this.gain = gain;
        this.CA = CA;
        this.qnt = qnt;
        this.date = date;
        this.nom = nom;
        this.id = id ;
    }
  public Vente_commande(float gain, float CA, float qnt, String date, String nom ) {
        this.gain = gain;
        this.CA = CA;
        this.qnt = qnt;
        this.date = date;
        this.nom = nom;
     
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getGain() {
        return gain;
    }

    public void setGain(float gain) {
        this.gain = gain;
    }

    public float getCA() {
        return CA;
    }

    public void setCA(float CA) {
        this.CA = CA;
    }

    public float getQnt() {
        return qnt;
    }

    public void setQnt(float qnt) {
        this.qnt = qnt;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
}
