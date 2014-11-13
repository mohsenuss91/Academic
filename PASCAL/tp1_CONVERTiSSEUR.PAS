program convertisseur;
uses crt;
var nbc,i,dec,nb,bin:longint;
choix:string;
begin
clrscr;

writeln('pour convertir du systeme decimal en binaire tapez <decbin> pour le cas inverse tapez <bindec> ');
readln(choix);
if (choix='decbin') then begin
textbackground(green);
textcolor(white);
                         writeln('entrez la valeur decimal (1023 au max)que vous voulez convertir en binaire:');
                         readln(nbc);
                         bin:=0;i:=1;
                         write('le resultat en binaire est:');
                         while(nbc>0) do begin
                                       nb:=nbc mod 2;
                                       nbc:= nbc div 2;
                                       bin:=(i*nb)+bin;
                                       i:=i*10;
                                       end;
                       write(bin);


end;
 if (choix='bindec') then begin
 textbackground(red);
textcolor(white);
                          writeln('entrez la valeur binaire(10 chiffres au max) que vous voulez convertir en decimal:');
                          readln(nbc);
                          i:=1;dec:=0;
                          write('le resultat en decimal est :');
                          while (nbc>0) do begin
                          dec:=dec+(i*(nbc mod 2));
                          i:=i*2;
                          nbc:=nbc div 10;
                          end;
                          write(dec);
                          end;
readln;
end.