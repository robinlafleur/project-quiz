package main;

public class Question {
	String[] answers = {"Which of the following is not a Java keyword?", "Integer", "try", "static", "new"};
	
	public String[] getQuestion(){
		return answers;
	}
	
	public String getRightAnswer(){
		return answers[1];
	}
}
