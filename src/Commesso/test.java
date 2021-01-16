package Commesso;

import org.json.JSONString; //libreria per la gestione di JSON
import utility.GestoreFile;
import utility.GestoreJson;
import utility.ValoreIntero; //interfaccia per la ricerca interpolata
import utility.RicercaInterpolata;


public class test {

	
	public static void main(String[] args) {
		CommessoModel cmodel = new CommessoModel();
		CommessoView cview = new CommessoView(cmodel);
		CommessoControl ccontrol = new CommessoControl(cview, cmodel);
		cview.setVisible(true);
		System.out.println("esecuzione");
	}
	
}
