package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
	@Autowired
	private BookRepository2 bkrepo;
	@Autowired
	private BookRepository bookrepository;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String homepage(Model model) {

		return "index";
	}
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String bookList(Model model) {
		model.addAttribute("booklist", bookrepository.findAll());
		//model.addAttribute("booklist", bkrepo.findAll());
		return "booklist";
	}
	
	@RequestMapping(value = "/addbook", method = RequestMethod.GET)
	public String addbook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@RequestMapping(value = "/addbook", method = RequestMethod.POST)
	public String save(Book book, Model model) {
		bookrepository.save(book);
		model.addAttribute("toiminto", "Book saved.");
		model.addAttribute("book", new Book());
		return "addbook";
	}
}

/*
 * @RequestMapping("/message") public String messages(Model model){
 * model.addAttribute("messages", "jukka"); return "index"; }
 */
