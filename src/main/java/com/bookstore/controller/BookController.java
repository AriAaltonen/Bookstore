package com.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String homepage(Model model) {

		return "index";
	}
}

/*
 * @RequestMapping("/message") public String messages(Model model){
 * model.addAttribute("messages", "jukka"); return "index"; }
 */
