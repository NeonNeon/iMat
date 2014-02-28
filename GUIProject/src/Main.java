import javax.swing.JTabbedPane;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchView searchView = new SearchView();
		CartView cartView = new CartView();
		StartView startView = new StartView();
		FrameView frame = new FrameView();
		JTabbedPane tabPane = new JTabbedPane();
		AccountView accountView = new AccountView();
		tabPane.addTab("Sortiment",startView);
		tabPane.setTabComponentAt(0, new Tab());
		tabPane.addTab("Uppgifter", accountView);
		tabPane.setTabComponentAt(1, new Tab());
		
		
		
		frame.addLeft(new SearchView());
		frame.addCenter(tabPane);
		frame.addRight(new CartView());
		frame.setVisible(true);
	}

}
