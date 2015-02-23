public class PokemonMer extends Pokemon {
private int nbNageoires;
public PokemonMer (String nom, int poids, int nbNageoires)
{ super (nom, poids);
this.nbNageoires = nbNageoires;
}
public double vitesse()
{ return (double)getPoids()/25 * nbNageoires;}
public String toString()
{ return super.toString() + " j'ai " + nbNageoires + " nageoires";}
}