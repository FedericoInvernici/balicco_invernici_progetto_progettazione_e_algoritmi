package Record;

import java.util.Date;
import java.util.spi.TimeZoneNameProvider;

import javax.xml.crypto.Data;

public class GiocoVenduto extends Gioco{

	float prezzo;
	Date data_vendita;
	boolean nuovo;
	
	public GiocoVenduto(String nome, float prezzo, Date d, boolean nuovo) {
		super(nome);
		this.prezzo=prezzo;
		this.data_vendita=d;
		this.nuovo=nuovo;
	}
	
	public Date getData_vendita() {
		return data_vendita;
	}
	
	public void setData_vendita(Date data_vendita) {
		this.data_vendita = data_vendita;
	}
	
	public float getPrezzo() {
		return prezzo;
	}
	
}
