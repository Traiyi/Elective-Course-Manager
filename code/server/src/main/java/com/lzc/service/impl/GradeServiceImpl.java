package com.lzc.service.impl;

import com.lzc.mapper.GradeMapper;
import com.lzc.pojo.Grade;
import com.lzc.pojo.SelectCondition;
import com.lzc.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    GradeMapper gradeMapper;


    public List<Grade> list() {
        return gradeMapper.list();
    }


    @Override
    public List<Grade> list(SelectCondition selectCondition) {
        // TODO Auto-generated method stub
        return gradeMapper.list(selectCondition);
    }


    @Override
    public int total() {
        return gradeMapper.total();
    }


    @Override
    public int add(Grade c) {
        return gradeMapper.add(c);

    }


    @Override
    public int update(Grade c) {
        return  gradeMapper.update(c);
    }


    @Override
    public int delete(int id) {
       return gradeMapper.delete(id);
    }


    @Override
    public Grade get(int id) {
        // TODO Auto-generated method stub
        return gradeMapper.get(id);
    }

    ;


}
