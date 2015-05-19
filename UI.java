package main;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class UI extends JPanel{

//	private QuestionList list = new QuestionList();
	private Question q;
	
	private CardLayout cardLayout = new CardLayout();
	private JPanel pnlMain = new JPanel(cardLayout);
	
	private IntroPanel introPnl = new IntroPanel(this);
	private QuizScreen quizScreenPnl = new QuizScreen(this);
	private WinScreen winScreenPnl = new WinScreen(this);
	private FailScreen failScreenPnl = new FailScreen(this);
	private CategoryScreen categoryScreenPnl = new CategoryScreen(this);
	
	private int rightAnswer;
	
	public UI(){
		setPreferredSize(new Dimension(768,768));
		
		pnlMain.add(introPnl, "IntroPanel");
		pnlMain.add(quizScreenPnl, "QuizScreen");
	    pnlMain.add(winScreenPnl, "WinScreen");
	 	pnlMain.add(failScreenPnl, "FailScreen");
	 	pnlMain.add(categoryScreenPnl, "CategoryScreen");
		
		add(pnlMain);
	}
	
	public void swap(String panel){
		cardLayout.show(pnlMain, panel);
	}
	
	public void setFailScreenAnswer(){
		failScreenPnl.setRightAnswer(q.getRightAnswer());
	}
	
	public void answers() {
		QuestionList list = new QuestionList();
		Random rand = new Random();
		list.questionList(); 
		list.randomInt(0);
		q = list.getQuestion();	
	}
	
	public String[] shuffleAnswers(){

		Random ran = new Random();
		String[] answers = new String[5];
		answers[0] = q.getQuestion();
		answers[1] = q.getRightAnswer();
		answers[2] = q.getWrongAnswer1();
		answers[3] = q.getWrongAnswer2();
		answers[4] = q.getWrongAnswer3();
				
		
		String[] shuffledAnswers = new String[4];
		
		int randomInt = ran.nextInt(4)+1;
		
		if(randomInt == 1){
			for(int i=0; i<4; i++){
				shuffledAnswers[i] = answers[i+1];
			}
			rightAnswer = 0;
		}
		else if(randomInt == 2){
			shuffledAnswers[0] = answers[3];
			shuffledAnswers[1] = q.getRightAnswer();
			shuffledAnswers[2] = answers[2];
			shuffledAnswers[3] = answers[4];
			rightAnswer = 1;
		}
		else if(randomInt == 3){
			shuffledAnswers[0] = answers[4];
			shuffledAnswers[1] = answers[3];
			shuffledAnswers[2] = q.getRightAnswer();
			shuffledAnswers[3] = answers[2];
			rightAnswer = 2;
		}
		else if(randomInt == 4){
			shuffledAnswers[0] = answers[3];
			shuffledAnswers[1] = answers[4];
			shuffledAnswers[2] = answers[2];
			shuffledAnswers[3] = q.getRightAnswer();
			rightAnswer = 3;
		}
		
		return shuffledAnswers;
	}
	
	public int getRightAnswer(){
		return rightAnswer;
	}
	
	public String getQuestion(){
		answers();
		String question = q.getQuestion();
		return question;
	}
	
	
	
}

