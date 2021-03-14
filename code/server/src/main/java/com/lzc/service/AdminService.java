package com.lzc.service;

import com.lzc.pojo.Admin;
import com.lzc.pojo.SelectCondition;

import java.util.List;

public interface AdminService {


    Admin login(String username);

    List<Admin> list();

    int total();

    List<Admin> list(SelectCondition selectCondition);

    void add(Admin c);

    void update(Admin c);

    void delete(Admin c);

    Admin get(int id);
}
