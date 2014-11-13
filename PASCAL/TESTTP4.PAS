program tp4 ;
const n=15;
var c:char;
    i,j,x,z,y:integer;
    t:array[1..n]of char;
    tab,num:array[1..10]of integer;choix:boolean;
begin
i:=1;
repeat begin
       readln(c);
       t[i]:=c;
       i:=i+1;
       end;
until(c='#');
writeln('la chaine de caractere est:');
for i:=1 to 10 do write(t[i]);
for i:=1 to n do begin
                 if (t[i]='0')then x:=0;
                  if (t[i]='1') then x:=1;
                   if (t[i]='2') then x:=2;
                    if (t[i]='3') then x:=3;
                    if(t[i]='4') then x:=4;
                    if(t[i]='5') then x:=5;
                    if(t[i]='6') then x:=6;
                    if(t[i]='7') then x:=7;
                    if(t[i]='8') then x:=8;
                    if(t[i]='9') then x:=9;
                    num[i]:=x;
                    end;
                    writeln('le numero est:');
                    for i:=1 to 10 do begin
                                      write(num [i]);
                                      end;
for i:=1 to 10 do begin
                  if (num[i]=2)or(num[i]=3)or(num[i]=4)or(num[i]=5) then choix :=true;
                  if(num[i]=6)or(num[i]=7)or(num[i]=8)or(num[i]=9) then choix :=true
                  ;
                  if(num[i]=0) or(num[i]=1) then choix:=false;
                  end;
if(choix=true) then begin
                    for i:=1 to 10 do begin
                                      x:=num[i]; j:=1;
                                      while(x>0) do begin
                                                    tab[j]:= x mod 2;
                                                    x:=x div 2;
                                                    j:=j+1;
                                                    end;
                                       end;
                     for j:=10 downto 1 do begin
                                           if(tab[j]=0) or(tab[j]=1) then write(tab[j]);
                                           end;
end;
                if choix=false then begin
                     for i:=1 to 10 do begin
                                    x:= num[i];
                                    i:=1;y:=0;
                                    while(x>0) do begin
                                                  y:=y+(i*(x mod 2));
                                                  i:=i*2;
                                                  x:=x div 10;
                                                  end;
                                       write(y);
                                       end;
                                       end;
readln;
end.