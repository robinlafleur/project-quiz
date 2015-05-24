package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * Klassen som ritar upp fönstret när du spelat en kategori
 */
public class EndScreen extends JPanel {
	private UI ui;
	private ImageIcon background = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/Handelse_1_Victory.png")));
	private JPanel pnlNorth = new JPanel(new GridLayout(2, 1));
	private JPanel pnlNorthNorth = new JPanel();
	private JPanel pnlNorthSouth = new JPanel();
	private JPanel pnlSouth = new JPanel();
	private JLabel labelNorthNorth = new JLabel();
	private JLabel labelNorthSouth = new JLabel("Poang: 18");
	private Font labelFont = new Font("Arial", Font.BOLD, 24);
	private JLabel labelSouth = new JLabel("", JLabel.CENTER);
	private JPanel pnlBackground = new JPanel();
	private JLabel lblBackground = new JLabel(background);
	private JButton btnCategory = new JButton("Nasta kategori");
	private JButton btnNewGame = new JButton("Nytt spel");
	private JLabel lblStory = new JLabel("temp");
	
	private Font font = new Font ("Garamond", Font.BOLD , 20);
	/*
	 * Konsturktorn ritar upp fönstret
	 */
	public EndScreen(UI ui) {
		this.ui = ui;
		setPreferredSize(new Dimension(768, 768));
		pnlBackground.setPreferredSize(new Dimension(768, 768));
		pnlNorth.setPreferredSize(new Dimension(768, 200));
		pnlNorth.setOpaque(false);
		pnlNorthNorth.setSize(new Dimension(380, 170));
		pnlNorthNorth.setOpaque(false);
		pnlNorthSouth.setSize(new Dimension(380, 100));
		pnlNorthSouth.setOpaque(false);
		pnlSouth.setPreferredSize(new Dimension(768, 300));
		pnlSouth.setOpaque(false);
		labelNorthNorth.setFont(labelFont);
		labelNorthSouth.setFont(labelFont);
		
		add(pnlBackground);
		pnlBackground.add(lblBackground);
		lblBackground.setLayout(new FlowLayout());
		lblBackground.add(pnlNorth);
		lblBackground.add(pnlSouth);
		pnlNorth.add(pnlNorthNorth);
		pnlNorthNorth.add(labelNorthNorth);
		pnlNorth.add(pnlNorthSouth);
		pnlNorthSouth.add(btnCategory);
		pnlNorthSouth.add(btnNewGame);
		pnlSouth.add(lblStory);
		
		lblStory.setFont(font);
		labelNorthNorth.setFont(font);
		
		addListeners();
	}
	/*
	 * Sätter text till en JLabel
	 */
	public void setStory(String story){
		lblStory.setText(story);
	}
	
	/*
	 * Skriver ut hur många poäng du fick
	 */
	
	public void setScore(String score){
		labelNorthNorth.setText("Poang: " + score);
	}	
	
	/*
	 * Lägger lyssnare till knapparna
	 */
	public void addListeners() {
		btnCategory.addActionListener(new CategoryButton());
		btnNewGame.addActionListener(new NewGameButton());
	}
	
	/*
	 * Sätter bakgrund beroende på tema
	 */
	
	public void setEndBackground(String path){
		background = new ImageIcon(
			Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/"+path)));
	lblBackground.setIcon(background);
	}
	
	/*
	 * Lyssnare till knappen för ny kategori
	 */
	
	private class CategoryButton implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(btnCategory.isEnabled()) {
				ui.playClickSound();
				ui.newCategory();
				ui.swap("CategoryScreen");
			}
		}
	}
	
	/*
	 * Lyssnare till knappen för att starta ett nytt spel
	 */
	
	private class NewGameButton implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(btnNewGame.isEnabled()) {
				ui.playClickSound();
				ui.newGame();
				ui.swap("IntroPanel");
			}
		}
	}
}

