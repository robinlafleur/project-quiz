package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * Klasssen som ritar upp fönstret som visas om du svarar fel på en fråga
 */
public class FailScreen extends JPanel {
	private UI ui;
	private ImageIcon background = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/Handelse_1_Bad.png")));
	private JPanel pnlNorth = new JPanel(new GridLayout(2, 1));
	private JPanel pnlNorthNorth = new JPanel();
	private JPanel pnlNorthSouth = new JPanel();
	private JPanel pnlSouth = new JPanel();
	private JLabel labelNorthNorth = new JLabel("FEL! FEL! FEL! Rätt svar är: ");
	private JLabel labelNorthSouth = new JLabel("");
	private Font labelFont = new Font("Arial", Font.BOLD, 24);
	private JLabel labelSouth = new JLabel("", JLabel.CENTER);
	private JPanel pnlBackground = new JPanel();
	private JLabel lblBackground = new JLabel(background);
	private JButton btnContinue = new JButton("Nästa fråga");
	private Font font = new Font ("Garamond", Font.BOLD , 20);
	
	/*
	 * Konstruktorna ritar upp fönstret
	 */
	
	public FailScreen(UI ui) {
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
		pnlNorthNorth.add(labelNorthSouth);
		pnlBackground.add(pnlSouth);
		pnlNorthSouth.add(btnContinue);
		
		labelNorthSouth.setFont(font);
		labelNorthNorth.setFont(font);
		
		btnContinue.addActionListener(new NewQuestion());
	}
	
	/*
	 * Metoder som skriver ut rätt svar
	 */
	public void setRightAnswer(String rightAnswer){
		labelNorthSouth.setText(rightAnswer);
	}
	
	/*
	 * Metod som skriver ut text när man vill går vidare
	 */
	
	public void setContinue(String txt){
		btnContinue.setText(txt);
	}
	
	/*
	 * Metod som sätter bakgrund beroende på tema
	 */
	public void setThemeBackground(String path){
		background = new ImageIcon(
			Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/"+path)));
	lblBackground.setIcon(background);
	}
	
	/*
	 * Lyssnare som gör att du kan klicka vidare till ny fråga
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


