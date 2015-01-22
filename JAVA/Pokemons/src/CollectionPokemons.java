import java.util.ArrayList;


public class CollectionPokemons {
	private ArrayList<Pokemon> l=new ArrayList();
	
	void insert(Pokemon p)
	{
		l.add(p);
		
	}
	
	double moy()
	{
		double s=0;
		
				for(int i=0;i<this.l.size();i++)
				{
					s=((Pokemon) l.get(i)).vitesse()+s;
					
				}
		
				if(l.size()!=0){return (float) (s/l.size());}
				else return 0;
		}
	
	float vitesseMoyenneSportifs()
	{
		
		double s=0;
		int nbps=0;
		
		for(int i=0;i<this.l.size();i++)
		{
			if(l.get(i) instanceof PokemonSportif) {
			s=((PokemonSportif) l.get(i)).vitesse()+s;
			nbps++;
			}
			
		}
		
		if(nbps!=0){return (float) (s/nbps);}
		else return 0;}
	

}
