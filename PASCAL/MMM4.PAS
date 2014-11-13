program tttp4t;
uses crt;
const n=25;
var c:char;
    chiff,indice,i,k,z,bin,dec,u,s,h,x,l,m,o,p:integer;
g:array[1..n]of char;
puiss,num,result:array[1..10]of integer;
begin
clrscr;
k:=1;
writeln('entrer les caracteres un par un en appuyant sur la touche entre a chaque fois sans laisser des cases vides');
repeat begin
       readln(c);
       g[k]:=c;
       k:=k+1;
       end;
until(c='#')or(k=n);
writeln('la chaine de caracteres que vous avez entrer est :');
for k:=1 to n do begin
                   write(g[k]);
                   end;
indice:=1;i:=1;k:=1;l:=0;m:=0;
while(indice<=n)do begin
if((g[k]>='0')and(g[k]<='9'))then begin
                                   while(i<=10)do begin
                                                  if(g[k]='0')then num[i]:=0;
                                                  if(g[k]='1')then num[i]:=1;
                                                  if(g[k]='2')then num[i]:=2;
                                                  if(g[k]='3')then num[i]:=3;
                                                  if(g[k]='4')then num[i]:=4;
                                                  if(g[k]='5')then num[i]:=5;
                                                  if(g[k]='6')then num[i]:=6;
                                                  if(g[k]='7')then num[i]:=7;
                                                  if(g[k]='8')then num[i]:=8;
                                                  if(g[k]='9')then num[i]:=9;
                                                  i:=i+1;l:=l+1;
                                                  indice:=k;
                                                  end;
                                                                                                                  k:=k+1;
for i:=l downto 1 do begin
                     while(p<=10) do begin
                                     puiss[p]:=num[i];
                                     p:=p+1;m:=m+1;
                                     end;
                      end;
for p:=m downto 0 do begin
                     if(puiss[p]<>0)or(puiss[p]<>1) then dec:=dec+1
                     else bin:=bin+1;
                     end;
p:=0;chiff:=0;
while(p<=9) do begin
               chiff:=(puiss[p])*(exp(p*ln(10)))+chiff;
               p:=p+1;
               end;
if(bin<>0) and(dec=0) then begin
                           u:=1;y:=0;
                           while(chiff>0) do begin
                           y:=y+(u*(chiff mod 2));
                           u:=u*2;
                           chiff:=chiff div 10;
                           end;
                           write(y);
                           end;
if(dec<>0) and (bin=0) then begin
                            i:=1;
                            while(chiff>0) do begin
                                              tab[i]:=chiff mod 2;
                                              chiff:=chiff div 2;
                                              i:=i+1;c:=c+1;
                                              end;
                        for i:=c downto 1 do begin
                                             write(tab[i]);
                                             end;
readln;
end;
end.
