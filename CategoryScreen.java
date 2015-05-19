package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CategoryScreen extends JPanel {
	private UI ui;
	private ImageIcon background = new ImageIcon("C:/Skolan/Systemutveckling/Projekt/bild/CodeQuiz/Category_Screen.png");
	private JPanel pnlBackground = new JPanel();
	private JLabel lblBackground = new JLabel(background);
	
	private JPanel pnlNorth = new JPanel();
	private JLabel lblNorth = new JLabel();
	
	private JPanel pnlCenter = new JPanel();
	private JPanel pnlSouth = new JPanel();
	
	private JButton category1 = new JButton();
	private JButton category2 = new JButton();
	private JButton category3 = new JButton();
	private JButton category4 = new JButton();
	private JButton category5 = new JButton();
	private JButton category6 = new JButton();
	private JButton category7 = new JButton();
	private JButton category8 = new JButton();
	private JButton category9 = new JButton();
	private JButton category10 = new JButton();
	private JButton btnBack = new JButton();
	
	private Dimension btnSize = new Dimension(100, 50);
	
	public CategoryScreen(UI ui) {
		this.ui = ui;
		pnlBackground.setPreferredSize(new Dimension(1000, 1000));
		
		add(pnlBackground);
		pnlBackground.add(lblBackground);
		lblBackground.setLayout(new FlowLayout());
		
		pnlNorth.setPreferredSize(new Dimension(1000, 100)); //Panel till "v�lj en kategori"
		pnlNorth.setOpaque(false);
		lblBackground.add(pnlNorth);
		pnlNorth.add(lblNorth);
		
		pnlCenter.setPreferredSize(new Dimension(1000, 600));
		pnlCenter.setOpaque(false);
		pnlCenter.setLayout(new GridLayout(11, 1));
		lblBackground.add(pnlCenter);
		category1.setSize(btnSize);
		category2.setSize(btnSize);
		category3.setSize(btnSize);
		category4.setSize(btnSize);
		category5.setSize(btnSize);
		category6.setSize(btnSize);
		category7.setSize(btnSize);
		category8.setSize(btnSize);
		category9.setSize(btnSize);
		category10.setSize(btnSize);
		btnBack.setSize(btnSize);
		
		category1.setIcon(new ImageIcon("C:/Skolan/Systemutveckling/Projekt/bild/CodeQuiz/Kodstrukturering_Category_1.png"));
		category1.setOpaque(false);
		category1.setContentAreaFilled(false);
		category1.setBorderPainted(false);
		
		category2.setIcon(new ImageIcon("C:/Skolan/Systemutveckling/Projekt/bild/CodeQuiz/Datatyper_Category_2.png"));
		category2.setOpaque(false);
		category2.setContentAreaFilled(false);
		category2.setBorderPainted(false);
		
		category3.setIcon(new ImageIcon("C:/Skolan/Systemutveckling/Projekt/bild/CodeQuiz/metoder_Category_3.png"));
		category3.setOpaque(false);
		category3.setContentAreaFilled(false);
		category3.setBorderPainted(false);
		
		category4.setIcon(new ImageIcon("C:/Skolan/Systemutveckling/Projekt/bild/CodeQuiz/Loopar_Category_4.png"));
		category4.setOpaque(false);
		category4.setContentAreaFilled(false);
		category4.setBorderPainted(false);
		
		category5.setIcon(new ImageIcon("C:/Skolan/Systemutveckling/Projekt/bild/CodeQuiz/User_Interface_Category_5.png"));
		category5.setOpaque(false);
		category5.setContentAreaFilled(false);
		category5.setBorderPainted(false);
		
		category6.setIcon(new ImageIcon("C:/Skolan/Systemutveckling/Projekt/bild/CodeQuiz/Arrays_Category_6.png"));
		category6.setOpaque(false);
		category6.setContentAreaFilled(false);
		category6.setBorderPainted(false);
		
		category7.setIcon(new ImageIcon("C:/Skolan/Systemutveckling/Projekt/bild/CodeQuiz/Exceptions_Category_7.png"));
		category7.setOpaque(false);
		category7.setContentAreaFilled(false);
		category7.setBorderPainted(false);
		
		category8.setIcon(new ImageIcon("C:/Skolan/Systemutveckling/Projekt/bild/CodeQuiz/Polymorfism_Category_8.png"));
		category8.setOpaque(false);
		category8.setContentAreaFilled(false);
		category8.setBorderPainted(false);
		
		category9.setIcon(new ImageIcon("C:/Skolan/Systemutveckling/Projekt/bild/CodeQuiz/Inkapsling_Category_9.png"));
		category9.setOpaque(false);
		category9.setContentAreaFilled(false);
		category9.setBorderPainted(false);
		
		category10.setIcon(new ImageIcon("C:/Skolan/Systemutveckling/Projekt/bild/CodeQuiz/Threads_Category_10.png"));
		category10.setOpaque(false);
		category10.setContentAreaFilled(false);
		category10.setBorderPainted(false);
		
		btnBack.setIcon(new ImageIcon("C:/Skolan/Systemutveckling/Projekt/bild/CodeQuiz/Back.png"));
		btnBack.setOpaque(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		
		addListeners();
		
		pnlCenter.add(category1);
		pnlCenter.add(category2);
		pnlCenter.add(category3);
		pnlCenter.add(category4);
		pnlCenter.add(category5);
		pnlCenter.add(category6);
		pnlCenter.add(category7);
		pnlCenter.add(category8);
		pnlCenter.add(category9);
		pnlCenter.add(category10);
		pnlCenter.add(btnBack);
	}
	
	public void addListeners(){
		category1.addActionListener(new CategoryListener());
		btnBack.addActionListener(new BackListener());
	}
	
	private class CategoryListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			ui.swap("QuizScreen");
			QuestionList list = new QuestionList();
//			list.questionList();
		}
	}
	
	private class BackListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			ui.swap("IntroPanel");
			
		}
	}

}
