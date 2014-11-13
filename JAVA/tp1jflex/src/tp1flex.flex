//specification du programme flex
%%
%class tp1flex	/*nom de la classe d'ananyseur*/
%int	/*type de la classe*/
%{
int nbV=0,nbC=0,nbP=0;	/*declaration de varialbes*/
%}
%%
/*regles*/
[aoeuiAOIUE] {nbV++;}/*voyelles*/
[a-zA-Z] {nbC++;}/*consonnes*/
[.,;:] {nbP++;}/*ponctuations*/
.|\n {}	/*autre*/
