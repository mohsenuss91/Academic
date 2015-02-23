// programme java ou en fait l'appel a lanalyseur
import java.io.*;
public class tp1flexprincipal {
public static void main(String...args) throws IOException{
	tp1flex lex=new tp1flex(new FileReader("/media/F20ED46F0ED42DFB/9RAYA/3eme année informatique/s5/Compilation/compilation 2012_2013/Tpcompil/tp1jflex/src/tp1jflextext.txt"));//lecture de fichier texte ou il ya les cacactere qu'en veux compter
	lex.yylex();//appel au programme de lanalyseur
	System.out.println("Voyelle(s): "+lex.nbV);
	System.out.println("Consonnes(s): "+lex.nbC);
	System.out.println("Ponctuation(s): "+lex.nbP);
  }
}
