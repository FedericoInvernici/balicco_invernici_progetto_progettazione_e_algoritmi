package Manager_filiare;

import java.util.ArrayList;
import java.util.Date;

import javax.print.attribute.standard.JobSheets;

import Record.Giochi;
import Record.GiocoVenduto;
import utility.GestoreJson;

public class ManagerModel {

	ArrayList<Giochi> g = new ArrayList<>();	//TODO utilizzo arraylist per testare
	ArrayList<GiocoVenduto>vend = new ArrayList<>();	//TODO utilizzo arraylist per testare
	
	
	public ManagerModel() { 
		//letturaDaFileGiochi();
		//letturaDaFilePreo();
	}
	
	
	//aggiunge un un gioco nuovo
	public void aggiungigiochi(String nome, double prezzo_nuovo, double prezzo_usato) {
		Giochi g1 = new Giochi(nome, prezzo_nuovo, prezzo_usato, 0, 0, 0);
		g.add(g1);
		scritturaSuFileGiochi();
	}
		
	//aggiunge una quantita a un gioco scegliendo tra quantita di giochi usati o nuovi
	public void aggiungiquantitagiochi(String nome, boolean nuovo, int quantita) {
		for (int i = 0; i < g.size(); i++) {
			if (g.get(i).getNome().equals(nome)) {			//cerco tra i giochi quello col nome uguale	
				if (nuovo) {
					g.get(i).aggiungiQnuovo(quantita);		//e quando lo trova gli sostituisce il prezzo
				}else {
					g.get(i).aggiungiQusato(quantita);;	//distinguendo tra nuovoe usato 
				}
			}
		}
		scritturaSuFileGiochi();
	}
	
	
	
	
	//cambia il prezzo del gioco "nome"
	public void cambiaprezzo(String nome, boolean nuovo, float nuovoprezzo) {
		for (int i = 0; i < g.size(); i++) {
			if (g.get(i).getNome().equals(nome)) {			//cerco tra i giochi quello col nome uguale
				if (nuovo) {
					g.get(i).setPrezzo_nuovo(nuovoprezzo);		//e quando lo trova gli sostituisce il prezzo
				}else {
					g.get(i).setPrezzo_usato(nuovoprezzo);	//distinguendo tra nuovoe usato 
				}
			}
		}	//TODO potremmo aggiungere un controllo nel caso in cui veda il file o meno
		scritturaSuFileGiochi();
	}
	
	
	
	
	public void ordinaprodotto(String nome, int quantita) {
		
	}
	
	
	
	
	//crea un report sui giochi venduti negli ultimi nmesi
	public String reportdata(int nmesi) {	//lista di iochi venduti negli ultimi n mesi
		//letturaDaFilePreo();
		String testo_report="";
		Date data_riferimento = new Date(System.currentTimeMillis());
		if (data_riferimento.getMonth()>12) {		//creo data_riferimento e lo imposto con la data di nmesi fa
			int y = data_riferimento.getYear();
			y = y - ((nmesi - (nmesi % 12))/12);
			data_riferimento.setYear(y);
			nmesi = nmesi % 12;
		}
		int m = data_riferimento.getMonth();
		m = m - nmesi;
		data_riferimento.setMonth(m);				//finisco di crearlo
		
		for (int i = 0; i < vend.size(); i++) {
			if (data_riferimento.after (vend.get(i).getData_vendita())) {	//cerco i giochi venduti dopo la data_riferimento
				testo_report = testo_report + " " + vend.get(i).getNome() + " " +
						vend.get(i).getPrezzo() + "\n";
			}
		}
		return testo_report;
	}
	
	
	//METODI LETTURA SCRITTURA DA FILE
	
	public void scritturaSuFileGiochi() {
		GestoreJson js = new GestoreJson();
		js.inserisci("GIOCHI", g);
		js.scritturaSuFile("FileGiochi.json");
	}
	
	public void letturaDaFileGiochi() { 
		GestoreJson js = new GestoreJson();
		js.letturaDaFileJSON("FileGiochi.json");
		// TODO js.recupera(preo)
	}
	
	public void letturaDaFilePreo() {
		GestoreJson js = new GestoreJson();
		js.letturaDaFileJSON("FileVenduti.json");
		// TODO js.recupera(g)
	}
	
	
}
