import java.util.ArrayList;


public class Convoi {
	
	static ArrayList<Vehicule> c=new ArrayList();
	
	public static float consomation()
	{
		return 0;
	}

		public static void main(String[] args) {
			
			
		CamionBache cb = new CamionBache("GH 324 AE",2, 1);
		CamionBache cb2 = new CamionBache("GH 324 AE",10, 15);
		
		c.add(cb);
		c.add(cb2);
		System.out.println("===||||Convoi||||===");
		System.out.println ("** Camion bache1 ** "+cb.obtenirDescription());
		System.out.println ("\tVitesse maximale : "+cb.calculerVitesseMax());
		System.out.println ("** Camion bache2 ** "+cb2.obtenirDescription());
		System.out.println("\tVitesse maximale : "+cb2.calculerVitesseMax());
		}
		
}
