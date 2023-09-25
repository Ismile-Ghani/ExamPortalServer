package com.exam.services;

import java.util.Set;

import com.exam.model.exam.Quiz;

public interface QuizService {
	
	Quiz addQuiz(Quiz quiz);
	
	Quiz updateQuiz(Quiz quiz);
	
	Set<Quiz> getQuizess();
	
	Quiz getQuiz(long quizId);
	
	void deleteQuiz(long quizId);
	
	

}
