package com.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bookstore.bean.Category;
import com.bookstore.bean.Book;
import com.bookstore.dao.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository repository;
	
	@Test
	public void addCategory() {
		Category category = new Category((long) 0, "Action");
		repository.save(category);
		
		assertThat(category.getId()).isNotNull();
	}
	
	@Test
	public void deleteCategory() {
		Category category = new Category((long) 0, "Action");
		repository.delete(category);
		
		assertThat(category.getId()).isNull();
	}
	
	@Test
	public void editCategory(){
		Category category = new Category((long) 0, "Action");
		repository.save(category);
		category = new Category ((long) 0, "Erot");
		repository.save(category);
		assertThat(category.getName()).isEqualTo("Erot");
	}
}
