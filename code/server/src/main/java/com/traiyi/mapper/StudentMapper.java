package com.traiyi.mapper;

import com.traiyi.pojo.SelectCondition;
import com.traiyi.pojo.Student;
import com.traiyi.util.Page;

import java.util.List;

public interface StudentMapper {


    public int add(Student student);


    public int delete(int id);


    public Student get(int id);


    public int update(Student student);


    public List<Student> list();

    public List<Student> list(SelectCondition selectCondition);

    public List<Student> listStudentAll();



    public int total();

}