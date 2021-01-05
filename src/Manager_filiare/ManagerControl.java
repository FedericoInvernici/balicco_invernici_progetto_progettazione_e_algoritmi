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


public class ManagerControl {

	private ManagerView mview;
	private ManagerModel mmodel;
	
	public ManagerControl(ManagerView mv, ManagerModel mm) {
		mview=mv;
		mmodel=mm;
		mview.addOrdinaListener(new ordina());
		mview.addCambiaPrezzoListener(new cambiaprezzo());
		mview.addReportListener(new report());
	}
	
	
	//metodi dei button
	class ordina implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	new DialogOrdina();
        }
	}
	
	class cambiaprezzo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	new DialogPrezzo();
        	
        }
	}
	
	class report implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	//TODO
        }
	}
	
	
	
	
	
	
	
	
}
