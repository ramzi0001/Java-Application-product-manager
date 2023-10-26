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
public class User {
   private String nom_prenom_user;
   private int grad = 0 ;
   private String password;
    public User(){}
    public User(String nom_prenom_user, int grad, String password) {
        this.nom_prenom_user = nom_prenom_user;
        this.grad = grad;
        this.password = password;
    
}
    public String getnom_prenom_user(){return nom_prenom_user;}
    public int getgrad(){return grad;}
    public String getpassword(){return password;}
    public void setnom_prenom_user(String nom_prenom_user){this.nom_prenom_user = nom_prenom_user;}
    public void setgrad(int grad){this.grad = grad;}
    public void setpassword(String password){this.password = password;}


    
}
