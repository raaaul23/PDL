package Principal;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import Accion.LeerFichero;
import Analizadores.Analizador_Lexico;

public class Main {
	public static void main(String [] args) {
		String rutaArchivoEntrada = "C:\\Users\\danig\\eclipse-workspace\\PDL\\src\\prueba.txt";
		LeerFichero fich= new LeerFichero(rutaArchivoEntrada);
		Analizador_Lexico an_lex=new Analizador_Lexico(fich);
		try {
			an_lex.escribirTokens("C:\\Users\\danig\\eclipse-workspace\\PDL\\src\\salida.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
