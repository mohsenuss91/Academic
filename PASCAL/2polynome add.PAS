program ccpolynome;
uses crt;
type polynome=^monome;
     monome=record
          puiss:integer;
          fac:integer;
          suiv,prec:polynome;
          end;
var nbe1,nbe2:integer;
       p1,p2,p3:polynome;



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
{SOMME3}
function add(var p1:polynome;var p2:polynome):polynome;
var q1,q2,p,r:polynome;
begin
q1:=p1;
while(q1^.suiv<>nil)do q1:=q1^.suiv;
q1^.suiv:=p2;
p2^.prec:=q1;
q1:=p1;
q2:=q1^.suiv;
while(q1<>nil)do begin
while(q2<>nil)do begin
if(q1^.puiss<>q2^.puiss)then q2:=q2^.suiv
else begin
r:=q2;
q2:=r^.suiv;
p:=r^.prec;
q1^.fac:=(q1^.fac)+(r^.fac);
q2^.prec:=p;
p^.suiv:=q2;
dispose(r);
end;
end;
q1:=q1^.suiv;
q2:=q1^.suiv;
end;
add:=p1;
end;

begin
clrscr;
write('le nombre d`elemets du 1er polynome est: ');
read(nbe1);
creation(p1,nbe1); 
affichage(p1);
writeln;
write('le nombre d`elemets du 2eme  polynome est: ');
read(nbe2);
creation(p2,nbe2);
affichage(p2);
writeln;
p3:=add(p1,p2);
writeln('le resultat de laddition de polynomes est= ');
affichage(p3);
readln;
readln
end.
