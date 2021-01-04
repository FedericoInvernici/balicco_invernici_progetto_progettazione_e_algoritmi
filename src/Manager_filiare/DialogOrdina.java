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
public class DialogOrdina
{ 
	private static Dialog d;
	JTextField nomegiocoText = new JTextField("Scrivi il gioco da ordinare");
	JButton bordina = new JButton("Ordina");
	JButton bannulla = new JButton("Annulla");
		 
	public DialogOrdina() {
		   JFrame f= new JFrame();  
		   nomegiocoText.setEditable(true); 
		   d = new JDialog(f , "ordina un gioco", true);
		   d.setSize(400, 120);
		   d.setLocation(450, 240);
				
		   bordina.addActionListener(new ActionListener()  
		   {  
		       public void actionPerformed( ActionEvent e )  
		       {  
		            if (!nomegiocoText.getText().equals("") || 
		            	!nomegiocoText.getText().equals("Scrivi il gioco da ordinare")) 
					{
						//TODO
		            	DialogOrdina.d.setVisible(false); 
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
		           DialogOrdina.d.setVisible(false);  
		       }  
		  }); 
				 
		   d.add(nomegiocoText,BorderLayout.NORTH);
		   d.add(bordina,BorderLayout.CENTER);		
		   d.add(bannulla,BorderLayout.SOUTH);
		   d.setVisible(true); 
	}  
}
	
