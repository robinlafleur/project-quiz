package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class QuizScreen extends JPanel {
	private UI ui;
	private ImageIcon background = new ImageIcon("C:/Skolan/Systemutveckling/Projekt/bild/CodeQuiz/Händelse_1_Start.jpg");
	private JLabel lblQuestion = new JLabel();
	private JPanel pnlBackground = new JPanel();
	private JLabel lblBackground = new JLabel(background);
	private JPanel pnlNorth = new JPanel();
	private JPanel pnlCenter = new JPanel();
	private JPanel pnlSouth = new JPanel();
	private JButton buttonBack = new JButton("TILLBAKA");
	private Question q;
	
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
		pnlCenter.setPreferredSize(new Dimension(768, 200));
		pnlSouth.setPreferredSize(new Dimension(768, 200));
		
		
		lblBackground.add(pnlNorth);
		lblBackground.add(pnlCenter);
		lblBackground.add(pnlSouth);
		
		pnlNorth.add(lblQuestion);
		shuffleAnswers();
		pnlSouth.add(buttonBack);
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
		lblQuestion.setFont(new Font("Arial", Font.PLAIN, 30));
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
		buttonBack.addActionListener(new BackButtonListener());
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
	
	private class BackButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			if(buttonBack.isEnabled()) {
				int res = JOptionPane.showConfirmDialog(null, "Vill du gå tillbaka och välja kategori?", "", JOptionPane.YES_NO_OPTION);
				if(res == JOptionPane.YES_OPTION) {
					ui.swap("CategoryScreen");
				}
			}
		}
	}
}	
	
