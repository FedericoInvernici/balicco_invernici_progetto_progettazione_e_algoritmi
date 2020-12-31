package Commesso;

import org.json.JSONString; //libreria per la gestione di JSON

import utility.GestoreFile;
import utility.GestoreJson;


public class test {

	
	public static void main(String[] args) {
		CommessoModel cmodel = new CommessoModel();
		CommessoView cview = new CommessoView(cmodel);
		CommessoControl ccontrol = new CommessoControl(cview, cmodel);
		cview.setVisible(true);
		System.out.println("esecuzione");
		
		GestoreFile fileManager = new GestoreFile();
		//test creazione e scrittura file json
		fileManager.creaFileJson("filediprova");
		fileManager.scritturaSuFile("filediprova.json", "{prova : pippo}");
		
		//test formato JSON con valori singoli, vettori e oggetti creati da noi
		GestoreJson json = new GestoreJson();
		
		int vett[]= {1,2,3,4,5};
		Studente s = new Studente("Pippo"); //classe studente di prova (da eliminare)
		
		
		json.inserisci("valore1", 30);
		json.inserisci("valore2", 50);
		json.inserisci("valore3", vett);
		json.inserisci("studente1",s);
		
		fileManager.scritturaSuFile("filediprova.json", json.toString());
		
	}
	

}
/*classe di prova per testare l'inserimento di oggetti in un file JSON. 
 * L'interfaccia JSONString indica la presenza del metodo toJSONString, per la conversione in una stringa
 * adatta al formato JSON */
 class Studente implements JSONString {
	String nome;
	
	Studente(String n){
		this.nome=n;
	}
	/*Metodo chiamato al momento dell'inserimento dell'oggetto in un JSONObject. Se non presente al posto del nome
	 * viene salvato il puntatore all'oggetto, come valore associato alla chiave */
	 public String toJSONString() {
		 return "{nome: "+this.nome+"}";
	 }
	
}
