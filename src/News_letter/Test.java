package News_letter;

import Manager_filiare.ManagerControl;
import Manager_filiare.ManagerModel;
import Manager_filiare.ManagerView;

public class Test {

	public static void main(String[] args) {
		NewsModel nmodel = new NewsModel();
		NewsView nview = new NewsView(nmodel);
		NewsControl ncontrol = new NewsControl(nview, nmodel);
		nview.setVisible(true);
		System.out.println("esecuzione");
	}
}
