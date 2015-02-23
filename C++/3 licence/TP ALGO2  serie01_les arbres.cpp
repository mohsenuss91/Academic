 
#include<stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <windows.h>
/*type liste*/
 
struct noeud {
  int val;
  struct noeud *g;
  struct noeud *d;
};
typedef struct noeud *ab;
/*creation dun neoud*/
ab creat(int v, ab ls, ab rs)
{
  ab res;
 
  // malloc renvoie un pointeur sur un espace mémoire
  // dont la taille est fournie en paramètre.
  // Tu veux créer de la place pour un noeud et malloc
  // renvoie un pointeur sur cet espace.
  // C'est à priori le seul endroit où tu vas utiliser
  // struct noeud
  res = (ab) malloc(sizeof(struct noeud));
 
  if (res == NULL) {
    fprintf(stderr, "Impossible d'allouer le noeud");
    return NULL;
  }
 
  res->val = v;
  res->g = ls;
  res->d = rs;
 
  return res;
}
 
/*ajout dun element dans un ab*/
// Avec cette version toutes les modifications
// que tu vas faire sur r seront perdues au
// retour de la fonction
// si tu as :
// r=NULL;
// ajout_old(r, 1);
// ici r sera toujours NULL
// pour modifier la valeur de r il faut réecrire
// la fonction avec pour paramètre un pointeur 
// sur r, donc de type ab*
// Comme tu fais pour scanf par exemple
void ajout_old(ab r, int elt)
{
  if (r == NULL) {
    r = creat(elt, NULL, NULL);
  } else if (r->g == NULL) {
    r->g = creat(elt, NULL, NULL);
  } else if (r->d == NULL) {
    r->d = creat(elt, NULL, NULL);
  } else {
    ajout_old(r->g, elt);
  }
}
 
// ici pr est un pointeur sur un ab
// si le pointeur est NULL il doit y avoir une
// erreur
// si le pointeur pointe sur NULL = arbre vide
// j'ai sur parenthésé pour que tu vois
// ce qui est manipulé
void ajout(ab* pr, int elt)
{
  if (pr==NULL) {
    printf("Erreur.");
    exit(1);
  } else if ((*pr)==NULL)
    *pr=creat(elt,NULL,NULL);
  else if ((*pr)->g==NULL)
    (*pr)->g=creat(elt,NULL,NULL);
  else if ((*pr)->d==NULL)
    (*pr)->d=creat(elt,NULL,NULL);
  else
    // remarque que je passe l'adresse du 
    // fils gauche
    ajout( &((*pr)->g), elt);
}
 /*affichage dun ab*/
void affichage_rgd(ab n)
{
  if (n != NULL) {
  printf(" [");
  printf("%d", n->val);
    affichage_rgd(n->g);
    affichage_rgd(n->d);
    printf("] ");
  }
}
 
/*affichage dun ab*/
void affichage_grd(ab n)
{
  if (n != NULL) {
  printf(" [");
    affichage_grd(n->g);
    printf("%d", n->val);
    affichage_grd(n->d);
    printf("] ");
  }
}
 /*affichage dun ab*/
void affichage_gdr(ab n)
{
  if (n != NULL) {
  printf(" [");
    affichage_gdr(n->g);
    affichage_gdr(n->d);
    printf("%d", n->val);
    printf("] ");
  }
}
 /*taille dun arbre binaire*/
 int taille (ab r)
 {if(r==NULL){return 0;}
 else {return 1+taille(r->g)+taille(r->d);}
     }
 /*nombre de feilles*/
 unsigned nbf(ab r)
{
	if(r==NULL)
		{return 0;}
	else if ((r->g==NULL)&&(r->d==NULL))
		{return 1;}
	else
		{return nbf(r->g)+nbf(r->d);}
}
/*tester si larbrbre nest pas degenere*/
bool notdeg(ab r)
{
     if(r==NULL) {return true;}
     else if((r->g==NULL)&&(r->d==NULL)) {return false;}
     else if((r->g!=NULL)&&(r->d!=NULL)) {return true;}
     else {return notdeg(r->g)&& notdeg(r->d) ;}
     }
