package commesso;

import java.util.ArrayList;
import java.util.Date;

import record.Giochi;
import record.GiocoPrenotato;
import record.GiocoVenduto;
import record.Iscritto;
import utility.GestoreJson;
import utility.RicercaInterpolata;

public class CommessoModel {
	
	ArrayList<Giochi> g = new ArrayList<>();	//utilizzo arraylist per i record (giochi,iscritti...)
	ArrayList<GiocoPrenotato> preo = new ArrayList<>();
	ArrayList<GiocoVenduto> vend = new ArrayList<>();
	ArrayList<Iscritto> iscr = new ArrayList<>();
	
	public CommessoModel() {	//il costruttore legge i file
		letturaDaFileGiochi();
		letturaDaFilePreo();
		letturaDaFileVend();
		letturaDaFileIscritti();
	}
	
	/*
	 * metodo che riceve in ingresso una stringa (rappresentante il nome del gioco) e un booleano (a true se il gioco 
	 * da cercare � nuovo, a false se � usato).
	 * Il gioco verr� cercato nel database, se non � presente verr� restituito 0.
	 */
	public double trovaprezzo(String nome, boolean nuovo){
		int indice = RicercaInterpolata.TrovaElementoComp(g, new Giochi(nome, 0, 0, 0));
		if(indice==-1) return 0;
		else if(nuovo) return g.get(indice).getPrezzo_nuovo();
		else return g.get(indice).getPrezzo_usato();
	}
	
	
	
	//metodo per il ritiro usato, che aumenta la quantita e restituisce il prezzo di un gioco
	public double ritirousato(String nome){
		double prezzo = 0.0;
		int indice = RicercaInterpolata.TrovaElementoComp(g, new Giochi(nome, 0, 0, 0));
		if(indice!=-1) {
			g.get(indice).quantitaUsatopiupiu();
		}
		scritturaSuFileGiochi();
		return prezzo;		//in caso non lo trovi ritornera prezzo=0
	}
	
	
	//metodi che aggiundono oggetti al array preo
	public void preordina(String nome, Double prezzo, Date d, String email, String cliente){			 
		preo.add(new GiocoPrenotato( nome, prezzo, d, email, cliente));
		scritturaSuFilePreo();
	}
	public void preordinaultimocliete(String email, String cliente){			 
		GiocoPrenotato gp;
		gp = preo.get(preo.size()-1);
		gp.setNome_cliente(cliente);
		gp.setEmail_cliente(email);
		preo.set(preo.size()-1,gp);
		scritturaSuFilePreo();

	}
	
	
	public void aggiungiPreordine(String nome, String email, String cliente) {
		Double prezzo;
		Date d;
		int indice = RicercaInterpolata.TrovaElementoComp(g, new Giochi(nome, 0, 0, 0));
		if(indice>=0) {
			prezzo=g.get(indice).getPrezzo_nuovo();
			d=g.get(indice).getDataUscita();
			g.get(indice).setQuantitaDisponibilePreoMenoMeno();
			preordina(nome, prezzo, d, email, cliente);
			scritturaSuFileGiochi();
			return;
		}
		
	}
	
	public boolean verificaDisponibilitaPreo(String nome) {
		int indice = RicercaInterpolata.TrovaElementoComp(g, new Giochi(nome, 0, 0, 0)); // trovo il gioco se esiste
		if(indice>=0&&g.get(indice).getQuantita_preo()>0) return true; // se il gioco viene trovato nel database e la disponibilit� � almeno uno ritorno true
		return false;
	}
	
