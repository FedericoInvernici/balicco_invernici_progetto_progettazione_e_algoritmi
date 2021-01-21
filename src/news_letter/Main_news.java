package news_letter;

import manager_filiare.ManagerControl;
import manager_filiare.ManagerModel;
import manager_filiare.ManagerView;

public class Main_news {

	public static void main(String[] args) {
		NewsModel nmodel = new NewsModel();
		NewsView nview = new NewsView(nmodel);
		NewsControl ncontrol = new NewsControl(nview, nmodel);
		nview.setVisible(true);
		System.out.println("esecuzione");
	}
}
