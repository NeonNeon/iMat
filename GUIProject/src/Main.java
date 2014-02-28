
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FrameView frame = new FrameView();
		
		frame.addLeft(new SearchView());
		frame.addCenter(new StartView());
		frame.addRight(new CartView());
		frame.setVisible(true);
	}

}
