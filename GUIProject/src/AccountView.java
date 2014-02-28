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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import se.chalmers.ait.dat215.project.*;

/**
 * The view that holds the customer and delivery information.
 * @author Grupp 16
 *
 */

public class AccountView extends JPanel {
	
	private static final Model model = Model.getInstance();
	private JTextField nameTextField;
	private JTextField addressTextField;
	private JTextField townTextField;
	private JTextField telephoneTextField;
	private JTextField emailTextField;
	private JTextField postNbrTextField;
	private JTextField cardNbr4;
	private JTextField cardNbr3;
	private JTextField cardNbr2;
	private JTextField cardNbr1;
	private JTextField cvvCode;
	private JTextField deliveryAddressTextField;
	private JTextField deliveryPostnbrTextField;
	private JTextField deliveryTownTextField;

	/**
	 * Create the panel.
	 */
	public AccountView() {
		setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		
		setSize(684, 681);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(10, 11, 327, 187);
		add(panel);
		panel.setLayout(null);
		
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
		
		nameTextField = new JTextField();
		nameTextField.setBounds(105, 46, 212, 20);
		panel.add(nameTextField);
		nameTextField.setColumns(10);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(105, 71, 212, 20);
		panel.add(addressTextField);
		addressTextField.setColumns(10);
		
		townTextField = new JTextField();
		townTextField.setBounds(190, 96, 127, 20);
		panel.add(townTextField);
		townTextField.setColumns(10);
		
		telephoneTextField = new JTextField();
		telephoneTextField.setBounds(105, 121, 212, 20);
		panel.add(telephoneTextField);
		telephoneTextField.setColumns(10);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(105, 146, 212, 20);
		panel.add(emailTextField);
		emailTextField.setColumns(10);
		
		postNbrTextField = new JTextField();
		postNbrTextField.setBounds(105, 96, 81, 20);
		panel.add(postNbrTextField);
		postNbrTextField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(347, 11, 327, 187);
		add(panel_1);
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
		paymentComboBox.setBounds(116, 48, 201, 20);
		panel_1.add(paymentComboBox);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 77, 307, 89);
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
		monthSpinner.setBounds(130, 59, 40, 20);
		panel_3.add(monthSpinner);
		
		JSpinner yearSpinner = new JSpinner();
		yearSpinner.setBounds(180, 59, 40, 20);
		panel_3.add(yearSpinner);
		
		JLabel lblMn = new JLabel("m\u00E5n");
		lblMn.setBounds(107, 62, 46, 14);
		panel_3.add(lblMn);
		
		JLabel lblr = new JLabel("\u00E5r");
		lblr.setBounds(180, 62, 46, 14);
		panel_3.add(lblr);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2.setBounds(10, 209, 664, 206);
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
		panel_2.add(checkBox);
		
		JLabel lblLeveransdag = new JLabel("Leveransdag:");
		lblLeveransdag.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLeveransdag.setBounds(351, 48, 127, 18);
		panel_2.add(lblLeveransdag);
		
		JComboBox deliveryDay = new JComboBox();
		deliveryDay.setBounds(361, 79, 182, 20);
		panel_2.add(deliveryDay);
		
		JLabel lblLeveranstid = new JLabel("Leveranstid:");
		lblLeveranstid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLeveranstid.setBounds(351, 113, 127, 18);
		panel_2.add(lblLeveranstid);
		
		JComboBox deliveryTime = new JComboBox();
		deliveryTime.setBounds(361, 138, 182, 20);
		panel_2.add(deliveryTime);
		
		JButton saveButton = new JButton("Spara");
		
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				save();
			}
		});
		
		saveButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		saveButton.setBounds(567, 426, 107, 65);
		add(saveButton);

	}
	
	
	public void save(){
		
		
		
	}
}
