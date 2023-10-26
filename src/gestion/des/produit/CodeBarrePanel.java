package gestion.des.produit;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CodeBarrePanel extends JPanel implements MouseListener, KeyListener, Runnable
{
    private CodeBarre cb;
    private Thread processus;
    private int speed;

    public CodeBarrePanel(String nb)
    {
        cb = new CodeBarre(nb);
        speed = 1000; // 1 sec
        addMouseListener(this);
        addKeyListener(this);
    }
    
    public void modifie(String nouvNb)
    {
        cb.modifie(nouvNb);
        repaint();
    }
    
    public void start()
    {
        if (processus == null) {
	        processus = new Thread(this);
	        processus.start();
	    }
    }
    
    public void stop()
    {
        processus = null;
        repaint();
    }
    
    public void run()
    {
        while (processus!=null) {
            try {
                // modifier quelque chose dans MODELE
                processus.sleep(speed);
                repaint();
            }
            catch (InterruptedException e){}
        }
        processus=null;
    }
    
    public void paint(Graphics g) 
    {
        super.paint(g);
        // remplissage du fond pour effacer lors des repaint()
        g.setColor(Color.WHITE);
        Dimension d = getSize();
        g.fillRect(0,0,d.width,d.height);
        
        cb.dessine(g);
    }
      
    public void mousePressed(MouseEvent evt) {
        requestFocus(); // pour le clavier
        // coordonn�es de l'endroit ou la souris a �t� cliqu�e
        int x = evt.getX();
        int y = evt.getY();
        repaint();
    }   
            
    public void mouseEntered(MouseEvent evt) { }  
    public void mouseExited(MouseEvent evt) { }   
    public void mouseReleased(MouseEvent evt) { } 
    public void mouseClicked(MouseEvent evt) { }
    
    public void keyPressed(KeyEvent evt)
    {
        char ch = evt.getKeyChar(); 
        switch (ch) {
            case '0':  break;
        }
        repaint();
    }
    public void keyReleased(KeyEvent evt){}
    public void keyTyped(KeyEvent evt){}

}

