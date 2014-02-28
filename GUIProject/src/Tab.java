import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;

/**
 * This is a panel that is used to set the size of the tabs in the tabbedPane.
 * @author neon
 *
 */
public class Tab extends JPanel {

	/**
	 * Create the panel.
	 */
	public Tab() {
		setBorder(null);
		setPreferredSize(new Dimension(117,45));
	}

}
