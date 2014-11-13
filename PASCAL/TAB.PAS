program tabzero;
uses crt;
const n=6;
var i,m:integer;
    T:array[1..n] of integer;
begin
clrscr;
i:=1;
while(i<=n) do
               begin
               readln(T[i]);
               i:=i+1;
               end;
   i:=1;
while(i<=n) do
                begin
                write(T[i],' ');
                i:=i+1
                end;
readln;
end.