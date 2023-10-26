package gestion.des.produit;

import java.awt.*;

/**
 * Decrivez votre classe codeBarre ici.
 * 
 * @author (votre nom) 
 * @version (un numero de version ou une date)
 */
public class CodeBarre
{
    // variables d'instance - remplacez l'exemple qui suit par le votre
    private String entree, sortie;
    private int longueur;
    private int bordX, bordH, hauteur, largeur;
    
    private String[][] T = {{"0001101","0100111","1110010","AAAAAA"},
                        {"0011001","0110011","1100110","AABABB"},
                        {"0010011","0011011","1101100","AABBAB"},
                        {"0111101","0100001","1000010","AABBBA"},
                        {"0100011","0011101","1011100","ABAABB"},
                        {"0110001","0111001","1001110","ABBAAB"},
                        {"0101111","0000101","1010000","ABBBAA"},
                        {"0111011","0010001","1000100","ABABAB"},
                        {"0110111","0001001","1001000","ABABBA"},
                        {"0001011","0010111","1110100","ABBABA"}};

    /**
     * Constructeur d"objets de classe codeBarre
     */
    public CodeBarre()
    {
        // initialisation des variables d"instance
        // entree = "9780130515186";
        entree = "9780130515186";
        bordX = 20;
        bordH = 20;
        largeur = 2;
        hauteur = 80;
        initialiser();
    }
    
    public CodeBarre(String en)
    {
        // initialisation des variables d"instance
        entree = en;
        bordX = 20;
        bordH = 20;
        largeur = 2;
        hauteur = 80;
        initialiser();
    }
    
    public CodeBarre(String en, int bx, int bh, int ha, int la)
    {
        // initialisation des variables d"instance
        entree = en;
        bordX = bx;
        bordH = bh;
        hauteur = ha;
        largeur = la;
        initialiser();
    }
    
    public void initialiser()
    {
        longueur = entree.length();
        sortie = convertir(entree);
    }
    
    public void modifie(String nouvNb)
    {
        entree = nouvNb;
        initialiser();
    }
    
    public boolean verifier(String en)
    {
        return true;
    }
     
    public String convertir(String en)
    {
        String codeDebut = "101";
        String codeMilieu = "01010";
        String codeFin = "101";
        String codeGauche ="";
        String codeDroite = "";
        String chiffre1, chiffre;
        int noChiffre1, noChiffre;
        String chiffre13;
        
        // chiffre 1 = cle
        chiffre1 = en.substring(0,1);
        noChiffre1 = Integer.parseInt(chiffre1);
        
        // 13e chiffre
        chiffre13 = T[noChiffre1][3];
        
        // partie gauche
        for (int no = 1; no < 7; no++)
        {
            chiffre = en.substring(no,no+1);
            noChiffre = Integer.parseInt(chiffre);
            if (chiffre13.substring(no-1,no).equals("A"))
            {
                codeGauche = codeGauche + T[noChiffre][0];
            }
            else 
            {
                codeGauche = codeGauche + T[noChiffre][1];
            }
        }
        
        // partie droite
        for (int no = 7; no < 13; no++)
        {
            chiffre = en.substring(no,no+1);
            noChiffre = Integer.parseInt(chiffre);
            codeDroite = codeDroite + T[noChiffre][2];
        }
         
        // fabrication du code de 95 bits
        return codeDebut + codeGauche + codeMilieu + codeDroite + codeFin;
    }
    
    public void dessine(Graphics g)
    {
        g.setColor(Color.BLACK);
        for (int i=0; i< 95; i++)
        {
            if (sortie.substring(i,i+1).equals("1"))
            {
                if (i<3 || (i>44 && i<50) || i>91) {
                    g.fillRect(bordX+i*largeur,bordH,largeur,hauteur);
                }
                else
                {
                    g.fillRect(bordX+i*largeur,bordH,largeur,hauteur-hauteur/10);
                }
            }
        }
        g.drawString(entree.substring(0,1),bordX/2,bordH+hauteur+hauteur/20);
        for (int i=1; i<7; i++)
        {
            g.drawString(entree.substring(i,i+1),2*bordX/3+7*i*largeur,bordH+hauteur+hauteur/20);
        }
        for (int i=7; i<13; i++)
        {
            g.drawString(entree.substring(i,i+1),4*bordX/3+7*i*largeur,bordH+hauteur+hauteur/20);
        }
                
    }

    
}

