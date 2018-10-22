package com.bookstore.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
	@Id
	private String isbn;
	private int year;
	private String title;
	private String author;
	private double price;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "id")
	private Category category;
	
	public Book() {
		
	}
	
	public Book(String isbn, int year, String title, String author, double price, Category category) {
		this.isbn = isbn;
		this.year = year;
		this.title = title;
		this.author = author;
		this.price = price;
		this.category = category;
	}
	
	@Override
	public String toString() {
		if (this.category != null)
			return "Book [isbn=" + isbn + ", year=" + year + ", title=" + title + ", author=" + author + ", price=" + price + ", category=" + this.getCategory() + "]";
		else
			return "Book [isbn=" + isbn + ", year=" + year +",title=" + title + ", author=" + author + ", price=" + price + "]";
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
