package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class QuestionList {
	private UI ui;
	private String url = "jdbc:mysql://localhost:3306/qdb", user = "codequiz", password = "codequiz";
	private ArrayList<Question> questions = new ArrayList<Question>();
	private int randInt;
	
	public Question getQuestion() {
		ArrayList<Question> al = (ArrayList<Question>)questions.clone();
		Question q = al.get(0);		
//		questions.remove(randInt);
		return q;
	}
	
	public void randomInt(int randInt) {
		this.randInt = randInt;
	}
	
	public void removeQuestion() {
		questions.remove(0);
	}

	
	public void questionList() {

		try {
			Connection myConn = DriverManager.getConnection(url, user, password);
			
			Statement myStat = myConn.createStatement();
			
			ResultSet myRs = myStat.executeQuery("select * from frågor");
			
			while(myRs.next()) {
				Question q = new Question();
				q.setQuestion(myRs.getString("QString"));
				q.setRightAnswer(myRs.getString("CorrectAnswer"));
				q.setWrongAnswer(myRs.getString("WrongAnswer1"), myRs.getString("WrongAnswer2"), myRs.getString("WrongAnswer3"));
				questions.add(0, q);
				Question q2 = new Question();
				q2.setQuestion("Namn?");
				q2.setRightAnswer("Rätt namn");
				q2.setWrongAnswer("Fel1", "Fel2", "Fel3");
				questions.add(1, q2);

			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
//		for(Question q : questions ) {
//			System.out.print(q);
//		}
		
//		System.out.println(questions.get(0));
//		System.out.print(questions.get(1));
		
	}
	
	public static void main(String[] args) {
		QuestionList q = new QuestionList();
//		q.getQuestion(0);
		q.questionList();
	}
	
}


