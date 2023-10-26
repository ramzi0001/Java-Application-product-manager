package gestion.des.produit;

import java.awt.*; 
import java.awt.event.*; 
import java.awt.geom.AffineTransform;
import java.awt.print.*; 
import java.io.File;
import javax.swing.*; 
public class Impression implements Printable, ActionListener{
 
/** **/ 
  private String  nameLocal,  expedition,  box,  ticket,  caissier,  dateTime,  items,  subTotal,  tax,  total,  recibo,  change ; 
  int y =0 ;       
  /*  private String contentTicket = 
"VINATERIA {{nameLocal}}\n"+
"{{expedition}}\n"+
"DOMICILIO CONOCIDO MERIDA, YUC.\n"+
"=============================\n"+
"MERIDA, XXXXXXXXXXXX\n"+
"RFC: XXX-020226-XX9\n"+
"Caja # {{box}} - Ticket # {{ticket}}\n"+
"Caisse: {{cajero}}\n"+
"{{dateTime}}\n"+
"=============================\n"+
"{{items}}\n"+
"=============================\n"+
"Remise: {{subTotal}}\n"+
"TAX: {{tax}}\n"+
"TOTAL: {{total}}\n\n"+
"=============================\n"+
"GRACIAS POR SU COMPRA...\n"+
"Tel: {{recibo}}\n"+
"ESPERAMOS SU VISITA NUEVAMENTE {{change}}\n"+
"\n"+
"\n";
    */
    public void draw (Graphics g , String text , int x ,int y){
    for(String line : text.split("\n")){
        g.drawString(line, x, y+= g.getFontMetrics().getHeight());
        this.y+=g.getFontMetrics().getHeight();}
    }   
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException { 
        if (page > 0) { return NO_SUCH_PAGE; } 
    ImageIcon icon = new ImageIcon("logo.png");
     Image image = icon.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
     icon.setImage(image); 
     int x=0;
    Graphics2D g2d = (Graphics2D) g; 
    g2d.drawString(nameLocal,15, x+= g2d.getFontMetrics().getHeight());
    g2d.drawString(expedition,15, x+= g2d.getFontMetrics().getHeight());
    g2d.drawImage(icon.getImage(), 90 ,x+= g2d.getFontMetrics().getHeight() , icon.getImageObserver()) ; 
   
    y=120;
    g2d.drawString("=============================",15, y+= g2d.getFontMetrics().getHeight());
    
    g2d.drawString("Vendeur : "+box,15, y+= g2d.getFontMetrics().getHeight());
    g2d.drawString("Ticket : "+ticket,15, y+= g2d.getFontMetrics().getHeight());
    g2d.drawString("Caissier : "+caissier,15, y+= g2d.getFontMetrics().getHeight());
    g2d.drawString(dateTime,15, y+= g2d.getFontMetrics().getHeight());
    
    g2d.drawString("=============================",15, y+= g2d.getFontMetrics().getHeight());
   
    draw(g2d,items,15,y+= g2d.getFontMetrics().getHeight());
    
    g2d.drawString("=============================",15, y+= g2d.getFontMetrics().getHeight());
    
    g2d.drawString("REMISE : "+subTotal,15, y+= g2d.getFontMetrics().getHeight());
    g2d.drawString("TAX : "+tax,15, y+= g2d.getFontMetrics().getHeight());
    g2d.drawString("TOTAL : "+total,15, y+= g2d.getFontMetrics().getHeight());
    
    g2d.drawString("=============================",15, y+= g2d.getFontMetrics().getHeight());
    
    g2d.drawString("Tel : "+recibo,15, y+= g2d.getFontMetrics().getHeight());
    g2d.drawString("Local : "+change,15, y+= g2d.getFontMetrics().getHeight());

    
    //printAll(g); 
    return PAGE_EXISTS; }
    public void actionPerformed(ActionEvent e) { PrinterJob job = PrinterJob.getPrinterJob(); 
    job.setPrintable(this);
    boolean ok = job.printDialog(); 
    if (ok) {
        try { job.print(); } 
        catch (PrinterException ex) { } } 
    } 
    public Impression(String nameLocal, String expedition, String box, String ticket, String caissier, String dateTime, String items, String subTotal, String tax, String total, String recibo, String change) { 
      this.nameLocal=nameLocal;
      this.expedition=expedition;
      this.box=box;
      this.ticket=ticket;
      this.caissier=caissier;
      this.dateTime=dateTime;
      this.items=items;
      this.subTotal=subTotal;
      this.tax=tax;
      this.total=total;
      this.recibo=recibo;
      this.change=change;
      
      
      

    } 
}