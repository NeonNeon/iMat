package view;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.BrowseController;
import controller.CartController;
import se.chalmers.ait.dat215.project.Customer;
import se.chalmers.ait.dat215.project.ShoppingItem;


public class CheckOutView extends JDialog {

	//TODO Functionality: Add the grocerybag in the scrollpane. 

	private static final Model model = Model.getInstance();
	private Customer customer;
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
	private JTextField expiresMonth;
	private JTextField expiresYear;
	private CartController cartController;
	private BrowseController browseController;
	private JPanel recieptItemsPanel;
	private JButton changeButton, payButton1;
	private JComboBox chooseDay, chooseTime,cardType;
	private CardLayout cardLayout = new CardLayout(0, 0);
	private DefaultComboBoxModel dayModel = new DefaultComboBoxModel(
			new String[] {"Måndag","Tisdag","Onsdag","Torsdag","Fredag","Lördag","Söndag"});
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
				if(evt.getActionCommand().equals("pay")){
					model.placeOrder(true);
					cartController.emptyCart();
					setModal(false);
					dispose();
					JOptionPane.showMessageDialog(null,"Tack för att du handlar på iMat, Ditt köp är nu registrerat. Välkommen åter!", "Bekräftelse av köp", 1);
					//hide();
					setFocusable(false);
				} 
					else if(evt.getActionCommand().equals("abort")){
						dispose();
						
				} 
					else if(evt.getActionCommand().equals("change")){
						changeButton.setText("Spara");
						changeButton.setActionCommand("save");
						changeButton.setFont(Constants.HEADERFONT.getFont());
						changeButton.setBackground(Constants.BUTTONCOLOR.getColor());
						changeButton.setForeground(Color.WHITE);
						changeButton.setBorder(null);
						changeButton.setOpaque(true);
						setEditability(true);
						payButton1.setEnabled(false);
						
						
					}
					
