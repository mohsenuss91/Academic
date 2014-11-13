program calendrier;
uses crt;

var nomoi,pj:string;
    an,numoi,j,nbjm,tmoi,esp:longint;

begin
clrscr;

                write('entrez lann‚e: ');
                readln(an);
                write('entrez les trois premieres lettes du 1er jour [exemple sam pour samedi] : ');


                readln(pj);
                writeln('appyez sur la touche pour passer au mois suivant');
                for numoi:=1 to 12 do begin
                                  case numoi of
                                  1: nomoi:='janvier';
                                  2: nomoi:='fevrier';
                                  3: nomoi:='mars';
                                  4: nomoi:='avril';
                                  5: nomoi:='mai';
                                  6: nomoi:='juin';
                                  7: nomoi:='juillet';
                                  8: nomoi:='aout';
                                  9: nomoi:='septembre';
                                  10: nomoi:='octobre';
                                  11: nomoi:='novombre';
                                  12: nomoi:='decembre';
                                  end;
                                  writeln;
                                  writeln(nomoi:15);
                                  esp:=an mod 4;
                                  tmoi:=numoi mod 2;
                                  if(numoi=2)then if(esp=0)then nbjm:=29
                                              else nbjm:=28
                                  else if(numoi<=7)then if(tmoi=0)then nbjm:=30
                                                    else nbjm:=31
                                       else if(tmoi=0)then nbjm:=31
                                            else nbjm:=30;
                                  writeln('sam dim lun mar mer jeu ven');
                                  if(pj='sam')then esp:=0;
                                  if(pj='dim')then esp:=1;
                                  if(pj='lun')then esp:=2;
                                  if(pj='mar')then esp:=3;
                                  if(pj='mer')then esp:=4;
                                  if(pj='jeu')then esp:=5;
                                  if(pj='ven')then esp:=6;
                                  write('':esp*4);
                                  for j:=1 to nbjm do begin
                                 if(j=(8-esp))or(j=(15-esp))or(j=(22-esp))or(j=(29-esp))or(j=(36-esp))then begin
                                                                                                           writeln(' ');
                                                                                                           tmoi:=1;
                                                                                                           end
                                                   else if(j=10)then tmoi:=5
                                                        else if(j=1)then tmoi:=1
                                                             else tmoi:=4;
                                                   write(j:tmoi);
                                                   end;
                                  j:=((nbjm mod 7)+esp)mod 7;
                                  case j of
                                  0: pj:='sam';
                                  1: pj:='dim';
                                  2: pj:='lun';
                                  3: pj:='mar';
                                  4: pj:='mer';
                                  5: pj:='jeu';
                                  6: pj:='ven';
                                  end;


readln;                end;
end.