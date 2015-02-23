%%
%line 
%column
%unicode
%int
%class somme 
%{ 
   int nb=0,sum=0;
%}
%%
[0-9]+ {nb++; sum+=new Integer(yytext());}
.|\n  { }
