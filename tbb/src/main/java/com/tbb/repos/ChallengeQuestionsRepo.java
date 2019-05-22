package com.tbb.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tbb.models.ChallengeQuestions;
import com.tbb.models.Users;

@Repository
public interface ChallengeQuestionsRepo extends JpaRepository <ChallengeQuestions, Integer> {

	List<ChallengeQuestions> findAllChallengeQuestionsByUserId(String userId);
	
}
