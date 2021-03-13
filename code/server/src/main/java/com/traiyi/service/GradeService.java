package com.traiyi.service;

import com.traiyi.pojo.Grade;
import com.traiyi.pojo.SelectCondition;
import com.traiyi.util.Page;

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
