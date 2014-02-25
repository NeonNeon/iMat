import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;


public class CartView extends JPanel {
private static final int WIDTH = 250;
private static final int HEIGHT = 681;

	/**
	 * Create the panel.
	 */
	public CartView() {
		setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout(0, 0));
		
		JLabel nameLabel = new JLabel("Stefan Svantesson");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font("DejaVu Sans", Font.BOLD, 20));
		add(nameLabel,BorderLayout.NORTH);
		
		JPanel cartPanel = new JPanel();
		cartPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		add(cartPanel, BorderLayout.CENTER);
	}

}
