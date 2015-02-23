#include<stdio.h>
/*Standard Input/Output Header: Fournit les capacités centrales d'entrée/sortie du langage C exemple scanf()*/
#include <stdlib.h>
/*Pour exécuter diverses opérations dont la conversion, la génération de nombres pseudo-aléatoires, l'allocation de mémoire, le contrôle de processus, la gestion de l'environnement et des signaux, la recherche et le tri.*/
#include <conio.h> 
/*pour creer des interface utilisateur text exemple getch*/

/*serie1_exo1_puissance nieme d'un nombre_1ere partie*/
float puissance(float x,int n)
{
     if (n==0) {return 1;}
     else {return x*puissance(x,n-1);}
}
/*serie1_exo1__puissance nieme d'un nombre_2ere partie*/
float puissance2(float x,int n)
{float t;
       if (n==0){t=1;}
       else {t=puissance(x,(n/2));
      	if (n%2==0){t=t*t;}
		else {t=x*t*t;}
		}
  return t;
}
/*serie1_exo2_conversion numerique*/
long convertion_base_dix(long n,long b)
{long q,r;
      q=n/10;
      r=n%10;
      if(q==0){return r;}
      else {return ((convertion_base_dix(q,b)*b)+r);}
}
/*convertion de la base dix vers une autre base*/
long convertion(long n,long b)
{
char chiffre[]="0123456789ABCDEF";
long q=n/b;
long r=n % b;
if (q!=0) {convertion(q,b);}
printf("%c",chiffre[r]);
}
/*tour de hanoi*/
/*programme principal*/
void hanoi(int n,int i,int j)
{int inter=6-(i+j);
if (n>0)
{
        hanoi((n-1),i,inter);
printf("%d -> %d\n",i,j);
hanoi((n-1),inter,j);


}
     }
main ()
{long nb,n,choix,b;

      do {
          /*faire le choix*/
    printf("\n");
    printf("______________________________________________\n");
      printf(" L A  L I S T E   D E S   P R O G R A M M E S\n");
       printf("______________________________________________\n");
      printf("- Puissance1 (1)");
       printf("\n");
      printf("- Puissance2 (2)");
       printf("\n");
        printf("- Convertion vers la base dix (3)");
       printf("\n");
       printf("- Convertion de la base dix vers une autre base (4)");
       printf("\n");
       printf("- Tour de hanoi (5)");
       printf("\n");
      printf("- Sortir (0)");
      printf("\n");
      printf("\n");
      printf("ENTRER VOTRE CHOIX : ");
      scanf("%d",&choix);
      printf("\n");
      /*travailler le choix*/
      switch(choix)
          {
          /*puissance1*/
                   case 1: {
              printf("*** P U I S S A N C E  1 ***\n");
                printf("ENTREZ LE NOMBRE!: ");
      scanf("%d",&nb);
      printf("ENTREZ LA PUISSANCE!: ");
      scanf("%d",&n);
                  printf("= %f",puissance(nb,n));
                  break;
                  }
      /*puissance2*/
          case 2: {
              printf("*** P U I S S A N C E  2 ***\n");
              printf("ENTREZ LE NOMBRE!: ");
      scanf("%d",&nb);
      printf("ENTREZ LA PUISSANCE!: ");
      scanf("%d",&n);
                 printf("= %f",puissance2(nb,n));
          break;
                  }
          /*convertion a la base dix*/
                  case 3: {
              printf("*** C O N V E R T I O N  B A S E  D I X ***\n");
              printf("ENTREZ LE NOMBRE!: ");
      scanf("%d",&nb);
      printf("ENTREZ LA BASE!: ");
      scanf("%d",&n);
    
                 printf("= %d ",convertion_base_dix(nb,n));
          break;
                  }
				  case 4: {
				   printf("*** CONVERTION DE LA BASE DIX VERS UNE AUTRE BASE *** \n ");
       printf("ENTREZ LE NOMBRE!: ");
      scanf("%d",&nb);
      printf("ENTREZ LA BASE!: ");
      scanf("%d",&n);
               printf("",convertion(nb,n));
          break;
                  }
				  case 5: {
				  printf("*** TOUR DE HANOI***\n");
				   printf("ENTREZ LE NOMBRE DE DISQUES!: ");
      scanf("%d",&nb);
      printf("ENTREZ LE DEBUT: ");
      scanf("%d",&n);
      printf("ENTREZ LE BUT: ");
      scanf("%d",&b);
      hanoi(nb,n,b);
				  
              
          break;
                  }
                  ;
          };
          }
      while (choix!=0);
      getch();

     }
