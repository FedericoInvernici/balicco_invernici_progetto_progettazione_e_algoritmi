package utility;

import java.io.File;  //Classe per la gestione dei File
import java.io.FileWriter; //Classe per la gestione della scrittura di stringhe nei File
import java.io.IOException; //Eccezione per problemi di I/O


public class GestoreFile {
	
	/*Metodo di prova per la creazione di un nuovo file JSON nella cartella "data"
	 * come parametro riceve la stringa contenete il nome da dare al nuovo file */
	public void creaFileJson(String nome) {
		try {
			File nuovoFile = new File("data\\"+nome+".json");
		    if (nuovoFile.createNewFile()) {
		    	System.out.println("Nuovo file creato correttamente: " + nuovoFile.getName());
		    } else {
		    	System.out.println("Il file esiste già");
		    }
		} catch (IOException e) {
			System.out.println("Problema nella generazione del file");
		    e.printStackTrace();
		}		
	}
	
	/*Metodo per la scrittura di una stringa su file già esistente, di cui bisogna fornire il nome 
	 * (compreso di estensione) nel parametro "nomeFile". La stringa da scrivere deve essere passata 
	 * nel parametro "testo" */
	public void scritturaSuFile(String nomeFile, String testo) {
		try {
			FileWriter fileInput = new FileWriter("data\\"+nomeFile,true);
			fileInput.write(testo);
			fileInput.close();
		} catch(IOException e){
			System.out.println("Errore nell'accesso/scrittura al file");
		} 		
	}

}
