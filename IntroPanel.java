package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class IntroPanel extends JPanel {
	private UI ui;
	private ImageIcon background = new ImageIcon("C:/Quizbilder/Bakgrund1.PNG");
	private JLabel lblTitle = new JLabel("Välkommen till CodeQuiz");
	private JPanel pnlBackground = new JPanel();
	private JLabel lblBackground = new JLabel(background);
	private JPanel pnlNorth = new JPanel();
	private JPanel pnlCenter = new JPanel();
	private JPanel pnlSouth = new JPanel();
	private JButton[] buttons = new JButton[3];
	private Dimension btnSize = new Dimension(200, 50);
	private final int panelSizeUnit = 192;
	
	public IntroPanel(UI ui) {
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
		
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 30));
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setOpaque(false);
			buttons[i].setPreferredSize(btnSize);
			pnlSouth.add(buttons[i]);
		}
		
		buttons[0].setText("Nytt spel");
		buttons[1].setText("Skapa fråga");
		buttons[2].setText("Avsluta");
		
		addListeners();
		
		pnlNorth.setPreferredSize(new Dimension(768, panelSizeUnit));
		pnlCenter.setPreferredSize(new Dimension(768, panelSizeUnit));
		pnlSouth.setPreferredSize(new Dimension(250, panelSizeUnit*2));
		
		lblBackground.add(pnlNorth);
		lblBackground.add(pnlCenter);
		lblBackground.add(pnlSouth);
		
		pnlNorth.add(lblTitle);
	}
	
	public void addListeners(){
		buttons[0].addActionListener(new NewGameListener());
		buttons[1].addActionListener(new CreateQuestionListener());
		buttons[2].addActionListener(new ExitListener());
	}
	
	private class NewGameListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			ui.swap("QuizScreen");
		}
	}
	
	private class CreateQuestionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Error 1337 \nContact blizzard support team");
		}
	}
	
	private class ExitListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
}