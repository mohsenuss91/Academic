type liste=^list;
     list=record
          fact:integer;
          puiss:integer;
          suiv:liste;
          end;
var tete,tete1,result,result1:liste;
    x:real; max:integer;



procedure creer(var tet:liste;max:integer);
var p:liste;
begin
write('entre la valeure de puiss: ');readln(tet^.puiss);
write('entre le valeure de fact quand puiss egale ',tet^.puiss,': ');
readln(tet^.fact);tet^.suiv:=nil;
while max>1 do
begin
new(p);
write('entre la valeure de puiss: ');readln(p^.puiss);
write('entre le valeure de fact quand puiss egale ',p^.puiss,': ');
readln(p^.fact);
p^.suiv:=tet;tet:=p;
max:=max-1;
end;
end;






function calcule(tet:liste;x:real):real;
var puiss1,somm:real;i:integer;
begin
somm:=0;
while tet<>nil do
begin
puiss1:=1;i:=1;
while i<=tet^.puiss do begin puiss1:=puiss1*x;i:=i+1;end;
somm:=somm+(puiss1*(tet^.fact));
tet:=tet^.suiv;
end;
calcule:=somm;
end;







procedure add(var result:liste;tet,tet1:liste);
var p:liste;test:boolean;
begin
while tet<>nil do begin
                  new(p);p^.puiss:=tet^.puiss;p^.fact:=tet^.fact;
                  p^.suiv:=result;result:=p;tet:=tet^.suiv;
                  end;
while tet1<>nil do begin
test:=false;
p:=result;
while p<>nil do begin
                if p^.puiss=tet1^.puiss then begin
                                             p^.fact:=(p^.fact)+(tet1^.fact);
                                             test:=true;
                                             end;
                p:=p^.suiv;
                end;
if(not test)then begin
                 new(p);p^.puiss:=tet1^.puiss;p^.fact:=tet1^.fact;
                 p^.suiv:=result;result:=p;
                 end;
tet1:=tet1^.suiv;
end;
end;








procedure ecrire(tet:liste);
begin
while tet<>nil do begin
                  if tet^.fact<>0 then begin
                                       if tet^.fact=1 then
                                       if tet^.puiss<>0 then
                                       if tet^.puiss=1 then write('x')
                                       else write('x^',tet^.puiss)
                                       else write('1')
                                       else if tet^.puiss<>0 then
                                       if tet^.puiss=1 then write(tet^.fact,'x')
                                       else write(tet^.fact,'x^',tet^.puiss)
                                       else write(tet^.fact);
                                       end
                  else ;
                  if tet^.suiv<>nil then if tet^.suiv^.fact>0 then write('+');
                  tet:=tet^.suiv;
                  end;
end;







procedure mult(var resul:liste;tet,tet1:liste);
var p,q,l,q1,tet12:liste; i:integer;
begin
while tet<>nil do begin
tet12:=tet1;
while tet12<>nil do begin
                   new(p);p^.puiss:=(tet^.puiss)+(tet12^.puiss);
                   p^.fact:=(tet^.fact)*(tet12^.fact);
                   p^.suiv:=resul;resul:=p;
                   tet12:=tet12^.suiv;
                   end;
tet:=tet^.suiv;
end;
while p^.suiv<>nil do begin
q:=p^.suiv;l:=p;
while q<>nil do begin
                i:=1;
                if p^.puiss=q^.puiss then begin
                                          i:=2;
                                          p^.fact:=(p^.fact)+(q^.fact);
                                          q1:=q;q:=q^.suiv;l^.suiv:=q;
                                          dispose(q1);
                                          end;
                if i=1 then begin q:=q^.suiv;l:=l^.suiv;end;
                end;
p:=p^.suiv;
end;
end;




begin
write('entre le nombre de facteur: ');readln(max);
if max>=1 then
begin
new(tete);creer(tete,max);
end
else write('erreur, la valeur de nombre de facteur doit etre supperieur ou egale 1');
write('entre la valeur de X :');readln(x);
writeln('le resultat est : ',calcule(tete,x));
writeln('entre autre polynome');
write('entre le nombre de facteur: ');readln(max);
if max<1 then write('erreur')
else
begin
new(tete1);creer(tete1,max);
end;
new(result);    result:=nil;
add(result,tete,tete1);
ecrire(result);writeln('');
new(result1); result1:=nil;
mult(result1,tete,tete1);
ecrire(result1);
readln
end.