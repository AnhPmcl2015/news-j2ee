package com.uit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uit.entity.Person;

@Controller
public class HomeController {
	
	private static List<Person> persons = new ArrayList<>();
	
	static {
		persons.add(new Person("Bill", "Gates"));
		persons.add(new Person("Steve", "Jobs"));
	}
	
	@GetMapping(value= {"/", "index"})
	public String index(Model model) {
		String message = "Hello Spring Boot";
		model.addAttribute("message", message);
		return "index";
	}
}
