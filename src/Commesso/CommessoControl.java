package Commesso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Commeso_Dialog.DialogAcquista;
import Commeso_Dialog.DialogGetPrezzo;
import Commeso_Dialog.DialogIscrivi;
import Commeso_Dialog.DialogPreordina;
import Commeso_Dialog.DialogRitiroUsato;


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
	class acquistanuovo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	String s;
        	double prezzo;
        	s = cview.getNomegiocoText();
        	prezzo = cmodel.vendita(s, true);
        	if(prezzo==0){
        		s="gioco non trovato";
        	}else{
        		s="Il gioco " + s + " costa: " + prezzo;
        	}
        	cview.setNomegiocoText(s);
        }
	}
	
	class acquistausato implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	String s;
        	double prezzo;
        	s = cview.getNomegiocoText();
        	prezzo = cmodel.vendita(s, true);
        	if(prezzo==0){
        		s="gioco non trovato";
        	}else{
        		s="Il gioco " + s + " costa: " + prezzo;
        	}
        	cview.setNomegiocoText(s);
        }
	}
	
	class preordina implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	new DialogPreordina();	//TODO
        }
	}
	
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
	
	class iscrivi implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	new DialogIscrivi(cmodel);
        }
	}
	
}
