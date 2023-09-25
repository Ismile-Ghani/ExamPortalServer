package com.exam.services.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.exam.Questions;
import com.exam.model.exam.Quiz;
import com.exam.repository.QuestionRepository;
import com.exam.services.QuestionsService;

@Service
public class QuestionServiceImpl implements QuestionsService {
	
	@Autowired
	private QuestionRepository quesrepo;

	@Override
	public Questions addQuestions(Questions ques) {
		
		return this.quesrepo.save(ques);
	}

	@Override
	public Questions updateQuestions(Questions ques) {
		
		return this.quesrepo.save(ques);
	}

	@Override
	public Set<Questions> getAllQuestion() {
		
		return new LinkedHashSet<Questions>(this.quesrepo.findAll());
	}

	@Override
	public Questions getQuestions(long quesId) {
		
		return this.quesrepo.findById(quesId).get();
	}

	@Override
	public Set<Questions> getQuestionOfQuiz(Quiz quiz) {
		
		return new LinkedHashSet<Questions>(this.quesrepo.findByQuiz(quiz));
	}

	@Override
	public void deleteQuestion(long quesId) {
		this.quesrepo.deleteById(quesId);
		
	}

}
