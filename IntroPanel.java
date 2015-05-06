package quizUI;

import java.awt.*;

import javax.swing.*;

public class IntroPanel extends JPanel {
	private ImageIcon background = new ImageIcon("C:/filer/Bakgrund1.PNG");
	private JLabel lblTitle = new JLabel("Välkommen till CodeQuiz");
	private JPanel pnlBackground = new JPanel();
	private JLabel lblBackground = new JLabel(background);
	private JPanel pnlNorth = new JPanel();
	private JPanel pnlCenter = new JPanel();
	private JPanel pnlSouth = new JPanel();
	private JButton[] buttons = new JButton[3];
	private Dimension btnSize = new Dimension(200, 50);
	private final int panelSizeUnit = 192;
	
	public IntroPanel() {
		setPreferredSize(new Dimension(768, 768));
		pnlBackground.setPreferredSize(new Dimension(768, 768));
		lblBackground.setPreferredSize(new Dimension(768, 768));
		
		add(pnlBackground);
		pnlBackground.add(lblBackground);
		lblBackground.setLayout(new FlowLayout());
		pnlNorth.setOpaque(false);
		pnlCenter.setOpaque(false);
		pnlSouth.setOpaque(false);
		
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 30));
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setOpaque(false);
			buttons[i].setPreferredSize(btnSize);
			pnlSouth.add(buttons[i]);
		}
		
		buttons[0].setText("Nytt spel");
		buttons[1].setText("Skapa fråga");
		buttons[2].setText("Avsluta");
		
		pnlNorth.setPreferredSize(new Dimension(768, panelSizeUnit));
		pnlCenter.setPreferredSize(new Dimension(768, panelSizeUnit));
		pnlSouth.setPreferredSize(new Dimension(250, panelSizeUnit*2));
		
		lblBackground.add(pnlNorth);
		lblBackground.add(pnlCenter);
		lblBackground.add(pnlSouth);
		
		pnlNorth.add(lblTitle);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("QUIZ");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add( new IntroPanel() );
		frame.pack();
		frame.setVisible(true);
	}
}