package Commesso;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CommessoView extends JFrame {
	
	private JLabel 	   label1			 = new JLabel("Inserisci nome gioco");
    private JTextField nomegiocoText     = new JTextField(30);
    private JButton    acquistaButton 	 = new JButton("Acquista gioco");
    private JButton    preordinaButton   = new JButton("Preordina gioco"); 
    private JButton    usatoButton    	 = new JButton("Ritira usato");
	private CommessoModel cmodel;
    
	public CommessoView (CommessoModel c)
	{
		cmodel = c;
		JPanel content = new JPanel();
		content.setLayout(new FlowLayout());
        content.add(label1);
        content.add(nomegiocoText);
        content.add(acquistaButton);
        content.add(preordinaButton);
        content.add(usatoButton);
        this.setContentPane(content);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(400, 200, 500, 200);
	}
	
	
	void addAcqustaListener(ActionListener m) {
		acquistaButton.addActionListener(m);
    }
	
	void addPreordinaListener(ActionListener m) {
		preordinaButton.addActionListener(m);
    }
	
	void addUsatoListener(ActionListener m) {
		usatoButton.addActionListener(m);
    }
	
}
