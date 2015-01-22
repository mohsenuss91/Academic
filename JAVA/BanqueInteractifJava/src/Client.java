import java.util.Scanner;

class Client {
  
    private Compte [] comptes=new Compte[100];// les comptes du client
    private int nbComptes=0;// le nombre des comptes du client
    private String nom;	//le nom du client
    private int numero;	// le numero du client
    
    /*Renvoi le nom du client*/
    public String getNom() 
    {
	return nom;
    }
   
    
    /*Renvoi les comptes du client*/
    public Compte[] getComptes() 
    {
	return this.comptes;
    }
    
    /*Renvoi le num du client*/
    public int getNum() 
    {
	return numero;
    }
    
    /*le num du client*/
    public void setNum(int num) 
    {
	this.numero=num;
    }
    
    /*Renvoi le Compte qui se trouve dans l'indice passé en parametres*/
    public Compte getCompte(int numero) {
	return comptes[numero];
    }
    
    /*Un constructeur de client */
    public Client(String s) 
    {
	nom=s;
	ajouterCompte();
    }
    
    /*Ajoute un nouveau compte*/
    public void ajouterCompte() 
    {
	nbComptes+=1;
	comptes[nbComptes]=new Compte();
	comptes[nbComptes].SetNum(Banque.GetnbComptes());
	Banque.SetnbComptes(Banque.GetnbComptes()+1);
    }
    
    /*renvoi le solde total du client*/
    public double getSolde()
    {
	double x=0;
	for (int i=1;i<=nbComptes;i++)
	    x=x+comptes[i].getSolde();
	return x;
    }
    
    
    /*Affiche le solde total du client la somme de tout ces comptes*/
    public void afficherSolde() 
    {
	System.out.println("Le solde du client: "+this.getNom()+ " est: "+this.getSolde()+"DA");
    }
    
    //le bilan de tout les comptes d'un client
    public void afficherBilan(){
	System.out.println("Bilan des comptes du client:"+nom +" N°"+numero);
	for (int i=1;i<=nbComptes;i++)
	    System.out.println(" Le solde du compte n°"+i+" est de "+comptes[i].getSolde()+"DA");
	System.out.println();
    }



    /*Les operations sur le client*/
    public void operation() {
	boolean fini=false;

	while(!fini) {
	    System.out.println("Quelle operation voulez-vous effectuer sur le client "+nom);
	    System.out.println(" (1) Faire un dépot");
	    System.out.println(" (2) Faire un retrait");
	    System.out.println(" (3) Faire un virement");
	    System.out.println(" (4) Créer un compte");
	    System.out.println(" (5) Afficher le bilan des comptes");
	    System.out.println(" (0) Retour");
	    
	    
	    Scanner sc=new Scanner(System.in);
	    System.out.print("Votre choix:\n\t-\t");
	    int reponse=sc.nextInt();
	    
	    switch (reponse) {
	    case 1: 
	    {	System.out.println("+++Faire un dépot+++");
	    	System.out.println("De quel montant? ");
	    	comptes[1].depot(sc.nextDouble());
	    	System.out.println("Le depot a été effectué");
	    	System.out.println();
	    	break;
	    }
	    case 2: 
	    {
	    	System.out.println("+++Faire un retrait+++");
	    	System.out.println("De quel montant? ");
	    	comptes[1].retrait(sc.nextDouble());
	    	System.out.println("Le retrait a été effectué");
	    	System.out.println();
			break;
	    }
	    case 3:
	    {System.out.println("+++Faire un virement+++");
	    	System.out.println("De quel montant? ");
	    	double montant =sc.nextDouble();
	    	System.out.println("Compte emetteur? ");
	    	int emetteur = sc.nextInt();
	    	System.out.println("Compte destinataire? ");
			int destinataire = sc.nextInt();
			if (((emetteur<=nbComptes) && (destinataire<=nbComptes)) &&((emetteur>0) && (destinataire>0)) )
			{
		    comptes[emetteur].virer(montant,comptes[destinataire]);
		    System.out.println("Le virement a étté effectué");
		    System.out.println();
			}
			else {
				
				System.out.println("Impossible de faire le depot\n vueillez verifier les numeros de comptes");
				System.out.println();
				}
		    
			break;
	    }
	    case 4:
	    	
		{
			System.out.println("+++Ajouter un compte+++");
			ajouterCompte();
			System.out.println("Le compte n°"+nbComptes+" a été créé");
			System.out.println();
			break;
		}
	    case 5:
		{	System.out.println("+++Afficher un bilan du client+++");
			afficherBilan();
			break;
		}
	    case 0:
	    	{
	    	fini=true;
	    	}
	    }
	}
    }
}
  
    
