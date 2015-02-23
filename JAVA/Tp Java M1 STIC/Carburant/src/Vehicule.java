public abstract class Vehicule {
public String immatriculation; 
public int poidsVide; 


public Vehicule(String immatriculation, int poidsVide) {
this.immatriculation = immatriculation;
this.poidsVide = poidsVide;
}

public abstract float calculerVitesseMax();

public String obtenirDescription() {
return immatriculation + "  " + poidsVide;
}

}