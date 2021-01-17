package utility;

import java.util.ArrayList;

import javax.xml.crypto.Data;

import org.json.JSONObject;

import Record.Giochi;
import Record.GiocoPrenotato;
import Record.GiocoVenduto;

public class test {

	public static void main(String[] args) {
		ArrayList<Giochi> g = new ArrayList<>();
		ArrayList<Giochi> g1 = new ArrayList<>();
		GestoreJson js = new GestoreJson();
		
		GestoreJson js1 = new GestoreJson();
		
		//prova di: creazione file JSON -> scrittura su file di un oggetto -> creazione di oggetto da file JSON
		js.creaFileJson("ppp");
		g.add(new Giochi("g2e", 6.0, 7.4, 3, 5, 70));
		g.add(new Giochi("g3e", 4.0, 3.4, 5, 5, 70));
		


		js.inserisci("giochi", g);
		js.scritturaSuFile("filediprova.json");
		
		g1=(ArrayList<Giochi>) js.letturaDaFileJSON("filediprova.json");
		System.out.println("G1=  "+g1.get(0).toJSONString());
		System.out.println("G2=  "+g1.get(1).toJSONString());
		
		
	}
}
