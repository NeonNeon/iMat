import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import se.chalmers.ait.dat215.project.Product;

/**
 * The FrameView class is the base class of the iMat application.
 * Every component lies in this frame.
 * @author Grupp16
 *
 */
public class FrameView extends JFrame {
	private static final Model model = Model.getInstance();
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 720;
	private JPanel contentPane;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel centerPanel;


	/**
	 * Create the frame.
	 */
	public FrameView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(70, 10, WIDTH, HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 250, 679);
		contentPane.add(leftPanel);
		leftPanel.setLayout(new GridLayout(1,1));
		
		rightPanel = new JPanel();
		rightPanel.setBounds(936, 0, 250, 679);
		contentPane.add(rightPanel);
		rightPanel.setLayout(new GridLayout(1,1));
		
		centerPanel = new JPanel();
		centerPanel.setBounds(250, 0, 684, 681);
		contentPane.add(centerPanel);
		centerPanel.setLayout(new GridLayout(1,1));
		
	}
	public void addCenter(Container con) {
		centerPanel.removeAll();
		centerPanel.add(con);
		revalidate();
	}
	public void addLeft(Container con) {
		leftPanel.removeAll();
		leftPanel.add(con);
		revalidate();
	}
	public void addRight(Container con) {
		rightPanel.removeAll();
		rightPanel.add(con);
		revalidate();
	}

}
