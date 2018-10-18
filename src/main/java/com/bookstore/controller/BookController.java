package com.bookstore.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.controller.Book;

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
	//show all books
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String bookList(Model model) {
		model.addAttribute("booklist", bookrepository.findAll());
		return "booklist";
	}
	// REST list books
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) bookrepository.findAll();
	}
	//find book by isbn
	@RequestMapping(value="/book/{isbn]", method = RequestMethod.GET)
		public @ResponseBody Book findBookRest(@PathVariable("isbn") String isbn) {
			return bookrepository.findByIsbn(isbn);	
	}
	
	//add a book GET
	@RequestMapping(value = "/addbook", method = RequestMethod.GET)
	public String addbook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", catRepo.findAll());
		return "addbook";
	}
	//add a book POST
	@RequestMapping(value = "/addbook", method = RequestMethod.POST)
	public String save(Book book, Model model) {
		bookrepository.save(book);
		model.addAttribute("toiminto", "Book saved.");
		model.addAttribute("book", new Book());
		model.addAttribute("categories", catRepo.findAll());
		return "addbook";
	}
	// delete book
	@RequestMapping(value = "/delete/{isbn}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("isbn") String isbn, Model model) {
		bookrepository.deleteByIsbn(isbn);
		return "redirect:/booklist";
	}
	// edit book
	@RequestMapping(value = "/editbook/{isbn}")
	public String addBook(@PathVariable("isbn") String isbn, Model model){
		model.addAttribute("book", bookrepository.findByIsbn(isbn));
		model.addAttribute("categories", catRepo.findAll());
		return "editbook";
	}
	// edit book POST
	@RequestMapping(value = "/editbook", method = RequestMethod.POST)
	public String editbook(Book book, Model model) {
		bookrepository.save(book);
		model.addAttribute("toiminto", "Book edited.");
		model.addAttribute("book", book);
		model.addAttribute("categories", catRepo.findAll());
		return "editbook";
	}
	// edit book GET
	@RequestMapping(value = "/editbook", method = RequestMethod.GET)
	public String editbook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", catRepo.findAll());
		return "editbook";
	}
}