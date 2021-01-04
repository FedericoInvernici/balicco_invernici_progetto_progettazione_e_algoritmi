package Commesso;

import java.util.ArrayList;
import java.util.Date;

import Record.Giochi;
import Record.GiocoPrenotato;

public class CommessoModel {
	
	ArrayList<Giochi> g = new ArrayList<>();	//TODO utilizzo arraylist per testareù
	ArrayList<GiocoPrenotato> preo = new ArrayList<>();	//TODO utilizzo arraylist per testareù
	
	public CommessoModel() {
		// TODO 
	}
	
	public float prezzoacquisto(String nome, boolean nuovo)
	{
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
	
	
	
	public float ritirousato(String nome, int condizioni)
	{
		float prezzo = 0;
		for (int i = 0; i < g.size(); i++) {				//cerco tra i giochi quello col nome uguale
			if (g.get(i).getNome().equals(nome)) {			 
				prezzo = g.get(i).getPrezzo_usato();		 
			}
		}
		switch (condizioni) {
		case 1:
			break;
		case 2:
			prezzo=(float) (prezzo*0.75);		//in base all condizioni varia il prezzo (1:ottime,2:buone,3:brutte,4:pessime)
			break;
		case 3:
			prezzo=(float) (prezzo*0.5);
			break;
		case 4:
			prezzo=(float) (prezzo*0.25);
			break;
		}
		return prezzo;		//in caso non lo trovi ritornera prezzo=0
	}
	
	
	public void preordina(String nome, float prezzo, Date d, String email, String cliente){			 
		preo.add(new GiocoPrenotato( nome, prezzo, d, email, cliente));
	}
	
	
	
	
	
}
