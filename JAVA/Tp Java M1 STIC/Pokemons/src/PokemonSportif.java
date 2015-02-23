public class PokemonSportif extends PokemonTerre {
private int frequence;
public PokemonSportif(String nom, int poids, int nbPattes, double taille,int frequence)
{ 
	super(nom,poids,nbPattes,taille);
	this.frequence = frequence;
}
public String toString()
{
	return super .toString() + "ma fréquence cardiaque est de " + frequence +" pulsations à la minute";}
}