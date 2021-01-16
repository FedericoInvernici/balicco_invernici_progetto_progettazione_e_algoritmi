package Commesso;

import java.util.ArrayList;
import java.util.Date;

import Record.Giochi;
import Record.GiocoPrenotato;
import Record.GiocoVenduto;
import Record.Iscritto;
import utility.GestoreJson;

public class CommessoModel {
	
	ArrayList<Giochi> g = new ArrayList<>();	//TODO utilizzo arraylist per testareï¿½
	ArrayList<GiocoPrenotato> preo = new ArrayList<>();	//TODO utilizzo arraylist per testareï¿½
	ArrayList<GiocoVenduto> vend = new ArrayList<>();	//TODO utilizzo arraylist per testareï¿½
	ArrayList<Iscritto> iscr = new ArrayList<>();
	GestoreJson js = new GestoreJson();
	
	public CommessoModel() {
		//letturaDaFileGiochi();
		//letturaDaFilePreo();
		//letturaDaFileVend();
		//letturaDaFileIscritti();
	}
	
	public double trovaprezzo(String nome, boolean nuovo){
		for (int i = 0; i < g.size(); i++) {
			if (g.get(i).getNome().equals(nome)) {			//cerco tra i giochi quello col nome uguale
				if (nuovo) {					//e quando lo trova gli sostituisce il prezzo
					return g.get(i).getPrezzo_nuovo();		//e quando lo trova gli sostituisce il prezzo
				}else {
					return g.get(i).getPrezzo_usato();	//distinguendo tra nuovoe usato 
				}
			}
		}
		return 0;		//in caso non lo trovi
	}
	
	
	
	//metodo per il ritiro usato, che aumenta la quantita e restituisce il prezzo di un gioco
	public double ritirousato(String nome){
		double prezzo = 0;
		Giochi gtemp;
		for (int i = 0; i < g.size(); i++) {		//cerco tra i giochi quello col nome uguale
			if (g.get(i).getNome().equals(nome)) {			 
				gtemp = g.get(i);							
				prezzo = gtemp.getPrezzo_usato();
				gtemp.quantitaUsatopiupiu();
				g.set(i, gtemp);
			}
		} 
		scritturaSuFileGiochi();
		return prezzo;		//in caso non lo trovi ritornera prezzo=0
	}
	
	
	public void preordina(String nome, Double prezzo, Date d, String email, String cliente){			 
		preo.add(new GiocoPrenotato( nome, prezzo, d, email, cliente));
		scritturaSuFilePreo();
	}
	
	
	
	//metodo di quando un gioco viene venduto un gioco e che quindi ne diminuisce la quantita; se non ci sono 
	//più copie (quantita == 0) restituisce false
	public double vendita(String nome, boolean nuovo) {
		Giochi gtemp;
		Double d;
		for (int i = 0; i < g.size(); i++) {
			if (g.get(i).getNome().equals(nome)) {			//cerco tra i giochi quello col nome uguale	
				gtemp = g.get(i);
				if (nuovo) {
					gtemp.quantitaNuovomenomeno();		//e quando lo trova gli sostituisce il prezzo
					vend.add(new GiocoVenduto(gtemp.getNome(), gtemp.getPrezzo_nuovo(), 
							new Date(System.currentTimeMillis()), nuovo));
					d=gtemp.getPrezzo_nuovo();
				}else {
					gtemp.quantitaUsatomenomeno();		//distinguendo tra nuovoe usato 
					vend.add(new GiocoVenduto(gtemp.getNome(), gtemp.getPrezzo_nuovo(), 
							new Date(System.currentTimeMillis()), nuovo));
					d=gtemp.getPrezzo_usato();
				}
				scritturaSuFileGiochi();
				scritturaSuFileVend();
				return d;
			}
		}
		return 0;
	}
	
	
	
	public void iscrivi(String nome, String cognome, String email) {
		iscr.add(new Iscritto(nome, cognome, email));
		scritturaSuFileIscritti();
	}
	
	
	
	
	
	
	
	
	
	//METODI LETTURA SCRITTURA DA FILE
	
	public void scritturaSuFileGiochi() {
		js.inserisci("GIOCHI", g);
		js.scritturaSuFile("FileGiochi.json");
	}
		
	public void letturaDaFileGiochi() {
		js.letturaDaFileJSON("FileGiochi.json");
		// TODO js.recupera(g)
	}
	
	public void scritturaSuFilePreo() {
		js.inserisci("GIOCHI", preo);
		js.scritturaSuFile("FilePreordina.json");
	}
		
	public void letturaDaFilePreo() {
		js.letturaDaFileJSON("FilePreordina.json");
		// TODO js.recupera(preo)
	}
	
	public void scritturaSuFileVend() {
		js.inserisci("GIOCHI", vend);
		js.scritturaSuFile("FileVenduti.json");
	}
		
	public void letturaDaFileVend() {
		js.letturaDaFileJSON("FileVenduti.json");
		// TODO js.recupera(vend)
	}
	
	public void scritturaSuFileIscritti() {
		js.inserisci("GIOCHI", iscr);
		js.scritturaSuFile("FileIscritti.json");
	}
		
	public void letturaDaFileIscritti() {
		js.letturaDaFileJSON("FileIscritti.json");
		// TODO js.recupera(iscr)
	}
	
}
