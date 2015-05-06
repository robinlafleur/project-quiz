package main;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class UI extends JPanel{
	private CardLayout cardLayout = new CardLayout();
	private JPanel pnlMain = new JPanel(cardLayout);
	
	private String rightAnswer;
	
	private IntroPanel introPnl = new IntroPanel(this);
	private QuizScreen quizScreenPnl = new QuizScreen(this);
	private WinScreen winScreenPnl = new WinScreen(this);
	private FailScreen failScreenPnl = new FailScreen(this);
	
	public UI(){
		setPreferredSize(new Dimension(768,768));
		
		pnlMain.add(introPnl, "IntroPanel");
		pnlMain.add(quizScreenPnl, "QuizScreen");
	    pnlMain.add(winScreenPnl, "WinScreen");
	 	pnlMain.add(failScreenPnl, "FailScreen");
		
		add(pnlMain);
	}
	
	public void swap(String panel){
		cardLayout.show(pnlMain, panel);
	}
	
	public void setRightAnswer(String rightAnswer){
		failScreenPnl.setRightAnswer(rightAnswer);
	}
	
}
