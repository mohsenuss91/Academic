import java.util.Scanner;

class Banque {
    private int nbClients=0;	//le nombre des clients de la banque 
    private static int nbComptes=0;	//le nombre des comptes totales
    private Client [] clients=new Client[100];	// les clients de la banque
    
    /*Ajouter un client a la banque*/
    public void ajouterClient(String nom) 
    {
	nbClients+=1;
	clients[nbClients]=new Client(nom);
	clients[nbClients].setNum(nbClients);
    }
    
    /*Get nbComptes*/
    
    public static int GetnbComptes()
    {
		return nbComptes;
    	
    }
    
    
    
 /*Set nbComptes*/
    
    public static int SetnbComptes(int val)
    {
		return nbComptes=val;
    	
    }
   /*le bilan de tout les comptes d'un client*/
    public void bilanClient(int num_client)
    {  
	for (int i=1;i<=nbClients;i++) 
	    if(clients[i].getNum()==num_client) 
	    {
	    	for(int j=1 ;j<=clients[i].getComptes().length;j++)
	    	{
	    		System.out.println("Client:"+clients[i].getNom()+ "Compte N°"+clients[i].getComptes()[j].getNum()+"Solde:"+clients[i].getComptes()[j].getSolde()+"DA");
	    		
	    	}
	    	
	    	
	    }

    }
    
    /*Bilan general de tout les comptes de tous les clienst*/
    public void afficherBilan()  
    	  {  System.out.println("***BILAN GENERAL***");
    			for (int i=1;i<=nbClients;i++) 
    				if(clients[i]!=null)
    				{
    					System.out.println("___Client: "+clients[i].getNom()+ "___" );
    			    	for(int j=0 ;j<clients[i].getComptes().length;j++)
    			    	{
    			    		if(clients[i].getComptes()[j]!=null)System.out.println("Compte N°"+clients[i].getComptes()[j].getNum()+" Solde:"+clients[i].getComptes()[j].getSolde()+"DA");
    			    		
    			    	}
    				}	
    			    	
    			    

    	}
    		    
    /*Interaction avec l' utilisateur*/
    public void interaction() {
	boolean fini=false;
	while (!fini) {
	    System.out.println("Tapez le numero de l'operation que vous voulez effectuer: ");
	    System.out.println(" (1) Ajouter un client");
	    System.out.println(" (2) Afficher le bilan de la banque");
	    System.out.println(" (3) Effectuer une operation sur un client");
	    System.out.println(" (0) Exit");
	    Scanner sc=new Scanner(System.in);
	    System.out.print("Votre choix:\n\t-\t");
	    int reponse=sc.nextInt();
	    switch(reponse){
	    case 1:
	    {
	    	System.out.println("***Ajouter un client***");
	    	System.out.println("Entrez le nom du client: ");
	    	String nom=sc.next();
	    	ajouterClient(nom);
	    	System.out.println("Le client a été ajouté");
	    	System.out.println();
	    	break;
		}
	    case 2:
	    {
	    	System.out.println("***Afficher le bilan de la banque***");
	    	afficherBilan();
	    	break;
	    }
	    case 3:
	    {
	    	System.out.println("***Effectuer une operation sur un client***");
	    	System.out.println("Choisissez le client:");
	    	for (int i=1;i<=nbClients;i++)System.out.println(" "+i+") "+clients[i].getNom());
	    	System.out.println("Votre choix:\n\t-\t");
	    	int numero=sc.nextInt();
	    	clients[numero].operation();
	    	break;
	    }
	    case 0:
	    {
	    	System.out.println("***Merci d'avoir utilisé notre systeme banquaire.***");
	    	fini=true;
	    }
	    }
	}
    }
}
  
  
