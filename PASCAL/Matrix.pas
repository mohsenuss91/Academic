program MATRIX;
uses crt;

const
     I_COLOR:integer = 2; { 2 = verde }
     LINES:integer=15;
     SCREENX:integer=80;
     SCREENY:integer=25; { Potrebbe essere necessario modificare questo valore... }
     MSG:String = 'Matrix by MOHSENUSS';

var
   font,x,y:integer;
   randomposition : array [0 .. 15] of integer; { Se modifichi LINES modifica questo... }
   uniqueposition : array [0 .. 80] of integer;
   linescount:integer;

function isunique(number : integer): boolean;
     var count:integer;
         value:boolean;
begin
     value:=true;
     for count := 0 to SCREENX do if (uniqueposition[count]=number) then value:=false;
     isunique:=value;
end;

function getuniqueposition : integer;
var
   number,c:integer;
begin
     c:=0;
     number:=random(SCREENX);
     while(not isunique(number)) do
     begin
          inc(c);
          number:=random(SCREENX);
          if (c>SCREENX) then
          begin
             number:=0;
             inc(linescount);
             break;
          end;
     end;
     uniqueposition[linescount]:=number;
     inc(linescount);
     getuniqueposition:=number;
end;

procedure view_centered_text;
var x,y,c:integer;

begin
    x:=(SCREENX div 2)-(Length(MSG) div 2);
    y:=SCREENY div 2;
    GotoXY(x,y); { Esattamente al centro }
    TextColor(I_COLOR);
    write(' ' + MSG + ' ');
    { Inserisce un rettangolo vuoto... }
    for c:=0 to (Length(MSG)+2) do
    begin
         GotoXY(x+c,y-1); { Una linea sopra... }
         write(' ');
    end;
    for c:=0 to (Length(MSG)+2) do
    begin
         GotoXY(x+c,y+1); { Una linea sotto... }
         write(' ');
    end;
end;
procedure init_random_positions;
begin
     { Memorizza N posizioni casuali... }
     for x:=0 to LINES do randomposition[x]:= getuniqueposition;{random(SCREENX);}
end;
procedure write_random_char(x,y,color:integer);
begin
     TextColor(color);
     GotoXY(x,y);
     write(chr(random(128)+127));
end;


begin

ClrScr;

{ Stampa la scritta al centro... }
view_centered_text;

{ Inizializza le posizioni casuali... }
init_random_positions;

{ Ciclo iterativo per stampare i caratteri a "cascata" }
repeat
      for y:=1 to SCREENY-1 do
      begin
           for x:=0 to LINES do
           begin
                write_random_char(randomposition[x],y,I_COLOR);
                write_random_char(randomposition[x],y+1,7); { 7 = bianco }
           end;
           if (y in [(SCREENY div 2)-1 .. (SCREENY div 2)+1]) then view_centered_text;
           Delay(50);
      end;

      { Scrive l'ultimo carattere in verde... }
      for x:=0 to LINES do write_random_char(randomposition[x],SCREENY,I_COLOR);

      { Controlla se Š tempo di ripulire lo schermo... }
      if linescount>=SCREENX then
      begin
         { Pulisci e azzera alcune variabili... }
         ClrScr;
         linescount:=0;
         for x:=0 to SCREENX do uniqueposition[x]:=0;
      end;

      view_centered_text;
      init_random_positions;

until keypressed;

end.
