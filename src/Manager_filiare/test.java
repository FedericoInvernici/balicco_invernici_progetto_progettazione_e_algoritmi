package Manager_filiare;


public class test {

	public static void main(String[] args) {
		ManagerModel cmodel = new ManagerModel();
		ManagerView cview = new ManagerView(cmodel);
		ManagerControl ccontrol = new ManagerControl(cview, cmodel);
		cview.setVisible(true);
		System.out.println("esecuzione");
	}
	
	
	
	
	
}
