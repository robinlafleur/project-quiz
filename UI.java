package main;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

/**
 * Klassen är en controllerklass som sköter logiken i programmet. 
 */

public class UI extends JPanel {
	private CardLayout cardLayout = new CardLayout();
	private JPanel pnlMain = new JPanel(cardLayout);

	private IntroPanel introPnl = new IntroPanel(this);
	private QuizScreen quizScreenPnl = new QuizScreen(this);
	private WinScreen winScreenPnl = new WinScreen(this);
	private FailScreen failScreenPnl = new FailScreen(this);
	private CategoryScreen categoryScreenPnl = new CategoryScreen(this);
	private EndScreen endScreenPnl = new EndScreen(this);
	private FinalScreen finalScreenPnl = new FinalScreen(this);
	private CreationScreen creationScreenPnl = new CreationScreen(this);
	private String imgFail, imgWin, storyFail, storyWin;
	
	private final int rounds = 3;
	
	private int newQ = 0, countGame = 0, gameScore = 0, totalScore = 0, totalRounds = 0, countCategorys = 0;
	private ArrayList<Question> failedAnswers = new ArrayList<Question>(); 
	
	private String query;
	private Sounds song = null;
	private Sounds click = null;

	public UI() {
		setPreferredSize(new Dimension(768, 768));

		pnlMain.add(introPnl, "IntroPanel");
		pnlMain.add(quizScreenPnl, "QuizScreen");
		pnlMain.add(winScreenPnl, "WinScreen");
		pnlMain.add(failScreenPnl, "FailScreen");
		pnlMain.add(categoryScreenPnl, "CategoryScreen");
		pnlMain.add(endScreenPnl, "EndScreen");
		pnlMain.add(finalScreenPnl, "FinalScreen");
		pnlMain.add(creationScreenPnl, "CreationScreen");

		add(pnlMain);
	}
	
	/**
	 *  Metoden byter till den panel som ska visas
	 */
	public void swap(String panel) {
		cardLayout.show(pnlMain, panel);
	}
	
	public void setQuery(String query) {
		this.query = query;
	}	
	
	/** Metoden omvandlar elementen i failedAnswers till en sträng
	 * som sedan används i FinalScreen
	 */
	private String getWrongAnswers() {
		String msg = "Du hade inga fel! ";
		if(failedAnswers.size() > 0){
			msg = "";
			for(int i=0; i<failedAnswers.size(); i++){
				msg += "\n";
				msg += "Fråga: " + failedAnswers.get(i).getQuestion() + "\n";
				msg += "Rätt svar: " + failedAnswers.get(i).getRightAnswer() + "\n";
				msg += "\n";
			}
		}
		return msg;
	}
	
	/**
	 * Metoden sköter en stor del av logiken i programmet.
	 * Här hämtas frågor och svar som ska visas ur en lista och 
	 * skickar dessa till respektive knappar och etiketter.
	 * Den kontrollerar även hur länge en spelomgång ska köras  
	 */
	public void newQuestion() {
		quizScreenPnl.removeListeners();
		setContinue();
		QuestionList questionList = new QuestionList(query);
		enableLastCategory();
		
		if (countGame < rounds) {
			int[] sA = shuffleAnswers();

			int[] wAnswers = { sA[1], sA[2], sA[3] };
			String[] answers = {
					questionList.getQuestion(newQ).getWrongAnswer1(),
					questionList.getQuestion(newQ).getWrongAnswer2(),
					questionList.getQuestion(newQ).getWrongAnswer3() };

			failScreenPnl.setRightAnswer(questionList.getQuestion(newQ)
					.getRightAnswer());
			quizScreenPnl.setQuestion(questionList.getQuestion(newQ)
					.getQuestion());
			quizScreenPnl.setRightAnswer(sA[0], questionList.getQuestion(newQ)
					.getRightAnswer());
			quizScreenPnl.setWrongAnswers(wAnswers, answers);
			quizScreenPnl.setFailedQuestion(questionList.getQuestion(newQ));

			newQ++;
			countGame++;
			totalRounds++;
		} else {
			if(totalRounds < 30){
				setEndBackground();
				endScreenPnl.setScore(Integer.toString(gameScore) + " / " + (rounds * 8));
				swap("EndScreen");
			}else{
				finalScreenPnl.setTotalScore(Integer.toString(totalScore) + " / " + (totalRounds * 8));
				finalScreenPnl.addWrongAnswers(getWrongAnswers());
				swap("FinalScreen");
			}
		}

	}
	
