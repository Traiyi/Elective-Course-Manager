package com.lzc.service;

import com.lzc.pojo.ElectiveCourse;
import com.lzc.pojo.SelectCondition;

import java.util.List;

public interface ElectiveCourseService {

	int total();
	List<ElectiveCourse> list();
	List<ElectiveCourse> list(SelectCondition selectCondition);
	int add(ElectiveCourse c);
	int update(ElectiveCourse c);
	int delete(int id);
	ElectiveCourse get(int id);
}
