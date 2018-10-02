package com.bookstore;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bookstore.controller.Book;
import com.bookstore.controller.BookRepository;
import com.bookstore.controller.Category;
import com.bookstore.controller.CategoryRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(BookstoreApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository catRepo) {	
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				log.info("Adding categories");
				catRepo.save(new Category((long) 0, "Action"));
				catRepo.save(new Category((long) 1, "Erotic"));
				//repository.save(new Book("ABCD-1234-BCDA", 1990, "Catcher", "AAb", 19.95, a));
			}
		};
	}
}
