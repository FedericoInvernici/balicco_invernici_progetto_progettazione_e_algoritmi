package commesso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import commesso_dialog.DialogIscrivi;
import commesso_dialog.DialogPreordina1;
import commesso_dialog.DialogPreordina2;
import commesso_dialog.DialogVendita;


public class CommessoControl {

	private CommessoView cview;
	private CommessoModel cmodel;
	
	public CommessoControl(CommessoView cv, CommessoModel cm) {
		cview=cv;
		cmodel=cm;
		cview.addAcqustanuovoListener(new acquistanuovo());
		cview.addPreordinaListener(new preordina());
		cview.addUsatoListener(new usato());
		cview.addPrezzoListener(new prezzo());
		cview.addIscriviListener(new iscrivi());
	}
	
	public boolean messaggioConfermaVendita(String nomeGioco, boolean nuovo) {
		String dialog;
		double prezzo = cmodel.trovaprezzo(nomeGioco, nuovo);
		if(prezzo==0){ //gioco non presente nel database, messaggio di errore
    		dialog= "Gioco inesistente nel database, non pu� essere comprato";
    		JOptionPane.showMessageDialog(new JFrame(),dialog,"Errore",JOptionPane.ERROR_MESSAGE);
    		return false;
    	}else{ 
    		//Il gioco � presente e si chiede al cliente se il costo va bene 
    		dialog="Gioco presente nel database. \n Il costo del gioco �: " + prezzo + " �\n Il cliente accetta l'importo?";
    		int a = JOptionPane.showConfirmDialog(new JFrame(),dialog,"Conferma", JOptionPane.YES_NO_OPTION); //Se viene schiacciato il tasto S�, si ritorna il valore 0
        	if (a==0)return true;
        	else return false;
    	}
	}
	
	//metodi dei button
	
	//cerca il gioco scritto nel campo text e se lo trova ne
	//restituisce il prezzo
	class acquistanuovo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	new DialogVendita(cmodel);
        	/*String s;
        	s = cview.getNomegiocoText();
        	if(messaggioConfermaVendita(s, true)) {
        		cmodel.vendita(s, true);
        	}

        	cview.setNomegiocoText("");*/
        }
	}
	
	//uguale al metodo sopra, ma per i giochi usati
	class acquistausato implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	String s;
        	s = cview.getNomegiocoText();
        	if(messaggioConfermaVendita(s, false)) {
        		cmodel.vendita(s, false);
        	}

        	cview.setNomegiocoText("");
        }
	}
	
	
	//crea la query per la prenotazione dei giochi
	class preordina implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	new DialogPreordina1(cmodel);	
        	new DialogPreordina2(cmodel);
        }
	}
	
	//cerca il gioco scritto nel campo text, ne restituisce il 
	//prezzo e aumenta la quantit� di usato di quel gioco 
	class usato implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	String s, dialog;
        	double prezzo;
        	s = cview.getNomegiocoText();
        	prezzo= 0.7*cmodel.trovaprezzo(s, false); //cerco se il gioco � nel database e quindi pu� essere accettato
        	if(prezzo==0){ //gioco non presente nel database, messaggio di errore
        		dialog= "Gioco inesistente nel database, non pu� essere accettato";
        		JOptionPane.showMessageDialog(new JFrame(),dialog,"Errore",JOptionPane.ERROR_MESSAGE);
        	}else{ 
        		//Il gioco � presente e si chiede al cliente se l'importo offerto dal negozio � accettabile
        		dialog="Gioco presente nel database. \n Il valore del gioco �: " + prezzo + " �\n Il cliente accetta l'importo?";
        		int a = JOptionPane.showConfirmDialog(new JFrame(),dialog,"Conferma", JOptionPane.YES_NO_OPTION); //Se viene schiacciato il tasto S�, si ritorna il valore 0
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
