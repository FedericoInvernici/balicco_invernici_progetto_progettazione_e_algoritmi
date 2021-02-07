package news_letter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class NewsControl {

	private NewsView nview;
	private NewsModel nmodel;
	
	public NewsControl(NewsView nv, NewsModel nm) {
		nview=nv;
		nmodel=nm;
		nview.addAcqustaListener(new spedisci());
	}
	
	
	//metodi dei button
	class spedisci implements ActionListener {
        public void actionPerformed(ActionEvent e) { 
        	if(!nview.textArea.getText().equals("")) {
        	nmodel.spedisci(nview.textArea.getText());
        	JOptionPane.showMessageDialog(new JFrame(),"Mail inviata a tutti gli iscritti","Conferma",JOptionPane.INFORMATION_MESSAGE);
        	} else {
        		JOptionPane.showMessageDialog(new JFrame(),"Mail non inviata, inserire corpo mail nella casella di testo","Errore",JOptionPane.ERROR_MESSAGE);
        	}
        }
	}
	
	
}