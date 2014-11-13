program filescer;
const qtaille=225;
type files=record
		t:array[1..qtaille]of integer;
		tete,queu:0..qtaille;
		end;
var f:files;
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
pleine:=((f.tete=1) and(f.queu=qtaille))or f.tete:=f.queu+1;
end;
function vide(f:files):boolean;
begin
vide:=f.tete=f.queu;
end;
procedure inserer(var f:files;x:integer);
begin
if f.queu=qteille then f.queu:=1 else f.queu:=f.queu+1;
f.t[f.queu]:=x;
end;
procedure enlever(var f:files;x:integer);
begin
if f.tete=qtaille then f.tete:=1 else f.tete:=f.tete+1;
x:=f.t[f.tete];
end;

begin
readln;
end.
