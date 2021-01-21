package commesso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
        	String s, dialog;
        	double prezzo;
        	s = cview.getNomegiocoText();
        	prezzo= 0.7*cmodel.trovaprezzo(s, false); //cerco se il gioco è nel database e quindi può essere accettato
        	//prezzo = cmodel.ritirousato(s);
        	if(prezzo==0){
        		dialog= "Gioco inesistente nel database, non può essere accettato";
        		JOptionPane.showMessageDialog(new JFrame(),dialog,"Errore",JOptionPane.ERROR_MESSAGE);
        	}else{
        		dialog="Gioco presente nel database. \n Il valore del gioco è: " + prezzo + " €\n Il cliente accetta l'importo?";
        		int a = JOptionPane.showConfirmDialog(new JFrame(),dialog,"Conferma", JOptionPane.YES_NO_OPTION);
            	if (a==0) {
            		cmodel.ritirousato(s);
            	}
        	}
        	cview.setNomegiocoText("");
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
