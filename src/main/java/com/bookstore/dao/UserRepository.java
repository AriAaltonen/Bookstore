package com.bookstore.dao;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.bean.User;


public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
