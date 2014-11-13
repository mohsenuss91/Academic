%%
%line 
%column
%unicode
%int
%class bonpar
%{
int nb=0;
%}
%eofval{
return 0;
%eofval}
%%
"(" {nb++;}
")" {if (nb>0) nb--; else return -1;}
.|\n  { }