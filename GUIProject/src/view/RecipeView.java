package view;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;


public class RecipeView extends JPanel {

	/**
	 * Create the panel.
	 */
	public RecipeView() {
		setBorder(new LineBorder(new Color(255, 105, 64), 2, true));
		setBackground(new Color(255, 243, 240));
		setSize(684, 581);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 11, 317, 251);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Laga n\u00E5got nytt ikv\u00E4ll?");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(337, 11, 337, 35);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(347, 57, 148, 99);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(515, 163, 148, 99);
		add(lblNewLabel_3);
		
		JLabel lblVeckansRecept = new JLabel("Veckans recept");
		lblVeckansRecept.setHorizontalAlignment(SwingConstants.CENTER);
		lblVeckansRecept.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVeckansRecept.setBounds(251, 325, 181, 35);
		add(lblVeckansRecept);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(10, 395, 83, 67);
		add(lblNewLabel_4);
		
		JLabel label = new JLabel("New label");
		label.setBounds(103, 395, 89, 67);
		add(label);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(202, 395, 83, 67);
		add(label_1);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(295, 395, 89, 67);
		add(label_2);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setBounds(394, 395, 83, 67);
		add(label_3);
		
		JLabel label_4 = new JLabel("New label");
		label_4.setBounds(487, 395, 89, 67);
		add(label_4);
		
		JLabel label_5 = new JLabel("New label");
		label_5.setBounds(585, 395, 89, 67);
		add(label_5);
		
		JLabel lblMndag = new JLabel("M\u00E5ndag");
		lblMndag.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMndag.setHorizontalAlignment(SwingConstants.CENTER);
		lblMndag.setBounds(10, 362, 83, 22);
		add(lblMndag);
		
		JLabel lblOnsdag = new JLabel("Onsdag");
		lblOnsdag.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnsdag.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOnsdag.setBounds(202, 362, 83, 22);
		add(lblOnsdag);
		
		JLabel lblTisdag = new JLabel("Tisdag");
		lblTisdag.setHorizontalAlignment(SwingConstants.CENTER);
		lblTisdag.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTisdag.setBounds(103, 364, 89, 19);
		add(lblTisdag);
		
		JLabel lblTorsdag = new JLabel("Torsdag");
		lblTorsdag.setHorizontalAlignment(SwingConstants.CENTER);
		lblTorsdag.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTorsdag.setBounds(295, 365, 89, 19);
		add(lblTorsdag);
		
		JLabel lblFredag = new JLabel("Fredag");
		lblFredag.setHorizontalAlignment(SwingConstants.CENTER);
		lblFredag.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFredag.setBounds(394, 362, 83, 22);
		add(lblFredag);
		
		JLabel lblLrdag = new JLabel("L\u00F6rdag");
		lblLrdag.setHorizontalAlignment(SwingConstants.CENTER);
		lblLrdag.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLrdag.setBounds(487, 365, 89, 19);
		add(lblLrdag);
		
		JLabel lblSndag = new JLabel("S\u00F6ndag");
		lblSndag.setHorizontalAlignment(SwingConstants.CENTER);
		lblSndag.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSndag.setBounds(585, 367, 89, 19);
		add(lblSndag);

	}
}
