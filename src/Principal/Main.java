package Principal;

import java.io.IOException;
import Accion.LeerFichero;
import Analizadores.Analizador_Lexico;

public class Main {
	public static void main(String [] args) {
		String rutaArchivoEntrada = ".\\prueba.txt";
		LeerFichero fich= new LeerFichero(rutaArchivoEntrada);
		Analizador_Lexico an_lex=new Analizador_Lexico(fich);
		try {
			an_lex.escribirTokens(".\\salida.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Hola");
	}
}
