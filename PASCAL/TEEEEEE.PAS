program puissancetest;


var
a,b:integer;
function ouss(x,y:integer):integer;

begin

if(y=0)then ouss:=1
       else if (y=1)then ouss:=x

                         else ouss:=x*(ouss(x,y-1));
readln;
end;
begin
read(a,b);
writeln(ouss(a,b));
readln;
end.