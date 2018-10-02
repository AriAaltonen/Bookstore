package com.bookstore.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BookRepository2 {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public List<Book> findAll() {
		return jdbcTemplate.query("select * from BOOK", new BookRowMapper());
	}
	
	public void addBook(Book book) {
		
	}
}

class BookRowMapper implements RowMapper<Book> {
	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book book = new Book();
		book.setIsbn(rs.getString("isbn"));
		book.setYear(rs.getInt("year"));
		book.setTitle(rs.getString("title"));
		book.setAuthor(rs.getString("author"));
		book.setPrice(rs.getDouble("price"));
		return book;
	}
}
