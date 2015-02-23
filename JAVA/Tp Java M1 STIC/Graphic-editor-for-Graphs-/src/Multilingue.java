package src;

import java.io.Serializable;
import java.util.Hashtable;

public class Multilingue implements Serializable{
	/**
	 * 
	 */
	
	protected Graphe graphe;
	  protected Hashtable dico;
	  public Multilingue() {
		    graphe=new Graphe();
		    dico=new Hashtable();

		  }
}
