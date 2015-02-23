
public class Pok {

	/**
	 * @param args
	 */
public static void main(String[] args) {
		

Pokemon p1=new PokemonSportif("Pika", 20,4,70,4);
Pokemon p2=new PokemonCasanier("Scwirttle",15,4,65,2);
Pokemon p3=new PokemonSportif("Barbasor", 30,4,75,4);
Pokemon p4=new PokemonCroisiere ("Poss",10,3);

System.out.println("P1) "+ p1.toString());
System.out.println();
System.out.println("P2) "+ p2.toString());
System.out.println();
System.out.println("P3) "+ p3.toString());
System.out.println();
System.out.println("P4) "+ p4.toString());
System.out.println();

CollectionPokemons c=new CollectionPokemons();

c.insert(p1);
c.insert(p2);
c.insert(p3);
c.insert(p4);

System.out.println("> La Moyenne des Pokemons de la Collec = "+c.moy());

System.out.println("> La Moyenne des PokemonSportifs de la Collec= " +c.vitesseMoyenneSportifs());
	}

}
