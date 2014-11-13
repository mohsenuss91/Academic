program bindec;
uses crt;
var i,x,y:integer;
begin
clrscr;

writeln('entrez la valeur binaire que vous voulez convertir en decimal:');
readln(x);
i:=1;
y:=0;
writeln('le resultat en decimal est:');
while(x>0) do begin
              y:=y+(i*(x mod 2));
              i:=i*2;
              x:=x div 10;
              end;
write(y);
readln;
end.