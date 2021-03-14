package com.lzc.mapper;

import java.util.List;

import com.lzc.pojo.Category;
import com.lzc.pojo.SelectCondition;

public interface CategoryMapper {


    public int add(Category category);


    public void delete(int id);


    public Category get(int id);


    public int update(Category category);


    public List<Category> list();

    public List<Category> list(SelectCondition selectCondition);


    public int total();

}