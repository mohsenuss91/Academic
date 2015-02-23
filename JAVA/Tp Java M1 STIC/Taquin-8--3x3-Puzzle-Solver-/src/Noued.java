import java.util.Queue;
public class Noued {
int grille[]=new int[9];
int niveau;
Noued suiv1=null;
Noued suiv2=null;
Noued suiv3=null;
Noued suiv4=null;
Noued pred=null;

static void successeur(Noued r)
{Queue<Integer> permut;
Integer elt;
	
	permut=taquin8.Test_permut(taquin8.indice_ent(r.grille,0));
	if(permut!=null){
		
	if(!permut.isEmpty()){
		elt=permut.element();
		r.suiv1=new Noued();
		r.suiv1.pred=r;
		for(int i=0;i<9;i++){r.suiv1.grille[i]=r.grille[i];}
		r.suiv1.niveau=r.niveau+1;
	r.suiv1.grille[taquin8.indice_ent(r.suiv1.grille,0)]=r.suiv1.grille[elt];
	r.suiv1.grille[elt]=0;
	
	
	
	permut.remove();
	if(!permut.isEmpty()){
		elt=permut.element();
		r.suiv2=new Noued();
		r.suiv2.pred=r;
		for(int i=0;i<9;i++){r.suiv2.grille[i]=r.grille[i];}
		r.suiv2.niveau=r.niveau+1;
	r.suiv2.grille[taquin8.indice_ent(r.suiv2.grille,0)]=r.suiv2.grille[elt];
	r.suiv2.grille[elt]=0;
	
	

	permut.remove();
if(!permut.isEmpty()){
		elt=permut.element();
		r.suiv3=new Noued();
		r.suiv3.pred=r;
		for(int i=0;i<9;i++){r.suiv3.grille[i]=r.grille[i];}
		r.suiv3.niveau=r.niveau+1;
	r.suiv3.grille[taquin8.indice_ent(r.suiv3.grille,0)]=r.suiv3.grille[elt];
	r.suiv3.grille[elt]=0;
	
	
	permut.remove();
if(!permut.isEmpty()){
		elt=permut.element();
		r.suiv4=new Noued();
		r.suiv4.pred=r;
		for(int i=0;i<9;i++){r.suiv4.grille[i]=r.grille[i];}
		r.suiv4.niveau=r.niveau+1;
	r.suiv4.grille[taquin8.indice_ent(r.suiv4.grille,0)]=r.suiv4.grille[elt];
	r.suiv4.grille[elt]=0;
	
	
	
	permut.remove();
	
	}
	}
	}
	

	}
		
	
		
		
}else{System.out.println("\n PERMUT IS EMPTY");}
}

 
 
}





	
	