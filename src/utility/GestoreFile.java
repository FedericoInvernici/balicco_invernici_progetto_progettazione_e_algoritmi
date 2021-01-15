package utility;

import java.io.File;  //Classe per la gestione dei File
import java.io.FileReader;
import java.io.FileWriter; //Classe per la gestione della scrittura di stringhe nei File
import java.io.IOException; //Eccezione per problemi di I/O

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



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
			FileWriter fileInput = new FileWriter("data\\"+nomeFile); //se metto come secondo argomento "true", la stringa viene messa in coda
			fileInput.write(testo);
			fileInput.close();
		} catch(IOException e){
			System.out.println("Errore nell'accesso/scrittura al file");
		} 		
	}
	
	/*
	 * Riceve come argomento il nome del file (compreso di estensione) da cui ricavare i dati in formato JSON.
	 * Restituisce il JSONObject che si genera dal parsing del file. Ritorna un null in caso non sia presente nessun
	 * dato in formato JSON
	 */
	public JSONObject letturaDaFileJSON(String nomeFile) {
		JSONParser parser = new JSONParser();
		Object ogg = null;
		try {
			FileReader fileOutput = new FileReader("data\\"+nomeFile);
			ogg = parser.parse(fileOutput);
			JSONObject oggettoLetto = (JSONObject) ogg;
			fileOutput.close();
			return oggettoLetto;
		}catch(IOException e){
			System.out.println("Errore nell'accesso al file");
		} catch (ParseException e) {
			System.out.println("Errore nel parsing");
		} 
		return (JSONObject) ogg;
	}

}
