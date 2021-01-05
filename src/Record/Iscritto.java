package Record;

import java.util.ArrayList;

public class Iscritto {

	String nome,cognome,email;
	ArrayList<String> generi_seguiti = new ArrayList<>();
	
	public Iscritto(String nome, String cognome, String email, ArrayList<String > s) {
		this.nome=nome;
		this.cognome=cognome;
		this.email=email;
		this.generi_seguiti = s;
	}
	
	public String getEmail() {
		return email;
	}
}
