package main;

import java.awt.*;

import javax.swing.*;

public class EndScreen extends JPanel {
	private ImageIcon background = new ImageIcon("C:/Skolan/Systemutveckling/Projekt/bild/CodeQuiz/Händelse_1_Victory.jpg");
	private JPanel pnlNorth = new JPanel(new GridLayout(2, 1));
	private JPanel pnlNorthNorth = new JPanel();
	private JPanel pnlNorthSouth = new JPanel();
	private JPanel pnlSouth = new JPanel();
	private JLabel labelNorthNorth = new JLabel("Bra jobbat!");
	private JLabel labelNorthSouth = new JLabel("Poäng: 18");
	private Font labelFont = new Font("Arial", Font.BOLD, 24);
	private JLabel labelSouth = new JLabel("", JLabel.CENTER);
	private JPanel pnlBackground = new JPanel();
	private JLabel lblBackground = new JLabel(background);
	
	public EndScreen() {
		setPreferredSize(new Dimension(768, 768));
		pnlBackground.setPreferredSize(new Dimension(768, 768));
//		lblBackground.setPreferredSize(new Dimension(1000, 1000));
		pnlNorth.setPreferredSize(new Dimension(768, 400));
		pnlNorth.setOpaque(false);
		pnlNorthNorth.setSize(new Dimension(380, 140));
		pnlNorthNorth.setOpaque(false);
		pnlNorthSouth.setSize(new Dimension(380, 140));
		pnlNorthSouth.setOpaque(false);
		pnlSouth.setPreferredSize(new Dimension(768, 400));
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
		frame.add( new EndScreen() );
		frame.pack();
		frame.setVisible(true); 
		
	}
	
		public static void main(String[] args) {
		EndScreen app = new EndScreen();
		app.start(); }
	}


