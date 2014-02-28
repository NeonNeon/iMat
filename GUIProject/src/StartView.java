import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import se.chalmers.ait.dat215.project.*;
import se.chalmers.ait.dat215.project.util.*;


public class StartView extends JPanel {

	private static final Model model = Model.getInstance();
	
	/**
	 * Create the panel.
	 */
	public StartView() {
		setBackground(new Color(235, 255, 227));
		setBorder(new LineBorder(new Color(181, 222, 164), 2, true));
		
		setSize(684, 681);
		setLayout(null);
		
		JLabel logoLabel = new JLabel("En fin logga");
		logoLabel.setBounds(10, 11, 664, 207);
		add(logoLabel);
		
		JLabel nbrLabel1 = new JLabel("  1");
		nbrLabel1.setFont(new Font("Tahoma", Font.BOLD, 16));
		nbrLabel1.setBounds(246, 247, 35, 35);
		add(nbrLabel1);
		
		JLabel nbrLabel2 = new JLabel("  2");
		nbrLabel2.setFont(new Font("Tahoma", Font.BOLD, 16));
		nbrLabel2.setBounds(246, 293, 35, 35);
		add(nbrLabel2);
		
		JLabel nbrLabel3 = new JLabel("  3");
		nbrLabel3.setFont(new Font("Tahoma", Font.BOLD, 16));
		nbrLabel3.setBounds(246, 339, 35, 35);
		add(nbrLabel3);
		
		JLabel instructionLabel1 = new JLabel("V\u00E4lj dina varor");
		instructionLabel1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		instructionLabel1.setBounds(291, 258, 127, 14);
		add(instructionLabel1);
		
		JLabel instructionLabel2 = new JLabel("Betala");
		instructionLabel2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		instructionLabel2.setBounds(292, 304, 46, 14);
		add(instructionLabel2);
		
		JLabel instructionLabel3 = new JLabel("F\u00E5 maten hemk\u00F6rd!");
		instructionLabel3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		instructionLabel3.setBounds(291, 350, 127, 14);
		add(instructionLabel3);
		
		JPanel offerPanel = new JPanel();
		offerPanel.setBorder(null);
		offerPanel.setBackground(new Color(255, 255, 240));
		offerPanel.setBounds(10, 432, 664, 238);
		add(offerPanel);
		offerPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblVeckansErbjudanden = new JLabel("Veckans erbjudanden!");
		lblVeckansErbjudanden.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblVeckansErbjudanden.setBounds(226, 385, 246, 36);
		add(lblVeckansErbjudanden);
		
		//Lägger till erbjudanden längst ner
		for(int i = 1; i <= 3; i++){
			offerPanel.add(new ErbjudandePanel(model.getProduct(i)));
		}

	}
}
