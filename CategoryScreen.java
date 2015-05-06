package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CategoryScreen extends JPanel {
	private UI ui;
	private ImageIcon background = new ImageIcon("C:/Quizbilder/Bakgrund1.png");
	private JPanel pnlBackground = new JPanel();
	private JLabel lblBackground = new JLabel(background);
	
	private JPanel pnlNorth = new JPanel();
	private JLabel lblNorth = new JLabel("VÄLJ EN KATEGORI: ");
	
	private JPanel pnlCenter = new JPanel();
	private JPanel pnlSouth = new JPanel();
	
	private JButton button1 = new JButton("KATEGORI 1");
	private JButton button2 = new JButton("KATEGORI 2");
	private JButton button3 = new JButton("KATEGORI 3");
	private JButton button4 = new JButton("KATEGORI 4");
	private JButton btnBack = new JButton("TILLBAKA");
	
	private Dimension btnSize = new Dimension(1000, 100);
	
	public CategoryScreen(UI ui) {
		this.ui = ui;
		pnlBackground.setPreferredSize(new Dimension(1000, 1000));
		
		add(pnlBackground);
		pnlBackground.add(lblBackground);
		lblBackground.setLayout(new FlowLayout());
		
		pnlNorth.setPreferredSize(new Dimension(1000, 200));
		pnlNorth.setOpaque(false);
		lblBackground.add(pnlNorth);
		pnlNorth.add(lblNorth);
		
		pnlCenter.setSize(new Dimension(1000, 500));
		pnlCenter.setOpaque(false);
		lblBackground.add(pnlCenter);
		button1.setSize(btnSize);
		button2.setSize(btnSize);
		button3.setSize(btnSize);
		button4.setSize(btnSize);
		btnBack.setSize(btnSize);
		
		addListeners();
		
		pnlCenter.add(button1);
		pnlCenter.add(button2);
		pnlCenter.add(button3);
		pnlCenter.add(button4);
		pnlCenter.add(btnBack);
	}
	
	public void addListeners(){
		button1.addActionListener(new CategoryListener());
		btnBack.addActionListener(new BackListener());
	}
	
	private class CategoryListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			ui.swap("QuizScreen");
			
		}
	}
	
	private class BackListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			ui.swap("IntroPanel");
			
		}
	}

}
