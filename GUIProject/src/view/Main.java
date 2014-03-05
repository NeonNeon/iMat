package view;
import controller.Director;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
		    public void run() {
		        Model.getInstance().shutDown();
		    }
		}));
		Director start = new Director();
		
	}

}
