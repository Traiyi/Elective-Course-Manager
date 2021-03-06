package com.lzc.service.impl;

import com.lzc.mapper.ElectiveCourseMapper;
import com.lzc.pojo.ElectiveCourse;
import com.lzc.pojo.SelectCondition;
import com.lzc.service.ElectiveCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectiveCourseServiceImpl implements ElectiveCourseService {
    @Autowired
    ElectiveCourseMapper electiveCourseMapper;


    public List<ElectiveCourse> list() {
        return electiveCourseMapper.list();
    }


    @Override
    public List<ElectiveCourse> list(SelectCondition selectCondition) {
        // TODO Auto-generated method stub
        return electiveCourseMapper.list(selectCondition);
    }

    @Override
    public int total() {
        return electiveCourseMapper.total();
    }


    @Override
    public int add(ElectiveCourse c) {
        return electiveCourseMapper.add(c);

    }


    @Override
    public int update(ElectiveCourse c) {
        return electiveCourseMapper.update(c);
    }


    @Override
    public int delete(int id) {
        return electiveCourseMapper.delete(id);
    }


    @Override
    public ElectiveCourse get(int id) {
        // TODO Auto-generated method stub
        return electiveCourseMapper.get(id);
    }


}
