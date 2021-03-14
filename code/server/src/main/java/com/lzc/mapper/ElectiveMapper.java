package com.lzc.mapper;

import com.lzc.pojo.Elective;
import com.lzc.pojo.SelectCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ElectiveMapper {


    public int add(Elective elective);

    public int delete(int id);

    public Elective get(int id);

    public int update(Elective elective);

    public List<Elective> list();

    public List<Elective> list(SelectCondition selectCondition);

    public int total();

    public int totalElective(int id);

    public List<Elective> listElectivePass(int id);

    public List<Elective> listElectiveNoPass(int id);

    public List<Elective> listStudent(@Param("id") int id, @Param("name") String name);

}