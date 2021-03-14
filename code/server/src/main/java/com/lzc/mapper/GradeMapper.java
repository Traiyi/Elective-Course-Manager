package com.lzc.mapper;

import com.lzc.pojo.Grade;
import com.lzc.pojo.SelectCondition;

import java.util.List;

public interface GradeMapper {


    public int add(Grade grade);


    public int delete(int id);


    public Grade get(int id);


    public int update(Grade grade);


    public List<Grade> list();

    public List<Grade> list(SelectCondition selectCondition);


    public int total();

}