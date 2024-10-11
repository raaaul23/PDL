package Analizadores;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Objetos.Token;
import Accion.Es;
import Accion.LeerFichero;


public class Analizador_Lexico {
    public LeerFichero fich;
    public ArrayList<Token> Tokens = new ArrayList<>();


    public Analizador_Lexico(LeerFichero fich) {
        this.fich = fich;
    }

   public Token genToken(int leer) {
	   String cad="";
	   //int length=0;
	   //boolean gen=false;
	   
	   //while(leer!=-1 && !gen) {
		   char caracter_leido=((char)leer); 
		   cad+=caracter_leido;
		   
		   //length++;
		   int le;
		  // if(length==1) {
		   		if(caracter_leido=='>') {
				   return new Token("MAYOR","-");
			   }else if(caracter_leido=='!') {
				   return new Token("NOT","-");
				   
			   }else if(caracter_leido=='{') {
				   return new Token("ABRIRCORCHETE","-");
				   
			   }else if(caracter_leido=='}') {
				   return new Token("CERRARCORCHETE","-");
				   
			   }else if(caracter_leido=='(') {
				   return new Token("ABRIRPARENTESIS","-");
				   
			   }else if(caracter_leido==')') {
				   return new Token("CERRARPARENTESIS","-");
				   
			   }else if(caracter_leido==';') {
				   return new Token("PUNTOCOMA","-");
				   
			   }else if(caracter_leido=='=') {
				   return new Token("IGUALAR","-");
				   
			   }else if(caracter_leido==',') {
				   return new Token("COMA","-");
			   
			   //NUMEROS
			   }else if(Es.isNumeric(cad)) {
				  
				   le=fich.read();
				   caracter_leido=((char)le);
				   System.out.println(new Token("CTEENTERA",cad));
				   System.out.println(leer);
				   if(le!=13) {
					   cad+=caracter_leido; 
				   }
				   //cad+=caracter_leido;
				   
				   
				   
				   while(Es.isNumeric(cad)) { //se debera de cambiar para los errores por ejemplo 2344436e324 error
					   le=fich.read();
					   caracter_leido=((char)le);
					   if(le!=13) {
						   cad+=caracter_leido;
					   }else {
						   break;
					   }
					   System.out.println(new Token("CTEENTERA",cad));
					   System.out.println(le);
					 }//Hemos encontrado el token CTEEntera, ahora bien, si despues hay otro numero sera un error, por lo que...
				   le=fich.read(); //vemos que caracter es el siguiente
				   caracter_leido=((char)le);
				   String comprueba="";
				   comprueba+=caracter_leido;
				   if(Es.isNumeric(comprueba)) { //si el siguiente caracter es un numero significa que habremos puesto un numero de dimensiones inadecuadas, por lo que lanzaremos un error, pero antes...
					   while(Es.isNumeric(comprueba)) { //leemos todos los numeros que haya para que no genere un error de numero y despues genere seguidamente otro token de cteentera ("espera")
						   le=fich.read();
						   caracter_leido=((char)le);
						   comprueba="";
						   comprueba+=caracter_leido; 
					   }
					   return new Token("ERRORCTEENTERA","-"); //lanzamos el error en forma de token(cambiar por exception o algo)
				   }else {
					   return new Token ("CTEENTERA",cad);  
				   }
				   
			   }
		   		
		   		//CADENAS
			   else if(Es.esLetra(caracter_leido)||caracter_leido=='_') { //si el caracter es alfabetico o el caracter es _ entonces nos encontramos con una cadena
				   String c=cad;
				   le=fich.read();
				   caracter_leido=((char)le);
				   while(Es.esLetra(caracter_leido)||caracter_leido=='_'||Es.isNumeric(c)) {
					   cad+=caracter_leido;
					   c="";
					   le=fich.read();
					   caracter_leido=((char)le);
					   c+=caracter_leido;//para saber si es un numero
					   
				   }
				   
				   if(Token.tokenMap.containsKey(cad)) {
					   return new Token (cad,"-"); //creamos el token con la palabra reservada
				   }else {
					  return new Token ("CAD",cad); //creamos el token CAD con la cadena
				   }
				   //if(espalres) gen token palres...
				   //else gen "CAD",cad
			   }
			   
			   
			   
			   
			   else {
				   return null;
			   }
	   		//}//if del length
	   //}//llave while
	   //return new Token("HOLA","-");
   }
   
   public Token genTokenEof() {
	   return new Token("EOF","-");
   }
   
   public void escribirTokens(String rutaSalida) throws IOException {
	   
	   int leer=fich.read();
	   Token tok;
	   
	   while(leer!=-1) {
//System.out.println(leer);
		   tok=genToken(leer);
		   if(tok!=null) {
			  Tokens.addLast(tok);
			  leer=fich.read();
		   }else {
			   leer=fich.read();
		   }
		   
	   }   
	   try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaSalida))) {
			for (Token token : Tokens) {
				System.out.println(token.toString());
			  bw.write(token.toString());
			  bw.newLine();
			}
			bw.write(genTokenEof().toString()); 
	   }catch (IOException e) {
			e.printStackTrace();
	   }

   }
	
	   
	   
	   
	   
	   
}
