package view;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import se.chalmers.ait.dat215.project.*;
import java.awt.Component;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

/**
 * The view that holds the customer and delivery information.
 * @author Grupp 16
 *
 */

public class AccountView extends JPanel {
	
	private static final Model model = Model.getInstance();
	private static JTextField firstName;
	private static JTextField addressTextField;
	private static JTextField townTextField;
	private static JTextField telephoneTextField;
	private static JTextField emailTextField;
	private static JTextField postNbrTextField;
	private JTextField cardNbr4;
	private JTextField cardNbr3;
	private JTextField cardNbr2;
	private JTextField cardNbr1;
	private JTextField cvvCode;
	private JTextField deliveryAddressTextField;
	private JTextField deliveryPostnbrTextField;
	private JTextField deliveryTownTextField;
	private static JTextField lastName;
	private static Customer customer = model.getCustomer();
	private static CreditCard creditCard = model.getCreditCard();
	private Color background = Constants.BACKGROUNDCOLOR.getColor();
	private Color borderColor = Constants.HOVERCOLOR.getColor();

	/**
	 * Create the panel.
	 */
	public AccountView() {
		setBorder(new LineBorder(borderColor, 2, true));
		
		setSize(665, 681);
		setLayout(null);
		setBackground(background);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(10, 11, 318, 187);
		add(panel);
		panel.setLayout(null);
		panel.setBackground(background);
		
		JLabel lblNamn = new JLabel("Namn:");
		lblNamn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNamn.setBounds(10, 48, 46, 14);
		panel.add(lblNamn);
		
		JLabel lblAdress = new JLabel("Adress:");
		lblAdress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdress.setBounds(10, 73, 46, 14);
		panel.add(lblAdress);
		
		JLabel lblPostadress = new JLabel("Postadress:");
		lblPostadress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPostadress.setBounds(10, 98, 67, 14);
		panel.add(lblPostadress);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefon.setBounds(10, 123, 67, 14);
		panel.add(lblTelefon);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(10, 148, 46, 14);
		panel.add(lblEmail);
		
		JLabel lblKunduppgifter = new JLabel("Kunduppgifter");
		lblKunduppgifter.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKunduppgifter.setBounds(10, 11, 176, 26);
		panel.add(lblKunduppgifter);
		
		firstName = new JTextField();
		firstName.setBounds(94, 45, 104, 20);
		panel.add(firstName);
		firstName.setColumns(10);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(94, 70, 212, 20);
		panel.add(addressTextField);
		addressTextField.setColumns(10);
		
		townTextField = new JTextField();
		townTextField.setBounds(190, 96, 116, 20);
		panel.add(townTextField);
		townTextField.setColumns(10);
		
		telephoneTextField = new JTextField();
		telephoneTextField.setBounds(94, 120, 212, 20);
		panel.add(telephoneTextField);
		telephoneTextField.setColumns(10);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(94, 145, 212, 20);
		panel.add(emailTextField);
		emailTextField.setColumns(10);
		
		postNbrTextField = new JTextField();
		postNbrTextField.setBounds(94, 95, 88, 20);
		panel.add(postNbrTextField);
		postNbrTextField.setColumns(10);
		
		lastName = new JTextField();
		lastName.setBounds(203, 45, 103, 20);
		panel.add(lastName);
		lastName.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(335, 11, 318, 187);
		add(panel_1);
		panel_1.setBackground(background);
		panel_1.setLayout(null);
		
		JLabel lblBetalning = new JLabel("Betalning");
		lblBetalning.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBetalning.setBounds(10, 11, 176, 26);
		panel_1.add(lblBetalning);
		
		JLabel lblBetalningsstt = new JLabel("Betalningss\u00E4tt:");
		lblBetalningsstt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBetalningsstt.setBounds(10, 48, 88, 18);
		panel_1.add(lblBetalningsstt);
		
		JComboBox paymentComboBox = new JComboBox();
		paymentComboBox.setBounds(116, 42, 201, 26);
		panel_1.add(paymentComboBox);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(6, 77, 302, 89);
		panel_3.setBackground(background);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblKortnummer = new JLabel("Kortnummer:");
		lblKortnummer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKortnummer.setBounds(10, 11, 76, 14);
		panel_3.add(lblKortnummer);
		
		JLabel lblNewLabel = new JLabel("CVV-kod");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 36, 62, 14);
		panel_3.add(lblNewLabel);
		
		JLabel lblSistaDatum = new JLabel("Giltigt till:");
		lblSistaDatum.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSistaDatum.setBounds(10, 61, 76, 14);
		panel_3.add(lblSistaDatum);
		
		cardNbr4 = new JTextField();
		cardNbr4.setBounds(257, 9, 40, 20);
		panel_3.add(cardNbr4);
		cardNbr4.setColumns(10);
		
		cardNbr3 = new JTextField();
		cardNbr3.setColumns(10);
		cardNbr3.setBounds(207, 9, 40, 20);
		panel_3.add(cardNbr3);
		
		cardNbr2 = new JTextField();
		cardNbr2.setColumns(10);
		cardNbr2.setBounds(157, 9, 40, 20);
		panel_3.add(cardNbr2);
		
