package view;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.CartController;

import se.chalmers.ait.dat215.project.Customer;
import se.chalmers.ait.dat215.project.ShoppingItem;


public class CheckOutView extends JFrame {

	//TODO Functionality: Add the grocerybag in the scrollpane. 

	private static final Model model = Model.getInstance();
	private static Customer customer = model.getCustomer();
	private static List<ShoppingItem> items;

	private JPanel contentPane;
	private static final int WIDTH = 700;
	private static final int HEIGHT = 600;
	//private Color textColor = Constants.TEXTCOLOR.getColor();
	//private Color textColorLight = Constants.TEXTCOLORLIGHT.getColor();
	private JTextField nameTextField;
	private JTextField addressTextField;
	private JTextField postCodeTextField;
	private JTextField cityTextField;
	private JTextField cardNumberTextField;
	private JTextField cvcTextField;
	private CartController cartController;
	private CardLayout cardLayout = new CardLayout(0, 0);
	private DefaultComboBoxModel dayModel = new DefaultComboBoxModel(
			new String[] {"MŒndag","Tisdag","Onsdag","Torsdag","Fredag","Lšrdag","Sšndag"});
	private DefaultComboBoxModel timeModel = new DefaultComboBoxModel(
			new String[] {"07:00", "08:00", "09:00", "10:00", "11:00", "14:00", "15:00", 
					"16:00", "17:00", "18:00", "19:00", "20:00"});



