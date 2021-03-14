package com.lzc.service.impl;

import java.util.List;

import com.lzc.pojo.SelectCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzc.mapper.CategoryMapper;
import com.lzc.pojo.Category;
import com.lzc.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;


    public List<Category> list() {
        return categoryMapper.list();
    }


    @Override
    public List<Category> list(SelectCondition selectCondition) {
        // TODO Auto-generated method stub
        return categoryMapper.list(selectCondition);
    }


    @Override
    public int total() {
        return categoryMapper.total();
    }


    @Override
    public void add(Category c) {
        categoryMapper.add(c);

    }


    @Override
    public void update(Category c) {
        categoryMapper.update(c);
    }


    @Override
    public void delete(Category c) {
        categoryMapper.delete(c.getId());
    }


    @Override
    public Category get(int id) {
        // TODO Auto-generated method stub
        return categoryMapper.get(id);
    }

    ;


}
