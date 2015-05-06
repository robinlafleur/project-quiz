package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class QuizScreen extends JPanel {
	private ImageIcon background = new ImageIcon("C:/Skolan/Systemutveckling/Projekt/bild/Bakgrund1.png");
	private JLabel lblQuestion = new JLabel("Fråga: Hur många bultar finns det i Ölandsbron?");
	private JPanel pnlBackground = new JPanel();
	private JLabel lblBackground = new JLabel(background);
	private JPanel pnlNorth = new JPanel();
	private JPanel pnlCenter = new JPanel();
	private JPanel pnlSouth = new JPanel();
	private JRadioButton btn1 = new JRadioButton("Alternativ 1");
	private JRadioButton btn2 = new JRadioButton("Alternativ 2");
	private JRadioButton btn3 = new JRadioButton("Alternativ 3");
	private JRadioButton btn4 = new JRadioButton("Alternativ 4");
	private JRadioButton btn5 = new JRadioButton("Alternativ 5");
	private Dimension btnSize = new Dimension(1000, 20);
	
	private JButton button = new JButton("TRYCK PÅ MIG");
	
	
	public QuizScreen() {
		setPreferredSize(new Dimension(1000, 1000));
		pnlBackground.setPreferredSize(new Dimension(1000, 1000));
		lblBackground.setPreferredSize(new Dimension(1000, 1000));
		
		add(pnlBackground);
		pnlBackground.add(lblBackground);
		lblBackground.setLayout(new FlowLayout());
		pnlNorth.setOpaque(false);
		pnlCenter.setOpaque(false);
		pnlSouth.setOpaque(false);
		
		btn1.setOpaque(false);
		btn2.setOpaque(false);
		btn3.setOpaque(false);
		btn4.setOpaque(false);
		btn5.setOpaque(false);
		
		btn1.setPreferredSize(btnSize);
		btn2.setPreferredSize(btnSize);
		btn3.setPreferredSize(btnSize);
		btn4.setPreferredSize(btnSize);
		btn5.setPreferredSize(btnSize);	
		
		
		pnlNorth.setPreferredSize(new Dimension(1000, 200));
		pnlCenter.setPreferredSize(new Dimension(1000, 600));
		pnlSouth.setPreferredSize(new Dimension(600, 50));
		
		lblBackground.add(pnlNorth);
		lblBackground.add(pnlCenter);
		lblBackground.add(pnlSouth);
		
		
		pnlNorth.add(lblQuestion);
		
		pnlCenter.add(btn1);
		pnlCenter.add(btn2);
		pnlCenter.add(btn3);
		pnlCenter.add(btn4);
		pnlCenter.add(btn5);
		pnlCenter.add(button);
		
		
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("QUIZ");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add( new QuizScreen() );
		frame.pack();
		frame.setVisible(true);
	}
	
	}

