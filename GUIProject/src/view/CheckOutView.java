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

import se.chalmers.ait.dat215.project.ShoppingItem;


public class CheckOutView extends JFrame {

	//TODO Functionality: Add the grocerybag in the scrollpane. 

	private static final Model model = Model.getInstance();
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
	private CardLayout cardLayout = new CardLayout(0, 0);
	private DefaultComboBoxModel dayModel = new DefaultComboBoxModel(
			new String[] {"M�ndag","Tisdag","Onsdag","Torsdag","Fredag","L�rdag","S�ndag"});
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

		nameTextField = new JTextField();
		nameTextField.setBounds(25, 85, 155, 28);
		nameTextField.setColumns(10);
		if(model.getCustomer() != null){
			nameTextField.setText(model.getCustomer().getFirstName() + " " + model.getCustomer().getLastName());
		} else {
			nameTextField.setText("-F�rnamn och efternamn-");
		}
		card2.add(nameTextField);

		addressTextField = new JTextField();
		addressTextField.setBounds(25, 120, 248, 28);
		addressTextField.setColumns(10);
		if(model.getCustomer() != null){
			nameTextField.setText(model.getCustomer().getAddress());
		} else {
			nameTextField.setText("-Adress-");
		}
		card2.add(addressTextField);

		postCodeTextField = new JTextField();
		postCodeTextField.setBounds(25, 155, 89, 28);
		postCodeTextField.setColumns(10);
		if(model.getCustomer() != null){
			nameTextField.setText(model.getCustomer().getPostCode());
		} else {
			nameTextField.setText("-Postkod-");
		}
		card2.add(postCodeTextField);

		cityTextField = new JTextField();
		cityTextField.setBounds(118, 155, 155, 28);
		cityTextField.setColumns(10);
		if(model.getCustomer() != null){
			nameTextField.setText(model.getCustomer().getPostAddress());
		} else {
			nameTextField.setText("-Postort-");
		}
		card2.add(cityTextField);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(372, 19, 300, 455);
		card2.add(scrollPane);

		/*JButton saveButton = new JButton("Spara");
		saveButton.addActionListener(myActionListener);
		saveButton.setFont(new Font("Gill Sans", Font.PLAIN, 20));
		saveButton.setHorizontalAlignment(SwingConstants.CENTER);
		saveButton.setBounds(150, 490, 160, 55);
		saveButton.setActionCommand("save");
		saveButton.addActionListener(myActionListener);
		card2.add(saveButton);*/

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
		
		JPanel panel = new JPanel();
		panel.setBounds(16, 52, 322, 141);
		card2.add(panel);
				panel.setLayout(null);
		
				JLabel deliveryAddress = new JLabel("Leveransadress");
				deliveryAddress.setBounds(113, 5, 96, 16);
				panel.add(deliveryAddress);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(16, 225, 322, 98);
		card2.add(panel_1);
				panel_1.setLayout(null);
		
				JComboBox chooseDay = new JComboBox();
				chooseDay.setBounds(4, 50, 118, 27);
				panel_1.add(chooseDay);
				chooseDay.setModel(dayModel);
				
						JComboBox chooseTime = new JComboBox();
						chooseTime.setBounds(126, 51, 97, 25);
						panel_1.add(chooseTime);
						chooseTime.setModel(timeModel);
						
								JLabel deliveryDay = new JLabel("Leveransdag");
								deliveryDay.setBounds(4, 23, 120, 15);
								panel_1.add(deliveryDay);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(16, 325, 322, 149);
		card2.add(panel_2);
		panel_2.setLayout(null);
		
				JLabel expireDateLabel = new JLabel("Utl�per:");
				expireDateLabel.setBounds(6, 115, 56, 16);
				panel_2.add(expireDateLabel);
				
						JTextField expiresYear = new JTextField();
						expiresYear.setBounds(63, 109, 39, 27);
						panel_2.add(expiresYear);
						
								JTextField expiresMonth = new JTextField();
								expiresMonth.setBounds(100, 109, 41, 27);
								panel_2.add(expiresMonth);
								
										cardNumberTextField = new JTextField();
										cardNumberTextField.setBounds(6, 72, 147, 28);
										panel_2.add(cardNumberTextField);
										cardNumberTextField.setColumns(10);
										
												cvcTextField = new JTextField();
												cvcTextField.setBounds(165, 72, 39, 28);
												panel_2.add(cvcTextField);
												cvcTextField.setColumns(10);
												
														JComboBox cardType = new JComboBox();
														cardType.setBounds(6, 33, 119, 27);
														panel_2.add(cardType);
														cardType.setModel(new DefaultComboBoxModel(new String[] {"-Korttyp-","VISA","MASTERCARD"}));
														
																JLabel paymentLabel = new JLabel("Betalningss\u00E4tt");
																paymentLabel.setBounds(6, 6, 90, 15);
																panel_2.add(paymentLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(16, 52, 322, 422);
		card2.add(panel_3);
		
		this.setLocation(300, 100);

		this.setVisible(true);

	}
}
