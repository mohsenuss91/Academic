program polynome;

type poly=record
          puiss:integer;
          facteur:integer;
          suiv:^poly;
          end;
var q,t,p:poly;
    i,x,r:integer;
    choix:boolean;
usescrt;
begin
clrscr;
new(p);
t:=p;
choix:=t;
q:=p;
while(choix<>f)do begin
                  read(p.puiss);
                  read(p.facteur);
                  write(`existe til un autre:`);read(choix);
                  new(p);
                  q^.suiv:=p;
                  end;
write(`la valeur de X est?`);read(x);
if (choix=f)then begin
                 while(t=f)do begin
                              r:=x*n;
                              for i:=1 to (t.puiss) do n:=x*i;
                              end;
write(`le resultat est: `,r);
readln;
end.



