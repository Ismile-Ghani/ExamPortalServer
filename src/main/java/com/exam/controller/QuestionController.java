package com.exam.controller;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.exam.Questions;
import com.exam.model.exam.Quiz;
import com.exam.services.QuestionsService;
import com.exam.services.QuizService;

@RestController
@RequestMapping("/question")
@CrossOrigin
public class QuestionController {
	
	@Autowired
	private QuestionsService quesService;
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public ResponseEntity<?> addQuestion(@RequestBody Questions ques) {
		return ResponseEntity.ok(this.quesService.addQuestions(ques));
	}
	
	
	@GetMapping("/{qId}")
	public ResponseEntity<?> getQuestion(@PathVariable("qId") long qId) {
		return ResponseEntity.ok(this.quesService.getQuestions(qId));
	}
	
	
	@GetMapping("/")
	public ResponseEntity<?> getAllQuestions() {
		return ResponseEntity.ok( new LinkedHashSet(this.quesService.getAllQuestion()));
	}
	
	
	
	@PutMapping("/")
	public ResponseEntity<?> updateQuestions(@RequestBody Questions ques){
		return ResponseEntity.ok(this.quesService.updateQuestions(ques));
	}
	
	
	@DeleteMapping(path = "/{qId}",produces = MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<String> deleteQuiz(@PathVariable("qId") long qId) {
		this.quesService.deleteQuestion(qId);
		return new  ResponseEntity<String>("\"Record with id " + qId + " deleted\"",HttpStatus.OK);
		}
	
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("quizId") long quizId){
		
		Quiz quiz = this.quizService.getQuiz(quizId);
		
		java.util.Set<Questions> questions = quiz.getQuestions();
		
		ArrayList list = new ArrayList(questions);
		
		if(list.size() > quiz.getNoOfQuestions())
		{
			list = (ArrayList) list.subList(0,quiz.getNoOfQuestions() +1);
			
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
		
		
	}
	
	@GetMapping("/quiz/forAdmin/{quizId}")
	public ResponseEntity<?> getQuestionOfQuizForAdmin(@PathVariable("quizId") long quizId){
		
		Quiz quiz = new Quiz();
		quiz.setqId(quizId);
		
		java.util.Set<Questions> questionOfQuiz = this.quesService.getQuestionOfQuiz(quiz);
		return ResponseEntity.ok(questionOfQuiz);
		
		
	}


}
