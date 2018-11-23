package com.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bookstore.bean.Category;
import com.bookstore.bean.Book;
import com.bookstore.dao.BookRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
    private BookRepository repository;
	
	@Test
	public void findByIsbnShouldReturnBook() {
		Book book = repository.findByIsbn("ABCD-1234-BCDA");
		assertThat(book.getIsbn()).isEqualTo("ABCD-1234-BCDA");
		}
	
	@Test
    public void createNewBook() {
    	Book book = new Book("ABCD-1234-BCDA", 1990, "Catcher", "AAb", 19.95, new Category(null, "Action"));
    	repository.save(book);
    	assertThat(book.getIsbn()).isNotNull();
    }   
	
	@Test
	public void deleteBook() {
		Book book = new Book("ABCD-1234-BCDB", 1990, "Catcher", "AAb", 19.95, new Category(null, "Action"));
		repository.delete(book);
		assertThat(book.getIsbn()).isNull();
	}
	
	@Test
	public void editBook() {
		Book book = new Book("ABCD-1234-BCDC", 1990, "Catcher", "AAb", 19.95, new Category(null, "Action"));
		repository.save(book);
	}
}
