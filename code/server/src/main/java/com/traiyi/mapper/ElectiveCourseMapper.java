package com.traiyi.mapper;

import com.traiyi.pojo.ElectiveCourse;
import com.traiyi.pojo.SelectCondition;
import com.traiyi.util.Page;

import java.util.List;

public interface ElectiveCourseMapper {


    public int add(ElectiveCourse electiveCourse);


    public int delete(int id);


    public ElectiveCourse get(int id);


    public int update(ElectiveCourse electiveCourse);


    public List<ElectiveCourse> list();

    public List<ElectiveCourse> list(SelectCondition selectCondition);

    public List<ElectiveCourse> listElectiveCourseAll();


    public int total();

}