	/**
	 * Metoden används privat i newQuestion metoden.
	 * Med hjälp av metoden så kan frågornas position 
	 * på knapparna se slumpartade ut
	 */
	private int[] shuffleAnswers() {
		Random ran = new Random();
		int random = ran.nextInt(4);
		int[] shuffledAnswers = new int[4];

		if (random == 0) {
			for (int i = 0; i < shuffledAnswers.length; i++) {
				shuffledAnswers[i] = i;
			}
		} else if (random == 1) {
			shuffledAnswers[0] = 1;
			shuffledAnswers[1] = 0;
			shuffledAnswers[2] = 2;
			shuffledAnswers[3] = 3;

		} else if (random == 2) {
			shuffledAnswers[0] = 2;
			shuffledAnswers[1] = 3;
			shuffledAnswers[2] = 0;
			shuffledAnswers[3] = 1;

		} else if (random == 3) {
			shuffledAnswers[0] = 2;
			shuffledAnswers[1] = 1;
			shuffledAnswers[2] = 3;
			shuffledAnswers[3] = 0;

		}

		return shuffledAnswers;
	}
	
	/**
	 * Metoden lägger till ett Question-objekt i en lista
	 */
	public void addFailedQuestion(Question q) {
		failedAnswers.add(q);
	}
	
	/**
	 * Metoden kontrollerar om den ska ändra utseendet på
	 * två knappar i programmet
	 */
	private void setContinue(){
		if(countGame+1 == rounds){
			failScreenPnl.setContinue("Se poäng");
			winScreenPnl.setContinue("Se poäng");
		}
	}
	
	/**
	 * Metoden lägger till poäng som ska visas i programmet
	 */
	public void addGameScore(){
		gameScore += 8;
		totalScore += 8;
	}
	
	/**
	 * Metoden spelar upp en klickljud med hjälp av ett Sounds-objekt
	 */
	public void playClickSound(){
		if(click == null){
			click = new Sounds("click.wav");
			click.startSound();
		}else{
			click.stopSound();
			click.startSound();
		}
	}
	
	/**
	 * Metoden spelar upp en sång med hjälp av ett Sounds-objekt
	 */
	public void playSong(){
		if(song == null){
			song = new Sounds("maincodequiz.wav");
			song.loopSound();
		}
	}
	
	/**
	 * Metoden återställer de värden som behövs för att 
	 * starta ett nytt spel
	 */
	public void newGame(){
		newQ = 0;
		countGame = 0;
		gameScore = 0;
		totalScore = 0;
		totalRounds = 0;
		countCategorys = 0;
		failedAnswers = new ArrayList<Question>();
		failScreenPnl.setContinue("Nästa fråga");
		winScreenPnl.setContinue("Nästa fråga");
		categoryScreenPnl.enableCategorys();
	}
	
	/**
	 * Metoden återställer de värden som behövs för att
	 * starta en ny kategori
	 */
	public void newCategory(){
		newQ = 0;
		countGame = 0;
		gameScore = 0;
		failScreenPnl.setContinue("Nästa fråga");
		winScreenPnl.setContinue("Nästa fråga");
	}
	
