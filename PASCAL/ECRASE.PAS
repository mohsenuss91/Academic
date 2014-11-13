program ecrase;
uses crt ;
const n=4;
var t:array[1..n]of integer;
x,i:integer;
begin
clrscr;
i:=1;
while (i<=n)do begin
               readln(x);
               t[i]:=x;
               i:=i+1;
               end;
i:=1;
while(i<=n)do begin
             write(t[i],' ');
             i:=i+1;
             end;
for i:=1 to n do begin
                        readln(x);
                        t[i]:=x;
                        end;
i:=1;
while(i<=n)do begin
             write(t[i],' ');
             i:=i+1;
             end;
 readln ;
 end.
