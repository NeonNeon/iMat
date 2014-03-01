package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import se.chalmers.ait.dat215.project.Product;


public class TestCartClass extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestCartClass frame = new TestCartClass();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestCartClass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		CartView view = new CartView();
		contentPane.add(view);
		Model model = Model.getInstance();
		List<Product> list = model.getProducts(NewCategorys.FRUKT_OCH_BAR);
		
//		for(Product p:list) {
//			view.addShoppingItem(p);
//		}
		
		view.addShoppingItem(list.get(0));
		view.addShoppingItem(list.get(1));
		view.addShoppingItem(list.get(2));
		view.addShoppingItem(list.get(3));
		view.addShoppingItem(list.get(4));
		view.addShoppingItem(list.get(5));
		view.addShoppingItem(list.get(6));
		view.addShoppingItem(list.get(7));
		view.addShoppingItem(list.get(2));
		view.addShoppingItem(list.get(2));
		
		setContentPane(contentPane);
	}

}
