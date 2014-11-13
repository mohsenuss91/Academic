program somepolynome;
uses crt;
type pntr=^liste;
     liste=record
          puiss:integer;
          fac:integer;
          suiv,prec:pntr;
          end;
var nbe1,nbe2,i,p,n,point,r,nbp,j:integer;
       l,tete1,tete2,q,c:pntr;

{procedure pour la creation du polynome}
procedure creation(var tete:pntr;nbe:integer);
var i,p,n:integer;
l,q:pntr;
begin

new(tete);
for i:=1 to nbe do begin
				writeln;
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
write('polynome: ');
while (q^.prec<>nil) do begin
write(' + ',q^.fac,'x^',q^.puiss);
q:=q^.prec;

end;
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
{PROCEDURE SOMME}


begin
clrscr;
{la creation du polynome}
write('le nombre d`elemets de 1er polynome est: ');
read(nbe1);
creation(tete1,nbe1);
writeln;
write('le nombre d`elemets de 2eme polynome est: ');
read(nbe2);
creation(tete2,nbe2);



{somme de polynome}

readln;
readln
end.
