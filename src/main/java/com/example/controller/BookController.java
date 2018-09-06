package com.example.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BookController {
		@RequestMapping(value="/index", method=RequestMethod.GET)
				public String greeting(@RequestParam(value="name") 
				String name, Model model) {
					model.addAttribute("name",name);
					return "";
				}
	}


	/*
	 * @RequestMapping("/message")
	 * public String messages(Model model){
	 * model.addAttribute("messages", "jukka");
	 * return "index";
	 * }
	 */
