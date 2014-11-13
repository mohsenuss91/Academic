program ccpolynome;
uses crt;
type polynome=^monome;
     monome=record
          puiss:integer;
          fac:integer;
          suiv,prec:polynome;
          end;
var nbe,i,p,n,point,r,y:integer;
       l,tete,q,c,pol,v,mini:polynome;
{ minimum}
function min(l:polynome):polynome;
var q,m:polynome;
i:integer;
begin
q:=l;
new(m);
m^.puiss:=q^.puiss;
m^.fac:=q^.fac;
while(q<>nil) do begin
if((q^.puiss)<(m^.puiss)) then begin
								m^.puiss:=q^.puiss;
								m^.fac:=q^.fac;
								end;
q:=q^.suiv;
end;
min:=m;
end;

{function recherche le poly qui a la puiss minimum pour le suprimé arpes le tri}

function rechpmin(l:polynome;x:integer):polynome;
var p,q:polynome;
begin
q:=l;
while q<>nil do begin
				if x=q^.puiss then p:=q;
				q:=q^.suiv;
				end;
rechpmin:=p;
end;
{PROCEDURE tripolynome}
procedure tri(var l:polynome);
var m,r,p,l2,precedent,suivant:polynome;
begin
l2:=nil;
repeat begin
m:=min(l);;
r:=rechpmin(l,m^.puiss);
q:=l;new(p);
p^.puiss:=m^.puiss;
p^.fac:=m^.fac;
precedent:=r^.prec;
suivant:=r^.suiv;
precedent^.suiv:=suivant;
suivant^.prec:=precedent;
l2:=p;
p^.suiv:=l2;
p^.prec:=p;
end
until (q=nil);
end;

{procedure pour la creation du polynome}
procedure creation(var tete:polynome;nbe:integer);
var i:integer;
l:polynome;
begin
for i:=1 to nbe do begin
                 new(l);
                 write('Le facteur du ',i, 'eme element svp est: ');
                 read(l^.fac);
                 write('La puissance du ',i,'eme element svp est: ');
                 read(l^.puiss);
                 l^.suiv:=tete;
				 tete^.prec:=l;
                 tete:=l;
                 end;

end;
{procedure pour afficher le polynome cree}
procedure affichage (tete:polynome);
var q:polynome;
begin
q:=tete;
while q^.suiv<>nil do q:=q^.suiv;
writeln;
write('le polynome= ');
while (q<>nil) do begin
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
function calcul(var tete:polynome;y:integer):integer;
var nb,puissa,poly,t,elem:integer;
    c:polynome;
begin
poly:=0;
c:=tete;
while(c<> nil) do begin

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
procedure addition(var result:polynome;tet1,tet2:polynome);
var p:polynome;test:boolean;
begin
while tet1<>nil do begin
                  new(p);
				  p^.puiss:=tet1^.puiss;
				  p^.fac:=tet1^.fac;
                  p^.suiv:=result;
				  result:=p;
				  tet1:=tet1^.suiv;
                  end;
while tet2<>nil do begin
test:=false;
p:=result;
while p<>nil do begin
                if p^.puiss=tet2^.puiss then begin
                                             p^.fac:=(p^.fac)+(tet2^.fac);
                                             test:=true;
                                             end;
                p:=p^.suiv;
                end;
if(not test)then begin
                 new(p);
				 p^.puiss:=tet2^.puiss;
				 p^.fac:=tet2^.fac;
                 p^.suiv:=result;
				 result:=p;
                 end;
tet1:=tet2^.suiv;
end;
end;

begin
clrscr;
{la creation du polynome}
write('le nombre d`elemets de ce polynome est: ');
read(nbe);
creation(tete,nbe);
affichage(tete);
mini:=min(tete);
y:=mini^.puiss;
v:=rechpmin(tete,y);
writeln;
writeln('la puiss min de poly (',y,') dans le facteur est (',v^.fac,')');
{le calcul du resultat a partir d`un point donne}
writeln;
write('entrer la valeur du point: ');
read(point);
r:=calcul(tete,point);
writeln('le point: <',point,'>  le resultat: ',r);
readln;
readln
end.