	/**
	 * Create the frame.
	 */
	public CheckOutView(List<ShoppingItem> items,CartController controller) {
		ActionListener myActionListener = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent evt) {
				if(evt.getActionCommand().equals("change")){
					cardLayout.next(contentPane);
				} else if(evt.getActionCommand().equals("save")){
					cardLayout.first(contentPane);
				} else if(evt.getActionCommand().equals("pay")){
					model.placeOrder(true);
					cartController.emptyCart();
					dispose();
				} else if(evt.getActionCommand().equals("abort")){
					dispose();
				}
			}
		};
		cartController = controller;
		CheckOutView.items = items;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, WIDTH, HEIGHT);
		contentPane = new JPanel();
		contentPane.setBackground(Constants.BACKGROUNDCOLOR.getColor());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(cardLayout);


		JPanel card2 = new JPanel();
		card2.setBackground(Constants.CONTRASTCOLOR.getColor());
		contentPane.add(card2, "Card2");
		card2.setLayout(null);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(16, 173, 1, 12);
		card2.add(separator_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(350, 5, 10, 555);
		separator.setOrientation(SwingConstants.VERTICAL);
		card2.add(separator);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(372, 19, 300, 455);
		card2.add(scrollPane);

		JButton payButton1 = new JButton("Betala");
		payButton1.setFont(new Font("Gill Sans", Font.PLAIN, 20));
		payButton1.setHorizontalAlignment(SwingConstants.CENTER);
		payButton1.setBounds(465, 490, 140, 55);
		payButton1.setActionCommand("pay");
		payButton1.addActionListener(myActionListener);
		card2.add(payButton1);;

		JLabel headLabel = new JLabel("Redo att betala?");
		headLabel.setForeground(new Color(255, 255, 255));
		headLabel.setFont(new Font("Gill Sans", Font.PLAIN, 28));
		headLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headLabel.setBounds(60, 5, 250, 35);
		card2.add(headLabel);

		JButton abortButton1 = new JButton("Avbryt");
		abortButton1.setBounds(107, 490, 140, 55);
		abortButton1.setFont(new Font("Gill Sans", Font.PLAIN, 20));
		abortButton1.setHorizontalAlignment(SwingConstants.CENTER);
		abortButton1.setActionCommand("abort");
		card2.add(abortButton1);
		separator.setBounds(350, 5, 10, 555);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(16, 307, 322, 167);
		card2.add(panel_2);
		panel_2.setLayout(null);

		JLabel expireDateLabel = new JLabel("Utlšper:");
		expireDateLabel.setBounds(17, 120, 56, 16);
		panel_2.add(expireDateLabel);

		JTextField expiresYear = new JTextField();
		expiresYear.setText(String.valueOf(model.getCreditCard().getValidYear()));
		expiresYear.setBounds(85, 114, 39, 27);
		panel_2.add(expiresYear);

		JTextField expiresMonth = new JTextField();
		expiresMonth.setText(String.valueOf(model.getCreditCard().getValidMonth()));
		expiresMonth.setBounds(123, 114, 41, 27);
		panel_2.add(expiresMonth);

		cardNumberTextField = new JTextField();
		cardNumberTextField.setText(model.getCreditCard().getCardNumber());
		cardNumberTextField.setBounds(17, 80, 147, 28);
		panel_2.add(cardNumberTextField);
		cardNumberTextField.setColumns(10);

		cvcTextField = new JTextField();
		cvcTextField.setText(String.valueOf(model.getCreditCard().getVerificationCode()));
		cvcTextField.setBounds(162, 80, 39, 28);
		panel_2.add(cvcTextField);
		cvcTextField.setColumns(10);

		JComboBox cardType = new JComboBox();
		if(model.getCreditCard().getCardType().toString().equals("Visa")){
			cardType.setSelectedItem(cardType.getItemAt(1));
		}else{
			cardType.setSelectedItem(cardType.getItemAt(2));
		}
		cardType.setBounds(17, 41, 119, 27);
		panel_2.add(cardType);
		cardType.setModel(new DefaultComboBoxModel(new String[] {"-Korttyp-","Visa","Mastercard"}));

		JLabel paymentLabel = new JLabel("Betalningss\u00E4tt");
		paymentLabel.setBounds(16, 14, 90, 15);
		panel_2.add(paymentLabel);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(16, 60, 322, 414);
		card2.add(panel_3);
		panel_3.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 322, 160);
		panel_3.add(panel);
		panel.setLayout(null);

		JLabel deliveryAddress = new JLabel("Leveransadress");
		deliveryAddress.setBounds(19, 16, 96, 16);
		panel.add(deliveryAddress);
		nameTextField = new JTextField();
		postCodeTextField = new JTextField();
		postCodeTextField.setBounds(16, 109, 89, 28);
		if(customer != null){
			nameTextField.setText(customer.getPostCode());
		} else {
			nameTextField.setText("-Postkod-");
		}
		
		panel.add(postCodeTextField);
		postCodeTextField.setColumns(10);

		cityTextField = new JTextField();
		cityTextField.setBounds(107, 109, 155, 28);
		if(customer.getPostAddress()!= null){
			nameTextField.setText(customer.getPostAddress());
		} else {
			nameTextField.setText("-Postort-");
		}
		panel.add(cityTextField);
		cityTextField.setColumns(10);

		addressTextField = new JTextField();
		addressTextField.setBounds(16, 79, 248, 28);
		if(customer != null){
			nameTextField.setText(customer.getAddress());
		} else {
			nameTextField.setText("-Adress-");
		}
		panel.add(addressTextField);
		addressTextField.setColumns(10);

		
		nameTextField.setBounds(16, 46, 155, 28);
		if(customer != null){
			nameTextField.setText(customer.getFirstName() + " " + customer.getLastName());
		} else {
			nameTextField.setText("-Fšrnamn och efternamn-");
		}
		panel.add(nameTextField);
		nameTextField.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 161, 322, 85);
		panel_3.add(panel_1);
		panel_1.setLayout(null);

		JComboBox chooseDay = new JComboBox();
		chooseDay.setBounds(16, 43, 118, 27);
		panel_1.add(chooseDay);
		chooseDay.setModel(dayModel);

		JComboBox chooseTime = new JComboBox();
		chooseTime.setBounds(130, 44, 97, 25);
		panel_1.add(chooseTime);
		chooseTime.setModel(timeModel);

		JLabel deliveryDay = new JLabel("Leveransdag");
		deliveryDay.setBounds(16, 16, 120, 15);
		panel_1.add(deliveryDay);

		this.setLocation(300, 100);

		this.setVisible(true);
		

	}
}
