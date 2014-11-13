//specification du programme flex

%%
%class tp1flex	/*nom de la classe d'ananyseur*/
%int	/*type de la classe*/
%{
int nbV=0,nbC=0,nbP=0;	/*declaration de varialbes*/
%}
%%
/*macros if then*/
[aoeuiAOIUE] {nbV++;}	
[a-zA-Z] {nbC++;}
[.,;:] {nbP++;}
.|\n {}	/*autre*/
