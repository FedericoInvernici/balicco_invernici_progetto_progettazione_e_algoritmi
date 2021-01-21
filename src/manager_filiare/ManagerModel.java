package manager_filiare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.JobSheets;

import finte_applicazioni_esterne.Finto_gestore_magazino;
import record.Giochi;
import record.GiocoVenduto;
import utility.GestoreJson;

public class ManagerModel {

	ArrayList<Giochi> g = new ArrayList<>();	//utilizzo arraylist per contenere i record
	ArrayList<GiocoVenduto> vend = new ArrayList<>();
	
	
	public ManagerModel() { //il costruttore legge i file
		letturaDaFileGiochi();
		letturaDaFileVend();
	}
	
	
	//aggiunge un un gioco nuovo
	public void aggiungigiochi(String nome, double prezzo_nuovo, double prezzo_usato) {
		Giochi g1 = new Giochi(nome, prezzo_nuovo, prezzo_usato, 0, 0, 0);
		g.add(g1);
		scritturaSuFileGiochi();
	}
	
	
	public void ordinaArrayGiochi(){
		Collections.sort(g);
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
		}	
		scritturaSuFileGiochi();
	}
	
	
	
	
	public void ordinaprodotto(String nome, int quantita) {
		Finto_gestore_magazino fm = new Finto_gestore_magazino();
		fm.InviaRichiestaGiochiPerFinta(nome, quantita);
	}
	
	
	
	
	//crea un report sui giochi venduti negli ultimi nmesi
	public String reportdata(int nmesi) {	//lista di giochi venduti negli ultimi nmesi
		String testo_report=""; // Stringa che conterr� il report completo
		int anniDiff = nmesi/12; 
		int mesiDiff= nmesi-anniDiff*12;
		Date data_riferimento = new Date(System.currentTimeMillis()); // costruisco una variabile di tipo data che indica il giorno nmesi fa
		data_riferimento.setYear(data_riferimento.getYear()-anniDiff);
		if(mesiDiff>data_riferimento.getMonth()) {
			data_riferimento.setYear(data_riferimento.getYear()-1);
			data_riferimento.setMonth(data_riferimento.getMonth()+12-mesiDiff);
		} else {
			data_riferimento.setMonth(data_riferimento.getMonth()-mesiDiff);
		}
		System.out.println("Anno: "+ data_riferimento.getYear()+"  mese: "+ data_riferimento.getMonth());
		
		for (int i = 0; i < vend.size(); i++) {
			if (!data_riferimento.after (vend.get(i).getData_vendita())) {	//cerco i giochi venduti dopo la data_riferimento
				
				testo_report = testo_report + " " + vend.get(i).getNome() + " " +
						vend.get(i).getPrezzo() + "\n";
			}
		}
		return testo_report;
	}
	
	
	//METODI LETTURA SCRITTURA DA FILE
	
	public void scritturaSuFileGiochi() {
		ordinaArrayGiochi();
		GestoreJson js = new GestoreJson();
		js.inserisci("GIOCHI", g);
		js.scritturaSuFile("FileGiochi.json");
	}
	
	public void letturaDaFileGiochi() { 
		GestoreJson js = new GestoreJson();
		g=(ArrayList<Giochi>) js.letturaDaFileJSON("FileGiochi.json"); 
	}
	
	public void letturaDaFileVend() {
		GestoreJson js = new GestoreJson();
		vend = (ArrayList<GiocoVenduto>) js.letturaDaFileJSON("FileVenduti.json"); 
	}
	
	
}
