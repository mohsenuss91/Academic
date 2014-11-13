#include<stdio.h>
#include <stdlib.h>

typedef struct element {
    int pri ;
    int val ;
    struct element *suiv ;
} filed ;

/* Création d'un nouvel élément */
void creation(filed *e,int pri, int val)
{
    e=(filed*)malloc(sizeof(filed*)) ;
    e->pri=pri;
    e->val=val;
    e->suiv=NULL;
}
/*afficher dune filed*/
void afficher(filed l)
{
 filed *q;
 *q=l;
 while(q!=NULL) {
 printf("Priorité %d",q->pri);
 printf("Valeur  %c",q->val);
 q=q->suiv;
                   }
}
/*insert en queu */
void emfiler(filed *l,int pe,int ve)
{    filed e,*q;
     creation(&e,pe,ve);
     if (l==NULL)  *l=e;
     else {
     q=l;
     while(q->suiv!=NULL)
     {q=q->suiv;}
     *q->suiv=e;
               }
}
/*supression de la tete*/
void defiler(filed *l,int *pd,int *vd)
{
 filed *q,*p;
 q=l;
 p=l;
 p=p->suiv;
 q->suiv=NULL;
 *pd=q->pri;
 *vd=q->val;
 free(q);
}
/*insertion en tete*/
void empiler(filed *l,int pe,int ve)
{
 filed *e,q;
 creation(e,pe,ve);
 if (l=NULL)  l=e;
 else {
 e->suiv=l;
 l=e;
     }
}
/*suppression de la tete*/
void depiler(filed *l,int *pd,int *vd)
{
 filed *q,*p;
 q=l;
 p=l;
 p=p->suiv;
 q->suiv=NULL;
 *pd=q->pri;
 *vd=q->val;
 free(q);
}
/*max pri*/
void maxpri(filed l,int *pm,int *vm)
{
 filed *q,*x;
 *q=l;
 *x=l;
 while(q!=NULL)  {
 if((q->pri)>(x->pri)) x=q;
 q=q->suiv;
           }
           *pm=x->pri;
           *vm=x->val;
 }
/*defiler par priorite*/
void defilerpri(filed *l,int *pd,int *vd)
{
     filed q,*ls,t,*p,*r;
     int vs;
     int ps;
     ls=NULL;
     p=l;
     maxpri(*l,pd,vd);
     while((p->pri!=*pd)&&(p->val!=*vd)) {
     defiler(l,&ps,&vs);
     empiler(ls,ps,vs);
     r=l;                                   }
if((r->val=*vd)&&(r->pri=*pd))  defiler(l,pd,vd);
if (ls!=NULL){
	do
	{
	depiler(ls,&ps,&vs);
	empiler(l,ps,vs);}
	while(ls!=NULL);
	}
			}
int main()
{
/*declaration des types et viables*/
filed* l,*lp;
int choix;
int prio,dp;
int vale,dv;
/*programme principal*/

l=NULL;
lp=NULL;
choix=1;
printf("\n");
printf(">L ELEMENT LE PLUS PRIORITAIRE EST CELUI QUI A LA PRIORITE LA PLUS SUPERIEUR<\n");
printf("\n");
while(choix!=0) {
printf("Entrer la valeur(un caractere):\n");
scanf("%c",&vale);
printf("Entrer la priorite(un entier):\n");
scanf("%d",&prio);
emfiler(l,prio,vale);
printf("Voulez vous ajoutez un element?  (y/n)\n");
scanf("%c",&choix);
}
printf("\n");

afficher(*l);
printf("\n");


do{
defilerpri(l,&dp,&dv);
empiler(lp,dp,dv);
}while(l!=NULL);
afficher(*lp);
getchar();
getchar();
}
