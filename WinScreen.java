package project;

import java.awt.*;

import javax.swing.*;

public class WinScreen extends JPanel {
	private ImageIcon background = new ImageIcon("C:/Skolan/Systemutveckling/Projekt/bild/Bakgrund1.png");
	private ImageIcon icon1 = new ImageIcon("M:/systemutveckling projekt/bilder/glad.gif");
	private JPanel pnlNorth = new JPanel(new GridLayout(2, 1));
	private JPanel pnlNorthNorth = new JPanel();
	private JPanel pnlNorthSouth = new JPanel();
	private JPanel pnlSouth = new JPanel();
	private JLabel labelNorthNorth = new JLabel("DU SVARADE RÄTT!");
	private JLabel labelNorthSouth = new JLabel();
	private Font labelFont = new Font("Arial", Font.BOLD, 24);
	private JLabel labelSouth = new JLabel("", icon1, JLabel.CENTER);
	private JPanel pnlBackground = new JPanel();
	private JLabel lblBackground = new JLabel(background);
	
	public WinScreen() {
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
		frame.add( new WinScreen() );
		frame.pack();
		frame.setVisible(true); 
		
	}
	
		public static void main(String[] args) {
		WinScreen app = new WinScreen();
		app.start(); }
	}


