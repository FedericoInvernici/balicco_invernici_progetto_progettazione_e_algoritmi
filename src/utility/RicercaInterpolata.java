package utility;

import java.lang.Math;

public class RicercaInterpolata {
	
	/* Metodo richiamabile per la ricerca in un vettore di oggetti che implementano l'interfaccia "ValoreIntero".
	 * Parametri: vett[] = vettore dove effettuare la ricerca
	 			  elem = elemento da ricercare
	 */
	static public <T extends ValoreIntero> boolean TrovaElemento(T vett[], T elem) {
		return TrovaElementoInterp(vett, elem, 0, vett.length-1);
	}
	
	/* Metodo interno ricorsivo per la ricerca interpolata in vettori di oggetti con interfaccia "ValoreIntero"
	 * 
	 */
	public static <T extends ValoreIntero> boolean TrovaElementoInterp(T vett[], T elem, int iniz, int fine) {
		int indice= iniz + (fine-iniz)*(elem.interoPerRicerca()-vett[iniz].interoPerRicerca())/
				(vett[fine].interoPerRicerca()-vett[iniz].interoPerRicerca());
		System.out.println("Inizio:"+iniz+"  Fine: "+ fine +" Indice: "+ indice);
		if(indice<iniz||indice>fine) return false;
		else if(vett[indice].interoPerRicerca()==elem.interoPerRicerca()) return true;
		else if(vett[indice].interoPerRicerca()<elem.interoPerRicerca()) return TrovaElementoInterp(vett, elem, indice, fine);
		else if(vett[indice].interoPerRicerca()>elem.interoPerRicerca()) return TrovaElementoInterp(vett, elem, iniz, indice);
		else return false;		
	}
	
	/* Metodo richiamabile per la ricerca in un vettore di oggetti che implementano l'interfaccia "Comperable".
	 * Pensato per la ricerca con le Stringhe
	 * Parametri: vett[] = vettore dove effettuare la ricerca
	 			  elem = elemento da ricercare
	 */
	public static <T extends Comparable> boolean TrovaElementoComp(T vett[], T elem) {
		return TrovaElementoCompInt(vett, elem, 0, vett.length-1);
	}


	private static <T extends Comparable> boolean TrovaElementoCompInt(T[] vett, T elem, int iniz, int fine) {
		if(iniz==fine) return false; //previene la divisione per zero nel calcolo dell'indice
		int indice= iniz + Math.round((fine-iniz)*(elem.compareTo(vett[iniz])/
				vett[fine].compareTo(vett[iniz])));
		System.out.println("Inizio:"+iniz+"  Fine: "+ fine +" Indice: "+ indice);
		if(indice<iniz||indice>fine) return false;
		else if(vett[indice].compareTo(elem)==0) return true;
		else if(vett[indice].compareTo(elem)<0) return TrovaElementoCompInt(vett, elem, indice+1, fine);
		else return TrovaElementoCompInt(vett, elem, iniz, indice-1);	
	}
	
}
