/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.des.produit;

import gestion.des.produit.dao.ConnectDB;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author ziram
 */
public class Vente_commande_form extends javax.swing.JFrame {

    /**
     * Creates new form Vente_commande_form
     */
    public Vente_commande_form() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Commande vende");
        setPreferredSize(new java.awt.Dimension(920, 470));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nom et prenom client", "Prix de vente", "Devise €", "Gain", "Date de payement"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(40);
        jTable1.setRowMargin(2);
        jTable1.setSelectionBackground(new java.awt.Color(182, 36, 110));
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 60, 560, 310);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/icon/viewmag--icone-5948-32.png"))); // NOI18N
        jLabel2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel2AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2);
        jLabel2.setBounds(470, 20, 34, 32);

        jDateChooser6.setForeground(new java.awt.Color(204, 255, 255));
        jDateChooser6.setDateFormatString("yyyy-MM-dd ");
        jDateChooser6.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel1.add(jDateChooser6);
        jDateChooser6.setBounds(120, 20, 142, 33);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("au:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(280, 20, 30, 30);

        jDateChooser5.setForeground(new java.awt.Color(204, 255, 255));
        jDateChooser5.setDateFormatString("yyyy-MM-dd ");
        jDateChooser5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel1.add(jDateChooser5);
        jDateChooser5.setBounds(310, 20, 142, 33);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("du:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(90, 20, 30, 30);

        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 380, 290, 14);

        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 400, 290, 14);

        jButton1.setBackground(new java.awt.Color(182, 36, 110));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Imprime");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(410, 380, 80, 23);

        jButton2.setBackground(new java.awt.Color(182, 36, 110));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Draw");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(500, 380, 80, 23);

        jButton3.setText("Supprime");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(323, 380, 80, 23);

        jButton4.setText("Vide");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(820, 400, 80, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion/des/produit/about2.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 920, 440);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        MessageFormat Header=new MessageFormat("les commandes payé \n");

        MessageFormat footer=new MessageFormat("page{0,number,integer}");
        
        try {

            jTable1.print(JTable.PrintMode.FIT_WIDTH, Header, footer );

        } catch (java.awt.print.PrinterException ex) {
            System.err.format("ereur dimpression",ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    ConnectDB db ;
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        db=new ConnectDB();
        db.ConnexionIntoDataBase();
        String sql ="SELECT * FROM vente_commande";
        db.getAll_vent_commande(jTable1 , jLabel3 ,jLabel4 , sql);
        
    }//GEN-LAST:event_formWindowActivated

    private void jLabel2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel2AncestorAdded
        // TODO add your handling code here:
        
      
    }//GEN-LAST:event_jLabel2AncestorAdded

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd"); 
         String sql ="select * from vente_commande where date between'" + sdf.format(jDateChooser6.getDate())  + "' and '" + sdf.format(jDateChooser5.getDate()) + "' ";
         db.getAll_vent_commande(jTable1 , jLabel3 ,jLabel4 , sql);
        
        
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
            try{ 
            int i = jTable1.getSelectedRow();
            int id = (int)jTable1.getValueAt(i, 0);
            
            if(JOptionPane.showConfirmDialog(null, "confirmer la supression ?", "suppression"
            ,JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
            String sql ;
            sql ="DELETE FROM vente_commande WHERE  id=" + id;
            db.DeleteCommande(sql);

            
        }}catch(HeadlessException | NumberFormatException e){
            JOptionPane.showMessageDialog(null, "ereur operation");
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
           try{   
            if(JOptionPane.showConfirmDialog(null, "confirmer l'opperation de vide tout la table de vente ?", "suppression"
            ,JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
            String sql ;
            sql ="DELETE FROM vente_commande " ;
            db.DeleteCommande(sql);

            
        }}catch(HeadlessException | NumberFormatException e){
            JOptionPane.showMessageDialog(null, "ereur operation");
        }
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       try{
           
          String url = "jdbc:sqlite:gestion_de_produit.db";      
          Connection cnx =  DriverManager.getConnection(url);
       
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd"); 
           String sql ="select date , SUM(gain) as gain from vente_commande  group by date";
        if( !(jDateChooser5.getDate() == null || jDateChooser6.getDate() == null) ){
            sql ="select date , SUM(gain) as gain from vente_commande  where date between'" + sdf.format(jDateChooser6.getDate())  + "' and '" + sdf.format(jDateChooser5.getDate()) + "' group by date";

           }
       
        JDBCCategoryDataset dataset = new JDBCCategoryDataset( cnx , sql) ;
       
        JFreeChart chart =ChartFactory.createLineChart("Statistique", "Date", "Gain", dataset, PlotOrientation.VERTICAL, false, true, true) ;
        BarRenderer ren = null ;
        CategoryPlot  plot = null ;
        ren = new BarRenderer();
        ChartFrame f = new ChartFrame("Statistique" , chart);
        f.setVisible(true);
        f.setSize(700 , 400);
      
   
        
        
       }catch(SQLException e){}
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Vente_commande_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vente_commande_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vente_commande_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vente_commande_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vente_commande_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
