program ccpolynome;
uses crt;
type pntr=^liste;
     liste=record
          puiss:integer;
          fac:integer;
          suiv,prec:pntr;
          end;
var nbe1,nbe2:integer;
       p1,p2:pntr;

{procedure pour la creation du polynome}
procedure creation(var tete:pntr;nbe:integer);
var i,p,n:integer;
l,q:pntr;
begin

new(tete);
for i:=1 to nbe do begin
                 write('Le facteur du ',i, 'eme element svp est: ');
                 read(n);
                 write('La puissance du ',i,'eme element svp est: ');
                 read(p);
                 tete^.fac:=n;
                 tete^.puiss:=p;
                 new(l);
                 l^.suiv:=tete;
                 tete^.prec:=l;
                 tete:=l;
                 end;
q:=tete;
while (q^.suiv <> nil) do q:=q^.suiv;
writeln;
write('le polynome= ');

while (q^.prec<>nil) do begin
write(' + ',q^.fac,'x^',q^.puiss);
q:=q^.prec;
end;
writeln;
end;
{fonction puissance}
function puissance(n:integer;p:integer):integer;
var s,cpt:integer;

begin
cpt:=0;s:=1;
while (cpt<p) do begin
                     s:=s*n;
                     cpt:=cpt+1;
                     end;
puissance:=s;
end;


{une fonction pour calculer le resultat a partir dun point donnè}
function calcul(var tete:pntr;y:integer):integer;
var nb,puissa,poly,t,elem:integer;
    c:pntr;
begin
poly:=0;
c:=tete;
while(c <> nil) do begin

                         nb:=c^.fac;
                         puissa:=c^.puiss;
			 t:=puissance(y,puissa);
			 elem:=nb*t;
			 poly:=poly+elem;
                         c:=c^.suiv;


			 end;
calcul:=poly;
end;
{PROCEDURE tripolynome}
procedure tripolynome (var p:pntr);
begin
end;

{PROCEDURE SOMME}
function somme(s1:pntr;s2:pntr):pntr;
var result:pntr;
begin
end;

begin
clrscr;
{la creation du polynome}
write('le nombre d`elemets du 1er polynome est: ');
read(nbe1);
creation(p1,nbe1);
writeln;
write('le nombre d`elemets du 2eme  polynome est: ');
read(nbe2);
creation(p2,nbe2);



{somme de polynome}

readln;
readln
end.
