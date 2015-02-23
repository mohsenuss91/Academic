package src;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import java.util.*;
import java.util.List;
 

import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;

//import java.util.*;

public class Paneau extends JPanel implements MouseListener,
		MouseMotionListener {

	

	private JTextField txtSaisie = new JTextField();;
	public Rectangle rectangleTracker;
	boolean mode = false;
  static Lang obj,obj2,objc;
  protected List nodeSelected = new LinkedList();
  protected List nodesToCopy = new LinkedList();
  protected List objToCopy = new LinkedList();

  //protected List nodeSelectedDist = new LinkedList();
  int[] Dist=new int[2];
	Noeud s, c, n, t;
Point point=new Point();
	String etiquette;

	private int numero;

	Rectangle rctSelection;

	private Noeud noeudChoisi, debut, fin, noeudProvisoire;

	public Arete arr, areteChoisi, arrProv;

	int l, h,lp,hp;// pour garder la distance entre le rect et le Cursor

	boolean selected = false;

	boolean drawArrProv = false;// pour permettre le dessin du fleche provisoire

	private JPopupMenu jPopupMenu = null;  //  @jve:decl-index=0:visual-constraint="128,95"

	private JMenuItem jMenuModify = null;

	private JMenuItem jMenuDel = null;

	private JMenuItem jMenuCopy = null;
	private JMenuItem jMenuPaste = null;

	public Paneau() {
		this.add(getJPopupMenu(), null);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1200, 1200));
		setBackground(Color.white);
		addMouseListener(this);
		addMouseMotionListener(this);
		txtSaisie.setFont(new Font("Arial", Font.PLAIN, 14));
		txtSaisie.setBackground(Color.WHITE);
		this.add(txtSaisie);
		txtSaisie.setVisible(false);
		// s = new Noeud(90, 50, "younes");
		// c = new Noeud(150, 150, "zoubiri");
		// a = new Arete(s, c, "fils");
		noeudChoisi = Principale.noeudSelected = null;
		rectangleTracker = new Rectangle(0, 0, 0, 0);
		// noeudSelected=null;
	}
		//initialize();
	//	initialize();

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
			
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		super.paintComponent(g2d);
		setBackground(Color.white);
		g2d.clearRect(0, 0, 600, 600);
		g2d.setFont(new Font("Serif", Font.PLAIN, 12));
		if (Principale.MonGraphe.graphe.noeuds != null) {
			for (Iterator itr = Principale.MonGraphe.graphe.noeuds.iterator(); itr
					.hasNext();) {
				Noeud t = (Noeud) itr.next();
				//System.out.println("line"+t.getNom());
				obj=(Lang)Principale.MonGraphe.dico.get(t.getNom());
				if (Principale.LANG==1){
				t.dessiner(g2d,obj.Francais);
				}else{
					t.dessiner(g2d,obj.Anglais);
				}

			}
		}
		if (Principale.MonGraphe.graphe.aretes != null) {
			for (Iterator itr = Principale.MonGraphe.graphe.aretes.iterator(); itr
					.hasNext();) {
				Arete t = (Arete) itr.next();
				t.initPos();
				t.dessiner(g2d, Color.black);

			}

		}
		if(rctSelection!=null)
		g2d.draw(rctSelection);
		if (nodeSelected!=null){
			for(Iterator itr=nodeSelected.iterator();itr.hasNext(); ){
				Noeud node =(Noeud) itr.next();
				g2d.draw(select(node));
				
			}
		}
		if (Principale.noeudSelected != null) {
			/*rctSelection = new Rectangle();
			rctSelection.x = Principale.noeudSelected.getX() - 2;
			rctSelection.y = Principale.noeudSelected.getY() - 2;
			rctSelection.width = Principale.noeudSelected.getLargeur() + 4;
			rctSelection.height = Principale.noeudSelected.getHauteur() + 4;*/
			
			g2d.draw(select(Principale.noeudSelected));
		}
		if (Principale.areteSelected != null) {
			g2d.setColor(Color.GREEN);
			Principale.areteSelected.dessiner(g2d, Color.GREEN);
			g2d.setColor(Color.BLUE);

		}
		if (arrProv != null) {
			arrProv.dessiner(g2d, Color.BLUE);
		}
		
		
	}
	//Pour donner le rectangle de selection d'un seul noeud donné
