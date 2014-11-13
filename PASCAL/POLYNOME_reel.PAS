program ccpolynome;
uses crt;
type polynome=^monome;
     monome=record
          puiss:real;
          fac:real;
          suiv,prec:polynome;
          end;
var nbe,point,nbe1,nbe2,prog:integer;
       p1,p2,p3:polynome;
       r:real;
{la creation du polynome}
procedure creation(var tete:polynome;nbe:integer);
var i:integer;
l,q:polynome;
begin
q:=nil;
for i:=1 to nbe do begin
                 new(l);
                 write('Le facteur du ',i, 'eme element svp est: ');
                 read(l^.fac);
                 write('La puissance du ',i,'eme element svp est: ');
                 read(l^.puiss);
				 q^.suiv:=l;
				 l^.prec:=q;
                 q:=l;
                 end;
while(q^.prec<>nil) do q:=q^.prec;
tete:=q;
end;
{afficher le polynome cree}
procedure affichage (tete:polynome);
var q:polynome;
begin
q:=tete;
writeln;
write('le polynome = ');
while (q<>nil) do begin
write('  +',q^.fac,' X^',q^.puiss);
q:=q^.suiv;
end;
end;
{puissance}
function puissance(n:real;p:real):real;
var s,cpt,t:real;
begin
s:=1;cpt:=0;
while (cpt<(abs(p))) do begin
                     s:=s*n;
                     cpt:=cpt+1;
                     end;
if (p<0) then puissance:=(1/s)
else puissance:=s;
end;
{calculer le resultat a partir dun point donnè}
function calcul(var tete:polynome;y:integer):real;
var
elem,t,poly,nb,puissa:real;
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
{SOMME}
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
{mulTIPLICATION}
function mul(var p1:polynome;var p2:polynome):polynome;
var q1,q2,p3,p4,y:polynome;
begin
q1:=p1;while(q1^.suiv<>nil)do q1:=q1^.suiv;
q2:=p2;while(q2^.suiv<>nil)do q2:=q2^.suiv;
p3:=nil;
p4:=nil;
while(q1<>nil)do begin
while(q2<>nil)do begin
new(y);
y^.puiss:=q1^.puiss+q2^.puiss;
y^.fac:=q1^.fac*q2^.fac;
p3^.suiv:=y;
y^.prec:=p3;
p3:=y;
q2:=q2^.prec;
end;
p4:=add(p3,p4);
q2:=p2;
p3:=nil;
q1:=q1^.prec;
end;
mul:=p4;
end;
begin
clrscr;
writeln('(1): calcule dun polynome en un point X donne');
writeln('(2): somme de deux polynomes ');
writeln('(3): produit de deux polynomes');
writeln('  __________________________  ');
write('vieller enter votre choix: ');
read(prog);
case prog of
1:begin
write('le nombre d`elemets de ce polynome est: ');
read(nbe);
creation(p1,nbe);
affichage(p1);
writeln;
write('entrer la valeur du point: ');
read(point);
r:=calcul(p1,point);
writeln('le point: <',point,'>  le resultat: ',r);
readln;
readln
end;
2:begin
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
end;
3:begin
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
p3:=mul(p1,p2);
writeln('le resultat de la multiplication de polynomes est= ');
affichage(p3);
readln;
readln
end;
else begin
writeln('Desole!!! votre choix est incorrect!!!');
readln
end;
end;
end.
