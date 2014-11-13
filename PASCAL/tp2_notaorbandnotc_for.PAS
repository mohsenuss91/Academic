program tabdeverfor;
uses crt;
var a,b,c:boolean;

begin
clrscr;

writeln('il donne le resultat de l expression booleenne NOT A OR B AND NOT C ');
writeln('avec la boucle FOR');
textbackground(blue);
textcolor(yellow);
writeln('++++++++++++++++++++++++++++++++++++++++++++++++');
writeln('+     a      b      c    not a or b and not c  +');
writeln('++++++++++++++++++++++++++++++++++++++++++++++++') ;

for a:=false to true do begin
 for b:=false to true do begin
  for c:=false to true do begin
 writeln('+ ',a:7,b:7,c:7,not a or b and not c:7,'                 +');

 end;
 end;
 end;
writeln('++++++++++++++++++++++++++++++++++++++++++++++++') ;
readln;
end.