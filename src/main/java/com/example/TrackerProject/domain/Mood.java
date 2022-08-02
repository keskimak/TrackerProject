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
	

	public Long getMoodId() {
		return moodId;
	}

	@NotNull
	@Min(1)
	@Max(5)
	private Integer moodValue;
	@NotNull
	private String date;

	private String comment;
	
	public Mood() {
		
	}

	public Mood(int moodValue, String date, String comment) {
		
		this.moodValue = moodValue;
		this.date = date;
		this.comment = comment;
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



	public Mood(@NotEmpty(message = "Mood value cannot be empty") @Min(1) @Max(5) Integer moodValue,
			@NotEmpty(message = "Date cannot be empty") String date, String comment) {
		super();
		this.moodValue = moodValue;
		this.date = date;
		this.comment = comment;
	}

	public Integer getMoodValue() {
		return moodValue;
	}

	public void setMoodValue(Integer moodValue) {
		this.moodValue = moodValue;
	}

	
	
}
