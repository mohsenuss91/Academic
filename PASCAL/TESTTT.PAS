 
program defile;
uses crt;
var espace,s:string; x:integer;
begin
clrscr;
espace:=' ';
write('Entrer le texte que vous voulez defiler');
readln(s);
clrscr;
repeat
delay(900);///pour cr�e l'effet de defilement
delline;///pour supprimer � chaque foie la ligne courante et faire avancer ta chaine de caract�re///
x:=wherex;
if x>=80 then  ///si on a atteint le nombre de colonne maximum on efface tout et on recomence la r�olution en mode texte est de 80 colonne par 25 lignes si je ne me trompe pas ///
begin
clrscr;
gotoxy(0,0);
espace:=' ';
end;
write(espace+s);
espace:=espace+'';
 
until keypressed;
end.