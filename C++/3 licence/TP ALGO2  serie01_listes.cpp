#include<stdio.h>
/*Standard Input/Output Header: Fournit les capacités centrales d'entrée/sortie du langage C exemple scanf()*/
#include <stdlib.h>
/*l'allocation de mémoire malloc et free*/
#include <conio.h>
/*pour creer des interface utilisateur text exemple getch*/
#include <windows.h>
/*type liste*/

struct element {
    int val ;
    struct element *suiv ;
};
typedef struct element* liste;
/* Création d'un nouvel élément */
liste creation(int vval)
{    liste e = NULL ;
    e = new(element);
    if(e!=NULL) {
        e->val = vval ;
        e->suiv = NULL ;
    }
    return e ;
}

/*insert en queu */
void enfiler(liste* l,int ve)
{   liste p, e=NULL,q=NULL ;
    e=creation(ve);
    
    if(*l==NULL) {
        *l =e;
    }
    else {
        q = *l ;
       /* while(q->suiv!=NULL) q = q->suiv ;
        q->suiv = e ;*/
    if(q->suiv==NULL){q->suiv=e;}
    else {&p=l->suiv;
         enfiler(&l->suiv,ve);}   
    }
}
/*affichage croissant d'une liste*/
void affich_L_cr(liste l)
{
    element *p = l;
    if(p!= NULL)
    {
        printf("%d", p->val);
        printf("> ");
        affich_L_cr(l->suiv);
    }
}

/*affichage decroissant d'une liste*/
void affich_L_dec(liste l)
{
    element *p = l;
    if(p!= NULL)
    {
        affich_L_dec(l->suiv);
        printf("%d", p->val);
        printf("> ");
    }
}



/**************************************/
/*recherche d'un element dans une liste*/
bool rech(int x,liste l)
{
     if (l==NULL){return false;}
     else if(l->val==x){return true;}
     else {return rech(x,l->suiv);}
     }
/*suppression d'un element d'une liste*/
liste supp(liste l, int x)
{element *s ;
    if(l == NULL)
        return NULL;

    if(l->val == x)
    {

        s = l->suiv;
        free(l);
        s = supp(s,x);
        return s;
    }
    else
    {

        l->suiv = supp(l->suiv,x);
        return l;
    }
}
/*ajour d'un element x apres y dans une liste*/
void ajout_x_y(liste l,int x,int y)
{liste p;
if (l!=NULL){
             if(l->val!=y){ajout_x_y(l->suiv,x,y);}
             else{p=new(element);
                  p->val=x;
                  p->suiv=l->suiv;
                  l->suiv=p;
                  }
             }
     }
/*coloeur
0 : Noir
1 : Bleu foncé
2 : Vert foncé
3 : Turquoise
4 : Rouge foncé
5 : Violet
6 : Vert caca d'oie
7 : Gris clair
8 : Gris foncé
9 : Bleu fluo
10 : Vert fluo
11 : Turquoise
12 : Rouge fluo
13 : Violet 2
14 : Jaune
15 : Blanc */
void Color(int couleurDuTexte,int couleurDeFond) 
{
        HANDLE H=GetStdHandle(STD_OUTPUT_HANDLE);
        SetConsoleTextAttribute(H,couleurDeFond*16+couleurDuTexte);
}
/*programme principal*/

main ()
{int choix,cho,vale,cher,sup,xx,yy;
liste l=NULL;
  do {
          /*faire le choix*/
          Color(15,0);
    printf("\n");
    printf("______________________________________________\n");
      printf(" L A  L I S T E   D E S   P R O G R A M M E S\n");
       printf("______________________________________________\n");
      printf("0)- sortir.");
      printf("\n");
      Color(10,0);
      printf("1)- creation d'une liste.");
      printf("\n");
      Color(11,0);
      printf("2)- affichage croissant d'une liste.");
      printf("\n");
      Color(11,0);
      printf("3)- affichage decroissant d'une liste.");
      printf("\n");
      Color(12,0);
      printf("4)-recherche d'un element dans une liste.");
      printf("\n");
      Color(13,0);
      printf("5)- supresion d'un element dans une liste.");
      printf("\n");
      Color(14,0);
      printf("6)-ajout d'un element x apres un y dans une liste.");
      printf("\n");
      printf("\n");
      Color(15,0);
      printf("ENTRER VOTRE CHOIX : ");
      scanf("%d",&choix);
      printf("\n");
      /*travailler le choix*/
      switch(choix)
      {
       case 1: {
            Color(10,0);
            printf("\n");
           printf("***CREATION DE LA LISTE***");
      printf("\n");
         cho=1;
while(cho!=0){
printf("Entrer la valeur :\n");
scanf("%d",&vale);
enfiler(&l,vale);
printf("Voulez vous ajoutez un element?  (1 / 0)\n");
scanf("%d",&cho);
}
printf("\n");
              break;
                  }

 case 2: {
      Color(11,0);
 printf("\n");
 printf("***AFFICHAGE  CROISSANT DE LA LISTE***");
      printf("\n");
affich_L_cr(l);
printf("\n");
 break;

          }
case 3: {
     Color(11,0);
 printf("\n");
 printf("***AFFICHAGE  DECROISSANT DE LA LISTE***");
      printf("\n");
affich_L_dec(l);
printf("\n");
 break;

          }
 case 4:
 {Color(12,0);
      printf("\n");
      printf("***RECHERCHE D'UN ELEMENT DANS UNE LISTE***");
 printf("\nEntrer la valeur que vous cherchez dans la liste:\n");
scanf("%d",&cher);

if(rech(cher,l)==1){ printf("\nL'element %d existe dans la liste",cher);}
else {printf("\nL'element %d n'existe pas dans la liste",cher);}
printf("\n");
break;
     }
 case 5:
 {Color(13,0);
      printf("***SUPPRESSION D'UN ELEMENT DANS UNE LISTE***");
  printf("\nEntrer la valeur que vous voulez la supprime de la liste:\n");
scanf("%d",&sup);
l=supp(l,sup);
 
    break; }
 case 6:
 {Color(14,0);
      printf("***INSERTION D'UN ELEMENT X APRES Y DANS UNE LISTE***");
   printf("\nEntrer la valeur de X:");
scanf("%d",&xx);
  printf("Entrer la valeur de Y:");
scanf("%d",&yy);
ajout_x_y(l,xx,yy);
    break; }
		  }
		  }
      while (choix!=0);

      getch();

     }
