package main;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Question {
	private String question, rightAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3;
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	
	public void setWrongAnswer(String wrongAnswer1, String wrongAnswer2, String wrongAnswer3) {
		this.wrongAnswer1 = wrongAnswer1;
		this.wrongAnswer2 = wrongAnswer2;
		this.wrongAnswer3 = wrongAnswer3;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public String getRightAnswer() {
		return rightAnswer;
	}
	
	public String getWrongAnswer1() {
		return wrongAnswer1;
	}
	
	public String getWrongAnswer2() {
		return wrongAnswer2;
	}
	
	public String getWrongAnswer3() {
		return wrongAnswer3;
	}
	
	public String toString() {
		return question +"\n"+ rightAnswer + "\n"+ wrongAnswer1 + "\n" +wrongAnswer2 +"\n" +wrongAnswer3;
	}
	
	public static void main(String[] args) {
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	String[] answers = {"Which of the following is not a Java keyword?", "Integer", "try", "static", "new"};
//	private String url = "jdbc:mysql://localhost:3306/qdb", user = "codequiz", password = "codequiz";
//	
//	public String[] getQuestion(){
//		
//
//		try {
//			Connection myConn = DriverManager.getConnection(url, user, password);
//			
//			Statement myStat = myConn.createStatement();
//			
//			ResultSet myRs = myStat.executeQuery("select * from frågor");
//			
//			while(myRs.next()) {
//				System.out.println(myRs.getString("QString") + "\n" +myRs.getString("CorrectAnswer") + "\n" + myRs.getString("WrongAnswer1")
//						+ "\n" + myRs.getString("WrongAnswer2") + "\n" + myRs.getString("WrongAnswer3"));
//			}
//			
//			
//			
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//		return answers;
//	}
//	
//	public String getRightAnswer(){
//		try {
//			
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		return answers[1];
//	}
//	
//	public static void main(String[] args) {
//		Question q = new Question();
//		q.getQuestion();
//
//	}
//	
	
}
