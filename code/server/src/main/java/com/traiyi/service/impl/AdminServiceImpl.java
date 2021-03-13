package com.traiyi.service.impl;

import com.traiyi.mapper.AdminMapper;
import com.traiyi.pojo.Admin;
import com.traiyi.pojo.SelectCondition;
import com.traiyi.service.AdminService;
import com.traiyi.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;


    @Override
    public Admin login(String username) {

        System.out.println(username);
        System.out.println("sssss");
        System.out.println(adminMapper.login(username));
        return adminMapper.login(username);
    }


    public List<Admin> list() {
        return adminMapper.list();
    }


    @Override
    public List<Admin> list(SelectCondition selectCondition) {
        // TODO Auto-generated method stub
        return adminMapper.list(selectCondition);
    }


    @Override
    public int total() {
        return adminMapper.total();
    }


    @Override
    public void add(Admin c) {
        adminMapper.add(c);

    }


    @Override
    public void update(Admin c) {
        adminMapper.update(c);
    }


    @Override
    public void delete(Admin c) {
        adminMapper.delete(c.getId());
    }


    @Override
    public Admin get(int id) {
        // TODO Auto-generated method stub
        return adminMapper.get(id);
    }


}
