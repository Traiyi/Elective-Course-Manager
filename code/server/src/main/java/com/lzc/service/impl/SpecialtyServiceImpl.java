package com.lzc.service.impl;

import com.lzc.mapper.SpecialtyMapper;
import com.lzc.pojo.SelectCondition;
import com.lzc.pojo.Specialty;
import com.lzc.service.SpecialtyService;
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




    public List<Specialty> list(SelectCondition selectCondition) {
        List<Specialty> specialties = specialtyMapper.list(selectCondition);
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
