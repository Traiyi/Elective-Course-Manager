package com.traiyi.service;

import com.traiyi.pojo.SelectCondition;
import com.traiyi.pojo.Specialty;
import com.traiyi.util.Page;

import java.util.List;

public interface SpecialtyService {

	List<Specialty> list();
	int total();
	List<Specialty> list(SelectCondition selectCondition);
	List<Specialty> listSpecialtyMoreAndOneGrade();
	int add(Specialty c);
	int update(Specialty c);
	int delete(int id);
	Specialty get(int id);
}
