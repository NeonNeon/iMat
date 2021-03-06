package view;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import controller.FrameController;
import se.chalmers.ait.dat215.project.*;
import se.chalmers.ait.dat215.project.util.*;

/**
 * The view that shows when you first start the application
 * @author Grupp16
 *
 */

public class StartView extends JPanel {

	private static final Model model = Model.getInstance();
	FrameController frameController;
	private Color background = Color.WHITE;
	private Font textFont = Constants.TEXTFONT.getFont();
	private Color textColor = Constants.TEXTCOLOR.getColor();
	private Font headerFont = Constants.HEADERFONT.getFont();
	private ImageIcon headerIcon = new ImageIcon("lib/Bildmapp/iMatHeader.jpg");
	/**
	 * Create the panel.
	 */
	public StartView(FrameController controller) {
		frameController=controller;
		setBackground(background);
		
		setSize(684, 581);
		setLayout(null);
		
		JLabel logoLabel = new JLabel();
		logoLabel.setBounds(10, 11, 664, 185);
		//logoLabel.setBorder(new LineBorder(Constants.TEXTCOLORLIGHT.getColor(),4));
		logoLabel.setIcon(headerIcon);
		add(logoLabel);
		
		JLabel nbrLabel1 = new JLabel("  1");
		nbrLabel1.setFont(new Font("Tahoma", Font.BOLD, 16));
		nbrLabel1.setBounds(246, 200, 35, 35);
		add(nbrLabel1);
		
		JLabel nbrLabel2 = new JLabel("  2");
		nbrLabel2.setFont(new Font("Tahoma", Font.BOLD, 16));
		nbrLabel2.setBounds(246, 225, 35, 35);
		add(nbrLabel2);
		
		JLabel nbrLabel3 = new JLabel("  3");
		nbrLabel3.setFont(new Font("Tahoma", Font.BOLD, 16));
		nbrLabel3.setBounds(246, 250, 35, 35);
		add(nbrLabel3);
		
		JLabel instructionLabel1 = new JLabel("V\u00E4lj dina varor");
		instructionLabel1.setFont(textFont);
		instructionLabel1.setBounds(290, 205, 127, 25);
		add(instructionLabel1);
		
		JLabel instructionLabel2 = new JLabel("Betala");
		instructionLabel2.setFont(textFont);
		instructionLabel2.setBounds(290, 230, 91, 25);
		add(instructionLabel2);
		
		JLabel instructionLabel3 = new JLabel("F\u00E5 maten hemk\u00F6rd!");
		instructionLabel3.setFont(textFont);
		instructionLabel3.setBounds(290, 255, 127, 25);
		add(instructionLabel3);
		
		JPanel offerPanel = new JPanel();
		offerPanel.setBorder(null);
		offerPanel.setBackground(background);
		offerPanel.setBounds(10, 330, 664, 240);
		add(offerPanel);
		offerPanel.setLayout(new GridLayout(1, 0, 6, 0));
		
		JLabel lblVeckansErbjudanden = new JLabel("Veckans erbjudanden!");
		lblVeckansErbjudanden.setFont(headerFont);
		lblVeckansErbjudanden.setForeground(Constants.TEXTCOLOR.getColor());
		lblVeckansErbjudanden.setBounds(222, 290, 246, 36);
		add(lblVeckansErbjudanden);
		
		//L�gger till erbjudanden l�ngst ner
		for(int i = 1; i <= 3; i++){
			offerPanel.add(new ErbjudandePanel(model.getProduct(i),frameController));
		}

	}
}
