package Commesso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CommessoControl {

	private CommessoView cview;
	private CommessoModel cmodel;
	
	public CommessoControl(CommessoView cv, CommessoModel cm) {
		cview=cv;
		cmodel=cm;
		cview.addAcqustaListener(new acquista());
		cview.addPreordinaListener(new prestito());
		cview.addUsatoListener(new usato());
	}
	
	
	//metodi dei button
	class acquista implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	//TODO
        }
	}
	
	class prestito implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	//TODO
        }
	}
	
	class usato implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	//TODO
        }
	}
	
}
