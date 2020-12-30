package Commesso;

import utility.GestoreFile;

public class test {

	
	public static void main(String[] args) {
		CommessoModel cmodel = new CommessoModel();
		CommessoView cview = new CommessoView(cmodel);
		CommessoControl ccontrol = new CommessoControl(cview, cmodel);
		cview.setVisible(true);
		System.out.println("esecuzione");
		
		GestoreFile fileManager = new GestoreFile();
		//test creazione e scrittura file json
		fileManager.creaFileJson("filediprova");
		fileManager.scritturaSuFile("filediprova.json", "{prova : pippo}");
	}
}
