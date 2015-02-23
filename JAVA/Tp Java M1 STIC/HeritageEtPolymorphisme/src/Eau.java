public class Eau extends  Pokemon {

	Eau(String nom, float poid,int nbnag) {
		super(nom, poid);
		this.nbnag=Eau.nbnag;
	}
	protected static Integer nbnag;
	
	public float vitesse()
	{
		return  ((Pokemon.poid/25)*(this.nbnag)/2);
	}
	 public void tostring() 
	  {
		  System.out.println("je suis le pokemon"+Pokemon.nom+" mon poid est de"+Pokemon.poid+"kg, ma vitesse est de"+this.vitesse()+"km/h j'ai"+Eau.nbnag+"nagoires");
	  }

}