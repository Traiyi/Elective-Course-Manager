package com.lzc.service.impl;

import com.lzc.mapper.ElectiveCourseMapper;
import com.lzc.mapper.ElectiveMapper;
import com.lzc.pojo.Elective;
import com.lzc.pojo.ElectiveCourse;
import com.lzc.pojo.SelectCondition;
import com.lzc.service.ElectiveService;
import com.lzc.util.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectiveServiceImpl implements ElectiveService {
    @Autowired
    ElectiveMapper electiveMapper;
    @Autowired
    ElectiveCourseMapper electiveCourseMapper;

    Credit credit;

    public List<Elective> list() {
        return electiveMapper.list();
    }


    @Override
    public List<Elective> list(SelectCondition selectCondition) {
        // TODO Auto-generated method stub
        List<Elective> electives = electiveMapper.list(selectCondition);
        for (Elective e:electives
             ) {
            System.out.println(e);
        }
        return electiveMapper.list(selectCondition);
    }


    @Override
    public int total() {
        return electiveMapper.total();
    }

    @Override
    public int add(Elective elective) {
        System.out.println("impl "+elective);
        credit.isPass(elective);
//        double studentCredit = elective.getStudentCredit();
//        double electiveCourseCredit = electiveCourseMapper.get(elective.getCourseID()).getCredit();
//        System.out.println(studentCredit+" "+electiveCourseCredit);
//        if (studentCredit < electiveCourseCredit)
//            elective.setIsPass(0);
//        else
//            elective.setIsPass(1);
//
        System.out.println("impl+isPass "+elective);
        return electiveMapper.add(elective);
    }


    @Override
    public int update(Elective elective) {
//        double studentCredit = elective.getStudentCredit();
//        ElectiveCourse electiveCourse = electiveCourseMapper.get(elective.getCourseID());
//        double electiveCourseCredit = electiveCourse.getCredit();
//        System.out.println(studentCredit+" "+electiveCourseCredit);
//        if (studentCredit < electiveCourseCredit)
//            elective.setIsPass(0);
//        else
//            elective.setIsPass(1);
        credit.isPass(elective);
        return electiveMapper.update(elective);
    }


    @Override
    public int delete(int id) {
        return electiveMapper.delete(id);
    }


    @Override
    public Elective get(int id) {
        // TODO Auto-generated method stub
        return electiveMapper.get(id);
    }


    public int totalElective(int id) {

        return electiveMapper.totalElective(id);
    }

    public List<Elective> listElectivePass(int id) {
        return electiveMapper.listElectivePass(id);
    }

    public List<Elective> listElectiveNoPass(int id) {
        return electiveMapper.listElectiveNoPass(id);
    }


    public List<Elective> listStudent(int id, String name) {
        return electiveMapper.listStudent(id, name);
    }

}
