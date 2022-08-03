package com.example.TrackerProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.TrackerProject.domain.Mood;
import com.example.TrackerProject.domain.MoodRepository;

@SpringBootApplication
public class TrackerProjectApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(TrackerProjectApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(MoodRepository moodRepository) {return (args) -> 
	{
		
		Mood mood1 = new Mood(3, "01.08.2022", "Paska päivä");
		moodRepository.save(mood1);
		Mood mood2 = new Mood(3, "01.10.2022", "Hyvä päivä");
		moodRepository.save(mood2);
	 
	};
	}

	
	
}
