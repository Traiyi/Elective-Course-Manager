package com.lzc.mapper;

import com.lzc.pojo.SelectCondition;
import com.lzc.pojo.Specialty;

import java.util.List;

public interface SpecialtyMapper {


    public int add(Specialty specialty);


    public int delete(int id);


    public Specialty get(int id);


    public int update(Specialty specialty);


    public List<Specialty> list();

    public List<Specialty> list(SelectCondition selectCondition);

//    public List<Specialty> listSpecialtyAll();

    public int total();


}