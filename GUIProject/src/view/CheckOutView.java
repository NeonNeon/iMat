package view;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
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

import se.chalmers.ait.dat215.project.ShoppingItem;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.List;


public class CheckOutView extends JFrame {

	//TODO Functionality: Add the grocerybag in the scrollpane. 

	private static final Model model = Model.getInstance();
	private static List<ShoppingItem> items;
	
	private JPanel contentPane;
	private static final int WIDTH = 700;
	private static final int HEIGHT = 600;
	private Color textColor = Constants.TEXTCOLOR.getColor();
	private Color textColorLight = Constants.TEXTCOLORLIGHT.getColor();
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

	private ActionListener myActionListener = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent evt) {
			if(evt.getActionCommand().equals("change")){
				cardLayout.next(contentPane);
			} else if(evt.getActionCommand().equals("save")){
				cardLayout.first(contentPane);
			} else if(evt.getActionCommand().equals("pay")){
				//TODO complete a purchase 
			} else if(evt.getActionCommand().equals("abort")){
				//TODO abort purchase
			}
		}
	};

	/**
	 * Create the frame.
	 */
	public CheckOutView(List<ShoppingItem> items) {
		CheckOutView.items = items;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, WIDTH, HEIGHT);
		contentPane = new JPanel();
		contentPane.setBackground(Constants.BACKGROUNDCOLOR.getColor());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(cardLayout);

		JPanel card1 = new JPanel();
		card1.setBackground(Constants.CONTRASTCOLOR.getColor());
		contentPane.add(card1, "Card1");
		card1.setLayout(null);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(350, 5, 10, 555);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		card1.add(separator_1);
		JScrollPane cartPane = new JScrollPane();
		cartPane.setBounds(375, 20, 300, 455);
		card1.add(cartPane);


		JLabel deliveryDay1 = new JLabel("Leveransdag");
		deliveryDay1.setBounds(25, 210, 80, 15);
		card1.add(deliveryDay1);

		JLabel deliveryAddress1 = new JLabel("Leveransadress");
		deliveryAddress1.setBounds(25, 58, 96, 16);
		card1.add(deliveryAddress1);

		JLabel paymentLabel1 = new JLabel("Betalningss\u00E4tt");
		paymentLabel1.setBounds(25, 280, 90, 15);
		card1.add(paymentLabel1);

		JButton abortButton = new JButton("Avbryt");
		abortButton.setBounds(25, 490, 120, 55);
		abortButton.setFont(new Font("Gill Sans", Font.PLAIN, 20));
		abortButton.setHorizontalAlignment(SwingConstants.CENTER);
		abortButton.setActionCommand("abort");
		abortButton.addActionListener(myActionListener);
		card1.add(abortButton);

		JButton payButton = new JButton("Betala");
		payButton.setBounds(465, 490, 140, 55);
		payButton.setFont(new Font("Gill Sans", Font.PLAIN, 20));
		payButton.setActionCommand("pay");
		payButton.addActionListener(myActionListener);
		card1.add(payButton);

		JComboBox chooseDay1 = new JComboBox();
		chooseDay1.setBounds(25, 235, 120, 25);
		chooseDay1.setModel(dayModel);
		card1.add(chooseDay1);

		JComboBox chooseTime1 = new JComboBox();
		chooseTime1.setBounds(150, 235, 90, 25);
		chooseTime1.setModel(timeModel);
		card1.add(chooseTime1);

		JLabel expiresLabel1 = new JLabel("Utl\u00F6per:");
		expiresLabel1.setBounds(25, 393, 56, 16);
		card1.add(expiresLabel1);

		JLabel headLabel1 = new JLabel("Redo att betala?");
		headLabel1.setBounds(60, 5, 250, 35);
		headLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		headLabel1.setForeground(Color.WHITE);
		headLabel1.setFont(new Font("Gill Sans", Font.PLAIN, 28));
		card1.add(headLabel1);

		JLabel nameLabel = new JLabel(model.getCustomer().getFirstName() + " " + model.getCustomer().getLastName());
		nameLabel.setBounds(24, 89, 138, 16);
		nameLabel.setForeground(textColorLight);
		card1.add(nameLabel);


		JLabel addressLabel = new JLabel(model.getCustomer().getAddress());
		addressLabel.setBounds(25, 117, 61, 16);
		addressLabel.setForeground(textColorLight);
		card1.add(addressLabel);

		JLabel postAddressLabel = new JLabel(model.getCustomer().getPostCode() + 
				" " + model.getCustomer().getPostAddress());
		postAddressLabel.setBounds(25, 149, 61, 16);
		postAddressLabel.setForeground(textColorLight);
		card1.add(postAddressLabel);

		JButton modifyButton = new JButton("€ndra");
		modifyButton.addActionListener(myActionListener);
		modifyButton.setActionCommand("change");
		modifyButton.setBounds(150, 490, 160, 55);
		modifyButton.setFont(new Font("Gill Sans", Font.PLAIN, 20));
		modifyButton.setHorizontalAlignment(SwingConstants.CENTER);
		card1.add(modifyButton);


		JPanel card2 = new JPanel();
		card2.setBackground(Constants.CONTRASTCOLOR.getColor());
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

		JLabel deliveryAddress = new JLabel("Leveransadress");
		deliveryAddress.setBounds(25, 58, 96, 16);
		card2.add(deliveryAddress);

		JLabel paymentLabel = new JLabel("Betalningss\u00E4tt");
		paymentLabel.setBounds(25, 280, 90, 15);
		card2.add(paymentLabel);

		JButton saveButton = new JButton("Spara");
		saveButton.addActionListener(myActionListener);
		saveButton.setFont(new Font("Gill Sans", Font.PLAIN, 20));
		saveButton.setHorizontalAlignment(SwingConstants.CENTER);
		saveButton.setBounds(150, 490, 160, 55);
		saveButton.setActionCommand("save");
		saveButton.addActionListener(myActionListener);
		card2.add(saveButton);

		JButton payButton1 = new JButton("Betala");
		payButton1.setFont(new Font("Gill Sans", Font.PLAIN, 20));
		payButton1.setHorizontalAlignment(SwingConstants.CENTER);
		payButton1.setBounds(465, 490, 140, 55);
		payButton1.setActionCommand("pay");
		payButton1.addActionListener(myActionListener);
		card2.add(payButton1);

		JComboBox chooseDay = new JComboBox();;
		chooseDay.setBounds(25, 235, 120, 25);
		chooseDay.setModel(dayModel);
		card2.add(chooseDay);

		JComboBox chooseTime = new JComboBox();
		chooseTime.setModel(timeModel);
		chooseTime.setBounds(150, 235, 90, 25);
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
		abortButton1.setActionCommand("abort");
		abortButton.addActionListener(myActionListener);
		card2.add(abortButton1);

		this.setVisible(true);

	}
}