		cardNbr1 = new JTextField();
		cardNbr1.setColumns(10);
		cardNbr1.setBounds(107, 9, 40, 20);
		panel_3.add(cardNbr1);
		
		cvvCode = new JTextField();
		cvvCode.setColumns(10);
		cvvCode.setBounds(107, 34, 40, 20);
		panel_3.add(cvvCode);
		
		JSpinner monthSpinner = new JSpinner();
		monthSpinner.setBounds(142, 59, 40, 20);
		panel_3.add(monthSpinner);
		
		JSpinner yearSpinner = new JSpinner();
		yearSpinner.setBounds(207, 59, 40, 20);
		panel_3.add(yearSpinner);
		
		JLabel lblMn = new JLabel("m\u00E5n");
		lblMn.setBounds(111, 61, 36, 14);
		panel_3.add(lblMn);
		
		JLabel lblr = new JLabel("\u00E5r");
		lblr.setBounds(192, 61, 30, 14);
		panel_3.add(lblr);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2.setBounds(10, 209, 643, 206);
		panel_2.setBackground(background);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblLeverans = new JLabel("Leverans");
		lblLeverans.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLeverans.setBounds(10, 11, 176, 26);
		panel_2.add(lblLeverans);
		
		JLabel lblLeveransadress = new JLabel("Leveransadress:");
		lblLeveransadress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLeveransadress.setBounds(10, 48, 101, 20);
		panel_2.add(lblLeveransadress);
		
		deliveryAddressTextField = new JTextField();
		deliveryAddressTextField.setBounds(25, 79, 279, 20);
		panel_2.add(deliveryAddressTextField);
		deliveryAddressTextField.setColumns(10);
		
		deliveryPostnbrTextField = new JTextField();
		deliveryPostnbrTextField.setBounds(25, 110, 86, 20);
		panel_2.add(deliveryPostnbrTextField);
		deliveryPostnbrTextField.setColumns(10);
		
		deliveryTownTextField = new JTextField();
		deliveryTownTextField.setBounds(115, 110, 189, 20);
		panel_2.add(deliveryTownTextField);
		deliveryTownTextField.setColumns(10);
		
		JCheckBox checkBox = new JCheckBox("Samma som anv\u00E4ndare");
		checkBox.setBounds(35, 137, 209, 23);
		checkBox.setBackground(background);
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deliveryAddressTextField.setText(addressTextField.getText());
				deliveryPostnbrTextField.setText(postNbrTextField.getText());
				deliveryTownTextField.setText(townTextField.getText());
			}
		});
		panel_2.add(checkBox);
		
		JLabel lblLeveransdag = new JLabel("Leveransdag:");
		lblLeveransdag.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLeveransdag.setBounds(351, 48, 127, 18);
		panel_2.add(lblLeveransdag);
		
		JComboBox deliveryDay = new JComboBox();
		deliveryDay.setBounds(361, 73, 182, 26);
		panel_2.add(deliveryDay);
		
		JLabel lblLeveranstid = new JLabel("Leveranstid:");
		lblLeveranstid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLeveranstid.setBounds(351, 113, 127, 18);
		panel_2.add(lblLeveranstid);
		
		JComboBox deliveryTime = new JComboBox();
		deliveryTime.setBounds(361, 138, 182, 26);
		panel_2.add(deliveryTime);
		
		/*JButton saveButton = new JButton("Spara");
		saveButton.setBounds(567, 427, 140, 55);
		saveButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		saveButton.setHorizontalAlignment(SwingConstants.CENTER);
		saveButton.setOpaque(true);
		*/
		
		JButton saveButton = new JButton("Spara");
		saveButton.setIcon(null);
		saveButton.setHorizontalTextPosition(SwingConstants.CENTER);
		saveButton.setBounds(513, 427, 140, 55);
		saveButton.setFont(new Font("Gill Sans", Font.PLAIN, 20));
		saveButton.setHorizontalAlignment(SwingConstants.CENTER);
		saveButton.setActionCommand("save");
		saveButton.setForeground(Color.BLACK);
		saveButton.setBackground(Constants.CONTRASTCOLOR.getColor());
		firstName.setText(customer.getFirstName());
		lastName.setText(customer.getLastName());
		addressTextField.setText(customer.getAddress());
		postNbrTextField.setText(customer.getPostCode());
		townTextField.setText(customer.getPostAddress());
		telephoneTextField.setText(customer.getPhoneNumber());
		emailTextField.setText(customer.getEmail());
		
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				save();
			}
		});
		
		add(saveButton);

	}
	
	
	public static void save(){
		
		//saving customer information
		customer.setFirstName(firstName.getText());
		customer.setLastName(lastName.getText());
		customer.setAddress(addressTextField.getText());
		customer.setPostCode(postNbrTextField.getText());
		customer.setPostAddress(townTextField.getText());
		customer.setPhoneNumber(telephoneTextField.getText());
		customer.setEmail(emailTextField.getText());
		
		//saving payment
		
		
	}
}
