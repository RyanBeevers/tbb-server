package com.tbb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tbb.models.ChallengeQuestions;
import com.tbb.models.Users;
import com.tbb.services.ChallengeQuestionsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/challengeQuestions")
public class ChallengeQuestionsController {
	
	private ChallengeQuestionsService service;
	
	@Autowired
	public ChallengeQuestionsController (ChallengeQuestionsService challengeQuestionsService) {
		this.service = challengeQuestionsService;
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ChallengeQuestions>> getChallengeQuestionsByUserId(@RequestBody Users newUser){
		if(newUser == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		int userId = newUser.getUserId();
		System.out.println(userId);
		List<ChallengeQuestions> challengeQuestions = service.findChallengeQuestionsByUserId(userId);
		if (challengeQuestions == null) {
			return new ResponseEntity<>(challengeQuestions, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ChallengeQuestions>>(challengeQuestions, HttpStatus.OK);
	}
	
}
