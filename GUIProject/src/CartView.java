import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;


public class CartView extends JPanel {
private static final int WIDTH = 250;
private static final int HEIGHT = 681;

	/**
	 * Create the panel.
	 */
	public CartView() {
		setSize(WIDTH, HEIGHT);
		
		JLabel nameLabel = new JLabel("Stefan Svantesson");
		nameLabel.setFont(new Font("DejaVu Sans", Font.BOLD, 20));
		add(nameLabel);
	}

}
