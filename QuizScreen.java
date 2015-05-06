package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class QuizScreen extends JPanel {
	private UI ui;
	private ImageIcon background = new ImageIcon("C:/Quizbilder/Bakgrund1.png");
	private JLabel lblQuestion = new JLabel("Fråga: Hur många bultar finns det i Ölandsbron?");
	private JPanel pnlBackground = new JPanel();
	private JLabel lblBackground = new JLabel(background);
	private JPanel pnlNorth = new JPanel();
	private JPanel pnlCenter = new JPanel();
	private JPanel pnlSouth = new JPanel();
	private Dimension btnSize = new Dimension(768, 20);
	
	private JButton[] buttons = new JButton[4];
	private int rightAnswer;
	
	
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
		
		pnlNorth.setPreferredSize(new Dimension(768, 200));
		pnlCenter.setPreferredSize(new Dimension(768, 600));
		pnlSouth.setPreferredSize(new Dimension(600, 50));
		
		lblBackground.add(pnlNorth);
		lblBackground.add(pnlCenter);
		lblBackground.add(pnlSouth);
		
		pnlNorth.add(lblQuestion);
		
		shuffleAnswers();
		addListeners();
	}
	
	public void shuffleAnswers(){
		setQuestion();
		String[] answers = ui.shuffleAnswers();
		
		for(int i=0; i<4; i++){
			buttons[i] = new JButton();
			buttons[i].setText(answers[i]);
			pnlCenter.add(buttons[i]);
		}
		
		rightAnswer = ui.getRightAnswer();
	}
	
	public void setQuestion(){
		lblQuestion.setText(ui.getQuestion());
	}
	
	public void addListeners(){
		for(int i=0; i<4; i++){
			if(i == rightAnswer){
				buttons[rightAnswer].addActionListener(new RightAnswerListener());
			}
			else{
				buttons[i].addActionListener(new WrongAnswerListener());
			}
		}
	}
	
	private class RightAnswerListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			ui.swap("WinScreen");
			
		}
		
	}
	
	private class WrongAnswerListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			ui.swap("FailScreen");
			ui.setFailScreenAnswer();
		}
		
	}
		
	
	


	
	
	
}

