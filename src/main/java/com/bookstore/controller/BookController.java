package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
	@Autowired
	private CategoryRepository catRepo;
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
		model.addAttribute("categories", catRepo.findAll());
		return "addbook";
	}
	
	@RequestMapping(value = "/addbook", method = RequestMethod.POST)
	public String save(Book book, Model model) {
		bookrepository.save(book);
		model.addAttribute("toiminto", "Book saved.");
		model.addAttribute("book", new Book());
		model.addAttribute("categories", catRepo.findAll());
		return "addbook";
	}
	
	@RequestMapping(value = "/delete/{isbn}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable("isbn") String isbn, Model model) {
		bookrepository.deleteByIsbn(isbn);
		return "redirect:/booklist";
	}
	
	@RequestMapping(value = "/editbook/{isbn}")
	public String addBook(@PathVariable("isbn") String isbn, Model model){
		model.addAttribute("book", bookrepository.findByIsbn(isbn));
		model.addAttribute("categories", catRepo.findAll());
		return "editbook";
	}
	
	@RequestMapping(value = "/editbook", method = RequestMethod.POST)
	public String editbook(Book book, Model model) {
		bookrepository.save(book);
		model.addAttribute("toiminto", "Book edited.");
		model.addAttribute("book", book);
		model.addAttribute("categories", catRepo.findAll());
		return "editbook";
	}
	
	@RequestMapping(value = "/editbook", method = RequestMethod.GET)
	public String editbook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", catRepo.findAll());
		return "editbook";
	}
}