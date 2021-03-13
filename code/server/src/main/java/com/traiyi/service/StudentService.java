package com.traiyi.service;

import com.traiyi.pojo.SelectCondition;
import com.traiyi.pojo.Student;
import com.traiyi.util.Page;

import java.util.List;

public interface StudentService {

	List<Student> list();
	int total();
	List<Student> list(SelectCondition selectCondition);
	int add(Student c);
	int update(Student c);
	int delete(int id);
	Student get(int id);
	List<Student> listStudentAll();
}
