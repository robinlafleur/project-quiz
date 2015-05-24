package main;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Huvudmenyn.
 */
public class IntroPanel extends JPanel {
	private UI ui;
	private ImageIcon background = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/New_Game_Screen.png")));
	private JPanel pnlBackground = new JPanel();
	private JLabel lblBackground = new JLabel(background);
	private JPanel pnlNorth = new JPanel();
	private JPanel pnlCenter = new JPanel();
	private JPanel pnlSouth = new JPanel();
	private JButton[] buttons = new JButton[3];
	private Dimension btnSize = new Dimension(200, 50);
	private Dimension btnSize2 = new Dimension(400, 50);
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
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setOpaque(false);
		
			
			buttons[i].setOpaque(false);
			buttons[i].setContentAreaFilled(false);
			buttons[i].setBorderPainted(false);
			pnlSouth.add(buttons[i]);
		}
		
		buttons[0].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/New_Game.png"))));
		buttons[1].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/Create_Question.png"))));
		buttons[2].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/Quit.png"))));
		
		buttons[0].setPreferredSize(btnSize);
		buttons[1].setPreferredSize(btnSize2);			
		buttons[2].setPreferredSize(btnSize);
		
		addListeners();
		
		pnlNorth.setPreferredSize(new Dimension(768, panelSizeUnit));
		pnlCenter.setPreferredSize(new Dimension(768, panelSizeUnit));
		pnlSouth.setPreferredSize(new Dimension(300, panelSizeUnit*2));
		
		lblBackground.add(pnlNorth);
		lblBackground.add(pnlCenter);
		lblBackground.add(pnlSouth);
	}
	
	/**
	 * Lägger till lyssnare för knapparna.
	 */
	public void addListeners(){
		buttons[0].addActionListener(new NewGameListener());
		buttons[1].addActionListener(new CreateQuestionListener());
		buttons[2].addActionListener(new ExitListener());
	}
	
	/**
	 * Lyssnare för 'Nytt spel'-knappen.
	 */
	private class NewGameListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			ui.playClickSound();
			ui.newGame();
			ui.swap("CategoryScreen");
			ui.playSong();
		}
	}
	
	/**
	 * Lyssnare för 'Skapa fråga'-knappen.
	 */
	private class CreateQuestionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			ui.playClickSound();
			ui.swap("CreationScreen");
		}
	}
	
	/**
	 * Lyssnare för 'Avsluta'-knappen.
	 */
	private class ExitListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}