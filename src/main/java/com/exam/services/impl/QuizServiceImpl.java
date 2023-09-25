package com.exam.services.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.exam.Quiz;
import com.exam.repository.QuizRepository;
import com.exam.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	
	@Autowired
	private QuizRepository quizrepo;
	
	@Override
	public Quiz addQuiz(Quiz quiz) {
		
		return this.quizrepo.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		
		return this.quizrepo.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizess() {
		
		return new LinkedHashSet<Quiz>(this.quizrepo.findAll());
	}

	@Override
	public Quiz getQuiz(long quizId) {
		
		return this.quizrepo.findById(quizId).get();
	}

	@Override
	public void deleteQuiz(long quizId) {
		this.quizrepo.deleteById(quizId);
		
	}
	

}
