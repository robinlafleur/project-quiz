package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * Klassen som ritar upp fönstret när du svarat rätt på en fråga
 */
public class WinScreen extends JPanel {
	private UI ui;
	private ImageIcon background = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/Handelse_1_Victory.png")));
	private JPanel pnlNorth = new JPanel(new GridLayout(2, 1));
	private JPanel pnlNorthNorth = new JPanel();
	private JPanel pnlNorthSouth = new JPanel();
	private JPanel pnlSouth = new JPanel();
	private JLabel labelNorthNorth = new JLabel("DU SVARADE RÄTT!");
	private JLabel labelNorthSouth = new JLabel();
	private Font labelFont = new Font("Arial", Font.BOLD, 24);
	private JLabel labelSouth = new JLabel("", JLabel.CENTER);
	private JPanel pnlBackground = new JPanel();
	private JLabel lblBackground = new JLabel(background);
	private JButton btnContinue = new JButton("Nästa fråga");
	
	private Font font = new Font ("Garamond", Font.BOLD , 20);
	
	/*
	 * Konstruktorn ritar upp fönstret.
	 */
	
	public WinScreen(UI ui) {
		this.ui = ui;
		setPreferredSize(new Dimension(768, 768));
		pnlBackground.setPreferredSize(new Dimension(768, 768));
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
		
		pnlNorthSouth.add(btnContinue);
		
		btnContinue.addActionListener(new NewQuestion());
		
		labelNorthNorth.setFont(font);
	}
	
	/*
	 * Sätter texten till knappen som gör att du kan klicka dig vidare
	 */
	
	public void setContinue(String txt){
		btnContinue.setText(txt);
	}
	
	/*
	 * Sätter bakgrund beroende på tema
	 */
	
	public void setThemeBackground(String path){
		background = new ImageIcon(
			Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/"+path)));
	lblBackground.setIcon(background);
	}
	
	/*
	 * Lyssnaren till knappen för att komma till nästa fråga
	 */
	
	private class NewQuestion implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(btnContinue.isEnabled()) {
				ui.playClickSound();
				ui.swap("QuizScreen");
				ui.newQuestion();
			}
		}
	}
}


