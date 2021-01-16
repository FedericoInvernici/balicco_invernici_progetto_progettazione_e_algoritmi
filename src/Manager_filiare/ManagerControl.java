package Manager_filiare;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Manager_dialog.DialogNuovoGioco;
import Manager_dialog.DialogOrdina;
import Manager_dialog.DialogReport;
import Manager_dialog.DialogCambiaPrezzo;
import Manager_dialog.DialogNuoveCopie;


public class ManagerControl {

	private ManagerView mview;
	private ManagerModel mmodel;
	
	public ManagerControl(ManagerView mv, ManagerModel mm) {
		mview=mv;
		mmodel=mm;
		mview.addOrdinaListener(new ordina());
		mview.addCambiaPrezzoListener(new cambiaprezzo());
		mview.addReportListener(new report());
		mview.addNuovoGiocoListener(new nuovogioco());
		mview.addNuovaCopiaListener(new nuovacopia());
	}
	
	
	//metodi dei button
	class ordina implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	new DialogOrdina(mmodel);
        }
	}
	
	class cambiaprezzo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	new DialogCambiaPrezzo(mmodel);
        	
        }
	}
	
	class report implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	new DialogReport(mmodel);
        }
	}
	
	class nuovogioco implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	new DialogNuovoGioco(mmodel);
        }
	}
	
	class nuovacopia implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	new DialogNuoveCopie(mmodel);
        }
	}
	
	
	
	
	
	
	
	
}