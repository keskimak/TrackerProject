package com.example.TrackerProject.web;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import com.example.TrackerProject.domain.Mood;
import com.example.TrackerProject.domain.MoodRepository;

@Controller
public class WebController{

	@Autowired
	private MoodRepository moodRepository;

	@RequestMapping("/login")
	public String indexPage() {
		return "login";
	}

	// Listing all past moods
	@RequestMapping(value = {"/home", "/"})
	public String homePage(Model model) {
		model.addAttribute("moods", moodRepository.findAll());
		return "home";

	}
	
	@RequestMapping(value = "/moods", method = RequestMethod.GET)
	public @ResponseBody List<Mood> moodListRest() {
		return (List<Mood>) moodRepository.findAll();
	}

	// Return book by id in JSON
	@RequestMapping(value = "/mood/{moodId}", method = RequestMethod.GET)
	public @ResponseBody Optional<Mood> findBookRest(@PathVariable("moodId") Long moodId) {
		return moodRepository.findById(moodId);
	}



	// Add new mood page
	@RequestMapping("/addmood")
	public String addMood(Model model) {

		model.addAttribute("mood", new Mood());

		return "addmood";

	}

	// tracking a new mood
	@RequestMapping(value= "/save",method = RequestMethod.POST)
	public String saveMood(Mood mood) {

		moodRepository.save(mood);

		return "redirect:home";

	}



	@RequestMapping(value = "/delete/{moodId}")
	public String deleteMood(@PathVariable("moodId") Long moodId, Model model) {
		moodRepository.deleteById(moodId);
		return "redirect:../home";
	}

	
	@RequestMapping(value = "/edit/{moodId}")
	public String editMood(@PathVariable("moodId") Long moodId, Model model) {
		model.addAttribute("mood", moodRepository.findById(moodId));
	
	
		return "editmood";
	}

}