	//metodo di quando un gioco viene venduto un gioco e che quindi ne diminuisce la quantita; se non ci sono 
	//pi� copie (quantita == 0) restituisce false
	public double vendita(String nome, boolean nuovo) {
		Giochi gtemp;
		Double d = 0.0;
		int indice = RicercaInterpolata.TrovaElementoComp(g, new Giochi(nome, 0, 0, 0));
		if(indice>=0) {
			gtemp=g.get(indice); //salvo il gioco trovato nella variabile temporanea gtemp
			if(nuovo&&gtemp.getQuantita_nuovo()>0) {
				gtemp.quantitaNuovomenomeno();
				vend.add((new GiocoVenduto(gtemp.getNome(), gtemp.getPrezzo_nuovo(), 
							new Date(System.currentTimeMillis()), nuovo)));
				d=gtemp.getPrezzo_nuovo();
			} else if (!nuovo&&gtemp.getQuantita_usato()>0) {
				gtemp.quantitaUsatomenomeno(); //tolgo un'unit� di prodotto usato al gioco trovato
				vend.add(new GiocoVenduto(gtemp.getNome(), gtemp.getPrezzo_usato(), 
						new Date(System.currentTimeMillis()), nuovo));
				d=gtemp.getPrezzo_usato();
			}
			scritturaSuFileGiochi();
			scritturaSuFileVend();
			return d; //viene ritornato 0 se non vi sono prodotti in magazzino per rispondere alla vendit�
		}
		return 0;
	}
	
	/* Riceve come parametri il nome del gioco e la sua condizione (nuovo= true se il gioco � nuovo, altrimenti false per gli usati).
	 * Verifica la disponibilit� del gioco indicato, restituendo true se � presente almeno un gioco disponibile in negozio
	 */
	public boolean verificaDisponibilita(String nome, boolean nuovo) {
		int indice = RicercaInterpolata.TrovaElementoComp(g, new Giochi(nome, 0, 0, 0));
		if(indice<0) return false;
		else {
			if(nuovo&&g.get(indice).getQuantita_nuovo()>0)return true;
			else if (!nuovo&&g.get(indice).getQuantita_usato()>0) return true;
			else return false;
		}
	}
	
	/*
	 * Metodo per l'iscrizione alla newsletter
	 */
	public void iscrivi(String nome, String cognome, String email) {
		iscr.add(new Iscritto(nome, cognome, email));
		scritturaSuFileIscritti();
	}
	
	
	
	
	
	
	
	
	
	//METODI LETTURA SCRITTURA DA FILE
	
	public void scritturaSuFileGiochi() {
		GestoreJson js = new GestoreJson();
		js.inserisci("GIOCHI", g);
		js.scritturaSuFile("FileGiochi.json");
	}
		
	public void letturaDaFileGiochi() {
		GestoreJson js = new GestoreJson();
		g= (ArrayList<Giochi>) js.letturaDaFileJSON("FileGiochi.json");
	}
	
	public void scritturaSuFilePreo() {
		GestoreJson js = new GestoreJson();
		js.inserisci("GIOCHI PRENOTATI", preo);
		js.scritturaSuFile("FilePreordina.json");
	}
		
	public void letturaDaFilePreo() {
		GestoreJson js = new GestoreJson();
		preo = (ArrayList<GiocoPrenotato>) js.letturaDaFileJSON("FilePreordina.json");
	}
	
	public void scritturaSuFileVend() {
		GestoreJson js = new GestoreJson();
		js.inserisci("GIOCHI VENDUTI", vend);
		js.scritturaSuFile("FileVenduti.json");
	}
		
	public void letturaDaFileVend() {
		GestoreJson js = new GestoreJson();
		vend = (ArrayList<GiocoVenduto>) js.letturaDaFileJSON("FileVenduti.json");
	}
	
	public void scritturaSuFileIscritti() {
		GestoreJson js = new GestoreJson();
		js.inserisci("ISCRITTI", iscr);
		js.scritturaSuFile("FileIscritti.json");
	}
		
	public void letturaDaFileIscritti() {
		GestoreJson js = new GestoreJson();
		iscr = (ArrayList<Iscritto>) js.letturaDaFileJSON("FileIscritti.json");
	}
}
