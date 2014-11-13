program converter;
uses crt;
const n=25;
type t=array[1..n]of integer;
var c,x,i,y:integer;
tab:t;
choix:string;
begin
clrscr;
c:=0;
writeln('pour convertir du systeme decimal en binaire tapez "decbin" pour le cas inverse tapez"bindec"');
readln(choix);
if (choix='decbin') then begin
                         writeln('entrez la valeur decimal positive (4chiffres au max) que vous voulez convertir en binaire:');
                         readln(x);
                         i:=1;
                         writeln('le resultat en binaire est:');
                         while(x>0) do begin
                                       tab[i]:=x mod 2;
                                       x:= x div 2;
                                       i:=i+1;
                                       c:=c+1;
                                       end;

for(i):=c downto 1 do begin
                       if (tab[i]=0) or (tab[i]=1) then
                       write(tab[i]);

                       end;
end;
 if (choix='bindec') then begin
                          writeln('entrez la valeur binaire (5 chiffres au max) que vous voulez convertir en decimal:');
                          readln(x);
                          i:=1;y:=0;
                          writeln('le resultat en decimal est :');
                          while (x>0) do begin
                          y:=y+(i*(x mod 2));
                          i:=i*2;
                          x:=x div 10;
                          end;
                          write(y);
                          end;

readln;
end.