public class Mer extends Eau {


	
	Mer(String nom, float poid, int nbnag) {
		super(nom, poid, nbnag);
		
	}

	public   float vitesse() {
	  return  ((Pokemon.poid/25)*(this.nbnag));
  }

 

}