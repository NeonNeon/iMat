package view;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.FrameController;

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
	private Color hoverColor = Constants.HOVERCOLOR.getColor();
	private Color originalColor = Constants.TEXTCOLOR.getColor();
	private JLabel categoryLabel;
	private FrameController frameController;
	private NewCategorys myCategory;
	public CategoryView(String name, ImageIcon icon, FrameController controller,NewCategorys category) {
		myCategory = category;
		setBackground(Constants.BACKGROUNDCOLOR.getColor());
		frameController = controller;
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
		categoryLabel.setFont(Constants.CATEGORYFONT.getFont());
		categoryLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		categoryLabel.addMouseListener(myMouseListener);
		add(categoryLabel);
		
		JButton imageButton = new JButton(icon);
		imageButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		imageButton.setBounds(12, 49, 176, 192);
		add(imageButton);
		imageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frameController.showCategory(myCategory);
			}
		});
		

	

	}
}
