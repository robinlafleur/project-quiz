package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * Klassen ritar upp fönstret som visas när du har spelat igenom en hel omgång
 */
public class FinalScreen extends JPanel {
	private UI ui;
	private ImageIcon background = new ImageIcon(
			Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/Bakgrund1.png")));
	private JPanel pnlBackground = new JPanel();
	private JLabel lblBackground = new JLabel(background);
	private JLabel lblHeadline = new JLabel("Frågorna du svarade fel på:");
	private JLabel lblPoints = new JLabel("1000");
	private JButton btnNewGame = new JButton();
	private JButton btnExit = new JButton();
	private JLabel lblNewGame = new JLabel();
	private JPanel pnlNorth = new JPanel();
	private JPanel pnlSouth = new JPanel();

	private JTextArea taQuestions = new JTextArea();
	private JScrollPane sp = new JScrollPane(taQuestions);	
	
	private Font font = new Font ("Garamond", Font.BOLD , 20);
	/*
	 * Konstruktorn ritar upp fönstret
	 */
	public FinalScreen(UI ui) {
		this.ui = ui;
		setPreferredSize(new Dimension(768, 768));
		pnlBackground.setPreferredSize(new Dimension(768, 768));
		lblBackground.setPreferredSize(new Dimension(768, 768));
		
		add(pnlBackground);
		pnlBackground.add(lblBackground);
		lblBackground.setLayout(new FlowLayout());
		pnlNorth.setPreferredSize(new Dimension(768, 150));
		pnlSouth.setPreferredSize(new Dimension(768, 500));
		lblHeadline.setPreferredSize(new Dimension(400, 50));
		lblPoints.setPreferredSize(new Dimension(200, 150));
		sp.setPreferredSize(new Dimension(400, 200));
		lblNewGame.setPreferredSize(new Dimension(700, 80));
		btnNewGame.setPreferredSize(new Dimension(400, 50));
		btnExit.setPreferredSize(new Dimension(400, 50));
		
		lblHeadline.setFont(font);
		lblPoints.setFont(font);
		
		taQuestions.setEditable(false);
		taQuestions.setOpaque(false);
		taQuestions.setWrapStyleWord(true);
		taQuestions.setLineWrap(true);

		
		pnlNorth.setOpaque(false);
		pnlSouth.setOpaque(false);
		
		lblBackground.add(pnlNorth);
		lblBackground.add(pnlSouth);
		
		pnlNorth.add(lblPoints);
		
		pnlSouth.add(lblHeadline);
		pnlSouth.add(sp);
		
		btnNewGame.setOpaque(false);
		btnNewGame.setContentAreaFilled(false);
		btnNewGame.setBorderPainted(false);
		btnNewGame.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/New_Game.png"))));
		
		btnExit.setOpaque(false);
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/Quit.png"))));
		
		pnlSouth.add(lblNewGame);
		pnlSouth.add(btnNewGame);
		pnlSouth.add(btnExit);
		
		addListeners();
	}
	
	public void setWrongAnswers(String e){
		taQuestions.setText(e);
	}
	
	/*
	 * Skriver ut poängen du har fått under spelets gång
	 */
	
	public void setTotalScore(String score){
		lblPoints.setText("Poäng: " + score);
	}
	
	/*
	 * Skriver ut frågorna du har svarat fel på
	 */
	public void addWrongAnswers(String txt) {
		taQuestions.setText(txt);
	}
	/*
	 * Lägger lyssnare till knapparna
	 */
	public void addListeners(){
		btnNewGame.addActionListener(new NewGameListener());
		btnExit.addActionListener(new ExitListener());
	}
	
	/*
	 * Lyssnare till knappen Nytt spel
	 */
	
	private class NewGameListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			ui.swap("IntroPanel");
		}
	}
	
	/*
	 * Lyssnare till knappen Avsluta
	 */
	
	private class ExitListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}
}
