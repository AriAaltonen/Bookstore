package com.bookstore;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bookstore.bean.Book;
import com.bookstore.bean.Category;
import com.bookstore.bean.User;
import com.bookstore.dao.BookRepository;
import com.bookstore.dao.CategoryRepository;
import com.bookstore.dao.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository catRepo, UserRepository userRepo) {
		return (args) -> {
			log.info("Adding categories");
			catRepo.save(new Category((long) 0, "Action"));
			catRepo.save(new Category((long) 1, "Erotic"));

			BCryptPasswordEncoder bKrypta = new BCryptPasswordEncoder();
			User user1 = new User("user", bKrypta.encode("password"), "b@google.ru",
					"USER");
			User user2 = new User("admin", bKrypta.encode("admin123"), "a@yahoo.fi",
					"ADMIN");
			userRepo.save(user1);
			userRepo.save(user2);

			repository.save(new Book("ABCD-1234-BCDA", 1990, "Catcher", "AAb", 19.95, catRepo.findByName("Action").get(0)));

			log.info("Fetch books");
			for (Book book : repository.findAll()) {
				log.info((book.toString()));
			}
		};
	}
}