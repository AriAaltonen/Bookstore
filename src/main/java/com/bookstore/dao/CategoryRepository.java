package com.bookstore.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.bean.Category;


public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
	List<Category> findByName(String name);
}
