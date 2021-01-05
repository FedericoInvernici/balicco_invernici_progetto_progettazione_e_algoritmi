package utility;
import org.json.*; //Libreria per la gestione del formato JSON


/*classe di collegamento con la libreria org.json  */
public class GestoreJson {
	
	// Oggetto in cui inserire le coppie di chiave e valore in formato JSON
	JSONObject dati = new JSONObject();
	
	/*/metodo di inserimento nell'oggetto JSON di una coppia chiave (obbligatoriamente di tipo stringa)
	 * e un oggetto di qualsiasi tipo */
	public <T> void inserisci(String chiave, T valore) {
		dati.put(chiave, valore);
	}
	
	/*/metodo di inserimento nell'oggetto JSON di una coppia chiave (obbligatoriamente di tipo stringa)
	 * e un vettore di oggetti di qualsiasi tipo */
	public <T> void inserisci(String chiave, T[] vettoreDiValori) {
		dati.put(chiave, vettoreDiValori);
	}
	
	/* Metodo che si basa sul toString del JSONObject
	 * */
	public String toString() {
		return dati.toString();
	}

	

}

