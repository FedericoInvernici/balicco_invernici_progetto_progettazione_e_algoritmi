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
	
	//creo jdialog per il metodo oredina
	public static class DialogOrdina
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
	
	
	//creo jdialog per il metodo oredina
	public static class DialogPrezzo
	{ 
		 private static Dialog d;
		 JTextField nomegiocoText = new JTextField("Scrivi il gioco di cui cambiare il prezzo");
		 JTextField prezzogiocoText = new JTextField("Scegli il prezzo da dargli");
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
			            !nomegiocoText.getText().equals("Scrivi il gioco di cui cambiare il prezzo")) 
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
	
	
	
	
	
	
	
}
