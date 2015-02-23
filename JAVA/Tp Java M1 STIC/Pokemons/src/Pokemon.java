public abstract class Pokemon {
private String nom;
private int poids;
public Pokemon(String nom, int poids)
{ this.nom = nom;
this.poids = poids;
}
public abstract double vitesse();
public int getPoids()
{  return poids;}
public String toString()
{ return "Je suis le pokémon " + nom + " mon poids est de " + poids
+ " ma vitesse est de "+ (float)vitesse() + "km/h"; }
}