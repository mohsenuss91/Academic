program piles;
const taille=225;
type pile=record
		t:array[1..taille]of integer;
		sommet:0..taille;
		end;
var p:pile;
procedure init(var p:pile);
begin
p.sommet:=0;
end;
function topelt(p:pile):integer;
begin
topelt:=p.t[p.sommet];
end;
function pleine(p:pile):boolean;
begin
pleine:=p.sommet=taille;
end;
function vide(p:pile):boolean;
begin
vide:=p.sommet=0;
end;
procedure inserer(var p:pile;x:integer);
begin
p.sommet:=p.sommet+1;
p.t[p.sommet]:=x;
end;
procedure enlever(var p:pile;x:integer);
begin
x:=p.t[p.sommet];
p.sommet:=p.sommet-1;
end;
begin
readln;
end.