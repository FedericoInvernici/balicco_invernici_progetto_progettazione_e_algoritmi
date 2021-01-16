package Record;

import java.util.ArrayList;

import org.json.simple.JSONAware;

public class Iscritto  implements JSONAware{

	String nome,cognome,email; 
	
	public Iscritto(String nome, String cognome, String email) {
		this.nome=nome;
		this.cognome=cognome;
		this.email=email; 
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public String getEmail() {
		return email;
	}

	@Override
	public String toJSONString() {
		String s;
		s= "{\"Nome\":\"" + nome+"\", \"Cognome\":" + cognome + ", \"Email\":" + email + "}";
		return s;
	}
}
