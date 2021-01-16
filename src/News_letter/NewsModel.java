package News_letter;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import Finte_applicazioni_esterne.Finto_gestore_mail;
import Record.Iscritto;
import utility.GestoreJson;

public class NewsModel {

	ArrayList<Iscritto> iscr = new ArrayList<>();	//TODO utilizzo arraylist per testare
	Finto_gestore_mail gm = new Finto_gestore_mail();
	GestoreJson js = new GestoreJson();
	
	public NewsModel() { 
		//letturaDaFileIscritti();
	}
	
	public void spedisci(String testo) { 
		for (int i = 0; i < iscr.size(); i++) {  
			gm.InviaMailPerFinta(iscr.get(i).getEmail(), testo);
		}
	}
	
	
		
	public void letturaDaFileIscritti() {
		js.letturaDaFileJSON("FileIscritti.json");
		// TODO js.recupera(iscr)
	}
	
}
