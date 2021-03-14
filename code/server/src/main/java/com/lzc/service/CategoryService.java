package com.lzc.service;

import java.util.List;

import com.lzc.pojo.Category;
import com.lzc.pojo.SelectCondition;

public interface CategoryService {

	List<Category> list();
	int total();
	List<Category> list(SelectCondition selectCondition);
	void add(Category c);
	void update(Category c);
	void delete(Category c);
	Category get(int id);
}
