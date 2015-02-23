package src;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.io.Serializable;

//import java.awt.geom.*;
public class Noeud implements Serializable {
	/**
	 * 
	 */


	/**
	 * 
	 */


	private int x, y, largeur, hauteur;

	private String Nom;
	protected List fils = new LinkedList();
	protected List pères = new LinkedList();

	public Noeud() {
		
	}

	public Noeud(int x, int y, String nom) {
		setX(x);
		setY(y);
		this.Nom = nom;
	//	largeur = Nom.length() * 7 + 3;
		setLargeur(Nom.length() * 7 + 20);
		setHauteur(Nom.length() * 7 + 20);
	}

	String getNom() {
		return Nom;
	}
	void setNom(String nom){
		Nom=nom;
		
	}

	public void dessiner(Graphics g,String nom) {
		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(Color.black);
		
		
		g2d.drawOval(x, y, getLargeur(), getHauteur());
		g2d.setColor(Color.BLACK);
		g2d.drawString(nom, x + 13, y + 10);

	}
	/*
	 public void paint(Graphics g) {
		 Graphics2D g2d = (Graphics2D) g;

			g2d.setColor(Color.blue);

			g2d.drawRect(x, y, getLargeur(), getHauteur());
			g2d.setColor(Color.BLACK);
			g2d.drawString(Nom, x + 13, y + 12);
 
	 }*/
	public void setX(int a) {
		x = a;

	}

	public void setY(int b) {
		y = b;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setLargeur(int Largeur) {
		largeur = Largeur;

	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public int getLargeur() {
		return largeur;

	}

	public int getHauteur() {
		return hauteur;
	}

	public boolean contains(int a, int b) {
		return (boolean) ((x <= a) & (a <= x + 90) & (y <= b) & (b <= y + 20));
	}
	 public void addFils(Noeud fils) {
		    this.fils.add(fils);
		  }

		  public void removeFils(Noeud fils) {
		    this.fils.remove(fils);
		  }

		  public void addPère(Noeud père) {
		    this.pères.add(père);
		  }

		  public void removePère(Noeud père) {

		    this.pères.remove(père);
		  }

		  public boolean isPeres(Noeud noeud) {
		    boolean trouve = false;
		    Noeud pere;
		    Iterator itr = pères.iterator();
		    while ( (itr.hasNext()) && (!trouve)) {
		      pere = (Noeud) itr.next();
		      trouve = pere.equals(noeud);
		    }

		    return trouve;
		  }

		  public boolean isFils(Noeud noeud) {
		    boolean trouve = false;
		    Noeud fils;
		    Iterator itr = this.fils.iterator();
		    while ( (itr.hasNext()) && (!trouve)) {
		      fils = (Noeud) itr.next();
		      trouve = fils.equals(noeud);
		    }

		    return trouve;
		  }
}
