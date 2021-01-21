package commesso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import commeso_dialog.DialogIscrivi;
import commeso_dialog.DialogPreordina1;
import commeso_dialog.DialogPreordina2;


public class CommessoControl {

	private CommessoView cview;
	private CommessoModel cmodel;
	
	public CommessoControl(CommessoView cv, CommessoModel cm) {
		cview=cv;
		cmodel=cm;
		cview.addAcqustanuovoListener(new acquistanuovo());
		cview.addAcqustausatoListener(new acquistausato());
		cview.addPreordinaListener(new preordina());
		cview.addUsatoListener(new usato());
		cview.addPrezzoListener(new prezzo());
		cview.addIscriviListener(new iscrivi());
	}
	
	
	//metodi dei button
	
	//cerca il gioco sctritto nel campo text e se lo trova ne
	//restituisce il prezzo
	class acquistanuovo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	String s;
        	double prezzo;
        	s = cview.getNomegiocoText();
        	prezzo = cmodel.vendita(s, true);
        	if(prezzo==0){
        		s="Gioco non disponibile";
        	}else{
        		s="Il gioco " + s + " costa: " + prezzo;
        	}
        	cview.setNomegiocoText(s);
        }
	}
	
	//uguale al metodo sopra, ma per i giochi usati
	class acquistausato implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	String s;
        	double prezzo;
        	s = cview.getNomegiocoText();
        	prezzo = cmodel.vendita(s, false);
        	if(prezzo==0){
        		s="Gioco non disponibile";
        	}else{
        		s="Il gioco " + s + " costa: " + prezzo;
        	}
        	cview.setNomegiocoText(s);
        }
	}
	
	
	//crea la queri per la prenotazione dei giochi
	class preordina implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	new DialogPreordina1(cmodel);	
        	new DialogPreordina2(cmodel);
        }
	}
	
	//cerca il gioco scritto nel campo text, ne restituisce il 
	//prezzo e aumenta la quantità di usato di quel gioco 
	class usato implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	String s;
        	double prezzo;
        	s = cview.getNomegiocoText();
        	prezzo = cmodel.ritirousato(s);
        	if(prezzo==0){
        		s="gioco non trovato";
        	}else{
        		s="Il gioco costa: " + prezzo;
        	}
        	cview.setNomegiocoText(s);
        }
	}
	
	//restituisce il prezo del gioco col nome nel campo text
	class prezzo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	String s;
        	double dn,du;
        	s = cview.getNomegiocoText();
        	dn=cmodel.trovaprezzo(s, true);
        	du=cmodel.trovaprezzo(s, false);
        	s=s+"p_nuovo: " + dn + " p_usato: " + du;
        	cview.setNomegiocoText(s);;
        }
	}
	
	//crea i campi necessari per l'iscrizione di nuovi clienti
	class iscrivi implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	new DialogIscrivi(cmodel);
        }
	}
	
}
