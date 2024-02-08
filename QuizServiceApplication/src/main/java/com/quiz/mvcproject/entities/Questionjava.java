package com.quiz.mvcproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Questionjava 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String quesno;
	String question;
	String option1;
	String option2;
	String option3;
	String option4;
	String correct;
	public Questionjava() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Questionjava(int id, String quesno, String question, String option1, String option2, String option3,
			String option4, String correct) {
		super();
		this.id = id;
		this.quesno = quesno;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correct = correct;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestionNo() {
		return quesno;
	}
	public void setQuestionNo(String quesno) {
		this.quesno= quesno;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getCorrectOption() {
		return correct;
	}
	public void setCorrectOption(String correct) {
		this.correct= correct;
	}
	@Override
	public String toString() {
		return "Quiz [id=" + id + ", questionNo=" + quesno + ", question=" + question + ", option1=" + option1
				+ ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4 + ", correctOption="
				+ correct + "]";
	}
	
	
	

}
