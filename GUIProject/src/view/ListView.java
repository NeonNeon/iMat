package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

public class ListView extends JPanel {
	
	private Color background = Constants.BACKGROUNDCOLOR.getColor();
	private Color borderColor = Constants.HOVERCOLOR.getColor();
	

	/**
	 * Create the panel.
	 */
	public ListView() {
		setSize(684, 581);
		setLayout(null);
		
		setBackground(background);
		setBorder(new LineBorder(borderColor, 2, true));
		
		JLabel lblMinaListor = new JLabel("Mina listor");
		lblMinaListor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMinaListor.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinaListor.setBounds(10, 11, 664, 33);
		add(lblMinaListor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 324, 515);
		add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(350, 55, 324, 515);
		add(scrollPane_1);
	}
}
