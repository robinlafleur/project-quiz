package main;

public class Question {
	String[] answers = new String[4];
	
	public Question(){
		answers[0] = "Right";
		answers[1] = "Wrong";
		answers[2] = "Wrong2";
		answers[3] = "Wrong3";
	}
	
	public String[] getQuestion(){
		return answers;
	}
	
	public String getRightAnswer(){
		return answers[0];
	}
}
