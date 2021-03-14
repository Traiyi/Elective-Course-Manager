package com.lzc.service;

import com.lzc.pojo.Elective;
import com.lzc.pojo.SelectCondition;

import java.util.List;

public interface ElectiveService {

    List<Elective> list();

    int total();

    List<Elective> list(SelectCondition selectCondition);

    int add(Elective c);

    int update(Elective c);

    int delete(int id);

    Elective get(int id);

    int totalElective(int id);

    List<Elective> listElectivePass(int id);

    List<Elective> listElectiveNoPass(int id);
    List<Elective> listStudent(int id,String name);
}
