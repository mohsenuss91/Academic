program convertisseur;
uses crt;
var x,i,y,nb,chiffre:longint;
choix:string;
begin
clrscr;
writeln('***ce programme est realis‚ par MOHSEN KHALDOUN***');
writeln;
writeln('pour convertir du systeme decimal en binaire tapez "decbin" pour le cas inverse tapez"bindec"');
readln(choix);
if (choix='decbin') then begin
textbackground(green);
textcolor(white);
                         writeln('entrez la valeur decimal (1023 au max)que vous voulez convertir en binaire:');
                         readln(x);
                         chiffre:=0;i:=1;
                         write('le resultat en binaire est:');
                         while(x>0) do begin
                                       nb:=x mod 2;
                                       x:= x div 2;
                                       chiffre:=(i*nb)+chiffre;
                                       i:=i*10;
                                       end;


                       write(chiffre);


end;
 if (choix='bindec') then begin
 textbackground(red);
textcolor(white);
                          writeln('entrez la valeur binaire(10 chiffres au max) que vous voulez convertir en decimal:');
                          readln(x);
                          i:=1;y:=0;
                          write('le resultat en decimal est :');
                          while (x>0) do begin
                          y:=y+(i*(x mod 2));
                          i:=i*2;
                          x:=x div 10;
                          end;
                          write(y);
                          end;
readln;
end.