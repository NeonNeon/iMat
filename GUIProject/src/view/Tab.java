package view;
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
	/**
	 * Create the panel.
	 */
	public Tab(FrameController controller,String name) {
		frameController = controller;
		setBorder(null);
		setPreferredSize(new Dimension(117,45));
		setBackground(new Color(245,245,245));
		JLabel nameOfTab = new JLabel(name);
		nameOfTab.setFont(new Font("Dialog", Font.BOLD, 16));
		add(nameOfTab);
		if(name.equals("Sortiment")) {
			nameOfTab.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					System.out.println("klicka på label sortiment");
					frameController.showSortiment();
				}
			});
		}
	}

}
