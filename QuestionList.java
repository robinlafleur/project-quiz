package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * Klassen hämtar frågor från databasen och placerar dem i en arraylist.
 */
public class QuestionList {
	private String url = "jdbc:mysql://localhost:3306/qdb", user = "codequiz", password = "codequiz";
	private String query;
	private ArrayList<Question> questions = new ArrayList<Question>();

	/**
	 * Returnerar en fråga ur arraylisten
	 */
	public Question getQuestion(int num) {
		Question q = questions.get(num);
		return q;
	}
	
	/**
	 * Tar bort en fråga ur arraylisten
	 */
	public void removeQuestion(int num) {
		questions.remove(num);
	}
	
	/**
	 * Returnerar storlek på arraylist
	 */
	public int getSize(){
		return questions.size();
	}
	
	/**
	 * Sätter query till den tabell i databasen som frågorna ska hämtas ur
	 */
	public QuestionList(String query){
		this.query = query;
		addQuestion();
	}
	
	/**
	 * Metoden kopplar till databasen, hämtar frågor och sparar dom i en arraylist
	 */
	public void addQuestion() {
		try {
			Random rand = new Random();
			int random = rand.nextInt(5)+1;
			Connection myConn = DriverManager.getConnection(url, user, password);
			Statement myStat = myConn.createStatement();
			ResultSet myRs = myStat.executeQuery(query + " order by rand()");
			
			while(myRs.next()) {
				Question q = new Question();
				
				q.setQuestion(myRs.getString("QString"));
				q.setRightAnswer(myRs.getString("CorrectAnswer"));

				q.setWrongAnswer(myRs.getString("WrongAnswer1"), myRs.getString("WrongAnswer2"), myRs.getString("WrongAnswer3"));
				questions.add(q);

				
			}
		} catch (com.mysql.jdbc.exceptions.jdbc4.CommunicationsException e) {
			JOptionPane.showMessageDialog(null, "Kunde ej koppla upp till databasen.\nVar säker på att databasen är startad.");
		} catch (Exception e2){
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}
}