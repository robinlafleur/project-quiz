package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
/**
 * Är en panel som tillåter skapandet av frågor.
 * @author Niklas Larsson Hultgren
 */
public class CreationScreen extends JPanel {
	private UI ui;
	private ImageIcon background = new ImageIcon(Toolkit.getDefaultToolkit()
			.getImage(getClass().getResource("/main/Images/New_Game_Screen.png")));
	private JPanel pnlBackground = new JPanel();
	private JLabel lblBackground = new JLabel(background);
	private JPanel pnlNorth = new JPanel();
	private JPanel pnlCenter = new JPanel();
	private JPanel pnlSouth = new JPanel();
	private JComboBox<String> combo = new JComboBox<String>();
	private JButton[] buttons = new JButton[2];
	private JTextField[] texts = new JTextField[5];
	private JLabel[] textLabels = new JLabel[5];
	private Dimension btnSize = new Dimension(200, 50);
	private Dimension btnSize2 = new Dimension(400, 50);

	private final String[] categories = { "Kodstrukturering", "Datatyper",
			"Metoder", "Loopar", "UI", "Arrays", "Exceptions", "Polymorfism",
			"Inkapsling", "Trådar" };
	private final int panelSizeUnit = 192;

	public CreationScreen(UI ui) {
		this.ui = ui;
		setPreferredSize(new Dimension(768, 768));
		pnlBackground.setPreferredSize(new Dimension(768, 768));
		lblBackground.setPreferredSize(new Dimension(768, 768));

		add(pnlBackground);
		pnlBackground.add(lblBackground);
		lblBackground.setLayout(new FlowLayout());
		pnlNorth.setOpaque(false);
		pnlCenter.setOpaque(false);
		pnlCenter.setLayout(new GridLayout(10, 1));
		pnlSouth.setOpaque(false);

		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setOpaque(false);

			buttons[i].setOpaque(false);
			buttons[i].setContentAreaFilled(false);
			buttons[i].setBorderPainted(false);
			pnlSouth.add(buttons[i]);
		}

		for (int i = 0; i < categories.length; i++) {
			combo.addItem(categories[i]);
		}

		textLabels[0] = new JLabel("Kategori");
		textLabels[1] = new JLabel("Frågetext");
		textLabels[2] = new JLabel("Rätt svar");
		textLabels[3] = new JLabel("Felaktiga svar");

		for (int i = 0; i < texts.length; i++) {
			texts[i] = new JTextField();
			texts[i].setPreferredSize(btnSize);
		}

		pnlCenter.add(textLabels[0]); // "Kategori"
		pnlCenter.add(combo); // Välj kategori
		pnlCenter.add(textLabels[1]); // "Frågetext"
		pnlCenter.add(texts[0]); // Skriv in frågetext
		pnlCenter.add(textLabels[2]); // "Rätt svar"
		pnlCenter.add(texts[1]); // Skriv in rätt svar
		pnlCenter.add(textLabels[3]); // "Felaktiga svar"
		pnlCenter.add(texts[2]); // Felsvar 1
		pnlCenter.add(texts[3]); // Felsvar 2
		pnlCenter.add(texts[4]); // Felsvar 3

		buttons[0].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("/main/Images/Ok.png"))));
		buttons[1].setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("/main/Images/Back.png"))));

		buttons[0].setPreferredSize(btnSize2);
		buttons[1].setPreferredSize(btnSize);

		addListeners();

		pnlNorth.setPreferredSize(new Dimension(768, panelSizeUnit));
		pnlCenter.setPreferredSize(new Dimension(600, panelSizeUnit + 90));
		pnlSouth.setPreferredSize(new Dimension(300, panelSizeUnit * 2));

		lblBackground.add(pnlNorth);
		lblBackground.add(pnlCenter);
		lblBackground.add(pnlSouth);
	}
	
	/**
	 * Lägger till lyssnare så att knapparna fungerar.
	 */
	public void addListeners() {
		buttons[0].addActionListener(new OkListener());
		buttons[1].addActionListener(new ExitListener());
	}
	
	/**
	 * Lyssnare för OK-knappen.
	 */
	private class OkListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ui.addQuestionToDB((String) combo.getSelectedItem(),
					texts[0].getText(), texts[1].getText(), texts[2].getText(),
					texts[3].getText(), texts[4].getText());
			for (JTextField tf : texts) {
				tf.setText("");
			}
		}
	}
	
	/**
	* Lyssnare för Tillbaka-knappen. 
	*/ 
	private class ExitListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			ui.swap("IntroPanel");
		}
	}
}