package view;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;


public class RecipeView extends JPanel {

	private Color background = Constants.BACKGROUNDCOLOR.getColor();
	//private Color borderColor = Constants.HOVERCOLOR.getColor();
	private Font font = Constants.TEXTFONT.getFont();
	private ImageIcon inspirationIcon = new ImageIcon("lib/Bildmapp/receptHeader.png");
	private ImageIcon salladIcon = new ImageIcon("lib/Bildmapp/sallad.png");
	private ImageIcon laxIcon = new ImageIcon("lib/Bildmapp/lax.png");
	private ImageIcon pastaIcon = new ImageIcon("lib/Bildmapp/kottfars.png");
	private ImageIcon kycklingIcon = new ImageIcon("lib/Bildmapp/kyckling.png");
	private ImageIcon hamburgareIcon = new ImageIcon("lib/Bildmapp/hamburgare.png");
	private ImageIcon grytaIcon = new ImageIcon("lib/Bildmapp/gryta.png");
	private ImageIcon paniniIcon = new ImageIcon("lib/Bildmapp/panini.png");
	private ImageIcon tacosIcon = new ImageIcon("lib/Bildmapp/tacos.png");
	private ImageIcon wokIcon = new ImageIcon("lib/Bildmapp/wok.png");
	
	private MouseListener mouseListener = new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	/**
	 * Create the panel.
	 */
	public RecipeView() {
		//setBorder(new LineBorder(borderColor, 2, true));
		setBackground(background);
		setSize(684, 581);
		setLayout(null);
		
		JLabel inspirationLabel = new JLabel(inspirationIcon);
		inspirationLabel.setBounds(10, 11, 317, 251);
		inspirationLabel.addMouseListener(mouseListener);
		add(inspirationLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Laga n\u00E5got nytt ikv\u00E4ll?");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel_1.setBounds(316, 10, 356, 35);
		//lblNewLabel_1.addMouseListener(mouseListener);
		add(lblNewLabel_1);
		
		JLabel grillLabel = new JLabel(paniniIcon);
		grillLabel.setBounds(339, 57, 148, 99);
		grillLabel.setBorder(new LineBorder(Color.black, 1, true));
		grillLabel.addMouseListener(mouseListener);
		add(grillLabel);
		
		JLabel salladLabel = new JLabel(salladIcon);
		salladLabel.setBounds(515, 163, 148, 99);
		salladLabel.setBorder(new LineBorder(Color.black, 1, true));
		salladLabel.addMouseListener(mouseListener);
		add(salladLabel);
		
		JLabel lblVeckansRecept = new JLabel("Veckans recept");
		lblVeckansRecept.setHorizontalAlignment(SwingConstants.CENTER);
		lblVeckansRecept.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVeckansRecept.setBounds(251, 325, 181, 35);
		add(lblVeckansRecept);
		
		JLabel lblNewLabel_4 = new JLabel(pastaIcon);
		lblNewLabel_4.setToolTipText("\u00D6ppna recept");
		lblNewLabel_4.setBounds(10, 395, 83, 67);
		lblNewLabel_4.setBorder(new LineBorder(Color.black, 1, true));
		lblNewLabel_4.addMouseListener(mouseListener);
		add(lblNewLabel_4);
		
		JLabel label = new JLabel(laxIcon);
		label.setToolTipText("\u00D6ppna recept");
		label.setBounds(103, 395, 89, 67);
		label.setBorder(new LineBorder(Color.black, 1, true));
		label.addMouseListener(mouseListener);
		add(label);
		
		JLabel label_1 = new JLabel(kycklingIcon);
		label_1.setToolTipText("\u00D6ppna recept");
		label_1.setBounds(202, 395, 83, 67);
		label_1.setBorder(new LineBorder(Color.black, 1, true));
		label_1.addMouseListener(mouseListener);
		add(label_1);
		
		JLabel label_2 = new JLabel(hamburgareIcon);
		label_2.setToolTipText("\u00D6ppna recept");
		label_2.setBounds(295, 395, 89, 67);
		label_2.setBorder(new LineBorder(Color.black, 1, true));
		label_2.addMouseListener(mouseListener);
		add(label_2);
		
		JLabel label_3 = new JLabel(tacosIcon);
		label_3.setToolTipText("\u00D6ppna recept");
		label_3.setBounds(394, 395, 83, 67);
		label_3.setBorder(new LineBorder(Color.black, 1, true));
		label_3.addMouseListener(mouseListener);
		add(label_3);
		
		JLabel label_4 = new JLabel(grytaIcon);
		label_4.setToolTipText("\u00D6ppna recept");
		label_4.setBounds(487, 395, 89, 67);
		label_4.setBorder(new LineBorder(Color.black, 1, true));
		label_4.addMouseListener(mouseListener);
		add(label_4);
		
		JLabel label_5 = new JLabel(wokIcon);
		label_5.setToolTipText("\u00D6ppna recept");
		label_5.setBounds(585, 395, 89, 67);
		label_5.setBorder(new LineBorder(Color.black, 1, true));
		label_5.addMouseListener(mouseListener);
		add(label_5);
		
		JLabel lblMndag = new JLabel("M\u00E5ndag");
		lblMndag.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMndag.setHorizontalAlignment(SwingConstants.CENTER);
		lblMndag.addMouseListener(mouseListener);
		lblMndag.setBounds(10, 362, 83, 22);
		add(lblMndag);
		
		JLabel lblOnsdag = new JLabel("Onsdag");
		lblOnsdag.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnsdag.setFont(new Font("Dialog", Font.BOLD, 14));
		lblOnsdag.setBounds(202, 362, 83, 22);
		lblOnsdag.addMouseListener(mouseListener);
		add(lblOnsdag);
		
		JLabel lblTisdag = new JLabel("Tisdag");
		lblTisdag.setHorizontalAlignment(SwingConstants.CENTER);
		lblTisdag.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTisdag.setBounds(103, 364, 89, 19);
		lblTisdag.addMouseListener(mouseListener);
		add(lblTisdag);
		
		JLabel lblTorsdag = new JLabel("Torsdag");
		lblTorsdag.setHorizontalAlignment(SwingConstants.CENTER);
		lblTorsdag.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTorsdag.setBounds(295, 365, 89, 19);
		lblTorsdag.addMouseListener(mouseListener);
		add(lblTorsdag);
		
		JLabel lblFredag = new JLabel("Fredag");
		lblFredag.setHorizontalAlignment(SwingConstants.CENTER);
		lblFredag.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFredag.setBounds(394, 362, 83, 22);
		lblFredag.addMouseListener(mouseListener);
		add(lblFredag);
		
		JLabel lblLrdag = new JLabel("L\u00F6rdag");
		lblLrdag.setHorizontalAlignment(SwingConstants.CENTER);
		lblLrdag.setFont(new Font("Dialog", Font.BOLD, 14));
		lblLrdag.setBounds(487, 365, 89, 19);
		lblLrdag.addMouseListener(mouseListener);
		add(lblLrdag);
		
		JLabel lblSndag = new JLabel("S\u00F6ndag");
		lblSndag.setHorizontalAlignment(SwingConstants.CENTER);
		lblSndag.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSndag.setBounds(585, 367, 89, 19);
		lblSndag.addMouseListener(mouseListener);
		add(lblSndag);
		
		JLabel lblNewLabel = new JLabel("Grillat och gott!");
		lblNewLabel.setForeground(new Color(0, 153, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(487, 87, 185, 35);
		lblNewLabel.setFont(new Font("Gabriola", Font.PLAIN, 22));
		//lblNewLabel_1.addMouseListener(mouseListener);
		add(lblNewLabel);
		
		JLabel lblEnFrchSallad = new JLabel("En fr\u00E4ch sallad!");
		lblEnFrchSallad.setForeground(new Color(0, 153, 0));
		lblEnFrchSallad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnFrchSallad.setFont(new Font("Gabriola", Font.PLAIN, 22));
		lblEnFrchSallad.setBounds(343, 208, 175, 35);
		//lblNewLabel_1.addMouseListener(mouseListener);
		add(lblEnFrchSallad);
		
		JLabel lblNewLabel_2 = new JLabel("K\u00F6ttf\u00E4rss\u00E5s");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 466, 83, 22);
		lblNewLabel_2.addMouseListener(mouseListener);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Laxpaj");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(103, 473, 89, 14);
		lblNewLabel_3.addMouseListener(mouseListener);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Kycklingsallad");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(202, 470, 83, 14);
		lblNewLabel_5.addMouseListener(mouseListener);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Hamburgare");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(295, 470, 89, 14);
		lblNewLabel_6.addMouseListener(mouseListener);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Tacos");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(394, 470, 83, 14);
		lblNewLabel_7.addMouseListener(mouseListener);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Svampgryta");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(487, 470, 89, 14);
		lblNewLabel_8.addMouseListener(mouseListener);
		add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Wok");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(585, 470, 89, 14);
		lblNewLabel_9.addMouseListener(mouseListener);
		add(lblNewLabel_9);

	}
}
