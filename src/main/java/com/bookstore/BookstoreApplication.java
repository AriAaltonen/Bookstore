package com.bookstore;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bookstore.controller.Book;
import com.bookstore.controller.BookRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(BookstoreApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository) {	
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				log.info("Saving books");
				repository.save(new Book("ABCD-1234-BCDA", 1990, "Catcher", "AAb", 19.95));
			}
		};
	}
}
