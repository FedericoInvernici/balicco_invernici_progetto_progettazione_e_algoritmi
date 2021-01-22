package commesso_dialog;

import java.text.SimpleDateFormat;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import commesso.CommessoModel;
import manager_dialog.DialogCambiaPrezzo;

public class DialogPreordina1 {
	private static Dialog d;
	private String s1="Scrivi il nome gioco";
	private String s2="Scrivi il prezzo";
	private String s3="gg/mm/yyyy";
	JTextField giocoText = new JTextField(s1);
	JTextField prezzoText = new JTextField(s2);
	JTextField dataText = new JTextField(s3);
	JButton bprocedi = new JButton("Procedi");
	CommessoModel cm;
		 
	public DialogPreordina1(CommessoModel m) {
		   JFrame f= new JFrame();  
		   cm = m;
		   giocoText.setEditable(true);
		   prezzoText.setEditable(true);
		   dataText.setEditable(true);
		   d = new JDialog(f , "Scrivi il gioco da prenotare", true);
		   d.setSize(400, 120);
		   d.setLocation(450, 240);
				
		   bprocedi.addActionListener(new ActionListener()  
		   {  
		       public void actionPerformed( ActionEvent e )  
		       {
		    	   	try {
		    	   		if (!giocoText.getText().equals("") || !giocoText.getText().equals(s1) ||
		    	   				!prezzoText.getText().equals("") || !prezzoText.getText().equals(s2) ||
		    	   				!dataText.getText().equals("") || !dataText.getText().equals(s3) ) 
		    	   		{
		    	   			java.util.Date d = new SimpleDateFormat("dd/MM/yyyy").parse(dataText.getText());; 
		    	   			cm.preordina(giocoText.getText(), Double.parseDouble(prezzoText.getText()),d,"","");
							DialogPreordina1.d.setVisible(false);   
		    	   		}else{
		    	   			String message="Devi inserire i dati correttamente";
		    	   			JOptionPane.showMessageDialog(new JFrame(),message,"Errore",JOptionPane.ERROR_MESSAGE);
		    	   		}
		    	   	}
		    	   	catch (Exception e2) {
		    	   		System.out.println("Devi inserire i dati correttamente");
		            }
		    	 
		       }  
		   }); 
		   d.add(giocoText,BorderLayout.NORTH);
		   d.add(prezzoText,BorderLayout.WEST);
		   d.add(dataText,BorderLayout.EAST);
		   d.add(bprocedi,BorderLayout.SOUTH);		
		   d.setVisible(true); 
	}  
	
	
}
