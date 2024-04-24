package com.cascade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Answer
{
	@Id
	@Column(name="answer_id")
	private int answerId;
	private String answer;
	
	@ManyToOne
    private Question question;
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	public Answer() {
		super();
	}
	public Answer(int answerId, String answer) {
		super();
		this.answerId = answerId;
		this.answer = answer;
	}
	
	
	}
