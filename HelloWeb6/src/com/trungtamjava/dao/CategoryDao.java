package com.trungtamjava.dao;

import java.util.List;

import com.trungtamjava.model.Category;

public interface CategoryDao {
	void add(Category category);

	void update(Category category);

	void delete(int id);

	Category get(int id);// duy nhat

	List<Category> search(String name);

}
