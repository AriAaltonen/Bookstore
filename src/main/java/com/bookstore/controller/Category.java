package com.bookstore.controller;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	private long id;
	private String name;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
	private List<Book> books;
	
	public Category () {
		
	}
	public Category(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	@Override
	public String toString() {
		return "Category [categoryid=" + id + ", name=" + name + "]";
	}
}
