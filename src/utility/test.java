package utility;

import java.util.ArrayList;
import java.util.Date;

import javax.xml.crypto.Data;



import Record.Giochi;
import Record.GiocoPrenotato;
import Record.GiocoVenduto;
import Record.Iscritto;

public class test {

	public static void main(String[] args) {
		ArrayList<Giochi> g = new ArrayList<>();
		ArrayList<Iscritto> listaIscritti = new ArrayList<Iscritto>();
		ArrayList<GiocoVenduto> listaGiochiV = new ArrayList<GiocoVenduto>();
		ArrayList<GiocoPrenotato> listaGiochiP = new ArrayList<GiocoPrenotato>();
		GestoreJson js = new GestoreJson();
		GestoreJson js2 = new GestoreJson();
		GestoreJson js3 = new GestoreJson();
		GestoreJson js4 = new GestoreJson();
		
		//Prova di scrittura e lettura su file JSON di tutti i quattro i file
		g.add(new Giochi("g2e", 6.0, 7.4, 3, 5, 70));
		g.add(new Giochi("g3e", 4.0, 3.4, 5, 5, 70));
		
		listaGiochiP.add(new GiocoPrenotato("prova1", 2.5, new Date(2000, 10, 10), "a@prova.it", "Pippo"));
		listaGiochiP.add(new GiocoPrenotato("prova2", 3.5, new Date(2010, 10, 10), "b@prova.it", "Pippone"));
		
		listaGiochiV.add(new GiocoVenduto("Gioco1", 50.2, new Date(2000, 10, 10), true));
		listaGiochiV.add(new GiocoVenduto("Gioco2", 80.2, new Date(2015, 6, 26), false));
		
		listaIscritti.add(new Iscritto("Pip", "po", "test@mail.it"));
		listaIscritti.add(new Iscritto("Pppppp", "po", "test2@mail.it"));
		
		js.inserisci("GIOCHI", g);
		js.scritturaSuFile("FileGiochi.json");
		js2.inserisci("ISCRITTI", listaIscritti);
		js2.scritturaSuFile("FileIscritti.json");
		js3.inserisci("GIOCHI PRENOTATI", listaGiochiP);
		js3.scritturaSuFile("FilePreordina.json");
		js4.inserisci("GIOCHI VENDUTI", listaGiochiV);
		js4.scritturaSuFile("FileVenduti.json");
		
		for(Object o:js.letturaDaFileJSON("FileIscritti.json")) {
			System.out.println(((Iscritto)o).toJSONString());
		}
		for(Object o:js.letturaDaFileJSON("FileGiochi.json")) {
			System.out.println(((Giochi)o).toJSONString());
		}
		for(Object o:js.letturaDaFileJSON("FilePreordina.json")) {
			System.out.println(((GiocoPrenotato)o).toJSONString());
		}
		for(Object o:js.letturaDaFileJSON("FileVenduti.json")) {
			System.out.println(((GiocoVenduto)o).toJSONString());
		}
		
		
	}
}
