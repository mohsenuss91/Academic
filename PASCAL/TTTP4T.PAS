program tttp4t;
uses crt;
const n=25;
var c:char;
i,k,z,bin,dec,u,s,h,x:integer;
g:array[1..n]of char;
num,result:array[1..10]of integer;
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
i:=1;     k:=1;
writeln;
writeln('les numeros sont:');

while (k<=n) do begin

                 if g[k]='0' then begin
                                  num[i]:=0;
                                  i:=i+1;
                                   end;
                 if(g[k]='1') then begin
                                   num[i]:=1;
                                   i:=i+1;
                                   end;
                 if(g[k]='2')then begin
                                  num[i]:=2;
                                  i:=i+1;
                                  end;
                 if(g[k]='3')then begin
                                  num[i]:=3;
                                  i:=i+1;
                                  end;
                 if(g[k]='4') then begin
                                   num[i]:=4;
                                   i:=i+1;
                                   end;
                 if(g[k]='5')then begin
                                  num[i]:=5;
                                  i:=i+1;
                                  end;
                 if(g[k]='6')then begin
                                  num[i]:=6;
                                  i:=i+1;
                                  end;
                 if(g[k]='7')then begin
                                  num[i]:=7;
                                  i:=i+1;
                                  end;
                 if(g[k]='8')then begin
                                  num[i]:=8;
                                  i:=i+1;
                                  end;
                 if(g[k]='9')then begin
                                  num[i]:=9;
                                  i:=i+1;
                                  end;
                                 k:=k+1;
                                 end;

for i:=1 to (i-1) do begin
write(num[i]);
end;
writeln;
bin:=0;dec:=0;
for i:=1 to 10 do begin
                if (num[i]=0)or(num[i]=1) then begin
                                               bin:=bin+1
                                               end
                else begin
                     dec:=dec+1;
                     end;
                end;
 writeln('le resultat est -->');
if (bin>0)and(dec=0) then begin
                           i:=1;
                          writeln('binaire to decimal');

                          while(i<=10) do begin
                                            s:=1;u:=1;

                                            while (i<=10) do begin
                                                             u:=u+(s*(num[i] mod 2));
                                                             s:=s*2;
                                                             num[i]:=num[i] div 10;
                                                             end;
                                                             write(u);
                                                             end;
                          end;
if(dec>0) then begin
               writeln('decimal to binaire');
               i:=1;
               while(i<=10) do begin
                               h:=1;
                               x:=num[i];
                               result[h]:= x mod 2;
                               x:=x div 2;
                               h:=h+1;
                               end;
                 for h:=10 downto 1 do begin
                                       if(result[h]=0) or (result[h]=1) then write(result[i]);
                                       end;
               end;
readln;
end.