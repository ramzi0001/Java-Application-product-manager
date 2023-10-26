/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.des.produit.dao;

import gestion.des.produit.AES;
import gestion.des.produit.modele.Achat;
import gestion.des.produit.modele.Client;
import gestion.des.produit.modele.Facture;
import gestion.des.produit.modele.Fornisseur;
import gestion.des.produit.modele.Stock;
import gestion.des.produit.modele.Vente;
import gestion.des.produit.modele.User;
import gestion.des.produit.modele.Bashoard;
import gestion.des.produit.modele.Date_licence;
import gestion.des.produit.modele.Stock_commande;
import gestion.des.produit.modele.Vente_commande;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.sqlite.SQLite;


/**
 *
 * @author ziram
 */
public class ConnectDB {

    private String url = "jdbc:sqlite:gestion_de_produit.db";      
    private Connection cnx;
    private Statement st, jt;
    private ResultSet rst , ts;

    public void DeleteAllElementTab(JTable T, int column, int row) {
        int i = 0;
        int j = 0;
        while (i < row) {
            while (j <= column) {
                T.setValueAt("", i, j);
                j++;
            }
            j = 0;
            i++;
        }

    }

    public String showDate() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        return sdf.format(d);

    }

    public String showDateTime() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
        return sdf.format(d);

    }

    public void ConnexionIntoDataBase() {
        
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("Driver OK");
            try {
                cnx = DriverManager.getConnection(url); 
                
                st = cnx.createStatement();
                
                
                System.out.println("successful connexion");
            } catch (SQLException ex) {
                Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, " erreur connexion activer le serveur ou verifier "
                        + "\nle configuration de  serveur");

            } finally {
            }
       } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int FindUser(User user) {
        int re = 0;
        try {
            
            String sql = "select * from user where user = '" + user.getnom_prenom_user() + "'";
            rst = (ResultSet) st.executeQuery(sql);
            while (rst.next()) {

                if (rst.getString("user").equals(user.getnom_prenom_user()) && rst.getString("password").equals(user.getpassword())) {
                 
                    re = 1;
                    user.setgrad(rst.getInt("grad"));
                } else {
                 
                    re = 0;
                    
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }

        return re;
    }
    public int FindUsername(User user){
    
     int re = 0;
        try {
            
            String sql = "select * from user where user = '" + user.getnom_prenom_user() + "'";
            rst = (ResultSet) st.executeQuery(sql);
            while (rst.next()) {

                if (rst.getString("user").equals(user.getnom_prenom_user())) {
                 
                    re = 1;
                    
                } else {
                 
                    re = 0;
                    
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }

        return re;
    }
    
    
    
        public int FindGrad(User user){
    
     int re = 1;
        try {
            
            String sql = "select * from user where user = '" + user.getnom_prenom_user() + "'";
            rst = (ResultSet) st.executeQuery(sql);
            while (rst.next()) {

                if (rst.getString("user").equals(user.getnom_prenom_user())) {
                 
                    re = rst.getInt("grad");
                    
                } else {
                 
                    re = 1;
                    
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }

        return re;
    }
    
    
    
    
    
    
    public void AddUser(User user){
     try {
            
            String sql1 = "INSERT INTO `user`( `user`, `password`, `grad`) "
                    + "VALUES ('" + user.getnom_prenom_user() + "'," + "'" + user.getpassword() + "','" + user.getgrad() + "') ";
            st.executeUpdate(sql1);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ereur operation");
            
        }
    }

    public void UpdatUser(String s, String ss ,String sss) {

        try {
            String sql = "Update user set user='" + s + "',password='" + ss + "'"
                    + "where user= '" + sss + "'";

            
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertFornisseur(Fornisseur forn) {

        try {
            
            String sql1 = "INSERT INTO `fornisseur`( `nom_prenom`, `N_telephone`, `Adresse`,`Ville`) "
                    + "VALUES ('" + forn.nom_prenom + "'," + "'" + forn.telephone + "','" + forn.adresse + "','" + forn.ville + "') ";
            st.executeUpdate(sql1);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ereur operation");
            
        }

    }

    public void insertClient(Client cl) {
        try {
            
            String sql1 = "INSERT INTO `client`( `nom_prenom`, `N_telephone`, `Adresse`) "
                    + "VALUES ('" + cl.nom_prenom + "'," + "'" + cl.telephone + "','" + cl.adresse + "') ";
            st.executeUpdate(sql1);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ereur operation");
        }
    }

    public void AllFornisseur(JTable T) {
        try {
            
            String sql = "select * from fornisseur";
            rst = (ResultSet) st.executeQuery(sql);
            int i = 0, j;

            while (rst.next()) {
                j = 0;
                T.setValueAt(rst.getInt("N_forn"), i, j);
                j++;
                T.setValueAt(rst.getString("nom_prenom").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("N_telephone").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("Adresse").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("Ville").toString(), i, j);
                j++;
                i++;

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }

    public void AllClient(JTable T) {
        try {
            
            String sql = "select * from client";
            rst = (ResultSet) st.executeQuery(sql);
            int i = 0, j;
            while (rst.next()) {
                j = 0;
                T.setValueAt(rst.getInt("N_client"), i, j);
                j++;
                T.setValueAt(rst.getString("nom_prenom").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("N_telephone").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("Adresse").toString(), i, j);
                j++;

                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }

    public void DeleteForn(int id) {
        String sql = "DELETE FROM fornisseur WHERE N_forn=" + id;
        try {
            
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpdatForn(int id, Fornisseur fr) {

        try { 
            String sql = "Update fornisseur set nom_prenom='" + fr.nom_prenom + "',N_telephone='" + fr.telephone + "',"
                    + "Adresse='" + fr.adresse + "'" + ",Ville='" + fr.ville + "'"
                    + " where N_forn=" + id;
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void DeleteClient(int id) {
        String sql = "DELETE FROM client WHERE N_client=" + id;
        try {
            
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpdatClient(int id, Client cl) {

        try { 
            String sql = "Update client set  nom_prenom='" + cl.nom_prenom + "',N_telephone='" + cl.telephone + "',"
                    + "Adresse='" + cl.adresse + "'"
                    + "where N_client=" + id;
           
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void FindClient(JTable T, String word) {
        try {
            
            String sql = "SELECT * FROM `client` WHERE nom_prenom like '" + word + "%'  ";
            rst = (ResultSet) st.executeQuery(sql);
            int i = 0, j;
            while (rst.next()) {
                j = 0;
                T.setValueAt(rst.getInt("N_client"), i, j);
                j++;
                T.setValueAt(rst.getString("nom_prenom").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("N_telephone").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("Adresse").toString(), i, j);
                j++;

                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }

    public void FindFornisseur(JTable T, String word, String recherche) {
        try {
            
            String sql = "SELECT * FROM fornisseur WHERE " + word + " like '" + recherche + "%'  ";
            rst = (ResultSet) st.executeQuery(sql);
            int i = 0, j;
            while (rst.next()) {
                j = 0;
                T.setValueAt(rst.getInt("N_forn"), i, j);
                j++;
                T.setValueAt(rst.getString("nom_prenom").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("N_telephone").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("Adresse").toString(), i, j);
                j++;
                T.setValueAt(rst.getString("Ville").toString(), i, j);
                j++;
                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }

    public void FindNomPrenomFornis(JComboBox combo) {
        try {
            
            String sql = "select nom_prenom  from fornisseur";
            rst = (ResultSet) st.executeQuery(sql);
            ArrayList<String> ar = new ArrayList<>();
            ArrayList<String> rpl = new ArrayList<>();

            while (rst.next()) {

                ar.add(rst.getString("nom_prenom").toString());
            }
            rpl = Rplace(ar);
            for (int i = 0; i < rpl.size(); i++) {
                combo.addItem(rpl.get(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }

    }

    public float AllAchat(JTable T) {
        float f = 0;
        try {
            ArrayList<Achat> list = new ArrayList<Achat>();
            
            String sql = "select * from achat";
            rst = (ResultSet) st.executeQuery(sql);
            //int i=0,j;
            while (rst.next()) {
                f = rst.getFloat("prix_total") + f;

                Achat ach = new Achat(rst.getInt("N_achat"), rst.getString("nom_prenom_forn"), rst.getString("designation"), rst.getInt("quantite"),
                        rst.getFloat("prix_total"), rst.getFloat("prix_unitaire"),
                        rst.getString("date_achat"));
                list.add(ach);
            }

            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            mo.setRowCount(0);
            DecimalFormat df = new DecimalFormat("0.00");
            Object row[] = new Object[7];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getN_achat();
                row[1] = list.get(k).getNom_prenom_forn();
                row[2] = list.get(k).getDesignation();
                row[3] = list.get(k).getQuantité();
                row[4] = list.get(k).getPrix_total();
                row[5] = list.get(k).getPrix_unitaire();
                row[6] = list.get(k).getDate_achat();
                mo.addRow(row);
            }
            list.clear();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
        return f;
    }

    public void inserAchat(Achat ach) {
        try {
            
            String sql1 = "INSERT INTO `achat`( `nom_prenom_forn`, `designation`, `quantite`"
                    + ", `prix_total`, `prix_unitaire`, `date_achat`) "
                    + "VALUES ('" + ach.nom_prenom_forn + "'," + "'" + ach.designation + "','" + ach.quantité + "'"
                    + ",'" + ach.prix_total + "','" +  ach.prix_total / ach.quantité + "','" + ach.date_achat + "') ";
            st.executeUpdate(sql1);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ereur operation");
            
        }
    }

    public void UpdatAchat(int id, Achat ach) {

        try {
            String sql = "Update achat set nom_prenom_forn='" + ach.nom_prenom_forn + "',designation='" + ach.designation + "',"
                    + "quantite='" + ach.quantité + "'" + ",prix_total='" + ach.prix_total + "',"
                    + "prix_unitaire='" + ach.prix_total / ach.quantité + "'"
                    + "where N_achat=" + id;
            
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void DeleteAchat(int id) {
        String sql = "DELETE FROM achat WHERE N_achat=" + id;
        try {
            
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void FindAchat(JTable T, String word, String recherche, JLabel j1, JLabel j2) {
        int qte = 0;
        float prixT = 0;
        try {
            ArrayList<Achat> list = new ArrayList<Achat>();
            
            String sql = "SELECT * FROM achat WHERE " + word + " like '" + recherche + "%'  ";
            rst = (ResultSet) st.executeQuery(sql);

            while (rst.next()) {
                qte = qte + rst.getInt("quantite");

                prixT = prixT + rst.getFloat("prix_total");

                Achat ach = new Achat(rst.getInt("N_achat"), rst.getString("nom_prenom_forn"), rst.getString("designation"), rst.getInt("quantite"),
                        rst.getFloat("prix_total"), rst.getFloat("prix_unitaire"),
                        rst.getString("date_achat"));
                list.add(ach);
            }
            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            DecimalFormat df = new DecimalFormat("0.00");
            mo.setRowCount(0);
            Object row[] = new Object[7];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getN_achat();
                row[1] = list.get(k).getNom_prenom_forn();
                row[2] = list.get(k).getDesignation();
                row[3] = list.get(k).getQuantité();
                row[4] = list.get(k).getPrix_total();
                row[5] = list.get(k).getPrix_unitaire();
                row[6] = list.get(k).getDate_achat();
                mo.addRow(row);
            }
            list.clear();
            j1.setText("qte totale " + qte);
            j2.setText("prix totale " + prixT);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }

    public void FindAchatDate(JTable T, String d1, String d2, JLabel j1, JLabel j2) {
        int qte = 0;
        float prixT = 0;
        try {
            ArrayList<Achat> list = new ArrayList<Achat>();
            
            String sql = "SELECT * FROM achat WHERE date_achat between'" + d1 + "' and '" + d2 + "'  ";
            rst = (ResultSet) st.executeQuery(sql);
            while (rst.next()) {
                qte = qte + rst.getInt("quantite");
                prixT = prixT + rst.getFloat("prix_total");
                Achat ach = new Achat(rst.getInt("N_achat"), rst.getString("nom_prenom_forn"), rst.getString("designation"), rst.getInt("quantite"),
                        rst.getFloat("prix_total"), rst.getFloat("prix_unitaire"),
                        rst.getString("date_achat") );
                list.add(ach);
            }
            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            DecimalFormat df = new DecimalFormat("0.00");
            mo.setRowCount(0);
            Object row[] = new Object[7];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getN_achat();
                row[1] = list.get(k).getNom_prenom_forn();
                row[2] = list.get(k).getDesignation();
                row[3] = list.get(k).getQuantité();
                row[4] = list.get(k).getPrix_total();
                row[5] = list.get(k).getPrix_unitaire();
                row[6] = list.get(k).getDate_achat();
                mo.addRow(row);
            }
            list.clear();
            j1.setText("qte totale " + qte);
            j2.setText("prix totale " + prixT);

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }

    public void inserFacture(Facture fac, String etat) {
        try {
            float r = fac.montant_a_paye - fac.montant_verser;
            
            String sql12 = "update facture set etat = \'servir\' where etat = \'non servir\' && nom_prenom_forn = '"+ fac.getNom_prenom_forn() +"' ";
            String sql1 = "INSERT INTO `facture`( `nom_prenom_forn`, `montant_a_paye`, `montant_verser`"
                    + ",`montant_reste`, `date_versement`, `etat`) "
                    + "VALUES ('" + fac.nom_prenom_forn + "'," + "'" + fac.montant_a_paye + "','" + fac.montant_verser + "'"
                    + ",'" + r + "','" + showDate() + "','" + etat + "') ";
            st.executeUpdate(sql12);
            st.executeUpdate(sql1);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ereur operation");
        }
    }

    public void AllFacture(JTable T) {
        try {
            ArrayList<Facture> list = new ArrayList<Facture>();
            
            String sql = "select * from facture";
            rst = (ResultSet) st.executeQuery(sql);

            while (rst.next()) {
                Facture fac = new Facture(rst.getInt("N_fact"), rst.getString("nom_prenom_forn"),
                        rst.getFloat("montant_a_paye"), rst.getFloat("montant_verser"),
                        rst.getFloat("montant_reste"), rst.getString("date_versement") + "", rst.getString("etat"));
                list.add(fac);
            }
            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            mo.setRowCount(0);
            Object row[] = new Object[7];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getN_fact();
                row[1] = list.get(k).getNom_prenom_forn();
                row[2] = list.get(k).getMontant_a_paye();
                row[3] = list.get(k).getMontant_verser();
                row[4] = list.get(k).getMontant_reste();
                row[5] = list.get(k).getDate_versement();
                row[6] = list.get(k).getEtat();
                mo.addRow(row);
            }
            list.clear();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }

    public void FindPrixTotale(String s, JTextField jt) {
        try {
          
            String sql = "SELECT sum(prix_total) FROM `achat` WHERE nom_prenom_forn = '" + s + "'  ";
             
              rst = (ResultSet) st.executeQuery(sql);
            if (rst.next()) {
                String f = rst.getString("sum(prix_total)");
                jt.setText(f + "");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }
    public void montant_a_paye(String s, JTextField jt){
      try {
            
            String sql = "SELECT sum(prix_total) FROM `achat` WHERE nom_prenom_forn = '" + s + "'  ";
            float f ,m ;
              
              rst = (ResultSet) st.executeQuery(sql);
            f=0;m=0;
            if (rst.next()) {
             f = rst.getFloat("sum(prix_total)");
                
            }
            sql = "SELECT sum(montant_verser) FROM `facture` WHERE nom_prenom_forn = '" + s + "'  ";
            rst = st.executeQuery(sql);
            if (rst.next()) {
                 m = rst.getFloat("sum(montant_verser)");
                 
              jt.setText(f-m + "");  
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    
    }
    public void DeleteFacture(int id) {
        String sql = "DELETE FROM facture WHERE N_fact=" + id;
        try {
            
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpdatFact(int id, Facture fc) {

        try {
            float reste = fc.montant_a_paye - fc.montant_verser;
            String etat;

            String sql = "Update facture set nom_prenom_forn='" + fc.nom_prenom_forn + "',montant_a_paye='" + fc.montant_a_paye + "',"
                    + "montant_verser='" + fc.montant_verser + "'" + ",montant_reste='" + reste + "',"
                    + "date_versement='" + showDate() 
                    + "where N_fact=" + id;
            
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void FindFact(JTable T, String SQL
    ) {

        try {
            ArrayList<Facture> list = new ArrayList<Facture>();
            
            String sql = SQL;
            rst = (ResultSet) st.executeQuery(sql);

            while (rst.next()) {
                Facture fac = new Facture(rst.getInt("N_fact"), rst.getString("nom_prenom_forn"),
                        rst.getFloat("montant_a_paye"), rst.getFloat("montant_verser"),
                        rst.getFloat("montant_reste"), rst.getString("date_versement") + "", rst.getString("etat"));
                list.add(fac);
            }
            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            mo.setRowCount(0);
            Object row[] = new Object[7];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getN_fact();
                row[1] = list.get(k).getNom_prenom_forn();
                row[2] = list.get(k).getMontant_a_paye();
                row[3] = list.get(k).getMontant_verser();
                row[4] = list.get(k).getMontant_reste();
                row[5] = list.get(k).getDate_versement();
                row[6] = list.get(k).getEtat();
                mo.addRow(row);
            }
            list.clear();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }

    public String FindPrixTotaleRESTE() {
        String f = "";
        try {
            
            String sql = "SELECT sum(montant_reste) FROM `facture` WHERE etat = 'non servir'  ";
             
             rst = (ResultSet) st.executeQuery(sql);
            if (rst.next()) {
                f = rst.getString("sum(montant_reste)");

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
        return f;
    }

    public void FindDesignation(JComboBox combo) {
        try {
            
            String sql = "select designation  from achat";
            rst = (ResultSet) st.executeQuery(sql);
            ArrayList<String> ar = new ArrayList<>();
            ArrayList<String> rpl = new ArrayList<>();
            while (rst.next()) {
                ar.add(rst.getString("designation").toString());

            }
            rpl = Rplace(ar);
            for (int i = 0; i < rpl.size(); i++) {
                combo.addItem(rpl.get(i));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }

    }

    ArrayList<String> Rplace(ArrayList<String> ar) {
        ArrayList<String> rpl = new ArrayList<>();
        int K = 0;
        boolean test;
        while (K < ar.size()) {
            test = true;
            for (int i = 0; i < rpl.size(); i++) {
                if (ar.get(K).equals(rpl.get(i))) {
                    test = false;
                }
            }
            if (test) {
                rpl.add(ar.get(K));
            }
            K++;
        }

        return rpl;
    }

    public void FindQteTotal(String sql, String sql1, JTextField jt) {
        try {
              
              rst = (ResultSet) st.executeQuery(sql);
            //  DecimalFormat df=new DecimalFormat("0.00");
            if (rst.next()) {

                float f = rst.getFloat(sql1);
                jt.setText(/*df.format(*/f/*)*/ + "");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }
    ArrayList<String> DES = new ArrayList<>();

    public void AllStock(JTable T) {

        try {
            ArrayList<Stock> list = new ArrayList<Stock>();
            
            String sql = "select * from stock";
            rst = (ResultSet) st.executeQuery(sql);
            DES.clear();
            while (rst.next()) {

                Stock ST = new Stock(rst.getInt("N_prod"), rst.getString("designation"),
                        rst.getString("categorie"), rst.getString("unite"),
                        rst.getString("date_exp") + "", rst.getInt("qte_totale"),
                        rst.getInt("qte_vente"), rst.getFloat("prix_vent"),
                        rst.getFloat("prix_unt") ,  rst.getFloat("prix_grant") , rst.getString("barcode")
                );
                list.add(ST);
            }

            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            mo.setRowCount(0);
            DecimalFormat df = new DecimalFormat("0.00");
            Object row[] = new Object[13];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getN_prod();
                row[1] = list.get(k).getDesignation();
                DES.add(list.get(k).getDesignation());
                row[2] = list.get(k).getCategorie();
                row[3] = list.get(k).getUnite();
                row[4] = list.get(k).getDate_exp();
                row[5] = df.format(list.get(k).getQte_totale());
                row[6] = list.get(k).getQte_vente();
                row[7] = list.get(k).getQte_reste();
                row[8] = /*df.format(*/ list.get(k).getPrix_unt()/*)*/;
                row[9] = list.get(k).getPrix_vent();
                row[10] = list.get(k).getGain();
                row[11] = list.get(k).getPrix_grant();
                row[12] = list.get(k).getBarcode();

                mo.addRow(row);
            }
            list.clear();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }

    public ArrayList<String> CONTROLE() {

        ArrayList<String> rpl = new ArrayList<>();
        ArrayList<String> rpl1 = new ArrayList<>();
        int K = 0;
        boolean test;
        while (K < DES.size()) {
            test = true;
            for (int i = 0; i < rpl.size(); i++) {
                if (DES.get(K).equals(rpl.get(i))) {
                    test = false;
                }
            }
            if (test) {
                rpl.add(DES.get(K));
            }
            if (test == false) {
                rpl1.add(DES.get(K));
            }
            K++;
        }

        return rpl1;
    }

    public ArrayList<String> CONTROLE2(JComboBox com) {

        ArrayList<String> rpl = new ArrayList<>();

        int K = 0;
        boolean test;
        while (K < com.getItemCount()) {
            test = true;
            for (int i = 0; i < DES.size(); i++) {
                if (com.getItemAt(K).toString().equals(DES.get(i))) {
                    test = false;
                }
            }
            if (test) {
                rpl.add((String) com.getItemAt(K));
            }
            K++;
        }

        return rpl;
    }

    public void insertStock(Stock ST, int s) {

        try {
            System.out.println(ST.getDesignation() + " " + ST.getCategorie()
                    + " " + ST.getUnite() + " " + ST.getDate_exp() + " HH" + ST.getQte_totale()
                    + " " + ST.getQte_vente() + " " + ST.getQte_reste() + " " + " " + ST.getPrix_unt()
                    + " " + ST.getPrix_vent() + " " + ST.getGain());
            
            String sql;
            if (s == 1) {
                sql = "INSERT INTO stock(  designation, categorie,unite,"
                        + "date_exp,qte_totale,qte_vente,qte_reste,prix_unt,"
                        + "prix_vent,gain ,prix_grant , barcode) "
                        + "VALUES ('" + ST.getDesignation() + "'," + "'" + ST.getCategorie()
                        + "','" + ST.getUnite() + "','" + ST.getDate_exp()
                        + "','" + ST.getQte_totale() + "','" + ST.getQte_vente() + "','" + ST.getQte_reste()
                        + "','" + ST.getPrix_unt() + "','" + ST.getPrix_vent() + "','" + ST.getGain() +"','" + ST.getPrix_grant() +"','" + ST.getBarcode() + "') ";
            } else {
                sql = "INSERT INTO stock(  designation, categorie,unite,"
                        + "qte_totale,qte_vente,qte_reste,prix_unt,"
                        + "prix_vent,gain,prix_grant , barcode) "
                        + "VALUES ('" + ST.getDesignation() + "'," + "'" + ST.getCategorie()
                        + "','" + ST.getUnite() + "'"
                        + ",'" + ST.getQte_totale() + "','" + ST.getQte_vente() + "','" + ST.getQte_reste()
                        + "','" + ST.getPrix_unt() + "','" + ST.getPrix_vent() + "','" + ST.getGain() +"','" + ST.getPrix_grant() + "','" + ST.getBarcode() +"') ";
            }
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ereur operation");
        }

    }

    public void DeleteStock(int id) {
        String sql = "DELETE FROM stock WHERE N_prod=" + id;
        try {
            
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpdatStock(String sql) {

        try {
           
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void FindStock(JTable T, String sql) {

        try {
            ArrayList<Stock> list = new ArrayList<Stock>();
            

            rst = (ResultSet) st.executeQuery(sql);
            while (rst.next()) {

                Stock ST = new Stock(rst.getInt("N_prod"), rst.getString("designation"),
                        rst.getString("categorie"), rst.getString("unite"),
                        rst.getString("date_exp") + "", rst.getInt("qte_totale"),
                        rst.getInt("qte_vente"), rst.getFloat("prix_vent"),
                        rst.getFloat("prix_unt"), rst.getFloat("prix_grant"),rst.getString("barcode")
                );
                list.add(ST);
            }

            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            mo.setRowCount(0);
            DecimalFormat df = new DecimalFormat("0.00");
            Object row[] = new Object[13];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getN_prod();
                row[1] = list.get(k).getDesignation();

                row[2] = list.get(k).getCategorie();
                row[3] = list.get(k).getUnite();
                row[4] = list.get(k).getDate_exp();
                row[5] = df.format(list.get(k).getQte_totale());
                row[6] = list.get(k).getQte_vente();
                row[7] = list.get(k).getQte_reste();
                row[8] = /*df.format(*/ list.get(k).getPrix_unt()/*)*/;
                row[9] = list.get(k).getPrix_vent();
                row[10] = list.get(k).getGain();
                row[11] = list.get(k).getPrix_grant();
                row[12] = list.get(k).getBarcode();

                mo.addRow(row);
            }
            list.clear();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }

    public void AllStockVente(JTable T) {

        try {
            ArrayList<Stock> list = new ArrayList<Stock>();
            
            String sql = "select N_prod,designation,qte_totale,"
                    + " qte_vente,qte_reste,prix_vent,gain,prix_grant , barcode from stock  ";
            rst = (ResultSet) st.executeQuery(sql);
            DES.clear();
            while (rst.next()) {
                Stock ST = new Stock(rst.getInt("N_prod"), rst.getString("designation"),
                        rst.getInt("qte_totale"),
                        rst.getInt("qte_vente"), rst.getInt("qte_reste"),
                        rst.getFloat("prix_vent"), rst.getFloat("gain"),rst.getFloat("prix_grant") , rst.getString("barcode")
                );

                list.add(ST);
            }

            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            mo.setRowCount(0);
            DecimalFormat df = new DecimalFormat("0.00");
            Object row[] = new Object[8];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getN_prod();
                row[1] = list.get(k).getDesignation();

                row[2] = df.format(list.get(k).getQte_totale());
                row[3] = list.get(k).getQte_vente();
                row[4] = list.get(k).getQte_reste();

                row[5] = list.get(k).getPrix_vent();
                row[6] = list.get(k).getGain();
                row[7] = list.get(k).getPrix_grant();

                mo.addRow(row);
            }
            list.clear();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }

    
        public void AllStockVenteRcherchebc(JTable T, String S) {

        try {
            ArrayList<Stock> list = new ArrayList<Stock>();
            
            String sql = "select N_prod,designation,qte_totale,"
                    + " qte_vente,qte_reste,prix_vent,prix_unt,gain,prix_grant ,barcode from stock where "
                    + "barcode like '" + S + "%'";
            rst = (ResultSet) st.executeQuery(sql);
            DES.clear();
            while (rst.next()) {

                Stock ST = new Stock(rst.getInt("N_prod"), rst.getString("designation"),
                        rst.getInt("qte_totale"),
                        rst.getInt("qte_vente"), rst.getInt("qte_reste"),
                        rst.getFloat("prix_vent"), rst.getFloat("gain"),rst.getFloat("prix_grant"), rst.getString("barcode")
                );
                list.add(ST);
            }

            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            mo.setRowCount(0);
            DecimalFormat df = new DecimalFormat("0.00");
            Object row[] = new Object[8];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getN_prod();
                row[1] = list.get(k).getDesignation();

                row[2] = df.format(list.get(k).getQte_totale());
                row[3] = list.get(k).getQte_vente();
                row[4] = list.get(k).getQte_reste();

                row[5] = list.get(k).getPrix_vent();
                row[6] = list.get(k).getGain();
                row[7] = list.get(k).getPrix_grant();
                mo.addRow(row);
            }
            list.clear();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }
    
    
    
    public void AllStockVenteRcherche(JTable T, String S) {

        try {
            ArrayList<Stock> list = new ArrayList<Stock>();
            
            String sql = "select N_prod,designation,qte_totale,"
                    + " qte_vente,qte_reste,prix_vent,prix_unt,gain,prix_grant , barcode from stock where "
                    + "designation like '" + S + "%'" + " or categorie like '" + S + "%'";
            rst = (ResultSet) st.executeQuery(sql);
            DES.clear();
            while (rst.next()) {

                Stock ST = new Stock(rst.getInt("N_prod"), rst.getString("designation"),
                        rst.getInt("qte_totale"),
                        rst.getInt("qte_vente"), rst.getInt("qte_reste"),
                        rst.getFloat("prix_vent"), rst.getFloat("gain"),rst.getFloat("prix_grant") , rst.getString("barcode")
                );
                list.add(ST);
            }

            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            mo.setRowCount(0);
            DecimalFormat df = new DecimalFormat("0.00");
            Object row[] = new Object[8];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getN_prod();
                row[1] = list.get(k).getDesignation();

                row[2] = df.format(list.get(k).getQte_totale());
                row[3] = list.get(k).getQte_vente();
                row[4] = list.get(k).getQte_reste();

                row[5] = list.get(k).getPrix_vent();
                row[6] = list.get(k).getGain();
                row[7] = list.get(k).getPrix_grant();
                mo.addRow(row);
            }
            list.clear();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }
    public void UpdateQteResteMinus( int id,int qte) {
        try {
            
            String sql = "SELECT qte_totale,qte_vente FROM `stock` WHERE N_prod = " + id + "  ";
          
              rst = (ResultSet) st.executeQuery(sql);
            if (rst.next()) {
                int totale = rst.getInt("qte_totale");
                int vente = rst.getInt("qte_vente")+qte;
                
                String sql2 = "Update stock set qte_vente='" + vente + "',qte_reste='" 
                        + (totale-vente) + "'"
                    + "where N_prod="+id;

            st.executeUpdate(sql2);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }
    public void UpdateQteResteAdd( String des,int qte) {
        try {
           
            String sql = "select Qte_reste,qte_vente,designation FROM `stock` WHERE designation = '" + des + "'  ";
              
              rst = (ResultSet) st.executeQuery(sql);
            if (rst.next()) {
                int vente = rst.getInt("qte_vente")-qte;
                int reste = rst.getInt("Qte_reste")+qte;
                
                String sql2 = "Update stock set qte_vente='" + vente + "',qte_reste='" 
                        + reste + "'"
                    + "where designation='"+des+"'";

            st.executeUpdate(sql2);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }
     public void FindNomPrenomClient(JComboBox combo) {
        try {
            
            String sql = "select nom_prenom  from client";
            rst = (ResultSet) st.executeQuery(sql);
            ArrayList<String> ar = new ArrayList<>();
            ArrayList<String> rpl = new ArrayList<>();

            while (rst.next()) {

                ar.add(rst.getString("nom_prenom").toString());
            }
            rpl = Rplace(ar);
            for (int i = 0; i < rpl.size(); i++) {
                combo.addItem(rpl.get(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }

    }
      public void insertVente(Vente V) {

        try {
            
            String sql1 = "INSERT INTO vente( nom_prenom_client, commentaire, marchendise,prix_a_payez,benefice,date_vente , vendeur, cridit) "
                    + "VALUES ('" + V.getNom_prenom() + "'," + "'" + V.getCommentaire() + "','" + V.getMarchendise() + "','" + V.getPrix_a_payez()
                    + "','"+V.getBenefice()+"','"+V.getDate()+"','"+V.getVendeur()+"','" +V.getCridit()+"')";
            st.executeUpdate(sql1);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ereur operation");
        }

    }
        public void AllVente(JTable T) {

        try {
            ArrayList<Vente> list = new ArrayList<Vente>();
            
            String sql = "select * from vente";
            rst = (ResultSet) st.executeQuery(sql);
            
            while (rst.next()) {
String s="";s= rst.getString("date_vente")+""+" " +rst.getTime("date_vente")+""; 
                Vente V = new Vente(rst.getInt("N_vente"), rst.getString("nom_prenom_client"),
                        rst.getString("commentaire"), rst.getString("marchendise"),
                         rst.getFloat("prix_a_payez"),rst.getFloat("benefice"),
                  s  , rst.getString("vendeur") , rst.getString("cridit") );
                list.add(V);
            }

            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            mo.setRowCount(0);
            DecimalFormat df = new DecimalFormat("0.00");
            Object row[] = new Object[9];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getN_vente();
                row[1] = list.get(k).getNom_prenom();
               
                row[3] = list.get(k).getCommentaire();
                row[4] = list.get(k).getMarchendise();
             
                row[5] = df.format(list.get(k).getPrix_a_payez());
                row[6] = df.format(list.get(k).getBenefice());
                row[7] = /*df.format(*/ list.get(k).getDate()/*)*/;
                row[8] = list.get(k).getVendeur();
                row[2] = list.get(k).getCridit();

                

                mo.addRow(row);
            }
           // list.clear();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }
            public void FindVente(JTable T,String sql,JLabel j1,JLabel j2) {

        try {
            ArrayList<Vente> list = new ArrayList<Vente>();
            
            
            rst = (ResultSet) st.executeQuery(sql);
           float prix=0,benefice=0;int client =0;
            while (rst.next()) {
String s="";s= rst.getString("date_vente")+""+" " +rst.getTime("date_vente")+""; 
                Vente V = new Vente(rst.getInt("N_vente"), rst.getString("nom_prenom_client"),
                        rst.getString("commentaire"), rst.getString("marchendise"),
                         rst.getFloat("prix_a_payez"),rst.getFloat("benefice"),
                  s , rst.getString("vendeur") , rst.getString("cridit")  );
                prix=prix+rst.getFloat("prix_a_payez");
                benefice=rst.getFloat("benefice")+benefice;
                client++;        
                list.add(V);
            }

            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            mo.setRowCount(0);
            DecimalFormat df = new DecimalFormat("0.00");
            Object row[] = new Object[9];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getN_vente();
                row[1] = list.get(k).getNom_prenom();
               
                row[3] = list.get(k).getCommentaire();
                row[4] = list.get(k).getMarchendise();
             
                row[5] = df.format(list.get(k).getPrix_a_payez());
                row[6] = df.format(list.get(k).getBenefice());
                row[7] = /*df.format(*/ list.get(k).getDate()/*)*/;
                row[8] = list.get(k).getVendeur();
                row[2] = list.get(k).getCridit();

                mo.addRow(row);
            }
           j1.setText("prix V T: "+prix);
            j2.setText("bénifice: "+benefice+" Nb client: "+client);

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
    }
            public void UpdatVente(int id, String s1,String s2 , String s3) {

        try {
            String sql = "Update vente set nom_prenom_client='" + s1+ "',commentaire='" +s2 + "',cridit='" +s3 + "'"
                    
                    + " where  	N_vente=" + id;
            
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
             public void DeleteVente(int id) {
        String sql = "DELETE FROM vente WHERE  	N_vente=" + id;
        try {
            
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clear(String table) {
        String sql="delete from " + table;
        try {
            
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int stockexist(String designation) {
       int re = 0;
        try {
            
            String sql = "select designation from stock where designation = '" + designation + "'";
            rst = (ResultSet) st.executeQuery(sql);
            while (rst.next()) {

                if (rst.getString("designation").equals(designation)) {
                 
                    re = 1;
                    
                } else {
                 
                    re = 0;
                    
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }

        return re;
    }
   public void  FindVentair(String sql , JLabel j1){
          try{
            
            rst = (ResultSet) st.executeQuery(sql);
            float benefice=0;
            while (rst.next()) {
               
            benefice=rst.getFloat("benefice")+benefice;
            j1.setText(benefice + "");
          
            }  
          } catch(SQLException ex) { JOptionPane.showMessageDialog(null, "ereur , verifier les champs");
    }
}
  

    public void Statistique(String sqlgain, String sqlentre, String sqlsorte, String sqlpvent, String sqlmvent, String sqlpgain, String sqlprest, JLabel jLabel22, JLabel jLabel23, JLabel jLabel24, JLabel jLabel25, JLabel jLabel26, JLabel jLabel27, JLabel jLabel28, JLabel jLabel29, JLabel jLabel30, JLabel jLabel31, JLabel jLabel32, JLabel jLabel33, JLabel jLabel34, JLabel jLabel35, JLabel jLabel36, JLabel jLabel37 , JLabel jLabel46 , JLabel jLabel47) {
      
        try{
        
        rst = (ResultSet) st.executeQuery(sqlgain);
        while (rst.next()) {
        jLabel22.setText(rst.getFloat("gain") +" DA");
        jLabel31.setText(rst.getInt("qte") +" ");}
        
        rst = (ResultSet) st.executeQuery(sqlentre);
        while (rst.next()) {
        jLabel23.setText(rst.getFloat("prix") +" DA");
        jLabel32.setText(rst.getInt("qte") +" ");}
        
        rst = (ResultSet) st.executeQuery(sqlsorte);
        while (rst.next()) {
        jLabel24.setText(rst.getFloat("prix") +" DA");
        jLabel33.setText(rst.getInt("qte") +" ");}
        int max = 0 ; 
       
        rst = (ResultSet) st.executeQuery(sqlpvent);
        while (rst.next()) {
        max = rst.getInt("max") ;    
        jLabel34.setText( max +" ");
         
        }
        int min = max ;
        ts = (ResultSet) st.executeQuery("select designation from stock where qte_vente = '" + max + "' ");
        while (ts.next()) {
        jLabel25.setText(ts.getString("designation") +"");
          }
        rst = (ResultSet) st.executeQuery(sqlmvent);
        while (rst.next()) {
         min = rst.getInt("min") ;    
         jLabel35.setText( min +" ");
        }
        ts = (ResultSet) st.executeQuery("select designation from stock where qte_vente ='" + min + "' ");

        while (ts.next()) {
        jLabel26.setText(ts.getString("designation") +"");
          }
        
            max=0;
            min=999999999;
           rst = (ResultSet) st.executeQuery(sqlpgain);
        while (rst.next()) {
            if(max < (int) (rst.getInt("qte_vente")*rst.getFloat("gain"))){
         max = (int) (rst.getInt("qte_vente")*rst.getFloat("gain")) ;  }  
             if(min > (int) (rst.getInt("qte_vente")*rst.getFloat("gain"))){
         min = (int) (rst.getInt("qte_vente")*rst.getFloat("gain")) ;  }  
        
        }
         jLabel37.setText( max +" DA");
         jLabel36.setText( min +" DA");
        ts = (ResultSet) st.executeQuery("select designation from stock where qte_vente*gain ='" + max + "' ");

        while (ts.next()) {
        jLabel30.setText(ts.getString("designation") +"");
          }
         ts = (ResultSet) st.executeQuery("select designation from stock where qte_vente*gain ='" + min + "' ");

        while (ts.next()) {
        jLabel29.setText(ts.getString("designation") +"");
          }
        rst = (ResultSet) st.executeQuery(sqlprest);
        while (rst.next()) {
        max = rst.getInt("max") ;    
        jLabel47.setText( max +" ");
        
        }
        ts = (ResultSet) st.executeQuery("select designation from stock where qte_reste = '" + max + "' ");
        while (ts.next()) {
        jLabel46.setText(ts.getString("designation") +"");
          }
        }catch(SQLException ex) { JOptionPane.showMessageDialog(null, "ereur , verifier les champs");}
    
    }

    public void pointage(String sql, JTable T , int i, JLabel j) {
        //To change body of generated methods, choose Tools | Templates.
      try{  
            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            
            
            rst = (ResultSet) st.executeQuery(sql);
            if(i==1){
            float total=0;
            mo.setRowCount(0);
            int k =0; 
            Object row[] = new Object[2];
            while (rst.next()) {  
                
             row[0] = rst.getString("dateversement");
             row[1] = rst.getFloat("prix");   
           if(row[0]!=null){
             total=rst.getFloat("prix") + total;
             mo.insertRow(k, row);
             k++;}
             
            }
            j.setText(total +" DA");
            }else {
            mo.setRowCount(0);
            int k =0 ; 
            Object row[] = new Object[2];
            while (rst.next()) {  
                
             row[0] = rst.getString("dateabsonce");
             row[1] = "absant";
             if(row[0]!=null){
             mo.insertRow(k, row);
             
             k++;}
             
            }
            j.setText(k +" jours");
            }
          } catch(SQLException ex) { JOptionPane.showMessageDialog(null, "ereur , verifier les champs");
    }
    
    }

    public void deletepointage(String sql) {
         //To change body of generated methods, choose Tools | Templates.
          try {
              
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ajouteversmentouab(String sql) {
        try {
            
            st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 

    public void affichecridit(String sql, JTable T, JLabel j) {
        try {
            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            
            rst = (ResultSet) st.executeQuery(sql);
            float total=0;
            mo.setRowCount(0);
            int k =0; 
            Object row[] = new Object[2];
            while (rst.next()) {  
                
                if(!"".equals(rst.getString("cridit"))){
                row[0] = rst.getString("date_vente");
                row[1] = Float.parseFloat(rst.getString("cridit"));
                total=(float) row[1] + total;
                mo.insertRow(k, row);
                k++;}
                
            }
            j.setText(total +" DA");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

    public void savename(String sql) {
         try {
            
            st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public int TVA(){
    int ttva=0;
    try {
            String sql = "select tva FROM info ";
              
              rst = (ResultSet) st.executeQuery(sql);
            while (rst.next()) {
            ttva=rst.getInt("tva");}
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
                    return ttva ;

}
public String NomeLocal(){
    String nome="MAGAZIN";
    try {
            String sql = "select name FROM info ";
             
              rst = (ResultSet) st.executeQuery(sql);
           while (rst.next()) {
            nome=rst.getString("name");}
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
                    return nome ;}
  public String Tel(){
    String tel="+213xxxxxxxxx";
    try {
            String sql = "select tel FROM info ";
              
              rst = (ResultSet) st.executeQuery(sql);
            while (rst.next()) {
            tel=rst.getString("tel");}
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
                    return tel ;}
    public String Addr(){
    String addr="MAGAZIN";
    try {
            String sql = "select addr FROM info ";
             
              rst = (ResultSet) st.executeQuery(sql);
            while (rst.next()) {
                addr=rst.getString("addr");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
                    return addr ;}

    
    public void csvachatfac(String sql ,  FileWriter f) throws IOException {
         try {
            
            rst = st.executeQuery(sql);
             while (rst.next()) {
                f.append('\n');
                f.append(rst.getString(2));
                f.append("\',\'");
                f.append(rst.getString(3));
                f.append("\',\'");
                f.append(rst.getString(4));
                f.append("\',\'");
                f.append(rst.getString(5));
                f.append("\',\'");
                f.append(rst.getString(6));
                f.append("\',\'");
                f.append(rst.getString(7));
                f.append('\n');
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
     public void csvvente(String sql ,  FileWriter f) throws IOException {
         try {
            
            rst = st.executeQuery(sql);
             while (rst.next()) {
                 f.append('\n');
                f.append(rst.getString(2));
                f.append("\',\'");
                f.append(rst.getString(3));
                f.append("\',\'");
                f.append(rst.getString(4));
                f.append("\',\'");
                f.append(rst.getString(5));
                f.append("\',\'");
                f.append(rst.getString(6));
                f.append("\',\'");
                f.append(rst.getString(7));
                f.append("\',\'");
                f.append(rst.getString(8));
                f.append("\',\'");
                f.append(rst.getString(9));
                f.append('\n');
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public void csvstock(String sql ,  FileWriter f) throws IOException {
         try {
            
            rst = st.executeQuery(sql);
             while (rst.next()) {
                 f.append('\n');
                f.append(rst.getString(2));
                f.append("\',\'");
                f.append(rst.getString(3));
                f.append("\',\'");
                f.append(rst.getString(4));
                f.append("\',\'");
                f.append(rst.getString(5));
                f.append("\',\'");
                f.append(rst.getString(6));
                f.append("\',\'");
                f.append(rst.getString(7));
                f.append("\',\'");
                  f.append(rst.getString(8));
                f.append("\',\'");
                  f.append(rst.getString(9));
                f.append("\',\'");
                  f.append(rst.getString(10));
                f.append("\',\'");
                f.append(rst.getString(11));
                f.append("\',\'");
                  f.append(rst.getString(12));
                f.append("\',\'");
                f.append(rst.getString(13));
                f.append('\n');
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public void importeachat(String get) {
             try {
            String sql = "INSERT INTO `achat`( `nom_prenom_forn`, `designation`, `quantite`"
                    + ", `prix_total`, `prix_unitaire`, `date_achat`) "
                    + "VALUES ('"+get+"')";
            
            st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void importestock(String get) {
            try {
            String sql = "INSERT INTO `stock`(  `designation`, `categorie`, `unite`, `date_exp`, `qte_totale`, `qte_vente`, `qte_reste`, `prix_unt`, `prix_vent`, `gain`, `prix_grant`, `barcode`) "
                    + "VALUES ('"+get+"')";
            
            st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void importefacture(String get) {
            try {
            String sql = "INSERT INTO `facture`( `nom_prenom_forn`, `montant_a_paye`, `montant_verser`"
                    + ", `montant_reste`, `date_versement`, `etat`) "
                    + "VALUES ('"+get+"')";
            
            st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void importevente(String get) {
    try {
            String sql = "INSERT INTO `vente`( `nom_prenom_client`, `commentaire`, `marchendise`, `prix_a_payez`, `benefice`, `date_vente`, `vendeur`, `cridit`) "
                    + "VALUES ('"+get+"')";
            
            st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void affichusers(String sql , JTable T){
    
        try {
            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            
            
            rst = (ResultSet) st.executeQuery(sql);
          
            mo.setRowCount(0);
            int k =0; 
            Object row[] = new Object[2];
            while (rst.next()) {
                row[0] = rst.getInt("id_user");
                row[1] = rst.getString("user");
                mo.insertRow(k, row);
                k++;}
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
             
            }

    public void Ajoute_commande(Bashoard b)  {
        
        try {
            
            String sql;
            
            sql = "INSERT INTO commande(  nom_prenom_client, wilaya, jours, prix_devise, budge, date_insert , date_versment, note,"
                    + "profile_facebook, tele, page_facebook, etat_vercement, etat_commande,"
                    + "sex, but , age , gain) "
                    + "VALUES ('" + b.getNom_prenom_client()+ "'," + "'" + b.getWilaya()
                    + "','" + b.getJours() + "','" + b.getPrix_devise()
                    + "','" + b.getBudge() + "','" + b.getDate_insert()
                    + "','" + b.getDate_versment() + "','" + b.getNote()
                    + "','" + b.getProfile_facebook() + "','" + b.getTele()
                    + "','" + b.getPage_facebook() + "','" + b.getEtat_vercement()
                    + "','" + b.getEtat_commande() + "','" + b.getSex()
                    + "','" + b.getBut() + "','" + b.getAge() +  "','"+b.getGain()+"') ";
            
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
        public void Ajoute_vente_commande(Vente_commande a)  {
        
        try {
            
            String sql;
            
            sql = "INSERT INTO vente_commande(  nom, gain, ca, qnt, date) "
                    + "VALUES ('" + a.getNom()+ "'," + "'" + a.getGain()
                    + "','" + a.getCA() + "','" + a.getQnt()
                    + "','" + a.getDate()  + "') ";
            
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }

    public Stock_commande getInfocommande() {
     
        Stock_commande ST = null  ;    
        try {
            
            String sql = "select * from stock_commande where id = '0'";
            rst = (ResultSet) st.executeQuery(sql);
            DES.clear();
            
        while (rst.next()){    
            ST = new Stock_commande(rst.getFloat("gain"), rst.getFloat("vent"), rst.getFloat("achat"),  rst.getDouble("qnt") );}
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return ST ;
        
    }
     
    public Bashoard getDetailcommande(int i){
         Bashoard b = null ;
        try {
            
            String sql ="select * from commande where N_commande = '"+i+"'" ;
            rst = (ResultSet) st.executeQuery(sql);
            DES.clear();
            while (rst.next()) {
                
                 b = new Bashoard(rst.getString("nom_prenom_client"),rst.getString("wilaya"),
                        rst.getInt("jours"), rst.getDouble("prix_devise"),
                        rst.getDouble("budge") ,""+ rst.getString("date_insert"),""+ rst.getString("date_versment"),
                        rst.getString("note"),rst.getString("tele") ,rst.getString("page_facebook"),rst.getString("profile_facebook"),
                        rst.getString("etat_vercement"),rst.getString("etat_commande"),
                        rst.getString("sex"),rst.getString("but"),rst.getString("age") ,rst.getString("deadline"),rst.getString("date_start")
                        
                );
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b ;
    }

    
    public int getAllcommande(JTable T , JLabel d , JLabel e , String sql) {
    
            double eurro = 0.0;
            double dinar = 0.0 ;
            float gain = 0 ;
            int nb = 0 ;
        try {

            ArrayList<Bashoard> list = new ArrayList<>();
            
            rst = (ResultSet) st.executeQuery(sql);
            DES.clear();
            while (rst.next()) {
                
                Bashoard b = new Bashoard(rst.getInt("N_commande"), rst.getString("nom_prenom_client"),
                        rst.getInt("jours"), rst.getDouble("prix_devise"),
                        rst.getDouble("budge") , ""+rst.getString("date_insert"),
                        rst.getString("etat_commande"),rst.getFloat("gain")
                );
                nb++;
                eurro= rst.getDouble("prix_devise") + eurro ;
                dinar= rst.getDouble("budge") + dinar ;
                gain= rst.getFloat("gain") + gain ;
          
                list.add(b);
            }

            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            mo.setRowCount(0);
            DecimalFormat df = new DecimalFormat("0",DecimalFormatSymbols.getInstance(Locale.ENGLISH));
            df.setMaximumFractionDigits(2);
            Object row[] = new Object[8];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getN_commande();
                row[1] = list.get(k).getNom_prenom_client();
               
                row[2] = list.get(k).getBudge();
                row[3] = df.format(list.get(k).getPrix_devise());
                row[4] = df.format(list.get(k).getGain());
                row[5] = list.get(k).getJours();
                row[6] = list.get(k).getDate_insert();
                row[7] = list.get(k).getEtat_commande();
                
                

                mo.addRow(row);
            }
            list.clear();
            d.setText("total budge est : "+df.format(dinar)+" DA     ==>   Clients : "+nb);
            e.setText("total devise est : "+df.format(eurro)+" €     ==>   Gain : "+df.format(gain)+" DA");

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
       
        return nb ;
        
}

    
    
    
    
    public void getAll_vent_commande(JTable T , JLabel d , JLabel e , String sql) {
    
            double eurro =  0.0;
            double dinar =  0.0 ;
            float gain =  0 ;
            int nb = 0 ;
        try {

            ArrayList<Vente_commande> list = new ArrayList<>();
            
            rst = (ResultSet) st.executeQuery(sql);
            DES.clear();
            while (rst.next()) {
                Vente_commande b = new Vente_commande(rst.getFloat("gain"), rst.getFloat("ca"),
                        rst.getFloat("qnt"), ""+rst.getString("date"),
                        rst.getString("nom") , rst.getInt("id") 
                );
         
                nb++;
                eurro= rst.getFloat("qnt") + eurro ;
                dinar= rst.getFloat("ca") + dinar ;
                gain= rst.getFloat("gain") + gain ;
                
                list.add(b);
               
                
            }

            DefaultTableModel mo = (DefaultTableModel) T.getModel();
            mo.setRowCount(0);
            DecimalFormat df = new DecimalFormat("0",DecimalFormatSymbols.getInstance(Locale.ENGLISH));
            df.setMaximumFractionDigits(2);
            Object row[] = new Object[6];
            for (int k = 0; k < list.size(); k++) {
                row[0] = list.get(k).getId();
                row[1] = list.get(k).getNom();
                row[2] = list.get(k).getCA();
                row[3] = list.get(k).getQnt();
                row[4] = list.get(k).getGain();
                row[5] = list.get(k).getDate();
               

                mo.addRow(row);
            }
   
            list.clear();
            
            
            d.setText("total est : "+df.format(dinar)+" DA     ==>   Clients : "+nb);
            e.setText("total devise est : "+df.format(eurro)+" €     ==>   Gain : "+df.format(gain)+" DA");
               

        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex + " error in recuperitaion");
        }
       
        
    
    }
    
    
    public void Gainweek(JLabel caa ,JLabel g){
        try {
          SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd"); 
          Date d = new Date();
            float gain = 0 ;
            float ca = 0 ;
            int nb = 0 ;
            
            String sql = "SELECT * FROM vente_commande WHERE date between'" + sdf.format(d.getTime()-(1000*60*60*24*7)) + "' and '" + sdf.format(d) + "'  ";
            rst = (ResultSet) st.executeQuery(sql);
            while (rst.next()) {
                gain = gain + rst.getFloat("gain");
                ca = ca + rst.getFloat("ca");
                nb++;
               
                
            }
            caa.setText("Total : "+ca+" DA");
            g.setText("Gain : "+gain+" DA       Clients : "+nb);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
        public void Vente_commande(JLabel caa ,JLabel g , JLabel cl , Date d1 , Date d2){
        try {
          SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd"); 
          Date d = new Date();
            float gain = 0 ;
            float ca = 0 ;
            int nb = 0 ;
            
            String sql = "SELECT * FROM vente_commande WHERE date between'" + sdf.format(d1) + "' and '" + sdf.format(d2) + "'  ";
            rst = (ResultSet) st.executeQuery(sql);
            while (rst.next()) {
                gain = gain + rst.getFloat("gain");
                ca = ca + rst.getFloat("ca");
                nb++;
               
                
            }
            caa.setText("Total : "+ca+" DA");
            g.setText("Gain : "+gain+" DA  ");
            cl.setText("Clients : "+nb);
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    
    public String Best(){
       
        String nom ="Zi ram" ;

        try {
            String sql ="select nom , sum(ca) as c from vente_commande group by nom order by c desc limit 1";
            
            rst = (ResultSet) st.executeQuery(sql);
            while (rst.next()) {
              nom = rst.getString("nom");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    return nom ;
    }

    
    public void UpdateCommand(String sql) {

        try {
            
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void DeleteCommande(String sql) {
     
        try {
            
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Actualise() {
  try {
      
        
        Date_licence dates = null ;

        try {
            String sql ="select * from date_licence where id = '0'";
            
            rst = (ResultSet) st.executeQuery(sql);
            
            while (rst.next()) {
                dates= new Date_licence(rst.getInt("etat"),rst.getString("date_start"),rst.getString("date_point"),rst.getString("date_end"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
            SimpleDateFormat sdft = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
            Date d = new Date();
            AES c = new AES();
            Date date_point;
      try {
            date_point = sdft.parse(c.decrypt(dates.getDate_point()));
      
            if(!date_point.after(d)){
            String s= c.encrypt(sdft.format(d));
            String sql = "Update date_licence set date_point = '" + s + "'  where id = '0' ";
            
            st.executeUpdate(sql);
            }
            } catch (ParseException ex) {
          Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
      }
              
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public Date_licence date_licence(){
       
        Date_licence dates = null ;

        try {
            String sql ="select * from date_licence where id = '0'";
            
            rst = (ResultSet) st.executeQuery(sql);
            
            while (rst.next()) {
                dates= new Date_licence(rst.getInt("etat"),rst.getString("date_start"),rst.getString("date_point"),rst.getString("date_end"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
   return dates ;
    }

    public String getSerial() {
     String serial = null ;
       try {
            String sql ="select key from Activation ";
            
            rst = (ResultSet) st.executeQuery(sql);
            
            while (rst.next()) {
                serial= rst.getString("key");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     return serial ;
    }
  
    
    
    
}