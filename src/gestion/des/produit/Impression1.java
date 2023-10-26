package gestion.des.produit;

import java.awt.*; 
import java.awt.event.*; 
import java.awt.print.*; 
import java.io.File;
import javax.swing.*; 
public class Impression1 extends JPanel implements Printable, ActionListener{
    /** **/ JPanel frameToPrint;
            String s ; 
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException { 
        if (page > 0) { return NO_SUCH_PAGE; } 
        int y =0 ;
    Graphics2D g2d = (Graphics2D) g; 
        g2d.drawString(s, 95, y+= g2d.getFontMetrics().getHeight());
        g2d.translate(pf.getImageableX(), 17);
    frameToPrint.printAll(g); return PAGE_EXISTS; }
    public void actionPerformed(ActionEvent e) { PrinterJob job = PrinterJob.getPrinterJob(); 
    job.setPrintable(this);
    boolean ok = job.printDialog(); 
    if (ok) {
        try { job.print(); } 
        catch (PrinterException ex) { } } 
    } 
    public Impression1(JPanel f  ,String s) { 
     frameToPrint = f; 
     this.s=s;
    
    } 
}