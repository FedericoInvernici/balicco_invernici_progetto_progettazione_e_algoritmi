package Manager_filiare;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ManagerView extends JFrame {
	
	private JTextField nomegiocoText     = new JTextField(30);
	private JButton    ordinaButton 	 = new JButton("Ordina un gioco");
	private JButton    cambiaprezzoButton   = new JButton("Cambia il prezzo a gioco"); 
	private JButton    reportButton    	 = new JButton("Chiedi report");
	private ManagerModel mmodel;
	
	public ManagerView(ManagerModel m) {
		mmodel = m;
		JPanel content = new JPanel();
		content.setLayout(new FlowLayout());
        content.add(nomegiocoText);
        content.add(ordinaButton);
        content.add(cambiaprezzoButton);
        content.add(reportButton);
        this.setContentPane(content);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(400, 200, 500, 200);
	}
	
	


	void addOrdinaListener(ActionListener m) {
		ordinaButton.addActionListener(m);
    }
	
	void addCambiaPrezzoListener(ActionListener m) {
		cambiaprezzoButton.addActionListener(m);
    }
	
	void addReportListener(ActionListener m) {
		reportButton.addActionListener(m);
    }
	
	
	
	
}
