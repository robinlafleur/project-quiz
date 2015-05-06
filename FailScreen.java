package project;

import java.awt.*;

import javax.swing.*;

public class FailScreen extends JPanel {
	private ImageIcon background = new ImageIcon("C:/Skolan/Systemutveckling/Projekt/bild/Bakgrund1.png");
	private ImageIcon icon1 = new ImageIcon("M:/systemutveckling projekt/bilder/glad.gif");
	private JPanel pnlNorth = new JPanel(new GridLayout(2, 1));
	private JPanel pnlNorthNorth = new JPanel();
	private JPanel pnlNorthSouth = new JPanel();
	private JPanel pnlSouth = new JPanel();
	private JLabel labelNorthNorth = new JLabel("FEL! FEL! FEL! Rätt svar är: ");
	private JLabel labelNorthSouth = new JLabel("ALTERNATIV 4");
	private Font labelFont = new Font("Arial", Font.BOLD, 24);
	private JLabel labelSouth = new JLabel("", icon1, JLabel.CENTER);
	private JPanel pnlBackground = new JPanel();
	private JLabel lblBackground = new JLabel(background);
	
	public FailScreen() {
		setPreferredSize(new Dimension(1000, 1000));
		pnlBackground.setPreferredSize(new Dimension(1000, 1000));
//		lblBackground.setPreferredSize(new Dimension(1000, 1000));
		pnlNorth.setPreferredSize(new Dimension(1000, 400));
		pnlNorth.setOpaque(false);
		pnlNorthNorth.setSize(new Dimension(380, 140));
		pnlNorthNorth.setOpaque(false);
		pnlNorthSouth.setSize(new Dimension(380, 140));
		pnlNorthSouth.setOpaque(false);
		pnlSouth.setPreferredSize(new Dimension(1000, 400));
		pnlSouth.setOpaque(false);
		labelNorthNorth.setFont(labelFont);
		labelNorthSouth.setFont(labelFont);
		
		add(pnlBackground);
		pnlBackground.add(lblBackground);
		lblBackground.setLayout(new FlowLayout());
		lblBackground.add(pnlNorth);
		pnlNorth.add(pnlNorthNorth);
		pnlNorthNorth.add(labelNorthNorth);
		pnlNorth.add(pnlNorthSouth);
		pnlNorthSouth.add(labelNorthSouth);
		pnlBackground.add(pnlSouth);
		pnlSouth.add(labelSouth);
	}


	public void start() {
		JFrame frame = new JFrame( "" ); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add( new FailScreen() );
		frame.pack();
		frame.setVisible(true); 
		
	}
	
		public static void main(String[] args) {
		FailScreen app = new FailScreen();
		app.start(); }
	}


