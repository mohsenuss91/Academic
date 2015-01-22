public abstract class Camion extends Vehicule {
public int charge;
public int chargeMax;
public Camion(String immatriculation, int poidsVide, int charge) {
	super(immatriculation,poidsVide);
	this.immatriculation=immatriculation;
	this.poidsVide=poidsVide;
this.charge = charge;
}
public Camion(String immatriculation, int poidsVide, int charge, int chargeMax) 
{
super(immatriculation,poidsVide);
if(charge > chargeMax) { 
System.out.println("Charge maximale dépassée"); 
}
else {
this.charge = charge;
this.chargeMax = chargeMax;
}
}
public String obtenirDescription() {
return  " \nchargeMax> "+chargeMax+" \ncharge> "+charge;
}
}