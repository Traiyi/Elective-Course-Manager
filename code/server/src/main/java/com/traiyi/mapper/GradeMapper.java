package com.traiyi.mapper;

import com.traiyi.pojo.Grade;
import com.traiyi.util.Page;

import java.util.List;

public interface GradeMapper {


    public int add(Grade grade);


    public int delete(int id);


    public Grade get(int id);


    public int update(Grade grade);


    public List<Grade> list();

    public List<Grade> list(Page page);


    public int total();

}