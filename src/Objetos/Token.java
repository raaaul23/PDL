package Objetos;

import java.util.HashMap;
import java.util.Map;

public class Token {
	public String Pal_Res;
	public int ts;
	public String cad;

	public Token(String Pal_Res, int ts) {
		this.Pal_Res = Pal_Res;
		this.ts = ts;
		this.cad = null;
	}

	public Token(String Pal_Res, String cad) {
		this.Pal_Res = Pal_Res;
		this.ts = 0;
		this.cad = cad;
	}

	public Token(String Pal_Res) {
		this.Pal_Res = Pal_Res;
		this.ts = 0;
		this.cad = null;
	}

	public String toString() {
		if (cad == null) {
			return "< " + Pal_Res + ", " + ts + ">";
		} else if (ts == 0) {
			return "< " + Pal_Res + ", " + cad + " >";
		} else {
			return "< " + Pal_Res + ", >";
		}

	}

	public static final Map<String, Integer> tokenMap = new HashMap<>();
	// Asignar valores al Map
	static {
		tokenMap.put("BOOLEAN", 1);
		tokenMap.put("ELSE", 2);
		tokenMap.put("FUNCTION", 3);
		tokenMap.put("IF", 4);
		tokenMap.put("INPUT", 5);
		tokenMap.put("INT", 6);
		tokenMap.put("OUTPUT", 7);
		tokenMap.put("RETURN", 8);
		tokenMap.put("STRING", 9);
		tokenMap.put("VAR", 10);
		tokenMap.put("VOID", 11);

		tokenMap.put("ASIGRESTA", 12);
		tokenMap.put("IGUALAR", 13);
		tokenMap.put("COMA", 14);
		tokenMap.put("PUNTOCOMA", 15);
		tokenMap.put("ABRIRPARENTESIS", 16);
		tokenMap.put("CERRARPARENTESIS", 17);
		tokenMap.put("ABRIRCORCHETE", 18);
		tokenMap.put("CERRARCORCHETE", 19);
		tokenMap.put("RESTA", 20);
		tokenMap.put("DIVIDIR", 21);
		tokenMap.put("NOT", 22);
		tokenMap.put("MAYOR", 23);
		tokenMap.put("EOF", 24);

		tokenMap.put("CTEENTERA", 25);
		tokenMap.put("ID", 26);
		tokenMap.put("CADENA", 27);
		tokenMap.put("", 28);
	}
	
	/*
	 *  
        for (Map.Entry<String, Integer> entry : tokenMap.entrySet()) {
            System.out.println("Token: " + entry.getKey() + " -> Código: " + entry.getValue());
        }
	 */ 
}

