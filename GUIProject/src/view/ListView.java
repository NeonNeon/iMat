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
		lblMinaListor.setFont(Constants.SUCHFONT.getFont());
		lblMinaListor.setForeground(Constants.TEXTCOLOR.getColor());
		lblMinaListor.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinaListor.setBounds(10, 11, 664, 69);
		add(lblMinaListor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 324, 478);
		add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(350, 92, 324, 478);
		add(scrollPane_1);
	}
}
