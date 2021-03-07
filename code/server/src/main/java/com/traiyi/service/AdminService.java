package com.traiyi.service;

import com.traiyi.pojo.Admin;
import com.traiyi.util.Page;

import java.util.List;

public interface AdminService {


    Admin login(String username);

    List<Admin> list();

    int total();

    List<Admin> list(Page page);

    void add(Admin c);

    void update(Admin c);

    void delete(Admin c);

    Admin get(int id);
}
