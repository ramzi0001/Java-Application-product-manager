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
public class Bashoard {
    
   public int N_commande;
   public String nom_prenom_client;
   public String wilaya;
   public int jours ;	
   public double prix_devise ;	 
   public double budge ;
   public float gain ;
   public String date_start;
   public String date_insert;
   public String date_versment;
   public String deadline;
   public String note;
   public String tele;
   public String page_facebook;
   public String profile_facebook;
   public String etat_vercement;
   public String etat_commande;
   public String sex;
   public String but;
   public String age;

    public Bashoard(int N_commande, String nom_prenom_client, int jours, double prix_devise, double budge, String date_insert, String etat_commande , float gain) {
        this.N_commande = N_commande;
        this.nom_prenom_client = nom_prenom_client;
        this.jours = jours;
        this.prix_devise = prix_devise;
        this.budge = budge;
        this.date_insert = date_insert;
        this.etat_commande = etat_commande;
        this.gain = gain ;
    }
   
   
   
   public Bashoard(String nom_prenom_client, String wilaya, int jours ,double prix_devise ,double budge ,String date_insert, String date_versment,
                       String note, String tele,  String page_facebook, String profile_facebook , String etat_vercement,  String etat_commande, String sex, String but, String age , float gain
                     ){
  
   this.nom_prenom_client = nom_prenom_client;
   this.wilaya = wilaya;
   this.jours = jours;	
   this.prix_devise = prix_devise;	 
   this.budge = budge;
   this.date_insert = date_insert;
   this.date_versment = date_versment;
   this.note = note;
   this.tele = tele;
   this.page_facebook = page_facebook;
   this.profile_facebook = profile_facebook;
   this.etat_vercement = etat_vercement;
   this.etat_commande = etat_commande;
   this.sex = sex;
   this.but = but;
   this.age = age;
   this.gain = gain ;

    
    
    }

      
   public Bashoard(String nom_prenom_client, String wilaya, int jours ,double prix_devise ,double budge ,String date_insert, String date_versment,
                       String note, String tele,  String page_facebook, String profile_facebook , String etat_vercement,  String etat_commande, String sex, String but, String age,
                       String deadline , String date_start){
  
   this.nom_prenom_client = nom_prenom_client;
   this.wilaya = wilaya;
   this.jours = jours;	
   this.prix_devise = prix_devise;	 
   this.budge = budge;
   this.date_insert = date_insert;
   this.date_versment = date_versment;
   this.note = note;
   this.tele = tele;
   this.page_facebook = page_facebook;
   this.profile_facebook = profile_facebook;
   this.etat_vercement = etat_vercement;
   this.etat_commande = etat_commande;
   this.sex = sex;
   this.but = but;
   this.age = age;
   this.deadline= deadline ;
   this.date_start = date_start ;
    
    
    }

    public float getGain() {
        return gain;
    }

    public void setGain(float gain) {
        this.gain = gain;
    }
   
    public int getN_commande() {
        return N_commande;
    }

    public void setN_commande(int N_commande) {
        this.N_commande = N_commande;
    }

    public String getNom_prenom_client() {
        return nom_prenom_client;
    }

    public void setNom_prenom_client(String nom_prenom_client) {
        this.nom_prenom_client = nom_prenom_client;
    }

    public String getWilaya() {
        return wilaya;
    }

    public void setWilaya(String wilaya) {
        this.wilaya = wilaya;
    }

    public int getJours() {
        return jours;
    }

    public void setJours(int jours) {
        this.jours = jours;
    }

    public double getPrix_devise() {
        return prix_devise;
    }

    public void setPrix_devise(double prix_devise) {
        this.prix_devise = prix_devise;
    }

    public double getBudge() {
        return budge;
    }

    public void setBudge(double budge) {
        this.budge = budge;
    }

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }
    
    public String getDate_insert() {
        return date_insert;
    }

    public void setDate_insert(String date_insert) {
        this.date_insert = date_insert;
    }
    
    public String getDate_versment() {
        return date_versment;
    }

    public void setDate_versment(String date_versment) {
        this.date_versment = date_versment;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getPage_facebook() {
        return page_facebook;
    }

    public void setPage_facebook(String page_facebook) {
        this.page_facebook = page_facebook;
    }

    public String getProfile_facebook() {
        return profile_facebook;
    }

    public void setProfile_facebook(String profile_facebook) {
        this.profile_facebook = profile_facebook;
    }

    public String getEtat_vercement() {
        return etat_vercement;
    }

    public void setEtat_vercement(String etat_vercement) {
        this.etat_vercement = etat_vercement;
    }

    public String getEtat_commande() {
        return etat_commande;
    }

    public void setEtat_commande(String etat_commande) {
        this.etat_commande = etat_commande;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBut() {
        return but;
    }

    public void setBut(String but) {
        this.but = but;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    
    
}
