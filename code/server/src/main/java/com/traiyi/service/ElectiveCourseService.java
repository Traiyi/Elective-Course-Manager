package com.traiyi.service;

import com.traiyi.pojo.ElectiveCourse;
import com.traiyi.util.Page;

import java.util.List;

public interface ElectiveCourseService {

	List<ElectiveCourse> list();
	int total();
	List<ElectiveCourse> list(Page page);

	 List<ElectiveCourse> listElectiveCourseAll();
	int add(ElectiveCourse c);
	int update(ElectiveCourse c);
	int delete(int id);
	ElectiveCourse get(int id);
}
