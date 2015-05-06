package project;

import java.awt.*;
import javax.swing.*;

public class EndScreen extends JPanel {
	private ImageIcon icon1 = new ImageIcon("M:/systemutveckling projekt/bilder/glad.gif");
	private JPanel pnlNorth = new JPanel(new GridLayout(2, 1));
	private JPanel pnlNorthNorth = new JPanel();
	private JPanel pnlNorthSouth = new JPanel();
	private JPanel pnlSouth = new JPanel();
	private JLabel labelNorthNorth = new JLabel("Bra jobbat!");
	private JLabel labelNorthSouth = new JLabel("Poäng: 18");
	private Font labelFont = new Font("Arial", Font.BOLD, 24);
	private JLabel labelSouth = new JLabel("", icon1, JLabel.CENTER);
	
	public EndScreen() {
		setPreferredSize(new Dimension(380, 600));
		setBackground(Color.WHITE);
		pnlNorth.setPreferredSize(new Dimension(380, 280));
		pnlNorth.setBackground(Color.WHITE);
		pnlNorthNorth.setSize(new Dimension(380, 140));
		pnlNorthNorth.setBackground(Color.WHITE);
		pnlNorthSouth.setSize(new Dimension(380, 140));
		pnlNorthSouth.setBackground(Color.WHITE);
		pnlSouth.setPreferredSize(new Dimension(380, 280));
		pnlSouth.setBackground(Color.WHITE);
		labelNorthNorth.setFont(labelFont);
		labelNorthSouth.setFont(labelFont);
		
		
		add(pnlNorth);
		pnlNorth.add(pnlNorthNorth);
		pnlNorthNorth.add(labelNorthNorth);
		pnlNorth.add(pnlNorthSouth);
		pnlNorthSouth.add(labelNorthSouth);
		add(pnlSouth);
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


