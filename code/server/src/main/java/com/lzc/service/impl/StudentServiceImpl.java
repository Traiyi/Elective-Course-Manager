package com.lzc.service.impl;

import com.lzc.mapper.StudentMapper;
import com.lzc.pojo.SelectCondition;
import com.lzc.pojo.Student;
import com.lzc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;


    public List<Student> list() {
        return studentMapper.list();
    }


    @Override
    public List<Student> list(SelectCondition selectCondition) {
        // TODO Auto-generated method stub
        return studentMapper.list(selectCondition);
    }


    @Override
    public int total() {
        return studentMapper.total();
    }


    @Override
    public int add(Student c) {
        return studentMapper.add(c);

    }


    @Override
    public int update(Student c) {
        return studentMapper.update(c);
    }


    @Override
    public int delete(int id) {
        return studentMapper.delete(id);
    }


    @Override
    public Student get(int id) {
        // TODO Auto-generated method stub
        return studentMapper.get(id);
    }

    public List<Student> listStudentAll() {

        return studentMapper.listStudentAll();
    }

}
