package com.lzc.service;

import com.lzc.pojo.SelectCondition;
import com.lzc.pojo.Specialty;

import java.util.List;

public interface SpecialtyService {

	List<Specialty> list();
	int total();
	List<Specialty> list(SelectCondition selectCondition);
//	List<Specialty> listSpecialtyMoreAndOneGrade();
	int add(Specialty c);
	int update(Specialty c);
	int delete(int id);
	Specialty get(int id);
}
