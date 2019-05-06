package com.tbb.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="CHALLENGE_QUESTIONS")
public class ChallengeQuestions {
	
	@Id
	@Column(name="challenge_question_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cq_seq")
    @SequenceGenerator(name="cq_seq", sequenceName="challenge_question_seq", allocationSize = 1)
    private int challengeQuestionId;
	
	@Column(name="user_id")
    @NotNull
	private int userId;
	
	@Column(name="challenge_question")
	@NotNull
	private String challengeQuestion;
	
	@Column(name="challenge_answer")
	@NotNull
	private String challengeAnswer;

	public ChallengeQuestions() {
		super();
	}

	public ChallengeQuestions(@NotNull int userId, @NotNull String challengeQuestion, @NotNull String challengeAnswer) {
		super();
		this.userId = userId;
		this.challengeQuestion = challengeQuestion;
		this.challengeAnswer = challengeAnswer;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getChallengeQuestion() {
		return challengeQuestion;
	}

	public void setChallengeQuestion(String challengeQuestion) {
		this.challengeQuestion = challengeQuestion;
	}

	public String getChallengeAnswer() {
		return challengeAnswer;
	}

	public void setChallengeAnswer(String challengeAnswer) {
		this.challengeAnswer = challengeAnswer;
	}

	@Override
	public String toString() {
		return "ChallengeQuestions [userId=" + userId + ", challengeQuestion=" + challengeQuestion
				+ ", challengeAnswer=" + challengeAnswer + "]";
	}
	
}
