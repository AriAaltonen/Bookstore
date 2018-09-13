package com.bookstore.controller;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	private String isbn;
	private int year;
	private String title;
	private String author;
	private double price;
	
	public Book() {
		
	}
	
	public Book(String isbn, int year, String title, String author, double price) {
		this.isbn = isbn;
		this.year = year;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "isbn =" + isbn + ", year =" + year +",title =" + title + ", author =" + author + ", price =" + price;
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

}
