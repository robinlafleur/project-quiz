package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FailScreen extends JPanel {
	private UI ui;
	private ImageIcon background = new ImageIcon("C:/Skolan/Systemutveckling/Projekt/bild/CodeQuiz/Händelse_1_Bad.jpg");
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
	
	public FailScreen(UI ui) {
		this.ui = ui;
		setPreferredSize(new Dimension(768, 768));
		pnlBackground.setPreferredSize(new Dimension(768, 768));
//		lblBackground.setPreferredSize(new Dimension(1000, 1000));
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
//		pnlSouth.add(labelSouth);
		
		btnContinue.addActionListener(new NewQuestion());
	}
	
	public void setRightAnswer(String rightAnswer){
		labelNorthSouth.setText(rightAnswer);
	}
	
	private class NewQuestion implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(btnContinue.isEnabled()) {
				ui.swap("QuizScreen");
				QuestionList list = new QuestionList();
				list.removeQuestion();
				
			}
		}
	}
	
}


