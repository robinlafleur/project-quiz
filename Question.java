package main;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Klassen används får att hantera frågor och svar
 */
public class Question {
	private String question, rightAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3;
	
	/**
	 * Metoden sätter frågan
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	
	/**
	 * Metod sätter rätt svar
	 */
	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	
	/**
	 * Metod som sätter fel svar
	 */
	public void setWrongAnswer(String wrongAnswer1, String wrongAnswer2, String wrongAnswer3) {
		this.wrongAnswer1 = wrongAnswer1;
		this.wrongAnswer2 = wrongAnswer2;
		this.wrongAnswer3 = wrongAnswer3;
	}
	
	/**
	 * Returnerar frågan
	 */
	public String getQuestion() {
		return question;
	}
	
	/**
	 * Returnerar rätt svar
	 */
	public String getRightAnswer() {
		return rightAnswer;
	}
	
	/**
	 * Returnerar ett felaktigt svar
	 */
	public String getWrongAnswer1() {
		return wrongAnswer1;
	}
	
	/**
	 * Returnerar ett felaktigt svar
	 */
	public String getWrongAnswer2() {
		return wrongAnswer2;
	}
	
	/**
	 * Returnerar ett felaktigt svar
	 */
	public String getWrongAnswer3() {
		return wrongAnswer3;
	}
	
	/**
	 * Returnerar frågan med tillhörande svarsalternativ som en sträng.
	 */
	public String toString() {
		return question +"\n"+ rightAnswer + "\n"+ wrongAnswer1 + "\n" +wrongAnswer2 +"\n" +wrongAnswer3;
	}
}
