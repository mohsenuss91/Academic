import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Balle extends JPanel implements ActionListener,KeyListener
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    // for Client-Side
    private BallListener ballListener;    
    double x=0, y=0, coor_x=0, coor_y=0;
    //A facility for threads to schedule tasks for future execution in a background thread.
    Timer t=new Timer(2, this);

    /*Constructeur*/
    public Balle()
    {
    	//timer start
        t.start();
        //Adds the specified key listener to receive key events from this component.
        addKeyListener(this);
        //Sets the focusable state of this Component to the specified value. This value overrides the Component's default focusability.
        setFocusable(true);
        //Sets whether focus traversal keys are enabled for this Component.
        setFocusTraversalKeysEnabled(true);
    }
 //constructeur pour coté client
    public Balle(BallListener bListener)
    {
    	this.ballListener = bListener;
        t.start();
        //Adds the specified key listener to receive key events from this component.
        addKeyListener(this);
        //Sets the focusable state of this Component to the specified value. This value overrides the Component's default focusability.
        setFocusable(true);
        //Sets whether focus traversal keys are enabled for this Component.
        setFocusTraversalKeysEnabled(true);
    }

/*Calls the UI delegate's paint method, if the UI delegate is non-null.*/
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g1=(Graphics2D) g;
        //Fills the interior of a Shape using the settings of the Graphics2D context.
        g1.fill(new Ellipse2D.Double(x,y,40,40)); //The Double class defines an ellipse specified in double precision.

    }

/*Invoked when an action occurs.*/
    public void actionPerformed(ActionEvent e)
    {    	
    	actionPreforme();
        repaint(); //Repaints this component.
    }
    
//bords controle    
    private void actionPreforme()
    {
        if(x<0){coor_x=0; x=0;}
        if(x>Balle.f.getWidth()-40){coor_x=0; x=Balle.f.getWidth()-55;}

        if(y<0){coor_y=0; y=0;}
        if(y>Balle.f.getHeight()-40){coor_y=0; y=Balle.f.getHeight()-80;}

        if (ballListener != null)
        	ballListener.changedLocation(x,y);

        x=x+coor_x;
        y=y+coor_y;
        
        repaint(); //Repaints this component.
    }
    
//changer la localisation de la balle de l'esclave par le maitre    
    public void changeLocation(double x,double y) 
    {    	
    	if (x != this.x || y != this.y) 
    	{
    		
        	this.x = x;
        	this.y = y;  
        	actionPreforme();
    	}
  	
    	
    	
 
    }

   /*HAUT*/
    public void up()
    {
            coor_y=-1;
            coor_x=0;
    }
    /*BAS*/
    public void down()
    {
        coor_y=1;
        coor_x=0;
    }

    /*GAUCHE*/
    public void left()
    {
        coor_x=-1;
        coor_y=0;
    }

    /*DROITE*/
    public void right()
    {
        coor_x=1;
        coor_y=0;
    }

    //Called just after the user presses a key while the listened-to component has the focus.
    public void keyPressed(KeyEvent e) 
    {
        int code=e.getKeyCode();

        if(code==KeyEvent.VK_UP) //Constant for the non-numpad up arrow key.
        {
            up();
        }

        if(code==KeyEvent.VK_DOWN) //Constant for the non-numpad down arrow key.
        {
            down();
        }

        if(code==KeyEvent.VK_LEFT)  //Constant for the non-numpad left arrow key.
        {
            left();
        }

        if(code==KeyEvent.VK_RIGHT) //Constant for the non-numpad right arrow key.
        {
            right();
        }
    }

   /*nvoked when a key has been typed.*/
    public void keyTyped(KeyEvent e){}

    /*Invoked when a key has been released.*/
    public void keyReleased(KeyEvent e)
    {
        coor_x=0;
        coor_y=0;
    }
   
    static JFrame f=new JFrame();
    
    public static Balle lancer_la_balle()
    {
    	Balle l=new Balle();
        f.add(l);
        f.setVisible(true);
        //Sets the operation that will happen by default when the user initiates a "close" on this frame.
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Balle.");
        f.setSize(300,300);
        return l;
    }
    
    public static void lancer_la_balle(BallListener bListener)
    {
    	Balle l=new Balle(bListener);
        f.add(l);
        f.setVisible(true);
        //Sets the operation that will happen by default when the user initiates a "close" on this frame.
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Balle.");
        f.setSize(300,300);               
    }
    
    //interface BallListener    
    public interface BallListener
    {    	
    	public void changedLocation(double x, double y);
    } 

}
