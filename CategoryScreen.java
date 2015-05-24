package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Klassen till skärmen där man väljer spelkategori.
 */

public class CategoryScreen extends JPanel {
	private UI ui;
	private ImageIcon background = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/Category_Screen.png")));
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
	
	/**
	 * Konstruktorn ritar upp kategoriskärmen.
	 */

	public CategoryScreen(UI ui) {
		this.ui = ui;
		category10.setEnabled(ui.enableLastCategory());
		pnlBackground.setPreferredSize(new Dimension(1000, 1000));
		
		add(pnlBackground);
		pnlBackground.add(lblBackground);
		lblBackground.setLayout(new FlowLayout());
		
		pnlNorth.setPreferredSize(new Dimension(1000, 100)); //Panel till "välj en kategori"
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
		
		category1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/Kodstrukturering_Category_1.png"))));
		category1.setOpaque(false);
		category1.setContentAreaFilled(false);
		category1.setBorderPainted(false);
		
		category2.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/Datatyper_Category_2.png"))));
		category2.setOpaque(false);
		category2.setContentAreaFilled(false);
		category2.setBorderPainted(false);
		
		category3.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/metoder_Category_3.png"))));
		category3.setOpaque(false);
		category3.setContentAreaFilled(false);
		category3.setBorderPainted(false);
		
		category4.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/Loopar_Category_4.png"))));
		category4.setOpaque(false);
		category4.setContentAreaFilled(false);
		category4.setBorderPainted(false);
		
		category5.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/User_Interface_Category_5.png"))));
		category5.setOpaque(false);
		category5.setContentAreaFilled(false);
		category5.setBorderPainted(false);
		
		category6.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/Arrays_Category_6.png"))));
		category6.setOpaque(false);
		category6.setContentAreaFilled(false);
		category6.setBorderPainted(false);
		
		category7.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/Exceptions_Category_7.png"))));
		category7.setOpaque(false);
		category7.setContentAreaFilled(false);
		category7.setBorderPainted(false);
		
		category8.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/Polymorfism_Category_8.png"))));
		category8.setOpaque(false);
		category8.setContentAreaFilled(false);
		category8.setBorderPainted(false);
		
		category9.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/Inkapsling_Category_9.png"))));
		category9.setOpaque(false);
		category9.setContentAreaFilled(false);
		category9.setBorderPainted(false);
		
		category10.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/Threads_Category_10.png"))));
		category10.setOpaque(false);
		category10.setContentAreaFilled(false);
		category10.setBorderPainted(false);
		
		btnBack.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/main/Images/Back.png"))));
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
	
	/**
	 * Metod som gör alla kategoriknappar utom sista klickbar.
	 */
	public void enableCategorys(){
		category1.setEnabled(true);
		category2.setEnabled(true);
		category3.setEnabled(true);
		category3.setEnabled(true);
		category4.setEnabled(true);
		category5.setEnabled(true);
		category6.setEnabled(true);
		category7.setEnabled(true);
		category8.setEnabled(true);
		category9.setEnabled(true);
		category10.setEnabled(false);
	}
	
	/**
	 * Lägger till lyssnare till kategoriknapparna.
	 */
	public void addListeners(){
		category1.addActionListener(new CategoryListener1());
		category2.addActionListener(new CategoryListener2());
		category3.addActionListener(new CategoryListener3());
		category4.addActionListener(new CategoryListener4());
		category5.addActionListener(new CategoryListener5());
		category6.addActionListener(new CategoryListener6());
		category7.addActionListener(new CategoryListener7());
		category8.addActionListener(new CategoryListener8());
		category9.addActionListener(new CategoryListener9());
		category10.addActionListener(new CategoryListener10());
		btnBack.addActionListener(new BackListener());
	}
	
	/*
	 * Nedan är lyssnare till de olika kategoriknapparna.
	 * Så att programmet vet vilken tabell i databasen frågor ska tas från,
	 * sätter tema, dimmar knappen bland annat. Där är liknande funktioner
	 * till övriga kategorier.
	 */
	
	/**
	 * Lyssnare till första kategoriknappen
	 */
	private class CategoryListener1 implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			ui.playClickSound();
			ui.setQuery("select * from kodstrukturering");
			ui.newQuestion();
			ui.setThemeBackground("Handelse_1_Start.png", "Handelse_1_Bad.png", "Handelse_1_Victory.png");
			ui.swap("QuizScreen");
			category1.setEnabled(false);
			ui.addCountCategorys();
			category10.setEnabled(ui.enableLastCategory());
		}
	}
	
	/**
	 * Lyssnare till andra kategoriknappen
	 */
	private class CategoryListener2 implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			ui.playClickSound();
			ui.setQuery("select * from datatyper");
			ui.newQuestion();
			ui.setThemeBackground("Handelse_2_start.jpg", "Handelse_2_Bad.jpg", "Handelse_2_Victory.jpg");
			ui.swap("QuizScreen");
			category2.setEnabled(false);
			ui.addCountCategorys();
			category10.setEnabled(ui.enableLastCategory());
		}
	}
	
	/**
	 * Lyssnare till tredje kategoriknappen
	 */
	private class CategoryListener3 implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			ui.playClickSound();
			ui.setQuery("select * from metoder");
			ui.newQuestion();
			ui.setThemeBackground("Handelse_3_Start.png", "Handelse_3_Bad.png", "Handelse_3_Victory.png");
			ui.swap("QuizScreen");
			category3.setEnabled(false);
			ui.addCountCategorys();
			category10.setEnabled(ui.enableLastCategory());
		}
	}
	
	/**
	 * Lyssnare till fjärde kategoriknappen
	 */
	private class CategoryListener4 implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			ui.playClickSound();
			ui.setQuery("select * from loopar");
			ui.newQuestion();
			ui.setThemeBackground("handelse_4_start.png", "Handelse_4_Bad.png", "Handelse_4_Victory.png");
			ui.swap("QuizScreen");
			category4.setEnabled(false);
			ui.addCountCategorys();
			category10.setEnabled(ui.enableLastCategory());
		}
	}
	
	/**
	 * Lyssnare till femte kategoriknappen
	 */
	private class CategoryListener5 implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			ui.playClickSound();
			ui.setQuery("select * from ui");
			ui.newQuestion();
			ui.setThemeBackground("Handelse_5_Start.png", "Handelse_5_Bad.png", "Handelse_5_Victory.png");
			ui.swap("QuizScreen");
			category5.setEnabled(false);
			ui.addCountCategorys();
			category10.setEnabled(ui.enableLastCategory());
		}
	}
	
	/**
	 * Lyssnare till sjätte kategoriknappen
	 */
	private class CategoryListener6 implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			ui.playClickSound();
			ui.setQuery("select * from arrays");
			ui.newQuestion();
			ui.setThemeBackground("Handelse_6_Start.png", "Handelse_6_Bad.png", "Handelse_6_Victory.png");
			ui.swap("QuizScreen");
			category6.setEnabled(false);
			ui.addCountCategorys();
			category10.setEnabled(ui.enableLastCategory());
		}
	}
	/**
	 * Lyssnare till sjunde kategoriknappen
	 */
	private class CategoryListener7 implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			ui.playClickSound();
			ui.setQuery("select * from exceptions");
			ui.newQuestion();
			ui.setThemeBackground("Handelse_7_Start.png", "Handelse_7_Bad.png", "Handelse_7_Victory.png");
			ui.swap("QuizScreen");
			category7.setEnabled(false);
			ui.addCountCategorys();
			category10.setEnabled(ui.enableLastCategory());
		}
	}
	
	/**
	 * Lyssnare till åttonde kategoriknappen
	 */
	private class CategoryListener8 implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			ui.playClickSound();
			ui.setQuery("select * from polymorfism");
			ui.newQuestion();
			ui.setThemeBackground("Handelse_8_Start.png", "Handelse_8_Bad.png", "Handelse_8_Victory.png");
			ui.swap("QuizScreen");
			category8.setEnabled(false);
			ui.addCountCategorys();
			category10.setEnabled(ui.enableLastCategory());
		}
	}
	
	/**
	 * Lyssnare till nionde kategoriknappen
	 */
	private class CategoryListener9 implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			ui.playClickSound();
			ui.setQuery("select * from inkapsling");
			ui.newQuestion();
			ui.setThemeBackground("Handelse_9_start.png", "Handelse_9_Bad.png", "Handelse_9_Victory.png");
			ui.swap("QuizScreen");
			category9.setEnabled(false);
			ui.addCountCategorys();
			category10.setEnabled(ui.enableLastCategory());
		}
	}
	
	/**
	 * Lyssnare till tioende kategoriknappen
	 */
	private class CategoryListener10 implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			ui.playClickSound();
			ui.setQuery("select * from trådar");
			ui.newQuestion();
			ui.setThemeBackground("Handelse_10_start.png", "Handelse_10_bad.png", "handelse_10_victory.png");
			ui.swap("QuizScreen");
		}
	}
	
	/**
	 * Lyssnare till tillbaka-knappen
	 */
	private class BackListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			ui.playClickSound();
			ui.swap("IntroPanel");
		}
	}
}
