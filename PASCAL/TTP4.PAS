program ttp4;
uses crt;
const n=10;
var i:integer;
    t:array[1..n]of char;
begin
clrscr;
i:=1;
repeat begin
       read(t[i]);
       i:=i+1;
       end;
until (t[i]='#') or (i=n);

writeln('vous avez entrer:');
for (i):=1 to n do begin
                 write(t[i]);
                 end;
readln;
end.