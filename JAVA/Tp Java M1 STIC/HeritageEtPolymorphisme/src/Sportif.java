public class Sportif extends Terre {

	

	private float freqcar;
	
	Sportif(String nom, float poid, int nbpattes, float taille,float freqcar) {
		super(nom, poid, nbpattes, taille);
		this.freqcar= freqcar;
	}

	void tostring() 
  {System.out.println("To str");
	  System.out.println("Je suis le pokemon"+Pokemon.nom+
			  " mon poid est de"+Pokemon.poid+
			  "kg, ma vitesse est de"+Terre.Vitesse()+
			  "km/h j'ai"+Terre.nbpattes+"pattes, ma taille est de"+Terre.taille+
			  "m ma frequence cardiaque est de"+this.freqcar+"pulsation a la minute");
  }

}