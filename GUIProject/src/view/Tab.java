package view;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controller.FrameController;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

/**
 * This is a panel that is used to set the size of the tabs in the tabbedPane.
 * @author neon
 *
 */
public class Tab extends JPanel {
	FrameController frameController;
	private String name;
	private JLabel nameOfTab;

	MouseAdapter mouseAdapter = new MouseAdapter() {
		public void mouseClicked(MouseEvent evt) {
			if(nameOfTab.equals("Sortiment") || name.equals("Sortiment")) {
			
				frameController.showSortiment();
			} else if(nameOfTab.equals("Recept") || name.equals("Recept")) {
				
				frameController.showRecept();
			} else if(nameOfTab.equals("Profil") || name.equals("Profil")) {
			
				frameController.showProfil();
			} else if(nameOfTab.equals("Historik") || name.equals("Historik")) {
			
				frameController.showHistorik();
			} else if(nameOfTab.equals("Listor") || name.equals("Listor")) {
				
				frameController.showListor();
			}  
		}
		public void mouseEntered(MouseEvent evt) {
			setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
	};
	/**
	 * Create the panel.
	 */
	public Tab(FrameController controller,String name) {
		setLayout(null);
		this.name = name;
		frameController = controller;
		setBorder(null);
		setPreferredSize(new Dimension(114,45));
		setBackground(new Color(245,245,245));
		nameOfTab = new JLabel(name);
		nameOfTab.setHorizontalAlignment(SwingConstants.CENTER);
		nameOfTab.setBounds(0, 0, 113, 45);
		nameOfTab.setFont(new Font("Dialog", Font.BOLD, 16));
		nameOfTab.addMouseListener(mouseAdapter);
		add(nameOfTab);
	}

	public String getName(){
		return name;
	}
}
