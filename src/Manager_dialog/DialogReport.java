package Manager_dialog;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Commesso.CommessoModel;
import Manager_filiare.ManagerModel;

public class DialogReport
{ 
	private static Dialog d;
	private String s1					="Di quanti mesi vuoi il report?";
	JTextField mesiText	 				= new JTextField(s1); 
	JButton bprocedi 					= new JButton("Procedi");
	JTextArea textArea 					= new JTextArea(30, 45);
	JScrollPane scroll 					= new JScrollPane (textArea);
	ManagerModel mm;
		 
	public DialogReport(ManagerModel m) {
		   JFrame f= new JFrame();  
		   mm = m;
		   mesiText.setEditable(true); 
		   d = new JDialog(f , "Chiedi un report", true);
		   d.setSize(700, 550);
		   d.setLocation(300, 140);
				
		   bprocedi.addActionListener(new ActionListener()  
		   {  
		       public void actionPerformed( ActionEvent e )  
		       {
		    	   	try {
		    	   		if (!mesiText.getText().equals("") || !mesiText.getText().equals(s1)) 
		    	   		{
		    	   			mm.reportdata(Integer.parseInt(mesiText.getText()));
		    	   		}else{
		    	   			String message="Devi inserire i dati correttamente";
		    	   			JOptionPane.showMessageDialog(new JFrame(),message,"Errore",JOptionPane.ERROR_MESSAGE);
		    	   		}
		    	 } catch (NumberFormatException e1) {
		    		 System.out.println("Devi inserire i dati correttamente");
		    	 }
		       }  
		   });  
		   d.add(mesiText,BorderLayout.WEST);
		   d.add(bprocedi,BorderLayout.EAST);
		   d.add(scroll,BorderLayout.SOUTH);		
		   d.setVisible(true); 
	}  
	
	
}
	
