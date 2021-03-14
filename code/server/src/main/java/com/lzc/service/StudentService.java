package com.lzc.service;

import com.lzc.pojo.SelectCondition;
import com.lzc.pojo.Student;

import java.util.List;

public interface StudentService {

	List<Student> list();
	int total();
	List<Student> list(SelectCondition selectCondition);
	int add(Student c);
	int update(Student c);
	int delete(int id);
	Student get(int id);
}
