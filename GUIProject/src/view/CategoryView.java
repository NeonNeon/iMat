package view;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

import se.chalmers.ait.dat215.project.*;
import se.chalmers.ait.dat215.project.util.*;

import java.awt.event.*;

/**
 * This is the small view of a category when browsing the sortiment.
 * @author Grupp16
 *
 */
public class CategoryView extends JPanel {
	private final static Model model = Model
			.getInstance();
	private String name;
	private ImageIcon icon;
	private Color hoverColor = new Color(255,0,0);
	private Color originalColor = new Color(0,0,0);
	private JLabel categoryLabel;
	
	public CategoryView(String name, ImageIcon icon) {
		setBackground(new Color(255, 243, 240));
		
		MouseAdapter myMouseListener = new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
				categoryLabel.setForeground(hoverColor);
					
				
			}
			
			public void mouseExited(MouseEvent ev){
				categoryLabel.setForeground(originalColor);
			}
		};
		
		this.name = name;
		this.icon = icon;
		setLayout(null);
		setPreferredSize(new Dimension(200, 273));
		
		categoryLabel = new JLabel(name, JLabel.CENTER);
		categoryLabel.setBounds(12, 13, 176, 40);
		categoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		categoryLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		categoryLabel.addMouseListener(myMouseListener);
		add(categoryLabel);
		
		JButton imageButton = new JButton(icon);
		imageButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		imageButton.setBounds(12, 49, 176, 192);
		add(imageButton);
		

	

	}
}
