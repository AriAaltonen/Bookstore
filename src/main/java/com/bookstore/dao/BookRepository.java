package com.bookstore.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.bean.Book;


public interface BookRepository extends CrudRepository<Book, Long> {
	//List<Book> findAll();
	//save(Book book);
	@Transactional
	void deleteByIsbn(String isbn);
	
	@Transactional
	Book findByIsbn(String isbn);
}