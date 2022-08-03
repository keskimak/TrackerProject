package com.example.TrackerProject.domain;

import javax.persistence.Entity;

import org.hibernate.annotations.BatchSize;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Mood {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long moodId;
	
	
	private Integer moodValue;
	private String date;
	private String comment;
	
	
	
	public Long getMoodId() {
		return moodId;
	}

	public void setMoodId(Long moodId) {
		this.moodId = moodId;
	}

	
	public Mood() {
		
	}

	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}



	public Integer getMoodValue() {
		return moodValue;
	}

	public void setMoodValue(Integer moodValue) {
		this.moodValue = moodValue;
	}

	public Mood(Integer moodValue,String date, String comment) {
		
		
		this.moodValue = moodValue;
		this.date = date;
		this.comment = comment;
	}

	
	
}
