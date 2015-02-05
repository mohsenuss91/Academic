import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;
import javax.swing.*;

public class balle extends JFrame {
/*Bouttons*/
private static final long serialVersionUID = 1L;
private JButton ajouter = new JButton("Ajouter");
private JButton pause = new JButton("Pause");
private JButton sortir = new JButton("Sortir");
private JPanel boutons = new JPanel();
private Panneau panneau = new Panneau();

//Classe balle_thread
public balle() 
{
      panneau.setBackground(Color.white);
      add(panneau);
      add(boutons, BorderLayout.SOUTH);
      boutons.add(ajouter);
      boutons.add(pause);
      boutons.add (sortir);
      ajouter.addActionListener(new ActionListener() 
      {
         public void actionPerformed(ActionEvent e) 
         {
            ajoutballe_thread();
         }
      });
  
 //action pause
      pause.addActionListener(new ActionListener() 
      {
         public void actionPerformed(ActionEvent e) 
         {
        	 try 
        	 {
				Thread.sleep(5000);
			} catch (InterruptedException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
         }
      });
//action sortir      
      sortir.addActionListener(new ActionListener() 
      {
          public void actionPerformed(ActionEvent e) 
          {
        	 System.exit(0);
          }
       });
      setSize(600, 600);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
   }
   
// ajouter balle_thread
   private void ajoutballe_thread() 
   {
      balle_thread balle_thread = new balle_thread();      
      panneau.ajout(balle_thread);
      new Thread(new balle_threadSeparee(balle_thread)).start();
   }

 // balle_thread separee
   private class balle_threadSeparee implements Runnable 
   {
      private balle_thread balle_thread;

      public balle_threadSeparee(balle_thread balle_thread) 
      {
          this.balle_thread = balle_thread;
      }
      
      public void run() 
      {
         try 
         {
            while(true)
            {
               balle_thread.deplace(panneau.getBounds());
               panneau.repaint();
               Thread.sleep(20);
            }
         }
         catch (InterruptedException ex) { }
      }
   }

//paneau
   private class Panneau extends JPanel 
   {
      private ArrayList<balle_thread> balle_threads = new ArrayList<balle_thread>();
//ajouter une balle_thread a la liste des balle_threads
      public void ajout(balle_thread balle_thread) 
      {
         balle_threads.add(balle_thread);
         
      }
 //supprimer une balle_thread de la liste des balle_threads
      public void supprime(balle_thread balle_thread)
      {
    	  balle_threads.remove(balle_thread);
      }
//dessiner les balle_threads dans le paneau
      @Override
      protected void paintComponent(Graphics g) 
      {
         super.paintComponent(g);
         Graphics2D surface = (Graphics2D) g;
         g.setColor(Color.black);
         for (balle_thread balle_thread : balle_threads) surface.fill(balle_thread.getForme());
         
      }
   }

   private class balle_thread 
   {
      private double x, y, dx=10, dy=10; //localisation et vitesses
      
  //deplacement des balle_threads
      public void deplace(Rectangle2D zone) 
      {
         x+=dx;
         y+=dy;
         if (x < zone.getMinX()) { x = zone.getMinX();  dx = -dx; }
         if (x+11 >= zone.getMaxX()) { x = zone.getMaxX() - 11;  dx = -dx; }
         if (y < zone.getMinY()) { y = zone.getMinY();  dy = -dy; }
         if (y+11 >= zone.getMaxY()) { y = zone.getMaxY() - 11;  dy = -dy; }
      }
//dessiner un eclipse
      public Ellipse2D getForme() 
      {
    	  
         return new Ellipse2D.Double(x, y, 25, 25); //dimensions
      }
   }
/*****M***A***I***N*******/
   public static void main(String[] args) 
   { 
	   new balle(); 
   }
}