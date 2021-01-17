package Record;

import java.util.Date;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

public class GiocoPrenotato extends Gioco implements JSONAware{

	double prezzo;
	Date data_uscita;
	String email_cliente;
	String nome_cliente;
	
	public GiocoPrenotato(String nome, Double prezzo, Date d, String email, String cliente) {
		super(nome);
		this.prezzo=prezzo;
		this.data_uscita=d;
		this.email_cliente=email;
		this.nome_cliente=cliente;
	}
	// Costruttore a partire da un JSONObject (letto da file)
	public GiocoPrenotato(JSONObject jso) {
		this.nome=(String) jso.get("Nome");
		this.prezzo=(double) jso.get("prezzo");
		this.data_uscita= new Date((int)(long)jso.get("anno"), (int)(long)jso.get("mese"), (int)(long)jso.get("giorno"));
		this.email_cliente= (String) jso.get("Email cliente");
		this.nome_cliente= (String) jso.get("Nome cliente");
	}

	@Override
	public String toJSONString() {
		String s;
		s= "{\"Nome\":\"" + nome+"\", \"prezzo\":" + prezzo + ", \"anno\":" + data_uscita.getYear() +
				", \"mese\":" + data_uscita.getMonth() + ", \"giorno\":" + data_uscita.getDay() +
				", \"Email cliente\":\"" + email_cliente + "\", \"Nome cliente\":\"" + nome_cliente+"\"}";
		return s;
	}

}
