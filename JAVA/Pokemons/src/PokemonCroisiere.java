public class PokemonCroisiere extends PokemonMer {
public PokemonCroisiere (String nom, int poids, int nbNageoires)
{ super(nom,poids,nbNageoires);}
public double vitesse()
{ return super.vitesse() / 2;}
}