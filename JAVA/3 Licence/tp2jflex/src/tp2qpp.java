import java.io.IOException;

public class tp2qpp {
public static void main(String...args) throws IOException  
{
somme sm=new somme(System.in);
sm.yylex();
if(sm.nb==0) System.out.println("0");
else System.out.println(sm.sum/sm.nb);
}
}
//apres avoir entrer la chainne il faut faire "ctrl+Z" pour afficher le resultat