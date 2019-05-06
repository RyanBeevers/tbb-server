package com.tbb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tbb.models.ChallengeQuestions;
import com.tbb.repos.ChallengeQuestionsRepo;
import com.tbb.models.Users;

@Service
public class ChallengeQuestionsService {
	
	private ChallengeQuestionsRepo repo;
	
	@Autowired
	public ChallengeQuestionsService(ChallengeQuestionsRepo challengeQuestionsRepo) {
		this.repo = challengeQuestionsRepo;
	}
	
	public List<ChallengeQuestions> findChallengeQuestionsByUserId (int userId) {
		return repo.findAllChallengeQuestionsByUserId(userId);
	}
	
	public ChallengeQuestions setChallengeQuestions (ChallengeQuestions newChallengeQuestion){
		return this.repo.save(newChallengeQuestion);
	}

}
