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


public class CheckOutView extends JFrame {

	private JPanel contentPane;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 650;
	private JTextField customerNameTextField;
	private JTextField customerAddressTextField;
	private JTextField customerPostCodeLabelTextField;
	private JTextField customerCityTextField;
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
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(332, 6, 12, 616);
		contentPane.add(separator);
		
		customerNameTextField = new JTextField();
		customerNameTextField.setBounds(20, 63, 199, 28);
		contentPane.add(customerNameTextField);
		customerNameTextField.setColumns(10);
		//customerNameTextField.setText();
		
		customerAddressTextField = new JTextField();
		customerAddressTextField.setBounds(20, 100, 227, 28);
		contentPane.add(customerAddressTextField);
		customerAddressTextField.setColumns(10);
		//customerAddressTextField.setText();
		
		customerPostCodeLabelTextField = new JTextField();
		customerPostCodeLabelTextField.setBounds(20, 140, 95, 28);
		contentPane.add(customerPostCodeLabelTextField);
		customerPostCodeLabelTextField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(356, 25, 423, 509);
		contentPane.add(scrollPane);
		
		customerCityTextField = new JTextField();
		customerCityTextField.setBounds(127, 140, 120, 28);
		contentPane.add(customerCityTextField);
		customerCityTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Leveransdag");
		lblNewLabel.setBounds(20, 195, 95, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblLeveransadress = new JLabel("Leveransadress");
		lblLeveransadress.setBounds(20, 35, 103, 16);
		contentPane.add(lblLeveransadress);
		
		JLabel lblBetalningsstt = new JLabel("Betalningss\u00E4tt");
		lblBetalningsstt.setBounds(20, 336, 103, 16);
		contentPane.add(lblBetalningsstt);
		
		JButton button = new JButton("");
		button.setBounds(26, 568, 117, 29);
		contentPane.add(button);
		
		JButton btnBetala = new JButton("Betala");
		btnBetala.setBounds(479, 546, 183, 61);
		contentPane.add(btnBetala);
		//textField_2.setText();
		
		
		
	}
}
