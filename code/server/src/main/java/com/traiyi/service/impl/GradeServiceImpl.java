package com.traiyi.service.impl;

import com.traiyi.mapper.GradeMapper;
import com.traiyi.pojo.Grade;
import com.traiyi.service.GradeService;
import com.traiyi.util.Page;
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
    public List<Grade> list(Page page) {
        // TODO Auto-generated method stub
        return gradeMapper.list(page);
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
