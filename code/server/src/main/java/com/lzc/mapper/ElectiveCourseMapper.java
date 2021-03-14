package com.lzc.mapper;

import com.lzc.pojo.ElectiveCourse;
import com.lzc.pojo.SelectCondition;

import java.util.List;

public interface ElectiveCourseMapper {


    public int add(ElectiveCourse electiveCourse);


    public int delete(int id);


    public ElectiveCourse get(int id);


    public int update(ElectiveCourse electiveCourse);


    public List<ElectiveCourse> list();

    public List<ElectiveCourse> list(SelectCondition selectCondition);



    public int total();

}