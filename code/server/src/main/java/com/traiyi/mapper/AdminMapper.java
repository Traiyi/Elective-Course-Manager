package com.traiyi.mapper;

import com.traiyi.pojo.Admin;
import com.traiyi.pojo.SelectCondition;
import com.traiyi.util.Page;

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