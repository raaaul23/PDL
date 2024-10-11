package Accion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



public class LeerFichero {
	 
	 public FileInputStream fileReader;
	 //public int currentLine;
	 
	 
	 public LeerFichero(String rutaArchivo) { //Constructor
			File file = new File(rutaArchivo);
			if (!file.exists()) {
				System.out.println(String.format("El fichero %s no existe.", rutaArchivo));
				return;
			}
			if (!file.isFile() || !file.canRead()) {
				System.out.println("El fichero " + rutaArchivo +  " no tiene permiso de lectura.");
				return;
			}
			try {
				this.fileReader = new FileInputStream(file);
			} catch (IOException ex) {
			}
			//this.currentLine = 1;
		}
	 
	 
	  public int read() {
	        int current_character = -1;
	        try {
	            if (this.fileReader != null) {
	                current_character = this.fileReader.read();
	     		   //System.out.println(current_character);

	            }
	        } catch (IOException ex) {
	            System.out.println("Error al leer el fichero: " + ex.getMessage());
	        }
	        return current_character; // Devuelve -1 si ha llegado al final del fichero
	    }
	    

	   
	}
