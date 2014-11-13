program diez;
uses crt;
type
    chiffre=array[1..10]of integer;
var chaine:string;
    bd,db,bin,num:chiffre;
    rep:boolean;
    i,l,m,n,k,h,e,b,c,d,g:integer;
begin
clrscr;

writeln;
writeln('entrez votre chaine de caractere suivi de #');
writeln( 'appuyez sur la touche <ENTRER> a chaque fois ');
readln(chaine);
i:=1;
while(chaine[i]<>'#')do begin
b:=0; c:=0; rep:=false;
while(rep=false)and(b<11)and(chaine[i]<>'#')do begin
if(chaine[i]>='0')and(chaine[i]<='9')then begin
b:=b+1;
val(chaine[i],num[b],g);
if(chaine[i+1]>='0')and(chaine[i+1]<='9')then rep:=false else rep:=true;
c:=c+1;
end;
i:=i+1;
end;
d:=b;
if(c<>0)then begin
e:=4;
for b:=1 to d do if(num[b]>=2)and(num[b]<=9)then e:=5;
if(e=5)then begin
for b:=1 to d do bd[b]:=num[b];
k:=1; h:=45;
while(h<>0)do begin
              bin[k]:=num[d]mod 2;
              for b:=1 to d do db[b]:=num[b];
              num[1]:=num[1]div 2;
              for b:=2 to d do num[b]:=(num[b]+((db[b-1]mod 2)*10))div 2;
              h:=0;
              for b:=1 to d do h:=h+num[b];
              k:=k+1;
              end;
l:=k-1;
write('la valeur DECIMAL est :');
for b:=1 to d do write(bd[b]);
write('>>> la valeur binaire est: ');
for k:=10 downto 1 do write(bin[k]);
end;
if(e=4)then begin
m:=1; n:=0;
for b:=d downto 1 do begin
                     n:=n+(num[b]*m);
                     m:=m*2;
                     end;
                     write('la valeur BINAIRE est: ');
for b:=1 to d do write(num[b]);
write('>>> la valeur decimal est: ',n) ;
end;
end;
readln;
end;
writeln('la convvertion est finie!');
readln
end.