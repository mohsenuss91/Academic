package src;

import java.util.*;
import java.io.*;
public class Graphe implements Serializable{
	

	 public boolean modifi� = false;
	protected List  noeuds= new LinkedList();
	  protected List  aretes= new LinkedList();
	  public short nombreNoeudMax = 1;
	public Graphe(){
	
}

	  public Noeud getNoeud(String nom) {
	    for (Iterator itr = noeuds.iterator(); itr.hasNext(); ) {
	      Noeud n = (Noeud) itr.next();
	      if (n.getNom().equals(nom)) {
	        return n;
	      }
	    }
	    return null;
	  }

	  public void addNoeud(Noeud noeud) {
	    ++nombreNoeudMax;
	    noeuds.add(noeud);
	  }

 	  public void removeNoeud(String nom) {

	    for (Iterator itr = noeuds.iterator(); itr.hasNext(); ) {
	      Noeud n = (Noeud) itr.next();
	      if (n.getNom().equals(nom)) {
	        noeuds.remove(n);
	        for (Iterator itr1 = n.p�res.iterator(); itr1.hasNext(); ) {
	          Noeud n1 = (Noeud) itr1.next();
	          n1.removeFils(n);
	          removeArr�te(n1, n);
	        }
	        for (Iterator itr1 = n.fils.iterator(); itr1.hasNext(); ) {
	          Noeud n1 = (Noeud) itr1.next();
	          n1.removeP�re(n);
	          removeArr�te(n, n1);
	        }
	        return;
	      }
	    }
	  }

	  public void getAscendant(Noeud n, LinkedList list) {

//	 Noeud n=getNoeud(Nom);
	    if (n.p�res!=null){
	    for (Iterator itr = n.p�res.iterator(); itr.hasNext(); ) {
	      Noeud pere = (Noeud) itr.next();
	      if (!list.contains( (Noeud) pere)) {
	        list.add(pere);


	      if (pere.p�res != null) {
	       getAscendant(pere,list);
	      } }

	    }
	   // return null;
	  }
	  }
	  public void getDescendant(Noeud n, LinkedList list) {

//	 Noeud n=getNoeud(Nom);
	   if (n.fils!=null){
	   for (Iterator itr = n.fils.iterator(); itr.hasNext(); ) {
	     Noeud fils = (Noeud) itr.next();
	     if (!list.contains( (Noeud) fils)) {
	       list.add(fils);


	     if (fils.fils != null) {
	      getDescendant(fils,list);
	     } }

	   }
	  // return null;
	 }
	 }

	  public void addAr�te(Arete arete) {
	    aretes.add(arete);
	  }

	  public void addArr�te(Noeud n1, Noeud n2,String Nom) {
	    if (!n1.fils.contains(n2)) {
	      n1.addFils(n2);
	    }
	    if (!n2.p�res.contains(n1)) {
	      n2.addP�re(n1);
	    }

	    aretes.add(new Arete(n1, n2,Nom));
	  }

	  public void removeArr�te(Noeud n1, Noeud n2) {

	    for (int i = 0; i < aretes.size(); i++) {
	      Arete a = (Arete) aretes.get(i);
	      if (a.origine == n1 && a.extrem == n2) {
	        aretes.remove(a);
	      }
	    }n1.removeFils(n2);
	    n2.removeP�re(n1);
	  }

	  public boolean contains(String nom) {
	    for (Iterator itr = noeuds.iterator(); itr.hasNext(); ) {
	      Noeud n = (Noeud) itr.next();
	      if (n.getNom().equals(nom)) {
	        return true;
	      }
	    }
	    return false;
	  }
	 /* public boolean contains_Arete(String nom) {
		    for (Iterator itr = aretes.iterator(); itr.hasNext(); ) {
		      Arete a = (Arete) itr.next();
		      if (a.getNom().equals(nom)) {
		        return true;
		      }
		    }
		    return false;
		  }*/
	

}
