package Manager_filiare;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



//creo jdialog per il metodo oredina
public class DialogPrezzo
{ 
	private static Dialog d;
	private String s1="Scrivi il gioco da ordinare";
	private String s2="Scegli il prezzo da dargli";
	JTextField nomegiocoText = new JTextField(s1);
	JTextField prezzogiocoText = new JTextField(s2);
	JButton bcambia = new JButton("Cambia prezzo");
	JButton bannulla = new JButton("Annulla");
			 
	public DialogPrezzo() {
		JFrame f= new JFrame();  
		nomegiocoText.setEditable(true);
		prezzogiocoText.setEditable(true);
		d = new JDialog(f , "cambia il prezzo a un gioco", true); 
		d.setSize(400, 120);
		d.setLocation(450, 240);
				    
						
		bcambia.addActionListener(new ActionListener()  
		{  
			public void actionPerformed( ActionEvent e )  
			{  
				if (!nomegiocoText.getText().equals("") || 
				    !nomegiocoText.getText().equals(s1)) 
				{
				       //TODO
					DialogPrezzo.d.setVisible(false); 
				}else{
					String message="Devi prima scrivere una frase";
					JOptionPane.showMessageDialog(new JFrame(), message, "Errore", JOptionPane.ERROR_MESSAGE);
				}
			}  
		}); 
		bannulla.addActionListener(new ActionListener()  
		{  
			public void actionPerformed( ActionEvent e )  
			{  
				 DialogPrezzo.d.setVisible(false);  
			}  
		}); 	
					
		d.add(nomegiocoText,BorderLayout.NORTH);
		d.add(prezzogiocoText,BorderLayout.CENTER);	
		d.add(bcambia,BorderLayout.WEST);
		d.add(bannulla,BorderLayout.EAST);
		d.setVisible(true); 
	}  
}
