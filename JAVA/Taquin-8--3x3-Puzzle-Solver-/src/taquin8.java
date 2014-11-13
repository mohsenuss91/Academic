import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


//classe principale
public class taquin8 {
static int start[] = {1,2,3,4,0,5,6,7,8};
static int goal[] = {1,2,3,4,5,6,7,8,0};
	
//remplire start random	
static void rempl_rando(int t[])
{
int i=0;
boolean equals;
while(i != 9) 
{
 t[i] = (int)(Math.random()*9);
 equals = false;
    for(int j = 0; j != i; j++)
    {
        if(t[j] == t[i]) {equals = true;}
    }
if(!equals) {i++;}
}
}

//affichage d'une grille	
static void affichertab(int t[])
{
		for (int i=0;i<9;i++)
		{ 
			if ((i%3)==2){System.out.println("["+t[i]+"]");}
			else {System.out.print("["+t[i]+"]");}
		}
		
}
//rechercher l'indice d'un entier
static int indice_ent(int t[],int x)
{
int ind = 10;
for (int i=0;i<9;i++)
{ 
	if (t[i]==x) ind=i;
}

return ind;		
}
	

//Test pour les possibilites de permutaion de 0
static Queue<Integer> Test_permut(int g)
{
Queue<Integer> pp = new LinkedList<Integer>();
	
	
switch (g)
{
	case 0:
	{
		pp.add(1);
		pp.add(3);
	break;}
	
	case 1:
	{
		pp.add(0);
		pp.add(2);
		pp.add(4);
	break;}
	
	
	case 2:
	{
		pp.add(1);
		pp.add(5);
	break;}

	case 3:
	{
		pp.add(0);
		pp.add(4);
		pp.add(6);
		
	break;}
	
	case 4:
	{
		pp.add(1);
		pp.add(3);
		pp.add(5);
		pp.add(7);
		
	break;}
	
	case 5:
	{
		pp.add(2);
		pp.add(4);
		pp.add(8);
		
	break;
	}
	
	case 6:
	{
	pp.add(3);
	pp.add(7);
	break;}
	
	case 7:
	{
	pp.add(4);
	pp.add(6);
	pp.add(8);

	break;}
	
	case 8:
	{
	pp.add(5);
	pp.add(7);
	break;}
	default:{};            
	}
		
		return pp;
}
	



	
//____________________Programme Principal_______________________________
public static void main(String[] args) {
Queue<Noued> queue = new LinkedList<Noued>();
Stack<Noued> sol = new Stack<Noued>();
//remplir le tableau start aleatoirement	
taquin8.rempl_rando(start);
//creer le 1er noeud
Noued rac=new Noued();
rac.grille=start;
rac.niveau=0;
int but=0;
//mettre le premier noeud dans la frontiere
queue.add(rac);
//le compteur des noeuds visites
int com=1;

//chercher le but dans la frontiere
while((but!=1)&&(!queue.isEmpty()))
{
	Noued test=queue.element();									
	System.out.println("\n---N° "+ com++ +"---Niv:"+test.niveau);
	taquin8.affichertab(test.grille);
	//faire le test avec la liste des noeuds deja visite
										if ( Arrays.equals(test.grille,goal) )
										{
											System.out.println("GOAAAAAAL");
											but=1;
											//noeud but trouve et ajoute a la pile sol
											sol.push(test);
										}
										
										//generer les successeurs du noeud et les mettre dans la frontiere
										else{
												Noued.successeur(test);
												if(test.suiv1!=null)
												{
													if(test.pred!=null)
													{
														if(!Arrays.equals(test.pred.grille,test.suiv1.grille)){queue.add(test.suiv1);}	
													}else{queue.add(test.suiv1);}
												}
												
												
												
												if(test.suiv2!=null)
												{
													if(test.pred!=null)
													{
														if(!Arrays.equals(test.pred.grille,test.suiv2.grille)){queue.add(test.suiv2);}	
													}else{queue.add(test.suiv2);}
												}
												if(test.suiv3!=null)
												{
													if(test.pred!=null)
													{
														if(!Arrays.equals(test.pred.grille,test.suiv3.grille)){queue.add(test.suiv3);}	
													}else{queue.add(test.suiv3);}
												}
												if(test.suiv4!=null)
												{
													if(test.pred!=null)
													{
														if(!Arrays.equals(test.pred.grille,test.suiv4.grille)){queue.add(test.suiv4);}	
													}else{queue.add(test.suiv4);}
												}
											}
										
//supprimer le noeud teste de la frontiere
queue.remove();
}

Noued deps=sol.pop();

//empiler le chemin de la solution
while(deps!=null)
{					
sol.push(deps);
deps=deps.pred;
}



//afficher la solution
int j=0;
System.out.println("\n** S O L U T I O N **");
while(!sol.isEmpty())
{
System.out.println("\n___-"+ j++ +"-___");
taquin8.affichertab(sol.pop().grille);	
}


	}
}