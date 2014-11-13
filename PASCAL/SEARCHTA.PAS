program search;
uses crt;
const n=6;
var t:array [1..n] of integer;
    i,x:integer;
begin
clrscr;
i:=1;
while (i<=n) do begin
                write('entrer un entier');
                readln(t[i]);
                i:=i+1;
                end;
i:=1;
write('quel element vous rehcrechez !');
readln(x);
while(t[i]<>0) and (i<=n) do i:=i+1;
if (i<=n) then writeln('existe') else write('nexiste pas dans le tableau suivant',' ');
i:=1;
while (i<=n) do begin
                write(t[i],' ');
                i:=i+1;
                end;
readln;
end.