package com.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.bookstore.bean.User;
import com.bookstore.dao.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository repository;
	
	@Test
	public void addUser() {
		BCryptPasswordEncoder bKrypta = new BCryptPasswordEncoder();
		User user = new User("user", bKrypta.encode("password"), "b@google.ru", "USER");
		repository.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void deleteUser() {
		BCryptPasswordEncoder bKrypta = new BCryptPasswordEncoder();
		User user = new User("user", bKrypta.encode("password"), "b@google.ru", "USER");
		repository.delete(user);
		assertThat(user.getId()).isNull();
	}
	
	@Test
	public void editUser() {
		BCryptPasswordEncoder bKrypta = new BCryptPasswordEncoder();
		User user = new User("user", bKrypta.encode("password"), "b@google.ru", "USER");
		repository.save(user);
		user = new User("useri", bKrypta.encode("password"), "b@google.ru", "USER");
		repository.save(user);
		assertThat(user.getUsername()).isEqualTo("useri");
	}
}