public Rectangle select(Noeud n){

	Rectangle rctSelect = new Rectangle();
	rctSelect.x = n.getX() - 2;
	rctSelect.y = n.getY() - 2;
	rctSelect.width = n.getLargeur() + 4;
	rctSelect.height = n.getHauteur() + 4;
	return rctSelect;
}
	void acquerirEtiquette(String msg) {
		DialogueEtiquette dial = new DialogueEtiquette(msg);
		etiquette = dial.getText();
		
		if (etiquette.length() == 0 )
		{ if(Principale.ETAT != 2)
			etiquette = "N" + numero++;
		else etiquette = "R"+ numero++;
		}
	}

	public void mouseDragged(MouseEvent e) {
		
		if (rctSelection!=null){
		getSelect(e);
		repaint();
		}
		
		if (noeudChoisi != null & Principale.ETAT == 0) {
			noeudChoisi.setX(e.getX() - l);
			noeudChoisi.setY(e.getY() - h);
			
		}
		
		if (!nodeSelected.isEmpty()& Principale.ETAT == 0 && noeudChoisi!=null){
			
			for(Iterator itr=nodeSelected.iterator();itr.hasNext();){
				Noeud node=(Noeud)itr.next();
				
				if (node!=Principale.noeudSelected){
					//System.out.println(noeudChoisi.getX() - point.x);
					//int r=node.getX();

					node.setX(node.getX()+(noeudChoisi.getX() - point.x));

					node.setY(node.getY()+(noeudChoisi.getY() - point.y));
					
					
					}
					
					}point=new Point(noeudChoisi.getX(),noeudChoisi.getY());repaint();
			
			}
		
		
		repaint();

		
	}

	public void mousePressed(MouseEvent e) {
		
		

		if (noeudChoisi == null & Principale.ETAT == 0) {
			noeudChoisi = noeudProche(e.getX(), e.getY());
			if(!nodeSelected.contains(noeudChoisi)){
				nodeSelected.clear();
			}
			if (noeudChoisi == null){
				nodeSelected=new LinkedList();
				rctSelection=new Rectangle(e.getX(),e.getY(),0,0);
				
			}
		}
		if (areteChoisi == null & Principale.ETAT == 0) {
			areteChoisi = areteProche(e.getX(), e.getY());
			/*if (areteChoisi != null)
			//	System.out.println("voila : " + areteChoisi.nom);*/
		}
		if (areteChoisi != null) {
			Principale.areteSelected = areteChoisi;
			repaint();
			}
		if (noeudChoisi != null && Principale.ETAT == 0) {
			selected = true;
			noeudChoisi = noeudProche(e.getX(), e.getY());
			Principale.noeudSelected = noeudChoisi;
			
		}
		if (noeudChoisi == null) {
			Principale.noeudSelected = noeudChoisi;
		}
		if (areteChoisi == null) {
			Principale.areteSelected = areteChoisi;
		}
		if ((noeudChoisi != null) & (Principale.ETAT == 0)) {
			l = e.getX() - noeudChoisi.getX();
			h = e.getY() - noeudChoisi.getY();
			if(!nodeSelected.isEmpty()){
						point=new Point(noeudChoisi.getX(),noeudChoisi.getY());
						
						
			}
				
		}
		if (Principale.ETAT == 2) {
			if (noeudChoisi == null) {
				noeudChoisi = noeudProche(e.getX(), e.getY());
			} else {
				debut = noeudChoisi;
				fin = noeudProche(e.getX(), e.getY());

				if (fin != null) {
					acquerirEtiquette("Nouvelle Arête :");
					if (!fin.isPeres(noeudChoisi)) {
						fin.addPère(noeudChoisi);
						noeudChoisi.addFils(fin);
						Principale.MonGraphe.graphe.modifié = true;
						arr = new Arete(debut, fin, etiquette);
						if (!Principale.MonGraphe.graphe.aretes.contains(arr)) {
							Principale.MonGraphe.graphe.addArête(arr);
							obj=new Lang(arr.getNom(),arr.getNom());
							Principale.MonGraphe.dico.put(arr.getNom(),obj);
							Principale.MonGraphe.graphe.modifié = true;
							Principale.ETAT=0;
						}
						noeudChoisi = null;
						arrProv = null;
						repaint();
					}
				}
			}
		}
	}

	public Dimension getPreferredSize() {
		int x = 0, y = 0;

		if (Principale.MonGraphe.graphe.noeuds != null) {
			for (Iterator itr = Principale.MonGraphe.graphe.noeuds.iterator(); itr
					.hasNext();) {
				Noeud t = (Noeud) itr.next();
				x = t.getX() + t.getLargeur() > x ? t.getX() + t.getLargeur()
						: x;
				y = t.getY() + t.getHauteur() > y ? t.getY() + t.getHauteur()
						: y;

			}
		}
		if (Principale.noeudSelected != null) {
			return new Dimension(x + Principale.noeudSelected.getLargeur()+30, y
					+ Principale.noeudSelected.getHauteur()+30);
		} else {
			return new Dimension(x+30, y+30);
		}

	}

	public void mouseReleased(MouseEvent e) {
		
		if (Principale.ETAT == 0) {
			noeudChoisi = null;
			areteChoisi = null;
			Principale.listNodeSelected=nodeSelected;
		}
		if (Principale.ETAT == 1 && e.getButton() == e.BUTTON1) {

			acquerirEtiquette("nouveau Noeud");
			Principale.clé = etiquette;
			n = new Noeud(e.getX(), e.getY(), Principale.clé);
			if (!Principale.MonGraphe.graphe.contains(n.getNom())) {
				Principale.MonGraphe.graphe.addNoeud(n);
				obj=new Lang(n.getNom(),n.getNom());
				Principale.MonGraphe.dico.put(n.getNom(),obj);
				Principale.MonGraphe.graphe.modifié = true;
			} else {
			//	System.out.println(Principale.MonGraphe.graphe
				//		.contains(Principale.clé));
				JOptionPane
						.showMessageDialog(null,
								"Ce noeud existe déja",
								"Noeud existant", 0);

			}
		}

	rctSelection=null;

		if (Principale.ETAT == 2 && e.getButton() == e.BUTTON1) {
			noeudProvisoire = noeudProche(e.getX(), e.getY());
			// System.out.println("noeudProv est :"+noeudProvisoire.getNom());
			if (noeudProvisoire == null || noeudChoisi == null) {
				arrProv = null;
				noeudChoisi = null;
				repaint();
			}
			;
		}
		if ((e.getButton() == e.BUTTON3 )&& ((Principale.noeudToCopy!=null) || (!nodesToCopy.isEmpty()))){
			
			
			if (!nodesToCopy.isEmpty()){
				int i=0;
				for(Iterator itr=nodesToCopy.iterator();itr.hasNext();){
					Noeud node=(Noeud)itr.next();
					node.setX(e.getX()+i);
					node.setY(e.getY()+i);
					i=i+20;
				}
			}else{
				Principale.noeudToCopy.setX(e.getX());
				Principale.noeudToCopy.setY(e.getY());
			}
			getJPopupMenu().remove(getJMenuCopy());
			getJPopupMenu().add(getJMenuPaste());
			
			jPopupMenu.show(this, e.getX(), e.getY());		}
		if ((e.getButton() == e.BUTTON3 )  && (Principale.noeudSelected  != null || Principale.areteSelected!=null)) {
			if (Principale.areteSelected!=null){
				getJPopupMenu().remove(getJMenuCopy());
			getJPopupMenu().remove(getJMenuPaste());
			}
			if(Principale.noeudSelected  != null  ){
				getJPopupMenu().remove(getJMenuPaste());
				getJPopupMenu().add(getJMenuCopy());}
			else{if (Principale.noeudToCopy!=null){
				
				
				getJPopupMenu().add(getJMenuPaste());
					
			}
				
			}
			jPopupMenu.show(this, e.getX(), e.getY());
			   
	    }
		if (getPreferredSize().height > getSize().height
				|| getPreferredSize().width > getSize().width
		/*
		 * || getPreferredSize().height < getSize().height ||
		 * getPreferredSize().width < getSize().width
		 */)
			
			this.setSize(getPreferredSize());
		else {
			if (getPreferredSize().height < getSize().height
					&& getPreferredSize().width < getSize().width)
				this.setSize(getPreferredSize());
		}
		

	}

	public void mouseMoved(MouseEvent e) {
		if (Principale.ETAT == 2 && noeudProvisoire != null) {

			noeudProvisoire = new Noeud(e.getX(), e.getY(), "prov");
			if (noeudChoisi != null) {
				arrProv = new Arete(noeudChoisi, noeudProvisoire, "");
			}
			repaint();

		} else {
			arrProv = null;
			repaint();
		}
	}

	/*public void validate2(MouseEvent e) {
		Principale.clé = (String) txtSaisie.getText();
		System.out.println("actionPerformed() " + Principale.clé);
		txtSaisie.setVisible(false);
		n = new Noeud(e.getX(), e.getY(), Principale.clé);
		System.out.println("actionPerformed() " + n.getNom());
		if (!Principale.MonGraphe.graphe.contains(n.getNom())) {
			Principale.MonGraphe.graphe.addNoeud(n);
			
			Principale.MonGraphe.graphe.modifié = true;
			// repaint();
		} else {
			System.out.println(Principale.MonGraphe.graphe
					.contains(Principale.clé));
			JOptionPane.showMessageDialog(null,
					"Ce noeud existe deja", "Noeud existant", 0);
			

		}

	}*/

	public void mouseClicked(final MouseEvent e) {
		
	/*	if (Principale.ETAT == 1) {

			acquerirEtiquette("nouveau Noeud");
			Principale.clé = etiquette;
			n = new Noeud(e.getX(), e.getY(), Principale.clé);
			if (!Principale.MonGraphe.graphe.contains(n.getNom())) {
				Principale.MonGraphe.graphe.addNoeud(n);
				obj=new Lang(n.getNom(),n.getNom());
				Principale.MonGraphe.dico.put(n.getNom(),obj);
				Principale.MonGraphe.graphe.modifié = true;
			} else {
			//	System.out.println(Principale.MonGraphe.graphe
				//		.contains(Principale.clé));
				JOptionPane
						.showMessageDialog(null,
								"Ce noeud existe deja",
								"Noeud existant", 0);

			}
		}*/

		repaint();
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	private Noeud noeudProche(int x, int y) {
		Iterator it = Principale.MonGraphe.graphe.noeuds.iterator();
		while (it.hasNext()) {
			Noeud s = (Noeud) it.next();
			if (s.contains(x, y))
				return s;
		}
		return null;
	}

	private Arete areteProche(int x, int y) {
		Iterator it = Principale.MonGraphe.graphe.aretes.iterator();
		while (it.hasNext()) {
			Arete s = (Arete) it.next();

			if (s.isSelected(x, y))
				return s;
		}
		return null;
	}
	static String getClé(String s){
		  Enumeration itr=Principale.MonGraphe.dico.keys();
		String  key;
		  while(itr.hasMoreElements()){
		  key=(String)itr.nextElement();
		  Lang obj=(Lang)Principale.MonGraphe.dico.get(key);
		  //System.out.println(obj.Francais);
		  if((obj.Francais.equals(s))||(obj.Anglais.equals(s))){
		        return key;
		      }
		    }return "";
		}

	public void modify_Node(Noeud n) {
		if (n != null) {
			acquerirEtiquette("Nouveau Nom");
			if (!Principale.MonGraphe.graphe.contains(etiquette)) {
				Lang obj=(Lang)Principale.MonGraphe.dico.get(n.getNom());
				if (Principale.LANG==1){
				
					obj.Francais=etiquette;
				
				}else {if (Principale.LANG==2)obj.Anglais=etiquette;
					
				}
				n.setLargeur(Math.max(obj.Francais.length(),obj.Anglais.length())*7);
				Principale.MonGraphe.graphe.modifié = true;
			} else {
				/*System.out.println(Principale.MonGraphe.graphe
						.contains(Principale.clé));*/
				JOptionPane
						.showMessageDialog(null,
								"Ce noeud existe deja",
								"Noeud existant", 0);

			}

		}

		repaint();
	}

	public void modify_Arete(Arete a) {
		if (a != null) {
			acquerirEtiquette("Nouvelle relation");

			a.setNom(etiquette);
			Principale.MonGraphe.graphe.modifié = true;

		}

		repaint();
	}
	public void recherche(String nom){
		 n=Principale.MonGraphe.graphe.getNoeud(getClé(nom));
		 System.out.println("recherche a donné"+
				 getClé(nom));
		 if (n==null){ JOptionPane.showMessageDialog(null,
					"Le graphe ne contient pas  ce noeud",
					"Noeud introuvable", 0);}
		 else{
			 Principale.noeudSelected=n;
			 
			 Rectangle rct=new Rectangle(n.getX()-60,n.getY()-60,200,200);
				scrollRectToVisible(rct);
		 }
	}
	/**
	 * This method initializes jPopupMenu	
	 * 	
	 * @return javax.swing.JPopupMenu	
	 */
	private JPopupMenu getJPopupMenu() {
		if (jPopupMenu == null) {
			jPopupMenu = new JPopupMenu();
			jPopupMenu.add(getJMenuModify());
			jPopupMenu.add(getJMenuDel());
			jPopupMenu.addSeparator();
		}
		return jPopupMenu;
	}
	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuModify() {
		if (jMenuModify == null) {
			jMenuModify = new JMenuItem();
			jMenuModify.setText("Modifier");
			jMenuModify.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					modify_Node(Principale.noeudSelected);
					modify_Arete(Principale.areteSelected);
				}
			});
		}
		return jMenuModify;
	}
	/**
	 * This method initializes jMenuItem1	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuDel() {
		if (jMenuDel == null) {
			jMenuDel = new JMenuItem();
			jMenuDel.setText("Supprimer");
			jMenuDel.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (Principale.noeudSelected != null) {
						Principale.MonGraphe.graphe.removeNoeud(Principale.noeudSelected.getNom());
						Principale.MonGraphe.dico.remove(Principale.noeudSelected.getNom());
						Principale.noeudSelected = null;
						repaint();
					}
					if (Principale.areteSelected != null) {
						Principale.MonGraphe.graphe.removeArrête(Principale.areteSelected.origine,
								Principale.areteSelected.extrem);
						Principale.areteSelected = null;
						repaint();
					}
					if (nodeSelected!=null){
						for(Iterator itr=nodeSelected.iterator();itr.hasNext();){
							Noeud node=(Noeud)itr.next();
							Principale.MonGraphe.graphe.removeNoeud(node.getNom());
							Principale.MonGraphe.dico.remove(node.getNom());
									}
						nodeSelected=new LinkedList();
					}
				}
				});
		}
		return jMenuDel;
	}
	/**
	 * This method initializes jMenuItem2	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuCopy() {
		if (jMenuCopy == null) {
			jMenuCopy = new JMenuItem();
			jMenuCopy.setText("Copier");
			jMenuCopy.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					/*Principale.noeudToCopy = new Noeud(Principale.noeudSelected.getX(), Principale.noeudSelected
							.getY(), "$$" + Principale.noeudSelected.getNom() + "$$");
					obj = (Lang) Principale.MonGraphe.dico.get(Principale.noeudSelected
							.getNom());*/
					/*Principale.noeudToCopy = null;
					
					nodesToCopy.clear();
					objToCopy.clear();
					nodeSelected.clear();*/
					if(!nodeSelected.isEmpty()){
						
						for(Iterator itr=nodeSelected.iterator();itr.hasNext();){
							Noeud node=(Noeud)itr.next();
							
							Noeud nodeToCopy = new Noeud(node.getX(), node.getY(), "$$" + node.getNom() + "$$");
							nodesToCopy.add(nodeToCopy);
							
							Lang obj = (Lang) Principale.MonGraphe.dico.get(node
									.getNom());
							
							objToCopy.add(obj);
						}
					}else
					{
						Principale.noeudToCopy = new Noeud(Principale.noeudSelected.getX(), Principale.noeudSelected
								.getY(), "$$" + Principale.noeudSelected.getNom() + "$$");
						objc = (Lang) Principale.MonGraphe.dico.get(Principale.noeudSelected
								.getNom());

					}
					
				}
			});
		}
		return jMenuCopy;
	}
	private JMenuItem getJMenuPaste() {
		if (jMenuPaste == null) {
			jMenuPaste = new JMenuItem();
			jMenuPaste.setText("Coller");
			jMenuPaste.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//Principale.noeudToCopy.setX(0);
				//	Principale.noeudToCopy.setY(0);
					if(!nodesToCopy.isEmpty()){
									int i=0;			
						for(Iterator itr=nodesToCopy.iterator();itr.hasNext();){
							
							Iterator itr2=objToCopy.iterator();
							Noeud node=(Noeud)itr.next();
							
							//Lang obj=(Lang)itr2.next();
							Lang obj=(Lang)objToCopy.get(i++);
							System.out.println(obj.Francais);							
							if (!Principale.MonGraphe.graphe.contains(node.getNom())){
							Principale.MonGraphe.graphe.addNoeud(node);}
							
							Lang obj2 = new Lang("Copie de " + obj.Francais + " $$",
									"Copy of  " + obj.Anglais+ " $$");
							Principale.MonGraphe.dico.put(node.getNom(),
									obj2);
							//itr2.hasNext();
							node.setLargeur(Math.max(obj2.Francais.length(),obj2.Anglais.length())*7);
						}
					}else{
				/*	if (!Principale.MonGraphe.graphe.contains(Principale.noeudToCopy
							.getNom())) {*/
						if(Principale.noeudToCopy!=null){
						if(!Principale.MonGraphe.graphe.contains(Principale.noeudToCopy.getNom()))
								{Principale.MonGraphe.graphe.addNoeud(Principale.noeudToCopy);
						
						obj2 = new Lang("Copie de " + objc.Francais + " $$",
								"Copy of  " + objc.Anglais + " $$");
						Principale.MonGraphe.dico.put(Principale.noeudToCopy.getNom(),
								obj2);
						Principale.noeudToCopy.setLargeur(Math.max(obj2.Francais.length(),obj2.Anglais.length())*7);}
					} }/*else {
						// System.out.println(Principale.MonGraphe.graphe
						// .contains(Principale.clé));
						JOptionPane.showMessageDialog(null,
								"Ce noeud existe deja",
								"Noeud existant", 0);

					}}*/
					Principale.noeudToCopy = null;
					Principale.noeudSelected = null;
					nodesToCopy.clear();
					objToCopy.clear();
					nodeSelected.clear();
				repaint();

				}
				
			});
		}
		return jMenuPaste;
	}
	public Image getImage(){
		   if(this==null){return null;}
		   int width = this.getWidth();
		   int height = this.getHeight();
		   BufferedImage image = new BufferedImage(width, height, 
		                                             BufferedImage.TYPE_INT_RGB);
		   Graphics2D g = image.createGraphics();
		   this.paintAll(g);
		   g.dispose();
		   return image;
		} 
	public void getSelect(MouseEvent e){
		if (rctSelection!=null){
			Noeud vnode = null;
			rctSelection.width=(int)(e.getX()-rctSelection.getX());
			rctSelection.height=(int)(e.getY()-rctSelection .getY());
			for (Iterator e1 = Principale.MonGraphe.graphe.noeuds.iterator(); e1.hasNext(); ) {
			      vnode = (Noeud) (e1.next());
			    //  System.out.println(isRectangleInRectangle(new Rectangle(vnode.getX(),vnode.getY(),vnode.getLargeur(),vnode.getHauteur()), rctSelection));
			      if (isRectangleInRectangle(new Rectangle(vnode.getX(),vnode.getY(),vnode.getLargeur(),vnode.getHauteur()), rctSelection)) {
			    	 
			    	  if(!nodeSelected.contains(vnode))
			    	  nodeSelected.add(vnode);
			    	  //rctSelect = rctSelection.union(vnode.getRectangle());
			      }
			    }
		}
	}

	 static boolean isRectangleInRectangle(Rectangle rct1, Rectangle rct2) {
		    Point pt1_TLft = new Point(rct1.x, rct1.y);
		    Point pt1_BRt = new Point(rct1.x + rct1.width, rct1.y + rct1.height);
		    boolean res = (rct2.contains(pt1_TLft.x, pt1_TLft.y) &&
		                   rct2.contains(pt1_BRt.x, pt1_BRt.y));
		    pt1_TLft = pt1_BRt = null;
		    return res;
		  }
}  //  @jve:decl-index=0:visual-constraint="31,15"