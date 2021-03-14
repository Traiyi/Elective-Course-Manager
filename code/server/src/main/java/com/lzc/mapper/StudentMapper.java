package com.lzc.mapper;

import com.lzc.pojo.SelectCondition;
import com.lzc.pojo.Student;

import java.util.List;

public interface StudentMapper {


    public int add(Student student);


    public int delete(int id);


    public Student get(int id);


    public int update(Student student);


    public List<Student> list();

    public List<Student> list(SelectCondition selectCondition);

    public int total();

}