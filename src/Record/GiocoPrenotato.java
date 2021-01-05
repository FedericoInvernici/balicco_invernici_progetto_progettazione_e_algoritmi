package Record;

import java.util.Date;

public class GiocoPrenotato extends Gioco{

	float prezzo;
	Date data_uscita;
	String email_cliente;
	String nome_cliente;
	
	public GiocoPrenotato(String nome, float prezzo, Date d, String email, String cliente) {
		super(nome);
		this.prezzo=prezzo;
		this.data_uscita=d;
		this.email_cliente=email;
		this.nome_cliente=cliente;
	}

}