/*tester legalite de dexu ab*/
bool egal(ab r1, ab r2)
{
if((r1==NULL)&&(r2==NULL)) {return true;}
else if ((r1==NULL)||(r2==NULL)) {return false;}
else if (r1->val!=r2->val){return false;}
else { return (egal(r1->g,r2->g)&&egal(r1->d,r2->d));}
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
 
main()
{
  int choix,cho,cho1,cho2,x,x1,x2;
  ab r1=NULL,r2=NULL,a = NULL;
  do {
    /*faire le choix */
    printf("\n");
    printf("______________________________________________\n");
      printf(" L A  L I S T E   D E S   P R O G R A M M E S\n");
       printf("______________________________________________\n");
       Color(10,0);
      printf("1)- Creation d'un arbre binaire.");
      printf("\n");
       Color(11,0);
    printf("2)- Affichage_rgd d'un arbre binaire.");
    printf("\n");
     Color(11,0);
    printf("3)- Affichage_grd d'un arbre binaire.");
    printf("\n");
     Color(11,0);
    printf("4)- Affichage_gdr d'un arbre binaire.");
    printf("\n");
     Color(12,0);
    printf("5)- La taille d'un arbre binaire.");
    printf("\n");
     Color(13,0);
    printf("6)- Le nombre de feuille d'un arbre binaire.");
    printf("\n");
     Color(14,0);
    printf("7)- Testet si l'arbre binaire n'est pas degenere.");
    printf("\n");
     Color(7,0);
    printf("8)- Tester l'egalite de deux arbres binaires.");
    printf("\n");
    printf("\n");
     Color(15,0);
    printf("ENTRER VOTRE CHOIX : ");
    scanf("%d", &choix);
    printf("\n");
    /*travailler le choix */
    switch (choix) {
    case 1:{ Color(10,0);
        cho = 1;
        while (cho != 0) {
          printf
              ("Entrer la valeur pour l'inserer dans l'arbre:\n");
          scanf("%d", &x);
          ajout(&a, x);
          printf
              ("Voulez vous ajoutez un element?  (1 / 0)\n");
          scanf("%d", &cho);
        }
        printf("\n");
 
        break;
      }
 
    case 2:{ Color(11,0);
        printf("**AFFICHAGE  RGD DE L'ARBRE**\n");
        affichage_rgd(a);
        break;
 
      }
  case 3:{ Color(11,0);
        printf("**AFFICHAGE  GRD DE L'ARBRE**\n");
        affichage_grd(a);
        break;
 
      }
       case 4:{ Color(11,0);
        printf("**AFFICHAGE  GDR DE L'ARBRE**\n");
        affichage_gdr(a);
        break;
 
      }
      case 5:{ Color(12,0);
           printf("**LA TAILLE DE L'ARBRE**\n");
            printf("= %d",taille(a));
           }
      case 6:{ Color(13,0);
           printf("**NOMBRE DE FEILLES DE L'ARBRE**\n");
            printf("= %d",nbf(a));
            break;
           }
           
     case 7:{ Color(14,0);
           printf("**L' ARBRE BINAIRE N'EST PAS DEGENERE**\n");
           if(notdeg(a)==true) {printf(": vrai");}
           else {printf(": faux");}
            break;
           }      
     case 8:{ Color(7,0);
           printf("**TESTER L'EGALITE DE DEUX ARBRES BINAIRES**\n");
           printf("\n");
           printf("<<Creation de R1>>\n");
            cho1 = 1;
        while (cho1 != 0) {
          printf
              ("Entrer la valeur pour l'inserer dans l'arbre R1:\n");
          scanf("%d",&x1);
          ajout(&r1,x1);
          printf
              ("Voulez vous ajoutez un element?  (1 / 0)\n");
          scanf("%d",&cho1);
        }
         printf("<<Creation de R2>>\n");
              cho2 = 1;
         printf("\n");     
        while (cho2 != 0) {
          printf
              ("Entrer la valeur pour l'inserer dans l'arbre R2:\n");
          scanf("%d", &x2);
          ajout(&r2, x2);
          printf
              ("Voulez vous ajoutez un element?  (1 / 0)\n");
          scanf("%d", &cho2);
        }
         printf("R1 et R2 sont egaux: ");
       if (egal(r1,r2)!=true) printf("Faux");
       else printf("Vrai");
         break;
          }  
           
    }
 
  } while (choix != 0);
 
//  getch();
 
}

