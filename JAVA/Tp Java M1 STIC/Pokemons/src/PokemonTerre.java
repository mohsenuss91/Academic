public abstract class PokemonTerre extends Pokemon {
private int nbPattes;
private double taille;
public PokemonTerre (String nom, int poids, int nbPattes, double taille)
{ super (nom, poids);
this.nbPattes = nbPattes;
this.taille = taille;
}
public double vitesse()
{ return nbPattes * taille * 3;}
public String toString()
{ return super.toString() + " j'ai " + nbPattes + " ma taille est de " +
taille + "m ";}
}