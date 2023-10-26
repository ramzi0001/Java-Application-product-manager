package gestion.des.produit;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CodeBarreApplet extends JApplet implements ActionListener
{
    private CodeBarrePanel panneauHaut;
    private JPanel panneauBas;
    private Container conteneur; 
    private JTextField JTCode , JTPrix;
    private JButton buttn ;
    private String nb;
    private Impression1 imprim;
	   
        public String randCode(){
        String code ="9780130515816";
        Random random = new Random();
        String first = random.nextInt(899)+100+"";
        String second = random.nextInt(899)+100+"";
        String theard = random.nextInt(899)+100+"";
        String four = random.nextInt(899)+100+"";
        code="6"+first+second+theard+four;
        return code ;
        }
	public void init()
	{
	    String parametre;
        nb =  randCode();
	    construireInterface();
	}
	
	public void initFrame()
	{
	    nb = randCode();
	    construireInterface();
    }
	
	public void construireInterface()
	{
	conteneur = getContentPane();
        panneauHaut = new CodeBarrePanel(nb);
        panneauBas = new JPanel();
        JTCode = new JTextField(nb);
        JTPrix = new JTextField("80000 DA");
        buttn = new JButton("Print");
        panneauBas.add(JTCode);
        panneauBas.add(JTPrix);
        panneauBas.add(buttn);
        JTCode.addActionListener(this);
        buttn.addActionListener(this);
	conteneur.add(panneauHaut, BorderLayout.CENTER);
        conteneur.add(panneauBas, BorderLayout.SOUTH);
        
        setVisible(true);
    }
	
    
	public void actionPerformed(ActionEvent evt)
	{
	    if (evt.getSource()==JTCode) {
    	    // modifier PANNEAUHAUT
    	    panneauHaut.modifie(JTCode.getText());
        }
              if (evt.getSource()==buttn) {
          
               imprim = new Impression1(panneauHaut , JTPrix.getText() );
               imprim.actionPerformed(evt);
           
          }
    }
     
}

