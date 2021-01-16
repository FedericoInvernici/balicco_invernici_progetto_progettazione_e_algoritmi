package Manager_dialog;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Manager_filiare.ManagerModel;


//creo jdialog per il metodo oredina
public class DialogOrdina
{ 
	private static Dialog d;
	private String s1="Scrivi il gioco da ordinare";
	JTextField nomegiocoText = new JTextField(s1);
	JButton bordina = new JButton("Ordina");
	JButton bannulla = new JButton("Annulla");
	ManagerModel mm;
		 
	public DialogOrdina(ManagerModel m) {
		   JFrame f= new JFrame();  
		   mm = m;
		   nomegiocoText.setEditable(true); 
		   d = new JDialog(f , "Ordina un gioco", true);
		   d.setSize(400, 120);
		   d.setLocation(450, 240);
				
		   bordina.addActionListener(new ActionListener()  
		   {  
		       public void actionPerformed( ActionEvent e )  
		       {  
		            if (!nomegiocoText.getText().equals("") || 
		            	!nomegiocoText.getText().equals(s1)) 
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
	
