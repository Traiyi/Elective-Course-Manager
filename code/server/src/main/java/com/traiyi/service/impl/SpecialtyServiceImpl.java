package com.traiyi.service.impl;

import com.traiyi.mapper.SpecialtyMapper;
import com.traiyi.pojo.SelectCondition;
import com.traiyi.pojo.Specialty;
import com.traiyi.service.SpecialtyService;
import com.traiyi.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {
    @Autowired
    SpecialtyMapper specialtyMapper;


    public List<Specialty> list() {
        return specialtyMapper.list();
    }


    @Override
    public List<Specialty> list(SelectCondition selectCondition) {
        // TODO Auto-generated method stub
        return specialtyMapper.list(selectCondition);
    }


    public List<Specialty> listSpecialtyMoreAndOneGrade() {
        List<Specialty> specialties = specialtyMapper.listSpecialtyAll();
        for (Specialty specialty : specialties
        ) {
            System.out.println("sssss");
            System.out.println(specialty);
        }
        return specialties;
    }


    @Override
    public int total() {
        return specialtyMapper.total();
    }


    @Override
    public int add(Specialty c) {
        return specialtyMapper.add(c);

    }


    @Override
    public int update(Specialty c) {
        return specialtyMapper.update(c);
    }


    @Override
    public int delete(int id) {
        return specialtyMapper.delete(id);
    }


    @Override
    public Specialty get(int id) {
        // TODO Auto-generated method stub
        return specialtyMapper.get(id);
    }


}