					else if(evt.getActionCommand().equals("save")){
						changeButton.setText("Ändra");
						changeButton.setActionCommand("change");
						changeButton.setFont(Constants.HEADERFONT.getFont());
						changeButton.setBackground(Constants.BUTTONCOLOR.getColor());
						changeButton.setForeground(Color.WHITE);
						changeButton.setBorder(null);
						changeButton.setOpaque(true);
						setEditability(false);
						payButton1.setEnabled(true);
					}
			}
		};
		setModalityType(ModalityType.TOOLKIT_MODAL);
		//setModal(true);
		
		
		customer = model.getCustomer();
		cartController = controller;
		CheckOutView.items = items;
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
		recieptItemsPanel = new JPanel();
		recieptItemsPanel.setPreferredSize(new Dimension(230, 800)); //TODO fixa ordentliga siffor
		recieptItemsPanel.setLayout(new BoxLayout(recieptItemsPanel, BoxLayout.Y_AXIS));

		JScrollPane recieptScrollPane = new JScrollPane(recieptItemsPanel);
		recieptScrollPane.setBounds(372, 19, 300, 455);
		card2.add(recieptScrollPane);
		double totalSum = 0;
		for(ShoppingItem item:items) {
			recieptItemsPanel.add(new OldCartItemPanel(item));
			totalSum+=item.getTotal();
		}
		
		payButton1 = new JButton("Betala " + String.format("%.1f", totalSum) + "kr");
		payButton1.setForeground(Color.WHITE);
		payButton1.setOpaque(true);
		payButton1.setBorder(null);
		payButton1.setFont(Constants.HEADERFONT.getFont());
		payButton1.setBackground(Constants.BUTTONCOLOR.getColor());
		payButton1.setHorizontalAlignment(SwingConstants.CENTER);
		payButton1.setBounds(435, 488, 192, 55);
		payButton1.setActionCommand("pay");
		payButton1.addActionListener(myActionListener);
		card2.add(payButton1);;

		JLabel headLabel = new JLabel("Redo att betala?");
		headLabel.setForeground(new Color(255, 255, 255));
		headLabel.setFont(new Font("Gill Sans", Font.PLAIN, 28));
		headLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headLabel.setBounds(60, 5, 250, 35);
		card2.add(headLabel);

		/*JButton abortButton1 = new JButton("Avbryt");
		abortButton1.setForeground(Color.WHITE);
		abortButton1.setOpaque(true);
		abortButton1.setBorder(null);
		abortButton1.setBounds(16, 488, 146, 55);
		abortButton1.setBackground(Constants.BUTTONCOLOR.getColor());
		abortButton1.setFont(Constants.HEADERFONT.getFont());
		abortButton1.setHorizontalAlignment(SwingConstants.CENTER);
		abortButton1.setActionCommand("abort");
		abortButton1.addActionListener(myActionListener);
		card2.add(abortButton1);
		separator.setBounds(350, 5, 10, 555);*/

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(16, 307, 322, 167);
		card2.add(panel_2);
		panel_2.setLayout(null);

		JLabel expireDateLabel = new JLabel("Utlöper:");
		expireDateLabel.setBounds(17, 120, 56, 16);
		panel_2.add(expireDateLabel);

		expiresMonth = new JTextField();
		expiresMonth.setText(String.valueOf(model.getCreditCard().getValidMonth()));
		expiresMonth.setBounds(85, 114, 39, 27);
		panel_2.add(expiresMonth);
		expiresMonth.setEditable(false);

		expiresYear = new JTextField();
		expiresMonth.setText(String.valueOf(model.getCreditCard().getValidYear()));
		expiresYear.setBounds(123, 114, 41, 27);
		panel_2.add(expiresYear);
		expiresYear.setEditable(false);

		cardNumberTextField = new JTextField();
		if(model.getCreditCard().getCardNumber().isEmpty()){
			cardNumberTextField.setText("-kortnummer-");
		}else{
			cardNumberTextField.setText(model.getCreditCard().getCardNumber());
		}
		cardNumberTextField.setBounds(17, 80, 147, 28);
		panel_2.add(cardNumberTextField);
		cardNumberTextField.setColumns(10);
		cardNumberTextField.setEditable(false);

		cvcTextField = new JTextField();
		if ((String.valueOf(model.getCreditCard().getVerificationCode())) == null){
			cvcTextField.setText("cvc");
		} else {
			cvcTextField.setText(String.valueOf(model.getCreditCard().getVerificationCode()));
		}
		cvcTextField.setBounds(162, 80, 39, 28);
		panel_2.add(cvcTextField);
		cvcTextField.setColumns(10);
		cvcTextField.setEditable(false);

		cardType = new JComboBox();
		cardType.setBounds(17, 41, 119, 27);
		cardType.setEnabled(false);
		panel_2.add(cardType);
		cardType.setModel(new DefaultComboBoxModel(new String[] {"-Korttyp-","Visa","Mastercard"}));

		if(model.getCreditCard().getCardType().toString().equals("Visa")){
			cardType.setSelectedItem(cardType.getItemAt(1));
		}else{
			cardType.setSelectedItem(cardType.getItemAt(2));
		}
		cardType.setEditable(false);

		JLabel paymentLabel = new JLabel("Betalningssätt");
		paymentLabel.setFont(Constants.TEXTFONT.getFont());
		paymentLabel.setForeground(Constants.TEXTCOLOR.getColor());
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
		deliveryAddress.setFont(Constants.TEXTFONT.getFont());
		deliveryAddress.setForeground(Constants.TEXTCOLOR.getColor());
		deliveryAddress.setBounds(19, 16, 96, 16);
		panel.add(deliveryAddress);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(16, 46, 155, 28);
		nameTextField.setText(customer.getFirstName() + " " + customer.getLastName());
		panel.add(nameTextField);
		nameTextField.setBounds(16, 46, 155, 28);
		nameTextField.setColumns(10);
		panel.add(nameTextField);
		nameTextField.setEditable(false);
		
		postCodeTextField = new JTextField();
		postCodeTextField.setBounds(16, 109, 118, 28);
		postCodeTextField.setColumns(10);
		if(customer.getPostCode().isEmpty()){
			postCodeTextField.setText("-Postnummer-");
		}else{
			postCodeTextField.setText(customer.getPostCode());
		}
		panel.add(postCodeTextField);
		postCodeTextField.setEditable(false);


		cityTextField = new JTextField();
		cityTextField.setBounds(134, 109, 130, 28);
		cityTextField.setColumns(10);
		if(customer.getPostAddress().isEmpty()){
			cityTextField.setText("-Postort-");
		}else{
			cityTextField.setText(customer.getPostAddress());
		}
		panel.add(cityTextField);
		cityTextField.setEditable(false);

		addressTextField = new JTextField();
		addressTextField.setBounds(16, 79, 248, 28);
		addressTextField.setColumns(10);
		if(customer.getAddress().isEmpty()){
			addressTextField.setText("-Adress-");
		}else{
			addressTextField.setText(customer.getAddress());
		}
		panel.add(addressTextField);
		addressTextField.setEditable(false);


		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 161, 322, 85);
		panel_3.add(panel_1);
		panel_1.setLayout(null);

		chooseDay = new JComboBox();
		chooseDay.setBounds(16, 43, 118, 27);
		panel_1.add(chooseDay);
		chooseDay.setModel(dayModel);
		chooseDay.setEnabled(false);

		chooseTime = new JComboBox();
		chooseTime.setBounds(130, 44, 97, 25);
		panel_1.add(chooseTime);
		chooseTime.setModel(timeModel);
		chooseTime.setEnabled(false);

		JLabel deliveryDay = new JLabel("Leveransdag");
		deliveryDay.setFont(Constants.TEXTFONT.getFont());
		deliveryDay.setForeground(Constants.TEXTCOLOR.getColor());
		deliveryDay.setBounds(16, 16, 120, 15);
		panel_1.add(deliveryDay);
		
		changeButton = new JButton("Ändra");
		changeButton.setFont(Constants.HEADERFONT.getFont());
		changeButton.setBackground(Constants.BUTTONCOLOR.getColor());
		changeButton.setForeground(Color.WHITE);
		changeButton.setBorder(null);
		changeButton.setOpaque(true);
		changeButton.setBounds(192, 488, 146, 55);
		changeButton.setHorizontalAlignment(SwingConstants.CENTER);
		changeButton.setActionCommand("change");
		changeButton.addActionListener(myActionListener);
		card2.add(changeButton);

		this.setLocation(300, 100);

		this.setVisible(true);


	}
	
	public void setEditability(boolean b){
		nameTextField.setEditable(b);
		addressTextField.setEditable(b);
		postCodeTextField.setEditable(b);
		cityTextField.setEditable(b);
		cardNumberTextField.setEditable(b);
		cvcTextField.setEditable(b);
		chooseDay.setEnabled(b);
		chooseTime.setEnabled(b);
		cardType.setEnabled(b);
		expiresMonth.setEditable(b);
		expiresYear.setEditable(b);
	}
}
