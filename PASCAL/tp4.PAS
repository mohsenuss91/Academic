program test;
type tab=array[1..10]of char;
var a:string;
    i,d,n,o,c,e,k,rest,g,p,f,u,z,h,s,l,j:integer;
    t:tab;
    b,w:boolean;
begin
readln(a);i:=1; d:=1;
while(a[i]<>'#')or(a[d]<>'#')do begin
j:=0;b:=false;
n:=0;
while(a[i]<>'#')and(b=false)and(j<11)do begin
                                        if(a[i]='2')or(a[i]='3')or(a[i]='4')or(a[i]='5')or(a[i]='6')or(a[i]='7')
                                        or(a[i]='9')or(a[i]='8')then begin
                                                                     j:=j+1;
                                                                     t[j]:=a[i];
                                                                     write(t[j]);
                                                                     if(a[i+1]='2')or(a[i+1]='3')or(a[i+1]='4')or(a[i+1]='5')
                                                                     or(a[i+1]='6')or(a[i+1]='7')or(a[i+1]='9')or(a[i+1]='8')
                                                                     then b:=false
                                                                     else b:=true;
                                                                     n:=n+1;
                                                                     end;
                                        i:=i+1;
                                        end;
z:=1;l:=0;
if(n<>0)then begin
writeln('');
while(j>0)do begin
             if(t[j]='2')then s:=2;
             if(t[j]='3')then s:=3;
             if(t[j]='4')then s:=4;
             if(t[j]='5')then s:=5;
             if(t[j]='6')then s:=6;
             if(t[j]='7')then s:=7;
             if(t[j]='8')then s:=8;
             if(t[j]='9')then s:=9;
             l:=l+(s*z);
             z:=z*10;
             j:=j-1;
             end;
writeln(l);
p:=0;
f:=l;
u:=l;
while(l>0)do begin
             l:=l div 2;
             p:=p+1;
             end;
g:=p;
while(g>0)do begin
             while(p>0)do begin
                          rest:=u mod 2;
                          u:=u div 2;
                          p:=p-1;
                          end;
             write(rest);
             g:=g-1;
             u:=f;
             p:=g;
             end;
writeln('');
end;
c:=0;b:=false;
o:=0;
while(a[d]<>'#')and(b=false)and(c<11)do begin
                                        if(a[d]='0')or(a[d]='1')then begin
                                                                     c:=c+1;
                                                                     t[c]:=a[d];
                                                                     write(t[c]);
                                                                     if(a[d+1]='0')or(a[d+1]='1')then b:=false
                                                                     else b:=true;
                                                                     o:=o+1;
                                                                     end;
                                        d:=d+1;
                                        end;
z:=1;l:=0;
if(o<>0)then begin
writeln('');
while(c>0)do begin
             if(t[c]='0')then s:=0;
             if(t[c]='1')then s:=1;
             l:=l+(s*z);
             z:=z*10;
             c:=c-1;
             end;
writeln(l);
e:=1;
k:=0;
while(l>0)do begin
             k:=k+(e*(l mod 2));
             e:=e*2;
             l:=l div 10;
             end;
write(k);
end;
readln;
end;
readln;
end.