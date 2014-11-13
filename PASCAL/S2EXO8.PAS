program serie2exo8;
uses crt;
{declaration des types et variables}
type liste=^element;
     element=record
     pri:integer;
     val:string;
     suiv:liste;
     end;
	 var l,lp:liste;
choix:char;
prio,dp:integer;
vale,dv:string;
{creation delement pour ajouter}
procedure creation(var e:liste;pri:integer;val:string);
begin
new(e);
e^.pri:=pri;
e^.val:=val;
end;
{affichage de liste}
procedure affichage(l:liste);
var q:liste;
begin
q:=l;
while(q<>nil) do begin
writeln('Priorite:> ',q^.pri);
writeln('Valeur => ',q^.val);
q:=q^.suiv;
end;
end;
{emfiler insert en queu}
procedure emfiler(var l:liste;var pe:integer;var ve:string);
var e,q:liste;
begin
creation(e,pe,ve);
if (l=nil) then l:=e
else begin
q:=l;
while(q^.suiv<>nil)do q:=q^.suiv;
q^.suiv:=e;
end;
end;
{defiler sup de la tete}
procedure defiler(var l:liste;var pd:integer;var vd:string);
var q:liste;
begin
q:=l;
l:=l^.suiv;
q^.suiv:=nil;
pd:=q^.pri;
vd:=q^.val;
dispose(q);
end;
{empiler insertion en tete}
procedure empiler(var l:liste;var pe:integer;var ve:string);
var e,q:liste;
begin
creation(e,pe,ve);
if (l=nil) then l:=e
else begin
e^.suiv:=l;
l:=e;
end;
end;
{depiler sup de la tete}
procedure depiler(var l:liste;var pd:integer;var vd:string);
var q:liste;
begin
q:=l;
l:=l^.suiv;
q^.suiv:=nil;
pd:=q^.pri;
vd:=q^.val;
dispose(q);
end;

{maxpri}
procedure maxpri(l:liste;var pm:integer;var vm:string);
var q,x:liste;
begin
q:=l;
x:=l;
while(q<>nil) do begin
if((q^.pri)>(x^.pri))then x:=q;
q:=q^.suiv;
end;
pm:=x^.pri;
vm:=x^.val;
end;

{defiler par prioriteX XX}
procedure defilerpri(var l:liste;var pd:integer;var vd:string);
var q,ls,t:liste;
vs:string;
ps:integer;
begin
ls:=nil;
maxpri(l,pd,vd);
while((l^.pri<>pd)and(l^.val<>vd)) do begin
defiler(l,ps,vs);
empiler(ls,ps,vs);
end;
if((l^.val=vd)and(l^.pri=pd)) then defiler(l,pd,vd);
if (ls<>nil) then repeat
depiler(ls,ps,vs);
empiler(l,ps,vs);
until(ls=nil);
end;

{program principal}

begin
clrscr;
l:=nil;
lp:=nil;
choix:='y';
writeln('>L ELEMENT LE PLUS PRIORITAIRE EST CELUI QUI A LA PRIORITE LA PLUS SUPERIEUR<');
writeln;
while(choix<>'n')do begin;
writeln('Entrer la valeur(un caractere):');
readln(vale);
writeln('Entrer la priorite(un entier):');
readln(prio);
emfiler(l,prio,vale);
writeln('Voulez vous ajoutez un element?: (y/n)');
readln(choix);
end;
writeln;
writeln('LA LISTE DES ELEMENTS CREES');
affichage(l);
writeln;
writeln('LISTE DES ELEMENTS AVEC LA PRIORITE CROISSANTE');
repeat
defilerpri(l,dp,dv);
empiler(lp,dp,dv);
until (l=nil);
affichage(lp);
readln;
end.