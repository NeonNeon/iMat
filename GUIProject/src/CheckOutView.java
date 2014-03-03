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
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CheckOutView extends JFrame {

	private static final Model model = Model.getInstance();
	
	private JPanel contentPane;
	private static final int WIDTH = 700;
	private static final int HEIGHT = 600;
	private JTextField nameTextField;
	private JTextField addressTextField;
	private JTextField postCodeTextField;
	private JTextField cityTextField;
	private JTextField cardNumberTextField;
	private JTextField cvcTextField;
	private CardLayout cardLayout = new CardLayout(0, 0);
	private DefaultComboBoxModel dayModel = new DefaultComboBoxModel(
			new String[] {"MŒndag","Tisdag","Onsdag","Torsdag","Fredag","Lšrdag","Sšndag"});
	private DefaultComboBoxModel timeModel = new DefaultComboBoxModel(
			new String[] {"07:00", "08:00", "09:00", "10:00", "11:00", "14:00", "15:00", 
					"16:00", "17:00", "18:00", "19:00", "20:00"});

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
		contentPane.setLayout(cardLayout);
		
		JPanel card1 = new JPanel();
		card1.setBackground(new Color(153, 204, 204));
		contentPane.add(card1, "Card1");
		card1.setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(350, 5, 10, 555);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		card1.add(separator_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(375, 20, 300, 455);
		card1.add(scrollPane_1);
		
		JLabel deliveryDay1 = new JLabel("Leveransdag");
		deliveryDay1.setBounds(25, 210, 80, 15);
		card1.add(deliveryDay1);
		
		JLabel label_4 = new JLabel("Leveransadress");
		label_4.setBounds(34, 61, 96, 16);
		card1.add(label_4);
		
		JLabel label_5 = new JLabel("Betalningss\u00E4tt");
		label_5.setBounds(25, 280, 90, 15);
		card1.add(label_5);
		
		JButton abortButton = new JButton("Avbryt");
		abortButton.setBounds(25, 490, 120, 55);
		abortButton.setFont(new Font("Gill Sans", Font.PLAIN, 20));
		abortButton.setHorizontalAlignment(SwingConstants.CENTER);
		card1.add(abortButton);
		
		JButton button_3 = new JButton("Betala");
		button_3.setBounds(465, 490, 140, 55);
		button_3.setFont(new Font("Gill Sans", Font.PLAIN, 20));
		card1.add(button_3);
		
		
		JComboBox chooseDay1 = new JComboBox();
		chooseDay1.setBounds(25, 235, 120, 25);
		chooseDay1.setModel(dayModel);
		card1.add(chooseDay1);
		
		JComboBox chooseTime1 = new JComboBox();
		chooseTime1.setBounds(150, 235, 90, 25);
		chooseTime1.setModel(timeModel);
		card1.add(chooseTime1);
		
		JLabel label_6 = new JLabel("Utl\u00F6per:");
		label_6.setBounds(35, 427, 50, 16);
		card1.add(label_6);
		
		JLabel headLabel1 = new JLabel("Redo att betala?");
		headLabel1.setBounds(60, 5, 250, 35);
		headLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		headLabel1.setForeground(Color.WHITE);
		headLabel1.setFont(new Font("Gill Sans", Font.PLAIN, 28));
		card1.add(headLabel1);
		
		JLabel nameLabel = new JLabel(model.getCustomer().getFirstName() + " " + model.getCustomer().getLastName());
		nameLabel.setBounds(24, 89, 138, 16);
		card1.add(nameLabel);

		
		JLabel addressLabel = new JLabel(model.getCustomer().getAddress());
		addressLabel.setBounds(25, 117, 61, 16);
		card1.add(addressLabel);
		
		JLabel postAddressLabel = new JLabel(model.getCustomer().getPostCode() + 
				" " + model.getCustomer().getPostAddress());
		postAddressLabel.setBounds(25, 149, 61, 16);
		card1.add(postAddressLabel);
		
		JButton modifyButton = new JButton("€ndra");
		modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.next(contentPane);
			}
		});
		modifyButton.setBounds(150, 490, 160, 55);
		modifyButton.setFont(new Font("Gill Sans", Font.PLAIN, 20));
		modifyButton.setHorizontalAlignment(SwingConstants.CENTER);
		card1.add(modifyButton);
		
		
		JPanel card2 = new JPanel();
		card2.setBackground(new Color(153, 204, 204));
		contentPane.add(card2, "Card2");
		card2.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(350, 5, 10, 555);
		separator.setOrientation(SwingConstants.VERTICAL);
		card2.add(separator);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(25, 86, 155, 28);
		nameTextField.setColumns(10);
		card2.add(nameTextField);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(25, 124, 248, 28);
		addressTextField.setColumns(10);
		card2.add(addressTextField);
		
		postCodeTextField = new JTextField();
		postCodeTextField.setBounds(25, 157, 89, 28);
		postCodeTextField.setColumns(10);
		card2.add(postCodeTextField);
		
		cityTextField = new JTextField();
		cityTextField.setBounds(118, 157, 155, 28);
		cityTextField.setColumns(10);
		card2.add(cityTextField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(375, 20, 300, 455);
		card2.add(scrollPane);
		
		JLabel deliveryDay = new JLabel("Leveransdag");
		deliveryDay.setBounds(25, 210, 80, 15);
		card2.add(deliveryDay);
		
		JLabel label_1 = new JLabel("Leveransadress");
		label_1.setBounds(25, 58, 96, 16);
		card2.add(label_1);
		
		JLabel label_2 = new JLabel("Betalningss\u00E4tt");
		label_2.setBounds(25, 280, 90, 15);
		card2.add(label_2);
		
		JButton saveButton = new JButton("Spara");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		saveButton.setFont(new Font("Gill Sans", Font.PLAIN, 20));
		saveButton.setHorizontalAlignment(SwingConstants.CENTER);
		saveButton.setBounds(150, 490, 160, 55);
		card2.add(saveButton);
		
		JButton payButton = new JButton("Betala");
		payButton.setFont(new Font("Gill Sans", Font.PLAIN, 20));
		saveButton.setHorizontalAlignment(SwingConstants.CENTER);
		payButton.setBounds(465, 490, 140, 55);
		card2.add(payButton);
		
		JComboBox chooseDay = new JComboBox();;
		chooseDay.setBounds(25, 235, 120, 25);
		chooseDay.setModel(dayModel);
		card2.add(chooseDay);
		
		JComboBox chooseTime = new JComboBox();
		chooseTime.setModel(timeModel);
		chooseTime.setBounds(150, 235, 90, 25);
		//comboBox.add
		card2.add(chooseTime);
		
		JComboBox cardType = new JComboBox();
		cardType.setBounds(25, 308, 119, 27);
		cardType.setModel(new DefaultComboBoxModel(new String[] {"-Korttyp-","VISA","MASTERCARD"}));
		card2.add(cardType);
		
		JTextField expiresYear = new JTextField();
		expiresYear.setBounds(82, 387, 39, 27);
		card2.add(expiresYear);
		
		JTextField expiresMonth = new JTextField();
		expiresMonth.setBounds(118, 387, 41, 27);
		card2.add(expiresMonth);
		
		cardNumberTextField = new JTextField();
		cardNumberTextField.setBounds(25, 347, 147, 28);
		card2.add(cardNumberTextField);
		cardNumberTextField.setColumns(10);
		
		JLabel expireDateLabel = new JLabel("Utlšper:");
		expireDateLabel.setBounds(25, 393, 56, 16);
		card2.add(expireDateLabel);
		
		cvcTextField = new JTextField();
		cvcTextField.setBounds(178, 347, 39, 28);
		card2.add(cvcTextField);
		cvcTextField.setColumns(10);
		
		JLabel headLabel = new JLabel("Redo att betala?");
		headLabel.setForeground(new Color(255, 255, 255));
		headLabel.setFont(new Font("Gill Sans", Font.PLAIN, 28));
		headLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headLabel.setBounds(60, 5, 250, 35);
		card2.add(headLabel);
		
		JButton abortButton1 = new JButton("Avbryt");
		abortButton1.setBounds(25, 490, 120, 55);
		abortButton1.setFont(new Font("Gill Sans", Font.PLAIN, 20));
		abortButton1.setHorizontalAlignment(SwingConstants.CENTER);
		card2.add(abortButton1);
		
		
	}
}
