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

public class balle extends JPanel implements ActionListener,KeyListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	double x=0, y=0, coor_x=0, coor_y=0;
	//A facility for threads to schedule tasks for future execution in a background thread.
	Timer t=new Timer(2, this);
	
	/*Constructeur*/
	public balle()
	{
		
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
		if(x<0){coor_x=0; x=0;}
		if(x>balle.f.getWidth()-40){coor_x=0; x=balle.f.getWidth()-55;}
		
		if(y<0){coor_y=0; y=0;}
		if(y>balle.f.getHeight()-40){coor_y=0; y=balle.f.getHeight()-80;}
		
		
		
		x=x+coor_x;
		y=y+coor_y;
		repaint(); //Repaints this component.
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
		
		if(code==KeyEvent.VK_LEFT)	//Constant for the non-numpad left arrow key.
		{
			left();
		}
		
		if(code==KeyEvent.VK_RIGHT)	//Constant for the non-numpad right arrow key.
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
	public static void lancer_la_balle()
	{
		
		balle l=new balle();
		f.add(l);
		f.setVisible(true);
		//Sets the operation that will happen by default when the user initiates a "close" on this frame.
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Balle.");
		f.setSize(300,300);
	
		
	}

}

