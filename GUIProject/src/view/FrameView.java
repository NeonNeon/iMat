package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import controller.Director;
import controller.FrameController;

/**
 * The FrameView class is the base class of the iMat application. Every
 * component lies in this frame.
 * 
 * @author Grupp16
 * 
 */
public class FrameView extends JFrame {
	private static final Model model = Model.getInstance();
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 720;
	private static int counter = 0;
	private JPanel contentPane;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel centerPanel;
	private JTabbedPane tabPane;
	private FrameController frameController;
	private Color backGround = new Color(245, 245, 245);

	/**
	 * Create the frame.
	 */
	public FrameView(FrameController controller) {
		frameController = controller;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(70, 10, WIDTH, HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(backGround);

		leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 250, 679);
		contentPane.add(leftPanel);
		leftPanel.setLayout(new GridLayout(1, 1));

		rightPanel = new JPanel();
		rightPanel.setBounds(935, 0, 262, 679);
		contentPane.add(rightPanel);
		rightPanel.setLayout(new GridLayout(1, 1));

		centerPanel = new JPanel();
		centerPanel.setBounds(250, 50, 684, 631);
		contentPane.add(centerPanel);
		centerPanel.setLayout(new GridLayout(1, 1));

		tabPane = new JTabbedPane();
		addCenter(tabPane);
		setResizable(false);

	}
	public void setTab(int index) {
		tabPane.setSelectedIndex(index);
	}
	public void addCenter(Container con) {
		centerPanel.removeAll();
		centerPanel.add(con);
		// revalidate();
	}

	public void addLeft(Container con) {
		leftPanel.removeAll();
		leftPanel.add(con);
		// revalidate();
	}

	public void addRight(Container con) {
		rightPanel.removeAll();
		rightPanel.add(con);
		// revalidate();
	}

	public void addTab(String name, Container con) {
		tabPane.addTab(name, con);
		tabPane.setTabComponentAt(counter, new Tab(frameController, name));
		tabPane.setBackgroundAt(counter, backGround);
		counter++;
	}

	public void addSortView(Container con) {
		tabPane.setComponentAt(0, con);
	}

	public void addSearch(SearchResultsView searchResultsView) {
		if (tabPane.getComponent(0) instanceof JPanel) {
			JPanel cardPanel = (JPanel) tabPane.getComponent(0);
			cardPanel.add(searchResultsView, Director.SORTIMENT);
			((CardLayout) (cardPanel.getLayout())).show(cardPanel,
					Director.SORTIMENT);
		}
	}

}
