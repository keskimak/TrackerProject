package com.example.TrackerProject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MoodRepository extends CrudRepository<Mood, Long> {
	
	List<Mood> findByDate(String date);
	
	
}
