package Accion;

public class Es {
	public static boolean isNumeric(String cadena) {

		boolean resultado;

		try {
			Integer.parseInt(cadena);
			resultado = true;
		} catch (NumberFormatException excepcion) {
			resultado = false;
		}
		//System.out.println(resultado);
		return resultado;
	}
	public static boolean esLetra(char c) {
	    return Character.isLetter(c);
	}

}
