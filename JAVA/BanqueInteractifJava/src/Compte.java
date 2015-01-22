class Compte {
	private int numero ; //le numero du compte
    private double solde = 0;//le solde du compte
    
    /*Faire un depot sur le compte*/
    public void depot(double valeur) 
    {
	if (valeur>0){solde=solde + valeur;}
	else {System.out.println("Le montant est négatif");}
    }
    
    /*Faire un retrait sur le compte*/
    public void retrait(double valeur) 
    {
	if ((valeur>0)&&(this.solde>valeur))
	{solde=solde - valeur;
	}
	else{
		if(valeur<0){System.out.println("Attention, le montant est negative");}
		if(this.solde<valeur){System.out.println("Votre solde est inferieur au montant");}
		
		}
    }
    
    /*Obtenir la valeur du solde*/
    public double getSolde() 
    {
	return this.solde;
    }
    
    /*Obtenir la numero du compte*/
    public int getNum() 
    {
	return this.numero;
    }
    
    /* numero du compte*/
    public void SetNum(int num) 
    {
	this.numero=num;
    }
    
    
    /*Afficher le solde*/
    public void afficherSolde() 
    {
	System.out.println("Le solde du compte N°"+this.getNum()+ " est de "+solde+"DA");
    }
    
    /*Faire un virement d'un compte a un autre*/
    public void virer(double value,Compte destinataire) 
    {
    	double comps=this.getSolde();
    	if (value>0) 
    	{
    		retrait(value);	
    		if(value<comps) destinataire.depot(value);
	    
    	}else{System.out.println("Attention, Le montant est negartif");}
    }
}

