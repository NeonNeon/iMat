import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;


public class CheckOutView extends JFrame {

	private JPanel contentPane;
	private static final int WIDTH = 700;
	private static final int HEIGHT = 600;
	private JTextField nameTextField;
	private JTextField addressTextField;
	private JTextField postCodeTextField;
	private JTextField cityTextField;
	private JTextField cardNumberTextField;
	private JTextField cvcTextField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOutView frame = new CheckOutView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CheckOutView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, WIDTH, HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel card1 = new JPanel();
		contentPane.add(card1, "name_1393502223039769000");
		card1.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(352, 6, 12, 556);
		separator.setOrientation(SwingConstants.VERTICAL);
		card1.add(separator);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(25, 86, 155, 28);
		nameTextField.setColumns(10);
		card1.add(nameTextField);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(25, 124, 248, 28);
		addressTextField.setColumns(10);
		card1.add(addressTextField);
		
		postCodeTextField = new JTextField();
		postCodeTextField.setBounds(25, 157, 89, 28);
		postCodeTextField.setColumns(10);
		card1.add(postCodeTextField);
		
		cityTextField = new JTextField();
		cityTextField.setBounds(118, 157, 155, 28);
		cityTextField.setColumns(10);
		card1.add(cityTextField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(376, 18, 296, 457);
		card1.add(scrollPane);
		
		JLabel label = new JLabel("Leveransdag");
		label.setBounds(25, 212, 78, 16);
		card1.add(label);
		
		JLabel label_1 = new JLabel("Leveransadress");
		label_1.setBounds(25, 58, 96, 16);
		card1.add(label_1);
		
		JLabel label_2 = new JLabel("Betalningss\u00E4tt");
		label_2.setBounds(25, 280, 89, 16);
		card1.add(label_2);
		
		JButton button = new JButton("");
		button.setBounds(6, 533, 75, 29);
		card1.add(button);
		
		JButton button_1 = new JButton("Betala");
		button_1.setFont(new Font("Gill Sans", Font.PLAIN, 20));
		button_1.setBounds(466, 487, 142, 55);
		card1.add(button_1);
		
		JComboBox chooseDay = new JComboBox();
		chooseDay.setBounds(25, 234, 119, 26);
		chooseDay.setModel(new DefaultComboBoxModel(new String[] {"MŒndag","Tisdag","Onsdag","Torsdag","Fredag","Lšrdag","Sšndag"}));
		card1.add(chooseDay);
		
		JComboBox chooseTime = new JComboBox();
		chooseTime.setModel(new DefaultComboBoxModel(new String[] {"07:00", "08:00", "09:00", "10:00", "11:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00"}));
		chooseTime.setBounds(150, 234, 89, 27);
		//comboBox.add
		card1.add(chooseTime);
		
		JComboBox cardType = new JComboBox();
		cardType.setBounds(25, 308, 119, 27);
		cardType.setModel(new DefaultComboBoxModel(new String[] {"-Korttyp-","VISA","MASTERCARD"}));
		card1.add(cardType);
		
		JTextField expiresYear = new JTextField();
		expiresYear.setBounds(82, 387, 39, 27);
		card1.add(expiresYear);
		
		JTextField expiresMonth = new JTextField();
		expiresMonth.setBounds(118, 387, 41, 27);
		card1.add(expiresMonth);
		
		cardNumberTextField = new JTextField();
		cardNumberTextField.setBounds(25, 347, 147, 28);
		card1.add(cardNumberTextField);
		cardNumberTextField.setColumns(10);
		
		JLabel expireDateLabel = new JLabel("Utlšper:");
		expireDateLabel.setBounds(25, 393, 56, 16);
		card1.add(expireDateLabel);
		
		cvcTextField = new JTextField();
		cvcTextField.setBounds(178, 347, 39, 28);
		card1.add(cvcTextField);
		cvcTextField.setColumns(10);
		
		JLabel headLabel = new JLabel("Redo att betala?");
		headLabel.setFont(new Font("Gill Sans", Font.PLAIN, 26));
		headLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headLabel.setBounds(58, 6, 248, 35);
		card1.add(headLabel);
		
		
	}
}
