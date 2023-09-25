package com.exam.services;

import java.util.Set;

import com.exam.model.exam.Questions;
import com.exam.model.exam.Quiz;

public interface QuestionsService {
	
	Questions addQuestions(Questions ques);
	
	Questions updateQuestions(Questions ques);
	
	Set<Questions> getAllQuestion();
	
	Questions getQuestions(long quesId);
	
	Set<Questions> getQuestionOfQuiz(Quiz quiz);
	
	void deleteQuestion(long quesId);
	

}
