program files;
const maxqueu=225;
type files=record
		t:array[1..maxqueu]of integer;
		tete,queu:0..taille;
		end;
var f:files;
procedure init(var f:files);
begin
f.queu:=0;
end;
function premierelt(f:files):integer;
begin
premierelt:=f.t[f.tete+1];
end;
function dernierelt(f:files):integer;
begin
dernierelt:=f.t[f.queu];
end;
function pleine(f:files):boolean;
begin
pleine:=f.queu=maxqueu;
end;
function vide(f:files):boolean;
begin
vide:=f.tete=f.queu;
end;
procedure inserer(var f:files;x:integer);
begin
f.queu:=f.queu+1;
f.t[f.queu]:=x;
end;
procedure enlever(var f:files;x:integer);
begin
f.tete:=f.tete+1;
x:=f.t[f.tete];

end;
begin
readln;
end.
