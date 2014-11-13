program tabver;
uses crt;
var a,b,c:boolean;
begin
clrscr;
writeln('    a     b     c     not a or b and not c');
for a:=false to true do begin
                        for b:=false to true do begin
                                                for c:=false to true do begin
                                                                        writeln(a:7,b:7,c:7,not a or b and not c:7);
                                                                        end;
                                                end;
                          end;
readln;
end.