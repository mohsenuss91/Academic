public class PokemonCasanier extends PokemonTerre {
private int tele;
public PokemonCasanier(String nom, int poids, int nbPattes,
double taille, int tele)
{ super(nom,poids,nbPattes,taille);
this.tele = tele;
}
public String toString()
{ return super.toString()+ "je regarde la télé " +tele+ " heures par jour";}
}