	/**
	 * Metoden ändrar bakgrundstemat i spelet beroende på
	 * vald kategori
	 */
	public void setThemeBackground(String img1, String imgFail, String imgWin) {
		this.imgFail = imgFail;
		this.imgWin = imgWin;
		quizScreenPnl.setThemeBackground(img1);
		failScreenPnl.setThemeBackground(img1);
		winScreenPnl.setThemeBackground(img1);
	}
	
	/**
	 * Metoden ändrar händelsetext i spelet beroende på
	 * vald kategori
	 */
	public void setStory(String story, String storyFail, String storyWin){
		this.storyFail = storyFail;
		this.storyWin = storyWin;
		quizScreenPnl.setStory(story);
	}
	
	/**
	 * Metoden ser till så att bakgrund och händelsetext ändras
	 * beroende på de poäng som användaren lyckats skrapa ihop
	 */
	public void setEndBackground() {
		if(countGame == 3 && gameScore >= 16) {
			endScreenPnl.setEndBackground(imgWin);
			endScreenPnl.setStory(storyWin);
		}else if(countGame == 3 && gameScore < 16) {
			endScreenPnl.setStory(storyFail);
			endScreenPnl.setEndBackground(imgFail);
		}
	}
	
	/**
	 * Metoden adderar countCategorys med 1
	 */
	public void addCountCategorys(){
		countCategorys++;
	}
	
	/**
	 * Metoden kollar om den sista kategorin ska vara 
	 * spelbar beroende på countCategorys
	 */
	public boolean enableLastCategory() {
		if(countCategorys == 9) {
			
			return true;
		}
		return false;
	}
	
	/**
	 * Kontrollerar om fälten är korrekt ifyllda och skickar
	 * frågan till databasen om så är fallet. 
	 * @param category Kategorin.
	 * @param qString Själva frågan.
	 * @param correctAnswer Rätt svar.
	 * @param wrongAnswer1 Fel svar 1.
	 * @param wrongAnswer2 Fel svar 2.
	 * @param wrongAnswer3 Fel svar 3.
	 */
	public void addQuestionToDB(String category, String qString,
			String correctAnswer, String wrongAnswer1, String wrongAnswer2,	String wrongAnswer3) {
			boolean ok = true;
			if(category.isEmpty() || qString.isEmpty() || correctAnswer.isEmpty() || wrongAnswer1.isEmpty() || wrongAnswer2.isEmpty() || wrongAnswer3.isEmpty()){
				JOptionPane.showMessageDialog(null, "Var god fyll i alla fält.");
				ok = false;
			} else if(category.length() > 200 || qString.length() > 200 || correctAnswer.length() > 200 || wrongAnswer1.length() > 200 || wrongAnswer2.length() > 200 || wrongAnswer3.length() > 200){
				JOptionPane.showMessageDialog(null, "Vad god använd inte mer än 200 tecken per fält.");
				ok = false;
			}
		if(ok){
			try {
				Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qdb", "root", "");
				Statement myStat = myConn.createStatement();
				String temp = "insert into "
						+ category
						+ "(QString, CorrectAnswer, WrongAnswer1, WrongAnswer2, WrongAnswer3) values('"
						+ qString + "', '" + correctAnswer + "', '" + wrongAnswer1
						+ "', '" + wrongAnswer2 + "', '" + wrongAnswer3 + "')";
				System.out.println(temp);
				myStat.executeUpdate(temp);
				ResultSet set = myStat
						.executeQuery("select * from " + category);
				while (set.next()) {
					System.out.println(set.getString("QString") + " " + set.getString("CorrectAnswer"));
				}

			} catch (com.mysql.jdbc.exceptions.jdbc4.CommunicationsException e) {
				JOptionPane.showMessageDialog(null, "Kunde ej koppla upp till databasen.\nVar säker på att databasen är startad.");
			} catch (Exception e2){
				JOptionPane.showMessageDialog(null, e2.getMessage());
			}
			
			JOptionPane.showMessageDialog(null, "Lyckades lägga till frågan i " + category + ".");
			swap("IntroPanel");
		}
	}
}
