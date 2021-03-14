package com.lzc.mapper;

import com.lzc.pojo.Admin;
import com.lzc.pojo.SelectCondition;

import java.util.List;

public interface AdminMapper {

    public Admin login(String username);

    public int add(Admin admin);


    public void delete(int id);


    public Admin get(int id);


    public int update(Admin admin);


    public List<Admin> list();

    public List<Admin> list(SelectCondition selectCondition);


    public int total();

}