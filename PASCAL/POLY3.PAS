program polynome;
uses crt;
type pntr=^liste;
     liste=record
          puiss:integer;
          fac:integer;
          suiv,prec:pntr;
          end;
var x,x2,poly,nb,nbe,i,p,n:integer;
       l,tete,q,c:pntr;


procedure creation(nbe:integer);
var i,p,n:integer;
tete,l,q:pntr;
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
write('le polynome: ');
while (q^.prec<>nil) do begin
write(' + ',q^.fac,'x^',q^.puiss);
q:=q^.prec;
end;
end;

begin
clrscr;
{la creation du polynome}
write('le nombre d`elemets de ce polynome est: ');
read(nbe);
creation(nbe);
writeln;

{le calcul du resultat a partir d`un point donn‚}

readln;
readln
end.
