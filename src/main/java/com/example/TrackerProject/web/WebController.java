package com.example.TrackerProject.web;

import java.util.ArrayList;
import java.util.List;

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
	@RequestMapping("/home")
	public String homePage(Model model) {
		model.addAttribute("moods", moodRepository.findAll());
		return "home";

	}

	// List past moods in page addmood
	@RequestMapping("/addmood")
	public String oldMoods(Model model) {

		model.addAttribute("mood", new Mood());
		model.addAttribute("moods", moodRepository.findAll());
		return "addmood";

	}

	// tracking a new mood
	@PostMapping("/save")
	public String saveMood(Mood mood) {

		moodRepository.save(mood);

		return "redirect:home";

	}

	@RequestMapping(value = "/delete/{moodId}", method = RequestMethod.GET)
	public String deleteMood(@PathVariable("moodId") Long moodId, Model model) {
		moodRepository.deleteById(moodId);
		return "redirect:../home";
	}

	@RequestMapping(value = "/edit/{moodId}", method = RequestMethod.GET)
	public String editMood(@PathVariable("moodId") Long moodId, Model model) {
		moodRepository.findById(moodId);
		return "redirect:../home";
	}

}
