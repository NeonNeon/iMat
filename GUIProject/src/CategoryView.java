import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

import se.chalmers.ait.dat215.project.*;
import se.chalmers.ait.dat215.project.util.*;

import java.awt.event.*;


public class CategoryView extends JPanel {
	private final static Model model = Model
			.getInstance();
	private Product p;
	
	
	public CategoryView(Product p) {
		this.p=p;
		setLayout(null);
		
		
		JLabel imageLabel = new JLabel(model.getImageIcon(p), JLabel.CENTER);
		imageLabel.setBounds(22, 66, 189, 137);
		imageLabel.setBorder(new LineBorder(Color.BLACK));
		imageLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(imageLabel);

		
		JLabel categoryLabel = new JLabel("New label");
		categoryLabel.setBounds(87, 13, 69, 40);
		categoryLabel.setText(p.getCategory().toString().toLowerCase());
		categoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		categoryLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(categoryLabel);
		

		imageLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//new CategoryDetailedView()
				System.out.println("Tjenare");
			}
		});
		categoryLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("Tjenare");
			}
		});
		
		setVisible(true);

	}
	
	
	
	

}