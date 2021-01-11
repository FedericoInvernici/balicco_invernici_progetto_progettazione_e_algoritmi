package Record;

import java.lang.reflect.Constructor;

public class Giochi {

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
	
	public void quantitaUsatomenomeno() {
		this.quantita_usato--;
	}
	
	public void quantitaNuovomenomeno() {
		this.quantita_nuovo--;
	}
	
	public String toJSONString() {
		String s;
		s="Nome: " + nome+" p_nuovi: " + prezzo_nuovo + " p_usati " + prezzo_usato + " q_nuovi: " + quantita_nuovo +
				" q_usati: " + quantita_usato + " q_preordinabili: " + quantita_preordinabile;
		return s;
	}
}
