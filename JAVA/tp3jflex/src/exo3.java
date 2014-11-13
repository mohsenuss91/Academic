

public class exo3 {
	public static void main(String...args) throws Exception  
	{
		bonpar bp =new bonpar(System.in);
		if(bp.yylex()==0)
			if(bp.nb==0) System.out.println("BON");
			else System.out.println("MAUVAIS");
		else System.out.println("MAIVAIS");
	}
}
