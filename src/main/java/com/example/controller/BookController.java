package com.example.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BookController {
		@RequestMapping(value="/index", method=RequestMethod.POST)
				public String greeting(@RequestParam(value="name") String name, Model model,@RequestParam(value="age") int age, Model modeli) {
					model.addAttribute("name",name);
					modeli.addAttribute("age",age);
					return "hello";
				}
	}


	/*
	 * @RequestMapping("/message")
	 * public String messages(Model model){
	 * model.addAttribute("messages", "jukka");
	 * return "index";
	 * }
	 */
