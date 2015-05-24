package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Klassen som visar själva frågeskärmen, där spelaren besvarar frågor.
 */
public class QuizScreen extends JPanel {
	private UI ui;
	private ImageIcon background = new ImageIcon(
			Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/Handelse_1_Start.png")));
	private JLabel lblQuestion = new JLabel();
	private JPanel pnlBackground = new JPanel();
	private JLabel lblBackground = new JLabel(background);
	private JPanel pnlNorth = new JPanel();
	private JPanel pnlCenter = new JPanel();
	private JPanel pnlSouth = new JPanel();
	private Question q;
	private JButton[] buttons = new JButton[4];
	private JLabel lblStory = new JLabel();
	private Font font = new Font ("Garamond", Font.BOLD , 20);
	
	/**
	 * Konstruktorn ritar upp spelplanen.
	 */
	public QuizScreen(UI ui) {
		this.ui = ui;
		setPreferredSize(new Dimension(768, 768));
		pnlBackground.setPreferredSize(new Dimension(768, 768));
		lblBackground.setPreferredSize(new Dimension(768, 768));

		add(pnlBackground);
		pnlBackground.add(lblBackground);
		lblBackground.setLayout(new FlowLayout());
		pnlNorth.setOpaque(false);
		pnlCenter.setOpaque(false);
		pnlSouth.setOpaque(false);

		pnlNorth.setPreferredSize(new Dimension(768, 100));
		pnlCenter.setPreferredSize(new Dimension(768, 150));
		pnlSouth.setPreferredSize(new Dimension(768, 200));

		lblBackground.add(pnlNorth);
		lblBackground.add(pnlCenter);
		lblBackground.add(pnlSouth);

		pnlNorth.add(lblQuestion);
		pnlSouth.add(lblStory);

		pnlCenter.add(buttons[0] = new JButton());
		pnlCenter.add(buttons[1] = new JButton());
		pnlCenter.add(buttons[2] = new JButton());
		pnlCenter.add(buttons[3] = new JButton());
		
		lblQuestion.setFont(font);
	}
	
	/**
	 * Metod som sätter text som kan visas på skärmen
	 */
	public void setStory(String story){
		lblStory.setText(story);
	}
	
	/**
	 * Metod som skriver ut frågan
	 */
	public void setQuestion(String question) {
		lblQuestion.setText("<html><p style=\"width:300px\">" + question + "</p></html>");
	}
	
	/**
	 * Metod som skriver ut rätt svar till en button
	 */
	public void setRightAnswer(int rAnswer, String answer) {
		buttons[rAnswer].setText(answer);
		buttons[rAnswer].addActionListener(new RightAnswerListener());
	}
	
	/**
	 * Metod som skriver ut fel svar till buttons
	 */
	public void setWrongAnswers(int[] wAnswers, String[] answers) {
		for (int i = 0; i < wAnswers.length; i++) {
			buttons[wAnswers[i]].setText(answers[i]);
			buttons[wAnswers[i]].addActionListener(new WrongAnswerListener());
		}
	}
	
	/**
	 * Metod som sätter håller reda på om fråga misslyckats
	 */
	public void setFailedQuestion(Question q) {
		this.q = q;
	}
	
	/**
	 * Metod som tar bort lyssnarna på knapparn
	 */
	public void removeListeners(){
		for(int i=0; i<buttons.length; i++){
			for(ActionListener l : buttons[i].getActionListeners()){
				buttons[i].removeActionListener(l);
			}
		}
	}
	
	/**
	 * Lyssnare till om man klickat på rätt svar
	 */
	private class RightAnswerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ui.playClickSound();
			ui.addGameScore();
			ui.swap("WinScreen");
		}
	}
	
	/**
	 * Lyssnare till de felaktiga knapparna
	 */
	private class WrongAnswerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ui.playClickSound();
			ui.swap("FailScreen");
			ui.addFailedQuestion(q);
		}
	}
	
	/**
	 * Metod som sätter backgrundstema för omgången
	 */
	public void setThemeBackground(String path){
			background = new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/"+path)));
		lblBackground.setIcon(background);
	}
}