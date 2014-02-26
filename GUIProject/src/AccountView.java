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


public class AccountView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;

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
		
		textField = new JTextField();
		textField.setBounds(105, 46, 212, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(105, 71, 212, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(190, 96, 127, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(105, 121, 212, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(105, 146, 212, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(105, 96, 81, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(116, 48, 201, 20);
		panel_1.add(comboBox);
		
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
		
		JLabel lblSistaDatum = new JLabel("Sista datum:");
		lblSistaDatum.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSistaDatum.setBounds(10, 61, 76, 14);
		panel_3.add(lblSistaDatum);
		
		textField_6 = new JTextField();
		textField_6.setBounds(257, 9, 40, 20);
		panel_3.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(207, 9, 40, 20);
		panel_3.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(157, 9, 40, 20);
		panel_3.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(107, 9, 40, 20);
		panel_3.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(107, 34, 40, 20);
		panel_3.add(textField_10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(107, 59, 40, 20);
		panel_3.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(157, 59, 40, 20);
		panel_3.add(spinner_1);
		
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
		
		textField_11 = new JTextField();
		textField_11.setBounds(25, 79, 279, 20);
		panel_2.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(25, 110, 86, 20);
		panel_2.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(115, 110, 189, 20);
		panel_2.add(textField_13);
		textField_13.setColumns(10);
		
		JCheckBox chckbxSammaSomAnvndare = new JCheckBox("Samma som anv\u00E4ndare");
		chckbxSammaSomAnvndare.setBounds(35, 137, 209, 23);
		panel_2.add(chckbxSammaSomAnvndare);
		
		JLabel lblLeveransdag = new JLabel("Leveransdag:");
		lblLeveransdag.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLeveransdag.setBounds(351, 48, 127, 18);
		panel_2.add(lblLeveransdag);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(361, 79, 182, 20);
		panel_2.add(comboBox_1);
		
		JLabel lblLeveranstid = new JLabel("Leveranstid:");
		lblLeveranstid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLeveranstid.setBounds(351, 113, 127, 18);
		panel_2.add(lblLeveranstid);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(361, 138, 182, 20);
		panel_2.add(comboBox_2);
		
		JButton btnNewButton = new JButton("Spara");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(567, 426, 107, 65);
		add(btnNewButton);

	}
}
