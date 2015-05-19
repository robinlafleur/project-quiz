package main;

import java.util.Random;
private String[] answers = new String[5];
private String question, rAnswer, wAnswer1, wAnswer2, wAnswer3;
private QuestionList list = new QuestionList();
private Question q;
public class bajs {

}


public void answers() {
	list.questionList();
	Random rand = new Random();
	int randInt = rand.nextInt(3)+1;
	q = list.getQuestion(0);
//	String question = q.toString();
//	String[] answers = new String[5];
	question = q.getQuestion();
	rAnswer = q.getRightAnswer();
	wAnswer1 = q.getWrongAnswer1();
	wAnswer2 = q.getWrongAnswer2();
	wAnswer3 = q.getWrongAnswer3();
	answers[0] = question;
	answers[1] = rAnswer;
	answers[2] = wAnswer1;
	answers[3] = wAnswer2;
	answers[4] = wAnswer3;
	for(int i = 0; i < answers.length; i++) {
		System.out.println(answers[i]);
	}	
}


public String getQuestion(){
//	answers();
	this.question = question;
	return question;
}

public String[] shuffleAnswers(){
//	answers();

	Random ran = new Random();
//	Question q = new Question();
//	String[] answers = new String[5];
	//q = list.getQuestion(0);
//	System.out.println(list.getQuestion(0).getQuestion());
//	answers[0] = q.getQuestion();
//	answers[1] = q.getRightAnswer();
//	answers[2] = q.getWrongAnswer1();
//	answers[3] = q.getWrongAnswer2();
//	answers[4] = q.getWrongAnswer3();
			
	
	String[] shuffledAnswers = new String[4];
	
	int randomInt = ran.nextInt(4)+1;
	
	if(randomInt == 1){
		shuffledAnswers[0] = rAnswer;
		shuffledAnswers[1] = wAnswer1;
		shuffledAnswers[2] = wAnswer2;
		shuffledAnswers[3] = wAnswer3;
		rightAnswer = 0;
	}
	else if(randomInt == 2){
		shuffledAnswers[0] = wAnswer2;
		shuffledAnswers[1] = rAnswer;
		shuffledAnswers[2] = wAnswer1;
		shuffledAnswers[3] = wAnswer3;
		rightAnswer = 1;
	}
	else if(randomInt == 3){
		shuffledAnswers[0] = wAnswer3;
		shuffledAnswers[1] = wAnswer2;
		shuffledAnswers[2] = rAnswer;
		shuffledAnswers[3] = wAnswer1;
		rightAnswer = 2;
	}
	else if(randomInt == 4){
		shuffledAnswers[0] = wAnswer2;
		shuffledAnswers[1] = wAnswer3;
		shuffledAnswers[2] = wAnswer1;
		shuffledAnswers[3] = rAnswer;
		rightAnswer = 3;
	}
	
	return shuffledAnswers;
}
