package Record;

import java.lang.reflect.Constructor;

public class Giochi {

	String nome;
	float prezzo_nuovo;
	float prezzo_usato;
	int quantita_nuovo;
	int quantita_usato;
	int quantita_preordinabile;
	
	public Giochi(String nome, float prezzo_nuovo, float prezzo_usato, int qnuovo, int qusato, int qprenotable) {
		this.nome=nome;
		this.prezzo_nuovo=prezzo_nuovo;
		this.prezzo_usato=prezzo_usato;
		this.quantita_nuovo=qnuovo;
		this.quantita_usato=qusato;
		this.quantita_preordinabile=qprenotable;
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

	public float getPrezzo_nuovo() {
		return prezzo_nuovo;
	}
	
	public float getPrezzo_usato() {
		return prezzo_usato;
	}
}
