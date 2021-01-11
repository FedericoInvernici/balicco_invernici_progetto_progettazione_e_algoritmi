package utility;

import java.util.ArrayList;

import javax.xml.crypto.Data;

import Record.Giochi;
import Record.GiocoPrenotato;
import Record.GiocoVenduto;

public class test {

	public static void main(String[] args) {
		ArrayList<Giochi> g = new ArrayList<>();
		ArrayList<Integer> a = new ArrayList<>();
		GestoreJson js = new GestoreJson();
		GestoreFile fi = new GestoreFile();
		
		/*a.add(1);
		a.add(2);
		a.add(3);
		
		js.inserisci("giochi", a);
		System.out.println(js.toString());
		*/
		
		
		Giochi g1 = new Giochi("g2", 6.0, 7.4, 3, 5, 70);
		g.add(new Giochi("g2", 6.0, 7.4, 3, 5, 70));
		//g.add(new Giochi("g3", 4.0, 3.4, 5, 5, 70));
		js.inserisci("giochi", g);
		System.out.println(js.toString());
		System.out.println(g1.toString());
		//fi.creaFileJson("test1");
		//fi.scritturaSuFile("test1", js.toString());
	}
}
