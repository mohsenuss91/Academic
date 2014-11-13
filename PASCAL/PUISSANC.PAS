program puissance ;
var n,p,s,cpt:integer;

begin
writeln('entrer le nombre puis la puissance');
readln(n,p);
cpt:=0;s:=1;
while (cpt<p) do begin
                     s:=s*n;
                     cpt:=cpt+1;
                     end;
write(n,'^',p,'=',s);
readln;
end.

