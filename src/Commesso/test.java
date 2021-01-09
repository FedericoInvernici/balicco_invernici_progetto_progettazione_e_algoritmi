package Commesso;

import org.json.JSONString; //libreria per la gestione di JSON
import utility.GestoreFile;
import utility.GestoreJson;
import utility.ValoreIntero; //interfaccia per la ricerca interpolata
import utility.RicercaInterpolata;


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
		Studente s = new Studente("Pippo",10); //classe studente di prova (da eliminare)

		json.inserisci("valore1", 30);
		json.inserisci("valore3", vett);
		json.inserisci("studente1",s);
		
		fileManager.scritturaSuFile("filediprova.json", json.toString());
		
		//Ricerca interpolata in un vettore di stringhe
		String a1 = "abc";
		String a2 = "abd";
		String a3 = "abe";
		String a4 = "abf";
		String a5 = "abg";
		String a6 = "abcaba"; //stringa da ricercare

		String v[] = {a1,a2,a3,a4,a5};
		
		System.out.println(RicercaInterpolata.TrovaElementoComp(v,a6));

	}
	

}
/*classe di prova per testare l'inserimento di oggetti in un file JSON. 
 * L'interfaccia JSONString indica la presenza del metodo toJSONString, per la conversione in una stringa
 * adatta al formato JSON */
 class Studente implements JSONString, ValoreIntero {
	String nome;
	int mat;
	
	Studente(String n, int mat){
		this.nome=n;
		this.mat= mat;
	}
	/*Metodo chiamato al momento dell'inserimento dell'oggetto in un JSONObject. Se non presente al posto del nome
	 * viene salvato il puntatore all'oggetto, come valore associato alla chiave */
	 public String toJSONString() {
		 return "{nome: "+this.nome+"}";
	 }
	 
	 @Override
	public int interoPerRicerca() {
		 return mat;
	}
	
}
