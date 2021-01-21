package record;

import java.lang.reflect.Constructor;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;



public class Giochi  implements JSONAware,Comparable{

	String nome;
	double prezzo_nuovo;
	double prezzo_usato;
	int quantita_nuovo;
	int quantita_usato;
	int quantita_preordinabile;
	
	public Giochi(String nome, Double prezzo_nuovo, Double prezzo_usato, int qnuovo, int qusato, int qprenotable) {
		this.nome=nome;
		this.prezzo_nuovo=prezzo_nuovo;
		this.prezzo_usato=prezzo_usato;
		this.quantita_nuovo=qnuovo;
		this.quantita_usato=qusato;
		this.quantita_preordinabile=qprenotable;
	}

	public Giochi(String string, int i, int j, int k) {
		this.nome=string;
		this.quantita_nuovo=i;
		this.quantita_usato=j;
		this.quantita_preordinabile=k;
	}
	
	// Costruttore a partire da un JSONObject (letto da file)
	public Giochi(JSONObject jso) {
		this.nome= (String) jso.get("nome");
		this.prezzo_nuovo=(double) jso.get("p_usati");
		this.prezzo_usato=(double) jso.get("p_nuovi");
		this.quantita_nuovo= (int)(long)jso.get("q_nuovi");
		this.quantita_usato=(int)(long) jso.get("q_usati");
		this.quantita_preordinabile=(int)(long) jso.get("q_preordinabili");
	}

	public String getNome() {
		return nome;
	}
	
	public void setPrezzo_nuovo(float prezzo_nuovo) {
		this.prezzo_nuovo = prezzo_nuovo;
	}
	
	public void setPrezzo_usato(float prezzo_usato) {
		this.prezzo_usato = prezzo_usato;
	}

	public double getPrezzo_nuovo() {
		return prezzo_nuovo;
	}
	
	public double getPrezzo_usato() {
		return prezzo_usato;
	}
	
	public void aggiungiQnuovo(int q) {
		this.quantita_nuovo=this.quantita_nuovo+q;
	}
	
	public void aggiungiQusato(int q) {
		this.quantita_usato=this.quantita_usato+q;
	}
	
	public void quantitaUsatopiupiu() {
		this.quantita_usato++;
	}
	
	public void quantitaUsatomenomeno() {
		this.quantita_usato--;
	}
	
	public void quantitaNuovomenomeno() {
		this.quantita_nuovo--;
	}
	/*
	 * Metodo dell'interfaccia JSONAware, che richiede di restituire i dati della classe in un formato compatibile al JSON.
	 * La stringa deve essere perciò conforme agli standard per essere parsata correttamente.
	 */
	public String toJSONString() {
		String s;
		s= "{\"nome\":\"" + nome+"\", \"p_nuovi\":" + prezzo_nuovo + ", \"p_usati\":" + prezzo_usato + ", \"q_nuovi\":" + quantita_nuovo +
				", \"q_usati\":" + quantita_usato + ", \"q_preordinabili\":" + quantita_preordinabile+"}";
		return s;
	}
	
	public int compareTo(Object o){
		return this.getNome().compareTo(((Giochi) o).getNome());
	}

	
	
}
