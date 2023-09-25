package com.exam.controller;

import java.util.LinkedHashSet;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.repository.QuizRepository;
import com.exam.services.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin
public class QuizController {
	
	@Autowired
	private QuizService quizservice;
	
	
	@PostMapping("/")
	public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz) {
		return ResponseEntity.ok(this.quizservice.addQuiz(quiz));
	}
	
	
	@GetMapping("/{qId}")
	public ResponseEntity<?> getQuiz(@PathVariable("qId") long qId) {
		return ResponseEntity.ok(this.quizservice.getQuiz(qId));
	}
	
	
	@GetMapping("/")
	public ResponseEntity<?> getAllQuiz() {
		return ResponseEntity.ok( new LinkedHashSet(this.quizservice.getQuizess()));
	}
	
	
	
	@PutMapping("/")
	public ResponseEntity<?> updateQuiz(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizservice.updateQuiz(quiz));
	}
	
	
	@DeleteMapping("/{qId}")
	public void deleteQuiz(@PathVariable("qId") long qId) {
		this.quizservice.deleteQuiz(qId);
		//return "Record with id" + qId + "deleted";
		}


}
