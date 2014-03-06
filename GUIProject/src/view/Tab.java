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
				System.out.println("klicka på label sortiment");
				frameController.showSortiment();
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
		this.name = name;
		frameController = controller;
		setBorder(null);
		setPreferredSize(new Dimension(111,45));
		setBackground(new Color(245,245,245));
		nameOfTab = new JLabel(name);
		nameOfTab.setFont(new Font("Dialog", Font.BOLD, 16));
		nameOfTab.addMouseListener(mouseAdapter);
		add(nameOfTab);
	}

	public String getName(){
		return name;
	}
}
