import java.util.ArrayList;


public class CollectionPokemons {
	private ArrayList<Pokemon> l=new ArrayList();
	
	void insert(Pokemon p)
	{
		l.add(p);
		
	}
	
	float moy()
	{
		float s=0;
		
				for(int i=0;i<this.l.size();i++)
				{
					s=((Pokemon) l.get(i)).vitesse()+s;
					
				}
		
		return s/l.size();
		}
	
	float vitesseMoyenneSportifs()
	{
		
		float s=0;
		
		for(int i=0;i<this.l.size();i++)
		{
			if(l.get(i) instanceof Sportif) {s=((Sportif) l.get(i)).vitesse()+s;}
			
		}
		
		return 0;}
	

}
