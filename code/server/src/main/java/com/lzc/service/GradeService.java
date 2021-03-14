package com.lzc.service;

import com.lzc.pojo.Grade;
import com.lzc.pojo.SelectCondition;

import java.util.List;

public interface GradeService {

    List<Grade> list();

    int total();

    List<Grade> list(SelectCondition selectCondition);

    int add(Grade c);

    int update(Grade c);

    int delete(int id);

    Grade get(int id);
}
