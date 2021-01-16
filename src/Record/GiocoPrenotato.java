package Record;

import java.util.Date;

import org.json.simple.JSONAware;

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

	@Override
	public String toJSONString() {
		String s;
		s= "{\"Nome\":\"" + nome+"\", \"prezzo\":" + prezzo + ", \"anno\":" + data_uscita.getYear() +
				", \"mese\":" + data_uscita.getMonth() + ", \"giorno\":" + data_uscita.getDay() +
				", \"Email cliente\":" + email_cliente + ", \"Nome cliente\":" + nome_cliente+"}";
		return s;
	}

}
