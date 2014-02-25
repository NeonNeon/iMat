import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;


public class ProductView extends JPanel {

	/**
	 * Create the panel.
	 */
	public ProductView() {
		setBorder(new LineBorder(new Color(204, 255, 153), 1, true));
		setBackground(new Color(255, 255, 240));
		
		setSize(170, 216);
		setLayout(null);
		
		JLabel pictureLabel = new JLabel("New label");
		pictureLabel.setBounds(10, 11, 150, 109);
		add(pictureLabel);
		
		JLabel nameLabel = new JLabel("New label");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nameLabel.setBounds(10, 131, 116, 14);
		add(nameLabel);
		
		JLabel priceLabel = new JLabel("New label");
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		priceLabel.setBounds(10, 160, 116, 14);
		add(priceLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(10, 185, 40, 20);
		add(spinner);
		
		JLabel lblSt = new JLabel("st");
		lblSt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSt.setBounds(51, 187, 46, 14);
		add(lblSt);
		
		JButton favouriteButton = new JButton("New button");
		favouriteButton.setToolTipText("L\u00E4gg till som favorit");
		favouriteButton.setBounds(136, 127, 24, 23);
		add(favouriteButton);
		
		JButton addToListButton = new JButton("New button");
		addToListButton.setToolTipText("L\u00E4gg till i lista");
		addToListButton.setBounds(136, 156, 24, 23);
		add(addToListButton);
		
		JButton addToCartButton = new JButton("New button");
		addToCartButton.setToolTipText("L\u00E4gg till i varukorg");
		addToCartButton.setBounds(136, 184, 24, 23);
		add(addToCartButton);

	}
}
