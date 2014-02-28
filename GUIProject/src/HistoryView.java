import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;


public class HistoryView extends JPanel {

	/**
	 * Create the panel.
	 */
	public HistoryView() {
		setSize(684, 631);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 342, 631);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 90, 318, 523);
		panel.add(scrollPane);
		
		JLabel lblHistorik = new JLabel("Historik");
		lblHistorik.setFont(new Font("Dialog", Font.BOLD, 24));
		lblHistorik.setBounds(107, 49, 116, 29);
		panel.add(lblHistorik);
	}
}
