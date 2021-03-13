package com.traiyi.service.impl;

import com.traiyi.mapper.ElectiveMapper;
import com.traiyi.pojo.Elective;
import com.traiyi.pojo.SelectCondition;
import com.traiyi.service.ElectiveService;
import com.traiyi.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectiveServiceImpl implements ElectiveService {
    @Autowired
    ElectiveMapper electiveMapper;


    public List<Elective> list() {
        return electiveMapper.list();
    }


    @Override
    public List<Elective> list(SelectCondition selectCondition) {
        // TODO Auto-generated method stub
        return electiveMapper.list(selectCondition);
    }


    @Override
    public int total() {
        return electiveMapper.total();
    }


    @Override
    public int add(Elective c) {
        return electiveMapper.add(c);

    }


    @Override
    public int update(Elective c) {
        return electiveMapper.update(c);
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
