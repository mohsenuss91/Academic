public class CamionBache extends Camion {
	
	
	
public CamionBache(String immatriculation,int poidsVide, int charge)  
{
	super(immatriculation,poidsVide,charge);
}
public float calculerVitesseMax() {
int vitesse;
if(charge > 7) 
vitesse = 80;
else 
if(charge > 3)
vitesse = 90;
else
if(charge > 0)
vitesse = 110;
else 
vitesse = 130;
return vitesse;
}
}