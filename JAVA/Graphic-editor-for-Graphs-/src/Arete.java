package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;

public class Arete implements Serializable{

	protected String nom;

	protected Noeud origine;

	protected Noeud extrem;

	public int x1,x2,y1,y2,a, b;
	ArrayList points;
	//Shape line;
	double eps = 0.25;
	  double d   = 13;
	  final int BARB = 10;
	  final double PHI = Math.toRadians(20);
	public Arete() {

	}

	public Arete(Noeud début, Noeud fin, String Nom) {
		this.origine = début;
		this.extrem = fin;
		this.nom = Nom;
		initPos();
	
	}
	public Arete(Noeud début, Noeud fin) {
		this.origine = début;
		this.extrem = fin;
		initPos();
	
	}
public void initPos(){
	
	if (origine.equals(extrem)){
		x1=origine.getX();
		x2=origine.getX()-5;
		y1=origine.getY();
		y2=origine.getHauteur()+y1;
	}
	else{ if (origine.getY()<extrem.getY()){
		x1=origine.getX()+origine.getLargeur()/2;
		y1=origine.getY()+origine.getHauteur();
		x2=extrem.getX()+extrem.getLargeur()/2;
		y2=extrem.getY();
	}
	else if (origine.getY()== extrem.getY()){
		      if (origine.getX()<=extrem.getX()){
				x1=origine.getX()+origine.getLargeur();
				y1=origine.getY()+origine.getHauteur()/2;
				x2=extrem.getX();
				y2=extrem.getY()+extrem.getHauteur()/2;}
		      else {
				x1=origine.getX();
				y1=origine.getY()+origine.getHauteur()/2;
				x2=extrem.getX()+extrem.getLargeur();
				y2=extrem.getY()+extrem.getHauteur()/2;}
	          }
	     else {x1=origine.getX()+origine.getLargeur()/2;
			y1=origine.getY();
			x2=extrem.getX()+extrem.getLargeur()/2;
			y2=extrem.getY()+extrem.getHauteur();}}
}
public boolean isSelected(int mousex, int mousey)
{
    double a, b, c, h, g;

    a = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    b = Math.sqrt((x1 - mousex) * (x1 - mousex) + (y1 - mousey)
            * (y1 - mousey));
    c = Math.sqrt((mousex - x2) * (mousex - x2) + (mousey - y2)
            * (mousey - y2));

    h = a / 2 - (b * b) / (2 * a) + c * c / (2 * a);

    g = Math.sqrt(c * c - h * h);
    if (g < 10
            && (mousex > x1 - 4 && mousex < x2 + 4 || mousex < x1 + 4
                    && mousex > x2 - 4)
            && (mousey > y1 - 4 && mousey < y2 + 4 || mousey < y1 + 4
                    && mousey > y2 - 4))
        return true;
    return false;
}

	public String getNom() {
		return nom;

	}
	public void setNom(String Nom){
		nom=Nom;
	}

	public Noeud getExtrem() {
		return extrem;
	}

	public Noeud getOrigine() {
		return origine;
	}

	public void dessiner(Graphics g,Color couleur) {
		Graphics2D g2d = (Graphics2D) g;
		double dy = y2-y1;
	    double dx =x2-x1;
	    //double dy = (extrem.getY()+extrem.getHauteur()) - origine.getY();
	    //double dx = (extrem.getX()+extrem.getLargeur())-origine.getX();
	    double theta = Math.atan2(dy, dx);
		if (origine==extrem){
			a=x1-20;
			b=y1+10;
		    g2d.setColor(couleur);
			g2d.drawArc(x1-36,y1-9,38,33,22,318);
			g2d.setColor(Color.WHITE);
			if (nom!="") {g2d.clearRect(a -20, b-12 ,20 ,17);}
			//g2d.drawRect(a -20, b-7 ,22 , 9);
		}
		else{a = (int) (x1+(dx/2) -((nom.length() / 2) * 7));
	    b = (int) (y1 + dy / 2);
		  //  Shape line = new Line2D.Double(x1,y1, x2, y2);
			g2d.setColor(couleur);
		        g2d.drawLine(x1,y1,x2,y2);
	         //	g2d.draw(line);
			g2d.setColor(Color.WHITE);
			g2d.clearRect(a - 2, b - 11, nom.length() * 7, 14);
			g2d.drawRect(a - 2, b - 11, nom.length() * 7, 14);
			
		}
		 g2d.setColor(couleur);
		 int []px=new int[3];
		 int []py=new int[3];
		// System.out.println("theta :"+theta);
		// System.out.println("cos theta :"+Math.cos(theta));
		 theta += Math.PI;
		 if (origine==extrem){
			 px[0]=x2+2;
			 py[0]=y2;
			 px[1]=x2-9;
			 py[1]=y2+2;
			 px[2]=x2-5;
			 py[2]=y2+10;
		 }
		 else {
		 px[0]=x2;
		 py[0]=y2;
		 px[1]=x2+(int) (BARB * Math.cos(theta-PHI));
		 py[1]=y2+ (int)(BARB * Math.sin(theta-PHI));
		 px[2]=x2+(int) (BARB * Math.cos(theta+PHI));
		 py[2]=y2+ (int)(BARB * Math.sin(theta+PHI));}
		 
		 
		 g2d.drawPolygon( px,py,3);
		 g2d.fillPolygon( px,py,3);
		 if (nom!=""){if (origine==extrem){g2d.drawString(nom, a-18, b);}
		 else {g2d.drawString(nom, a+3, b);}}
		
	}

	/*public boolean contains(int a, int b) {
		Point2D p=new Point2D.Double(a,b);
		points= new ArrayList();
		return (boolean) getListPoint().contains(p);
	}*/
}
