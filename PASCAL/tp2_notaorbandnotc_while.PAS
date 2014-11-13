program tabdeverwhile;
uses crt;
var a,b,c:boolean;
begin
clrscr;



writeln('il donne le resultat de l expression booleenne NOT A OR B AND NOT C ');
writeln('avec la boucle WHILE');
textbackground(green);
textcolor(white);
writeln('++++++++++++++++++++++++++++++++++++++++++++++++');
writeln('+    a      b      c    not a or b and not c   +');
writeln('++++++++++++++++++++++++++++++++++++++++++++++++') ;
a:=false;
while a<=true do begin
b:=false;
while b<=true do begin
c:=false;
while c<=true do begin
 writeln('+',a:7,b:7,c:7,not a or b and not c:7,'                  +');
 c:=succ(c);
 end;
 b:=succ(b);
 end;
 a:=succ(a);
 end;
writeln('++++++++++++++++++++++++++++++++++++++++++++++++') ;
readln;
end.