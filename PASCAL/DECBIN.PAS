program decimaltobin;
uses crt;
type t=array[1..50]of integer;
var x,i:integer;
tab:t;
begin
clrscr;
writeln('entrez la valeur decimal que vous voulez convertir en binaire:');
readln(x);
i:=0;
while(x>0) do begin
              i:=i+1;
              tab[i]:=x mod 2;
              x:= x div 2;
              end;
writeln('le resultat en binaire est:');
while(i>0) do begin
              write(tab[i]);
              i:=i-1;
              end;
readln;
end.