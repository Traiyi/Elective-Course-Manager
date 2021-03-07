package com.traiyi.service.impl;

import com.traiyi.mapper.ElectiveCourseMapper;
import com.traiyi.pojo.ElectiveCourse;
import com.traiyi.service.ElectiveCourseService;
import com.traiyi.util.Page;
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
    public List<ElectiveCourse> list(Page page) {
        // TODO Auto-generated method stub
        return electiveCourseMapper.list(page);
    }

    public List<ElectiveCourse> listElectiveCourseAll(){
        System.out.println(electiveCourseMapper.listElectiveCourseAll());
        List<ElectiveCourse> electiveCourses =  electiveCourseMapper.listElectiveCourseAll();
        for (ElectiveCourse e:electiveCourses
             ) {
            System.out.println(e);

        }
        return electiveCourseMapper.listElectiveCourseAll();
    }

    @Override
    public int total() {
        return electiveCourseMapper.total();
    }


    @Override
    public int add(ElectiveCourse c) {
         return  electiveCourseMapper.add(c);

    }


    @Override
    public int update(ElectiveCourse c) {
        return   electiveCourseMapper.update(c);
    }


    @Override
    public int delete(int id) {
        return  electiveCourseMapper.delete(id);
    }


    @Override
    public ElectiveCourse get(int id) {
        // TODO Auto-generated method stub
        return electiveCourseMapper.get(id);
    }

    ;


}
