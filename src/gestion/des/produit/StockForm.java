/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.des.produit;

import gestion.des.produit.dao.ConnectDB;
import gestion.des.produit.modele.Stock;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ziram
 */
public class StockForm extends javax.swing.JFrame {

    /**
     * Creates new form ProduitForm
     */
    public StockForm() {
        initComponents();icon();
    }
void icon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().
                getResource("Cartgrill_icon-icons.com_51191.png")));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jSpinner1 = new javax.swing.JSpinner();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton7 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField7 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setTitle("stock");
        setBackground(new java.awt.Color(204, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 650));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 229, 247));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(182, 36, 110)));
        jPanel1.setLayout(null);

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(204, 0, 51));
        jPanel1.add(jTextField1);
        jTextField1.setBounds(193, 45, 208, 30);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel1.setText("id");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(46, 46, 17, 26);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel2.setText("désignation");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(15, 89, 99, 26);

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(192, 86, 208, 34);

        jTextField3.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(0, 153, 102));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3);
        jTextField3.setBounds(193, 131, 208, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel3.setText("Catégorie");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(15, 132, 85, 26);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel4.setText("quantité totale");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(503, 91, 125, 26);

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(255, 255, 255));
        jTextField4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jPanel1.add(jTextField4);
        jTextField4.setBounds(655, 90, 208, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel5.setText("prix unitaire ach");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(503, 132, 142, 26);

        jTextField5.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jPanel1.add(jTextField5);
        jTextField5.setBounds(655, 131, 208, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel6.setText("prix de vente");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(503, 173, 114, 26);

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(255, 255, 255));
        jTextField6.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(0, 153, 102));
        jTextField6.setToolTipText("clicker pour calculer");
        jTextField6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField6);
        jTextField6.setBounds(655, 172, 208, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/001-technology.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(873, 90, 21, 30);

        jDateChooser1.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser1.setForeground(new java.awt.Color(204, 255, 255));
        jDateChooser1.setDateFormatString("yyyy-MM-dd ");
        jDateChooser1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel1.add(jDateChooser1);
        jDateChooser1.setBounds(193, 179, 208, 33);

        jSpinner1.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jPanel1.add(jSpinner1);
        jSpinner1.setBounds(870, 130, 65, 30);

        jComboBox2.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Piéce", "Kg", "L" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(655, 45, 208, 34);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel8.setText("Unité");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(503, 48, 47, 26);

        jButton2.setBackground(new java.awt.Color(182, 36, 110));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/ajouter.png"))); // NOI18N
        jButton2.setText("ajouter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(15, 246, 150, 41);

        jButton4.setBackground(new java.awt.Color(182, 36, 110));
        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/User-Files-icon.png"))); // NOI18N
        jButton4.setText("modifier");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(171, 244, 150, 44);

        jButton3.setBackground(new java.awt.Color(182, 36, 110));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/supprimer.png"))); // NOI18N
        jButton3.setText("supprimer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(327, 244, 150, 44);

        jButton5.setBackground(new java.awt.Color(182, 36, 110));
        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/modifier.png"))); // NOI18N
        jButton5.setText("actualliser");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(483, 244, 150, 44);

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/viewmag--icone-5948-32.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(240, 570, 46, 30);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " N_prod", "designation", "categorie", "unite", "date_exp", "qte totale", "qte vente", "qte reste", "prix unit", "prix vente", "gain", "prix en grant", "barcode"
            }
        ));
        jTable1.setToolTipText(""); // NOI18N
        jTable1.setGridColor(new java.awt.Color(255, 0, 0));
        jTable1.setRowHeight(40);
        jTable1.setRowMargin(2);
        jTable1.setSelectionBackground(new java.awt.Color(182, 36, 110));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(1, 294, 1007, 195);

        jCheckBox1.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 0, 51));
        jCheckBox1.setText("date d'éxpiration");
        jPanel1.add(jCheckBox1);
        jCheckBox1.setBounds(16, 181, 171, 31);

        jButton7.setBackground(new java.awt.Color(182, 36, 110));
        jButton7.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/verification-of-delivery-list-clipboard-symbol(1).png"))); // NOI18N
        jButton7.setText("verifier ");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(470, 509, 150, 39);

        jComboBox3.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "designation", "categorie", "date exp", "qte reste" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox3);
        jComboBox3.setBounds(33, 526, 208, 34);

        jTextField7.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(0, 102, 255));
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField7);
        jTextField7.setBounds(33, 571, 208, 30);

        jButton8.setBackground(new java.awt.Color(182, 36, 110));
        jButton8.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/imprimer-icone-3918-48.png"))); // NOI18N
        jButton8.setText("imprimer");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(1014, 303, 150, 56);

        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jTextField2.setText("0");
        jPanel1.add(jTextField2);
        jTextField2.setBounds(655, 208, 208, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
        jLabel7.setText("prix en grant");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(503, 209, 109, 26);

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField8);
        jTextField8.setBounds(655, 4, 208, 30);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        jLabel9.setText("Code barre");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(503, 6, 84, 22);
        jLabel9.getAccessibleContext().setAccessibleName("code barre");

        jButton9.setBackground(new java.awt.Color(182, 36, 110));
        jButton9.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/annuler-icone-6802-48.png"))); // NOI18N
        jButton9.setText("vider");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(858, 498, 150, 61);

        jButton10.setBackground(new java.awt.Color(182, 36, 110));
        jButton10.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/simulateur-argent-icone-5481-48.png"))); // NOI18N
        jButton10.setText("Exporte");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(1014, 365, 150, 57);

        jButton16.setBackground(new java.awt.Color(182, 36, 110));
        jButton16.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/index-up-upload-icone-7700-32.png"))); // NOI18N
        jButton16.setText("Importe");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton16);
        jButton16.setBounds(1014, 428, 150, 55);

        jButton11.setBackground(new java.awt.Color(182, 36, 110));
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Imprime Un Code");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11);
        jButton11.setBounds(869, 8, 150, 23);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/about3.png"))); // NOI18N
        jPanel1.add(jLabel10);
        jLabel10.setBounds(0, 0, 1366, 770);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1367, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed
    ConnectDB db;
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated


    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        db = new ConnectDB();
        db.ConnexionIntoDataBase();
        
        db.FindDesignation(jComboBox1);
        db.AllStock(jTable1);
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String sql = "SELECT sum(quantite) FROM `achat` WHERE designation = '" + jComboBox1.getSelectedItem() + "'  ";
        String sql1 = "sum(quantite)";
        db.FindQteTotal(sql, sql1, jTextField4);
        sql = "SELECT max(prix_unitaire) FROM `achat` WHERE designation = '" + jComboBox1.getSelectedItem() + "'  ";
        sql1 = "max(prix_unitaire)";
        db.FindQteTotal(sql, sql1, jTextField5);


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
         try {
        int k = (int) Float.parseFloat(jTextField5.getText());
        int h = Integer.parseInt(jSpinner1.getValue().toString())
                + k;
        jTextField6.setText(h + "");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "ereur,verifier les champs");
          }

    }//GEN-LAST:event_jTextField6MouseClicked

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed

    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String k = "";
           if(db.stockexist((String) jComboBox1.getSelectedItem())==0){
            if (jCheckBox1.isSelected()) {
                SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
                k = sdf.format(jDateChooser1.getDate());
                Stock ST = new Stock(0, jComboBox1.getSelectedItem() + "", jTextField3.getText(),
                        jComboBox2.getSelectedItem() + "", k,
                        (int) Float.parseFloat(jTextField4.getText()),
                        0, Float.parseFloat(jTextField6.getText()),
                        Float.parseFloat(jTextField5.getText()) , Float.parseFloat(jTextField2.getText()) , jTextField8.getText());
                db.insertStock(ST, 1);
            } else {
                Stock ST = new Stock(0, jComboBox1.getSelectedItem() + "", jTextField3.getText(),
                        jComboBox2.getSelectedItem() + "", k,
                        (int) Float.parseFloat(jTextField4.getText()),
                        0, Float.parseFloat(jTextField6.getText()),
                        Float.parseFloat(jTextField5.getText()) , Float.parseFloat(jTextField2.getText()), jTextField8.getText());
                db.insertStock(ST, 0);
            }
            }else{            
                  JOptionPane.showMessageDialog(null, "le produit deja exist !");
                 }
            
            db.AllStock(jTable1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ereur de saisis");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
        String k = "";
        String sql;

        if (jCheckBox1.isSelected()) {
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
            k = sdf.format(jDateChooser1.getDate());
            Stock ST = new Stock(0, jComboBox1.getSelectedItem() + "", jTextField3.getText(),
                    jComboBox2.getSelectedItem() + "", k,
                    (int) Float.parseFloat(jTextField4.getText()),
                    0, Float.parseFloat(jTextField6.getText()),
                    Float.parseFloat(jTextField5.getText()) , Float.parseFloat(jTextField2.getText()) ,jTextField8.getText());

            sql = "Update stock set designation='" + ST.getDesignation() + "',categorie='" + ST.getCategorie() + "',"
                    + "unite='" + ST.getUnite() + "'" + ",date_exp='" + ST.getDate_exp() + "',"
                    + "qte_totale='" + ST.getQte_totale()
                    + "',qte_reste='" + ST.getQte_reste()
                    + "',barcode='" + ST.getBarcode()
                    + "',prix_unt='" + ST.getPrix_unt() + "',prix_vent='" + ST.getPrix_vent() 
                    + "',prix_grant='" + ST.getPrix_grant() + "',"
                    + "gain='" + ST.getGain() + "'"
                    + "where N_prod=" + Integer.parseInt(jTextField1.getText());
            db.UpdatStock(sql);
        } else {
            Stock ST = new Stock(0, jComboBox1.getSelectedItem() + "", jTextField3.getText(),
                    jComboBox2.getSelectedItem() + "", k,
                    (int) Float.parseFloat(jTextField4.getText()),
                    0, Float.parseFloat(jTextField6.getText()),
                    Float.parseFloat(jTextField5.getText()) , Float.parseFloat(jTextField2.getText()),jTextField8.getText());

            sql = "Update stock set designation='" + ST.getDesignation() + "',categorie='" + ST.getCategorie() + "',"
                    + "unite='" + ST.getUnite() + "'" + ",qte_totale='" + ST.getQte_totale()
                    + "',qte_reste='" + ST.getQte_reste()
                    + "',barcode='" + ST.getBarcode()
                    + "',prix_unt='" + ST.getPrix_unt() + "',prix_vent='" + ST.getPrix_vent() 
                    + "',prix_grant='" + ST.getPrix_grant() + "',"
                    + "gain='" + ST.getGain() + "'"
                    + "where N_prod=" + Integer.parseInt(jTextField1.getText());
            db.UpdatStock(sql);
        }
        db.AllStock(jTable1);

         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "eruer operation");
         }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            if (JOptionPane.showConfirmDialog(null, "confirmer la supression ?", "suppression", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                db.DeleteStock(Integer.parseInt(jTextField1.getText()));
                db.AllStock(jTable1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ereur operation");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
db.AllStock(jTable1);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {      String sql;  
            if(jComboBox3.getSelectedItem().equals("designation")){
               sql="select * from stock where designation like '"
                       +jTextField7.getText()+"%'" ;
               db.FindStock(jTable1, sql);
            }else 
                if(jComboBox3.getSelectedItem().equals("categorie")){
               sql="select * from stock where categorie like '"
                       +jTextField7.getText()+"%'" ;
               db.FindStock(jTable1, sql);
            }else if(jComboBox3.getSelectedItem().equals("qte reste")){
               sql="select * from stock where qte_reste<=  "
                       +Integer.parseInt(jTextField7.getText())+"" ;
               db.FindStock(jTable1, sql);
            }else 
                    if(jComboBox3.getSelectedItem().equals("date exp")){
               sql="select * from stock where date_exp between  '"+db.showDate()
                       +"' and '"+jTextField7.getText()+"'";
                       
               db.FindStock(jTable1, sql);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ereur operation");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int i;
        try {
            i = jTable1.getSelectedRow();
            jTextField1.setText(jTable1.getValueAt(i, 0) + "");
            jTextField3.setText(jTable1.getValueAt(i, 2) + "");
            jComboBox1.setSelectedItem(jTable1.getValueAt(i, 1) + "");
            jSpinner1.setValue(jTable1.getValueAt(i, 10));
            jTextField5.setText(jTable1.getValueAt(i, 8) + "");
            jTextField6.setText(jTable1.getValueAt(i, 9) + "");
            jComboBox2.setSelectedItem(jTable1.getValueAt(i, 3) + "");
            jTextField4.setText(jTable1.getValueAt(i, 5) + "");
            jTextField2.setText(jTable1.getValueAt(i, 11) + "");
            jTextField8.setText(jTable1.getValueAt(i, 12) + "");
            

        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
     
        JOptionPane.showMessageDialog(null, 
               "produit repeter : "+db.CONTROLE()+"\n produit avec non prix"
                       + ":" +db.CONTROLE2(jComboBox1),
               "verification de cohérence",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        MessageFormat Header = new MessageFormat("stock"
            + " " + db.showDateTime() + "");

        MessageFormat footer = new MessageFormat("page{0,number,integer}");
        try {

            jTable1.print(JTable.PrintMode.FIT_WIDTH, Header, footer);
            
        } catch (java.awt.print.PrinterException ex) {
            System.err.format("ereur dimpression", ex.getMessage());
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseEntered

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer tout le tableau de Stock ?", "suppression", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
              { db.clear("stock");
              }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
          try {
            ExcelExporter ex =new ExcelExporter();
            File f =  new File("stock.xls");
             try (FileWriter fw = new FileWriter("stock.csv")) {
                 String sql="select * from stock";
                 db.csvstock(sql , fw);
                 fw.flush();
             }
            ex.exportTable(jTable1, f);
              JOptionPane.showMessageDialog(null, "operation Done"," Done", 
                  JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex1) {
            Logger.getLogger(VenteForm.class.getName()).log(Level.SEVERE, null, ex1);
        }
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        
           try {
            // TODO add your handling code here:
            JFileChooser file =new JFileChooser();
            file.setFileFilter(new FileNameExtensionFilter("csv file","csv"));
            file.showSaveDialog(this);
            File f = file.getSelectedFile();
            String path = f.getAbsolutePath();
            BufferedReader reader = new BufferedReader(new FileReader(path));
            
            while( reader.readLine() !=null){
            db.importestock(reader.readLine());
            }
                JOptionPane.showMessageDialog(null, "operation Done"," Done", 
                  JOptionPane.INFORMATION_MESSAGE);
            
        } catch (IOException ex) {
            Logger.getLogger(AchatForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        CodeBarreApplet code = new CodeBarreApplet();
        JFrame fenetreApplication = new JFrame("CodeBarre");
        fenetreApplication.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        CodeBarreApplet modele = new CodeBarreApplet();
        modele.initFrame();
        
        fenetreApplication.getContentPane().add(modele);
        fenetreApplication.setSize(260,200);
        fenetreApplication.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StockForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
