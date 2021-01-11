package Manager_filiare;

import java.util.ArrayList;
import java.util.Date;

import Record.Giochi;
import Record.GiocoVenduto;

public class ManagerModel {

	ArrayList<Giochi> g = new ArrayList<>();	//TODO utilizzo arraylist per testare
	ArrayList<GiocoVenduto> repo = new ArrayList<>();	//TODO utilizzo arraylist per testare
	
	
	public ManagerModel() { //TODO (forse)
	}
	
	
	//aggiunge un un gioco nuovo
	public void aggiungigiochi(String nome, double f, double g2) {
		Giochi g1 = new Giochi(nome, f, g2, 0, 0, 0);
		g.add(g1);
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
	}
	
	//metodo di quando un gioco viene venduto un gioco e che quindi ne diminuisce la quantita; se non ci sono 
	//più copie (quantita == 0) restituisce false
	public boolean vendita(String nome, boolean nuovo) {
		for (int i = 0; i < g.size(); i++) {
			if (g.get(i).getNome().equals(nome)) {			//cerco tra i giochi quello col nome uguale	
				if (nuovo) {
					g.get(i).quantitaNuovomenomeno();		//e quando lo trova gli sostituisce il prezzo
				}else {
					g.get(i).quantitaUsatomenomeno();	//distinguendo tra nuovoe usato 
				}
				return true;
			}
		}
		return false;
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
	}
	
	
	
	
	public void ordinaprodotto(String nome, int quantita) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//crea un report sui giochi venduti negli ultimi nmesi
	public String reportdata(int nmesi) {	//lista di iochi venduti negli ultimi n mesi
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
		
		for (int i = 0; i < repo.size(); i++) {
			if (data_riferimento.after (repo.get(i).getData_vendita())) {	//cerco i giochi venduti dopo la data_riferimento
				testo_report = testo_report + " " + repo.get(i).getNome() + " " +
						repo.get(i).getPrezzo() + "\n";
			}
		}
		return testo_report;
	}
	
	
	//
	
	
}
