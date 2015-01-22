public class Terre extends Pokemon {

	protected static int nbpattes;

	protected static float taille;
	
	Terre(String nom, float poid,int nbpattes,float taille) {
		super(nom, poid);
		this.nbpattes=nbpattes;
		this.taille=taille;
		
	}


	



  protected static float Vitesse() 
  {
	  return (nbpattes*taille*3);	  
  }

}