package News_letter;

import java.util.ArrayList;

import Record.Iscritto;

public class NewsModel {

	ArrayList<Iscritto> iscr = new ArrayList<>();	//TODO utilizzo arraylist per testare
	
	public void spedisci(String testo) {
		for (int i = 0; i < iscr.size(); i++) {
			//FINTO METODO SPEDIZIONE TESTO A ISCR.GET(I).getemail()
		}
	}
	
}
